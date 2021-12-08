<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Mis Publicaciones</title>
<%@ include file="partial/header.jsp" %>

<link href="${pageContext.request.contextPath}/css/w3s.css" rel="stylesheet">
<link href="../css/estilos.css" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<div class="container-publicaciones noselect">
    <c:if test="${not empty publicacionesError}">
        <div class="w3-panel w3-red w3-round-xxlarge">
            <h4><span>${publicacionesError}</span></h4>
        </div>
    </c:if>
    <c:forEach items="${publicaciones}" var="publicacion" varStatus="status" step="1" begin="0">
        <div id="${status.index % 3 + 1}" class="tarjeta-publicacion-mascota">

            <c:if test="${publicacion.mascota.estado.id == 1}">
                <h2 style="text-align: center">Perdido</h2>
            </c:if>
            <c:if test="${publicacion.mascota.estado.id == 2}">
                <h2 style="text-align: center">Encontrado</h2>
            </c:if>
<%--            <img src="${publicacion.mascota.imagen}" class="imagen-tarjeta" alt="">--%>
            <img src="../../../../../../../images/Pluto.png" class="imagen-tarjeta" alt="">
            <div class="w3-container w3-center">
                <p><b>Nombre:</b> ${publicacion.mascota.nombre}</p>
                <p><b>Raza:</b> ${publicacion.mascota.raza}</p>
                <p><b>Detalles:</b> ${publicacion.mascota.detalle}</p>
                <p><b>Tamanio:</b> ${publicacion.mascota.tamanio}</p>
                <p><b>Color:</b> ${publicacion.mascota.color}</p>
                <p><b>Edad:</b> ${publicacion.mascota.edad}</p>
                <p><b>Localidad:</b> ${publicacion.localidad.descripcion}</p>
            </div>
            <a href="/missingpets/publicacion?id=${publicacion.id}">
                <button class="w3-btn w3-green" style="text-decoration: none">Ver publicacion</button>
            </a>
        </div>
    </c:forEach>
</div>


</body>
</html>

<%-- src="<spring:url value='webapp/images'${savedUser.profileImage.originalFilename}'  --%>