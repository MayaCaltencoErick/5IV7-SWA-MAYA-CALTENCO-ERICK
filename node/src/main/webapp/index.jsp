<%-- 
    Document   : sesion
    Created on : 18/11/2021, 11:26:37 AM
    Author     : PRIDE OTTER
--%>

<%@page import="modelo.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sesión</title>
    <link rel="stylesheet" href="css/style1.css">
</head>
<%
   
    HttpSession sesionusu = request.getSession(true);
    
    if(sesionusu.getAttribute("usuario")==null){
    %>
    
    
<body background="imagen\Pastry_Bread_Buns_Ear_botany_543572_1920x1080.jpg">
    <header>
        <section class="menu">
            
           
        </section>
    </header>
    <a href="iniciar.html" > <input type="button" value="Iniciar sesión" class="btn1"></a>
    <a href="registrar.html" > <input type="button" value="Registrar cuenta" class="btn2"></a>
    
</body>
    
    <%
    }else{
        usuario hola = (usuario)sesionusu.getAttribute("usuario");
       

    %>
<body background="imagen\Pastry_Bread_Buns_Ear_botany_543572_1920x1080.jpg">
    <header>
        <section class="menu">
            <h1 style="color: white">Ya has iniciado sesión <%=hola.getNombre()%></h1>
        </section>
    </header>
     
         <a href="pan.html" > <input type="button" value="Gestionar Panes" class="btn1"></a>
      
        
        <form name="formulario" method="post" action = "Cerrar">
         <input type="submit" value="Cerrar Sesión" class="btn2"> 
     </form>   
    
</body>
<%}%>
</html>
