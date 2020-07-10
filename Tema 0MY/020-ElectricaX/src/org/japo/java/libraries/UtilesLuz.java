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
public class UtilesLuz {

    public static final String MSG_FIJAKWS = "Introduzca el precio del kW/h: ";
    public static final String MSG_PIDEKWS = "Introduce los kW consumidos este mes: ";
    public static final String MSG_ERR = "ERROR: Entrada incorrecta.";
    public static final String PACO = "---";
    public static final String PACO_LONG = "-----------------------------";

    //método que fija el precio del kW.
    public static final double fijakWs() {
        double precioFijo;

        do {
            precioFijo = UtilesEntrada.obtener(MSG_FIJAKWS, MSG_ERR);
            if (precioFijo < 0) {
                System.out.println("ERROR: Aquí estamos para ganar dinero.");
                System.out.println(PACO);
            }
        } while (precioFijo < 0);
        return precioFijo;
    }

//método que pide la potencia mediante un switch.
    public static final double pidePotencia() {
        double potencia = 0;
        String pot;
        boolean checkPotencia;

        do {
            System.out.printf("%n   Pulsa A, B, C o D para elegir la potencia"
                    + " contratada%n");
            System.out.println("   -----------------------------------------"
                    + "-----------");
            System.out.println("A = 3.45kW\tB = 4.60kW\tC = 5.75kW\tD = 6.90kW"
                    + "\tE = 8.05KW");
            System.out.printf("%nIntroduce selección: ");

            pot = UtilesEntrada.obtenerString();
            pot = pot.toUpperCase();

            checkPotencia = !pot.equals("A") && !pot.equals("B")
                    && !pot.equals("C") && !pot.equals("D") && !pot.equals("E");

            if (checkPotencia) {
                System.out.println(PACO);
                System.out.println("ERROR: Potencia incorrecta");
                System.out.println(PACO);
            }

        } while (checkPotencia);

        switch (pot) {
            case "A":
                potencia = 3.45;
                break;
            case "B":
                potencia = 4.60;
                break;
            case "C":
                potencia = 5.75;
                break;
            case "D":
                potencia = 6.90;
                break;
            case "E":
                potencia = 8.05;
        }
        return potencia;
    }

//método para la introducción del consumo en kWs
    public static final double pidekWs() {
        double kWs;

        do {
            System.out.println(PACO_LONG);
            kWs = UtilesEntrada.obtener(MSG_PIDEKWS, MSG_ERR);
            System.out.println(PACO_LONG);
            if (kWs < 0) {
                System.out.println("ERROR: Valor kWs incorrecto.");
            }
        } while (kWs < 0);
        return kWs;
    }
}
