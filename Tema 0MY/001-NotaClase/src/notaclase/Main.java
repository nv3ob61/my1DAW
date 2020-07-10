/*
 * Copyright 2019 mon_mo.
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
package notaclase;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mon_mo
 */
public class Main {

    /* Programa que introduce varias notas random y hace la media. 
     *
     *
     */
    // Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    // Random
    public static final Random RND = new Random();

    public static void main(String[] args) throws InterruptedException {
        //Variables
        double nota;
        double notaMedia = 0;
        double acumul = 0;
        /*Rango de los valores de las notas, para nextDouble la fórmula es: 
        x = RND.nextDouble() * (MAX - MIN) + MIN; */
        final double N_MIN = 1;
        final double N_MAX = 10;
        int cont = 0;

        reWelcome();
        //Condición para que lo repita 3 veces.
        for (int i = 0; i < 3; i++) {
            // Nota aleatoria
            nota = filtroNota(eligeNota(N_MIN, N_MAX));
            cuenta(cont);
            acumul = acumul + nota;
            //contador para la nota
            cont++;
            notaMedia = acumul / cont;
            //Salida. Comentada la siguiente línea. for testing..
            //System.out.printf("Contador..: %d%n", cont);
            System.out.printf("%nNOTA MEDIA %.2f%n", notaMedia);
        }
        goodBye(notaMedia);

    }

    public static void reWelcome() throws InterruptedException {
        System.out.printf("La lotería de su vida: %n");
        System.out.printf("Comienza en 3 segundos!! %n");
        Thread.sleep(3000);
    }

// Añadimos método que hace el random de la nota
    public static double eligeNota(double N_MIN, double N_MAX) {

        double nota;
        nota = RND.nextDouble() * (N_MAX - N_MIN) + N_MIN;
        return nota;
    }

    public static double filtroNota(double nota) {

        //System.out.printf("%nElija nota .......: %.2f%n", nota);
        if (nota > 8) {
            System.out.printf("Su nota es..%.2f..: SOBRESALIENTE %n%n", nota);
        } else if (nota > 7) {
            System.out.printf("Su nota es..%.2f..: NOTABLE %n%n", nota);
        } else if (nota > 5) {
            System.out.printf("Su nota es..%.2f..: BIEN %n%n", nota);
        } else if (nota == 5) {
            System.out.printf("Su nota es..%.2f..: SUFICIENTE %n%n", nota);
        } else {
            System.out.printf("Su nota es..%.2f..: INSUFICIENTE %n%n", nota);
        }
        return nota;
    }

    public static void cuenta(int cont) {
        
        System.out.println("************************************");
        System.out.printf("Notas introducidas: %d %n", cont + 1);
        System.out.printf("************************************ %n");
    }

    public static void goodBye(double notaMedia) {

        System.out.printf("%nSU NOTA MEDIA FINAL ES %.2f%n", notaMedia);
        System.out.printf("%n******FIN DEL PROGRAMA.GRACIAS******%n");
    }

}
