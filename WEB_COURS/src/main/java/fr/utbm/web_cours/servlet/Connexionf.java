/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.web_cours.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexionf")
public class Connexionf extends HttpServlet {
    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/WEB-INF/Connexion.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession mySession = request.getSession();

            String email = request.getParameter( "email" );
            String mdp = request.getParameter( "mdp" );
            /* connexion test if the mail and mdp correspond to the admin user ( mail : inscription.courslo54@gmail.com...)*/
            if (("inscription.courslo54@gmail.com".equals(email)) && ("admincourslo".equals(mdp))){
                    mySession.setAttribute("authenticated", true);
                    mySession.setAttribute("utilisateur", true);
                    mySession.setAttribute("authentificationechoue", false);
                    response.sendRedirect(response.encodeRedirectURL("Add"));
                    mySession.setAttribute( ATT_SESSION_USER, true );
                    
            }
            else {
                    mySession.setAttribute("authentificationechoue", true);
                    response.sendRedirect(response.encodeRedirectURL("Connexionf"));
                    mySession.setAttribute( ATT_SESSION_USER, null );
            }
    }

}
