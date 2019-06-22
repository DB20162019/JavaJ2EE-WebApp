<%-- 
    Document   : AjoutCoursSession
    Created on : 13 déc. 2018, 01:24:10
    Author     : dainahb
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.utbm.projetlo.entity.Course"%>
<%@page import="fr.utbm.projetlo.entity.Location"%>
<%@page import="fr.utbm.web_cours.servlet.AjoutCoursSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class='container'>
            <form action="Deconnexion" method="GET" >
                <div class="form-group">
                    <a style="color:white; padding: 3px 12px;" class="btn btn-primary" href="<% out.print(request.getContextPath() + "/Add");%>">Retour</a>
                    <input type="submit" id="singlebutton" class="btn btn-success pull-right" value="Deconnexion">
                </div>
            </form>
            <div class="row">
                <div class="col-lg-10 col-md-9" style="width: 100%; margin-bottom: 20px;">
                    <h3 style="text-align: center;">Ajout d'une session à un cours</h3>
                </div>
            </div>
            <div class="col-md-12">
                <form action="AjoutCoursSession"  method="POST">
                    <div class="form-group">
                        <select name="cours" class="custom-select" style="margin-bottom:30px; margin-top:40px; ">
                            <option value="" selected>Choisir un cours</option>
                            
                            <% List<Course> listcs = (ArrayList<Course>) request.getAttribute("listecours");
                                
                                for (Course cs : listcs) {    %>
                                
                            <option value="<% out.print(cs.getCode()); %>"><% out.print(cs.getCode()); %></option>
                            <%  } %>
                        </select>   
                        <select name="ville" class="custom-select" style="margin-bottom:30px; margin-top:40px; ">
                            <option value="" selected>Choisir une Ville</option>
                            
                            <% List<Location> list = (ArrayList<Location>) request.getAttribute("listeloc");
                                
                                for (Location loc : list) {    %>
                            <option value="<% out.print(loc.getId()); %>"><% out.print(loc.getCity()); %></option>
                            <%  }%>
                            
                        </select>  
                        <input type="date" id="singlebutton" name="dated" placeholder="Date de début de la session">
                        <input type="date" id="singlebutton" name="datef" placeholder="Date de fin de la session" >
                        <div class="form-group">
                            <label for="nombremax">Nombre maximum de participant à cette session :</label>
                            <input type="text" class="form-control" name="nombremax" id="nombremax" required>
                        </div>
                        <div class="form-group">
                            <input type="submit" id="singlebutton" name="action_ajout_session" class="btn btn-success" value="Enregistrer">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
