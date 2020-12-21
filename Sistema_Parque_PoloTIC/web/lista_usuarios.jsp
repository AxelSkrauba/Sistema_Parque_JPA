<%@page import="java.util.List"%>
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios - Parque -</title>
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
                        <tr>
                            <th>ID Usuario</th>
                            <th>Nombre de Usuario</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <%
                                Controladora control = new Controladora();
                                List<Usuario> listaUsuarios = control.getListaUsuarios();
                                for (Usuario unUsuario : listaUsuarios) {
                            %>
                            <td><%=unUsuario.getId_usuario() %></td>
                            <td><%=unUsuario.getNombreUsuario() %></td>
                            
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
