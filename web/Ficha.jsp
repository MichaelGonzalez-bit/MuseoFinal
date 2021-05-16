<%-- 
    Document   : Ficha
    Created on : 15/05/2021, 11:52:44 PM
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
                        <th>NOMBRE</th>
                        <th>FILUM</th>
                        <th>TAMAÑO</th>
                        <th>PESO</th>
                        <th>PROCEDENCIA</th>
                        <th>FECHA INGRESO</th>
                        <th>EDAD EJEMPLAR</th>
                        <th>AUTOR</th>
                       
                        
                    </tr>
                </thead>  
                <tbody>
                    <c:forEach var="dato" items="${datos}">
                    <tr>
                        <td>${dato.getId()}</td>
                        <td>${dato.getNombre()}</td>
                        <td>${dato.getFilum()}</td>
                        <td>${dato.getTamaño()}</td>
                        
                        <td>${dato.getPeso()}</td>
                        <td>${dato.getProcedencia()}</td>
                        <td>${dato.getFechaIngreso()}</td>
                        <td>${dato.getEdadEjemplar()}</td>
                        <td>${dato.getAutor()}</td>
                        
                        
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
