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

import java.util.Locale;

/**
 *
 * @author mon-mode
 */
public class Main {

    public static void main(String[] args) {
        //Constantes

        final String NOMBRE = "Jaimito";
        final String ARTICULO = "Patatas";
        final String ARTICULO_IMPREV = "Piruleta";
        final double PRECIO_PATATAS = 0.3;
        final double PRECIO_PIRULETA = 0.2;
        final double CANTIDAD_ENCARGADA = 3;
        final double DINERO_SUMINISTRADO = 1;
        
        //Varaibles
        double dineroDevu = DINERO_SUMINISTRADO - PRECIO_PIRULETA;
        double vueltaMadre;
        
        //Usamos el casting para el redondeo
        int numeroKilos = (int) (dineroDevu / PRECIO_PATATAS);
        
        //la vuelta que le da a la madre
        vueltaMadre = dineroDevu - (numeroKilos * PRECIO_PATATAS);
                
        System.out.println("Secuencia de Patatas");
        System.out.printf("====================%n");
        System.out.printf("Persona encargada .....: %s %n", NOMBRE);
        System.out.printf("Artículo encargado ....: %s %n", ARTICULO);
        System.out.printf("Cantidad encargada ....: %.0f kg %n", CANTIDAD_ENCARGADA);
        System.out.printf("---%n");
        System.out.printf(Locale.ENGLISH, "Precio encargo ........: %.2f €/Kg %n", PRECIO_PATATAS);
        System.out.printf(Locale.ENGLISH,"Dinero suministrado ...: %.2f € %n", DINERO_SUMINISTRADO);
        System.out.printf("---%n");
        System.out.printf("Artículo imprevisto ...: %s %n", ARTICULO_IMPREV);
        System.out.printf(Locale.ENGLISH, "Precio imprevisto .....: %.2f € %n", PRECIO_PIRULETA);
        System.out.printf("---%n");
        System.out.printf("Cantidad comprada .....: %d kg %n", numeroKilos);
        
        
        System.out.printf(Locale.ENGLISH, "Dinero devuelto .......: %.2f € %n", vueltaMadre);
        //System.out.printf("%s%n", artIm);

        
        
    }
}
