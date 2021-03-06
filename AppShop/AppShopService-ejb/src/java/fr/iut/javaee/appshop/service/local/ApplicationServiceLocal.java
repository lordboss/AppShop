/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.iut.javaee.appshop.service.local;

import fr.iut.javaee.appshop.commons.Application;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Alexis
 */
@Local
public interface ApplicationServiceLocal 
{
    public List<Application> findAll();
    
    public List<Application> findApplicationList();
    
    public Application findOneById(Integer id);
    
    public List<Application> findApplicationsByName(String name);
    
    public List<Application> findApplicationsByPlatformId(int id);
    
    public List<Application> findApplicationsByPlatformName(String name);
    
    public List<Application> findApplicationsByVersion(String version);
    
    public List<Application> findApplicationsByEditorId(int id); 
    
    public List<Application> findApplicationsByEditorName(String name);
    
    public void persist(Application a);
    
    public void remove(Application a);
    
    public void notifyUpdate(Application a);

    public List<Application> findLastFiveApplicationsAdded();
    
    public void setEM(EntityManager em);
}
