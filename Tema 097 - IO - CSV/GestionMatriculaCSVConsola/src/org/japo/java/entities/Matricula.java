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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import org.japo.java.enumerations.EstadoAlumn;
import org.japo.java.libraries.UtilesDNI;
import org.japo.java.libraries.UtilesMatricula;
import org.japo.java.libraries.UtilesValidacion;

/**
 *
 * @author Jonsui
 */
public final class Matricula implements Comparable<Matricula> {

  //Simpledate format
  public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

  //RegEx
  public static final String REG_NIA = "\\d{8}";
  public static final String REG_NOMBRE
          = "([A-ZÑÇÁÉÍÓÚÀÈÌÒÙÜa-zñçáéíóúàèìòùü]{0,25})"
          + "( [A-ZÑÇÁÉÍÓÚÀÈÌÒÙÜa-zñçáéíóúàèìòùü]{0,25})?";
  public static final String REG_APE
          = "([A-ZÑÇÁÉÍÓÚÀÈÌÒÙÜa-zñçáéíóúàèìòùü-]{0,50})"
          + "( [A-ZÑÇÁÉÍÓÚÀÈÌÒÙÜa-zñçáéíóúàèìòùü-]{0,50})?";
  public static final String REG_DOMI
          = "([a-zA-Z0-9]+.?)*(( |-)[a-zA-ZÑÇÁÉÍÓÚÀÈÌÒÙÜñçáéíóúàèìòùü0-9]+.?)* "
          + "(((#|[nN][oO].?) ?)?\\d{1,4}(( ?[a-zA-Z0-9-ºª]+)+)?)*";
  public static final String REG_CP = "(?:0[1-9]|[1-4]\\d|5[0-2])\\d{3}";
  public static final String REG_TELF = "\\d{9}";
  public static final String REG_MAIL
          = "[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)"
          + "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}";

  public static final String REG_ESTADO = "[activo|baja|indefinido]";
  // Valores Predeterminados
  public static final String DEF_NIA = "00000000";   // El NIA de 8 caracteres
  public static final String DEF_NOMBRE_ALUM = "DEF_NOMBRE";
  public static final String DEF_APELLIDO_ALUM = "DEF_APELLIDOS";
  public static final String DEF_DNI = "00000000T";
  public static final Date DEF_FECHA_NAC = Date.from(Instant.EPOCH);
  public static final String DEF_DOMICILIO = "DEF_DOMICILIO";
  public static final String DEF_CP = "01000";   //
  public static final String DEF_LOCALIDAD = "DEF_LOCALIDAD";
  public static final String DEF_TELEFONO = "900000000";
  public static final String DEF_EMAIL = "email.por@defecto.com";
  public static final String DEF_TUTOR = "DEF_TUTOR";
  public static final EstadoAlumn DEF_ESTADO = EstadoAlumn.EN_TRAMITE;

  // Campos de la entidad 
  private String nia;            // Código de Expediente
  private String nombre;         // Nombre
  private String apellidos;      // Apellidos
  private String dni;            // DNI
  private Date fechaNac;       // Fecha de Nacimiento
  private String domicilio;      // Dirección del domicilio
  private String cp;             // Código Postal
  private String localidad;      // Localidad del domicilio
  private String telefono;       // Teléfono
  private String email;          // Email
  private String tutor;          // Padre / Madre / Tutor (Si procede)

  // Para que se pueda dar de baja una matrícula, también EN_TRAMITE
  private EstadoAlumn estado;

  //Constructor Predet
  public Matricula() {
    nia = DEF_NIA;
    nombre = DEF_NOMBRE_ALUM;
    apellidos = DEF_APELLIDO_ALUM;
    dni = DEF_DNI;
    fechaNac = DEF_FECHA_NAC;
    domicilio = DEF_DOMICILIO;
    cp = DEF_CP;
    localidad = DEF_LOCALIDAD;
    telefono = DEF_TELEFONO;
    email = DEF_EMAIL;
    tutor = DEF_TUTOR;
    estado = DEF_ESTADO;
  }

  //Constructor parametrizado SIN EstadoAlumno para el BorrarAlumnos.
  public Matricula(String nia, String nombre, String apellidos,
          String dni, Date fechaNac,
          String domicilio, String cp, String localidad,
          String telefono, String email,
          String tutor) {
    this.nia = nia;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.dni = dni;
    this.fechaNac = fechaNac;
    this.domicilio = domicilio;
    this.cp = cp;
    this.localidad = localidad;
    this.telefono = telefono;
    this.email = email;
    this.tutor = tutor;
  }

  //Constructor parametrizado
  public Matricula(String nia, String nombre, String apellidos,
          String dni, Date fechaNac,
          String domicilio, String cp, String localidad,
          String telefono, String email,
          String tutor, EstadoAlumn estado) throws ParseException {
//    validar NIA
    if (UtilesValidacion.validar(nia, REG_NIA)) {
      this.nia = nia;
    } else {
      this.nia = DEF_NIA;
    }

    //validar nombre
    if (UtilesValidacion.validar(nombre, REG_NOMBRE)) {
      this.nombre = nombre;
    } else {
      this.nombre = DEF_NOMBRE_ALUM;
    }

    //validar apellidos
    if (UtilesValidacion.validar(apellidos, REG_APE)) {
      this.apellidos = apellidos;
    } else {
      this.apellidos = DEF_APELLIDO_ALUM;
    }

    //validar DNI
    if (UtilesDNI.validar(dni)) {
      this.dni = dni;
    } else {
      this.dni = DEF_DNI;
    }

    //validar fechaNac
//    if (UtilesMatricula.validarRangoAdmision(fechaNac)) {
      this.fechaNac = fechaNac;
//    } else {
//      this.fechaNac = DEF_FECHA_NAC;
//    }

    //validar domicilio
    if (UtilesValidacion.validar(domicilio, REG_DOMI)) {
      this.domicilio = domicilio;
    } else {
      this.domicilio = DEF_DOMICILIO;
    }

    //validar cp
    if (UtilesValidacion.validar(cp, REG_CP)) {
      this.cp = cp;
    } else {
      this.cp = DEF_CP;
    }

    //validar localidad
    if (UtilesValidacion.validar(localidad, REG_NOMBRE)) {
      this.localidad = localidad;
    } else {
      this.localidad = DEF_LOCALIDAD;
    }

    //validar telf
    if (UtilesValidacion.validar(telefono, REG_TELF)) {
      this.telefono = telefono;
    } else {
      this.telefono = DEF_TELEFONO;
    }

    //validar email
    if (UtilesValidacion.validar(email, REG_MAIL)) {
      this.email = email;
    } else {
      this.email = DEF_EMAIL;
    }

    //validar tutor
    if (UtilesValidacion.validar(tutor, REG_NOMBRE)) {
      this.tutor = tutor;
    } else {
      this.tutor = DEF_TUTOR;
    }
    //validar estado
    if (UtilesMatricula.validarEstado(estado)) {
      this.estado = estado;
    } else {
      this.estado = DEF_ESTADO;
    }
  }

  public String getNia() {
    return nia;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public String getDni() {
    return dni;
  }

  public Date getFechaNac() {
    return fechaNac;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public String getCp() {
    return cp;
  }

  public String getLocalidad() {
    return localidad;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getEmail() {
    return email;
  }

  public String getTutor() {
    return tutor;
  }

  public EstadoAlumn getEstadoAlumn() {
    return estado;
  }

  public void setNia(String nia) {
    if (UtilesValidacion.validar(nia, REG_NIA)) {
      this.nia = nia;
    }
  }

  public void setNombre(String nombre) {
    if (UtilesValidacion.validar(nombre, REG_NOMBRE)) {
      this.nombre = nombre;
    }
  }

  public void setApellidos(String apellidos) {
    if (UtilesValidacion.validar(apellidos, REG_APE)) {
      this.apellidos = apellidos;
    }
  }

  public void setDni(String dni) {
    if (UtilesDNI.validar(dni)) {
      this.dni = dni;
    }
  }

  public void setFechaNac(Date fechaNac) {
    this.fechaNac = fechaNac;
  }

  public void setDomicilio(String domicilio) {
    if (UtilesValidacion.validar(domicilio, REG_DOMI)) {
      this.domicilio = domicilio;
    }
  }

  public void setCp(String cp) {
    if (UtilesValidacion.validar(cp, REG_CP)) {
      this.cp = cp;
    }
  }

  public void setLocalidad(String localidad) {
    if (UtilesValidacion.validar(localidad, REG_NOMBRE)) {
      this.localidad = localidad;
    }
  }

  public void setTelefono(String telefono) {
    if (UtilesValidacion.validar(telefono, REG_TELF)) {
      this.telefono = telefono;
    }
  }

  public void setEmail(String email) {
    if (UtilesValidacion.validar(email, REG_MAIL)) {
      this.email = email;
    }
  }

  public void setTutor(String tutor) {
    if (UtilesValidacion.validar(tutor, REG_NOMBRE)) {
      this.tutor = tutor;
    }
  }

  public void setEstadoAlumn(EstadoAlumn estado) {
    if (UtilesMatricula.validarEstado(estado)) {
      this.estado = estado;
    }
  }

  @Override
  public String toString() {
    return String.format(
            "INFO MATRICULA %s%n"
            + "==============%n"
            + "NOMBRE ......: %s%n"
            + "APELLIDOS ...: %s%n"
            + "DNI .........: %s%n"
            + "F.NACIM .....: %s%n"
            + "DOMICILIO ...: %s%n"
            + "C.POST ......: %s%n"
            + "LOCALIDAD ...: %s%n"
            + "TELF ........: %s%n"
            + "EMAIL .......: %s%n"
            + "TUTOR .......: %s%n"
            + "ESTADO ......: %s%n%n",
            nia, getNombre(), getApellidos(), getDni(),
            UtilesMatricula.formatDateTime(fechaNac),
            getDomicilio(), getCp(), getLocalidad(), getTelefono(),
            getEmail(), getTutor(), getEstadoAlumn());
  }

  public void mostrarMatricula() {
    System.out.println(toString());
  }

  @Override
  public int compareTo(Matricula o) {
    return getNia().compareTo(o.getNia());
  }

  public int compareFechas(Date d) {
    return getFechaNac().compareTo(d);
  }
}
