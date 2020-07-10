/*
 * Copyright 2019 mon_mo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.

Ejemplo de la salida:
    -----------------------------
      PROGRAMA HIDROELÉCTRICA X
    -----------------------------
    Introduzca el precio del kW/h: 34
    -----------------------------
    Introduce los dígitos del contrato 
    en formato xxx-xxxx : 111-1111

       Pulsa A, B, C o D para elegir la potencia contratada
       ----------------------------------------------------
    A = 3.45kW	B = 4.60kW	C = 5.75kW	D = 6.90kW	E = 8.05KW

    Introduce selección: r
    ---
    ERROR: Potencia incorrecta
    ---

       Pulsa A, B, C o D para elegir la potencia contratada
       ----------------------------------------------------
    A = 3.45kW	B = 4.60kW	C = 5.75kW	D = 6.90kW	E = 8.05KW

    Introduce selección: a
    -----------------------------
    Introduce los kW consumidos este mes: 34
    -----------------------------

    Nº contrato 	kW 	Potencia 	Incremento 	Precio Final
    111-1111	34.0		3.45kWs		0.0%		1166.23 euros.

    ¿Desea introducir otro cliente? (si o no):
    n

    ¿Desea introducir otro cliente? (si o no):
    no

    Total Clientes 	Total kW  	Facturado
    1		34.0		1166.23€.


 */
package org.japo.java.app;

import org.japo.java.libraries.UtilesEntrada;
import org.japo.java.libraries.UtilesCalcula;
import org.japo.java.libraries.UtilesLuz;
import org.japo.java.libraries.UtilesContrato;

/**
 *
 * @author mon_mo
 */
public final class App {

    public static final String PACO = "---";
    public static final String PACO_LONG = "-----------------------------";
    public static final String MSG_ERR = "ERROR: Entrada incorrecta.";

//INICIO DE LA APP
    public final void launchApp() {
        //Variables
        int numClientes = 0;
        double precioFijo;
        double potencia;
        double kWs;
        double incremento;
        double precioCliente;
        double totalkWs = 0;
        double totalFacturado = 0;
        String contrato;
        String respuesta;
        //loop principal del programa.
            precioFijo = UtilesLuz.fijakWs();
        do {
            muestraBanner();
            contrato = UtilesContrato.pideContrato();
            potencia = UtilesLuz.pidePotencia();
            kWs = UtilesLuz.pidekWs();
            incremento = UtilesCalcula.calculaIncremento(kWs);
            precioCliente = 
                    UtilesCalcula.calculaPrecioCliente(UtilesCalcula.
                            switchTarifa(potencia), kWs,incremento, precioFijo);
            totalkWs += kWs;
            totalFacturado += precioCliente;
            numClientes++;
            System.out.println("\nNº contrato \tkW \t\tPotencia \tIncremento \tPrecio Final");
            System.out.println(contrato + "\t" + kWs + "\t\t" + potencia
                    + "kWs\t\t" + (incremento * 100) + "%\t\t" + precioCliente + " euros.");
            respuesta = UtilesEntrada.deseaCont();
        } while (respuesta.equalsIgnoreCase("si"));
        
        //SALIDA FINAL cuando ya no queremos introducir más clientes.
        System.out.println("\nTotal Clientes \tTotal kW  \tFacturado");
        System.out.println(numClientes + "\t\t" + totalkWs + "\t\t" + totalFacturado + "€."); 
    }

    public final void muestraBanner() {
        System.out.println(PACO_LONG);
        System.out.println("  PROGRAMA HIDROELÉCTRICA X");
    }

}
