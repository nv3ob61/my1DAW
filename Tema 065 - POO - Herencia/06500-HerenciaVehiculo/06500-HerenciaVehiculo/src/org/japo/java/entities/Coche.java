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

import java.io.Serializable;
import java.util.Arrays;
import org.japo.java.entities.abs.Vehiculo;
import org.japo.java.entities.parts.MotorCombustion;
import org.japo.java.entities.parts.Neumatico;
import org.japo.java.interfaces.Avisador;
import org.japo.java.interfaces.Girable;
import org.japo.java.interfaces.INeumatico;
import org.japo.java.interfaces.Ilumina;
import org.japo.java.interfaces.Motriz;
import org.japo.java.interfaces.MotrizCombustion;
import org.japo.java.interfaces.MotrizElectrico;
import org.japo.java.interfaces.Tripulable;
import org.japo.java.utils.UtilesPrints;

/**
 *
 * @author Jonsui
 */
public class Coche extends Vehiculo implements Girable, Avisador, Motriz,
        MotrizCombustion, MotrizElectrico, Ilumina, Tripulable, INeumatico,
        Serializable {

  private static final long serialVersionUID = 3213174568916907152L;

  private Neumatico[] neumaticos;
  private MotorCombustion motor;
  //Manual, Automático
  private String tipoCoche;

  public Coche() {
    motor = new MotorCombustion();
    neumaticos = new Neumatico[UtilesPrints.DEF_RUEDASCOCHE];
    tipoCoche = UtilesPrints.DEF_TIPOCOCHE;
    marca = UtilesPrints.DEF_FERRARI;
    ruedas = UtilesPrints.DEF_RUEDASCOCHE;
  }

  public Coche(Neumatico[] neumaticos, MotorCombustion motor, String tipoCoche) {
    this.neumaticos = neumaticos;
    this.motor = motor;
    this.tipoCoche = tipoCoche;
  }

  public Coche(Neumatico[] neumaticos, MotorCombustion motor, String tipoCoche, String marca, String modelo, int marchas, int ruedas, int numPlazas, boolean luces) {
    super(marca, modelo, marchas, ruedas, numPlazas, luces);
    this.neumaticos = neumaticos;
    this.motor = motor;
    this.tipoCoche = tipoCoche;
  }


  public Neumatico[] getNeumaticos() {
    return neumaticos;
  }

  public MotorCombustion getMotor() {
    return motor;
  }

  public String getTipoCoche() {
    return tipoCoche;
  }

  public void setNeumaticos(Neumatico[] neumaticos) {
    this.neumaticos = neumaticos;
  }

  public void setMotor(MotorCombustion motor) {
    this.motor = motor;
  }

  public void setTipoCoche(String tipoCoche) {
    this.tipoCoche = tipoCoche;
  }

  @Override
  public void desmontar() {
       System.out.println(UtilesPrints.DEF_DESMONTAR);
  }

  @Override
  public void montar() {
    System.out.println(UtilesPrints.DEF_MONTAR);
  }

  @Override
  public void conducir() {
    System.out.println(UtilesPrints.DEF_CONDUCIR);
  }

  @Override
  public void girarIzquierda() {
    System.out.println(UtilesPrints.DEF_IZQUIERDA);
  }

  @Override
  public void girarDerecha() {
    System.out.println(UtilesPrints.DEF_DERECHA);
  }

  @Override
  public void avisar() {
    System.out.println(UtilesPrints.DEF_AVISAR);
  }

  @Override
  public void acelerar() {
    System.out.println(UtilesPrints.DEF_ACELERAR);
  }
  
  @Override
  public void frenar() {
    System.out.println(UtilesPrints.DEF_FRENAR);
  }

  @Override
  public void arrancar() {
    System.out.println(UtilesPrints.DEF_ARRANCAR);
  }

  @Override
  public void parar() {
    System.out.println(UtilesPrints.DEF_PARAR);
  }

  @Override
  public void repostar() {
    System.out.println(UtilesPrints.DEF_REPOSTAR);
  }

  @Override
  public void conectar() {
    System.out.println(UtilesPrints.DEF_CONECTAR);
  }

  @Override
  public void desconectar() {
    System.out.println(UtilesPrints.DEF_DESCONECTAR);
  }

  @Override
  public boolean enciendeLucesPosicion() {
    if (luces == false) {
      luces = true;
      System.out.println(UtilesPrints.DEF_ENCIENDELUCESPOS);
    }
    return luces;
  }

  @Override
  public void inflar(double k) {
    System.out.println(UtilesPrints.DEF_INFLARNEUM);
  }

  @Override
  public void desinflar(double k) {
    System.out.println(UtilesPrints.DEF_DESINFLARNEUM);    
  }

  @Override
  public void cambiarNeumatico() {
       System.out.println(UtilesPrints.DEF_CAMBIARNEUM);  
  }
  @Override
  public String toString() {
        return String.format("DATOS DEL COCHE%n"
            + "MARCA: %s%n"
            + "MODELO: %s%n"
                + "DATOS DEL MOTOR:%n%s%n"
                + "DATOS NEUMATICOS: %s", getMarca(), getModelo(), getMotor(),
                Arrays.toString(getNeumaticos()));
  }
  
  public void mostrarInfoCoche(){
    System.out.println(toString());
  }

  
}
