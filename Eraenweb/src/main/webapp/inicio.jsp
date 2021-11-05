<%-- 
    Document   : inicio
    Created on : 3/11/2021, 08:11:00 PM
    Author     : PRIDE OTTER
--%>

<%@page import="java.math.BigInteger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%HttpSession sesionuok = request.getSession(true);
    String texto = (String)sesionuok.getAttribute("cifrado");
    BigInteger p = (BigInteger)sesionuok.getAttribute("Primo 1");
    BigInteger q = (BigInteger)sesionuok.getAttribute("Primo 2");
    BigInteger d = (BigInteger)sesionuok.getAttribute("d");
    System.out.println(p);%>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="./codigo.js"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body background="imagen/1262530 (1).png">
        
        <div class="titulo"><h1>¡Cifrado Exitoso!</h1></div>
    <br>
    <br>
    <br>
    <div class="archivo">
        
            <table>
            <tr>
            <td>Texto Cifrado(Copie los números dentro del corchete):</td><td><%out.println(texto); %></td>
            </tr>
            <tr>
            <td>Primo 1 :</td><td><%out.println(p); %></td>
            </tr>
            <tr>
            <td>Primo 2 :</td><td><%out.println(q); %></td>
            </tr>
            <tr>
            <td>Clave d :</td><td><%out.println(d); %></td>
            </tr>
            </table>
            <input type="hidden" name="nombre" value="" />
            
    <iframe name="null" style="display: none;"></iframe></div>
    <div class="botones">
    
    <a href="descifrar.jsp">Descifrar</a></div>
    </body>
</html>
