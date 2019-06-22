/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.repository;
import fr.utbm.projetlo.util.HibernateUtil2;
import fr.utbm.projetlo.entity.Course;
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
public class CourseDAO implements Serializable{
    public void insert(Course course) {
        Session session = HibernateUtil2.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(course);
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
    
    public ArrayList<Course> select() {
        Session session = HibernateUtil2.getSessionFactory().openSession();
        try 
        {
	    session.beginTransaction();
            Query requete = session.createQuery("from Course");
            List list = requete.list();
            
	    session.getTransaction().commit();
            return (ArrayList<Course>)list;
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
        return new ArrayList<Course>();
    }
}
