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
@WebServlet(name = "ServletEditarJuego", urlPatterns = {"/ServletEditarJuego"})
public class ServletEditarJuego extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String hora_inicio = request.getParameter("hora_inicio");
        String hora_fin = request.getParameter("hora_fin");
        String id_horario = request.getParameter("id_horario");
        
        Controladora control = new Controladora();

        Horario horario = new Horario();
        horario.setId_horario(Integer.parseInt(id_horario));
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
        control.editarHorario(horario);
        
        Juego juego = new Juego();
        juego.setId_juego(Integer.parseInt(id));
        juego.setNombre(nombre);
        juego.setHorario(horario);
        //Backup de Listas existentes
        juego.setListaEmpleados(control.getJuego(id).getListaEmpleados());
        juego.setListaEntradas(control.getJuego(id).getListaEntradas());
        control.editarJuego(juego);
        
        response.sendRedirect("lista_juegos.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
