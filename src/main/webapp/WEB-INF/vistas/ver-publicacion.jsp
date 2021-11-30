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
<%--            <img src="${publicacion.mascota.imagen}" style="width: 400px; height: 400px;border-radius: 12px" alt="">--%>
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
                    <br> <br>
                    <input type="button"  id="myBtn" class="w3-btn w3-green" value="Ver Chota" style="width: 100%">
                </div>


                <c:if test="${not empty mailOk}">
                    <div class="w3-panel w3-green w3-round">
                        <h4><span>${mailOk}</span></h4>
                    </div>
                </c:if>
            </form:form>

    <!-- The Modal -->
    <div id="myModal" class="modal">
        <!-- Modal content -->
        <div class="modal-content">
            <div class="modal-header w3-center">
                <span class="close">&times;</span>
                <h2>Conversacion</h2>
            </div>
            <div class="modal-body">
                <div class="container">
                    <img src="/w3images/bandmember.jpg" alt="Avatar">
                    <p>Hello. How are you today?</p>
                    <span class="time-right">11:00</span>
                </div>

                <div class="container darker">
                    <img src="/w3images/avatar_g2.jpg" alt="Avatar" class="right">
                    <p>Hey! I'm fine. Thanks for asking!</p>
                    <span class="time-left">11:01</span>
                </div>

                <div class="container">
                    <img src="/w3images/bandmember.jpg" alt="Avatar">
                    <p>Sweet! So, what do you wanna do today?</p>
                    <span class="time-right">11:02</span>
                </div>

                <div class="container darker">
                    <p  class="w3-right">BABY</p>
                    <p>Nah, I dunno. Play soccer.. or learn more coding perhaps?</p>
                    <span class="time-left">11:05</span>
                </div>
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
        btn.onclick = function() {
            modal.style.display = "block";
        }

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
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

