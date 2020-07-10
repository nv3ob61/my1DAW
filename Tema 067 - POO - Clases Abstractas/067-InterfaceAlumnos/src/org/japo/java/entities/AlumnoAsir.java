/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.io.Serializable;
import org.japo.java.entities.abs.AlumnoCic;

/**
 *
 * @author Jonsui
 */
public class AlumnoAsir extends AlumnoCic implements Serializable {
  
  private static final long serialVersionUID = 3769775241329277968L;
  
  private char administra;
  
  public AlumnoAsir(){
    super();
  }

  public AlumnoAsir(char administra) {
    this.administra = administra;
  }

  public AlumnoAsir(char administra, char familia) {
    super(familia);
    this.administra = administra;
  }

  public AlumnoAsir(char administra, char familia, int exp) {
    super(familia, exp);
    this.administra = administra;
  }

  public char getAdministra() {
    return administra;
  }

  public void setAdministra(char administra) {
    this.administra = administra;
  }
  
}
