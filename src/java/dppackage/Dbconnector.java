package dppackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

public class Dbconnector {

    public static Connection connection() {
        try {
            DriverManager.registerDriver(new OracleDriver());
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "system", password = "pass";
            Connection connect = DriverManager.getConnection(url, user, password);
            return connect;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

}
