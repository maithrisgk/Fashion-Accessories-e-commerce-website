/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.*;
import java.net.*;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Admin
 */
public class Login_check extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    
    List errorMsgs2=new LinkedList();
        String name=request.getParameter("t1");
        String password=request.getParameter("t2");
        
      
        if(name.length()==0) {
            errorMsgs2.add("Please enter your username");
        }

       
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
    
    
    
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
