<%-- 
    Document   : Visitante
    Created on : 16/05/2021, 12:36:02 AM
    Author     : 57320
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Visitante</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <center>
        <div>
            <<h3>Visitante</h3> 
            <form action="ControladorVisitante" method="POST">
                <input type="submit" name="accion" value="Listar">
            </form>
        </div>
        <div>
            
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRES</th>
                        <th>APELLIDOS</th>
                        <th>CORREO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>  
                <tbody>
                    <c:forEach var="dato" items="${datos}">
                    <tr>
                        <td>${dato.getId()}</td>
                        <td>${dato.getNombre()}</td>
                        <td>${dato.getApellido()}</td>
                        <td>${dato.getEmail()}</td>
                        
                        <td>
                            <form action="ControladorVisitante" method="POST">
                                <input type="hidden" name="id" value="${dato.getId()}">
                                <input type="submit" name="accion" value="Editar">
                                <input type="submit" name="accion" value="Borrar">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            
        </div>
    </center>
    </body>
</html>
