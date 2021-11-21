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
                <c:if test="${publicacion.finalizado == true}">
                    <h4 style="text-align: center; color: red">Finalizado</h4>
                </c:if>
                <c:if test="${publicacion.mascota.estado.descripcion == Perdido}">
                    <h2 style="text-align: center">Perdido</h2>
                </c:if>
                <c:if test="${publicacion.mascota.estado.descripcion == Encontrado}">
                    <h2 style="text-align: center">Encontrado</h2>
                </c:if>
                <img src="${publicacion.mascota.imagen}" class="imagen-tarjeta" alt="">
            <div class="w3-container w3-center">
                <p>Nombre: ${publicacion.mascota.nombre}</p>
                <p>Raza: ${publicacion.mascota.raza}</p>
                <p>Detalles: ${publicacion.mascota.detalle}</p>
                <p>Tamanio: ${publicacion.mascota.tamanio}</p>
                <p>Color: ${publicacion.mascota.color}</p>
                <p>Edad: ${publicacion.mascota.edad}</p>
            </div>
            <c:if test="${publicacion.finalizado == true}">
                <a class="w3-btn w3-red" style="margin-top: 10px" href="/missingpets/eliminar-publicacion?id=${publicacion.id}">Eliminar</a>
            </c:if>
    <c:if test="${publicacion.finalizado != true}">
            <div>
                <br>
                <a class="w3-btn w3-green" style="width: 100%;" href="/missingpets/ir-al-sitio-modificar-mascota?id=${publicacion.id}">Modificar</a>
                <br>
                <a class="w3-btn w3-red" style="width: 100%; margin-top: 10px" type="submit" href="/missingpets/finalizar-publicacion?id=${publicacion.id}">Finalizar</a>
            </div>
        <br>
        <div class="w3-center">
            <c:if test="${publicacion.mascota.estado.descripcion == Perdido}">
                <form:form cssClass="w3-container" action="buscarUsuario" method="POST" modelAttribute="datosMascota">
                    <label style="float: left">Buscar Usuario</label>
                        <form:input cssClass="w3-input w3-border" path="email"  type="text" id="email"/>
                    <button class="w3-btn w3-blue" style="width: 100%;" type="submit">Buscar</button>
                </form:form>
            </c:if>
        </div>
    </c:if>
        </div>

    </c:forEach>
    <c:if test="${not empty busqueda}">
        <div class="w3-container">
            <div class="w3-panel w3-red w3-round-xxlarge">
                <h4><span>${busqueda}</span></h4>
            </div>
            <div>
                <a class="w3-btn w3-blue w3-round-xxlarge" style="width: 100%; margin-top: 10px" href="javascript: history.go(-1)">Volver a Mis Publicaciones</a>

            </div>
        </div>
    </c:if>
</div>

</body>
</html>
