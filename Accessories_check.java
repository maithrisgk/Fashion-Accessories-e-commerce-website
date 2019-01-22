

package controller;

import model.Ornaments;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Accessories_check extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List errorMsgs=new LinkedList();
        String name=request.getParameter("name");
        String num1=request.getParameter("num");
        String address=request.getParameter("address");
        int num=0;
        if(name.length()==0) {
            errorMsgs.add("Please enter a title");
        }

        try {
            num=Integer.parseInt(num1);
        }
        catch(Exception e) {
            errorMsgs.add("Number must be an integer");
        }

        /*int b=num1.length();
        if(b!=10) {
        errorMsgs.add("Enter an 10 digit number");
        }*/

        if(address.length()== 0) {
            errorMsgs.add("Enter a valid addrees in the textbox");
        }


        if(errorMsgs.isEmpty()) {
            Ornaments o=new Ornaments(name, num, address);
            o.addOrnament(name, num, address);
            request.setAttribute("o",o);
            RequestDispatcher r=request.getRequestDispatcher("Accessories_Success");
            r.forward(request, response);
        }
        else {
            request.setAttribute("errorMsgs", errorMsgs);
              RequestDispatcher r=request.getRequestDispatcher("Accessories_Failure");
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
