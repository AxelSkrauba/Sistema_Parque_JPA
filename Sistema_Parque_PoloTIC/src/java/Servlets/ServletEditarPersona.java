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
@WebServlet(name = "ServletEditarPersona", urlPatterns = {"/ServletEditarPersona"})
public class ServletEditarPersona extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("name");
        String apellido = request.getParameter("lastname");
        
        Controladora control = new Controladora();
        Persona persona = new Persona();
        persona.setId_persona(Integer.parseInt(id));
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        control.editarPersona(persona);
        
        response.sendRedirect("lista_personas.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
