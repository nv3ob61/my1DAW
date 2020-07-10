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

    public static final String MSG_USR = "Introducir número ....: ";
    public static final String MSG_ERROR = "ERROR: Entrada incorrecta";
    public static final String MSG_OUT = "Número introducido ...: ";
    public static final String PACO = "---";
    public static final String PACO_LONG = "-------------------";

    public final static double obtener() {
        //Validamos el entero
        double numero = 0;
        boolean isOk = false;
        do {
            try {
                System.out.printf("%s", MSG_USR);
                numero = SCN.nextDouble();
                isOk = true;
            } catch (Exception e) {
                System.out.println(MSG_ERROR);
                System.out.println(PACO);
            } finally {
                SCN.nextLine();
            }
        } while (!isOk);
        return numero;
    }

}
