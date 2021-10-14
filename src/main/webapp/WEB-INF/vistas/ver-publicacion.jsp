<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Mascotas Perdidas</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/w3s.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body class="imagen-fondo" style="background: white">
<div class="header-publicaciones"
     style="background: linear-gradient(to right top, #051937, #3a2e5d, #75407b, #b6528e, #f66793);">
    <div class="w3-bar home-navegador" id="myNavbar">
        <a class="w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right" href="javascript:void(0);"
           onclick="toggleFunction()" title="Toggle Navigation Menu">
            <i class="fa fa-bars"></i>
        </a>
        <a href="home" class="w3-bar-item w3-button">HOME</a>
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

<div class="container-publicaciones noselect">
    <div class="tarjeta-publicacion-ver-publicacion">
        <div class="w3-container w3-center">
            <p>Foto + Descripcion de la publicacion</p>
            <%--            <textarea class="ver-publicacion-escribir-comentario"></textarea>--%>
            <form:form action="enviarCorreo" method="POST" modelAttribute="datosCorreo" cssClass="w3-container">
                <label class="w3-left">Correo creador de la publicacion</label>
                <form:input cssClass="w3-input" path="receptor" id="receptor"/>
                <form:textarea cssClass="ver-publicacion-escribir-comentario" path="comentario" id="receptor"/>
                <div>
                    <button class="w3-btn w3-purple" type="submit">Comentar</button>
                </div>
                <c:if test="${not empty mailOk}">
                    <div class="w3-panel w3-green w3-round">
                        <h4><span>${mailOk}</span></h4>
                    </div>
                </c:if>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

