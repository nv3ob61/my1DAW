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
public abstract class Profesor extends Persona implements Serializable {
  
  private static final long serialVersionUID = 4934446465090825952L;
  
  private String especialidad;
  
  public Profesor() {
  }

  public Profesor(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }
  
  
}
