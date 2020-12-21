<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link href="https://fonts.googleapis.com/css?family=Alegreya+Sans:100,100i,300,300i,400,400i,500,500i,700,700i,800,800i,900,900i" rel="stylesheet">

<header>

    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" id="mainNav">
        <div class="container-fluid">
            <a class="navbar-brand js-scroll-trigger" href="index.jsp">
                <h2></h2>
                <img src="images\logo.png" >
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="principal.jsp">Inicio <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown  main-menu">
                        <a class="nav-link dropdown-toggle" href="#" >Personal</a>
                        <div class="dropdown-menu main-menubox" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="lista_empleados.jsp">Empleados</a>
                            <a class="dropdown-item" href="lista_usuarios.jsp">Usuarios</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lista_juegos.jsp">Juegos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lista_personas.jsp">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lista_entradas.jsp">Entradas</a>
                    </li>
                    
                    <li class="nav-item dropdown  main-menu">
                        <a class="nav-link dropdown-toggle" href="#" >Informes</a>
                        <div class="dropdown-menu main-menubox" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="informe_entradas_dia.jsp">Entradas por Día</a>
                            <a class="dropdown-item" href="informe_entradas_juego.jsp">Entradas por Juego</a>
                            <a class="dropdown-item" href="informe_empleados_juego.jsp">Empleados por Juego</a>
                        </div>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="about.jsp">Acerca</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ServletLogOut">LogOut</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>