/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

/**
 *
 * @author nv3ob61
 */
public class UtilesContrato {

    public static final String PACO = "---";
    public static final String PACO_LONG = "-----------------------------";

    /*  método que pide el núm de contrato en formato xxx-xxxx donde 'x' son dígitos.
//No acepta otro separador que '-', a base de un for que recorre el string
    y comprueba uno a uno que son dígitos y si en la posicion 3 está el '-'  
    Usa el cont para verificar ambas condiciones sumando 1 al contador inicial
    que se reinicia cada vez que hace el loop porque la cuenta NO es válida.*/
    public static final String pideContrato() {
        String numeroContrato;
        int cont;

        do {
            cont = 0;
            System.out.println(PACO_LONG);
            System.out.printf("Introduce los dígitos del contrato %nen formato "
                    + "xxx-xxxx : ");
            numeroContrato = UtilesEntrada.obtenerString();

            if (numeroContrato.length() == 8) {
                for (int i = 0; i < 8; i++) {
                    if (i == 3) {
                        if (numeroContrato.charAt(i) != '-') {
                            cont++;
                        }
                    } else if (!Character.isDigit(numeroContrato.charAt(i))) {
                        cont++;
                    }
                }
            } else {
                System.out.println(PACO);
                System.out.println("ERROR: Núm contrato incorrecto");
                cont++;
            }
        } while (cont > 0);
        return numeroContrato;
    }

}
