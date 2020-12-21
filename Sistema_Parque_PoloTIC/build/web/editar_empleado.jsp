<%@page import="Logica.Juego"%>
<%@page import="Logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Empleado</title>
    </head>
    <body>

        <%
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("nombreUsuario");
            if (usuario == null) {
                response.sendRedirect("index.jsp");
            } else {
                String ID = request.getParameter("id");
                if (ID == null) {
                    //Sin id, se redirige a la página anterior
                    response.sendRedirect("lista_empleados.jsp");
                } else {
                    Controladora control = new Controladora();
                    Empleado empleadoEditar = control.getEmpleado(ID);
                    if (empleadoEditar == null) {
                        //Si el id no existe, se redirige a la página anterior
                        response.sendRedirect("lista_empleados.jsp");
                    } else {
        %>

        <div id="header">
            <jsp:include page="common/header.jsp"/>
        </div>
        <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div id="main">

                <div class="container">
                    <div class="abs-center" style="background-color:rgba(100, 100, 100, 0.3);">

                        <form action="ServletEditarEmpleado" method="POST" class="border p-3 form">
                            <span class="login100-form-title p-b-34 p-t-27">
                                Agregar Empleado
                            </span>
                            <div class="form-group">
                                <input type="hidden" name="id" id="id" class="form-control" value='<%=ID%>'>
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="id_user" id="id" class="form-control" value='<%=empleadoEditar.getUnUsuario().getId_usuario()%>'>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="name">Nombre</label>
                                        <input type="text" name="name" id="name" class="form-control" required value='<%=empleadoEditar.getNombre()%>'>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="lastname">Apellido</label>
                                        <input type="text" name="lastname" id="lastname" class="form-control" required value='<%=empleadoEditar.getApellido()%>'>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="dni">DNI</label>
                                        <input type="text" name="dni" id="dni" class="form-control" required value='<%=empleadoEditar.getDni()%>'>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="cargo">Cargo</label>
                                <input type="text" name="cargo" id="cargo" class="form-control" required value='<%=empleadoEditar.getCargo()%>'>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="usuario">Usuario</label>
                                        <input type="text" name="usuario" id="usuario" class="form-control" required value='<%=empleadoEditar.getUnUsuario().getNombreUsuario()%>'>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="contrasenia">Contraseña</label>
                                        <input type="password" name="contrasenia" id="contrasenia" class="form-control" required value='<%=empleadoEditar.getUnUsuario().getContrasenia()%>'>
                                    </div>
                                </div>

                            </div>


                            <div class="input-group">
                                <label for="game">Juego Asociado</label>
                                <select name="game" id="game" class="" required>
                                    <%
                                        List<Juego> listaJuegos = control.getListaJuegos();
                                        out.println("<option value='' selected disabled hidden>Seleccione Juego</option>");
                                        for (Juego unJuego : listaJuegos) {
                                            out.println("<option value ='" + unJuego.getId_juego() + "'>" + unJuego.getNombre() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>

                            <button type="submit" class="btn btn-primary">Guardar cambios</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <%
                    }
                }
            }
        %>
    </body>
</html>