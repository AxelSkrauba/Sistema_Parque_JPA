<%@page import="Logica.Empleado"%>
<%@page import="Logica.Juego"%>
<%@page import="Logica.Entrada"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe: empleados de un juego</title>
    </head>
    <body>

        <%
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("nombreUsuario");
            Controladora control = new Controladora();
            if (usuario == null) {
                response.sendRedirect("index.jsp");
            } else {
                String id_juego = request.getParameter("id_game");
                if (id_juego == null) {
                    id_juego = "-1";
                }
        %>

        <div id="header">
            <jsp:include page="common/header.jsp"/>
        </div>
        <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div id="main">
                <div class="container">
                    <div class="abs-center" style="background-color:rgba(100, 100, 100, 0.3);">

                        <form action="informe_empleados_juego.jsp" method="GET" class="border p-3 form">
                            <span class="login100-form-title p-b-34 p-t-27">
                                Empleados de un juego
                            </span>
                            <div class="input-group">
                                <label for="id_game">Seleccione el juego de interés:</label>
                                <select name="id_game" id="id_game" class="" required required>
                                    <%
                                        List<Juego> listaJuegos = control.getListaJuegos();
                                        for (Juego unJuego : listaJuegos) {
                                            if (unJuego.getId_juego() == Integer.parseInt(id_juego)) {
                                                out.println("<option selected value ='" + unJuego.getId_juego() + "'>" + unJuego.getNombre() + "</option>");
                                            } else {
                                                out.println("<option value ='" + unJuego.getId_juego() + "'>" + unJuego.getNombre() + "</option>");
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Filtrar</button>
                        </form>
                        <% if (id_juego.equals("-1")) {
                                out.println("<h3 style='color:red'>Seleccione un juego válido para ver sus encargados.</h3>");
                            } else {%>

                        <table class="table table-bordered" id="dataTable" name="tablita" width="100%" cellspacing="0">
                            <thead class="thead-dark">
                            <tr>
                                <th>ID Empleado</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>DNI</th>
                                <th>Cargo</th>
                            </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <%
                                        Juego juegoSelec = control.getJuego(id_juego);
                                        List<Empleado> listaEmpleados = juegoSelec.getListaEmpleados();
                                        for (Empleado empleado : listaEmpleados) {
                                    %>
                                    <td><%=empleado.getId_empleado()%></td>
                                    <td><%=empleado.getNombre()%></td>
                                    <td><%=empleado.getApellido()%></td>
                                    <td><%=empleado.getDni()%></td>
                                    <td><%=empleado.getCargo()%></td>
                                </tr>

                                <% } %>
                            </tbody>
                        </table>



                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
        <%            }
        %>
    </body>
</html>