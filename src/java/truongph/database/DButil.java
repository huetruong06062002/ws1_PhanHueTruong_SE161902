
package truongph.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DButil implements Serializable{
    
    public static Connection makeConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TruongPHFa23";
            Connection conn = DriverManager.getConnection(url, "sa", "12345");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
}



