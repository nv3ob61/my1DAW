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
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mon-mode
 */
public class Main {

    public static void main(String[] args) {
                
        //Instancia de Calendar
        Calendar cal = Calendar.getInstance();
        int d, m, a;
        //Definimos ls variable date
        Date date;
        //date = llamada al tiempo en milisegundos
        date = new Date(System.currentTimeMillis());
        //Sout!
        System.out.printf("Fecha del sistema.....: %1$td/%1$tm/%1$tY %n", date);

        
        //Especificamos el formato de la fecha
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        // Lo pasamos a un string para que se pueda manipular
        String fecha = SDF.format(date);
        
        System.out.printf("Fecha del sistema.2...: %s%n", fecha);

        //Out del formato de la fecha de otra, directamente desde la 1ª llamada:
        // Sin conversión a String!
        System.out.println("Fecha del sistema.3...: " + SDF.format(date));
        
        
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH) + 1;
        a = cal.get(Calendar.YEAR);
        
        System.out.printf("Fecha del sistema.(C).: %1$td/%1$tm/%1$tY %n", date);
        


    }

}
