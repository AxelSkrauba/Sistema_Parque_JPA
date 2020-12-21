<%@page import="Logica.Entrada"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe: entradas por día</title>
    </head>
    <body>

        <%
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("nombreUsuario");
            int cantidad = 0;
            Controladora control = new Controladora();
            List<Entrada> listEntradas = control.getListaEntradas();
            if (usuario == null) {
                response.sendRedirect("index.jsp");
            } else {
                String dia = request.getParameter("dia");
                if (dia != null) {
                    for (Entrada entrada : listEntradas) {
                        if (control.DateAString2(entrada.getFecha()).equals(dia)) {
                            cantidad++;
                        }
                    }
                } else {
                    for (Entrada entrada : listEntradas) {
                        cantidad++;
                    }
                }
        %>

        <div id="header">
            <jsp:include page="common/header.jsp"/>
        </div>
        <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div id="main">
                <div class="container">
                    <div class="abs-center" style="background-color:rgba(100, 100, 100, 0.3);">

                        <form action="informe_entradas_dia.jsp" method="GET" class="border p-3 form">
                            <span class="login100-form-title p-b-34 p-t-27">
                                Entradas Vendidas por Día
                            </span>
                            <div class="form-group">
                                <label for="dia">Seleccione la fecha de interés:</label>
                                <input type="date" name="dia" id="dia" class="form-control" required value='<%=dia%>'>
                            </div>
                            <button type="submit" class="btn btn-primary">Filtrar</button>
                        </form>
                        <% if (dia == null) {
                                out.println("<h3 style='color:red'>Mostrando resultados generales, fecha no seleccionada o incorrecta</h3>");
                                out.println("<h4>Ventas Totales:" + cantidad + "</h4>");
                            } else {
                                out.println("<h4>Ventas en el día: " + cantidad + "</h4>");
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