/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.validacionesvistacontrolador.controlador;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author julian esteban vallejo galindo
 */
@ManagedBean(name = "validacionControlador")
@ViewScoped
@Dependent

/**
 * Clase ValidacionControlador 
 */
public class ValidacionControlador implements Serializable {

    private String mensajeVacio = "";
    private String mensajeTamaño = "";
    private String mensajeCorreo = "";
    private String mensajeValores = "";
    private String mensajeFechas = "";
    private String mensajeMoneda = "";
    private String mensajeError = "";

    /**
     * Metodo el cual llama a la logica e invoca las validacion de vacio
     * 
     * @param context
     * @param toValidate
     * @param value
     */
    public void validarVacio(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (texto.equals("")) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Campo vacio"));
        }
    }

    /**
     * Metodo el cual llama a la logica e invoca las validacion de Tamaño
     * @param context
     * @param toValidate
     * @param value 
     */
    public void validarTamano(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equals("")) {
            if (texto.length() < 5 || texto.length() > 10) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage("la longitud debe estar entre(5 y 10caracteres)"));
            } else {
                
            }
        } else {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Campo vacio"));
        }
    }

    /**
     *  Metodo el cual llama a la logica e invoca las validacion de correo
     * @param context
     * @param toValidate
     * @param value 
     */
    public void validarEmail(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equals("")) {
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(texto);
            if (mather.find() == false) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage("Correo invalido"));
            }
        } else {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Campo vacio"));
        }
    }

    /**
     * Metodo el cual llama a la logica e invoca las validacion de valores
     * @param context
     * @param toValidate
     * @param value 
     */
    public void validarValores(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equals("")) {
            if (Integer.parseInt(texto) < -10 || Integer.parseInt(texto) > 10) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage("El valor debe estar entre -10 y 10"));
            }
        } else {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Campo vacio"));
        }
    }

    /**
     * Metodo el cual llama a la logica e invoca las validacion de fecha
     * @param context
     * @param toValidate
     * @param value 
     */
    public void validarFecha(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equals("")) {
            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                formatoFecha.setLenient(false);
                formatoFecha.parse(texto);
            } catch (ParseException e) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage("El formato es dd/MM/AAAA"));
            }
        } else {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Campo vacio"));
        }
    }

    /**
     * Metodo el cual llama a la logica e invoca las validacion de moneda
     * @param context
     * @param toValidate
     * @param value 
     */
    public void validarMoneda(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equals("")) {
            if (texto.charAt(0) != '$') {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage("Debe empezar por el signo pesos ($)"));
            }
        } else {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Campo vacio"));
        }
    }

    /**
     * getters y setters
     * @return 
     */
    public String getMensajeVacio() {
        return mensajeVacio;
    }

    public void setMensajeVacio(String mensajeVacio) {
        this.mensajeVacio = mensajeVacio;
    }

    public String getMensajeTamaño() {
        return mensajeTamaño;
    }

    public void setMensajeTamaño(String mensajeTamaño) {
        this.mensajeTamaño = mensajeTamaño;
    }

    public String getMensajeCorreo() {
        return mensajeCorreo;
    }

    public void setMensajeCorreo(String mensajeCorreo) {
        this.mensajeCorreo = mensajeCorreo;
    }

    public String getMensajeValores() {
        return mensajeValores;
    }

    public void setMensajeValores(String mensajeValores) {
        this.mensajeValores = mensajeValores;
    }

    public String getMensajeFechas() {
        return mensajeFechas;
    }

    public void setMensajeFechas(String mensajeFechas) {
        this.mensajeFechas = mensajeFechas;
    }

    public String getMensajeMoneda() {
        return mensajeMoneda;
    }

    public void setMensajeMoneda(String mensajeMoneda) {
        this.mensajeMoneda = mensajeMoneda;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

}

