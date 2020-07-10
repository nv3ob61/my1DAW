/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.io.Serializable;

/**
 *
 * @author  
 
 */
public class Cafetera implements Serializable {

    private static final long serialVersionUID = 2L;

    public static final int CAFE = 0;
    public static final int TE = 1;
    public static final int BATIDO = 2;
    public static final int CON_AZUCAR = 4;
    public static final int SIN_AZUCAR = 8;
    
    //Servicio Predeterminado
    public static final int DEF_SERVICIO = CAFE + SIN_AZUCAR;
    
    //Atributos
    private int servicio;
    
    //Constructores
    public Cafetera() {
        servicio = DEF_SERVICIO;
    }
    
    //Constructor con todos los atributos
    public Cafetera(int servicio) {
        //Aquí validamos que servicio coja los valores de las constantes
        if(servicio == CAFE + SIN_AZUCAR|| 
                servicio == CAFE + CON_AZUCAR ||
                servicio == TE + SIN_AZUCAR ||
                servicio == TE + CON_AZUCAR ||
                servicio == BATIDO) {
        this.servicio = servicio;            
        } else {
           this.servicio = DEF_SERVICIO; 
        }               
    }
       
    //ACCESORES
    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        //Aquí validamos que servicio coja los valores de las constantes.
        //No hay else como en el constructor porque si se valida y no está
        //en el rango ya tiene un valor por defecto: CAFE + SIN_AZUCAR;
        if(servicio == CAFE + SIN_AZUCAR|| 
                servicio == CAFE + CON_AZUCAR ||
                servicio == TE + SIN_AZUCAR ||
                servicio == TE + CON_AZUCAR ||
                servicio == BATIDO) {
        this.servicio = servicio;            
        } 
    }
}
