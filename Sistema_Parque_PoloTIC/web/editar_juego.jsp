<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
        <title>Editar Juego</title>
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
                    response.sendRedirect("lista_juegos.jsp");
                } else {
                    Controladora control = new Controladora();
                    Juego juegoEditar = control.getJuego(ID);
                    if (juegoEditar == null) {
                        //Si el id no existe, se redirige a la página anterior
                        response.sendRedirect("lista_juegos.jsp");
                    } else {
        %>

        <div id="header">
            <jsp:include page="common/header.jsp"/>
        </div>
        <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div id="main">
                <div class="container">
                    <div class="abs-center" style="background-color:rgba(100, 100, 100, 0.3);">

                        <form action="ServletEditarJuego" method="POST" class="border p-3 form">
                            <span class="login100-form-title p-b-34 p-t-27">
                                Editar Juego
                            </span>
                            <div class="form-group">
                                <input type="hidden" name="id" id="id" class="form-control" value='<%=ID%>'>
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="id_horario" id="id_horario" class="form-control" value='<%=juegoEditar.getHorario().getId_horario() %>'>
                            </div>
                            <div class="form-group">
                                <label for="nombre">Nombre</label>
                                <input type="text" name="nombre" id="nombre" class="form-control" required value='<%=juegoEditar.getNombre()%>'>
                            </div>

                            <span class="center">
                                Horario de Funcionamiento
                            </span>

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="hora_inicio">Desde</label>
                                        <input type="time" name="hora_inicio" id="hora_inicio" class="form-control" required value='<%=control.convertirDateToTime(juegoEditar.getHorario().getHorario_inicio())%>'>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="hora_fin">Hasta</label>
                                        <input type="time" name="hora_fin" id="hora_fin" class="form-control" required value='<%=control.convertirDateToTime(juegoEditar.getHorario().getHorario_fin())%>'>
                                    </div>
                                </div>
                            </div>


                            <button type="submit" class="btn btn-primary">Cargar</button>
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