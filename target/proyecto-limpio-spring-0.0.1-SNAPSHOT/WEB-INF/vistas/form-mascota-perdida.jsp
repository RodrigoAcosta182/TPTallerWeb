<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/w3s.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
    <%--		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">--%>
</head>
<body class="container-body-login">
<div class="w3-container container-home">
    <div id="loginbox" class="loginbox">
        <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
        <%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
        <%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto--%>

        <form:form cssClass="w3-container" action="validar-login" method="POST" modelAttribute="datosLogin">
            <h3 class="titulo-login">DATOS DE LA MASCOTA</h3>
            <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
            <label>Usuario</label>
<%--            <form:input cssClass="w3-input" path="email" id="email" type="email"/>--%>
            <label>Password</label>
<%--            <form:input cssClass="w3-input" path="password" type="password" id="password"/>--%>
            <%--Bloque que es visible si el elemento error no esta vacio	--%>
            <c:if test="${not empty msg}">
                <h4><span>${msg}</span></h4>
                <br>
            </c:if>
            <div class="w3-row l12 w3-center btn-login">
                <button class="w3-button w3-deep-purple" Type="Submit"/>Ingresar al sistema</button>
            </div>
        </form:form>
        <hr class="colorgraph">
        <div class="w3-row l12 w3-center">
            <span>Todavia no tenes una cuenta?</span>
            <a href="ir-a-registrarme" class="login-registro-usuario">Registrarme</a>
        </div>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
