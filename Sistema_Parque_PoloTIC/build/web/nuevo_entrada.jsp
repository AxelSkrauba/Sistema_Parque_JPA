<%@page import="Logica.Persona"%>
<%@page import="Logica.Juego"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Entrada - Parque -</title>
    </head>
    <body>

        <%
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("nombreUsuario");
            if (usuario == null) {
                response.sendRedirect("index.jsp");
            } else {
        %>

        <div id="header">
            <jsp:include page="common/header.jsp"/>
        </div>
        <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div id="main">
                <div class="container">
                    <div class="abs-center" style="background-color:rgba(100, 100, 100, 0.3);">

                        <form action="ServletNuevoEntrada" method="POST" class="border p-3 form">
                            <span class="login100-form-title p-b-34 p-t-27">
                                Agregar Entrada
                            </span>
                            <div class="form-group">
                                <label for="date">Fecha</label>
                                <input type="date" name="date" id="date" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label for="time">Hora</label>
                                <input type="time" name="time" id="time" class="form-control" required>
                            </div>

                            <div class="input-group">
                                <label for="id_client">Cliente</label>
                                <select name="id_client" id="id_client" class="" required>
                                    <%
                                        Controladora control = new Controladora();
                                        List<Persona> listaPersonas = control.getListaPersonas();
                                        for (Persona persona : listaPersonas) {
                                            out.println("<option value ='" + persona.getId_persona() + "'>" + persona.getNombre() + " " + persona.getApellido() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                            <span></span>


                            <div class="input-group">
                                <label for="id_game">Juego</label>
                                <select name="id_game" id="id_game" class="" required>
                                    <%
                                        List<Juego> listaJuegos = control.getListaJuegos();
                                        for (Juego unJuego : listaJuegos) {
                                            out.println("<option value ='" + unJuego.getId_juego() + "'>" + unJuego.getNombre() + "</option>");
                                        }
                                    %>
                                </select>
                            </div>


                            <button type="submit" class="btn btn-primary">Cargar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <%
            }
        %>
    </body>
</html>