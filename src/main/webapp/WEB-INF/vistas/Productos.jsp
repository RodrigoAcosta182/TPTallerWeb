<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Mis Publicaciones</title>
<%@ include file="partial/header.jsp" %>

<div class="w3-container">
    <c:if test="${not empty msg}">
        <div style="display: flex;justify-content: center;align-items: center;margin-top: 40px">
            <div class="w3-panel w3-green w3-round w3-round-xxlarge">
                <h4 style="text-align: center">${msg}</h4>
            </div>
        </div>
    </c:if>
    <div class="puntosDelUsuario w3-center" style="margin-top: 30px; display: flex">
        <c:if test="${not empty usuario}">
            <h2>MissingPets Points actuales: ${usuario.puntos}</h2>
        </c:if>
    </div>
    <c:if test="${usuario.rol == 'admin'}">
        <div style="display: flex;justify-content: center;align-items: center;margin-top: 10px">
            <a class="w3-btn w3-blue" type="submit"
               href="ir-a-registrar-producto">Subir nuevo Producto</a>
        </div>
    </c:if>
    <div class="container-publicaciones noselect">
        <c:forEach items="${productos}" var="productos" varStatus="status" step="1" begin="0">
            <div id="${status.index % 3 + 1}" class="tarjeta-publicacion-producto">
                <h4>${productos.descripcion}</h4>
                <img src="${productos.imgproducto}" class="imagen-tarjeta" alt="">
                <div class="w3-container w3-center">
                    <c:set var="context" value="${pageContext.request.contextPath}"/>
                    <script src="${context}/themes/js/jquery.js"></script>
                    <p><b>Stock Disponible:</b> ${productos.cantidad}</p>
                    <p><b>Puntos:</b> ${productos.puntos}</p>
                </div>
                <div>
                    <form action=""></form>
                    <br>
                    <a class="w3-btn w3-purple w3-round-xxlarge" style="width: 100%; margin-top: 10px" type="submit"
                       href="/missingpets/canjear-producto?id=${productos.id}">Canjear</a>
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
                    <a class="w3-btn w3-blue w3-round-xxlarge" style="width: 100%; margin-top: 10px" type="submit"
                       href="ir-a-productos">Volver a ver Productos</a>
                </div>
            </div>
        </c:if>
    </div>

</div>
</body>
</html>
