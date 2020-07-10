/*
 * Copyright (C) 2020 CicloM
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

import org.japo.java.utils.UtilesVehiculo;

/**
 *
 * @author CicloM
 */
public class Camion extends SuperVehiculo {

    private static final long serialVersionUID = -604372492498942957L;

    public static final int DEF_CARGA = 0;
    public static final int CARGA_MIN = 0;
    public static final int CARGA_MAX = 30000;
    public static final int KM_REVISION = 12500;

    private int pesoCarga;

    public Camion() {
        super();
        pesoCarga = DEF_CARGA;
    }

    public Camion(int contador, int pesoCarga) {
        super(contador);
        if (UtilesVehiculo.validarPesoCarga(pesoCarga)) {
            this.pesoCarga = pesoCarga;
        } else {
            this.pesoCarga = DEF_CARGA;
        }
    }

    public int getPesoCarga() {
        return pesoCarga;
    }

    public void setPesoCarga(int pesoCarga) {
        if (UtilesVehiculo.validarPesoCarga(pesoCarga)) {
            this.pesoCarga = pesoCarga;
        }
    }

}
