package com.mycompany.pokedex.web.servlets;
import com.mycompany.pokedex.web.servlets.dominio.PokemonDTO;
import com.mycompany.pokedex.web.servlets.persistencia.IPokemonsDAO;
import com.mycompany.pokedex.web.servlets.persistencia.PokemonsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Yuri Germán García López - 252583
 */
@WebServlet(name = "Pokedex", urlPatterns = {"/pokedex"})
public class Pokedex extends HttpServlet {

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
        //LOGICA PARA RECUPERAR LOS POKEMONS DE UNA "BD"
        IPokemonsDAO pokemonsDAO = new PokemonsDAO();
        List<PokemonDTO> pokemonsNuevos = pokemonsDAO.obtenerNuevosPokemons();
        //inyectando los resultados en la petición para que se puedan acceder en la pagina
        request.setAttribute("pokes", pokemonsNuevos);
        //redirecciona a una pagina JSP inyectando
        //los datos del request y response
        this.getServletContext()
                .getRequestDispatcher("/pokemons.jsp")
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
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

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
