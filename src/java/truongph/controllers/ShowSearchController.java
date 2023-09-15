/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongph.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import truongph.registration.RegistrationDTO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ShowSearchController", urlPatterns = {"/ShowSearchController"})
public class ShowSearchController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowSearchController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowSearchController at " + request.getContextPath() + "</h1>");
           

            List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");

            if (result != null) {
                out.print("<table border=\"1\">");
                out.print(" <thead>");
                out.print("<tr>");
                out.print("<th>STT</th>");
                out.print("<th>username</th>");
                out.print("<th>password</th>");
                out.print("<th>Họ Tên</th>");
                out.print("<th>Role</th>");
                out.print("</tr>");
                out.print("</thead>");
                out.print(" <tbody>");
                int count = 0;
                for (RegistrationDTO dto : result) {
                    out.print("<tr>");
                    out.print("<td>" + ++count + "</td>");
                    out.print("<td>" + dto.getUsername() + "</td>");
                    out.print("<td>" + dto.getPassword() + "</td>");
                    out.print("<td>" + dto.getLastname() + "</td>");
                    out.print("<td>" + dto.isRole() + "</td>");
                    out.print("</tr>");
                }
                out.print("</tbody>");
                out.print(" </table>");

            } else {
                out.println("<h2>Have no record</h2>");
            }

            out.println("</body>");
            out.println("</html>");
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
