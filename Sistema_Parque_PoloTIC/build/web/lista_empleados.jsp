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
                        <a type="button" class="btn btn-primary" href="nuevo_empleado.jsp">Agregar Nuevo<span ></span></a>
                        <tr>
                            <th>ID Empleado</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DNI</th>
                            <th>Cargo</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <%
                                Controladora control = new Controladora();
                                List<Empleado> listaEmpleados = control.getListaEmpleados();
                                for (Empleado empleado : listaEmpleados) {
                            %>
                            <td><%=empleado.getId_empleado()%></td>
                            <td><%=empleado.getNombre()%></td>
                            <td><%=empleado.getApellido()%></td>
                            <td><%=empleado.getDni()%></td>
                            <td><%=empleado.getCargo()%></td>
                            <td><a type="button" class="btn btn-danger" href="ServletEliminarEmpleado?id=<%=empleado.getId_empleado()%>">Eliminar<span ></span></a></td>
                            <td><a type="button" class="btn btn-primary" href="editar_empleado.jsp?id=<%=empleado.getId_empleado()%>">Editar<span ></span></a></td>
                            
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
