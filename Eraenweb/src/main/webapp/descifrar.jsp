<%-- 
    Document   : descifrar
    Created on : 4/11/2021, 05:03:26 PM
    Author     : PRIDE OTTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="./codigo.js"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body background="imagen/1262530 (1).png">
    
    <div class="container">
    <header></header>
    <div class="titulo"><h1>Descifrar</h1></div>
    <br>
    <br>
    <br>
    <div class="archivo">
        <form name="formulario" method="post"  onsubmit="return validar2()" >
            <table>
            <tr>
            <td>Texto a descifrar</td><td><input type="text"  name="texto" id="hola" /></td>
            </tr>
            <tr>
            <td>Primo 1</td><td><input type="number"  name="primo1" id="primo1" /></td>
            </tr>
            <tr>
            <td>Primo 2</td><td><input type="number"  name="primo2" id="primo2" /></td>
            </tr>
            <tr>
            <td>clave d</td><td><input type="number"  name="d" id="d" /></td>
            </tr>
            <tr>
            <td colspan="2"><input type="submit" value="descifrar" class="btn" ></td>
            </tr>
            </table>
            <input type="hidden" name="nombre" value="" />
            </form>
    <iframe name="null" style="display: none;"></iframe></div>
    <div class="botones">
    
    <a href="index.jsp">Cifrar</a></div></div>
       <div ><h2 class="hola3">Maya Caltenco Erick Sebastian</h2></div> 
</body>
</html>
