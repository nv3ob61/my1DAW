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
        int dia, mes, any, diaAct, mesAct, anyAct;

        try {
            //Asigna valores de Calendar a las variables
            diaAct = CAL.get(Calendar.DAY_OF_MONTH);
            mesAct = CAL.get(Calendar.MONTH) + 1;
            anyAct = CAL.get(Calendar.YEAR);

            //pedimos datos de fecha al usuario
            System.out.printf("Día nacimiento ....: ");
            dia = SCN.nextInt();
            SCN.nextLine();

            System.out.printf("Mes nacimiento ....: ");
            mes = SCN.nextInt();
            SCN.nextLine();

            System.out.printf("Año nacimiento ....: ");
            any = SCN.nextInt();
            SCN.nextLine();

            //Salida de fechas
            System.out.println("---");
            System.out.printf("Fecha nacimiento ..: %02d/%02d/%02d - Manual %n", dia, mes, any);
            System.out.printf("Fecha actual ......: %02d/%02d/%02d - Sistema %n", diaAct, mesAct, anyAct);
            System.out.println("---");
            //y ternario para la condición si es mayor de edad o no.
            System.out.printf("Mayoría de edad ...: %s%n", anyAct - any > 18
                    || anyAct - any == 18 && mesAct > mes
                    || anyAct - any == 18 && mesAct == mes && diaAct >= dia ? "SI" : "NO");
        } catch (Exception e) {
            System.out.println("ERROR: Entrada incorrecta");
        } 
    }
}
