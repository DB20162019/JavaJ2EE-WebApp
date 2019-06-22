/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.web_cours.servlet;

import fr.utbm.projetlo.entity.Client;
import fr.utbm.projetlo.entity.CourseSession;
import fr.utbm.projetlo.entity.Location;
import fr.utbm.projetlo.service.ClientService;
import fr.utbm.projetlo.service.CourseSessionService;
import fr.utbm.projetlo.service.LocationService;
import fr.utbm.projetlo.util.HibernateUtil2;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author dainahb
 */
@WebServlet( "/" )
public class Liste extends HttpServlet {

    public Liste() {
    }

    public float calculerPourcentage(Integer nbInscrit, Integer max) {
        /*Method to calculate % of inscription*/
        float nb = nbInscrit;
        float m = max;
        return ((nb / m) * 100);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Liste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Liste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        /*Creation of the query to filter date/title/city : the three filters work separate or together : 
        the user can filter by date and title or simple date...*/
        String date = request.getParameter("date");
        String titre = request.getParameter("titre");
        String ville = request.getParameter("ville");

        ArrayList<CourseSession> liste = null;
        if (date == null && titre == null && ville == null) {
            CourseSessionService css = new CourseSessionService();
            liste = css.liste();
        } else {
            String requete = "from CourseSession v ";
            
            boolean where = false;

            if (!"".equals(date)) {
                requete += " WHERE v.startDate >=:date";
                where = true;
            }
            if (!"".equals(titre)) {
                if (where) {
                    requete += " AND v.courseCode.title like :titre";
                    //requete += " OR v.courseCode.code like :titre";
                } else {
                    requete += " WHERE v.courseCode.title like :titre";
                    //requete += " OR v.courseCode.code like :titre";
                    where = true;
                }
            }
            if (!"".equals(ville)) {
                if (where) {
                    requete += " AND v.locationID.city =:ville ";
                } else {
                    requete += " WHERE v.locationID.city =:ville ";
                }
            }
            Session sessionH = HibernateUtil2.getSessionFactory().openSession();
            Query req = sessionH.createQuery(requete);

            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            if (date != "") {
                req.setParameter("date", formater.parse(date));
            }
            if (ville != "") {
                req.setParameter("ville", ville);
            }
            if (titre != "") {
                req.setParameter("titre", "%" + titre + "%");
            }

            liste = (ArrayList<CourseSession>) req.list();
        }
        request.setAttribute("liste", liste);

        request.getRequestDispatcher("WEB-INF/liste.jsp").forward(request, response);
    }

    public ArrayList<Location> listeLieu() {
        /*Get list of cities*/
        LocationService loc = new LocationService();
        ArrayList<Location> listeloc = loc.liste();
        return listeloc;

    }

    public ArrayList<Client> ListeClient(Integer idSession) {
        /*Get list of client registered in a session */
        ClientService cli = new ClientService();
        ArrayList<Client> listecli = cli.liste(idSession);
        return listecli;
    }
}
