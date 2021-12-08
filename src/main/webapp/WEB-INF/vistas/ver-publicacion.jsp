<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href="css/style.css" rel="stylesheet">

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
                    <p><span style="font-weight: bold">Tamanio:</span> ${publicacion.mascota.tamanio}</p>
                </div>
                <div class="w3-col">
                    <p><span style="font-weight: bold">Edad:</span> ${publicacion.mascota.edad}</p>
                    <p><span style="font-weight: bold">Color:</span> ${publicacion.mascota.color}</p>
                    <p><span style="font-weight: bold">Localidad:</span> ${publicacion.localidad.descripcion}</p>
                </div>
            </div>
            <form:form action="enviarCorreo" method="POST" modelAttribute="datosCorreo">
                <form:input value="${publicacion.id}" cssClass="w3-input" path="idPublicacion" type="hidden" id="id"/>
                <label class="w3-left">Enviar mensaje a:</label>
                <form:input cssClass="w3-input" path="receptor" id="receptor" readonly="true"/>
                <form:textarea cssClass="ver-publicacion-escribir-comentario" path="comentario" id="receptor"/>
                <div>
                    <button class="w3-btn w3-purple" type="submit" style="width: 100%">Enviar mensaje</button>
                    <br> <br>
                    <input type="button" id="myBtn" class="w3-btn w3-green" value="Ver Chat" style="width: 100%">
                </div>

                <c:if test="${not empty mailError}">
                    <div class="w3-panel w3-red w3-round">
                        <h4 style="text-align: center"><span>${mailError}</span></h4>
                    </div>
                </c:if>


                <c:if test="${not empty mailOk}">
                    <div class="w3-panel w3-blue w3-round">
                        <h4 style="text-align: center">${mailOk}</h4>
                    </div>
                </c:if>
            </form:form>


            <!-- The Modal -->
            <div id="myModal" class="modal">
                <!-- Modal content -->
                <div style="width: 35%" class="modal-content">
                    <div class="modal-header w3-center">
                        <span class="close">&times;</span>
                        <h2>Conversacion</h2>
                    </div>
                    <div  class="modal-body">
                        <c:forEach items="${listaComentarios}" var="comentario" varStatus="status" step="1" begin="0">
                            <div id="${status.index % 3 + 1}">
                                <c:if test="${publicacion.usuario.email == comentario.usuario.email}">
                                    <div class="container">

                                        <h5 style="text-align: right"><i style="color: cornflowerblue" class="fa fa-check-circle login-icono-tilde"></i>${comentario.usuario.email}:</h5>
                                        <h5 style="text-align: right;font-weight: bold">${comentario.mensaje}</h5>
                                        <span class="time-right">${comentario.fecha}</span>
                                    </div>
                                </c:if>
                                <c:if test="${publicacion.usuario.email != comentario.usuario.email}">
                                    <div class="container darker">
                                        <h5>${comentario.usuario.email}:</h5>
                                        <h5 style="font-weight: bold">${comentario.mensaje}</h5>
                                        <span class="time-left">${comentario.fecha}</span>
                                    </div>
                                </c:if>

                            </div>
                        </c:forEach>

                    </div>
                    <div class="modal-footer w3-center">
                        <h3>Missing pets</h3>
                    </div>
                </div>

            </div>

            <script>
                // Get the modal
                var modal = document.getElementById("myModal");

                // Get the button that opens the modal
                var btn = document.getElementById("myBtn");

                // Get the <span> element that closes the modal
                var span = document.getElementsByClassName("close")[0];

                // When the user clicks the button, open the modal
                btn.onclick = function () {
                    modal.style.display = "block";
                }

                // When the user clicks on <span> (x), close the modal
                span.onclick = function () {
                    modal.style.display = "none";
                }

                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function (event) {
                    if (event.target == modal) {
                        modal.style.display = "none";
                    }
                }
            </script>
        </div>
    </div>
</div>
</body>
</html>

