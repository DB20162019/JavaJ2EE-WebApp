/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.service;
import fr.utbm.projetlo.entity.Location;
import fr.utbm.projetlo.repository.LocationDAO;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author dainahb
 */
public class LocationService implements Serializable{

    public ArrayList<Location> liste() {
        LocationDAO dao = new LocationDAO();
        return dao.select();
    }
}
