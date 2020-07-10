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
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class UtilesCarrito {

    // separador de Línea
    public static final String LS = System.getProperty("line.separator");

    // Opciones Menús
    public static final String OPC_MENU_PPAL = "IiCcPpXx";
    public static final String OPC_MENU_ITEM = "AaBbCcMmXx";
    public static final String OPC_MENU_CONT = "LlFfOoXx";
    public static final String OPC_MENU_FILT = "DdIiNnPpCcXx";
    public static final String OPC_MENU_ORDE = "IiNnPpCcXx";
    public static final String OPC_MENU_PERS = "IiEeXx";

    // Texto Menú Principal
    public static final String TXT_MENU_PPAL
            = "MENÚ PRINCIPAL" + LS
            + "==============" + LS
            + "[ I ] Gestión Items" + LS
            + "[ C ] Gestión Contenido" + LS
            + "[ P ] Gestión Persistencia" + LS
            + "---" + LS
            + "[ X ] Salir" + LS
            + "---" + LS
            + "Introducir opción: ";

    // Texto Menú Items
    public static final String TXT_MENU_ITEM
            = "MENÚ ITEMS" + LS
            + "==========" + LS
            + "[ A ] Agregar item" + LS
            + "[ B ] Borrar Item" + LS
            + "[ C ] Consultar Item" + LS
            + "[ M ] Modificar Item" + LS
            + "---" + LS
            + "[ X ] Menú Anterior" + LS
            + "---" + LS
            + "Introducir opción: ";

    // Texto Menú Contenido
    public static final String TXT_MENU_CONT
            = "MENÚ CONTENIDO" + LS
            + "==============" + LS
            + "[ L ] Listar" + LS
            + "[ F ] Filtrar" + LS
            + "[ O ] Ordenar" + LS
            + "---" + LS
            + "[ X ] Menú Anterior" + LS
            + "---" + LS
            + "Introducir opción: ";

    // Texto Menú Filtrado
    public static final String TXT_MENU_FILT
            = "MENÚ FILTRADO" + LS
            + "=============" + LS
            + "[ D ] Desactivar" + LS
            + "---" + LS
            + "[ I ] Por ID" + LS
            + "[ N ] Por NOMBRE" + LS
            + "[ P ] Por PRECIO" + LS
            + "[ C ] Por COLOR" + LS
            + "---" + LS
            + "[ X ] Menú Anterior" + LS
            + "---" + LS
            + "Introducir opción: ";

    // Texto Menú Ordenación
    public static final String TXT_MENU_ORDE
            = "MENÚ ORDENACIÓN" + LS
            + "===============" + LS
            + "[ I ] Por ID" + LS
            + "[ N ] Por NOMBRE" + LS
            + "[ P ] Por PRECIO" + LS
            + "[ C ] Por COLOR" + LS
            + "---" + LS
            + "[ X ] Menú Anterior" + LS
            + "---" + LS
            + "Introducir opción: ";

    // Texto Menú Persistencia
    public static final String TXT_MENU_PERS
            = "MENÚ PERSISTENCIA" + LS
            + "=================" + LS
            + "[ I ] Importar Datos" + LS
            + "[ E ] Exportar Datos" + LS
            + "---" + LS
            + "[ X ] Menú Anterior" + LS
            + "---" + LS
            + "Introducir opción: ";

    public static final String TXT_MENU_ERROR = "ERROR: Opción no válida";
}
