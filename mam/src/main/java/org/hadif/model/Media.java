package org.hadif.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import java.util.Set;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Parameters;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import io.quarkus.panache.common.Page;

@Entity
@Table(name="Media")
@Cacheable
@NamedQuery(name = "media.findAll", query = "SELECT m FROM Media m", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
//@NamedQuery(name = "media.findByMetadata", query ="SELECT m FROM Media m JOIN Metadata md ON m.id = md.media.id WHERE md.name = :name AND md.value in :values", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@NamedQuery(name = "media.findByMetadata", query ="SELECT m FROM Media m JOIN Metadata md ON m.id = md.media.id WHERE md.name = :name AND md.value like :values", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
public class Media extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Integer id;

    // basic 
    public String name;
    public String title;
    /**
     * movie, series, documentary
     */
    public String type;
    public String description;   

    // Meta Data
    public Integer hour; 
    public Integer minute;
    public Integer productionYear;

    // Social
    public Integer rating=0;
    public Integer numberOfViews=0;

    // Media Delivery
    public String deliveryMethod;   // vod , streaming
    public Boolean availableOnTv;
    public Boolean availableOnWeb;
    public Boolean availableOnMobile;
    public String thumbnailWeb;
    public String thumbnailMobile;
    public String thumbnailTv;
    

    //@ManyToMany(cascade = { CascadeType.MERGE })
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            uniqueConstraints = {
            @UniqueConstraint(columnNames = { "media_id", "tag_id" })},
            name = "media_tag",
            joinColumns = {@JoinColumn(name = "media_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    public Set<Tag> tags = new HashSet<>();
     
    
    @OneToMany(mappedBy = "media", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<CdnSource> cdnSources = new HashSet<>();
    
    /**
     * placeholder for all extra metadata, for example
     * Directors, Actors, Producers, Writers, IMDB
     */
    @OneToMany(mappedBy = "media", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<Metadata> metadata = new HashSet<>();
    
    // Helper Methods

    public static Map<String,Object> listAll(int pageNumber,int pageSize) {   
        Map<String,Object> resultMap = new HashMap<>();
        Page page = Page.of(pageNumber-1,pageSize);
        PanacheQuery<Media> resutlsPanacheQuery = find("#media.findAll");
        resutlsPanacheQuery.page(page);
        resultMap.put("data", resutlsPanacheQuery.list());
        resultMap.put("pageNo",pageNumber);
        resultMap.put("pageSize",pageSize);
        resultMap.put("pageCount",resutlsPanacheQuery.pageCount());
        resultMap.put("count",resutlsPanacheQuery.count());
        return resultMap;
    }
                

    /**
     * find Media by Metadata
     * @param attributeName
     * @param attributeValues
     * @return
     */
    public static Map<String,Object> findByMetadata(String attributeName, String attributeValues,
                                             int pageNumber,int pageSize) { 
        Map<String,Object> resultMap = new HashMap<>();                                                       
        //List<String> values = Arrays.asList(attributeValues.split(","));
        String value = attributeValues + "%";
        Page page = Page.of(pageNumber-1,pageSize);
        PanacheQuery<Media> resutlsPanacheQuery = find("#media.findByMetadata",Parameters.with("name", attributeName).and("values", value) );
        resutlsPanacheQuery.page(page);
        resultMap.put("data", resutlsPanacheQuery.list());
        resultMap.put("pageNo",pageNumber);
        resultMap.put("pageSize",pageSize);
        resultMap.put("pageCount",resutlsPanacheQuery.pageCount());
        resultMap.put("count",resutlsPanacheQuery.count());
        return resultMap;
    }

    public void attachMetadata(Set<Metadata> metadataList){
        for (Metadata item : metadataList) {
            item.media = this;
            item.persist();
        }
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }
    
}
