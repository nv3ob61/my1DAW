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

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * @author mon_mode
 */
public final class DataAccessManager {

  // Sentencias SQL - Módulos
  public static final String DEF_MOD_SQL1 = "SELECT * FROM creden WHERE user='%s' AND pass='%s'";

  // Tamaño Paginación
  public static final int DEF_LIN_PAG = 3;

  // Cabecera Módulos
  private static final String CAB_LST_MOD1
          = " #  User        Password   ";
  private static final String CAB_LST_MOD2
          = "=== =========== ==========";

  // Cabecera Alumnos
  private static final String CAB_LST_ALU1
          = " #  ";
  private static final String CAB_LST_ALU2
          = "=== ";

  // Cabecera Profesores
  private static final String CAB_LST_PRO1
          = " #  ";
  private static final String CAB_LST_PRO2
          = "=== ";

  // Referencias
  private Connection conn;
  private Statement stmt;

  // Constructor - Connection
  public DataAccessManager(Connection con) {
    this.conn = con;
  }

  // Constructor - Connection + Statement
  public DataAccessManager(Connection conn, Statement stmt) {
    this.conn = conn;
    this.stmt = stmt;
  }

  // --- Accesores ---
  public Connection getConn() {
    return conn;
  }

  public void setConn(Connection conn) {
    this.conn = conn;
  }

  public Statement getStmt() {
    return stmt;
  }

  public void setStmt(Statement stmt) {
    this.stmt = stmt;
  }
  // --- Accesores ---

  // Metadatos BD >> Pantalla
  public final void mostrarMetadatos() throws SQLException {
    // Metadatos de la base de datos
    DatabaseMetaData dmd = conn.getMetaData();

    // Cabecera
    System.out.println("Información");
    System.out.println("===========");

    // Información de la base de datos
    System.out.printf("Usuario .........: %s%n", dmd.getUserName());
    System.out.printf("Base de datos ...: %s%n", dmd.getDatabaseProductName());
    System.out.printf("Versión SGBD ....: %s%n", dmd.getDatabaseProductVersion());
    System.out.printf("Driver JDBC .....: %s%n", dmd.getDriverName());
    System.out.printf("Versión JDBC ....: %d.%d%n",
            dmd.getJDBCMajorVersion(),
            dmd.getJDBCMinorVersion());
  }

  // Listado Módulos - SQL
  public final boolean listar(String sql, Login login) throws SQLException {
    boolean isOk = false;

    //Test de la select que envía
//    System.out.println(String.format(DEF_MOD_SQL1, login.getUserName(), Arrays.toString(login.getPassword())));


    // Proceso de listado
    try (ResultSet rs = stmt.executeQuery(sql)) {
      // Mensaje de inicio de listado

      // Comprueba si hay datos
      if (rs.next()) {
        isOk = true;
        // Cabecera
        System.out.println(CAB_LST_MOD1);
        System.out.println(CAB_LST_MOD2);

      } else {
        System.out.println("MEC: Login incorrecto");
      }
    }
    return isOk;
  }

  // Inserción Módulos - SQL
  public final void insertar(String sql) throws SQLException {
    // Mensaje de inicio de listado
    System.out.println("Inserción de módulos ...");

    // Separación
    System.out.println("---");

    // Inserción de datos
    int filas = stmt.executeUpdate(sql);

    // Muestra las filas borradas
    System.out.println(filas + " fila/s insertadas/s");
  }

  // Modificación Módulos - SQL
  public final void modificar(String sql) throws SQLException {
    // Mensaje de inicio de listado
    System.out.println("Modificación de módulos ...");

    // Separación
    System.out.println("---");

    // Inserción de datos
    int filas = stmt.executeUpdate(sql);

    // Muestra las filas borradas
    System.out.println(filas + " fila/s modificadas/s");
  }
}
