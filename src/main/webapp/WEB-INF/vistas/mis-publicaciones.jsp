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
<%--            <img class="imagen-publicacion-mascota"--%>
<%--                 src="https://images.clarin.com/2021/06/20/el-caniche-arriba-en-las___6JQOYiC4y_340x340__1.jpg"--%>
<%--                 alt="Alps">--%>
                <c:if test="${publicacion.finalizado == true}">
                    <h4 style="text-align: center; color: red">Finalizado</h4>
                </c:if>
                <c:if test="${publicacion.mascota.estado == 1}">
                    <h2 style="text-align: center">Perdido</h2>
                </c:if>
                <c:if test="${publicacion.mascota.estado == 2}">
                    <h2 style="text-align: center">Encontrado</h2>
                </c:if>
                <img src="${publicacion.mascota.imagen}" class="imagen-tarjeta" alt="">
            <div class="w3-container w3-center">
<%--                <c:set var="context" value="${pageContext.request.contextPath}" />--%>
<%--                <script src="${context}/themes/js/jquery.js"></script>--%>
                <p>Nombre: ${publicacion.mascota.nombre}</p>
                <p>Raza: ${publicacion.mascota.raza}</p>
                <p>Detalles: ${publicacion.mascota.detalle}</p>
                <p>Tamanio: ${publicacion.mascota.tamanio}</p>
                <p>Edad: ${publicacion.mascota.edad}</p>
            </div>
    <c:if test="${publicacion.finalizado != true}">
            <div>
                <form action=""></form>
                <br>
                <a class="w3-btn w3-green" style="width: 100%;" type="submit">Modificar</a>
                <br>
                <a class="w3-btn w3-red" style="width: 100%; margin-top: 10px" type="submit" href="/missingpets/finalizar-publicacion?id=${publicacion.id}">Finalizar</a>
            </div>
    </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>

<%-- src="<spring:url value='webapp/images'${savedUser.profileImage.originalFilename}'  --%>