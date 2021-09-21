<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<title>Login Missing Pets</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/w3s.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
    body,h1 {font-family: "Raleway", sans-serif}
    body, html {height: 100%}
    .bgimg {
        background-image: linear-gradient(to right top, #051937, #3a2e5d, #75407b, #b6528e, #f66793);
        min-height: 100%;
        background-position: center;
        background-size: cover;
    }
</style>
<body>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
    <div class="w3-display-topleft w3-padding-large w3-xlarge">
        Missing Pets
    </div>
    <div class="w3-display-middle">
        <div class="w3-jumbo w3-animate-top ">
            <div class="loginbox w3-text-black">
                <div class="titulo-login">Datos de la mascota perdida</div>
                <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
                <%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
                <%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto--%>
                <form:form cssClass="w3-container" action="registrarMascota" method="POST" modelAttribute="datosMascota">
                    <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
                    <label style="float: left">Nombre</label>
<%--                    <form:input cssClass="w3-input" path="nombre" id="nombre" type="name"/>--%>
                    <label style="float: left">Tipo</label>
<%--                    <form:input cssClass="w3-input" path="tipo" type="password" id="password"/>--%>
                    <%--Bloque que es visible si el elemento error no esta vacio	--%>
                    <c:if test="${not empty error}">
                        <h4><span>${error}</span></h4>
                        <br>
                    </c:if>
                    <div class="w3-row l12 w3-center btn-login">
                        <button class="w3-button w3-deep-purple" Type="Submit"/>Subir datos</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <div class="w3-display-bottomleft w3-padding-large">
        Powered by <a href="https://www.youtube.com/watch?v=yG7MPEQm1-w" target="_blank">Garlopa Company</a>
    </div>
</div>

</body>
</html>
