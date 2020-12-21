package Servlets;

import Logica.Controladora;
import Logica.Persona;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Axel
 */
@WebServlet(name = "ServletNuevoPersona", urlPatterns = {"/ServletNuevoPersona"})
public class ServletNuevoPersona extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("name");
        String apellido = request.getParameter("lastname");
        
        Controladora control = new Controladora();
        
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        
        control.crearPersona(persona);
        
        response.sendRedirect("lista_personas.jsp");
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
