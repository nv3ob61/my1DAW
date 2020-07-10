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

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author mon-mode
 */
public class Main {

    public static void main(String[] args) {
        // Variables
        int d;
        int m;
        int a;
        
        // Objeto calendar
        GregorianCalendar cal = new GregorianCalendar();
        
        // Entrada variables
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH) + 1;
        a = cal.get(Calendar.YEAR);
        
        // Mensaje
        System.out.printf("Fecha del sistema ...: %02d/%02d/%d%n", d, m, a);
        


    }

}
