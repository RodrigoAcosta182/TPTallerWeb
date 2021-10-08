<!DOCTYPE html>
<html>
<title>Mascotas Perdidas</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/w3s.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body class="imagen-fondo">
<div class="w3-top">
    <div class="w3-bar home-navegador" id="myNavbar">
        <a class="w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right" href="javascript:void(0);"
           onclick="toggleFunction()" title="Toggle Navigation Menu">
            <i class="fa fa-bars"></i>
        </a>
        <a href="#home" class="w3-bar-item w3-button">HOME</a>
        <a href="" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-user"></i> Perdidos</a>
        <a href="" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-user"></i> Encontrados</a>
        <a href="" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-user"></i> Reencontrados</a>
        <a href="" class="w3-bar-item w3-button w3-hide-small"><i class="fa fa-user"></i> Servicios</a>


        </a>
    </div>

    <!-- Navbar on small screens -->
    <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium">
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Perdidos</a>
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Encontrados</a>
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Reencontrados</a>
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Servicios</a>
    </div>
</div>

<!-- First Parallax Image with Logo Text -->
<div class="w3-display-container" style="height: 50%" id="home">
    <div class="container-publicaciones noselect">
        <div class="tarjeta-publicacion-mascota">
            <img class="imagen-publicacion-mascota" src="https://cadenapolitica.com/wp-content/uploads/2021/08/schnauzer.jpg" alt="Alps">
            <div class="w3-container w3-center">
                <p>Descripcion de la mascota perdida</p>
            </div>
        </div>
        <div class="tarjeta-publicacion-mascota">
            <img class="imagen-publicacion-mascota"  src="https://images.clarin.com/2021/06/20/el-caniche-arriba-en-las___6JQOYiC4y_340x340__1.jpg" alt="Alps">
            <div class="w3-container w3-center">
                <p>Descripcion de la mascota perdida</p>
            </div>
        </div>
        <div class="tarjeta-publicacion-mascota">
            <img class="imagen-publicacion-mascota"  src="https://hips.hearstapps.com/es.h-cdn.co/mcres/images/mi-casa/terraza-jardines-porche/razas-pequenas-de-perros-blancos/bichon-frise/1722987-1-esl-ES/bichon-frise.jpg?crop=1xw:0.9377289377289377xh;center,top&resize=480:*" alt="Alps">
            <div class="w3-container w3-center">
                <p>Descripcion de la mascota perdida</p>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
