<%-- 
    Document   : editAdmin
    Created on : 14/05/2021, 09:14:43 PM
    Author     : 57320
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <center>
        <div>
            <<h3>Actualizar Administrador</h3>
            <form action="ControladorAdmin" method="POST">
                <input type="submit" name="accion" value="Listar">
                <input type="submit" name="accion" value="Nuevo">
                //consulta controlador
                
            </form>
        </div>
        <div>
            <form action="ControladorAdmin" method="POST">
                ID:
                <input type="text" name="txtid" value="${administrador.getId()}"> <br>
                NOMBRES:
                <input type="text" name="txtnombre" value="${administrador.getNombre()}"> <br>
                APELLIDOS:
                <input type="text" name="txtapellido" value="${administrador.getApellido()}"> <br>
                CORREO:
                <input type="email" name="txtcorreo" value="${administrador.getEmail()}"> <br>
                CONTRASEÑA:
                <input type="text" name="txtcontra" value="${administrador.getContraseña()}"> <br>
                <input type="submit" name="accion" value="Actualizar">
            </form>
        </div>
    </center>
    </body>
</html>
