<%-- 
    Document   : inscription
    Created on : 1 déc. 2018, 14:54:54
    Author     : dainahb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href=""/>
        <link rel="shortcut icon" href="">

        <title>LO54</title>

        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">

            <div class="col-lg-2">

                <a id="retour" name="Retour" class="btn btn-primary pull-left" href="<% out.print(request.getContextPath() + "/");%>" style="margin-top: 10px;">Retour</a>
            </div>
            <div class="row">
                <div class="col-lg-10 col-md-9" style="width: 100%; margin-bottom: 20px;">
                    <h3 style="text-align: center;">Inscription à une session du cours <% out.print(request.getParameter("cours")); %></h3>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-50">     
                    <div class="tableaudebord">


                        <div class='container'>


                            <form action="Inscription" method="POST" >

                                <div class='row'>
                                    <p>Inscription au cours : <input disabled name="cours" value="<% out.print(request.getParameter("cours"));%>" style="text-align:center">
                                    <p>Date de début de cette session : <input disabled name="datedebut" value="<% out.print(request.getParameter("datedebut")); %>" style="text-align:center">
                                        Date de fin de cette session : <input disabled name="datefin" value="<% out.print(request.getParameter("datefin")); %>" style="text-align:center"></p>
                                    <input hidden name="sessionid" value="<% out.print(request.getParameter("sessionid")); %>">
                                    <input hidden name="cours" value="<% out.print(request.getParameter("cours"));%>">
                                    <input hidden name="datedebut" value="<% out.print(request.getParameter("datedebut")); %>">
                                    <input hidden name="datefin" value="<% out.print(request.getParameter("datefin"));%>">
                                </div>
                                <div class='row'>
                                    <div class="form-group">
                                        <label for="nom">Nom :</label>
                                        <input type="text" class="form-control" name="firstname" id="firstname" required>
                                    </div>
                                    <div class="form-group" >
                                        <label for="prenom" >Prénom :</label>
                                        <input type="text" class="form-control" name="lastname" id="lastname" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="adresse">Adresse :</label>
                                        <input type="text" class="form-control" name="adress" id="adress" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email :</label>
                                        <input type="email" class="form-control" name="email" id="email" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="Téléphone">Téléphone :</label>
                                        <input type="text" class="form-control" name="phone" id="phone" required>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" id="singlebutton" onClick="Message()" name="action_inscrire_sess" class="btn btn-success" value="Enregistrer">
                                    </div>

                                </div>      
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script type="text/javascript">
    function Message() {
        var msg="Inscription à la session effectuée";
        alert(msg);
    }
 </script>

</html>						   
