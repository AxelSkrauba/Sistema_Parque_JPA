package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Juego;
import Logica.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Axel
 */
@WebServlet(name = "ServletNuevoEmpleado", urlPatterns = {"/ServletNuevoEmpleado"})
public class ServletNuevoEmpleado extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("name");
        String apellido = request.getParameter("lastname");
        String dni = request.getParameter("dni");
        String cargo = request.getParameter("cargo");
        String usuarioNombre = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        String game = request.getParameter("game");
        
        
        Controladora control = new Controladora();
        
        //Se crea el usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioNombre);
        usuario.setContrasenia(contrasenia);

        //Se crea el empleado
        Empleado empleado = new Empleado();
        empleado.setApellido(apellido);
        empleado.setNombre(nombre);
        empleado.setDni(dni);
        empleado.setCargo(cargo);
        empleado.setUnUsuario(usuario);
        control.crearEmpleado(empleado);
        
        //Se agrega el empleado a la lista de empleados del juego
        Juego juego = control.getJuego(game);
        List<Empleado> listaEmpleados = juego.getListaEmpleados();
        listaEmpleados.add(empleado);
        control.editarJuego(juego);
        
        
        response.sendRedirect("lista_empleados.jsp");
        
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
