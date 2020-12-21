<%@page import="Logica.Entrada"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entradas - Parque -</title>
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
                        <a type="button" class="btn btn-primary" href="nuevo_entrada.jsp">Agregar Nueva<span ></span></a>
                        <tr>
                            <th>ID Entrada</th>
                            <th>Fecha</th>
                            <th>Hora</th>
                            <th>Cliente</th>
                            <th>Juego</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <%
                                Controladora control = new Controladora();
                                List<Entrada> listaEntradas = control.getListaEntradas();
                                for (Entrada entrada : listaEntradas) {
                            %>
                            <td><%=entrada.getId_entrada() %></td>
                            <td><%=control.DateAString(entrada.getFecha()) %></td>
                            <td><%=control.convertirDateToTime(entrada.getHora()) %></td>
                            <td><%=control.getPersonaFromIdEntrada(String.valueOf(entrada.getId_entrada()))%></td>
                            <td><%=control.getJuegoFromIdEntrada(String.valueOf(entrada.getId_entrada()))%></td>
 
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
