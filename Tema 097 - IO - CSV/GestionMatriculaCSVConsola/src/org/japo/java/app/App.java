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
package org.japo.java.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import org.japo.java.comparators.ComparadorMatricula;
import org.japo.java.entities.Matricula;
import org.japo.java.enumerations.Criterio;
import org.japo.java.enumerations.EstadoAlumn;
import org.japo.java.libraries.UtilesApp;
import org.japo.java.libraries.UtilesDNI;
import org.japo.java.libraries.UtilesMenu;
import org.japo.java.libraries.UtilesEntrada;
import org.japo.java.libraries.UtilesFecha;
import org.japo.java.libraries.UtilesMatricula;
import org.japo.java.libraries.UtilesValidacion;

/**
 *
 * @author mon_mo
 */
public final class App {

  //formato de fecha
  public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
  // Posiciones Campos CSV
  public static final int DEF_INDICE_NIA = 0;
  public static final int DEF_INDICE_NOMBRE = 1;
  public static final int DEF_INDICE_APELL = 2;
  public static final int DEF_INDICE_DNI = 3;
  public static final int DEF_INDICE_FECHA_NAC = 4;
  public static final int DEF_INDICE_DOMIC = 5;
  public static final int DEF_INDICE_CP = 6;
  public static final int DEF_INDICE_LOCAL = 7;
  public static final int DEF_INDICE_TELF = 8;
  public static final int DEF_INDICE_EMAIL = 9;
  public static final int DEF_INDICE_TUTOR = 10;
  public static final int DEF_INDICE_ESTADO = 11;

  // Expresiones Regulares Separador CSV
  public static final String REG_CSV_LECT = "\\s*,\\s*";
  public static final String REG_CSV_ESCR = ",";

  // Nombre del Fichero
  public static final String DEF_NOMBRE_FICHERO = "datos.csv";

  // Colección Items
  public static final List<Matricula> ALUMLIST = new ArrayList<Matricula>();
  public static final List<Matricula> FILTRO = new ArrayList<Matricula>();

  // Propiedades de la Aplicación
  private static final Properties prp = UtilesApp.importarPropiedades();

  /* 
  
  private static final GUI gui = new GUI();
  public static final void changePanel(int panel) {
    gui.changePanel(panel);
  }
   */
  public static final String getPrp(String key) {
    return prp.getProperty(key);
  }

  // Criterios
  private Criterio criOrd = Criterio.NINGUNO;
  private Criterio criFil = Criterio.NINGUNO;

  // Constructor
  public App() {
  }

  // Lógica de la Aplicación
  public final void launchApp() throws ParseException {

    //En teoría al lanzar la app sacaremos el GUI
    // gui.setVisible(true);
    
    
    // Menú Principal
    importarDatosRdux();  //muestra log solo si algo falla, aparentemente.
    procesarMenuPpal();

    // Mensajes de Despedida
    System.out.println("Sesión de Trabajo Finalizada");
    System.out.println("Gracias por utilizar los servicios de mon_mo Labs");
    System.out.println("Hasta la próxima");
  }

  // Menú Principal
  private void procesarMenuPpal() throws ParseException {
    // Semáforo Bucle
    boolean salirOK = false;

    // Bucle Menú Principal
    do {
      // Consola + Opciones > Opcion
      int opcion = UtilesEntrada.obtenerOpcion(UtilesMenu.TXT_MENU_PPAL,
              UtilesMenu.TXT_MENU_ERROR,
              UtilesMenu.OPC_MENU_PPAL);

      // Separación cosmética
      System.out.println("---");

      // Gestión Opciones
      switch (opcion) {
        case 1:
          procesarMenuAlumnos();
          break;
        case 2:
          procesarMenuLista();
          break;
        case 3:
          procesarMenuPersistencia();
          break;
        case 0:
          salirOK = true;
          break;
        default:
          System.out.println("---");
          System.out.println("ERROR: Opción NO disponible");
          System.out.println("---");
      }
    } while (!salirOK);
  }

  // Menú Items
  private void procesarMenuAlumnos() throws ParseException {
    // Semaforo control bucle
    boolean salirOK = false;

    // Bucle Menú
    do {
      // Consola + Opciones > Opcion
      int opcion = UtilesEntrada.obtenerOpcion(UtilesMenu.TXT_MENU_ALUM,
              UtilesMenu.TXT_MENU_ERROR,
              UtilesMenu.OPC_MENU_ALUM);

      System.out.println("---");

      switch (opcion) {
        case 1:
          altaAlumno();
          break;
        case 2:
          borrarAlumno();
          break;
        case 3:
          consultarMatricula();
          break;
        case 4:
          modificarAlumno();
          break;
        case 5:
          habilitarAlumno();
          break;
        case 6:
          deshabilitarAlumno();
          break;
        case 0:
          salirOK = true;
          break;
        default:
          System.out.println("ERROR: Opción NO disponible");
          System.out.println("---");
      }
    } while (!salirOK);
  }

  // Menú contenido
  private void procesarMenuLista() throws ParseException {
    // Semaforo control bucle
    boolean salirOK = false;

    // Bucle Menú
    do {
      // Consola + Opciones > Opcion
      int opcion = UtilesEntrada.obtenerOpcion(UtilesMenu.TXT_MENU_CONT,
              UtilesMenu.TXT_MENU_ERROR,
              UtilesMenu.OPC_MENU_CONT);

      System.out.println("---");

      switch (opcion) {
        case 1:
          listarAlumnos();
          break;
        case 2:
          procesarMenuFiltro();
          break;
        case 3:
          procesarMenuOrden();
          break;
        case 0:
          salirOK = true;
          break;
        default:
          System.out.println("ERROR: Opción NO disponible");
          System.out.println("---");
      }
    } while (!salirOK);
  }

  // Menú Ordenación
  private void procesarMenuFiltro() throws ParseException {
    // Semaforo control bucle
    boolean salirOK = false;

    // Bucle Menú
    do {
      // Consola + Opciones > Opcion
      int opcion = UtilesEntrada.obtenerOpcion(UtilesMenu.TXT_MENU_FILT,
              UtilesMenu.TXT_MENU_ERROR,
              UtilesMenu.OPC_MENU_FILT);

      // Separador
      System.out.println("---");

      // Registro Criterio
      switch (opcion) {
        case 9:
          desactivarFiltro(true);
          salirOK = true;
          break;
        case 1:
          criFil = Criterio.NIA;
          activarFiltroNIA();
          salirOK = true;
          break;
        case 2:
          criFil = Criterio.NOMBRE;
          activarFiltroNombre();
          salirOK = true;
          break;
        case 3:
          criFil = Criterio.APELLIDOS;
          activarFiltroApellidos();
          salirOK = true;
          break;
        case 4:
          criFil = Criterio.FECHA_NAC;
          activarFiltroFechaNac();
          salirOK = true;
          break;
        case 5:
          criFil = Criterio.LOCALIDAD;
          activarFiltroLocalidad();
          salirOK = true;
          break;
        case 6:
          criFil = Criterio.ACTIVO;
          activarFiltroActivo();
          salirOK = true;
          break;
        case 7:
          criFil = Criterio.BAJA;
          activarFiltroBaja();
          salirOK = true;
          break;
        case 8:
          criFil = Criterio.EN_TRAMITE;
          activarFiltroEnTramite();
          salirOK = true;
          break;
        case 0:
          salirOK = true;
          break;
        default:
          System.out.println("ERROR: Opción NO disponible");
          System.out.println("---");
      }
    } while (!salirOK);
  }

  // Menú Ordenación
  private void procesarMenuOrden() {
    // Semaforo control bucle
    boolean salirOK = false;

    // Bucle Menú
    do {
      // Consola + Opciones > Opcion
      int opcion = UtilesEntrada.obtenerOpcion(UtilesMenu.TXT_MENU_ORDE,
              UtilesMenu.TXT_MENU_ERROR,
              UtilesMenu.OPC_MENU_ORDE);

      // Separador
      System.out.println("---");

      // Registro Criterio Ordenacion
      switch (opcion) {
        case 1:
          ordenarAlumnos(Criterio.NIA);
          salirOK = true;
          break;
        case 2:
          ordenarAlumnos(Criterio.NOMBRE);
          salirOK = true;
          break;
        case 3:
          ordenarAlumnos(Criterio.APELLIDOS);
          salirOK = true;
          break;
        case 4:
          ordenarAlumnos(Criterio.FECHA_NAC);
          salirOK = true;
          break;
        case 5:
          ordenarAlumnos(Criterio.LOCALIDAD);
          salirOK = true;
          break;
        case 0:
          salirOK = true;
          break;
        default:
          System.out.println("ERROR: Opción NO disponible");
          System.out.println("---");
      }
    } while (!salirOK);
  }

  // Alumno > Colección
  private void altaAlumno() throws ParseException {
    boolean fechaOk;
    boolean mayordeOk = true;
    String nia;
    String pideFecha;
    String pideDomi;
    String pideCp;
    String pideLoc;
    String pideTelf;
    String pideEmail;
    String pideTutor;
    String dni;
    int posicion;
    Date d = null;

    // Comparador de Búsqueda
    Comparator<Matricula> cmp = new ComparadorMatricula(Criterio.NIA);
    // Ordenacion
    Collections.sort(ALUMLIST, cmp);

    // Cabecera
    System.out.println("Alta de Alumno");
    System.out.printf("==============%n%n");

    if (ALUMLIST.isEmpty()) {
      nia = Matricula.DEF_NIA;
    } else {
      // Consola > Clave / Se le pasa el último nia de la lista
      nia = UtilesMatricula.generarNia(
              ALUMLIST.get(ALUMLIST.size() - 1).getNia());

    }
    // Clave de Busqueda
    Matricula clave = new Matricula(
            nia, null, null,
            Matricula.DEF_DNI, null, null, null, null, null, null, null,
            EstadoAlumn.EN_TRAMITE);

    // Proceso de Busqueda
    posicion = Collections.binarySearch(ALUMLIST, clave, cmp);

    // Analisis Resultado Busqueda
    if (posicion < 0) {
      // Obtiene Matricula
      Matricula m = new Matricula(
              nia, null, null,
              Matricula.DEF_DNI, null, null, null, null, null, null, null,
              EstadoAlumn.EN_TRAMITE); //se crea la Matrícula EN_TRAMITE!, no null

      // Separador
//      System.out.println("---");
      // Consola > NIA
      m.setNia(nia);
      System.out.printf("NIA ...............: %s%n", nia);
      System.out.println("====================");

      // Consola > Nombre
      do {
        m.setNombre(UtilesEntrada.leerTexto("   Nombre .........: "));
      } while (m.getNombre().equals(Matricula.DEF_NOMBRE_ALUM));

      // Consola > Apellido
      do {
        m.setApellidos(UtilesEntrada.leerTexto("   Apellidos ......: "));
      } while (m.getApellidos().equals(Matricula.DEF_APELLIDO_ALUM));

      // Consola > DNI
      do {
        dni = UtilesDNI.obtener("   DNI ............: ");

        if (dni.length() != 0) {
          m.setDni(dni);
        } else {
          m.setDni("");
        }
      } while (m.getDni().equals(Matricula.DEF_DNI) && !dni.equals(""));

      // Consola > FechaNac
      do {
        do { //bucle de entrada fecha
          pideFecha = UtilesEntrada.leerTexto("   Fecha de Nac ...: ");
          if (!pideFecha.isEmpty()) {
            fechaOk = UtilesFecha.validarRegistroEdad(pideFecha);
          } else {
            fechaOk = true;  //sale porque acepta "" como condición.
          }
        } while (!fechaOk);
        //si el String pideFecha no está vacío o es null..
        if (!pideFecha.isEmpty()) {
          d = SDF.parse(pideFecha); //parsea el string y comprueba la edad.
          mayordeOk = UtilesFecha.esMayorde(d);
          if (mayordeOk) {
            m.setFechaNac(d);
          }
        }
      } while (!fechaOk);

      //Si es mayor o igual que la edad necesaria para el alta pide resto datos.
      if (mayordeOk) {
        // Consola > Domicilio
        do {
          pideDomi = UtilesEntrada.leerTexto("   Domicilio ......: ");
          m.setDomicilio(pideDomi);
        } while (m.getDomicilio().equals(Matricula.DEF_DOMICILIO)
                && !pideDomi.isEmpty());

        // Consola > Código Postal
        do {
          pideCp = UtilesEntrada.leerTexto("   Código Postal ..: ");
          m.setCp(pideCp);
        } while (m.getCp().equals(Matricula.DEF_CP) && !pideCp.isEmpty());

        // Consola > Localidad
        do {
          pideLoc = UtilesEntrada.leerTexto("   Localidad ......: ");
          m.setLocalidad(pideLoc);
        } while (m.getLocalidad().equals(Matricula.DEF_LOCALIDAD)
                && !pideLoc.isEmpty());

        // Consola > Teléfono
        do {
          pideTelf = UtilesEntrada.leerTexto("   Teléfono .......: ");
          m.setTelefono(pideTelf);
        } while (m.getTelefono().equals(Matricula.DEF_TELEFONO)
                && !pideTelf.isEmpty());

        // Consola > Email
        do {
          pideEmail = UtilesEntrada.leerTexto("   Email ..........: ");
          m.setEmail(pideEmail);
        } while (m.getEmail().equals(Matricula.DEF_EMAIL)
                && !pideEmail.isEmpty());

        // Consola > Tutor
        do {
          pideTutor = UtilesEntrada.leerTexto("   Tutor ..........: ");
          m.setTutor(pideTutor);
        } while (m.getTutor().equals(Matricula.DEF_TUTOR)
                && !pideTutor.isEmpty());

        //Si faltan datos en el alta...
        if (UtilesMatricula.checkDatosAlta(m)) {
          m.setEstadoAlumn(EstadoAlumn.EN_TRAMITE);
        } else {
          // Consola > EstadoAlumno por defecto al crear la cuenta.
          m.setEstadoAlumn(EstadoAlumn.ACTIVO);
        }

        System.out.println("------------------------------");

        // Consola > Datos Nuevo Item
        System.out.println("Alta de Alumno");
        System.out.println("--------------");
        System.out.printf("Nia ...........: %s%n", m.getNia());
        System.out.printf("Nombre ........: %s%n", m.getNombre());
        System.out.printf("Apellidos .....: %s%n", m.getApellidos());
        System.out.printf("DNI ...........: %s%n", m.getDni());
        if (m.getFechaNac() != null) {
          System.out.printf("Fecha Nac .....: %s%n", SDF.format(m.getFechaNac()));
        }
        System.out.printf("Domicilio .....: %s%n", m.getDomicilio());
        System.out.printf("Código Postal .: %s%n", m.getCp());
        System.out.printf("Localidad .....: %s%n", m.getLocalidad());
        System.out.printf("Teléfono ......: %s%n", m.getTelefono());
        System.out.printf("Email .........: %s%n", m.getEmail());
        System.out.printf("Tutor .........: %s%n", m.getTutor());
        System.out.printf("Estado ........: %s%n", m.getEstadoAlumn());

        // Separador
        System.out.println("---");

        // Confirmar Proceso
        if (UtilesEntrada.confirmarProceso(
                "Confirmar Inserción (S/n) ...: ", true)) {
          // Insercion Ítem
          ALUMLIST.add(m);

          // Mensaje Informativo
          UtilesEntrada.hacerPausa("Alumno AÑADIDO correctamente");
        } else {
          // Mensaje Informativo
          UtilesEntrada.hacerPausa("Inserción de alumno CANCELADA");
        }

      } else if (pideFecha.isEmpty()) {
        System.out.println(" SIN FECHA ESTABLECIDA en el ALTA");
      } else {
        System.out.printf("%nERROR: ALUMNO por debajo de la EDAD%n");
        System.out.printf("       SALIDA AL MENÚ PRINCIPAL ...%n%n");
      }
    }
  }

  // Matricula X Colección   //no la borra, la desactiva... 
  private void borrarAlumno() {
    // Cabecera
    System.out.println("Borrado de Matricula");
    System.out.println("====================");
    if (!ALUMLIST.isEmpty()) {
      // Consola > Clave
      String nia = UtilesEntrada.leerTexto("NIA .....: ");

      // Comparador de Búsqueda
      Comparator<Matricula> cmp = new ComparadorMatricula(Criterio.NIA);

      // Ordenacion
      Collections.sort(ALUMLIST, cmp);

      // Clave de Busqueda
      Matricula clave
              = new Matricula(nia, null, null,
                      Matricula.DEF_DNI, null, null, null, null,
                      null, null, null); // Localización

      int posicion = Collections.binarySearch(ALUMLIST, clave, cmp);

      if (posicion < 0) {
        UtilesEntrada.hacerPausa("ERROR: Matrícula NO encontrada");
      } else {
        // Obtiene Matricula
        Matricula m = ALUMLIST.get(posicion);
        //comprbación que la matrícula no es BAJA, se pueden eliminar EN_TRAMITE too

        // Separador
        System.out.println("---");

        // Muestra Datos
        System.out.println("Matricula Seleccionada");
        System.out.println("-----------------");
        m.mostrarMatricula();
        // Separador
        System.out.println("---");

        // Confirmar Proceso
        if (UtilesEntrada.confirmarProceso(
                "Confirmar Borrado (s/N) ...: ", false)) {
          // Eliminación Ítem
          ALUMLIST.remove(posicion);

          // Mensaje Informacivo
          UtilesEntrada.hacerPausa("Matrícula BORRADA correctamente");
        } else {
          // Mensaje Informacivo
          UtilesEntrada.hacerPausa("Borrado de matrícula CANCELADA");
        }
      }
      desactivarFiltro();
    } else {
      System.out.printf("%nERROR: La lista de alumnos está VACÍA.");
    }
  }

  // Colección > Matricula
  private void consultarMatricula() {
    // Cabecera
    System.out.println("Consulta Matrícula por NIA");
    System.out.println("==========================");
    if (!ALUMLIST.isEmpty()) {

      // Consola > Clave
      String nia = UtilesEntrada.leerTexto(
              "NIA .....: ");

      // Comparador de Búsqueda
      Comparator<Matricula> cmp = new ComparadorMatricula(Criterio.NIA);

      // Ordenacion
      Collections.sort(ALUMLIST, cmp);

      // Clave de Busqueda
      Matricula clave = new Matricula(nia, null, null, null,
              null, null, null, null, null, null, null);

      // Localización
      int posicion = Collections.binarySearch(ALUMLIST, clave, cmp);

      if (posicion < 0) {
        UtilesEntrada.hacerPausa("ERROR: Ítem NO encontrado");
      } else {
        // Obtiene Matricula
        Matricula m = ALUMLIST.get(posicion);

        // Separador
        System.out.println("---");

        // Muestra Datos
        m.mostrarMatricula();

        // Mensaje Informacivo
        UtilesEntrada.hacerPausa();
      }
    } else {
      System.out.printf("%nERROR: La lista de alumnos está VACÍA.");
    }
  }

  // Colección > Item > Colección
  private void modificarAlumno() throws ParseException {
    boolean fechaOk;
    boolean mayordeOk = true;
    String nombre;
    String nia;
    String pideFecha;
    String pideDomi;
    String pideCp;
    String pideLoc;
    String pideTelf;
    String pideEmail;
    String pideTutor;
    String dni;
    int posicion;
    Date d = null;

    if (!ALUMLIST.isEmpty()) {

      // Cabecera
      System.out.println("Modificación de Matricula");
      System.out.println("=========================");

      // Consola > Clave
      nia = UtilesEntrada.leerTexto("NIA .....: ");

      // Comparador de Búsqueda
      Comparator<Matricula> cmp = new ComparadorMatricula(Criterio.NIA);

      // Ordenacion
      Collections.sort(ALUMLIST, cmp);

      // Clave de Busqueda
      Matricula clave = new Matricula(nia, null, null, null,
              null, null, null, null, null, null, null);

      // Localización
      posicion = Collections.binarySearch(ALUMLIST, clave, cmp);

      if (posicion < 0) {
        UtilesEntrada.hacerPausa("ERROR: Ítem NO encontrado");
      } else {
        // Obtiene Matricula
        Matricula m = ALUMLIST.get(posicion);

//      // Separador
//      System.out.println("---");
        // Muestra Datos
        System.out.println("-----------------");
        m.mostrarMatricula();

        // Separador
        System.out.println("---");

        // Confirmar Proceso
        if (UtilesEntrada.confirmarProceso(
                "Modificar matrícula (s/N) ...: ", false)) {
          // Separador
          System.out.println("---");

          // Matrícula vacía
          Matricula aux = new Matricula(
                  nia, null, null, Matricula.DEF_DNI,
                  null, null, null, null, null, null, null,
                  EstadoAlumn.EN_TRAMITE);

          // Item Modificado
          System.out.println("Matrícula Modificada");
          System.out.println("--------------------");
          // Consola > Nombre
          do {
            nombre = UtilesEntrada.leerTexto("   Nombre .........: ");
            if (!nombre.isEmpty()) {
              aux.setNombre(nombre);
            } else {
              aux.setNombre(m.getNombre());
            }
          } while (aux.getNombre().equals(Matricula.DEF_NOMBRE_ALUM));

          // Consola > Apellido
          do {
            String ape = UtilesEntrada.leerTexto("   Apellidos ......: ");
            if (!ape.isEmpty()) {
              aux.setApellidos(ape);
            } else {
              aux.setApellidos(m.getApellidos());
            }
          } while (aux.getApellidos().equals(Matricula.DEF_APELLIDO_ALUM));

          // Consola > DNI
          do {
            dni = UtilesDNI.obtener("   DNI ............: ");
            if (dni.length() != 0) {
              aux.setDni(dni);
            } else {
              aux.setDni(m.getDni());
            }
          } while (aux.getDni().equals(Matricula.DEF_DNI) && !dni.equals(""));

          // Consola > FechaNac
          do {
            do { //bucle de entrada fecha
              pideFecha = UtilesEntrada.leerTexto("   Fecha de Nac ...: ");
              if (!pideFecha.isEmpty()) {
                fechaOk = UtilesFecha.validarRegistroEdad(pideFecha);
              } else {
                aux.setFechaNac(m.getFechaNac());
                fechaOk = true;  //sale porque acepta "" como condición.
              }
            } while (!fechaOk);
            //si el String pideFecha no está vacío o es null..
            if (!pideFecha.isEmpty()) {
              d = SDF.parse(pideFecha); //parsea el string y comprueba la edad.
              mayordeOk = UtilesFecha.esMayorde(d);
              if (mayordeOk) {
                aux.setFechaNac(d);
              }
            }
          } while (!fechaOk);

          //Si es mayor o igual que la edad necesaria para el alta pide resto datos.
          if (mayordeOk) {
            // Consola > Domicilio
            do {
              pideDomi = UtilesEntrada.leerTexto("   Domicilio ......: ");
              if (!pideDomi.isEmpty()) {
                aux.setDomicilio(pideDomi);
              } else {
                aux.setDomicilio(m.getDomicilio());
              }
            } while (aux.getDomicilio().equals(Matricula.DEF_DOMICILIO));

            // Consola > Código Postal
            do {
              pideCp = UtilesEntrada.leerTexto("   Código Postal ..: ");
              if (!pideCp.isEmpty()) {
                aux.setCp(pideCp);
              } else {
                aux.setCp(m.getCp());
              }
            } while (aux.getCp().equals(Matricula.DEF_CP));

            // Consola > Localidad
            do {
              pideLoc = UtilesEntrada.leerTexto("   Localidad ......: ");
              if (!pideLoc.isEmpty()) {
                aux.setLocalidad(pideLoc);
              } else {
                aux.setLocalidad(m.getLocalidad());
              }
            } while (aux.getLocalidad().equals(Matricula.DEF_LOCALIDAD));

            // Consola > Teléfono
            do {
              pideTelf = UtilesEntrada.leerTexto("   Teléfono .......: ");
              if (!pideTelf.isEmpty()) {
                aux.setTelefono(pideTelf);
              } else {
                aux.setTelefono(m.getTelefono());
              }
            } while (aux.getTelefono().equals(Matricula.DEF_TELEFONO));

            // Consola > Email
            do {
              pideEmail = UtilesEntrada.leerTexto("   Email ..........: ");
              if (!pideEmail.isEmpty()) {
                aux.setEmail(pideEmail);
              } else {
                aux.setEmail(m.getEmail());
              }
            } while (aux.getEmail().equals(Matricula.DEF_EMAIL)
                    && !pideEmail.isEmpty());

            // Consola > Tutor
            do {
              pideTutor = UtilesEntrada.leerTexto("   Tutor ..........: ");
              if (!pideTutor.isEmpty()) {
                aux.setTutor(pideTutor);
              } else {
                aux.setTutor(m.getTutor());
              }
            } while (aux.getTutor().equals(Matricula.DEF_TUTOR));
            String estado;
            do {
              // Consola > EstadoAluauxno por defecto al crear la cuenta.
              estado = UtilesEntrada.leerTexto("   Estado .........: ");
              if (UtilesMatricula.validarEstado(
                      UtilesMatricula.generarEstado(m, estado))) {
                aux.setEstadoAlumn(UtilesMatricula.generarEstado(m, estado));
              } else {
                System.out.println("ERROR: Estado INCORRECTO");
                System.out.println("---");
              }
            } while (!UtilesMatricula.validarEstado(
                    UtilesMatricula.generarEstado(m, estado)));

            System.out.println("------------------------------");
            aux.mostrarMatricula();
            // Separador
            System.out.println("---");

            // Confirmar Sustitución
            if (UtilesEntrada.confirmarProceso(
                    "Guardar cambios (s/N) ...: ", false)) {
              // Sustitución Item
              ALUMLIST.set(posicion, aux);

              // Mensaje Informacivo
              UtilesEntrada.hacerPausa("MAtrícula MODIFICADA correctamente");
            } else {
              // Mensaje Informacivo
              UtilesEntrada.hacerPausa("Modificación de Matrícula CANCELADA");
            }
          } else {
            // Mensaje Informacivo
            UtilesEntrada.hacerPausa("Modificación de Matrícula CANCELADA");
          }
        }
      }
    } else {
      System.out.printf("%nERROR: La lista de alumnos está VACÍA.");
    }
  }

  private void habilitarAlumno() {
    String nia;

    if (!ALUMLIST.isEmpty()) {
      System.out.println("Habilitar ALUMNO de BAJA");
      System.out.printf("========================%n%n");

      // Registrar Filtro
      criFil = Criterio.BAJA;

      // Vaciar Filtro
      FILTRO.clear();

      // Muestra lista de matrículas estado BAJA
      for (Matricula mat : ALUMLIST) {
        if (mat.getEstadoAlumn().equals(EstadoAlumn.BAJA)) {
          FILTRO.add(mat);
          mat.mostrarMatricula();
        }
      }
      do {
        nia = UtilesEntrada.leerTexto("¿Qué NIA desea habilitar? "
                + "(" + "\"exit\" para salir" + ")" + " ..: ");

        if (UtilesValidacion.validar(nia, Matricula.REG_NIA)) {
          // Registrar Filtro
          criFil = Criterio.NIA;

          // Filtrado de Datos
          for (Matricula mat : ALUMLIST) {
            if (mat.getNia().equals(nia)
                    && mat.getEstadoAlumn().equals(EstadoAlumn.BAJA)) {
              mat.setEstadoAlumn(EstadoAlumn.ACTIVO);  //set ACTIVO
              System.out.printf("%nALUMNO habilitado CORRECTAMENTE%n%n");
            } else if (mat.getNia().equals(nia)
                    && !mat.getEstadoAlumn().equals(EstadoAlumn.BAJA)) {
              System.out.printf("%nERROR: Estado del alumno NO es baja.%n%n");
            }
          }
        } else if (nia.equalsIgnoreCase("exit")) {
          //separador
          System.out.println();
        } else {
          System.out.printf("%nERROR: NIA introducido NO válido%n---%n");
        }
      } while (!UtilesValidacion.validar(nia, Matricula.REG_NIA)
              && !nia.equals("exit"));
      // Devuelve el filtro a ninguno
      criFil = Criterio.NINGUNO;
    } else {
      System.out.printf("%nERROR: La lista de alumnos está VACÍA.");
    }
  }

  private void deshabilitarAlumno() {
    String nia;

    if (!ALUMLIST.isEmpty()) {
      System.out.println("Deshabilitar ALUMNO de ALTA");
      System.out.println("===========================");

      // Registrar Filtro
      criFil = Criterio.ACTIVO;

      // Vaciar Filtro
      FILTRO.clear();

      // Filtrado de Datos 
      for (Matricula mat : ALUMLIST) {
        if (mat.getEstadoAlumn().equals(EstadoAlumn.ACTIVO)) {
          FILTRO.add(mat);
          mat.mostrarMatricula();
        }
      }
      do {
        nia = UtilesEntrada.leerTexto("¿Qué NIA desea deshabilitar? "
                + "(" + "\"exit\" para salir" + ")" + " ..: ");

        if (UtilesValidacion.validar(nia, Matricula.REG_NIA)) {
          // Registrar Filtro
          criFil = Criterio.NIA;

          // Filtrado de Datos
          for (Matricula mat : ALUMLIST) {
            if (mat.getNia().equals(nia)
                    && mat.getEstadoAlumn().equals(EstadoAlumn.BAJA)) {
              mat.setEstadoAlumn(EstadoAlumn.BAJA);  //set BAJA
              System.out.printf("%nALUMNO deshabilitado CORRECTAMENTE%n%n");
            } else if (mat.getNia().equals(nia)
                    && !mat.getEstadoAlumn().equals(EstadoAlumn.ACTIVO)) {
              System.out.printf("%nERROR: Estado del alumno NO es ACTIVO.%n%n");
            }
          }
        } else if (nia.equalsIgnoreCase("exit")) {
          //separador
          System.out.println();
        } else {
          System.out.printf("%nERROR: NIA introducido NO válido%n---%n");
        }
      } while (!UtilesValidacion.validar(nia, Matricula.REG_NIA)
              && !nia.equals("exit"));

      // Devuelve el filtro a ninguno
      criFil = Criterio.NINGUNO;
    } else {
      System.out.printf("%nERROR: La lista de alumnos está VACÍA.");
    }
  }

  // Lista > Listado Consola
  private void listarAlumnos() {
    // Cabecera
    System.out.println("Listado de Alumnos");
    System.out.println("================");

    if (!ALUMLIST.isEmpty()) {
      // Criterio de Ordenación/Filtrado
      System.out.printf("Criterio de Ordenación .: %S%n", criOrd.getNombre());
      System.out.printf("Criterio de Filtrado ...: %S%n", criFil.getNombre());

      // Separados
      System.out.println("---");

      // Filtrado > Selección Colección
      List<Matricula> lista = criFil.equals(Criterio.NINGUNO) ? ALUMLIST : FILTRO;

      // Recorrido Colección
      for (Matricula mat : lista) {
        mat.mostrarMatricula();
      }
    } else {
      System.out.printf("%nERROR: La lista de alumnos está VACÍA.");
    }

    // Pausa
    UtilesEntrada.hacerPausa();
  }

  // Lista > Ordenada por NIA
  private void ordenarAlumnos(Criterio criOrd) {
    // Ordenación > Desactivación Filtro
    desactivarFiltro();

    // Registra Criterio Ordenación
    this.criOrd = criOrd;

    // Ordenación Colección
    Collections.sort(ALUMLIST, new ComparadorMatricula(criOrd));

    // Mensaje
    System.out.printf("Alumnos ordenados por %s%n", criOrd.getNombre());

    // Pausa
    UtilesEntrada.hacerPausa();
  }

  //
  //                           FILTROS
  //
  private void desactivarFiltro() {
    // Registra Estado Filtro
    criFil = Criterio.NINGUNO;

    // Vacia Filtro
    FILTRO.clear();
  }

  private void desactivarFiltro(boolean pausaOK) {
    // Registra Estado Filtro
    criFil = Criterio.NINGUNO;

    // Vacia Filtro
    FILTRO.clear();

    // Mensaje Informativo
    if (pausaOK) {
      UtilesEntrada.hacerPausa("Filtro DESACTIVADO");
    } else {
      System.out.println("Filtro DESACTIVADO");
    }
  }

  // Filtro ID
  private void activarFiltroNIA() {
    System.out.println("Activación Filtro NIA");
    System.out.println("=====================");

    // Registrar Filtro
    criFil = Criterio.NIA;

    // Establecer Rango
    int niaMin = UtilesEntrada.leerEntero("NIA mínimo ....: ",
            "ERROR: Entrada incorrecta", 0, Integer.MAX_VALUE);
    int niaMax = UtilesEntrada.leerEntero("NIA máximo ....: ",
            "ERROR: Entrada incorrecta", niaMin, Integer.MAX_VALUE);

    // Vaciar Filtro
    FILTRO.clear();

    // Filtrado de Datos
    for (Matricula mat : ALUMLIST) {
      if (Integer.parseInt(mat.getNia()) >= niaMin
              && Integer.parseInt(mat.getNia()) <= niaMax) {
        FILTRO.add(mat);
      }
    }

    // Mensaje Informativo
    UtilesEntrada.hacerPausa("Filtro pod NIA establecido");
  }

  private void activarFiltroNombre() {
    System.out.println("Activación Filtro NOMBRE");
    System.out.println("========================");

    // Registrar Filtro
    criFil = Criterio.NOMBRE;

    // Establecer Patrón
    String nombre = UtilesEntrada.leerTexto("Patrón Nombre ...: ");

    // Expresion Regular
    String patron = String.format(".*%s.*", nombre);

    // Vaciar Filtro
    FILTRO.clear();

    // Filtrado de Datos
    for (Matricula mat : ALUMLIST) {
      if (UtilesValidacion.validar(mat.getNombre(), patron)) {
        FILTRO.add(mat);
      }
    }

    // Mensaje Informativo
    UtilesEntrada.hacerPausa("Filtro por NOMBRE establecido");
  }

  private void activarFiltroApellidos() {
    System.out.println("Activación Filtro APELLIDOS");
    System.out.println("===========================");

    // Registrar Filtro
    criFil = Criterio.APELLIDOS;

    // Establecer Patrón
    String nombre = UtilesEntrada.leerTexto("Patrón Apellidos ...: ");

    // Expresion Regular
    String patron = String.format(".*%s.*", nombre);

    // Vaciar Filtro
    FILTRO.clear();

    // Filtrado de Datos
    for (Matricula mat : ALUMLIST) {
      if (UtilesValidacion.validar(mat.getApellidos(), patron)) {
        FILTRO.add(mat);
      }
    }

    // Mensaje Informativo
    UtilesEntrada.hacerPausa("Filtro por Apellidos establecido");
  }

  private void activarFiltroLocalidad() {
    System.out.println("Activación Filtro LOCALIDAD");
    System.out.println("===========================");

    // Registrar Filtro
    criFil = Criterio.LOCALIDAD;

    // Establecer Patrón
    String nombre = UtilesEntrada.leerTexto("Patrón Localidad ...: ");

    // Expresion Regular
    String patron = String.format(".*%s.*", nombre);

    // Vaciar Filtro
    FILTRO.clear();

    // Filtrado de Datos
    for (Matricula mat : ALUMLIST) {
      if (UtilesValidacion.validar(mat.getLocalidad(), patron)) {
        FILTRO.add(mat);
      }
    }

    // Mensaje Informativo
    UtilesEntrada.hacerPausa("Filtro por Localidad establecido");
  }

  private void activarFiltroFechaNac() throws ParseException {
    System.out.println("Activación Filtro FECHA NAC");
    System.out.println("===========================");

    // Registrar Filtro
    criFil = Criterio.FECHA_NAC;

    // Establecer Rango
    Date fechaMin = UtilesEntrada.leerFecha("Fecha mínima ....: ");
    Date fechaMax = UtilesEntrada.leerFecha("Fecha máxima ....: ");

    FILTRO.clear();

    for (Matricula mat : ALUMLIST) {
      if (mat.getFechaNac().compareTo(fechaMin) > -1
              && mat.getFechaNac().compareTo(fechaMax) < 1) {
        FILTRO.add(mat);
      }
    }

    // Mensaje Informativo
    UtilesEntrada.hacerPausa("Filtro por FECHA establecido");
  }

  private void activarFiltroActivo() {
    System.out.println("Activación Filtro ACTIVO");
    System.out.println("========================");

    // Registrar Filtro
    criFil = Criterio.ACTIVO;

    // Vaciar Filtro
    FILTRO.clear();

    // Filtrado de Datos
    for (Matricula mat : ALUMLIST) {
      if (mat.getEstadoAlumn().equals(EstadoAlumn.ACTIVO)) {
        FILTRO.add(mat);
      }
    }
    // Mensaje Informativo
    UtilesEntrada.hacerPausa("Filtro por alumno ACTIVO establecido");
  }

  private void activarFiltroBaja() {
    System.out.println("Activación Filtro BAJA");
    System.out.println("======================");

    // Registrar Filtro
    criFil = Criterio.BAJA;

    // Vaciar Filtro
    FILTRO.clear();

    // Filtrado de Datos
    for (Matricula mat : ALUMLIST) {
      if (mat.getEstadoAlumn().equals(EstadoAlumn.BAJA)) {
        FILTRO.add(mat);
      }
    }
    // Mensaje Informativo
    UtilesEntrada.hacerPausa("Filtro por alumno BAJA establecido");
  }

  private void activarFiltroEnTramite() {
    System.out.println("Activación Filtro EN_TRAMITE");
    System.out.println("============================");

    // Registrar Filtro
    criFil = Criterio.EN_TRAMITE;

    // Vaciar Filtro
    FILTRO.clear();

    // Filtrado de Datos
    for (Matricula mat : ALUMLIST) {
      if (mat.getEstadoAlumn().equals(EstadoAlumn.EN_TRAMITE)) {
        FILTRO.add(mat);
      }
    }
    // Mensaje Informativo
    UtilesEntrada.hacerPausa("Filtro por alumno EN_TRAMITE establecido");
  }

  // Menú Entrada / Salida
  private void procesarMenuPersistencia() throws ParseException {
    // Semaforo control bucle
    boolean salirOK = false;

    // Bucle Menú
    do {
      // Consola + Opciones > Opcion
      int opcion = UtilesEntrada.obtenerOpcion(UtilesMenu.TXT_MENU_PERS,
              UtilesMenu.TXT_MENU_ERROR,
              UtilesMenu.OPC_MENU_PERS);

      // Separador
      System.out.println("---");

      // Registro Criterio Ordenacion
      switch (opcion) {
        case 1:
          importarDatos();
          salirOK = true;
          break;
        case 2:
          exportarDatos();
          salirOK = true;
          break;
        case 0:
          salirOK = true;
          break;
        default:
          System.out.println("ERROR: Opción NO disponible");
          System.out.println("---");
      }
    } while (!salirOK);
  }

  // Fichero CSV > ALUMLIST
  private void importarDatos() throws ParseException {
    // Cabecera
    System.out.println("Importación de Datos");
    System.out.println("====================");

    // Acceso al Fichero
    try (
            FileReader fr = new FileReader(DEF_NOMBRE_FICHERO);
            BufferedReader br = new BufferedReader(fr)) {
      // Colección Auxiliar
      final List<Matricula> AUX = new ArrayList<>();

      // Bucle de Lectura
      boolean lecturaOK = true;
      do {
        // Lectura Linea Actual
        String linea = br.readLine();

        // Procesar Lectura
        if (linea != null) {
          // String > Array
          String[] mat = linea.split(REG_CSV_LECT);

          // Campo 0 - NIA ( String )
          String nia = mat[DEF_INDICE_NIA].trim();

          // Campo 1 - nombre ( String )
          String nombre = mat[DEF_INDICE_NOMBRE].trim();

          // Campo 2 - apell ( String )
          String apell = mat[DEF_INDICE_APELL].trim();

          // Campo 3 - DNI ( String )
          String dni = mat[DEF_INDICE_DNI].trim();

          // Campo 4 - Fecha ( Date )
          Date date;
          try {
            date = SDF.parse(mat[DEF_INDICE_FECHA_NAC].trim());
          } catch (ParseException parseException) {
            date = Date.from(Instant.EPOCH);
          }

          // Campo 5 - Domicilio ( String )
          String domic = mat[DEF_INDICE_DOMIC].trim();

          // Campo 6 - Código post ( String )
          String cp = mat[DEF_INDICE_CP].trim();

          // Campo 7 - Localidad ( String )
          String loc = mat[DEF_INDICE_LOCAL].trim();

          // Campo 8 - Teléfono ( String )
          String telf = mat[DEF_INDICE_TELF].trim();

          // Campo 9 - Email ( String )
          String mail = mat[DEF_INDICE_EMAIL].trim();

          // Campo 10 - Tutor ( String )
          String tutor = mat[DEF_INDICE_TUTOR].trim();

          //Campo 11 - EstadoAlumno ( EstadoAlumno )
          EstadoAlumn estado = UtilesMatricula.generarEstado(
                  mat[DEF_INDICE_ESTADO].trim());

          // Generar Nuevo Item
          Matricula matr = new Matricula(nia, nombre, apell, dni,
                  date, domic, cp, loc, telf, mail, tutor, estado);

          // Matrícula > Carrito
          AUX.add(matr);
//                    System.out.println("Importado: " + Matrícula);
        } else {
          lecturaOK = false;
        }
      } while (lecturaOK);

      // Vaciar Carrito
      ALUMLIST.clear();

      // AUX > ALUMLIST
      ALUMLIST.addAll(AUX);

      // Mensaje Informativo
      UtilesEntrada.hacerPausa("Datos importados correctamente");
    } catch (NumberFormatException | NullPointerException e) {
      // Mensaje Informativo
      UtilesEntrada.hacerPausa("ERROR: Formato de datos incorrecto");

      // Vaciado lista
      ALUMLIST.clear();
    } catch (IOException e) {
      // Mensaje Informativo
      UtilesEntrada.hacerPausa("ERROR: Acceso al fichero");
    }
  }

  // Fichero CSV > ALUMLIST
  private void importarDatosRdux() throws ParseException {
    // Acceso al Fichero
    try (
            FileReader fr = new FileReader(DEF_NOMBRE_FICHERO);
            BufferedReader br = new BufferedReader(fr)) {
      // Colección Auxiliar
      final List<Matricula> AUX = new ArrayList<>();

      // Bucle de Lectura
      boolean lecturaOK = true;
      do {
        // Lectura Linea Actual
        String linea = br.readLine();

        // Procesar Lectura
        if (linea != null) {
          // String > Array
          String[] mat = linea.split(REG_CSV_LECT);

          // Campo 0 - NIA ( String )
          String nia = mat[DEF_INDICE_NIA].trim();

          // Campo 1 - nombre ( String )
          String nombre = mat[DEF_INDICE_NOMBRE].trim();

          // Campo 2 - apell ( String )
          String apell = mat[DEF_INDICE_APELL].trim();

          // Campo 3 - DNI ( String )
          String dni = mat[DEF_INDICE_DNI].trim();

          // Campo 4 - Fecha ( Date )
          Date date;
          try {
            date = SDF.parse(mat[DEF_INDICE_FECHA_NAC].trim());
          } catch (ParseException parseException) {
            date = null;
          }

          // Campo 5 - Domicilio ( String )
          String domic = mat[DEF_INDICE_DOMIC].trim();

          // Campo 6 - Código post ( String )
          String cp = mat[DEF_INDICE_CP].trim();

          // Campo 7 - Localidad ( String )
          String loc = mat[DEF_INDICE_LOCAL].trim();

          // Campo 8 - Teléfono ( String )
          String telf = mat[DEF_INDICE_TELF].trim();

          // Campo 9 - Email ( String )
          String mail = mat[DEF_INDICE_EMAIL].trim();

          // Campo 10 - Tutor ( String )
          String tutor = mat[DEF_INDICE_TUTOR].trim();

          //Campo 11 - EstadoAlumno ( EstadoAlumno )
          EstadoAlumn estado = UtilesMatricula.generarEstado(
                  mat[DEF_INDICE_ESTADO].trim());

          // Generar Nuevo Item
          Matricula matr = new Matricula(nia, nombre, apell, dni,
                  date, domic, cp, loc, telf, mail, tutor, estado);

          // Item > Carrito
          AUX.add(matr);
//                    System.out.println("Importado: " + matr);
        } else {
          lecturaOK = false;
        }
      } while (lecturaOK);

      // Vaciar Carrito
      ALUMLIST.clear();

      // AUX > ALUMLIST
      ALUMLIST.addAll(AUX);

    } catch (NumberFormatException | NullPointerException e) {
      // Mensaje Informativo
      UtilesEntrada.hacerPausa("ERROR: Formato de datos incorrecto");

      // Vaciado lista
      ALUMLIST.clear();
    } catch (IOException e) {
      // Mensaje Informativo
      UtilesEntrada.hacerPausa("ERROR: Acceso al fichero");
    }
  }

  // ALUMLIST > Fichero CSV
  private void exportarDatos() {
    // Cabecera
    System.out.println("Exportación de Datos");
    System.out.println("====================");

    // Acceso al Fichero
    try (PrintWriter pr = new PrintWriter(DEF_NOMBRE_FICHERO)) {
      // Bucle de Escritura
      for (Matricula mat : ALUMLIST) {
        // Generar Linea de Texto
        String linea = String.format(Locale.ENGLISH, "%s%s%s%s%s%s%s%s%s%s%s%s",
                mat.getNia() + REG_CSV_ESCR,
                mat.getNombre() + REG_CSV_ESCR,
                mat.getApellidos() + REG_CSV_ESCR,
                mat.getDni() + REG_CSV_ESCR,
                UtilesMatricula.formatDateTime(mat.getFechaNac()) + REG_CSV_ESCR,
                mat.getDomicilio() + REG_CSV_ESCR,
                mat.getCp() + REG_CSV_ESCR,
                mat.getLocalidad() + REG_CSV_ESCR,
                mat.getTelefono() + REG_CSV_ESCR,
                mat.getEmail() + REG_CSV_ESCR,
                mat.getTutor() + REG_CSV_ESCR,
                UtilesMatricula.obtenerNombreEstado(mat.getEstadoAlumn()));

        // Item > Fichero
        pr.println(linea);
      }

      // Mensaje Informativo
      UtilesEntrada.hacerPausa("Datos exportados correctamente");
    } catch (NumberFormatException | NullPointerException e) {
      // Mensaje Informativo
      UtilesEntrada.hacerPausa("ERROR: Formato de datos incorrecto");

      // Vaciado Carrito
      ALUMLIST.clear();
    } catch (IOException e) {
      // Mensaje Informativo
      UtilesEntrada.hacerPausa("ERROR: Acceso al fichero");
    }
  }

}
