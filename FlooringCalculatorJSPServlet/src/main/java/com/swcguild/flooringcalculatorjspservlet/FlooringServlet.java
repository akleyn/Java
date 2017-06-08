/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringcalculatorjspservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author softwareguild
 */
@WebServlet(name = "FlooringServlet", urlPatterns = {"/FlooringServlet"})
public class FlooringServlet extends HttpServlet {

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

        double totalCost = 0;
        double workRate = 20;
        double laborRate = 86;
        double laborTime = 0;
        double updatedLaborTime = 0;
        double laborCost = 0;
        double remainder = 0;
        double additionalTime = 0;

        String input = request.getParameter("width");
        double width = Double.parseDouble(input);
        String input2 = request.getParameter("length");
        double length = Double.parseDouble(input2);
        String input3 = request.getParameter("materialCost");
        double materialCost = Double.parseDouble(input3);

        double flooringCost = width * length * materialCost;

        laborTime = ((length * width) / 20);
        if (laborTime % .25 != 0) {
            remainder = laborTime % .25;
            laborTime -= remainder;
            if (remainder > 0 && remainder < .25) {
                remainder = .25;
            } else if (remainder > .25 && remainder < .50) {
                remainder = .50;
            } else if (remainder > .50 && remainder < .75) {
                remainder = .75;
            } else if (remainder > .75 && remainder < 1) {
                remainder = 1;
            } else{
                remainder = remainder;
            }
            
            updatedLaborTime = remainder + laborTime;

        } else {
            updatedLaborTime = laborTime;
        }

        laborCost = laborRate * updatedLaborTime;

        totalCost = laborCost + flooringCost;

        request.setAttribute("width", width);
        request.setAttribute("length", length);
        request.setAttribute("materialCost", materialCost);
        request.setAttribute("flooringCost", flooringCost);
        request.setAttribute("remainder", remainder);
        request.setAttribute("updatedLaborTime", updatedLaborTime);
        request.setAttribute("laborTime", laborTime);
        request.setAttribute("laborCost", laborCost);
        request.setAttribute("totalCost", totalCost);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
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
