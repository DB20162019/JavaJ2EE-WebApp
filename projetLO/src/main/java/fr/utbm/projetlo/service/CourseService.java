/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.service;
import fr.utbm.projetlo.entity.Course;
import fr.utbm.projetlo.repository.CourseDAO;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author dainahb
 */

public class CourseService implements Serializable{
    private Course course = new Course();
    
    public Course getClient() {
        return course;
    }

    public void setClient(Course course) {
        this.course = course;
    }

    public ArrayList<Course> liste() {
        CourseDAO dao = new CourseDAO();
        return dao.select();
    }
    
    public void register(Course cs){
        CourseDAO dao = new CourseDAO();
        dao.insert(cs);
    }
}
