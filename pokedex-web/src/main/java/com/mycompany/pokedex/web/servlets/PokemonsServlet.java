package com.mycompany.pokedex.web.servlets;
import com.mycompany.pokedex.web.servlets.dominio.PokemonDTO;
import com.mycompany.pokedex.web.servlets.persistencia.IPokemonsDAO;
import com.mycompany.pokedex.web.servlets.persistencia.PokemonsDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
/**
 * @author Yuri Germán García López - 252583
 */
@WebServlet(name = "PokemonsServlets", urlPatterns = {"/pokes"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 10,
    maxRequestSize = 1024 * 1024 * 20
)
public class PokemonsServlet extends HttpServlet {

    private final String NUMERO_REGEX = "\\d{3}";
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nombre = request.getParameter("nombre");
        String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        Part imagen = request.getPart("imagen");
        String mensajesError = "";
        
        if(nombre == null || nombre.isBlank()){
            mensajesError += "El nombre del pokémon está vacío";
        }
        if(numero == null || numero.isBlank()){
            mensajesError += "El número del pokémon está vacío";
        }
        if(tipo == null || tipo.isBlank()){
            mensajesError += "El tipo del pokémon está vacío";
        }
        if(imagen == null || imagen.getSize() == 0){
            mensajesError += "La imagen del pokémon está vacía";
        }
        if(numero != null && !numero.matches(NUMERO_REGEX)){
            mensajesError += "El número del pokémon no coincide con el formato especificado";
        }
        if(!mensajesError.isBlank()){
            request.setAttribute("errores", mensajesError);
            this.getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(request, response);
        } else {
            String nombreArchivo = imagen.getSubmittedFileName();
            String rutaDestino = request.getServletContext().getRealPath("/imgs/" + nombreArchivo);
            imagen.write(rutaDestino);
            String urlImagen = "imgs/" + nombreArchivo;

            PokemonDTO nuevoPokemon = new PokemonDTO(nombre, Integer.parseInt(numero), tipo, urlImagen);

            IPokemonsDAO pokemonsDAO = new PokemonsDAO();
            pokemonsDAO.agregarPokemon(nuevoPokemon);
            
            response.sendRedirect(request.getContextPath() + "/pokedex");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
