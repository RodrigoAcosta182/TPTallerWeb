<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Mis Publicaciones</title>
<%@ include file="partial/header.jsp" %>


<div style="display: flex;margin-top: 64px;justify-content: center;">
    <a href="ir-a-busqueda">
    <button class="w3-button w3-blue" style="text-decoration: none">Nueva Busqueda</button>
    </a>
</div>
<div class="container-publicaciones noselect" style="margin-top: 0">
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
            <img src="${publicacion.mascota.imagen}" class="imagen-tarjeta" alt="">
            <div class="w3-container w3-center">
                <p> <span style="font-weight: bold">Nombre:</span>  ${publicacion.mascota.nombre}</p>
                <p> <span style="font-weight: bold">Raza:</span>  ${publicacion.mascota.raza}</p>
                <p> <span style="font-weight: bold">Detalles:</span>  ${publicacion.mascota.detalle}</p>
                <p> <span style="font-weight: bold">Color:</span>  ${publicacion.mascota.color}</p>
                <p> <span style="font-weight: bold">Tamanio:</span>  ${publicacion.mascota.tamanio}</p>
                <p> <span style="font-weight: bold">Edad:</span>  ${publicacion.mascota.edad}</p>
                <p> <span style="font-weight: bold">Localidad:</span>  ${publicacion.localidad.descripcion}</p>
                <p> <span style="font-weight: bold">Publicacion de:</span>  ${publicacion.usuario.email}</p>

            </div>
            <a href="/missingpets/publicacion?id=${publicacion.id}">
                <button class="w3-btn w3-green" style="text-decoration: none;margin-top: 8px">Ver publicacion</button>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>
