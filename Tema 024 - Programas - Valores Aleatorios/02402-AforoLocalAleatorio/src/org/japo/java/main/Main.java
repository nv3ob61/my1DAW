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

//import java.util.Locale;
import java.util.Random;
//import java.util.Scanner;

/**
 *
 * @author mon-mode
 */
public class Main {
    /*Objeto Scanner, en estos ejercicios del Random no se utiliza.

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+"); */
    
    //Inicio Random
    public static final Random RND = new Random();

    public static void main(String[] args) {
        //Constantes
        final int AFORO_MAX = 100;
        final int AFORO_MIN = 0;
        
        //Variables
        int aforo;
        int aforoInt;
        
        //Generamos dato rango de 0 hasta 100, el local puede estar vacío.
        aforo = RND.nextInt(AFORO_MAX - AFORO_MIN +1 ) + AFORO_MIN;
        
        //Geramos los datos con Math.random, floor para quitar los decimales
        aforoInt = (int) Math.floor(Math.random()*(100+1));
        
        //Datos de salida
        System.out.printf("Aforo actual del local: %d personas %n", aforo);
        System.out.printf("AforoInt del local....: %d personas %n", aforoInt);
    }
}
