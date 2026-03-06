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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.model.registration.RegistrationDAO;

/**
 *
 * @author Be Keo
 */
@WebServlet(name = "StartUpServlet", urlPatterns = {"/StartUpServlet"})
public class StartUpServlet extends HttpServlet {

    private static final String LOGIN_PAGE = "login.html";
    private static final String SEARCH_PAGE = "search.jsp";

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
        String url = LOGIN_PAGE;
        try {
            //1.Check if cookies exist
            //1.1 Get all cookies
            Cookie[] cookies = request.getCookies();
            //1.2 Check if cookie exist
            if (cookies != null) {
                //Not first time
                //Take the lastest one
                Cookie newestCookie = cookies[cookies.length - 1];

                //2. Get username and password  from cookies (key-value of cookies)
                String username = newestCookie.getName();
                String password = newestCookie.getValue();
                //3. Call method of model
                //3.1 
                RegistrationDAO dao = new RegistrationDAO();
                //3.2 Call method of DAO

                boolean result = dao.checkLogin(username, password);
                //4. Controller process result
                if (result) {
                    url = SEARCH_PAGE;
                }
            }
        } catch (SQLException e) {
            log("StartUpServlet _ SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            log("StartUpServlet _ ClassNotFound: " + e.getMessage());
        } finally {
            //Since it already has cookies --> use sendRedirect or forward is the same
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
