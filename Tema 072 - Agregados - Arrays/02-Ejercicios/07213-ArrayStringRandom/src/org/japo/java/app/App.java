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
package org.japo.java.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mon_mo
 */
public final class App {
    
    public static final Random RND = new Random();

    public static final int LONG_LISTA = 5;

    public static final String FICHERO = "palabras.txt";

    public final void launchApp() {
        final String[] LISTA = new String[LONG_LISTA];

        try (
                FileReader fr = new FileReader(FICHERO);
                BufferedReader br = new BufferedReader(fr)) {

            List<String> listaNombres = importarLista(br);
            for (int i = 0; i < LISTA.length; i++) {
                LISTA[i] = obtenerNombreLista(listaNombres);
            }
            
            for (String candidato : LISTA) {
                System.out.println("Candidato: " +candidato);
            }
        } catch (Exception e) {
            System.out.println("ERROR: Acceso al fichero.");
        }

    }


    private List<String> importarLista(BufferedReader br) throws IOException {
        //Creal almacent de datos
        List<String> lista = new ArrayList<>();
        boolean lecturaOk = true;
        do {
        //leer
            String str = br.readLine();
            
            if(str == null){
            lecturaOk = false;
            } else {
                lista.add(str);
            }
        } while (lecturaOk); 
        
        return lista;
    }

    private String obtenerNombreLista(List<String> listaNombres) {
        int numItems = listaNombres.size();
        
        int posLista = RND.nextInt(numItems - 0 +1) +0;
        
        return listaNombres.get(posLista);
    }
}
