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
import org.japo.java.enums.Color;
import org.japo.java.enums.Tipo;
import org.japo.java.interfaces.IAlquila;

/**
 *
 * @author Jonsui
 */
public abstract class Vehiculo extends Matricula
        implements IAlquila {

  private static final long serialVersionUID = 2656741904006770596L;
  //Atr clase
  private static final double PRECIO_BASE = 50.0;

  public static final String DEF_MARCA = "MarcaXDef";
  public static final Color DEF_COLOR = Color.DEF_COLOR;
  public static final Tipo DEF_TIPO = Tipo.DEF_TIPO;
  public static final int DEF_CILIN = -1;
  public static final int DEF_YEARS = -1;

  //Atr miembro
  String marca;
  Color color;
  Tipo motor;
  int cilindrada;
  int anyos;

  public Vehiculo() {
    marca = DEF_MARCA;
    color = DEF_COLOR;
    motor = DEF_TIPO;
    cilindrada = DEF_CILIN;
    anyos = DEF_YEARS;
  }

  public Vehiculo(String marca, Color color, Tipo motor, int cilindrada, int anyos) {
    this.marca = marca;
    this.color = color;
    this.motor = motor;
    this.cilindrada = cilindrada;
    this.anyos = anyos;
  }

  public Vehiculo(String marca, Color color, Tipo motor, int cilindrada, int anyos, String matricula) {
    super(matricula);
    this.marca = marca;
    this.color = color;
    this.motor = motor;
    this.cilindrada = cilindrada;
    this.anyos = anyos;
  }

  public static double getPRECIO_BASE() {
    return PRECIO_BASE;
  }

  public String getMarca() {
    return marca;
  }

  public Color getColor() {
    return color;
  }

  public Tipo getMotor() {
    return motor;
  }

  public int getCilindrada() {
    return cilindrada;
  }

  public int getAnyos() {
    return anyos;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public void setMotor(Tipo motor) {
    this.motor = motor;
  }

  public void setCilindrada(int cilindrada) {
    this.cilindrada = cilindrada;
  }

  public void setAnyos(int anyos) {
    this.anyos = anyos;
  }

  @Override
  public String toString() {
    return String.format("DATOS DEL VEHÍCULO %s%n"
            + "------------------%n"
            + "Marca ....: %s%n"
            + "Color ....: %s%n"
            + "Motor ....: %s%n"
            + "Cilindrada ..: %d CV%n"
            + "Años ........: %d años%n",
            getMatricula(), getMarca(), getColor(), getMotor(),
            getCilindrada(), getAnyos());
  }

  public void muestraVehiculo() {
    System.out.println(toString());
  }

  // equals normal, no añadimos super porque es la matricula
  //y siempre daría false. Son los atr básicos que todo vehículo comparte.
  @Override
  public boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Vehiculo)) {
      testOk = false;
    } else {
      testOk = marca.equals(((Vehiculo) o).getMarca())
              && color == ((Vehiculo) o).getColor()
              && motor == ((Vehiculo) o).getMotor()
              && cilindrada == ((Vehiculo) o).getCilindrada()
              && anyos == ((Vehiculo) o).getAnyos();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.marca);
    hash = 67 * hash + Objects.hashCode(this.color);
    hash = 67 * hash + Objects.hashCode(this.motor);
    hash = 67 * hash + this.cilindrada;
    hash = 67 * hash + this.anyos;
    hash = 67 * hash + super.hashCode();
    return hash;
  }
}
