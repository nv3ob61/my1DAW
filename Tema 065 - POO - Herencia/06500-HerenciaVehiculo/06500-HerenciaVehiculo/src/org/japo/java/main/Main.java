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
package org.japo.java.main;

import org.japo.java.app.App;

/**
 *
 * @author jonsui10
 */
public class Main {

    private static final String ACCESS_UID = "mon_mode1962894500";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        if (args.length == 1 && args[0].equals(ACCESS_UID)) {
            //Crear aplicacion
            final App APP = new App();
            //Lanzar aplicacion
            APP.launchApp();
        } else {
            System.out.println("ACCESO DENEGADO");
            System.out.println("---");
            System.out.println("Contacte con su servicio tecnico.");
        }
    }

}
