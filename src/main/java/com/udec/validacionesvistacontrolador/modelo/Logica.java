/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.validacionesvistacontrolador.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Julian esteban vallejo galindo
 */
public class Logica {
    /**
     * Metodo que llama a todos los metodos de validaciones previamente creadas
     * @param palabra
     * @param tamano
     * @param correo
     * @param valor
     * @param fecha
     * @param moneda
     * @return 
     */
    public String validarTodo(String palabra, String tamano, String correo, String valor, String fecha, String moneda){
        if(validarVacio(palabra, tamano, correo, valor, fecha, moneda)){
            if(validarTamano(tamano)){
                if(validarCorreo(correo)){
                    if(validarValores(valor)){
                        if(validarFecha(fecha)){
                            if(validarMoneda(moneda)){ 
                            }
                            else{
                                return "Debe empezar por el signo pesos ($)";
                            }
                        }
                        else{
                            return "El formato es dd/mm/yyyy";
                        }
                    }
                    else{
                        return "El valor debe ser mayor a -10 y menor a 10";
                    }
                }
                else{
                   return "Correo invalido. Ejemplo: abc@gmail.com"; 
                }
            }
            else{
                return "La longitud debe estar entre (5 y  10)";
            }
        }
        else{
            return "Llenar campo vacio";
        }
        return "validaciones completas";
    }
    /**
     * Validacion campos vacios
     * @param palabra
     * @param tamano
     * @param correo
     * @param valor
     * @param fecha
     * @param moneda
     * @return 
     */
    public boolean validarVacio(String palabra, String tamano, String correo, String valor,String fecha, String moneda ){
        try{
            if(palabra.length()==0 || tamano.length() ==0 || correo.length() ==0 || valor.length() ==0 ||fecha.length() ==0 ||moneda.length() ==0 ){
                return false;
        }
        }catch(Exception e){
            if(e.getMessage().equals("NullPointerExeption")){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Metodo que Valida la longitud
     * @param palabra
     * @return 
     */
    public boolean validarTamano(String palabra) {
        if (palabra.length() < 5) {
            return false;
        }
        if (palabra.length() >= 10) {
            return false;
        }
        return true;
    }
    
    /**
     * Metodo que valida el correo
     * @param correo
     * @return 
     */
    public boolean validarCorreo(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Metodo que valida e Rango
     * @param valor
     * @return 
     */
    public boolean validarValores(String valor) {
        if (Integer.parseInt(valor) < -10 || Integer.parseInt(valor) > 10) {
            return false;
        }
        return true;
    }
    
    /**
     * Metodo que valida la fecha
     * @param fecha
     * @return 
     */
    public boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    } 
    
    /**
     * Metodo que valida la Moneda
     * @param moneda
     * @return 
     */
    public boolean validarMoneda(String moneda){
        if(moneda.charAt(0)!= '$'){
            return false;
        }
        return true;
    }
}
