<%-- 
    Document   : index
    Created on : 2/11/2021, 01:38:30 PM
    Author     : PRIDE OTTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
    <div class="titulo"><h1>Cifrar</h1></div>
    <br>
    <br>
    <br>
    <div class="archivo">
        <form name="formulario" method="post"  onsubmit="return validar()" >
            <table>
            <tr>
            <td>Texto a cifrar</td><td><input type="text"  name="texto" id="hola" /></td>
            </tr>
            
            <tr>
            <td colspan="2"><input type="submit" value="Cifrar" class="btn" ></td>
            </tr>
            </table>
            <input type="hidden" name="nombre" value="" />
            </form>
    <iframe name="null" style="display: none;"></iframe></div>
    <div class="botones">
    
    <a href="descifrar.jsp">Descifrar</a></div></div>
        <div ><h2 class="hola3">Maya Caltenco Erick Sebastian</h2></div>
</body>
</html>
