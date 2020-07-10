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
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
//Inicio Random
    public static final Random RND = new Random();
    
    public static void main(String[] args) {
        //Inicalizamos constantes
        final int H_INI = 8;
        final int M_INI = 20;
        final int S_INI = 0;
        
        int hAct, mAct, sAct, tmpIni, tmpAct, tmpRnd, tmpDis;
        // Gregorian Calendar
        GregorianCalendar cal = new GregorianCalendar();

        // Captura la hora actual
        hAct = cal.get(Calendar.HOUR_OF_DAY);
        mAct = cal.get(Calendar.MINUTE);
        sAct = cal.get(Calendar.SECOND);

        // Pasa los valores a segundos y hace la resta
        tmpIni = H_INI * 3600 + M_INI * 60 + S_INI;
        tmpAct = hAct * 3600 + mAct * 60 + sAct;
        tmpRnd = RND.nextInt(tmpAct - tmpIni + 1) + tmpIni;
        tmpDis = tmpAct - tmpRnd;

        // Hora Aleatoria
        int hRnd = tmpRnd / 3600;
        tmpRnd = tmpRnd % 3600;
        int mRnd = tmpRnd / 60;
        int sRnd = tmpRnd % 60;

        // Distacia  HoraDist = tiempoDist /3600 
        int hDis = tmpDis / 3600;
        tmpDis = tmpDis % 3600;
        int mDis = tmpDis / 60;
        int sDis = tmpDis % 60;

        // Salidas
        System.out.printf("Hora actual ......: %02d:%02d:%02d%n", hAct, mAct, sAct);
        System.out.printf("Hora inicio ......: %02d:%02d:%02d%n", hRnd, mRnd, sRnd);
        System.out.printf("Tiempo de clase ..: %02d:%02d:%02d%n", hDis, mDis, sDis);
    }
}