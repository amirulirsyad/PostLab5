/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import com.dvd.model.DVDItem;
/**
 *
 * @author Admin
 */
public class ListLibraryServlet extends HttpServlet {

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
        
        List dvds = new ArrayList();
        dvds.add(new DVDItem("Aquaman","2019","Sci-Fi"));
        dvds.add(new DVDItem("Robin Hood","2018","Action"));
        dvds.add(new DVDItem("The Grinch","2018","Comedy"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
            out.print("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListLibraryServlet</title>");
            out.println("<body bgcolor='white'>");
            out.println("You currently have <b>"+dvds.size()+"</b> DVD in your collection:</br>");
            out.println("<table border='1' cellspacing='0' cellpadding='5'>");
            out.println("<tr>");
            out.println("   <th>TITLE</th>");
            out.println("   <th>YEAR</th>");
            out.println("   <th>GENRE</th>");
            out.println("</tr>");
            
            Iterator it = dvds.iterator();
            while(it.hasNext()){
                DVDItem item = (DVDItem) it.next();
                out.println("<tr>");
                out.println("   <td>"+item.getTitle()+"</td>");
                out.println("   <td>"+item.getYear()+"</td>");
                out.println("   <td>"+item.getGenre()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("End of list...");
            out.println("</body>"); 
            out.println("</html>");
            out.close();
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
