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
package org.japo.java.utils;

/**
 *
 * @author Jonsui
 */
public class UtilesVehiculo {
  
  //Vehiculo, Camión y moto. ORDENARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR!!
  public static final int MIN_KM = 0;
  public static final int MAX_KM_MOTO = 5;
  public static final int MAX_KM_CAMION = 20;
  public static final int MARGEN_REVISION = 50;
  public static final int MARGEN_CAMION = 5000;
  public static final int MARGEN_MOTO = 12500;
  
  
//Mensajes por defecto de todos los m'etodos de las interfaces.
  public static final String DEF_DESMONTAR = "USUARIO; Se ha desmontado"
          + "del veh'iculo.";
  public static final String DEF_MONTAR = "USUARIO: Ha subido al ve'iculo.";
  public static final String DEF_CONDUCIR = "USUARIO: A los mandos del veh'iculo";
  public static final String DEF_AVISAR = "USUARIO: (sonido de cl'axon) "
          + "Tututu tuu tuu, Tututu tuu tuu! (la cucaracha)";
  public static final String DEF_IZQUIERDA = "USUARIO: Derrapa a la izquierda";
  public static final String DEF_DERECHA = "USUARIO: Derrapa a la deracha";
  public static final String DEF_DESCANSAR = "USUARIO: Se para a descansar"
          + " y a fumarse un cigarro.";
  public static final String DEF_ACELERAR = "USUARIO: Acelera con su veh'iculo";
  public static final String DEF_FRENAR = "USUARIO: Frena con su veh'iculo";
  public static final String DEF_ARRANCAR = "USUARIO: Arrancando vehículo";
  public static final String DEF_PARAR = "USUARIO: Para el vehículo";
  
  public static final String DEF_INFLARNEUM = "USUARIO: Inflando neumatico del vehiculo";
  public static final String DEF_DESINFLARNEUM = "USUARIO: Desinflando neumatico del vehiculo";
  public static final String DEF_CAMBIARNEUM = "USUARIO: Cambiando neum'atico";
  public static final String DEF_REPOSTAR = "USUARIO: Repostando veh'iculo";
  
  public static final String DEF_CONECTAR = "USUARIO: Conectando veh'iculo";
  public static final String DEF_DESCONECTAR = "USUARIO: Desconectando veh'iculo";
  public static final String DEF_ENCIENDELUCESPOS = "USUARIO: Enciende las luces"
          + "de posici'on";
  //Definimos n'umero de ruedas de vehiculos con neum'aticos
  public static final int DEF_RUEDASBICI = 2;
  public static final int DEF_RUEDASCOCHE = 4;
  public static final int DEF_RUEDASCAMION = 10;

//Bastidor
  //String para generar el num de bastidor.
  public static final String LISTA_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
          + "0123456789";
  //Longitud del String que genera
  public static final int BASTIDOR_LEN = 17;
  //Prefijo del bastidor para que reste a los char generados...
  public static final int BAS_PREF = 9;

//INeumatico Propiedades
  public static final double DEF_PRESION = 2.00;
  public static final String DEF_COLOR = "Negro";
  public static final int DEF_DIAMETRO = 60;
  public static final String DEF_TIPONEUM = "Calle";
  public static final String DEF_ESTADONEUM = "'Optimo";

//Andamio
  public static final double DEF_ANDAMIOALTURADEF = 30.0;
  public static final int DEF_ANDAMIOALTURAMAX = 50;

//tipoBici
  public static final int DEF_PLAZASBICI = 1;
  public static final String DEF_MARCABICI = "BH";
  public static final String DEF_MODELOBICI = "Ultra SuperVici - 1200KB Plus";
  public static final String DEF_TIPOBICI = "Pedales";
  public static final String DEF_TIPOBICI2 = "Electrica";
  public static final String DEF_TIPOBICIERROR = "BICI¦ERROR: Tipo Incorrecto";

//Coche               manual o automático  (por ejemplo)
  public static final String DEF_TIPOCOCHE = "Manual";
  public static final String DEF_FERRARI = "El Ferrari de Joanpaon";

//Motor
  public static final int DEF_MAXRPM = 5000;
  public static final int DEF_POTENCIA = 70;
  public static final int DEF_RPM = 0;
  
//MotorEléctrico
  public static final int DEF_MAXRPMELEC = 3500;
  public static final int DEF_POTENCIAELEC = 12;
  public static final int DEF_ALIMENTAELEC = 380;
  public static final int DEF_CONSUMOELEC = 24;
  public static final int DEF_ALIMENTACIONTIPO1 = 220;
  public static final int DEF_ALIMENTACIONTIPO2 = 380;
}
