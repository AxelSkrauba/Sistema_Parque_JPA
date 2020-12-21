<%@page import="Logica.Juego"%>
<%@page import="Logica.Entrada"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informe: entradas por juego y día</title>
    </head>
    <body>

        <%
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("nombreUsuario");
            int cantidad = 0;
            Controladora control = new Controladora();
            List<Entrada> listEntradas = control.getListaEntradas();
            List<Juego> listJuegos = control.getListaJuegos();
            if (usuario == null) {
                response.sendRedirect("index.jsp");
            } else {
                String dia = request.getParameter("dia");
                String id_juego = request.getParameter("id_game");
                if (dia != null && id_juego != null) {
                    for (Entrada entrada : listEntradas) {
                        for (Juego juego : listJuegos){
                            if (juego.getId_juego() != Integer.parseInt(id_juego)){
                                continue;
                            }
                            List<Entrada> listEntradasXJuego = juego.getListaEntradas();
                            for (Entrada entradaJuego : listEntradasXJuego){
                                if (control.DateAString2(entrada.getFecha()).equals(dia) && entradaJuego.getId_entrada() == entrada.getId_entrada()) {
                                cantidad++;
                                }
                            }
                        }
                    }
                }else{
                    id_juego = "0";
                } 
        %>

        <div id="header">
            <jsp:include page="common/header.jsp"/>
        </div>
        <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div id="main">
                <div class="container">
                    <div class="abs-center" style="background-color:rgba(100, 100, 100, 0.3);">

                        <form action="informe_entradas_juego.jsp" method="GET" class="border p-3 form">
                            <span class="login100-form-title p-b-34 p-t-27">
                                Entradas Vendidas por Juego y Día
                            </span>
                            <div class="form-group">
                                <label for="dia">Seleccione la fecha de interés:</label>
                                <input type="date" name="dia" id="dia" class="form-control" required value='<%=dia%>'>
                            </div>
                            <div class="input-group">
                                <label for="id_game">Seleccione el juego de interés:</label>
                                <select name="id_game" id="id_game" class="" required required>
                                    <%
                                        List<Juego> listaJuegos = control.getListaJuegos();
                                        for (Juego unJuego : listaJuegos) {
                                            if(unJuego.getId_juego() == Integer.parseInt(id_juego)){
                                                out.println("<option selected value ='" + unJuego.getId_juego() + "'>" + unJuego.getNombre() + "</option>");
                                            }else{
                                                out.println("<option value ='" + unJuego.getId_juego() + "'>" + unJuego.getNombre() + "</option>");
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Filtrar</button>
                        </form>
                        <% if (dia == null) {
                                out.println("<h3 style='color:gray'>Para ver resultados, ingrese un juego y fecha válidos</h3>");
                            } else {
                                out.println("<h4>Ventas en el juego y día seleccionado: " + cantidad + "</h4>");
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