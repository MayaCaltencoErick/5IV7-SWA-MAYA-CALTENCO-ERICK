<%-- 
    Document   : index
    Created on : 14/11/2021, 06:46:06 PM
    Author     : PRIDE OTTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%System.out.println("hola");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="./codigo.js"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body background="https://fondosmil.com/fondo/4603.jpg">
    
    <div class="container">
    <header></header>
    <div class="titulo"><h1>Firmar</h1></div>
    <br>
    <br>
    <br>
    <div class="archivo">
        <form name="formulario" method="post" enctype="multipart/form-data" >
            <table>
            <tr>
            <td>Seleccione Archivo</td><td><input type="file" onchange="cargarArchivo(this)" name="archivo" id="hola" /></td>
            </tr>
            <tr>
            <td colspan="2"><input type="submit" value="Cifrar" class="btn" onclick="return validar()"></td>
            </tr>
            </table>
            <input type="hidden" name="nombre" value="" />
            </form>
    <iframe name="null" style="display: none;"></iframe></div>
    <div class="botones">
    
    <a href="Descifrar.jsp">Descifrar</a></div></div>
        <div ><h2 class="hola3">Maya Caltenco Erick Sebastian y Lopez Sierra Mayra Fernanda</h2></div>
</body>
</html>
