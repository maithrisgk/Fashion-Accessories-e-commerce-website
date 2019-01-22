/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Reg_new;
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
public class new_check extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    List errorMsgs3=new LinkedList();
        String name=request.getParameter("name");
        String phonenumber=request.getParameter("num");
        String city=request.getParameter("city");
        String username=request.getParameter("uname");
        String password=request.getParameter("password");
        int phonenumber1=0;
       if(name.length()==0) {
            errorMsgs3.add("Please enter your first name");
        }

        try {
            phonenumber1=Integer.parseInt(phonenumber);
        }
        catch(Exception e) {
            errorMsgs3.add("Number must be an integer");
        }

        if(city.length()== 0) {
            errorMsgs3.add("Enter your current city");
        }
        if(username.length()==0){
            errorMsgs3.add("Enter a username for you to create an account in MAISAK");
            
        }
        if(password.length()==0){
            errorMsgs3.add("You need a password for logging into MAISAK");
            
        }
        if(errorMsgs3.isEmpty()) {
            Reg_new rn=new Reg_new(name, phonenumber1, city,username,password);
            rn.addRegister(name, phonenumber1, city,username,password);
            request.setAttribute("rn",rn);
            RequestDispatcher r=request.getRequestDispatcher("Login_success");
            r.forward(request, response);
        }
        else {
            request.setAttribute("errorMsgs", errorMsgs3);
              RequestDispatcher r=request.getRequestDispatcher("Login_Failure");
              r.forward(request, response);
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
