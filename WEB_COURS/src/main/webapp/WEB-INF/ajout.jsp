<%-- 
    Document   : ajout
    Created on : 9 déc. 2018, 00:11:04
    Author     : dainahb
--%>

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

        <title>Ajout d'un cours</title>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <form action="Deconnexion" method="GET" >
                <div class="form-group">
                    <a style="color:white; padding: 3px 12px;" class="btn btn-primary" href="<% out.print(request.getContextPath() + "/AjoutCoursSession");%>">Ajout d'une session à un cours</a>
                    <input type="submit" id="singlebutton" class="btn btn-success pull-right" value="Deconnexion">

                </div>

            </form>
            <div class="row">
                <div class="col-lg-10 col-md-9" style="width: 100%; margin-bottom: 20px;">
                    <h3 style="text-align: center;">Création d'un nouveau cours</h3>
                </div>
            </div>

            <div class="row">
                <div class='container'>

                    <form action="Add" method="POST" >

                        <div class='row'>
                            <div class="form-group">
                                <label for="code">Code du cours :</label>
                                <input type="text" class="form-control" name="code" id="code" required>
                            </div>
                            <div class="form-group" >
                                <label for="title" >Titre du cours :</label>
                                <input type="text" class="form-control" name="title" id="title" required>
                            </div>
                            <div class="form-group">
                                <input type="submit" id="singlebutton" name="action_ajout_cours" class="btn btn-success" value="Enregistrer">
                            </div>
                        </div>      
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</html>						   
