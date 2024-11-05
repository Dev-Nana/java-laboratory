
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    
private static Connection con;
    
public static Connection getConnection() throws ClassNotFoundException, SQLException{
     if(con==null){
      Class.forName("org.postgresql.Driver");
               String url="jdbc:postgresql://localhost:5432/Agendamentos";
               String user="postgres";
               String pass="123";
               con= DriverManager.getConnection(url, user, pass);
               return con;
       }else{
            return con;
       }
    }
}
