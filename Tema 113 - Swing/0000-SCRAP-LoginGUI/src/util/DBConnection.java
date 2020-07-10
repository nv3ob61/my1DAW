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
package util;

/**
 *
 * @author nv3ob61
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  public static Connection createConnection() {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/customers"; //MySQL URL and followed by the database name
    String username = "root"; //MySQL username
    String password = "root123"; //MySQL password   
    try {
      try {
        Class.forName("com.mysql.jdbc.Driver"); //loading mysql driver 
      } catch (ClassNotFoundException e) {
      }
      con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
      System.out.println("Printing connection object " + con);
    } catch (SQLException e) {
    }
    return con;
  }
}
