package org.hadif.service;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Map;
import org.hadif.model.MediaCollection;
import org.hadif.model.MediaCollectionItem;


@ApplicationScoped
public class MediaCollectionService {
    @Inject
    EntityManager em; 

    
    @Transactional 
    public MediaCollection createMediaCollection(MediaCollection mediaCollection) {
        mediaCollection.persist();
        mediaCollection.attachMediaItems(mediaCollection.mediaItems);
        return mediaCollection;
    }

    public Map<String,Object>listAll(int pageNumber,int pageSize){
        return MediaCollection.listAll(pageNumber,pageSize);
    }

    public MediaCollectionItem[] getAllItems(){
        return em.createNamedQuery("items.findAll", MediaCollectionItem.class)
                .getResultList().toArray(new MediaCollectionItem[0]);
    }

    
    public MediaCollection findById(Integer id){
        MediaCollection collection = MediaCollection.findById(id);
        /*
        MediaCollection collection = cache.get(id);
        if(collection==null) {
            System.out.println("Caching for the first time");
            collection = MediaCollection.findById(id);
            cache.put(id, collection);
        } */
        return collection;
    }

    @Transactional
    public MediaCollection updateMediaCollection(Integer id, MediaCollection updatedMediaCollection){
        MediaCollection mediaCollection = MediaCollection.findById(id);
        if(mediaCollection!=null){
            mediaCollection = em.merge(updatedMediaCollection);
            mediaCollection.persist();
            //em.persist(mediaCollection);
            mediaCollection.attachMediaItems(mediaCollection.mediaItems);
        }
        return mediaCollection;
    }

    @Transactional
    public MediaCollection deleteMediaCollection(Integer id){
        MediaCollection mediaCollection = em.getReference(MediaCollection.class, id);
        if(mediaCollection!=null){
            mediaCollection.delete();
        }
        return mediaCollection;
    }

}