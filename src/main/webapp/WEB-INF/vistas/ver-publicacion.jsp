<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Mascotas Perdidas</title>
<%@ include file="partial/header.jsp" %>

<!-- First Parallax Image with Logo Text -->

<div class="container-publicaciones noselect">
    <div class="tarjeta-publicacion-ver-publicacion">
        <div class="w3-container w3-center">
            <p>Foto + Descripcion de la publicacion</p>
            <%--            <textarea class="ver-publicacion-escribir-comentario"></textarea>--%>
            <form:form action="enviarCorreo" method="POST" modelAttribute="datosCorreo" cssClass="w3-container">
                <label class="w3-left">Correo creador de la publicacion</label>
                <form:input cssClass="w3-input" path="receptor" id="receptor"/>
                <form:textarea cssClass="ver-publicacion-escribir-comentario" path="comentario" id="receptor"/>
                <div>
                    <button class="w3-btn w3-purple" type="submit">Comentar</button>
                </div>
                <c:if test="${not empty mailOk}">
                    <div class="w3-panel w3-green w3-round">
                        <h4><span>${mailOk}</span></h4>
                    </div>
                </c:if>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

