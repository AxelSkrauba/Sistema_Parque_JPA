<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Empleado</title>
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

                        <span class="login100-form-title p-b-34 p-t-27">
                            Curso de Desarrollo Web Full Stack con Java
                        </span>
                        <span class="login100-form-title p-b-34 p-t-27">
                            Polo TIC 2020
                        </span>
                        <span class="login100-form-title p-b-34 p-t-27">
                            Alumno: Skrauba Axel A.
                        </span>
                        
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>