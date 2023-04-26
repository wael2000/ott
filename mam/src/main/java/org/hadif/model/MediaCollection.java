package org.hadif.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.OneToMany;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import io.quarkus.panache.common.Page;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

@Entity
@Table(name="Collection")
@Cacheable
@NamedQuery(name = "mediaCollection.findAll", query = "FROM MediaCollection m left join fetch m.mediaItems", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
public class MediaCollection extends PanacheEntityBase {
  
    @Id
    @GeneratedValue
    public Integer id;

    public String name;
    public String type;   
    public String description;
    public Integer sesion;

    @OneToMany(mappedBy = "mediaCollection", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<MediaCollectionItem> mediaItems = new HashSet<>();
    
    public void attachMediaItems(Set<MediaCollectionItem> items){
        for (MediaCollectionItem item : items) {
            item.mediaCollection = this;
            item.persist();
        }
    }

    public static Map<String,Object> listAll(int pageNumber,int pageSize) {        
        Map<String,Object> resultMap = new HashMap<>();
        Page page = Page.of(pageNumber-1,pageSize);
        PanacheQuery<MediaCollection> resutlsPanacheQuery = find("#mediaCollection.findAll");
        resutlsPanacheQuery.page(page);
        resultMap.put("data", resutlsPanacheQuery.list());
        resultMap.put("pageNo",pageNumber);
        resultMap.put("pageSize",pageSize);
        resultMap.put("pageCount",resutlsPanacheQuery.pageCount());
        resultMap.put("count",resutlsPanacheQuery.count());
        return resultMap;
    }
}
