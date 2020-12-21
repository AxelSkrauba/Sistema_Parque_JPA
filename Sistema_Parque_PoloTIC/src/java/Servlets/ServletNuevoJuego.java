package Servlets;

import Logica.Controladora;
import Logica.Horario;
import Logica.Juego;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Axel
 */
@WebServlet(name = "ServletNuevoJuego", urlPatterns = {"/ServletNuevoJuego"})
public class ServletNuevoJuego extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String hora_inicio = request.getParameter("hora_inicio");
        String hora_fin = request.getParameter("hora_fin");

        
        Controladora control = new Controladora();
        
        //No existe control de intervalo de horario, porque se considera que el
        //parque trabaja de corrido. Ej: de 23 a 5 significa un horario nocturno/madrugada
        //Mientras que de 5 a 23 significaría un horaraio tarde/noche
        Horario horario = new Horario();
        try {
            horario.setHorario_inicio(control.convertirHoraStringADate(hora_inicio));
        } catch (ParseException ex) {
            Logger.getLogger(ServletNuevoJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            horario.setHorario_fin(control.convertirHoraStringADate(hora_fin));
        } catch (ParseException ex) {
            Logger.getLogger(ServletNuevoJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Juego juego = new Juego();
        juego.setNombre(nombre);
        juego.setHorario(horario);
        control.crearJuego(juego);
        
        response.sendRedirect("lista_juegos.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
