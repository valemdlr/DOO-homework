/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ComentariosDAO;
import models.ComentariosPOJO;
import utils.Log;

/**
 *
 * @author SEG11
 */
public class ComentariosControladors extends HttpServlet {

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
        String action = request.getParameter("action");
        String nombre = request.getParameter("nombre");
        String comentario = request.getParameter("comentario");
        HttpSession session =request.getSession();
        ComentariosDAO dao = new ComentariosDAO();
        ComentariosPOJO pojo = new ComentariosPOJO();
        pojo.setNombre(nombre);
        pojo.setComentario(comentario);
        Log log = Log.getInstance("C:\\Users\\Valeria\\Downloads\\DOO\\laboratorio9\\Log.txt");
        log.write(nombre);
        if(action.equals("comentar")){
            dao.insertar(pojo);
            response.sendRedirect("buscar.jsp");
        } else {
            if(action.equals("buscar")){
                ArrayList <ComentariosPOJO> comentarios = dao.buscar(pojo);
                session.setAttribute("comentarios", comentarios);
                response.sendRedirect("buscar.jsp");
            } else {
                if(!"comentar".equals(action) & !"buscar".equals(action)){
                response.sendRedirect("error.jsp");
                }
            }
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
