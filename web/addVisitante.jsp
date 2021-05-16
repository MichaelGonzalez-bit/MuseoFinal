<%-- 
    Document   : addVisitante
    Created on : 16/05/2021, 12:37:03 AM
    Author     : 57320
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitante</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <center>
        <div>
            <h3>Inicio de sesión Visitante</h3>
            <form action="ControladorVisitante" method="POST">
                <input type="submit" name="accion" value="Listar">
                <input type="submit" name="accion" value="Nuevo">
                //consulta controlador
                
            </form>
        </div>
        <div>
            <form action="ControladorVisitante" method="POST">
                ID:
                <input type="text" name="txtid"> <br>
                NOMBRES:
                <input type="text" name="txtnombre"> <br>
                APELLIDOS:
                <input type="text" name="txtapellido"> <br>
                CORREO:
                <input type="email" name="txtcorreo"> <br>
                CONTRASEÑA:
                <input type="text" name="txtcontra"> <br>
                <input type="submit" name="accion" value="Guardar">
            </form>
        </div>
    </center>
        
    </body>
</html>
