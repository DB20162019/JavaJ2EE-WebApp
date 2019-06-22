<%-- 
    Document   : liste
    Created on : 4 déc. 2018, 05:06:42
    Author     : dainahb
--%>

<%@page import="fr.utbm.projetlo.entity.Client"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fr.utbm.projetlo.entity.CourseSession"%>
<%@page import="fr.utbm.web_cours.servlet.Liste" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.utbm.projetlo.entity.Location"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="An interactive getting started guide for Brackets.">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <%   Liste filterliste = new Liste(); %>
    </head>
    <body>
        <div class="row">
            <h2 style="text-align: center;margin-top:25px;">Liste des cours et des sessions</h2>

        </div>
        <div class="container">
            <div class="col-md-12">
                <form action="Liste"  method="POST">
                    <div class="form-group">
                        <select name="ville" class="custom-select" style="margin-bottom:30px; margin-top:40px; ">
                            <option value="" selected>Choisir Ville</option>
                            <% for (Location loc : filterliste.listeLieu()) {    %>
                            <option value="<% out.print(loc.getCity()); %>"><% out.print(loc.getCity()); %></option>
                            <%  } %>
                        </select>  
                        <input type="date" id="singlebutton" name="date" placeholder="Date de la session">
                        <input type="input" id="singlebutton" name="titre" placeholder="Recherche d'un cours" >
                        <input type="submit" id="singlebutton" name="Rechercher" class="btn btn-primary" value="Rechercher">
                    </div>
                </form>
            </div>

            <table id="liste" class="display" style="width:100%;border-spacing: 4px; border-collapse: inherit;">
                <thead>
                    <tr style="background-color: lightgray;">
                        <th style="text-align:center;">Code du cours</th>
                        <th style="text-align:center;">Nom du cours</th>
                        <th style="text-align:center;">Date de début</th>
                        <th style="text-align:center;">Date de fin</th>
                        <th style="text-align:center;">Lieu du cours</th>
                        <th style="text-align:center;">Pourcentage d'inscrit</th>
                        <th style="text-align:center;">S'inscrire à cette session</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<CourseSession> list = null;
                        list = (ArrayList<CourseSession>) request.getAttribute("liste");
                    %>
                    <% for (CourseSession cs : list) {
                        
                            List<Client> listeInscrit = filterliste.ListeClient(cs.getId());
                            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
                    %>

                    <tr style="text-align: center;background-color:#80808012">

                        <td><% out.print(cs.getCourseCode().getCode()); %></td>
                        <td><% out.print(cs.getCourseCode().getTitle()); %></td>
                        <td><% out.print(formater.format(cs.getStartDate()));%></td>
                        <td><% out.print(formater.format(cs.getEndDate())); %></td>
                        <td><% out.print(cs.getLocationID().getCity()); %></td>
                        <td><% out.print(filterliste.calculerPourcentage(listeInscrit.size(), cs.getMax()));%> %</td>

                        <td>
                            <%if (filterliste.calculerPourcentage(listeInscrit.size(), cs.getMax()) >= 100) {%>

                            <p style="color:white; background-color:#777; cursor:default" class="btn">Complet</p><%  } else { %>

                            <a style="color:white; background-color:rgb(218, 28, 28);" href="inscription.jsp?cours=<% out.print(cs.getCourseCode().getTitle()); %>&sessionid=<% out.print(cs.getId()); %>&datedebut=<% out.print(cs.getStartDate()); %>&datefin=<% out.print(cs.getStartDate());%>" 
                               class="btn">S'inscrire</a>

                            <% } %>

                        </td>
                    </tr> 
                    <% } %>
                </tbody>
            </table>
            <a style="color:white;margin-top:20px; padding: 3px 12px;" class="btn btn-success" href="<% out.print(request.getContextPath() + "/Connexionf");%>">Admin</a>
        </div>

    </body>
</html>
