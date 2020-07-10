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

import java.util.Objects;

/**
 *
 * @author CicloM
 */
public class Arcon extends Almacen {

  private static final long serialVersionUID = 6598345983973750422L;

  //Tipos materiales
  public static final String MATERIAL_SINT = "Sint'etico";
  public static final String MATERIAL_MADE = "Madera";
  public static final String MATERIAL_METAL = "Metal";

  //Valor por defecto
  public static final String DEF_MATERIAL = "Madera";

  private String material;

  public Arcon() {
    material = DEF_MATERIAL;
  }

  public Arcon(String material) {
    if (material.equals(MATERIAL_MADE) || material.equals(MATERIAL_SINT)
            || material.equals(MATERIAL_METAL)) {
      this.material = material;
    } else {
      this.material = DEF_MATERIAL;
    }
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    if (material.equals(MATERIAL_MADE) || material.equals(MATERIAL_SINT)
            || material.equals(MATERIAL_METAL)) {
      this.material = material;
    }
  }

  @Override
  public String toString() {
    return String.format("%s - %s", getClass().getSimpleName(), material);
  }

  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Arcon)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.material.equals(((Arcon) o).getMaterial());
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.material);
    return hash;
  }
  
  @Override
  public void instalar() {
    System.out.println("Desempaquetar, armar y colocar");
  }

}
