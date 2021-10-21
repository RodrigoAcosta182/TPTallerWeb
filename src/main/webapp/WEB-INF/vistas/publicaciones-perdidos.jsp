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

    <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium">
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Perdidos</a>
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Encontrados</a>
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Reencontrados</a>
        <a href="" class="w3-bar-item w3-button" onclick="toggleFunction()">Servicios</a>
    </div>
</div>


<div class="container-publicaciones noselect">
    <c:if test="${not empty publicacionesError}">
        <div class="w3-panel w3-red w3-round-xxlarge">
            <h4><span>${publicacionesError}</span></h4>
        </div>
    </c:if>
    <c:forEach items="${publicaciones}" var="publicacion" varStatus="status" step="1" begin="0">
        <div id="${status.index % 3 + 1}" class="tarjeta-publicacion-mascota">
            <a href="/publicacion/${publicacion.id}" class="tarjeta-text-decoration">


                    <%--            <img class="imagen-publicacion-mascota"--%>
                    <%--                 src="https://images.clarin.com/2021/06/20/el-caniche-arriba-en-las___6JQOYiC4y_340x340__1.jpg"--%>
                    <%--                 alt="Alps">--%>
                <c:if test="${publicacion.mascota.estado == 1}">
                    <h2 style="text-align: center">Perdido</h2>
                </c:if>
                <c:if test="${publicacion.mascota.estado == 2}">
                    <h2 style="text-align: center">Encontrado</h2>
                </c:if>
                <img src="${publicacion.mascota.imagen}" width="100%" height="250px" alt="">
                <div class="w3-container w3-center">
                        <%--                <c:set var="context" value="${pageContext.request.contextPath}" />--%>
                        <%--                <script src="${context}/themes/js/jquery.js"></script>--%>
                    <p>Nombre: ${publicacion.mascota.nombre}</p>
                    <p>Raza: ${publicacion.mascota.raza}</p>
                    <p>Detalles: ${publicacion.mascota.detalle}</p>
                    <p>Tamanio: ${publicacion.mascota.tamanio}</p>
                    <p>Edad: ${publicacion.mascota.edad}</p>


                </div>
            </a>
        </div>
    </c:forEach>
</div>


</body>
</html>

<%-- src="<spring:url value='webapp/images'${savedUser.profileImage.originalFilename}'  --%>