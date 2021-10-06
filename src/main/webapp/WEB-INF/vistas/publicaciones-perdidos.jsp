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
<!-- Navbar (sit on top) -->
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
<div class="bgimg-1 w3-display-container" style="height: 50%" id="home">
    <div class="w3-display-middle w3-row home-botones-container noselect" style="width: 50%; margin-top: 5%">
        <div class="w3-card-4 w3-col w3-margin">
            <img style="width: 100%;" src="https://cadenapolitica.com/wp-content/uploads/2021/08/schnauzer.jpg" alt="Alps">
            <div class="w3-container w3-center">
                <p>Descripcion de la mascota perdida</p>
            </div>
        </div>
        <div class="w3-card-4 w3-col w3-margin">
            <img style="width: 100%;" src="https://images.clarin.com/2021/06/20/el-caniche-arriba-en-las___6JQOYiC4y_340x340__1.jpg" alt="Alps">
            <div class="w3-container w3-center">
                <p>Descripcion de la mascota perdida</p>
            </div>
        </div>
        <div class="w3-card-4 w3-col w3-margin">
            <img style="width: 100%;" src="https://hips.hearstapps.com/es.h-cdn.co/mcres/images/mi-casa/terraza-jardines-porche/razas-pequenas-de-perros-blancos/bichon-frise/1722987-1-esl-ES/bichon-frise.jpg?crop=1xw:0.9377289377289377xh;center,top&resize=480:*" alt="Alps">
            <div class="w3-container w3-center">
                <p>Descripcion de la mascota perdida</p>
            </div>
        </div>
    </div>
</div>
<!-- Modal for full size images on click-->
<div id="modal01" class="w3-modal w3-black" onclick="this.style.display='none'">
    <span class="w3-button w3-large w3-black w3-display-topright" title="Close Modal Image"><i class="fa fa-remove"></i></span>
    <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
        <img id="img01" class="w3-image">
        <p id="caption" class="w3-opacity w3-large"></p>
    </div>
</div>

<script>
    // Modal Image Gallery
    function onClick(element) {
        document.getElementById("img01").src = element.src;
        document.getElementById("modal01").style.display = "block";
        var captionText = document.getElementById("caption");
        captionText.innerHTML = element.alt;
    }

    // Change style of navbar on scroll
    window.onscroll = function () {
        myFunction()
    };

    function myFunction() {
        var navbar = document.getElementById("myNavbar");
        if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
            navbar.className = "w3-bar" + " w3-card" + " w3-animate-top" + " w3-white";
        } else {
            navbar.className = navbar.className.replace(" w3-card w3-animate-top w3-white", "");
        }
    }

    // Used to toggle the menu on small screens when clicking on the menu button
    function toggleFunction() {
        var x = document.getElementById("navDemo");
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
