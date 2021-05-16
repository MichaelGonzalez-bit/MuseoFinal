<%-- 
    Document   : Admin
    Created on : 14/05/2021, 05:00:27 PM
    Author     : 57320
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <<h3>Admin</h3> 
            <form action="ControladorAdmin" method="POST">
                <input type="submit" name="accion" value="Listar">
            </form>
        </div>
        <div>
            <table border="1">
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
                            <form action="ControladorAdmin" method="POST">
                                <input type="hidden" name="id" value="${dato.getId()}">
                                <input type="submit" name="accion" value="Editar">
                                <input type="submit" name="accion" value="Borrar">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </center>
        
    </body>
</html>
