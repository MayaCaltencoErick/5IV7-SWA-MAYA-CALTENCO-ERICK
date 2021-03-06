/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.RSA;

/**
 *
 * @author PRIDE OTTER
 */
public class Descifrar extends HttpServlet {

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
            String letra="";
            String texto = request.getParameter("texto");
            System.out.println(texto);
            BigInteger primo1= new BigInteger(request.getParameter("primo1"));
            BigInteger primo2= new BigInteger(request.getParameter("primo2"));
            BigInteger d= new BigInteger(request.getParameter("d"));
            RSA cifradoRSA = new RSA(primo1, primo2, 10); 
             StringTokenizer st=new StringTokenizer(texto);
             System.out.println(st);
              BigInteger[] textoCifrado = new BigInteger[st.countTokens()];
                  
            for(int i=0;i<textoCifrado.length;i++){
            letra = st.nextToken();
            textoCifrado[i]=new BigInteger(letra);
            }
            
           System.out.println(Arrays.toString(textoCifrado));
           
           String resultado = cifradoRSA.desencripta(textoCifrado, d);
           HttpSession hola = request.getSession(true);
           
           System.out.println(resultado);
           BigInteger n = cifradoRSA.getN();
            System.out.println(n);
            BigInteger p = cifradoRSA.getP();
            BigInteger a = cifradoRSA.getD();
            System.out.println(d);
            System.out.println(p);
             hola.setAttribute("Resultado", resultado);
            response.sendRedirect("resultado.jsp");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Descifrar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Descifrar at " + texto + primo1+ primo2+ resultado+"</h1>");
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
