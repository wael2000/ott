package org.hadif.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.json.bind.annotation.JsonbTransient;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Media_Asset")
@Cacheable
public class MediaAsset extends BaseModel{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    // in case it is series
    public Integer episodeNumber;
    public String episodeTitle;
    // Metadata
    public Integer hour;
    public Integer minute; 
     
    @OneToMany(mappedBy = "mediaAsset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<CdnSource> cdnSources = new HashSet<>();

    @JsonbTransient
    @ManyToOne
    public Media media;

        
}
