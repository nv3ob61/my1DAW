/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author nv3ob61
 */
public class UtilesEntrada {

    // Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final String PACO = "---";
    public static final String PACO_LONG = "-----------------------------";

    public static final double obtener(String msgUser, String msgErr) {
        //Entrada de teclado
        double numero = 0;
        boolean isOk = true;
        //Bucle externo para que acabe con un valor válido y no se rompa el progr.
        do {
            try {
                //Entrada de datos
                System.out.printf(msgUser);
                numero = SCN.nextDouble();
                //Si el dato introducido es bueno, sale del loop
                isOk = false;
            } catch (Exception e) {
                System.out.println(PACO);
                System.out.println(msgErr);
                System.out.println(PACO);
            } finally {
                //borra el buffer, si no entra en bucle sin fin.
                SCN.nextLine();
            }
        } while (isOk);
        // DEVUELVE EL NUMERO
        return numero;
    }

    public static final String obtenerString() {
        String str;
        str = SCN.nextLine();

        return str;
    }
    
    
//método para el dowhile final de salida del programa
    public static final String deseaCont() {
        String respuesta;
        //dowhile para introducir otro
        do {
            System.out.println("\n¿Desea introducir otro cliente? (si o no):");
            respuesta = UtilesEntrada.obtenerString();
            respuesta = respuesta.toLowerCase();
        } while (!respuesta.equals("si") && !respuesta.equals("no"));
        return respuesta;
    }
}
