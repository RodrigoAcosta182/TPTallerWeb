<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<!DOCTYPE html>
<html>
<title>Mis Publicaciones</title>
<%@ include file="partial/header.jsp" %>

<c:if test="${not empty msg}">
    <div style="display: flex;justify-content: center;align-items: center">
        <div class="w3-panel w3-green w3-round-xxlarge " style="margin-top: 60px; width: 30%">
            <h4 style="text-align: center">${msg}</h4>
        </div>
    </div>
</c:if>
<c:if test="${not empty publicacionesError}">
    <div style="display: flex;justify-content: center;align-items: center">
        <div class="w3-panel w3-red w3-round-xxlarge" style="margin-top: 60px; width: 30%">
            <h4 style="text-align: center">${publicacionesError}</h4>
        </div>
    </div>
</c:if>
<div class="container-publicaciones noselect">
    <c:forEach items="${publicaciones}" var="publicacion" varStatus="status" step="1" begin="0">
        <div id="${status.index % 3 + 1}" class="tarjeta-publicacion-mascota">
            <c:if test="${publicacion.finalizado == true}">
                <h4 style="text-align: center; color: red">Finalizado</h4>
            </c:if>
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
                    <p class="text-elipsis"><span style="font-weight: bold">Nombre:</span> ${publicacion.mascota.nombre}
                    </p>
                    <p class="text-elipsis"><span style="font-weight: bold">Raza:</span> ${publicacion.mascota.raza}</p>
                    <p class="text-elipsis"><span
                            style="font-weight: bold">Detalles:</span> ${publicacion.mascota.detalle}</p>
                    <p class="text-elipsis"><span
                            style="font-weight: bold">Tamanio:</span> ${publicacion.mascota.tamanio}</p>
                </div>
                <div style="width: 130px">
                    <p class="text-elipsis"><span style="font-weight: bold">Edad:</span> ${publicacion.mascota.edad}</p>
                    <p class="text-elipsis"><span style="font-weight: bold">Color:</span> ${publicacion.mascota.color}
                    </p>
                    <p class="text-elipsis"><span
                            style="font-weight: bold">Localidad:</span> ${publicacion.localidad.descripcion}</p>
                </div>
            </div>
            <div>
                <c:if test="${publicacion.finalizado == true}">
                    <a class="w3-btn w3-red" style="margin-top: 10px"
                       href="/missingpets/eliminar-publicacion?id=${publicacion.id}">Eliminar</a>
                </c:if>
                <c:if test="${publicacion.finalizado != true}">
                    <div>
                        <form:form action="finalizar-publicacion" method="POST" modelAttribute="datosMascota">
                            <form:input value="${publicacion.id}" cssClass="w3-input" path="id" type="hidden" id="id"/>
                            <c:if test="${publicacion.mascota.estado.id == 1}">
                                <h6>Quien encontro tu mascota?</h6>
                                <form:input placeholder='Ingrese su mail' cssClass="w3-input w3-border" path="email"
                                            type="text" id="email"/>
                            </c:if>
                            <button class="w3-btn w3-purple" style="width: 100%; margin-top: 10px;" Type="Submit"/>
                            Finalizar</button>
                        </form:form>
                        <div style="display: flex;gap: 8px;padding-top: 8px ">
                            <a class="w3-btn w3-blue" style="width: 100%"
                               href="/missingpets/ir-al-sitio-modificar-mascota?id=${publicacion.id}">Modificar
                            </a>
                            <a href="/missingpets/publicacion?id=${publicacion.id}">
                                <button class="w3-btn w3-green" style="text-decoration: none">Ver publicacion</button>
                            </a>
                        </div>
                    </div>
                    <br>
                </c:if>
            </div>
        </div>

    </c:forEach>
    <c:if test="${not empty error}">
        <div class="w3-container w3-center">
            <div>
                <p class="login-mensaje-error">${error}</p>
            </div>
            <div>
                <a class="w3-btn w3-blue w3-round-xxlarge" style="width: 100%; margin-top: 10px"
                   href="javascript:history.back(-1);" title="Ir la página anterior">Volver</a></div>
        </div>
    </c:if>
</div>

</body>
</html>
