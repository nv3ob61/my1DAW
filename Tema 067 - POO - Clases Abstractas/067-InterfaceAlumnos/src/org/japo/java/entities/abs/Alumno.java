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
public abstract class Alumno extends Persona implements Serializable {
  
  private static final long serialVersionUID = 6946978197283687862L;
  
  private int exp;
  
  public Alumno() {
  }

  public Alumno(int exp) {
    this.exp = exp;
  }

  public int getExp() {
    return exp;
  }

  public void setExp(int exp) {
    this.exp = exp;
  }
 
}
