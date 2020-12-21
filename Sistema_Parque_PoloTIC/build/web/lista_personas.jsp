<%@page import="Logica.Persona"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes - Parque -</title>
    </head>
    <body>

        <%
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("nombreUsuario");
            if (usuario == null) {
                response.sendRedirect("index.jsp");
            } else {
        %>

        <div id="header" >
            <jsp:include page="common/header.jsp"/>
        </div>
        <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div id="main">
                <table class="table table-bordered" id="dataTable" name="tablita" width="100%" cellspacing="0">
                    <thead class="thead-dark">
                        <a type="button" class="btn btn-primary" href="nuevo_persona.jsp">Agregar Nuevo<span ></span></a>
                        <tr>
                            <th>ID Usuario</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <%
                                Controladora control = new Controladora();
                                List<Persona> listaPersonas = control.getListaPersonas();
                                for (Persona persona : listaPersonas) {
                            %>
                            <td><%=persona.getId_persona() %></td>
                            <td><%=persona.getNombre() %></td>
                            <td><%=persona.getApellido() %></td>
                            <td><a type="button" class="btn btn-danger" href="ServletEliminarPersona?id=<%=persona.getId_persona()%>">Eliminar<span ></span></a></td>
                            <td><a type="button" class="btn btn-primary" href="editar_persona.jsp?id=<%=persona.getId_persona()%>">Editar<span ></span></a></td>
                            
                            
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
