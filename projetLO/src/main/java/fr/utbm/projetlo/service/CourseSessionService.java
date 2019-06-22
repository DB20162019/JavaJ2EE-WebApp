/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.service;

import fr.utbm.projetlo.entity.CourseSession;
import fr.utbm.projetlo.repository.CourseSessionDAO;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author dainahb
 */
public class CourseSessionService implements Serializable{

    public ArrayList<CourseSession> liste() {
        CourseSessionDAO dao = new CourseSessionDAO();
        return dao.select();
    }
    
    public void register(CourseSession cs){
        CourseSessionDAO dao = new CourseSessionDAO();
        dao.insert(cs);
    }
}
