/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iut.javaee.appshop.service.local.impl;

import fr.iut.javaee.appshop.commons.Collection;
import fr.iut.javaee.appshop.service.local.CollectionServiceLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Audrey
 */
@Stateless
public class CollectionService implements CollectionServiceLocal
{
    @PersistenceContext(unitName="AppShopCommonsPU")
    private EntityManager em;
    
    Logger logger = Logger.getLogger(DownloadService.class.getName());

    @Override
    public Collection findOneById(Integer id) 
    {
        return (Collection)em.createNamedQuery("Collection.findByCollectionId")
                              .setParameter("collectionId", id)
                              .getSingleResult();      
    }
    
    @Override
    public List<Collection> findCollectionsByMemberId(Integer id) 
    {
        return (List<Collection>)em.createNamedQuery("Collection.findByCollectionUsersId")
                              .setParameter("collectionUsersId", id)
                              .getResultList();
    }
    
    @Override
    public void persist(Collection c) 
    {
        try {
            em.persist(em.merge(c));
        }
        catch(Exception e) {
            logger.log(Level.SEVERE, "Unable to remove the given collection object");
        }
    }

    @Override
    public void remove(Collection c) 
    {
        try {
            em.remove(em.merge(c));
        }
        catch(Exception e) {
            logger.log(Level.SEVERE, "Unable to remove the given collection object");
        }
    } 
    
    @Override
    public void setEM(EntityManager em)
    {
        this.em = em;
    }
}
