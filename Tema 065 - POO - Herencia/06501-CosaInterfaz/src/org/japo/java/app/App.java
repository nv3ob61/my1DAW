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

import org.japo.java.entities.Cosa;
import org.japo.java.entities.Trasto;

/**
 *
 * @author jonsui10
 */
public final class App {

    public static final String PACO = "---";

    public final void launchApp() {
      Cosa c1 = new Cosa();
      Trasto t1 = new Trasto();
      
      t1.mostrarInfo();
      c1.mostrarInfo();
      System.out.println("Cambio estado del Trasto.");
      t1.cambiaEstado();
      System.out.println("---");
      t1.mostrarInfo();

//
//        Cosa c1 = new Cosa();
//        Cosa c2 = new Cosa(true);
//
//        c1.mostrarInfo();
//        c2.mostrarInfo();
//        System.out.println(PACO);
//
//        System.out.println("Uso del método cambiaEstado(): ");
//        c1.cambiaEstado();
//        c2.cambiaEstado();
//        System.out.println(PACO);
//
//        c1.mostrarInfo();
//        c2.mostrarInfo();
//
//        System.out.println(PACO);
//        //Comparamos las dos entidades
//        System.out.println(String.format("Objetos %s IGUALES", c1.equals(c2) ? "SI" : "NO"));
    }

}
