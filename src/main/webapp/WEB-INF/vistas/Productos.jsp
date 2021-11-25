<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Mis Publicaciones</title>
<%@ include file="partial/header.jsp" %>

<div class="w3-container">
    <div class="container-publicaciones noselect">
        <c:forEach items="${productos}" var="productos" varStatus="status" step="1" begin="0">
            <div id="${status.index % 3 + 1}" class="tarjeta-publicacion-mascota">
                <h4>${productos.descripcion}</h4>
                <img src="${productos.imgproducto}" class="imagen-tarjeta" alt="">
                <div class="w3-container w3-center">
                    <c:set var="context" value="${pageContext.request.contextPath}" />
                    <script src="${context}/themes/js/jquery.js"></script>
                    <p>Stock Disponible: ${productos.cantidad}</p>
                    <p>Puntos: ${productos.puntos}</p>
                </div>
                <div>
                    <form action=""></form>
                    <br>
                    <a class="w3-btn w3-purple w3-round-xxlarge" style="width: 100%; margin-top: 10px" type="submit" href="/missingpets/canjear-producto?id=${productos.id}">Canjear</a>
                </div>
            </div>
        </c:forEach>
        <c:if test="${not empty error}">
            <div class="w3-container w3-center">
                <div>
                    <img class="imagen-tarjeta" src="img/perro-triste.jpeg" alt="triste">
                </div>
                <div>
                    <p class="login-mensaje-error">${error}</p>
                </div>
                <div>
                    <a class="w3-btn w3-blue w3-round-xxlarge" style="width: 100%; margin-top: 10px" type="submit" href="ir-a-productos">Volver a ver Productos</a>
                </div>
            </div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="w3-container w3-center">
                <div>
                    <p class="login-mensaje-error">${msg}</p>
                </div>
                <div>
                    <a class="w3-btn w3-blue w3-round-xxlarge" style="width: 100%; margin-top: 10px" type="submit" href="ir-a-productos">Volver a ver Productos</a>
                </div>
            </div>
        </c:if>
    </div>
    <c:if test="${usuario.rol == 'admin'}">
        <a class="w3-btn w3-blue" style="margin-top: 20px; margin-left: 44%" type="submit" href="ir-a-registrar-producto">Subir nuevo Producto</a>
    </c:if>
</div>


</body>
</html>

<%-- src="<spring:url value='webapp/images'${savedUser.profileImage.originalFilename}'  --%>