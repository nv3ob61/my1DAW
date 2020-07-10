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
package org.japo.java.entities;

import org.japo.java.interfaces.IAlmacen;

/**
 *
 * @author CicloM
 */
public abstract class Almacen extends Mobiliario implements IAlmacen {

    private static final long serialVersionUID = -264170551012537724L;

    @Override
    public void almacenar(String cosa) {
        System.out.printf("Almacenando %s...%n", cosa);
    }

    @Override
    public void extraer(String cosa) {
        System.out.printf("Extrayendo %s...%n", cosa);
    }
    
}
