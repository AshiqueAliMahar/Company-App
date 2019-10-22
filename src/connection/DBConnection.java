
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {

    
    public static Connection getCon(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showInternalMessageDialog(null, ex.getMessage(),"Driver Not Loaded", 0);
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, ex.getMessage(),"Connection Not Created", 0);
        }
        return con;
    }
    
    
}
