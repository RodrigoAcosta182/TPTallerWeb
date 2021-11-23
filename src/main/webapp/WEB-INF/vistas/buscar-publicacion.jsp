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
            <a href="home" class="noselect" style="font-size: 20px;cursor: pointer;text-decoration: none">X</a>
        </div>
        <div class="buscar-publicaciones-titulo">
            <span style="font-size: 20px">Buscar Mascota</span>
        </div>
        <div>
<%--            REVISAR BUSQUEDA DESDE VISTA HASTA REPOSITORIO--%>
            <form:form cssClass="w3-container" action="buscar-publicaciones" method="GET" modelAttribute="datosMascota" >
                <label style="float: left; margin-bottom: 2px">Estado</label>
                <form:select path="estado" id="estado" cssClass="w3-select">
                    <form:option value="${null}" disabled="true" selected="selected">Seleccionar</form:option>
                    <form:options items="${estadosMascota}"
                                  itemValue="descripcion"
                                  itemLabel="descripcion"/>
                </form:select>
                <label style="float: left; margin-bottom: 2px">Tipo</label>
                <form:select path="tipo" id="tipo" cssClass="w3-select">
                    <form:option value="${null}" disabled="true" selected="selected">Seleccionar</form:option>
                    <form:options items="${tiposDeMascota}"
                                  itemValue="descripcion"
                                  itemLabel="descripcion"/>
                </form:select>

                <label style="float: left; margin-bottom: 2px">Localidad</label>
                <form:select path="publicacion.localidad.descripcion" id="publicacion.localidad.descripcion" cssClass="w3-select">
                    <form:option value="${null}" disabled="true" selected="selected">Seleccionar</form:option>
                    <form:options items="${localidades}"
                                  itemValue="descripcion"
                                  itemLabel="descripcion"/>
                </form:select>
                <label style="float: left">Color</label>
                <form:input  cssClass="w3-input" path="color" type="text" id="color"/>

                <label style="float: left">Raza</label>
                <form:input  cssClass="w3-input" path="raza" type="text" id="raza"/>
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
