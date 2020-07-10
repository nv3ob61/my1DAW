/* 
 * Copyright 2019 Oscar G.4 - oscargimenez4@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.app;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.japo.java.entities.DataAccessManager;
import org.japo.java.libraries.UtilesBD;

/**
 *
 * @author Oscar G.4 - oscargimenez4@gmail.com
 */
public final class App {

  // Propiedades Aplicación
  private final Properties prp;

  // Constructor Parametrizado
  public App(Properties prp) {
    this.prp = prp;
  }

  // Logica de la Aplicación
  public final void launchApp() {
    // Intentando conexion
    System.out.println("Conectando con la Base de Datos ...");
    System.out.println("---");
    // Gestion de Conexion
    try (
            Connection con = getConnection();
            Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {
      // Conexion Establecida
      System.out.println("Conexion con la Base de Datos establecida");

      listar(con, stmt);

      // Gestion de la Base de Datos
      System.out.println("Procesando informacion");

      // Cerrar la Base de Datos
      System.out.println("Cerrando la Base de Datos");
    } catch (SQLException e) {
      System.out.println("ERROR: Acceso a la Base de Datos CANCELADO");
      System.out.printf("Codigo de error .: %d%n", e.getErrorCode());
      System.out.printf("Estado SQL ......: %s%n", e.getSQLState());
      System.out.printf("Descripcion .....: %s%n", e.getMessage());
      System.out.println("---");
    } catch (Exception e) {
      System.out.printf("ERROR: Aplicacion finalizada - %s%n", e.getMessage());
      System.out.println("---");
    }
    System.out.println("Programa Terminado");
    System.out.println("Gracias por utilizar los Servicios de TuPu");
  }
  
  
  public static final Connection getConnection() throws SQLException {
    Connection con
            = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.11:1521:orcl",
                    "videoclub", "motu828");
    return con;
  }

  public final void listar(Connection conn, Statement stmt) throws SQLException {
    //Gestor de Acceso a los Datos
    DataAccessManager dam = new DataAccessManager(conn, stmt);

    dam.listarPeliculas(DataAccessManager.DEF_MOD_SQL1);
  }
}
