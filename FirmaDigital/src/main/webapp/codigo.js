/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cargarArchivo(elemento){
    
var file = elemento.files[0];
	var objHidden = document.formulario.nombre;
        document.formulario.target = "null";
        document.formulario.action = "hola";
	objHidden.value = file.name;
        
}



function descifrar(elemento){

var file = elemento.files[0];
	var objHidden = document.formulario.nombre;
        //document.formulario.target = "null";
        document.formulario.action = "descifrar";
	objHidden.value = file.name;
        
}

function validar(){
     var nombre = document.getElementById("hola");
     
     
    var allowedExtensions = /(.txt)$/i;
        if(!allowedExtensions.exec(nombre.value)){
        alert('Por favor sólo suba archivos.txt.');
        return false;
    }else{
	
	alert("proceso terminado");
        return true;
    }    
    return true;
     
}
function validar2(){
     var nombre = document.getElementById("hola");
     var llave = document.getElementById("hola2");
     var llave2 = document.getElementById("hola3");
     var firma = document.getElementById("hola4");
     var allowedExtensions2 = /(.key)$/i;
     if(!allowedExtensions2.exec(llave.value)||!allowedExtensions2.exec(llave2.value)){
         alert("La llave debe de ser un archivo.key");
         return false;
     }else{
    var allowedExtensions = /(.cifrado)$/i;
        if(!allowedExtensions.exec(nombre.value)){
        alert('Por favor sólo suba archivos.cifrado.');
        return false;
    }else{
	var allowedExtensions3 = /(.txt)$/i;
        if(!allowedExtensions3.exec(firma.value)){
        alert('La firma debe ser un archivo de texto');
        return false;
    }else{
        alert("proceso terminado");
        return true;
        }
        return true;
    }
	
        return true;
    }    
    return true;
     }

