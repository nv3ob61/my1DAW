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

import java.util.Objects;

/**
 *
 * @author CicloM
 */
public class Operario extends Empleado {

    private static final long serialVersionUID = -8806639045308469145L;

    public static final String DEF_SECCION = "Produccion";
    public static final String DEF_CARGOOPE = "Operario";

    private String seccion;

    public Operario() {
        super("Operario");
        seccion = DEF_SECCION;
    }

    public Operario(String seccion) {
        this.seccion = seccion;
    }

    public Operario(String seccion, String cargo) {
        super("Operario");
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    //Ponemos este setCargo vacio para evitar que se pueda cambiar el cargo
    @Override
    public void setCargo(String cargo) {

    }

    @Override
    public String toString() {
        return String.format("Informe .....: %s"
                + "Cargo .......: %s%n"
                + "Seccion .....: %s%n", DEF_HORA, cargo, seccion);
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
        } else if (!(o instanceof Operario)) {
            testOK = false;
        } else {
            testOK = getCargo().equals(((Operario) o).getCargo())
                    && seccion.equals(((Operario) o).getSeccion());
        }
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.seccion);
        return hash;
    }
}
