<%@page import="com.mycompany.pokedex.web.servlets.dominio.PokemonDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<html>
    <head>
        <title>PokÃ©dex Web - Registros</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="./imgs/logo.png">
        <link rel="stylesheet" href="./styles/styles.css">
    </head>
    <body>
        <%@include file="fragments/header.jspf"%>
        <main class="container">
            <ul class="pokemon-lista">
                <c:forEach var="pokemon" items="${pokes}">
                <li class="pokemon-item">
                    <div class="pokemon">
                        <div class="pokemon-imagen">
                            <img class="pokemon-imagen" src="<c:url value='/${pokemon.url}'/>" alt="${pokemon.nombre}">
                        </div>
                        <div class="info-pokemon">
                            <h3 class="nombre-pokemon"><c:out value="${pokemon.getNombre()}"/></h3>
                            <h2 class="numero-pokemon"><c:out value="${pokemon.getNumero()}"/></h2>
                            <h2 class="tipo-pokemon"><c:out value="${pokemon.getTipo()}"/></h2>
                        </div>
                    </div>
                </li>
                </c:forEach>
            </ul>
        </main>
    </body>
</html>