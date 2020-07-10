/* 
 * Copyright (C) 2020 mon_mode   0mon.mode@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.japo.java.app;

import java.util.Locale;
import java.util.Scanner;
import org.japo.java.entities.Contacto;

/**
 *
 * @author jonsui10
 */
public final class App {

    public static final Scanner SCN = new Scanner(System.in, "Windows-1252")
            .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    
    public final void launchApp() {

        Contacto con = new Contacto();
        System.out.println("Inicio de la APP");
        
        System.out.println("Introduzca su edad: ");
        con.setEdad(SCN.nextInt());
        
        System.out.println("Introduzca su nombre: ");
        con.setAlias(SCN.next());
        
//        if(con.esMayorDe(con.getEdad())) {
//            System.out.printf("La persona %s tiene %d anyos, es MAYOR de 18.", 
//                    con.getAlias(), con.getEdad());
//        } else {
//            System.out.printf("La persona %s solo tiene %d anyos, es menor de 18.",
//                    con.getAlias(), con.getEdad());
//        }
    }

}
