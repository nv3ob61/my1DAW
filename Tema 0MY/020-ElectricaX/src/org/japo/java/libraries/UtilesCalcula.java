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
public class UtilesCalcula {

    public static final int LIMIT1 = 150;
    public static final int LIMIT2 = 300;
    public static final int LIMIT3 = 400;
    public static final double INCRE1 = 0.07;
    public static final double INCRE2 = 0.09;
    public static final double INCRE3 = 0.1;

    public static final double POT1 = 3.45;
    public static final double POT2 = 4.60;
    public static final double POT3 = 5.75;
    public static final double POT4 = 6.90;
    public static final double POT5 = 8.05;

    public static final double calculaIncremento(double kWs) {
        double incremento;
        /*método para calcular si hay un incremento en la factura depende el rango que
hayamos consumido:
        de 150 a 300
        de 300 a 400
        o más de 400 kws...    */
        if (kWs > LIMIT1 && kWs <= LIMIT2) {
            incremento = INCRE1;
        } else if (kWs > LIMIT2 && kWs <= LIMIT3) {
            incremento = INCRE2;
        } else if (kWs > LIMIT3) {
            incremento = INCRE3;
        } else {
            incremento = 0;
        }
        return incremento;
    }

    public static double switchTarifa(double potencia) {
        //Operaciones finales, añade incremento en la suma total. Recordarses!
        //La variable preciofijo es por si cambian los tiempos...
        double tarifa, total, sumaTotal;

        if (potencia == POT1) {
            tarifa = 10.23;
        } else if (potencia == POT2) {
            tarifa = 14.45;
        } else if (potencia == POT3) {
            tarifa = 18.69;
        } else if (potencia == POT4) {
            tarifa = 21.34;
        } else if (potencia == POT5) {
            tarifa = 25.99;
        } else {
            tarifa = 14.45;
        }

        return tarifa;
    }

    public static final double calculaPrecioCliente(double tarifa, double kWs,
            double incremento, double precioFijo) {
        ///aquí totales
        double total = tarifa + (kWs * precioFijo);

        double sumaTotal = total + (total * incremento);

        return sumaTotal;
    }
}
