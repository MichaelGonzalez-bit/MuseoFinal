<%-- 
    Document   : EditFicha
    Created on : 15/05/2021, 11:45:16 PM
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
            <<h3>Actualizar Ficha</h3>
            <form action="ControladorFicha" method="POST">
                <input type="submit" name="accion" value="Listar">
                <input type="submit" name="accion" value="Nuevo">
                //consulta controlador
                
            </form>
        </div>
        <div>
            <form action="ControladorFicha" method="POST">
                ID:
                <input type="text" name="txtid" value="${FichaFosil.getId_Ejemplar()}"> <br>
                NOMBRE:
                <input type="text" name="txtnombre" value="${FichaFosil.getId_Nombre()}"> <br>
                FILUM:
                <input type="text" name="txtfilum" value="${administrador.getFilum()}"> <br>
                TAMAÑO:
                <input type="text" name="txttamaño" value="${administrador.getTamaño()}"> <br>
                PESO:
                <input type="text" name="txtpeso" value="${administrador.getPeso()}"> <br>
                PROCEDENCIA:
                <input type="text" name="txtprocedencia" value="${administrador.getProcedencia()}"> <br>
                FECHAINGRESO:
                <input type="text" name="txtfechaingreso" value="${administrador.getFechaIngreso()}"> <br>
                EDADEJEMPLAR:
                <input type="text" name="txtedadejemplar" value="${administrador.getEdadEjemplar()}"> <br>
                AUTOR:
                <input type="text" name="txtautor" value="${administrador.getAutor()}"> <br>
                
                <input type="submit" name="accion" value="Actualizar">
            </form>
        </div>
    </center>
    </body>
</html>
