package org.hadif.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;


/**
 * 
 */

@Entity
@Table(name="Featured")
@Cacheable
public class Featured extends PanacheEntityBase  {
    @Id
    @GeneratedValue
    public Integer id;    

    /**
     * Recentrly Added
     * Popular
     * Seasonal
     */
    public String type; 
    public String name;
    public String description;
    public Boolean active;
    public Date fromDate;
    public Date toDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            uniqueConstraints = {
            @UniqueConstraint(columnNames = { "feature_id", "media_id" })},
            name = "featured_media",
            joinColumns = {@JoinColumn(name = "feature_id")},
            inverseJoinColumns = {@JoinColumn(name = "media_id")})
    public Set<Media> mediaItems = new HashSet<>();
    
}
