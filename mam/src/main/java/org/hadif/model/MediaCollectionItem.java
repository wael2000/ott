package org.hadif.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.json.bind.annotation.JsonbTransient;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.FetchType;

@Entity
@Table(name="Collection_Item")
@Cacheable
@NamedQuery(name = "items.findAll", query = "FROM MediaCollectionItem m inner join fetch m.mediaCollection", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
public class MediaCollectionItem extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Integer id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonbTransient 
    public MediaCollection mediaCollection;
    
    @ManyToOne 
    public Media media;

    public Integer episode;
    
}
