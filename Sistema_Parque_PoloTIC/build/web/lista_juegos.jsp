<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Juego"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Empleado"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados - Parque -</title>
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
                <table class="table table-bordered" id="dataTable" name="tablita" width="100%" cellspacing="0">
                    <thead class="thead-dark">
                    <a type="button" class="btn btn-primary" href="nuevo_juego.jsp">Agregar Nuevo<span ></span></a>
                    <tr>
                        <th>ID Juego</th>
                        <th>Nombre</th>
                        <th>Desde</th>
                        <th>Hasta</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <%
                                Controladora control = new Controladora();
                                List<Juego> listajuegos = control.getListaJuegos();
                                for (Juego juego : listajuegos) {
                            %>
                            <td><%=juego.getId_juego()%></td>
                            <td><%=juego.getNombre()%></td>
                            <td><%=control.convertirDateToTime(juego.getHorario().getHorario_inicio())%></td>
                            <td><%=control.convertirDateToTime(juego.getHorario().getHorario_fin())%></td>

                            <td><a type="button" class="btn btn-danger" href="ServletEliminarJuego?id=<%=juego.getId_juego()%>">Eliminar<span ></span></a></td>
                            <td><a type="button" class="btn btn-primary" href="editar_juego.jsp?id=<%=juego.getId_juego()%>">Editar<span ></span></a></td>

                        </tr>

                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>


        <%
            }
        %>
    </body>
</html>
