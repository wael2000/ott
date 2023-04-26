package org.hadif.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.json.bind.annotation.JsonbTransient;


/**
 * Media Tag:
 *   id: Unique identifier for the media item
 *   name: Name of the tag
 *   description: Description of the tag
 */

@Entity
@Table(name="Tag")
@Cacheable
public class Tag extends PanacheEntityBase  {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    @JsonbTransient 
    public String description;
    
}
