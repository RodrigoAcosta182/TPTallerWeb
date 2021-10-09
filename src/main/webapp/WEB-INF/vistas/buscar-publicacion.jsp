<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Buscar Mascota</title>
</head>
<link href="css/w3s.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
<div class="imagen-fondo container-buscar-publicaciones" style="height: 100%">
    <div class="buscar-publicaciones-formulario">
        <div class="buscar-publicaciones-cerrar">
            <span class="noselect"  style="font-size: 20px;cursor: pointer">X</span>
        </div>
        <div class="buscar-publicaciones-titulo">
            <span style="font-size: 20px">Buscar Mascota</span>
        </div>
        <div>
            <form:form cssClass="w3-container" action="buscarMascota" method="POST" modelAttribute="datosMascota">
                <label style="float: left">Estado</label>
                <form:select path="estado" cssClass="w3-select">
                    <form:option value="" disabled="true" selected="selected">-- SELECCIONE --</form:option>
                    <form:option value="1">Perdido</form:option>
                    <form:option value="2">Encontrado</form:option>
                </form:select>
                <label style="float: left; margin-bottom: 2px">Tipo</label>
                <form:select path="tipo" cssClass="w3-select">
                    <form:option value="" disabled="true" selected="selected">-- SELECCIONE --</form:option>
                    <form:option value="1">Perro</form:option>
                    <form:option value="2">Gato</form:option>
                    <form:option value="3">Otro</form:option>
                </form:select>
                <label style="float: left">Raza</label>
                <form:input cssClass="w3-input" path="raza" type="text" id="raza"/>
                <label style="float: left">Color</label>
                <form:input cssClass="w3-input" path="color" type="text" id="color"/>
                <div class="buscar-publicaciones-boton-container">
                    <button class="w3-button w3-deep-purple" Type="Submit"/>
                    Buscar</button>
                </div>
            </form:form>
        </div>
    </div>
</div>


</body>
</html>
