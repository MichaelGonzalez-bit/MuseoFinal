<%-- 
    Document   : AddFicha
    Created on : 15/05/2021, 11:44:30 PM
    Author     : Duvan Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <center>
        <div>
            <<h3>Agregar Administrador</h3>
            <form action="ControladorFicha" method="POST">
                <input type="submit" name="accion" value="Listar">
                <input type="submit" name="accion" value="Nuevo">
                //consulta controlador
                
            </form>
        </div>
        <div>
            <form action="ControladorFicha" method="POST">
                ID:
                <input type="text" name="txtid"> <br>
                NOMBRE:
                <input type="text" name="txtnombre"> <br>
                FILUM:
                <input type="text" name="txtfilum"> <br>
                TAMAÑO:
                <input type="text" name="txttamaño"> <br>
                PESO:
                <input type="text" name="txtpeso"> <br>
                PROCEDENCIA:
                <input type="text" name="txtprocedencia"> <br>
                FECHAINGRESO:
                <input type="text" name="txtfechaingreso"> <br>
                EDADEJEMPLAR:
                <input type="text" name="txtedadejemplar"> <br>
                AUTOR:
                <input type="text" name="txtautor"> <br>
                
                <input type="submit" name="accion" value="Guardar">
            </form>
        </div>
    </center>
    </body>
</html>
