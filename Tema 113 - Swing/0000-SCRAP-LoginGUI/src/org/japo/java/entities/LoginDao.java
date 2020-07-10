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

/**
 *
 * @author nv3ob61
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import static org.japo.java.entities.DataAccessManager.DEF_MOD_SQL1;
import org.japo.java.libraries.UtilesBD;
import util.DBConnection;

public class LoginDao {

  // Propiedades Aplicación
  private final Properties prp;

  public LoginDao(Properties prp) {
    this.prp = prp;
  }

  LoginDao() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public String authenticateUser(Login loginBean) {
    String userName = loginBean.getUserName(); //Assign user entered values to temporary variables.
    char[] password = loginBean.getPassword();

    Connection con;
    Statement statement;
    ResultSet resultSet;

    String userNameDB;
    String passwordDB;

    try {
      con = DBConnection.createConnection(); //Fetch database connection object
      statement = con.createStatement(); //Statement is used to write queries. Read more about it.
      resultSet = statement.executeQuery("select user,pass from creden"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.

      while (resultSet.next()) // Until next row is present otherwise it return false
      {
        userNameDB = resultSet.getString("user"); //fetch the values present in database
        passwordDB = resultSet.getString("pass");

        if (userName.equals(userNameDB) && password.equals(passwordDB)) {
          return "SUCCESS"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
        }
      }
    } catch (SQLException e) {
    }
    return "Invalid user credentials"; // Return appropriate message in case of failure
  }

  // Logica de la Aplicación
  public boolean newAuthentiUser(Login login) throws SQLException {
    boolean isOk;
    // Intentando conexion
//    System.out.println("Conectando con la Base de Datos ...");
//    System.out.println("---");
    // Gestion de Conexion
    try (
            Connection conn = UtilesBD.conectar(prp);
            Statement stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {
      // Conexion Establecida
//      System.out.println("Conexion con la Base de Datos establecida");

      isOk = listar(conn, stmt, login);

      // Cerrar la Base de Datos
//      System.out.println("Cerrando la Base de Datos");
    } catch (SQLException e) {
      System.out.println("ERROR: Acceso a la Base de Datos CANCELADO");
      System.out.printf("Codigo de error .: %d%n", e.getErrorCode());
      System.out.printf("Estado SQL ......: %s%n", e.getSQLState());
      System.out.printf("Descripcion .....: %s%n", e.getMessage());
      System.out.println("---");
      isOk = false;
    } catch (Exception e) {
      System.out.printf("ERROR: Aplicacion finalizada - %s%n", e.getMessage());
      System.out.println("---");
      isOk = false;
    }
//    System.out.println("Programa Terminado");
//    System.out.println("Gracias por utilizar los Servicios de TuPu");
    return isOk;
  }

  public final boolean listar(Connection conn, Statement stmt, Login login) throws SQLException {
    //Gestor de Acceso a los Datos
    DataAccessManager dam = new DataAccessManager(conn, stmt);
    return dam.listar(String.format(DEF_MOD_SQL1, login.getUserName(), Arrays.toString(login.getPassword())), login);
  }
}
