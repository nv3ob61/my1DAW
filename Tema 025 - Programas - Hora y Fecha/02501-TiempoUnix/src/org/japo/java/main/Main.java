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

import java.util.Date;

/**
 *
 * @author mon-mode
 */
public class Main {

    public static void main(String[] args) {
        /*Instancia de los objetos/variables, aunque ejercicio funcionaría con esta línea
        System.out.println("Tiempo UNIX (s)....... : " + System.currentTimeMillis());  
        Lo acompañamos con el uso de la clase Date y Calendar */
        long fromEpoch, timeinMilli;
        //Instancia de new Date
        Date date = new Date();
        
        fromEpoch = System.currentTimeMillis();
        System.out.printf("Tiempo UNIX.(1)........... : %d en segundos %n", fromEpoch / 1000);
        
        //Usamos la clase Date aquí
        timeinMilli = date.getTime();
        System.out.println("Tiempo UNIX. (Date)....... : " + timeinMilli);
        System.out.println(date);
        

        
    }
}
