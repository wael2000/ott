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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
@NamedQuery(name = "media.findByUser", query = "SELECT m FROM Media m where m.createdBy = :user", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@NamedQuery(name = "media.findByMetadata", query ="SELECT m FROM Media m JOIN Metadata md ON m.id = md.media.id WHERE UPPER(md.name) = UPPER(:name) AND UPPER(md.value) like UPPER(:values)", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@NamedQuery(name = "media.search", query ="SELECT distinct m FROM Media m LEFT JOIN Metadata md ON m.id = md.media.id WHERE UPPER(md.value) like UPPER(:values) or UPPER(m.name) like UPPER(:values)", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))

// TBD 
//@NamedQuery(name = "media.findByMetadata", query ="SELECT m FROM Media m JOIN Metadata md ON m.id = md.media.id WHERE md.name = :name AND md.value in :values", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))

public class Media extends BaseModel  {

    @Id
    @GeneratedValue
    public Integer id;

    // basic 
    public String name;
    public String title;
    
    public String type;             // movie, series, documentary
    public String description;   
    public String longDescription;
    public String ageRating;        // kids, adults

    public Integer releaseYear;

    // Media Delivery
    public String deliveryMethod;   // vod , streaming
    public Boolean availableOnTv;
    public Boolean availableOnWeb;
    public Boolean availableOnMobile;
    public String thumbnailWeb;
    public String thumbnailMobile;
    public String thumbnailTv;

    // Social & stats
    public Integer rating=0;
    public Integer numberOfViews=0;
    
    // Poster Fields
    public String posterHorizontal;
    public String posterVertical;
    public String heroArt;
    public String banner;

    //@ManyToMany(cascade = { CascadeType.MERGE })
    /**
     * used to for Media Genere
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            uniqueConstraints = {
            @UniqueConstraint(columnNames = { "media_id", "tag_id" })},
            name = "media_tag",
            joinColumns = {@JoinColumn(name = "media_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    public Set<Tag> tags = new HashSet<>();
     
    /**
     * placeholder for all extra metadata, for example
     * Directors, Actors, Producers, Writers, IMDB
     */
    @OneToMany(mappedBy = "media", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<Metadata> metadata = new HashSet<>();
    
    /**
     * link to all media assets to mainly store the media asset info like length, episode No
     * in case of series it is one-to-many
     * in case of movie it is one-to-one
     */
    @OneToMany(mappedBy = "media", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<MediaAsset> mediaAssets = new HashSet<>();    

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
     * find media by user
     * @param pageNumber
     * @param pageSize
     * @param user
     * @return
     */
    public static Map<String,Object> findByUser(String user, int pageNumber,int pageSize) {   
        Map<String,Object> resultMap = new HashMap<>();
        Page page = Page.of(pageNumber-1,pageSize);
        PanacheQuery<Media> resutlsPanacheQuery = find("#media.findByUser", Parameters.with("user", user));
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
        //PanacheQuery<Media> resutlsPanacheQuery = find("#media.findByMetadata",Parameters.with("name", attributeName).and("values", "%"+value+"%") );
        PanacheQuery<Media> resutlsPanacheQuery = find("#media.search",Parameters.with("values", "%"+value+"%") );
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

    public void attachMediaAssets(Set<MediaAsset> mediaAssets){
        for (MediaAsset item : mediaAssets) {
            item.media = this;
            item.persist();
        }
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }
    
}
