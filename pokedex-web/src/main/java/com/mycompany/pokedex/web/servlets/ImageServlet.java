package com.mycompany.pokedex.web.servlets;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * @author Yuri Germán García López - 252583
 * Servlet para servir imágenes dinámicamente desde el directorio.
 * Más que nada para que las imágenes carguen de una en la página de pokemons registrados.
 */
@WebServlet("/imgs/*")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Obtener el nombre del archivo de la URL
        String filename = request.getPathInfo();

        if (filename == null || filename.isBlank()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //Obtener la ruta real en el disco local
        String realPath = getServletContext().getRealPath("/imgs" + filename);
        File file = new File(realPath);

        //Si el archivo no existe, envía el error 404
        if (!file.exists() || file.isDirectory()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //Determinar el tipo de contenido
        String mimeType = getServletContext().getMimeType(realPath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);

        //Leer el archivo del disco y mandarlo al response
        try {
            Files.copy(file.toPath(), response.getOutputStream());
        } catch (IOException e) {
            System.err.println("Error al servir imagen: " + e.getMessage());
        }
    }
}
