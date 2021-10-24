<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Mascotas Perdidas</title>
<%@ include file="partial/header.jsp" %>

<!-- First Parallax Image with Logo Text -->

<div class="container-publicaciones noselect">
    <div class="tarjeta-publicacion-ver-publicacion">
        <div>
            <img src="${publicacion.mascota.imagen}" style="width: 400px; height: 400px;border-radius: 12px" alt="">
            <div class="w3-row" style="display: flex;justify-content: space-around;padding: 12px 0">
                <div class="w3-col">
                    <p><span style="font-weight: bold">Nombre:</span> ${publicacion.mascota.nombre}</p>
                    <p><span style="font-weight: bold">Raza:</span> ${publicacion.mascota.raza}</p>
                    <p><span style="font-weight: bold">Detalles:</span> ${publicacion.mascota.detalle}</p>
                </div>
                <div class="w3-col">
                    <p><span style="font-weight: bold">Tamanio:</span>  ${publicacion.mascota.tamanio}</p>
                    <p><span style="font-weight: bold">Edad:</span> ${publicacion.mascota.edad}</p>
                </div>
            </div>
            <form:form action="enviarCorreo" method="POST" modelAttribute="datosCorreo">
                <label class="w3-left">Enviar mensaje a:</label>
                <form:input cssClass="w3-input" path="receptor" id="receptor" readonly="true"/>
                <form:textarea cssClass="ver-publicacion-escribir-comentario" path="comentario" id="receptor"/>
                <div>
                    <button class="w3-btn w3-purple" type="submit" style="width: 100%">Enviar mensaje</button>
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

