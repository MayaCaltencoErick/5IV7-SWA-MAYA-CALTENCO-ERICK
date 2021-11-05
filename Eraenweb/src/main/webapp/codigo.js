/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validar(){
    

	
        //document.formulario.target = "null";
        document.formulario.action = "Cifrar";
	var primo = document.getElementById("primo");
        var texto = document.getElementById("hola");
        
       
            if(texto.value===""){
                alert("ingrese un texto a cifrar por favor");
                return false;
            }
            else{
                return true;
            }
            return true;
        
        
}

function validar2(){
    
    
    document.formulario.action = "Descifrar";
    var primo1 = document.getElementById("primo1");
    var texto = document.getElementById("hola");
    var primo2 = document.getElementById("primo2");    
       
            if(texto.value===""){
                alert("ingrese un texto a cifrar por favor");
                return false;
            }
            else{
                if(primo1.value < 1 || primo1.value.length > 4){
                    alert("Ingresa un número válido en primo 1 por favor (de 1 a 4 dígitos, naturales)")
                    return false;
                }else{
                    if(primo2.value < 1 || primo2.value.length > 4){
                       alert("Ingresa un número válido en primo 2 por favor (de 1 a 4 dígitos, naturales)")
                    return false; 
                    }else{
                        
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
}




