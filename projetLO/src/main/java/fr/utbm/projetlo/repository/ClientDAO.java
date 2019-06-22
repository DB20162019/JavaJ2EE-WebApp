/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.repository;

import fr.utbm.projetlo.entity.Client;
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
public class ClientDAO implements Serializable{
    public void insert(Client client) {
        Session session = HibernateUtil2.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(client);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he) {
                    he.printStackTrace();
                }
            }
        }
    }
    
    public ArrayList<Client> select(Integer idSession) {
         Session session = HibernateUtil2.getSessionFactory().openSession();
        try 
        {
	    session.beginTransaction();
            Query requete = session.createQuery("from Client where COURSE_SESSION_ID = ? ");
            requete.setParameter(0, idSession);
            List list = requete.list();
            
	    session.getTransaction().commit();
            return (ArrayList<Client>)list;
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
        
        return new ArrayList<Client>();
    }
}
