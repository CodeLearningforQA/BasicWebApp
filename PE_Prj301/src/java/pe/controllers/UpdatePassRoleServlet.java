/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.model.registration.RegistrationDAO;

/**
 *
 * @author Be Keo
 */
@WebServlet(name = "UpdatePassRoleServlet", urlPatterns = {"/UpdatePassRoleServlet"})
public class UpdatePassRoleServlet extends HttpServlet {
    private final String ERROR_PAGE = "error.html";
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url= ERROR_PAGE;
        try {
            //1. Get user info
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            boolean role = false;
            String admin = request.getParameter("chkAdmin");
            if (admin != null) {
                role = true;
            }
            String lastSearchValue = request.getParameter("lastSearchValue");
            //2. Call method of DAO
            //2.1 Initialized DAO
            RegistrationDAO dao = new RegistrationDAO();
            //2.2 Call method
            boolean result = dao.updatePassRoleAccount(username, password, role);

            //3. Controller process
             if (result) {
                //refresh (call previous function
                //use URL REWRITING
                url = "MainController"
                        + "?action=Search"
                        + "&txtSearchValue=" + lastSearchValue;
            }
            
        } catch(SQLException e){
            log("UpdatePassRoleServlet _ SQL" + e.getMessage());
        } catch (ClassNotFoundException e){
            log("UpdatePassRoleServlet _ ClassNotFound: " + e.getMessage());
        } finally {
            response.sendRedirect(url);
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
