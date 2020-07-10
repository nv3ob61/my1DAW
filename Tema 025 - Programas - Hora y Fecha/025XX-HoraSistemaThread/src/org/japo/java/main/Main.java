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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mon-mode
 */
public class Main {

    public static void main(String[] args) {
        //Definimos ls variable date
        Date date;
        date = new Date(System.currentTimeMillis());
        try {
            //Creamos un loop sin fin. CUIDADO!
            while(date==date){
            //date = llamada al tiempo en milisegundos
            date = new Date(System.currentTimeMillis());
            //Especificamos el formato de la fecha
            SimpleDateFormat SDF = new SimpleDateFormat("HH:mm:ss");

            //Out del formato de la fecha
            System.out.println("\tHora del sistema......: " + SDF.format(date));
            System.out.printf("\tRecuerda finalizar este programa%n%n%n%n%n");
            Thread.sleep(700);
            System.out.print("\033[2J");
            Thread.sleep(300);
            
            
            }
        } catch (InterruptedException e) {
        }

    }

}
