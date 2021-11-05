/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.RSA;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author PRIDE OTTER
 */
public class Cifrar extends HttpServlet {

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
            int tamano;
            
            String texto = request.getParameter("texto");
            System.out.println(texto);
            
            RSA cifrado= new RSA(10);
            System.out.println(cifrado.getP());
            System.out.println(cifrado.getQ());
            System.out.println(cifrado.getTamPrimo());
            byte[] digitos = texto.getBytes();
            BigInteger[] resultado = new BigInteger[digitos.length];
            resultado = cifrado.encripta(texto);
            System.out.println(Arrays.toString(resultado));
            BigInteger n = cifrado.getN();
            System.out.println(n);
            BigInteger p = cifrado.getP();
            BigInteger q = cifrado.getQ();
            BigInteger d = cifrado.getD();
            HttpSession hola = request.getSession(); 
            String descifrado = cifrado.desencripta(resultado, d);
            System.out.println(descifrado);
            System.out.println(d);
            hola.setAttribute("cifrado", Arrays.toString(resultado));  
            hola.setAttribute("Primo 1", p);
            hola.setAttribute("Primo 2", q);
            hola.setAttribute("d", d);
            response.sendRedirect("inicio.jsp"); 
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cifrar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cifrar at " + texto + Arrays.toString(resultado)+ "</h1>");
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
