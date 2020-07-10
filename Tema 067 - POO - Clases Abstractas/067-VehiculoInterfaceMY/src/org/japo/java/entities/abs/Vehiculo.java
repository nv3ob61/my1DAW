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
package org.japo.java.entities.abs;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import org.japo.java.interfaces.IVehiculo;

/**
 *
 * @author Jonsui
 */
public abstract class Vehiculo extends Bastidor implements IVehiculo {

  public static final int DEF_CONTADOR;

  //Definimos con este static DEF_CONTADOR
  static {
    final int CONTADOR_MIN = 0;
    final int CONTADOR_MAX = 20;

    final Random RND = new Random();

    DEF_CONTADOR = RND.nextInt(CONTADOR_MAX - CONTADOR_MIN + 1)
            + CONTADOR_MIN;
  }

  private String marca;
  private String modelo;
  private int marchas;
  private int ruedas;
  private int numPlazas;
  //true encendidas, false apagadas
  private boolean luces;

  private String tipoVehiculo;
  private double kmRecorridos;
  private int revisiones;
  private int contador;

  public Vehiculo() {
    contador = DEF_CONTADOR;
  }

  public Vehiculo(String marca, String modelo, int marchas, int ruedas,
          int numPlazas, boolean luces, String tipoVehiculo, double kmRecorridos,
          int revisiones, int contador) {
    this.marca = marca;
    this.modelo = modelo;
    this.marchas = marchas;
    this.ruedas = ruedas;
    this.numPlazas = numPlazas;
    this.luces = luces;
    this.tipoVehiculo = tipoVehiculo;
    this.kmRecorridos = kmRecorridos;
    this.revisiones = revisiones;
    if (validar(contador)) {
      this.contador = contador;
    } else {
      this.contador = DEF_CONTADOR;
    }
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public int getMarchas() {
    return marchas;
  }

  public int getRuedas() {
    return ruedas;
  }

  public int getNumPlazas() {
    return numPlazas;
  }

  public boolean isLuces() {
    return luces;
  }

  public String getTipoVehiculo() {
    return tipoVehiculo;
  }

  public double getKmRecorridos() {
    return kmRecorridos;
  }

  public int getRevisiones() {
    return revisiones;
  }

  public double getContador() {
    return contador;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setMarchas(int marchas) {
    this.marchas = marchas;
  }

  public void setRuedas(int ruedas) {
    this.ruedas = ruedas;
  }

  public void setNumPlazas(int numPlazas) {
    this.numPlazas = numPlazas;
  }

  public void setLuces(boolean luces) {
    this.luces = luces;
  }

  public void setTipoVehiculo(String tipoVehiculo) {
    this.tipoVehiculo = tipoVehiculo;
  }

  public void setKmRecorridos(double kmRecorridos) {
    this.kmRecorridos = kmRecorridos;
  }

  public void setRevisiones(int revisiones) {
    this.revisiones = revisiones;
  }

  public void setContador(int contador) {
    this.contador = contador;
  }

  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Vehiculo)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.getKmRecorridos() == ((Vehiculo) o).getKmRecorridos()
              && this.getMarca().equals(((Vehiculo) o).getMarca())
              && this.getMarchas() == ((Vehiculo) o).getMarchas()
              && this.getModelo().equals(((Vehiculo) o).getModelo())
              && this.getNumBastidor().equals(((Vehiculo) o).getNumBastidor())
              && this.getNumPlazas() == ((Vehiculo) o).getNumPlazas()
              && this.getRevisiones() == ((Vehiculo) o).getRevisiones()
              && this.getRuedas() == ((Vehiculo) o).getRuedas()
              && this.getTipoVehiculo().equals(((Vehiculo) o).getTipoVehiculo());
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 67 * hash + Objects.hashCode(this.marca);
    hash = 67 * hash + Objects.hashCode(this.modelo);
    hash = 67 * hash + this.marchas;
    hash = 67 * hash + this.ruedas;
    hash = 67 * hash + this.numPlazas;
    hash = 67 * hash + (this.luces ? 1 : 0);
    hash = 67 * hash + Objects.hashCode(this.tipoVehiculo);
    hash = 67 * hash + (int) (Double.doubleToLongBits(this.kmRecorridos)
            ^ (Double.doubleToLongBits(this.kmRecorridos) >>> 32));
    hash = 67 * hash + this.revisiones;
    hash = 67 * hash + (int) (Double.doubleToLongBits(this.contador)
            ^ (Double.doubleToLongBits(this.contador) >>> 32));
    return hash;
  }

  @Override
  public final String toString() {
    return String.format(Locale.ENGLISH, "TIPO DE VEHÍCULO: %s%n"
            + "MARCA ..........: %s%n"
            + "MODELO .........: %s%n"
            + "Nº MARCHAS .....: %d%n"
            + "Nº BASTIDOR ....: %s%n"
            + "TIPO VEHÍCULO ..: %s%n"
            + "Nº RUEDAS ......: %d%n"
            + "Nº PLAZAS ......: %d%n"
            + "Kms RECORRIDOS .: %.2f%n"
            + "REVISIONES .....: %d%n",
            getClass().getSimpleName(), this.getMarca(), this.getModelo(),
            this.getMarchas(),
            this.getNumBastidor(), this.getTipoVehiculo(), this.getRuedas(),
            this.getNumPlazas(), this.getKmRecorridos(), obtenerNumeroRevisiones(getContador()));
  }

  public void mostrarInfo() {
    System.out.println(toString());
  }

  @Override
  public abstract void mostrarInfoRevisiones();

  @Override
  public abstract int obtenerNumeroRevisiones(double km);

  private boolean validar(int contador) {

    return contador >= DEF_CONTADOR;
  }

}
