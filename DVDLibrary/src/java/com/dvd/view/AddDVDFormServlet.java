/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.view;

import com.dvd.model.DVDItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddDVDFormServlet", urlPatterns = {"/add_dvd.view"})
public class AddDVDFormServlet extends HttpServlet {

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
        
            // Retrieve the errorMsgs attribute from the request object
           List<String> errorMsgs = (List<String>) request.getAttribute("errorMsgs");  
           
           // If errorMsgs is not null, display the error messages
            if (errorMsgs != null) {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Error</h1>");
                out.println("<p>The following errors occurred:</p>");
                out.println("<ul>");
                for (String errorMsg : errorMsgs) {
                    out.println("<li>" + errorMsg + "</li>");
                }
                out.println("</ul>");
                out.println("</body>");
                out.println("</html>");
            }
      
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>DVD library Application: Add DVD Form</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Add DVD</h1>");
            out.println("<form action='add_dvd.do' method='POST'>");
            out.println("Title: <input type='text' name='title'> <br/> <br/>");
            out.println("Year: <input type='text' name='year'> <br/> <br/>");
            out.println("Genre: <select name='genre'>");
            out.println("<option value='Sci-Fi'>Sci-Fi</option>");
            out.println("<option value='Drama'>Drama</option>");
            out.println("<option value='Comedy'>Comedy</option>");
            out.println("</select>");
            out.println("or new genre: <input type='text' name='newGenre'> <br/> <br/>");
            out.println("<input type='submit'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            out.close();
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
        // retrieve the errorMsgs attribute from the request scope
    List<String> errorMsgs = (List<String>) request.getAttribute("errorMsgs");
    
    // retrieve the user's entered data
    String title = request.getParameter("title");
    String year = request.getParameter("year");
    String genre = request.getParameter("genre");
    String newGenre = request.getParameter("newGenre");

    // call the processRequest method to process the form data
    processRequest(request, response);

    // set the content type to HTML
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    // display the form header
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Add DVD Form</title>");
    out.println("</head>");
    out.println("<body>");

    // display the error messages if any
    if (errorMsgs != null) {
        out.println("<div>");
        out.println("<h2>Error Messages:</h2>");
        out.println("<ul>");
        for (String errorMsg : errorMsgs) {
            out.println("<li>" + errorMsg + "</li>");
        }
        out.println("</ul>");
        out.println("</div>");
    }

    // display the form with repopulated fields
//    out.println("<form action='AddDVDServlet' method='post'>");
//    out.println("Title: <input type='text' name='title' value='" + title + "' /><br>");
//    out.println("Year: <input type='text' name='year' value='" + year + "' /><br>");
//    out.println("Genre: <select name='genre'>");
//    out.println("<option value='Sci-Fi' " + (genre.equals("Sci-Fi") ? "selected" : "") + ">Sci-Fi</option>");
//    out.println("<option value='Drama' " + (genre.equals("Drama") ? "selected" : "") + ">Drama</option>");
//    out.println("<option value='Comedy' " + (genre.equals("Comedy") ? "selected" : "") + ">Comedy</option>");
//    out.println("</select>");
//    out.println("or new genre: <input type='text' name='newGenre' value='" + newGenre + "' /><br>");
//    out.println("<input type='submit' value='Add DVD'>");
//    out.println("</form>");
//    out.println("</body>");
//    out.println("</html>");

      // Display the title field
out.print(" Title: <input type='text' name='title' ");
if(title == null) {
title = "";
}
out.println("value = '" + title + "' /> <br/>");
// Display the year field
out.print(" Year: <input type='text' name='year' ");
if(year == null) {
year = "";
}
out.println("value = '" + year + "' /> <br/>");

String genre_list = "Sci-Fi,Drama,Comedy";
String [] genres = null;
genres = genre_list.split(",");
//Repopulate the Genre drop-down menu
out.println(" Genre: <select name='genre'>");
for ( int i = 0; i < genres.length; i++ ) {
out.print("<option value='" + genres[i] + "'");
if( genre.equals(genres[i])) {
out.print(" selected");
}
out.println("> " + genres[i] + "</option>");
}
out.println("</select>");

out.println(" or new genre: <input type='text' name='newGenre' ");
if(newGenre == null) {
newGenre = "";
}
out.println("value = '" + newGenre + "'/> <br/>");
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
