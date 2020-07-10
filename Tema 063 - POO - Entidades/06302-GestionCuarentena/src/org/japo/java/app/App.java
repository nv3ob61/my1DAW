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

import org.japo.java.entities.Perro;

/**
 *
 * @author jonsui10
 */
public final class App {

    public final void launchApp() {
        Perro p1 = new Perro();
        
        System.out.println(p1.toString());
        System.out.println("Nuevo perro que acaba de llegar a Islandia.");
        System.out.println("---");
        System.out.println("Ha pasado la cuarentena?");
        System.out.println("Respuesta: " + p1.isCuarentena());

        //Si cuarentena es false pasamos al perro a cuarentena.
        if (p1.isCuarentena() == false) {
            p1.setCuarentena(true);
            System.out.println("Ponemos al perro en cuarentena...");
        }
        
        System.out.println();
        //Comprobar de nuevo el estado
        System.out.println("ESTADO CUARENTENA: " + p1.isCuarentena());
    }

}
