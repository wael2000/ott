package org.hadif.service;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import java.util.List;
import java.util.Map;
import org.hadif.model.Media;


@ApplicationScoped
public class MediaService {
    @Inject
    EntityManager em; 

    @Transactional 
    public Media createMedia(Media media) {
        media.persist();
        media.attachMetadata(media.metadata);
        return media;
    }

    public Map<String,Object> listAll(int pageNumber,int pageSize){
        return Media.listAll(pageNumber,pageSize);
    }

    
    public Media findById(Integer id){
        return Media.findById(id);
    }

    @Transactional
    public Media updateMedia(Integer id, Media updatedMedia){
        Media media = Media.findById(id);
        if(media!=null){
            em.merge(updatedMedia);
            media.persist();
        }
        return media;
    }

    @Transactional
    public Media deleteMedia(Integer id){
        Media media = em.getReference(Media.class, id);
        if(media!=null){
            media.delete();
        }
        return media;
    }

    // Search methods 
    /**
     * Find by metadata (using and perator)
     * @param names : comma seperated 
     * @param values : comma seperated 
     * @return
     */
    public Map<String,Object> findByMetadata(String name,String values,int pageNumber,int pageSize){
        return Media.findByMetadata(name, values,pageNumber, pageSize);
    }

}