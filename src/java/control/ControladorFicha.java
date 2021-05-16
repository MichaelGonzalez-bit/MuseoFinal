/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.FichaDAO;
import modelo.FichaEjemplar;

/**
 *
 * @author Duvan Felipe
 */
public class ControladorFicha extends HttpServlet {
    
    FichaDAO dao=new FichaDAO();
    FichaEjemplar ficha=new FichaEjemplar();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorFicha</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorFicha at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion=request.getParameter("accion");
        switch(accion){
            case "Listar":
                List<FichaEjemplar>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("Ficha.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("AddFicha.jsp").forward(request, response);
                break;
            case "Guardar":
                int id=Integer.parseInt(request.getParameter("txtid"));
                String nombre=request.getParameter("txtnombre");
                String filum=request.getParameter("txtfilum");
                String tamaño=request.getParameter("txttamaño");
                double peso=Double.parseDouble(request.getParameter("txtpeso"));
                String procedencia=request.getParameter("txtprocedencia");
                
                String[] date= request.getParameter("txtfecha").split("/");
                int day=Integer.parseInt(date[0]);
                int mes=Integer.parseInt(date[1])-1;
                int año=Integer.parseInt(date[2]);
                DateFormat format=new SimpleDateFormat("DD/MM/YYYY");
                Date fecha;
            try {
                fecha = format.parse(day+"/"+mes+"/"+año);
            
                int edadEjemplar=Integer.parseInt(request.getParameter("txtedadejemplar"));
                String autor=request.getParameter("txtautor");
                
                
                FichaEjemplar aux=new FichaEjemplar(id, nombre, filum, tamaño, peso, procedencia, fecha, edadEjemplar, autor);
                
                
                dao.agregar(aux);
                
                } catch (ParseException ex) {
                Logger.getLogger(ControladorFicha.class.getName()).log(Level.SEVERE, null, ex);
            }
                request.getRequestDispatcher("ControladorFicha?accion=Listar").forward(request, response);
                break;
            case "Editar":
                String idFicha=request.getParameter("id");
                FichaEjemplar aux=(FichaEjemplar) dao.listarID(String.valueOf(idFicha));
                request.setAttribute("fichaEjemplar", aux);
                request.getRequestDispatcher("EditFicha.jsp").forward(request, response);
                break;
            case "Actualizar":
                
                
            
                int idF=Integer.parseInt(request.getParameter("txtid"));
                String nombreF=request.getParameter("txtnombre");
                String filumF=request.getParameter("txtfilum");
                String tamañoF=request.getParameter("txttamaño");
                double pesoF=Double.parseDouble(request.getParameter("txtpeso"));
                String procedenciaF=request.getParameter("txtprocedencia");
                
                String[] dateF= request.getParameter("txtfecha").split("/");
                int dayF=Integer.parseInt(dateF[0]);
                int mesF=Integer.parseInt(dateF[1])-1;
                int añoF=Integer.parseInt(dateF[2]);
                DateFormat formatF=new SimpleDateFormat("DD/MM/YYYY");
            
                Date fechaF;
            try {
                fechaF = formatF.parse(dayF+"/"+mesF+"/"+añoF);
            
            
                int edadEjemplarF=Integer.parseInt(request.getParameter("txtedadejemplar"));
                String autorF=request.getParameter("txtautor");
                
                
                
                FichaEjemplar fichaAux = new FichaEjemplar(idF, nombreF, filumF, tamañoF, pesoF, procedenciaF, fechaF, edadEjemplarF, autorF);
                
                
                
                dao.actualizar(fichaAux);
                
                } catch (ParseException ex) {
                Logger.getLogger(ControladorFicha.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            case "Borrar":
                
                String id2=request.getParameter("id");
                dao.delete(id2);
                request.getRequestDispatcher("ControladorFicha?accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
        
        
        
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
