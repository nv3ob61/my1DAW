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

import java.io.Serializable;
import java.util.Objects;
import org.japo.java.interfaces.IEmpleado;
import org.japo.java.utils.UtilesEmpleado;
import org.japo.java.utils.UtilesHora;

/**
 *
 * @author CicloM
 */
public class Empleado implements IEmpleado, Serializable {

    private static final long serialVersionUID = -3083892287209642029L;

    public static final String CARGO_OPE = "Operario";
    public static final String CARGO_ENC = "Encargado";
    public static final String DEF_CARGO = CARGO_OPE;
    public static final String DEF_HORA = UtilesHora.mostrarHora();

    String cargo;

    public Empleado() {
        cargo = DEF_CARGO;
    }

    public Empleado(String cargo) {
        if (UtilesEmpleado.validarCargo(cargo)) {
            this.cargo = cargo;
        } else {
            this.cargo = DEF_CARGO;
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (UtilesEmpleado.validarCargo(cargo) == true) {
            this.cargo = cargo;
        }
    }

    @Override
    public String toString() {
        return String.format("Informe .....: %s"
                + "Cargo .......: %s%n", DEF_HORA, cargo);
    }

    @Override
    public void mostrarInfo() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object o) {
        boolean testOK;
        if (o == null) {
            testOK = false;
        } else if (!(o instanceof Empleado)) {
            testOK = false;
        } else {
            testOK = getCargo().equals(((Empleado) o).getCargo());
        }
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.cargo);
        return hash;
    }

}
