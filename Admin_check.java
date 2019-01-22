package controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Admin;

public class Admin_check extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List errorMsgs1=new LinkedList();
        String orna=request.getParameter("orna");
        String qua=request.getParameter("qua");
        int qua1=0;
        if(orna.length()==0) {
            errorMsgs1.add("Please enter the name of ornaments or accessories");
        }

        try {
            qua1=Integer.parseInt(qua);
        }
        catch(Exception e) {
            errorMsgs1.add("Quanitity must be an integer");
        }


        if(errorMsgs1.isEmpty()) {
            Admin k=new Admin(orna, qua1);
            k.addAdmin(orna, qua1);
            request.setAttribute("k",k);
            RequestDispatcher r=request.getRequestDispatcher("Admin_Success");
            r.forward(request, response);
        }
        else {
            request.setAttribute("errorMsgs1", errorMsgs1);
              RequestDispatcher r=request.getRequestDispatcher("Admin_Failure");
              r.forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
