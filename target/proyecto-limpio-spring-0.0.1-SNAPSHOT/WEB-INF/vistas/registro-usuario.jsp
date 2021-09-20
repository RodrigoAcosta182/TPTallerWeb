<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/w3s.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
</head>
<body class="container-body-login">
<div class = "w3-container container-home">
    <div id="loginbox" class="loginbox">
        <form:form action="registrarme" method="POST" modelAttribute="datos" cssClass="w3-container">
            <h3 class="titulo-login">Nuevo Usuario</h3>

            <label>Mail</label>
            <form:input cssClass="w3-input" path="email" id="email"/>
            <label>Clave</label>
            <form:input cssClass="w3-input" path="clave" type="password" id="clave"/>
            <label>Repite clave</label>
            <form:input cssClass="w3-input" path="repiteClave" type="password" id="clave"/>
            <div class="w3-row l12 w3-center btn-login">
                <button id="btn-registrarme"  class="w3-button w3-deep-purple"  Type="Submit"/>Registrarme</button>
            </div>
            <c:if test="${not empty error}">
                <h4><span>${error}</span></h4>
                <br>
            </c:if>

        </form:form>


    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>