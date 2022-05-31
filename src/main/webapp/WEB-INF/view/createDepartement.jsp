<!--<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="windows-1256">
        <title>Créer un Departement</title>
    </head>

    <body>
        <form action="saveDepartement" method="post">
            <pre>
nom : <input type="text" name="nomDepartement">
prix : <input type="text" name="surfaceDepartement">
date création : <input type="date" name="date">
<input type="submit" value="ajouter">
</pre>
        </form>
        ${msg}
        <br />
        <br />
        <a href="ListeDepartements">Liste Produits</a>
    </body>

    </html>
-->



    
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html>
            <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
            <c:url value="/css/main.css" var="jstlCss" />
            <link href="${jstlCss}" rel="stylesheet" />
            <script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
                <title>Ajouter Departement</title>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="card-body">
                        <form action="saveDepartement" method="post">
                            <div class="form-group">
                                <label class="control-label">Nom Departement :</label>
                                <input type="text" name="nomDepartement" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label class="control-label">surface Departement :</label>
                                <input type="text" name="surfaceDepartement" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label class="control-label">date creation :</label>
                                <input type="date" name="date" class="form-control" />
                            </div>
                            <div>

                                <button type="submit" class="btn btn-primary">Ajouter</button>
                            </div>
                        </form>
                    </div>
                    ${msg}
                    <br />
                    <br />
                    <a href="ListeDepartements">Liste Departements</a>
                </div>
            </body>

            </html>