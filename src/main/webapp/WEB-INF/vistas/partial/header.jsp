<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Header</title>
</head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/w3s.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top imagen-fondo">
    <div class="w3-bar home-navegador" id="myNavbar">
        <a class="w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right" href="javascript:void(0);"
           onclick="toggleFunction()" title="Toggle Navigation Menu">
            <i class="fa fa-bars"></i>
        </a>
        <a href="home" class="w3-bar-item w3-button">HOME</a>
        <a href="ir-a-publicacion-mascota-perdida" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-user"></i> Perdidos</a>
        <a href="ir-a-publicacion-mascota-encontrada" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-user"></i> Encontrados</a>
        <a href="" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-user"></i> Servicios</a>

        <a class="w3-bar-item w3-button w3-hide-small" style="float:right" href="#about">Cerrar Sesion</a>
        <a class="w3-bar-item w3-button w3-hide-small" style="float:right" href="ir-a-mis-publicaciones">Mis Publicaciones</a>
        <a class="w3-bar-item w3-button w3-hide-small" style="float:right" href="ir-a-mis-publicaciones">Bienvenido ${usuario.nombre}</a>

        </a>
    </div>

    <!-- Navbar on small screens -->
    <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium">
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Perdidos</a>
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Encontrados</a>
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Servicios</a>
    </div>
</div>

