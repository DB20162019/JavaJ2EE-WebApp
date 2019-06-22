/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.repository;

import fr.utbm.projetlo.entity.Location;
import fr.utbm.projetlo.util.HibernateUtil2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author dainahb
 */
public class LocationDAO implements Serializable{
    
    public ArrayList<Location> select() {
        Session session = HibernateUtil2.getSessionFactory().openSession();
        try 
        {
	    session.beginTransaction();
            Query requete = session.createQuery("from Location");
            List list = requete.list();
	    session.getTransaction().commit();
            return (ArrayList<Location>)list;
        }
        catch (HibernateException he)
        {
	    he.printStackTrace();
	    if(session.getTransaction() != null) 
            {
	        try 
                {
	            session.getTransaction().rollback();
	        }
                catch(HibernateException he2)
                {
                    he2.printStackTrace(); 
                }
	    }
        }
      
        return new ArrayList<Location>();
    }

}