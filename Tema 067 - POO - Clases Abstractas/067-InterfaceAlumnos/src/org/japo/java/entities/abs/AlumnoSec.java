/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities.abs;

import java.io.Serializable;

/**
 *
 * @author Jonsui
 */
public abstract class AlumnoSec extends Alumno implements Serializable {

  private static final long serialVersionUID = -4594696998113476669L;

  private char itinerario;

  public AlumnoSec() {
  }

  public AlumnoSec(char itinerario) {
    this.itinerario = itinerario;
  }

  public AlumnoSec(char itinerario, int exp) {
    super(exp);
    this.itinerario = itinerario;
  }

  public char getItinerario() {
    return itinerario;
  }

  public void setItinerario(char itinerario) {
    this.itinerario = itinerario;
  }

}
