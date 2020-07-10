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

import org.japo.java.entities.Alquiler;
import org.japo.java.entities.Camion;
import org.japo.java.entities.Coche;
import org.japo.java.entities.Conductor;
import org.japo.java.entities.Matricula;
import org.japo.java.entities.MicroBus;
import org.japo.java.entities.Vehiculo;
import org.japo.java.enums.Color;
import org.japo.java.enums.Tipo;
import org.japo.java.libraries.UtilesEntrada;
import org.japo.java.lists.ListaAlquilados;
import org.japo.java.lists.ListaVehiculos;

/**
 *
 * @author mon_mo
 */
public final class App {

  public static final String MSG_OP = "Introduzca una opción: ";
  public static final String MSG_ERR = "ERROR: Opción incorrecta.";
  public static final String MSG_MATR = "Introduzca matrícula: ";
  public static final String MSG_MARC = "Introduzca marca: ";
  public static final String MSG_COL = "Introduzca color: ";
  public static final String MSG_DIAS = "Número de días de alquiler: ";
  public static final String MSG_DNI = "Introduce el DNI del conductor: ";
  //microbus
  public static final String MSG_MICRO_PL = "Introduzca plazas: ";
  public static final int DEF_MINI_METROS = 12;
  //cambion
  public static final int DEF_PMA = 3500;
  public static final int DEF_CAM_RUE = 12;

  public final void launchApp() {
    //Instanciamos cosas varias
    boolean ok;
    int opcion;
    int plazas;
    int dias;

    String matricula = null;
    String marca;
    String color;
    String dni;

    Color c = null;

    Coche coche;
    MicroBus microbus;
    Camion camion;
    Vehiculo v;
    Conductor conductor;

    Alquiler alq;
    ListaVehiculos milista = new ListaVehiculos();
    ListaAlquilados listaAlquilados = new ListaAlquilados();
    
    
    //Objetos para rellenar el arraylist
    Coche c1Coche = new Coche(2, "1111-AAA");
    Coche c2Coche = new Coche(3, "2222-AAA");
    Coche c3Coche = new Coche(6, "Renol", Color.AMARILLO, 
            Tipo.ELÉCTRICO, 1200, 1, "3333-AAA");
    
    Camion camion1 = new Camion(6000, 14);
    camion1.setMatricula("5555-AAA");
    camion1.setMarca("Renol Camión");
    
    Camion camion2 = new Camion(7500, 12, "4444-AAA");
    camion2.setAnyos(14);
    camion2.setMarca("Mercedes CV137");
    
    MicroBus micro1 = new MicroBus(14, 20);
    micro1.setMatricula("6666-AAA");
    MicroBus micro2 = new MicroBus(20, "7777-AAA");
    
    milista.addVehiculo(c1Coche);
    milista.addVehiculo(c2Coche);
    milista.addVehiculo(c3Coche);
    milista.addVehiculo(camion1);
    milista.addVehiculo(camion2);
    milista.addVehiculo(micro1);
    milista.addVehiculo(micro2);

    System.out.println(" GESTOR DE ALQUILER DE VEHÍCULOS ");
    System.out.println(" -------------------------------");
    System.out.println();

    do {
      mostrarMenu();
      opcion = UtilesEntrada.leerEntero(MSG_OP, MSG_ERR);

      switch (opcion) {
//Añadir coche
        case 1:
          boolean isOk = false;
          //Validamos el formato de la matrícula
          do {
            matricula = UtilesEntrada.leerTexto(MSG_MATR);
            if (!matricula.matches(Matricula.EXP_MATRICULA)) {
              System.out.println("ERROR: Formato de matrícula incorrecto");
            } else {
              isOk = true;
            }
          } while (!isOk);
          //La marca puede ser random, está sin filtro
          marca = UtilesEntrada.leerTexto(MSG_MARC);
          //Validador del color del coche
          do {
            c = null;
            color = UtilesEntrada.leerTexto(MSG_COL).toLowerCase();
            switch (color) {
              case "blanco":
                c = Color.BLANCO;
                break;
              case "negro":
                c = Color.NEGRO;
                break;
              case "amarillo":
                c = Color.AMARILLO;
                break;
              case "azul":
                c = Color.AZUL;
                break;
              case "verde":
                c = Color.VERDE;
                break;
              case "rojo":
                c = Color.ROJO;
                break;
              default:
                System.out.println("ERROR: Color introducido incorrecto");
            }
          } while (c == null);
          // int plazas, String marca, Color color, Tipo motor, 
          //int cilindrada, int anyos, String matricula
          coche = new Coche(6, marca, c, Tipo.DIESEL, 300, 4, matricula);
          ok = milista.addVehiculo(coche);
          if (ok) {
            System.out.println();
            System.out.println("Coche añadido.");
            System.out.println();
          } else {
            System.out.println();
            System.out.println("No se ha podido añadir el coche.");
            System.out.println();
          }
          break;

        case 2:
//Añadir microbus
          isOk = false;
          //Validamos el formato de la matrícula
          do {
            matricula = UtilesEntrada.leerTexto(MSG_MATR);
            if (!matricula.matches(Matricula.EXP_MATRICULA)) {
              System.out.println("ERROR: Formato de matrícula incorrecto");
            } else {
              isOk = true;
            }
          } while (!isOk);
          //La marca puede ser random, está sin filtro
          marca = UtilesEntrada.leerTexto(MSG_MARC);
          //Validamos el núm de plazas del Microbus......
          do {
            plazas = UtilesEntrada.leerEntero(MSG_MICRO_PL, MSG_ERR);
            if (plazas < 1 || plazas > 20) {
              System.out.println("ERROR: Número de plazas fuera de límite");
            }
          } while (plazas < 1 || plazas > 20);

          //Validador del color del microbus
          do {
            c = null;
            color = UtilesEntrada.leerTexto(MSG_COL).toLowerCase();
            switch (color) {
              case "blanco":
                c = Color.BLANCO;
                break;
              case "negro":
                c = Color.NEGRO;
                break;
              case "amarillo":
                c = Color.AMARILLO;
                break;
              case "azul":
                c = Color.AZUL;
                break;
              case "verde":
                c = Color.VERDE;
                break;
              case "rojo":
                c = Color.ROJO;
                break;
              default:
                System.out.println("ERROR: Color introducido incorrecto");
            }
          } while (c == null);
          // int plazas, String marca, Color color, Tipo motor, 
          //int cilindrada, int anyos, String matricula
          microbus = new MicroBus(plazas, DEF_MINI_METROS);
          ok = milista.addVehiculo(microbus);
          if (ok) {
            System.out.println();
            System.out.println("Microbus añadido.");
            System.out.println();
          } else {
            System.out.println();
            System.out.println("No se ha podido añadir el microbus.");
            System.out.println();
          }
          break;

//Añadir camion
        case 3:
          isOk = false;
          //Validamos el formato de la matrícula
          do {
            matricula = UtilesEntrada.leerTexto(MSG_MATR);
            if (!matricula.matches(Matricula.EXP_MATRICULA)) {
              System.out.println("ERROR: Formato de matrícula incorrecto");
            } else {
              isOk = true;
            }
          } while (!isOk);
          //La marca puede ser random, está sin filtro
          marca = UtilesEntrada.leerTexto(MSG_MARC);
          //Validador del color del coche
          do {
            c = null;
            color = UtilesEntrada.leerTexto(MSG_COL).toLowerCase();
            switch (color) {
              case "blanco":
                c = Color.BLANCO;
                break;
              case "negro":
                c = Color.NEGRO;
                break;
              case "amarillo":
                c = Color.AMARILLO;
                break;
              case "azul":
                c = Color.AZUL;
                break;
              case "verde":
                c = Color.VERDE;
                break;
              case "rojo":
                c = Color.ROJO;
                break;
              default:
                System.out.println("ERROR: Color introducido incorrecto");
            }
          } while (c == null);
          // int plazas, String marca, Color color, Tipo motor, 
          //int cilindrada, int anyos, String matricula
          camion = new Camion(DEF_PMA, DEF_CAM_RUE, marca, c, Tipo.DIESEL, 500, 4, matricula);
          ok = milista.addVehiculo(camion);
          if (ok) {
            System.out.println();
            System.out.println("Camión añadido.");
            System.out.println();
          } else {
            System.out.println();
            System.out.println("No se ha podido añadir el camión.");
            System.out.println();
          }
          break;

//Sigue con la opción 4 - Precio alquiler vehículo por matricula 
        case 4:
          isOk = false;
          //Validamos el formato de la matrícula
          do {
            matricula = UtilesEntrada.leerTexto(MSG_MATR);
            if (!matricula.matches(Matricula.EXP_MATRICULA)) {
              System.out.println("ERROR: Formato de matrícula incorrecto");
            } else {
              isOk = true;
            }
          } while (!isOk);

          v = milista.buscaVehiculo(matricula);
          if (v != null) {
            do {
              dias = UtilesEntrada.leerEntero(MSG_DIAS, MSG_ERR);
              if (dias <= 0) {
                System.out.println("ERROR: Nº de días incorrecto");
              }
            } while (dias <= 0);
            System.out.printf("%nEl precio total a pagar por %d días"
                    + " es de %.2f €%n%n", dias, v.precioAlquiler(dias));
          } else {
            System.out.printf("%nERROR: Vehículo NO encontrado%n");
          }
          break;
//Caso 5 - todos los precios de un día
        case 5:
          if (milista.numVehiculos() > 0) {
            milista.mostrarPrecios(1);
          } else {
            System.out.println("ERROR: No hay vehículos.");
          }
          break;
//Caso 6 - CAMBIO DE COLOR          
        case 6:
          isOk = false;
          System.out.println("Cambio de color");
          System.out.println("---------------");
          //Validamos el formato de la matrícula
          do {
            matricula = UtilesEntrada.leerTexto(MSG_MATR);
            if (!matricula.matches(Matricula.EXP_MATRICULA)) {
              System.out.println("ERROR: Formato de matrícula incorrecto");
            } else {
              isOk = true;
            }
          } while (!isOk);

          v = milista.buscaVehiculo(matricula);

          if (v != null) {
            do {
              c = null;
              color = UtilesEntrada.leerTexto(MSG_COL).toLowerCase();
              switch (color) {
                case "blanco":
                  c = Color.BLANCO;
                  break;
                case "negro":
                  c = Color.NEGRO;
                  break;
                case "amarillo":
                  c = Color.AMARILLO;
                  break;
                case "azul":
                  c = Color.AZUL;
                  break;
                case "verde":
                  c = Color.VERDE;
                  break;
                case "rojo":
                  c = Color.ROJO;
                  break;
                default:
                  System.out.println("ERROR: Color introducido incorrecto");
              }
            } while (c == null);
            v.setColor(c);
            System.out.println();
            System.out.println("COLOR cambiado con éxito");
            System.out.println();
          } else {
            System.out.println();
            System.out.println("ERROR: Matrícula NO encontrada.");
            System.out.println();
          }
          break;
//Caso 7 - ALQUILER DE UN VEhÏCULO
        case 7:
          isOk = false;
          System.out.println("ALQUILER DE VEHÍCULO");
          System.out.println("--------------------");
          //Validamos el formato de la matrícula
          do {
            matricula = UtilesEntrada.leerTexto(MSG_MATR);
            if (!matricula.matches(Matricula.EXP_MATRICULA)) {
              System.out.println("ERROR: Formato de matrícula incorrecto");
            } else {
              isOk = true;
            }
          } while (!isOk);

          v = milista.buscaVehiculo(matricula);
          if (v != null) {
            if (!listaAlquilados.estaAlquilado(matricula)) {
              dni = UtilesEntrada.leerTexto(MSG_DNI);
              conductor = new Conductor(dni);

              dias = UtilesEntrada.leerEntero(MSG_DIAS, MSG_ERR);
              alq = new Alquiler(conductor, dias, v);
              listaAlquilados.addAlquiler(alq);
              System.out.println("ENHORABUENA: Has alquilado el vehículo");
            } else {
              System.out.println("ERROR: El vehículo seleccionado"
                      + " ya está alquilado");
            }
          } else {
            System.out.println("ERROR: Matrícula NO está"
                    + " en la lista de vehículos.");
          }
          break;

//caso 8 borramos vehículo          
        case 8:
          isOk = false;
          System.out.println("DEVOLVER UN VEHÍCULO");
          System.out.println("--------------------");
          //Validamos el formato de la matrícula
          do {
            matricula = UtilesEntrada.leerTexto(MSG_MATR);
            if (!matricula.matches(Matricula.EXP_MATRICULA)) {
              System.out.println("ERROR: Formato de matrícula incorrecto");
            } else {
              isOk = true;
            }
          } while (!isOk);
          alq = listaAlquilados.devuelveAlquiler(matricula);
          if (alq != null) {
            System.out.printf("Importe a pagar: %.2f €%n%n", 
                    alq.getVehi().precioAlquiler(alq.getDiasA()));
 
            //borrar la línea de la lista
            ok = listaAlquilados.borrarAlquiler(alq);
            if (ok) {
              System.out.println("Vehículo devuelto");
            } else {
              System.out.println("No se ha podido borrar el alquiler.");
            }
          } else {
            System.out.println("No se ha podido borrar el vehículo.");
          }
          break;

//caso 9:  Consulta por DNI:
        case 9:
          dni = UtilesEntrada.leerTexto(MSG_DNI);
          alq = listaAlquilados.dimeAlquilados(dni);
          if (alq != null) {
            System.out.println();
            System.out.println("Vehículo alquilado");
            System.out.println();
            alq.getVehi().muestraVehiculo();
          } else {
            System.out.println();
            System.out.println("ERROR: DNI no encontrado o sin alquileres");
            System.out.println();
          }
          break;

        case 0:
          System.out.printf("%nFIN%n");
          break;
        ///Def del switch 
        default:
          System.out.printf("%nERROR: Opción introducida incorrecta%n%n");

          break;
      }
    } while (opcion != 0);
  }

  public final void mostrarMenu() {
    System.out.println("¿Qué quieres hacer?");
    System.out.println("-------------------");
    System.out.println("1. Alta de coche");
    System.out.println("2. Alta de microbús");
    System.out.println("3. Alta de camión");
    System.out.println("---");
    System.out.println("4. Precio alquiler vehículo");
    System.out.println("5. Precio alquiler todos los vehículos");
    System.out.println("---");
    System.out.println("6. Cambiar de color el coche");
    System.out.println("7. Alquilar un vehiculo");
    System.out.println("8. Devolver un vehiculo y mostrar factura");
    System.out.println("9. Mostrar vehiculo alquilado (por DNI)");
    System.out.println("---");
    System.out.println("0. Salir");
    System.out.println();
  }

//   TESTS VARIOS
//    Coche c1 = new Coche();
//    c1.setPlazas(4);
//    c1.setMarca("Renol");
//    c1.setColor(Color.ROJO);
//    c1.setMotor(Tipo.GASOLINA);
//    c1.setCilindrada(82);
//
//    Coche c2 = new Coche(14);
//    c2.setAnyos(40);
//    c2.setPlazas(8);
//    c2.setMarca("Bolsbaguen");
//    c2.setColor(Color.NEGRO);
//    c2.setMotor(Tipo.DIESEL);
//    c2.setCilindrada(31);
//
//    System.out.println(c1.getClass().getSimpleName());
//    System.out.println(c1.precioAlquiler(4));
//    System.out.println(c2.precioAlquiler(4));
//
//    c1.muestraVehiculo();
//
//    System.out.println("---");
//    System.out.println();
//
//    c2.muestraVehiculo();
//
//    //separador para camiones
//    System.out.println("---");
//    System.out.println();
//
//    Camion cam1 = new Camion();
//    cam1.setNumRuedas(12);
//    cam1.setPma(12000);
//    cam1.muestraVehiculo();
}
