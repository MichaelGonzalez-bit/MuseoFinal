/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AdminDAO;
import modelo.Administrador;

/**
 *
 * @author 57320
 */
public class ControladorAdmin extends HttpServlet {
    AdminDAO dao=new AdminDAO();
    Administrador admin=new Administrador();
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
        String accion=request.getParameter("accion");
            switch (accion){
                case "Principal":
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
                    
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
                List<Administrador>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("Admin.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("addAdmin.jsp").forward(request, response);
                break;
            case "Guardar":
                String id=request.getParameter("txtid");
                String nombre=request.getParameter("txtnombre");
                String apellido=request.getParameter("txtapellido");
                String correo=request.getParameter("txtcorreo");
                String contraseña=request.getParameter("txtcontra");
                String clave=request.getParameter("txtclave");
                admin.setId(id);
                admin.setNombre(nombre);
                admin.setApellido(apellido);
                admin.setEmail(correo);
                admin.setContraseña(contraseña);
                admin.setClave(clave);
                dao.agregar(admin);
                request.getRequestDispatcher("ControladorAdmin?accion=Listar").forward(request, response);
                break;
            case "Editar":
                String idAdmin=request.getParameter("id");
                Administrador admine=dao.listarId(idAdmin);
                request.setAttribute("administrador", admine);
                request.getRequestDispatcher("editAdmin.jsp").forward(request, response);
                break;
            case "Actualizar":
                String acid=request.getParameter("txtid");
                String acNombre=request.getParameter("txtnombre");
                String acApellido=request.getParameter("txtapellido");
                String acCorreo=request.getParameter("txtcorreo");
                String acContra=request.getParameter("txtcontra");
                admin.setId(acid);
                admin.setNombre(acNombre);
                admin.setApellido(acApellido);
                admin.setEmail(acCorreo);
                admin.setContraseña(acContra);
                dao.actualizar(admin);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            case "Borrar":
                String id2=request.getParameter("id");
                dao.delete(id2);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
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
