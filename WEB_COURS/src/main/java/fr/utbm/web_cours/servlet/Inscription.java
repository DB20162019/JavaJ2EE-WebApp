/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.web_cours.servlet;

import fr.utbm.projetlo.util.EmailUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.utbm.projetlo.entity.Client;
import fr.utbm.projetlo.entity.CourseSession;
import fr.utbm.projetlo.service.ClientService;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author dainahb
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        

        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */

                if (request.getParameter("action_inscrire_sess").equals("Enregistrer")) {
                    String lastName = request.getParameter("lastname");
                    String firstName = request.getParameter("firstname");
                    String address = request.getParameter("adress");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String cours = request.getParameter("cours");
                    String datefin = request.getParameter("datefin");
                    String datedebut = request.getParameter("datedebut");
                    Integer sessionID = Integer.parseInt(request.getParameter("sessionid"));
                    
                    CourseSession css = new CourseSession(sessionID);
                    Client cli = new Client(lastName, firstName, address, phone, email, css);

                    ClientService cs = new ClientService();   
                    cs.register(cli);
                    
                    String Newligne=System.getProperty("line.separator"); //allow a line separator in the e-mail
                    
                    String object = "Confirmation d'inscription à une session de "+ cours;
                    
                    String body = firstName + " "+ lastName +"," + Newligne + Newligne + "Vous êtes inscrit(e) à la session du cours "+cours + " qui commence le " +datedebut +  " et qui se termine le " +datefin + ".";
                    
                    EmailUtil.sendEmail(email,object,body);
                    
                    response.sendRedirect(request.getContextPath().concat("/"));   
                }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
