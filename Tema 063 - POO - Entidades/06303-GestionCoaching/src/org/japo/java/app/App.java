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

import org.japo.java.entities.Maceta;

/**
 *
 * @author jonsui10
 */
public final class App {

  public static final String PACO = "---";
  
    public final void launchApp() {

        System.out.println("Inicio de la APP");
        Maceta m1 = new Maceta();
        
        System.out.println("Mostramos nombre predeterminado: " + m1.getNombre());
        System.out.println(PACO);
        System.out.println("Cambiamos el nombre a Paco Jon");
        
        m1.setNombre("Paco Jon");
        
        System.out.println(PACO);
        System.out.println();
        System.out.println("Muestra del cambio de nombre de maceta m1: ");
        System.out.println(m1.getNombre());
        System.out.println(PACO);
        System.out.println();
        System.out.println("Intento de cambio por un nombre de más de 10 char:");
        System.out.println("Entra: Paco Jon  | Sale: Amilcar Barca");
        System.out.println(PACO);
        System.out.println();
        
        m1.setNombre("Amilcar Barca");
        
        System.out.println(m1.getNombre());
        
    }

}
