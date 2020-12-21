package Servlets;

import Logica.Controladora;
import Logica.Entrada;
import Logica.Juego;
import Logica.Persona;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "ServletNuevoEntrada", urlPatterns = {"/ServletNuevoEntrada"})
public class ServletNuevoEntrada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fecha = request.getParameter("date");
        String hora = request.getParameter("time");
        String id_cliente = request.getParameter("id_client");
        String id_juego = request.getParameter("id_game");

        Controladora control = new Controladora();

        //Verifica que la fecha de venta no sea del pasado
        if (control.verificarFechaVenta(fecha)) {
            //Verificar horario dentro del intervalo
            Date hora_inicio = control.getJuego(id_juego).getHorario().getHorario_inicio();
            Date hora_fin = control.getJuego(id_juego).getHorario().getHorario_fin();
            if (control.verificarHoraVenta(hora_inicio, hora_fin, hora)) {
                Entrada entrada = new Entrada();
                entrada.setFecha(control.deStringToDate(fecha));
                try {
                    entrada.setHora(control.convertirHoraStringADate(hora));
                } catch (ParseException ex) {
                    Logger.getLogger(ServletNuevoEntrada.class.getName()).log(Level.SEVERE, null, ex);
                }
                control.crearEntrada(entrada);

                //Agregar entrada a la lista de la persona
                Persona persona = control.getPersona(id_cliente);
                List<Entrada> listaEntradas = persona.getListaEntradas();
                listaEntradas.add(entrada);
                persona.setListaEntradas(listaEntradas);
                control.editarPersona(persona);

                //Agregar entrada a la lista del juego
                Juego juego = control.getJuego(id_juego);
                List<Entrada> listaEntradas_j = juego.getListaEntradas();
                listaEntradas_j.add(entrada);
                juego.setListaEntradas(listaEntradas_j);
                control.editarJuego(juego);
                
                //Respuesta OK
                response.sendRedirect("lista_entradas.jsp");
            }
            else{
                response.sendRedirect("error_entradas_hora.jsp");
            }
        }
        else{
            response.sendRedirect("error_entradas_fecha.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
