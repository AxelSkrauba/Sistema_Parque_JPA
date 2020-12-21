package Servlets;

import Logica.Controladora;
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
@WebServlet(name = "ServletEliminarJuego", urlPatterns = {"/ServletEliminarJuego"})
public class ServletEliminarJuego extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_juego = request.getParameter("id");
        Controladora control = new Controladora();
        
        control.eliminarJuego(id_juego);
        
        response.sendRedirect("lista_juegos.jsp");
    }

  
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
