<%-- 
    Document   : resultado
    Created on : 4/11/2021, 10:03:17 PM
    Author     : PRIDE OTTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.math.BigInteger"%>

<!DOCTYPE html>
<html>
    <%HttpSession sesionuok = request.getSession(true);
    String texto = (String)sesionuok.getAttribute("Resultado");
    %>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="./codigo.js"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body background="imagen/1262530 (1).png">
        
        <div class="titulo"><h1>¡Descifrado Exitoso!</h1></div>
    <br>
    <br>
    <br>
    <div class="archivo">
        
            <table>
            <tr>
            <td>Texto Descifrado:</td><td><%out.println(texto); %></td>
            </tr>
            
            </table>
            <input type="hidden" name="nombre" value="" />
            
    <iframe name="null" style="display: none;"></iframe></div>
    <div class="botones">
    
    <a href="index.jsp">Cifrar</a></div>
    </body>
</html>
