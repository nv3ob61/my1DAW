/* 
 * Copyright 2019 mon-mode - 0mon.mode@gmail.com
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
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author mon-mode
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Constantes. Definimos el día máximo
        final int DIA_MAX = 5;
        //Tiempo de jornada 37.5 horas pasada a minutos
        final int MIN_MAX = 2250;
        //Variables de horas varias
        int diaMin;
        int horaEntrada = 0;
        int minutoEntrada = 0;
        int horaSalida = 0;
        int minutoSalida = 0;
        //Variables para convertir a minutos, diferencia y acumulador.
        int entradaAmins;
        int salidaAmins;
        int difMins;
        int acuMins = 0;
        double acumHoras;

        //double final que mostrará el desfase en horas.
        double totalDesfase;

        //String diaSemana para el switch dimeDia();
        String diaSemana = " ";

//*******************************************************************************        
//                            COMIENZA LA FIESTA
//******************************************************************************* 
//Bucle que genera los nombres de los días laborales
        for (diaMin = 0; diaMin < DIA_MAX && acuMins < MIN_MAX; diaMin++) {

            switch (diaMin + 1) {
                case 1:
                    diaSemana = "lunes";
                    break;
                case 2:
                    diaSemana = "martes";
                    break;
                case 3:
                    diaSemana = "miercoles";
                    break;
                case 4:
                    diaSemana = "jueves";
                    break;
                case 5:
                    diaSemana = "viernes";
            }

            boolean checkHorario;
            //Este primer do va con checkHorario, si las resta no es positiva.:
            do {
                //boolean para el control de las horas
                boolean horaEntradaOk = false;
                boolean minEntradaOk = false;
                boolean horaSalidaOk = false;
                boolean minSalidaOk = false;

                boolean horaEntValid = false;
                boolean minEntValid = false;
                boolean horaSalValid = false;
                boolean minSalValid = false;

                checkHorario = false;
                //Bucle para la HORA de ENTRADA
                do {
                    try {
                        do {
                            //Entrada de datos
                            System.out.printf("Es %s introduzca la HORA "
                                    + "ENTRADA ......: ", diaSemana);
                            horaEntrada = SCN.nextInt();
                            horaEntradaOk = true;
                            if (horaEntrada < 0 || horaEntrada > 23) {
                                System.out.println("ERROR: Hora fuera de rango.");
                            } else {
                                horaEntValid = true;
                            }
                        } while (!horaEntValid);
                    } catch (Exception e) {
                        System.out.println("ERROR: Valor introducido incorrecto");
                    } finally {
                        //borra el buffer, si no entra en bucle sin fin.
                        SCN.nextLine();
                    }
                } while (!horaEntValid);

                //Bucle para los MINUTOS de ENTRADA
                do {
                    try {
                        do {
                            //Entrada de datos
                            System.out.printf("Es %s introduzca los MINUTOS "
                                    + "ENTRADA ..: ", diaSemana);
                            minutoEntrada = SCN.nextInt();
                            minEntradaOk = true;
                            if (minutoEntrada < 0 || minutoEntrada > 59) {
                                System.out.println("ERROR: Minutos fuera de rango.");
                            } else {
                                minEntValid = true;
                            }
                        } while (!minEntValid);
                    } catch (Exception e) {
                        System.out.println("ERROR: Valor introducido incorrecto");
                    } finally {
                        //borra el buffer, si no entra en bucle sin fin.
                        SCN.nextLine();
                    }
                } while (!minEntValid);

                //Bucle para la HORA de SALIDA
                do {
                    try {
                        do {
                            //Entrada de datos
                            System.out.printf("Es %s introduzca la HORA "
                                    + "SALIDA .......: ", diaSemana);
                            horaSalida = SCN.nextInt();
                            horaSalidaOk = true;
                            if (horaSalida < 0 || horaSalida > 23) {
                                System.out.println("ERROR: Hora fuera de rango.");
                            } else {
                                horaSalValid = true;
                            }
                        } while (!horaSalValid);
                    } catch (Exception e) {
                        System.out.println("ERROR: Valor introducido incorrecto");
                    } finally {
                        //borra el buffer, si no entra en bucle sin fin.
                        SCN.nextLine();
                    }
                } while (!horaSalValid);

                //Bucle para los MINUTOS de SALIDA
                do {
                    try {
                        do {
                            //Entrada de datos
                            System.out.printf("Es %s introduzca los MINUTOS "
                                    + "SALIDA ...: ", diaSemana);
                            minutoSalida = SCN.nextInt();
                            minSalidaOk = true;
                            if (minutoSalida < 0 || minutoSalida > 59) {
                                System.out.println("ERROR: Minutos fuera de rango.");
                            } else {
                                minSalValid = true;
                            }
                        } while (!minSalValid);
                    } catch (Exception e) {
                        System.out.println("ERROR: Valor introducido incorrecto");
                    } finally {
                        //borra el buffer, si no entra en bucle sin fin.
                        SCN.nextLine();
                    }
                } while (!minSalValid);

                //Pasamos la hora de entrada a minutos para operar luego,
                //ACABAR!
                entradaAmins = horaEntrada * 60 + minutoEntrada;
                salidaAmins = horaSalida * 60 + minutoSalida;

                //Control si la hora de entrada introducida es mayor. 
                //No es posible
                if (entradaAmins >= salidaAmins) {
                    System.out.printf("%nLas horas no corresponden con una "
                            + "entrada real al trabajo. "
                            + "%n       ..... Por favor, INTÉNTELO DE NUEVO ....."
                            + "  %n%n");
                    checkHorario = true;
                } else {
                    //¿Es necesario?
                    checkHorario = false;
                    //Hacemos las operaciones si checkHorario no cambia de valor.
                    difMins = salidaAmins - entradaAmins;
                    acuMins += difMins;
                    //Salida de la hora por días
                    System.out.println();
                    System.out.println(diaSemana);
                    System.out.printf("Su hora de entrada es ..: %02d:%02d%n",
                            horaEntrada, minutoEntrada);
                    System.out.printf("Su hora de salida es ...: %02d:%02d%n%n",
                            horaSalida, minutoSalida);

                    //Mensajes de test APAÑAR!
                    System.out.println("Hora entrada a mins : " + entradaAmins);
                    System.out.println("Hora salida a mins  : " + salidaAmins);
                    System.out.println("Diferencia en mins  : " + (difMins));
                    System.out.println("Acumulador mins     : " + (acuMins));
                    System.out.println();
                }

            } while (checkHorario);

        }
        //Más test final... apañar! CAMBIO A HORAS!
        acumHoras = acuMins / 60;
        //Dividimos directamente / 60 para pasar a horas. double totalDesfase!
        //Es bueno el cast aquí? Válido y legal?
        totalDesfase = (double) (acuMins - MIN_MAX) / 60;

        System.out.println("Mensajes de test. apañar!");
        System.out.printf("Minutos trabajas semanales: %d%n", acuMins);
        System.out.printf("En horas : %.2f%n", acumHoras);
        if (acuMins >= MIN_MAX) {
            System.out.println("Ha trabajado MÁS horas de 37.5h semanales");
            System.out.printf("Te has pasado: %.2f h.%n", totalDesfase);
        } else {
            System.out.println("Bien! Has hecho MENOS horas de 37.5h semanales ");
        }
    }
}
