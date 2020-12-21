<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal - Parque -</title>
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
                <br>
                <br>
                <br>
                <br>
                <h3> ¡Bienvenido: <%=usuario%>!</h3>
            </div>
        </div>


        <%
            }
        %>
    </body>
</html>
