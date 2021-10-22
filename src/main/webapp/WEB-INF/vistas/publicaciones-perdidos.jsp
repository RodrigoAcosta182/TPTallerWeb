<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Mis Publicaciones</title>
<%@ include file="partial/header.jsp" %>

<div class="container-publicaciones noselect">
    <c:if test="${not empty publicacionesError}">
        <div class="w3-panel w3-red w3-round-xxlarge">
            <h4><span>${publicacionesError}</span></h4>
        </div>
    </c:if>
    <c:forEach items="${publicaciones}" var="publicacion" varStatus="status" step="1" begin="0">
        <div id="${status.index % 3 + 1}" class="tarjeta-publicacion-mascota">

            <c:if test="${publicacion.mascota.estado == 1}">
                <h2 style="text-align: center">Perdido</h2>
            </c:if>
            <c:if test="${publicacion.mascota.estado == 2}">
                <h2 style="text-align: center">Encontrado</h2>
            </c:if>
            <img src="${publicacion.mascota.imagen}" class="imagen-tarjeta" alt="">
            <div class="w3-container w3-center">
                <p>Nombre: ${publicacion.mascota.nombre}</p>
                <p>Raza: ${publicacion.mascota.raza}</p>
                <p>Detalles: ${publicacion.mascota.detalle}</p>
                <p>Tamanio: ${publicacion.mascota.tamanio}</p>
                <p>Edad: ${publicacion.mascota.edad}</p>
            </div>

        </div>
    </c:forEach>
</div>


</body>
</html>

<%-- src="<spring:url value='webapp/images'${savedUser.profileImage.originalFilename}'  --%>