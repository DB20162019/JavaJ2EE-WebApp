<%-- 
    Document   : Connexion
    Created on : 8 déc. 2018, 08:55:56
    Author     : dainahb
--%>
<%@page import="fr.utbm.web_cours.servlet.Connexionf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
    </head>
    <body>
        <form method="post" action="Connexionf">
            
            <%if (session.getAttribute("authentificationechoue") == null) { %>
            <div class="badpassword">Veuillez saisir votre Identifiant et Mot de passe :</div>
            <%} else { %>
            <div class="badpassword">Identifiant & Mot de passe incorrecte</div>
            <%}%>
            <br/>
            <tr>
                <td><label>Identifiant : *</label></td>
                <td><input type="text" name="email" maxlength="40"/></td>
            </tr>


            <tr>
                <td><label>Mot de passe : *</label></td>
                <td><input type="password" name="mdp" maxlength="30" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Se connecter"/></td>
            </tr>
        </table>	
    </form>
</body>
</html>
