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
package org.japo.java.libraries;

/**
 *
 * @author mon_mo
 */
public class UtilesMenu {

    // separador de Línea
    public static final String LS = System.getProperty("line.separator");

    // Opciones Menús
    public static final String OPC_MENU_PPAL = "1230";
    public static final String OPC_MENU_ALUM = "1234560";
    public static final String OPC_MENU_CONT = "1230";
    public static final String OPC_MENU_FILT = "1234567890";
    public static final String OPC_MENU_ORDE = "123450";
    public static final String OPC_MENU_PERS = "120";
    public static final String OPC_MENU_SN   = "[s|S|n|N]";

    // Texto Menú Principal
    public static final String TXT_MENU_PPAL
            = "MATRÍCULA DE ALUMNOS - MENÚ PRINCIPAL" + LS
            + "=====================================" + LS
            + "[ 1 ] Gestión Individual" + LS
            + "[ 2 ] Gestión Conjunta " + LS
            + "[ 3 ] Gestión Persistencia" + LS
            + "---" + LS
            + "[ 0 ] Salir" + LS
            + "---" + LS
            + "Introducir opción: ";

    // Texto Menú Items
    public static final String TXT_MENU_ALUM
            = "MATRÍCULA DE ALUMNOS - GESTIÓN INDIVIDUAL" + LS
            + "=========================================" + LS
            + "[ 1 ] Alta de Alumno" + LS
            + "[ 2 ] Baja total de Alumno" + LS
            + "[ 3 ] Consulta de Alumno" + LS
            + "[ 4 ] Modificación de Alumno" + LS
            + "---" + LS
            + "[ 5 ] Habilitar Alumno" + LS
            + "[ 6 ] Deshabilitar Alumno" + LS
            + "---" + LS
            + "[ 0 ] Menú Anterior" + LS
            + "---" + LS
            + "Introducir opción: ";

    // Texto Menú Contenido
    public static final String TXT_MENU_CONT
            = "MATRÍCULA DE ALUMNOS - GESTIÓN CONTENIDO" + LS
            + "========================================" + LS
            + "[ 1 ] Listado de Alumnos" + LS
            + "[ 2 ] Filtrado de Datos" + LS
            + "[ 3 ] Ordenación de Datos" + LS
            + "---" + LS
            + "[ 0 ] Menú Anterior" + LS
            + "---" + LS
            + "Introducir opción: ";

    // Texto Menú Filtrado
    public static final String TXT_MENU_FILT
            = "MATRÍCULA DE ALUMNOS - FILTRADO DE DATOS" + LS
            + "========================================" + LS
            + "[ 1 ] Filtrar por NIA" + LS
            + "[ 2 ] Filtrar por Nombre" + LS
            + "[ 3 ] Filtrar por Apellidos" + LS
            + "[ 4 ] Filtrar por Fecha de Nacimiento" + LS
            + "[ 5 ] Filtrar por Localidad" + LS
            + "---" + LS
            + "[ 6 ] Filtrar por Estado ACTIVO" + LS
            + "[ 7 ] Filtrar por Estado BAJA" + LS
            + "[ 8 ] Filtrar por Estado EN_TRAMITE" + LS
             + "---" + LS
            + "[ 9 ] Desactivar Filtro" + LS
            + "---" + LS
            + "[ 0 ] Menú Anterior" + LS
            + "---" + LS
            + "Introducir opción: ";

    // Texto Menú Ordenación
    public static final String TXT_MENU_ORDE
            = "MATRÍCULA DE ALUMNOS - ORDENACIÓN DE DATOS" + LS
            + "==========================================" + LS
            + "[ 1 ] Ordenar por NIA" + LS
            + "[ 2 ] Ordenar por Nombre" + LS
            + "[ 3 ] Ordenar por Apellidos" + LS
            + "[ 4 ] Ordenar por Fecha de Nacimiento" + LS
            + "[ 5 ] Ordenar por Localidad" + LS
            + "---" + LS
            + "[ 0 ] Menú Anterior" + LS
            + "---" + LS
            + "Introducir opción: ";

    // Texto Menú Persistencia
    public static final String TXT_MENU_PERS
            = "MATRÍCULA DE ALUMNOS - GESTIÓN DE PERSISTENCIA" + LS
            + "==============================================" + LS
            + "[ 1 ] Importar Datos" + LS
            + "[ 2 ] Exportar Datos" + LS
            + "---" + LS
            + "[ 0 ] Menú Anterior" + LS
            + "---" + LS
            + "Introducir opción: ";

    public static final String TXT_MENU_ERROR = "ERROR: Opción no válida";
}
