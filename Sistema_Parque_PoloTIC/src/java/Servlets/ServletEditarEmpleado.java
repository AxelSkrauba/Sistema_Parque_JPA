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
@WebServlet(name = "ServletEditarEmpleado", urlPatterns = {"/ServletEditarEmpleado"})
public class ServletEditarEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("name");
        String apellido = request.getParameter("lastname");
        String dni = request.getParameter("dni");
        String cargo = request.getParameter("cargo");

        String id_usuario = request.getParameter("id_user");
        String usuarioNombre = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");

        String game = request.getParameter("game");

        Controladora control = new Controladora();

        Empleado empleado = new Empleado();
        empleado.setId_empleado(Integer.parseInt(id));
        empleado.setApellido(apellido);
        empleado.setNombre(nombre);
        empleado.setDni(dni);
        empleado.setCargo(cargo);
        empleado.setUnUsuario(control.getUsuario(id_usuario));
        control.editarEmpleado(empleado);

        Usuario usuario = new Usuario();
        usuario.setId_usuario(Integer.parseInt(id_usuario));
        usuario.setNombreUsuario(usuarioNombre);
        usuario.setContrasenia(contrasenia);
        control.editarUsuario(usuario);

        //Eliminar empleado asociado al antiguo juego
        //Se recorren todos los juegos, en cada juego se recorre la lista de
        //empleados. Al encontrar el id del empleado en edicion, se finaliza el
        //ciclo de busqueda. Para el juego y posicion en la lista encontrados,
        //se elimina el empleado y se guardan los cambios.
        Juego juego_antiguo = new Juego();
        int indice_empleado_juego_antiguo = 0;
        List<Juego> listaJuegos = control.getListaJuegos();
        for (Juego unJuego : listaJuegos) {
            List<Empleado> listaEmpleados = unJuego.getListaEmpleados();
            int indice = 0;
            for (Empleado unEmpleado : listaEmpleados){
                if (unEmpleado.getId_empleado() == Integer.parseInt(id)){
                    juego_antiguo = unJuego;
                    indice_empleado_juego_antiguo = indice;
                    indice = -1; //Bandera para el for externo
                    break;
                }
                indice++;
            }
            if (indice == -1) {
                break;
            }
        }
        List<Empleado> listaEmpleados_edit = juego_antiguo.getListaEmpleados();
        listaEmpleados_edit.remove(indice_empleado_juego_antiguo);
        juego_antiguo.setListaEmpleados(listaEmpleados_edit);
        control.editarJuego(juego_antiguo);
        

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
