package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logica.Controladora;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Axel
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreUsuario = request.getParameter("username");
        String contrasenia = request.getParameter("pass");
        boolean usuarioOK = false;
        
        Controladora control = new Controladora();
        usuarioOK = control.comprobarIngreso(nombreUsuario,contrasenia);
        
        if(usuarioOK == true){
            //Crear sesión validada
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("nombreUsuario", nombreUsuario);
            sesion.setAttribute("contrasenia", contrasenia);
            
            response.sendRedirect("principal.jsp");
        }
        else{
            response.sendRedirect("login_error.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
