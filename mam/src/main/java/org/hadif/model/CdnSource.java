package org.hadif.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.ManyToOne;

/**
 *
 */

@Entity
@Table(name="CDN_source")
@Cacheable
public class CdnSource extends PanacheEntityBase  {
    @Id
    //@SequenceGenerator(name = "cdnSequence", sequenceName = "cdn_id_seq", allocationSize = 1, initialValue = 10)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cdnSequence")
    @GeneratedValue
    public Integer id;

    public String type;   
    public String resolution;
    public String src;

    @ManyToOne
    public Media media;
    
}
