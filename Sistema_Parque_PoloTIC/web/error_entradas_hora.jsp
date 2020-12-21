<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generar Entrada: error hora!</title>
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
                            Entrada NO Generada
                        </span>
                        <span class="center">
                            El horario seleccionado no coresponde al horario
                        </span>
                        <br>
                        <span class="center">
                            de funcionamiento del juego escogido.
                        </span>
                        <div class="row">
                            <div class="col-md-6">
                                <td><a type="button" class="btn btn-secondary" href="lista_entradas.jsp">Volver<span ></span></a></td>
                            </div>

                            <div class="col-md-6">
                                <td><a type="button" class="btn btn-primary" href="nuevo_entrada.jsp">Volver a Intentar<span ></span></a></td>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <%
            }
        %>
    </body>
</html>