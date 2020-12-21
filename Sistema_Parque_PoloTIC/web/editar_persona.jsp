<%@page import="Logica.Persona"%>
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
        <title>Editar Cliente</title>
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
                    response.sendRedirect("lista_personas.jsp");
                } else {
                    Controladora control = new Controladora();
                    Persona personaEditar = control.getPersona(ID);
                    if (personaEditar == null) {
                        //Si el id no existe, se redirige a la página anterior
                        response.sendRedirect("lista_personas.jsp");
                    } else {
        %>

        <div id="header">
            <jsp:include page="common/header.jsp"/>
        </div>
        <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
            <div id="main">

                <div class="container">
                    <div class="abs-center" style="background-color:rgba(100, 100, 100, 0.3);">

                        <form action="ServletEditarPersona" method="POST" class="border p-3 form">
                            <span class="login100-form-title p-b-34 p-t-27">
                                Agregar Cliente
                            </span>
                            <div class="form-group">
                                <input type="hidden" name="id" id="id" class="form-control" value='<%=ID%>'>
                            </div>
                            <div class="form-group">
                                <label for="name">Nombre</label>
                                <input type="text" name="name" id="name" class="form-control" required value='<%=personaEditar.getNombre()%>'>
                            </div>

                            <div class="form-group">
                                <label for="lastname">Apellido</label>
                                <input type="text" name="lastname" id="lastname" class="form-control" required value='<%=personaEditar.getApellido()%>'>
                            </div>

                            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
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