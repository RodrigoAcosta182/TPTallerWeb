<%@ page import="ar.edu.unlam.tallerweb1.modelo.Usuario" %>
<%@ page import="ar.edu.unlam.tallerweb1.modelo.Publicacion" %>
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
            <c:if test="${publicacion.mascota.estado.id == 1}">
                <h2 style="text-align: center">Perdido</h2>
            </c:if>
            <c:if test="${publicacion.mascota.estado.id == 2}">
                <h2 style="text-align: center">Encontrado</h2>
            </c:if>
            <img src="${publicacion.mascota.imagen}" class="imagen-tarjeta" alt="">
            <div class="w3-container w3-center">
                <p><b>Nombre:</b> ${publicacion.mascota.nombre}</p>
                <p><b>Raza:</b> ${publicacion.mascota.raza}</p>
                <p><b>Detalles:</b> ${publicacion.mascota.detalle}</p>
                <p><b>Tamanio:</b> ${publicacion.mascota.tamanio}</p>
                <p><b>Color:</b> ${publicacion.mascota.color}</p>
                <p><b>Edad:</b> ${publicacion.mascota.edad}</p>
                <p><b>Localidad:</b> ${publicacion.localidad.descripcion}</p>
                <p><b>Publicacion de:</b> ${publicacion.usuario.email}</p>
            </div>
            <a href="/missingpets/publicacion?id=${publicacion.id}">
                <button class="w3-btn w3-green" style="text-decoration: none">Ver publicacion</button>
            </a>
                    <form:form  action="finalizar-publicacion" method="POST" modelAttribute="datosMascota">
                        <form:input  value="${publicacion.id}" cssClass="w3-input" path="id" type="hidden" id="id" />
                            <c:if test="${publicacion.mascota.estado.id == 2 && publicacion.usuario.id != sessionScope.Usuario.id}">
                                    <h6>Quien encontro tu mascota?</h6>
                                    <form:input placeholder='Ingrese su mail' cssClass="w3-input w3-border" path="email"  type="text" id="email"/>
                            </c:if>
                        <button class="w3-btn w3-purple" style="width: 100%; margin-top: 10px;" Type="Submit"/>Finalizar</button>
                    </form:form>
        </div>
    </c:forEach>
</div>


</body>
</html>

<%-- src="<spring:url value='webapp/images'${savedUser.profileImage.originalFilename}'  --%>