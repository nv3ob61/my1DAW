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
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author mon-mode
 */
public class Main {

    // Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final Calendar CAL = Calendar.getInstance();

    public static void main(String[] args) {

        //Declaramos variables hour, min, sec...
        int hour, min, sec, hourAct, minAct, secAct, timeUser, timeAct;
        int secDis, minDis, hourDis;

        try {
            System.out.printf("Hora inicio.....: ");
            hour = SCN.nextInt();
            SCN.nextLine();
            System.out.printf("Minuto inicio...: ");
            min = SCN.nextInt();
            SCN.nextLine();
            System.out.printf("Segundo inicio..: ");
            sec = SCN.nextInt();
            SCN.nextLine();
            
            //Asigna valores de Calendar a las variables
            hourAct = CAL.get(Calendar.HOUR_OF_DAY);
            minAct = CAL.get(Calendar.MINUTE);
            secAct = CAL.get(Calendar.SECOND);
            
            //Pasamos el tiempo a milisegundos
            timeUser = hour * 3600 + min * 60 + sec;
            timeAct = hourAct * 3600 + minAct * 60 + secAct;
            // Dif en segundos
            secDis = timeAct - timeUser;
            //minutos
            minDis = secDis / 60;
            secDis = secDis % 60;
            // horas
            hourDis = minDis / 60;
            minDis = minDis % 60;

            System.out.printf("Hora actual.....: %02d:%02d:%02d%n", hourAct, minAct, secAct);
            System.out.printf("Hora inicio.....: %02d:%02d:%02d%n", hour, min, sec);
            System.out.printf("Tiempo de clase.: %02d:%02d:%02d%n%n", hourDis, minDis, secDis);

        } catch (Exception e) {
            System.out.println("OOOOPPPS!");
        }
    }
}
