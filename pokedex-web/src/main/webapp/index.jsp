<!DOCTYPE html>
<html>
    <head>
        <title>Pokédex Web</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="./imgs/logo.png">
        <link rel="stylesheet" href="./styles/styles.css">
    </head>
    <body>
        <%@include file="fragments/header.jspf"%>
        <main class="seccion-main">
            <div id="seccion-titulo">
                    <h2 class="titulo-formulario">Agrega un Pokémon</h2>
                </div>
            <form class="formulario" action="pokes" method="post" enctype="multipart/form-data">
                <div class="seccion-datos">
                    <label class="texto-label" for="nombre">Nombre</label>
                    <input class="input-text" type="text" id="nombre" name="nombre" required placeholder="Ingresa el nombre del pokémon"/>
                </div>
                <div class="seccion-datos">
                    <label class="texto-label" for="numero">Número</label>
                    <input class="input-text" type="text" id="numero" name="numero" pattern="\d{3}" required placeholder="Ingresa el número del pokémon en la pokédex"/>
                </div>
                <div class="seccion-datos">
                    <label class="texto-label" for="tipo">Tipo</label>
                    <input class="input-text" type="text" id="tipo" name="tipo" maxlength="10" required placeholder="Ingresa el tipo del pokémon"/>
                </div>
                <div class="seccion-datos">
                    <label class="texto-label" for="imaqen">Imagen del Pokémon</label>
                    <input class="input-file" type="file" id="imagen" name="imagen" required placeholder="Agrega la imagen del pokémon"/>
                </div>
                <% 
                    String errores = (String)request.getAttribute("errores");
                    if(errores != null && !errores.isBlank()){ 
                %>
                    <div class="seccion-errores">
                        <%=errores %>
                    </div>
                <% 
                    }
                %>
                <div id="seccion-enviar">
                    <input class="boton-enviar" type="submit" value="Agregar Pokémon">
                </div>
            </form>
        </main>
    </body>
</html>
