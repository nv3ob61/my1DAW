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

/**
 *
 * @author mon-mode
 */
public class Main {

    public static final Calendar CAL = Calendar.getInstance();

    public static void main(String[] args) {
        int h, m, s;
        // Con un int se puede definir el valor al que equivale por defecto esa
        // característica, comentada está la línea la otra forma que hay para hacerlo.

        //h = CAL.get(Calendar.HOUR_OF_DAY);
        h = CAL.get(11);
        //m = CAL.get(Calendar.MINUTE);
        m = CAL.get(12);
        //s = CAL.get(Calendar.SECOND);
        s = CAL.get(13);

        System.out.printf("Hora del sistema....: %02d:%02d:%02d %n", h, m, s);
    }

}
