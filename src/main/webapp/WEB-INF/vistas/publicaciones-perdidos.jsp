<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Mis Publicaciones</title>
<%@ include file="partial/header.jsp" %>

<%--<link href="${pageContext.request.contextPath}/css/w3s.css" rel="stylesheet">--%>
<%--&lt;%&ndash;<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">&ndash;%&gt;--%>
<%--&lt;%&ndash;<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">&ndash;%&gt;--%>
<%--<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>

<link href="../css/estilos.css" rel="stylesheet">

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
            <div style="width: 200px;height: 200px">
                <img src="${publicacion.mascota.imagen}" class="imagen-tarjeta" alt="">
            </div>
            <div style="display: flex;justify-content: space-around;padding: 12px 0;width: 350px;">
                <div style="width: 190px">
                    <p class="text-elipsis"><span style="font-weight: bold">Nombre:</span> ${publicacion.mascota.nombre}</p>
                    <p class="text-elipsis"><span style="font-weight: bold">Raza:</span> ${publicacion.mascota.raza}</p>
                    <p class="text-elipsis"><span style="font-weight: bold">Detalles:</span> ${publicacion.mascota.detalle}</p>
                    <p class="text-elipsis"><span style="font-weight: bold">Tamanio:</span> ${publicacion.mascota.tamanio}</p>
                </div>
                <div style="width: 130px">
                    <p class="text-elipsis"><span style="font-weight: bold">Edad:</span> ${publicacion.mascota.edad}</p>
                    <p class="text-elipsis"><span style="font-weight: bold">Color:</span> ${publicacion.mascota.color}</p>
                    <p class="text-elipsis"><span style="font-weight: bold">Localidad:</span> ${publicacion.localidad.descripcion}</p>
                </div>
            </div>
            <p class="text-elipsis"><b>Publicacion de:</b> ${publicacion.usuario.email}</p>
            <a href="/missingpets/publicacion?id=${publicacion.id}">
                <button class="w3-btn w3-green" style="text-decoration: none;margin-top: 20px">Ver publicacion</button>
            </a>
        </div>
    </c:forEach>
</div>


</body>
</html>

<%-- src="<spring:url value='webapp/images'${savedUser.profileImage.originalFilename}'  --%>