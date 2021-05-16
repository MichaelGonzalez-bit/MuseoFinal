package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Administrador;
import modelo.Visitante;
import modelo.VisitanteDAO;

/**
 *
 * @author 57320
 */
public class ControladorVisitante extends HttpServlet {
     VisitanteDAO dao=new VisitanteDAO();
     Visitante visitante=new Visitante();
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
                List<Visitante>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("Visitante.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("addVisitante.jsp").forward(request, response);
                break;
            case "Guardar":
                String id=request.getParameter("txtid");
                String nombre=request.getParameter("txtnombre");
                String apellido=request.getParameter("txtapellido");
                String correo=request.getParameter("txtcorreo");
                String contraseña=request.getParameter("txtcontra");
                visitante.setId(id);
                visitante.setNombre(nombre);
                visitante.setApellido(apellido);
                visitante.setEmail(correo);
                visitante.setContraseña(contraseña);
                dao.agregar(visitante);
                request.getRequestDispatcher("ControladorVisitante?accion=Listar").forward(request, response);
                break;
            case "Editar":
                String idVisitante=request.getParameter("id");
                Visitante visitante1=dao.listarId(idVisitante);
                request.setAttribute("administrador", visitante1);
                request.getRequestDispatcher("editVisitante.jsp").forward(request, response);
                break;
            case "Actualizar":
                String acid=request.getParameter("txtid");
                String acNombre=request.getParameter("txtnombre");
                String acApellido=request.getParameter("txtapellido");
                String acCorreo=request.getParameter("txtcorreo");
                String acContra=request.getParameter("txtcontra");
                visitante.setId(acid);
                visitante.setNombre(acNombre);
                visitante.setApellido(acApellido);
                visitante.setEmail(acCorreo);
                visitante.setContraseña(acContra);
                dao.actualizar(visitante);
                request.getRequestDispatcher("ControladorVisitante?accion=Listar").forward(request, response);
                break;
            case "Borrar":
                String id2=request.getParameter("id");
                dao.delete(id2);
                request.getRequestDispatcher("ControladorVisitante?accion=Listar").forward(request, response);
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
