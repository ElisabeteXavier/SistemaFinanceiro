
package br.edu.iftm.jsf.Servlet;

import br.edu.iftm.jsf.entity.Produto;
import br.edu.iftm.jsf.logic.ProdutoLogic;
import br.edu.iftm.jsf.util.MimeTypes;
import org.apache.tika.Tika;
import java.io.IOException;
import java.io.OutputStream;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ImagemServlet", urlPatterns = {"/imagem"})
public class ImagemServlet extends HttpServlet {

    @Inject
    private ProdutoLogic logic;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = null;
        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Produto produto  = logic.buscarPorId(id);
        if(produto == null || produto.getFotoUpload()== null  || "".equals(produto.getFotoUpload())) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        byte[] foto = produto.getFotoUpload();
        Tika tk = new Tika();
        String extencao = tk.detect(foto);
        String mimeType = MimeTypes.getMimeType(extencao);
        response.setContentType(mimeType);
        response.setContentLength(foto.length);
        
        try (OutputStream out = response.getOutputStream()) {
            out.write(foto);
            out.flush();
        }
        
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
