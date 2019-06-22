/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.web_cours.servlet;

import fr.utbm.projetlo.entity.Course;
import fr.utbm.projetlo.entity.CourseSession;
import fr.utbm.projetlo.entity.Location;
import fr.utbm.projetlo.service.CourseService;
import fr.utbm.projetlo.service.CourseSessionService;
import fr.utbm.projetlo.service.LocationService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dainahb
 */
@WebServlet("/AjoutCoursSession")
public class AjoutCoursSession extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        /*Get list of all city*/
        LocationService loc = new LocationService();
        ArrayList<Location> listeloc = loc.liste();
        request.setAttribute("listeloc", listeloc); 

        /*Get list of all Course*/
        CourseService cser = new CourseService();
        ArrayList<Course> listecours = cser.liste();
        request.setAttribute("listecours", listecours);

        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("WEB-INF/ajoutcourssession.jsp").forward(request, response);
            if (request.getParameter("action_ajout_session").equals("Enregistrer")) {
                String code = request.getParameter("cours");
                Integer idville = Integer.parseInt(request.getParameter("ville"));
                String dated = request.getParameter("dated");
                String datef = request.getParameter("datef");
                Integer nombremax = Integer.parseInt(request.getParameter("nombremax"));
                Course css = new Course(code);

                Location l = new Location(idville);
                SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-M-dd");
                Date newdate = dateformat2.parse(dated);
                SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy-M-dd");

                Date newdate2 = dateformat3.parse(datef);

                CourseSession c = new CourseSession(newdate, newdate2, nombremax, css, l);

                CourseSessionService cs = new CourseSessionService();
                cs.register(c);
                

            }
            /* TODO output your page here. You may use following sample code. */

        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AjoutCoursSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AjoutCoursSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
