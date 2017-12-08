package ec.edu.ister.controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class Conexion {

    private static Connection Conexion;

    private Conexion() {
    }

    public static Conexion getInstance(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);

            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ConexionHolder.INSTANCE;
    }

    private static class ConexionHolder {

        private static final Conexion INSTANCE = new Conexion();
    }

    public void closeConnection() {
        try {
            Conexion.close();
            //JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void MySQLConnection(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            //Conexion = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/" + db_name, user, pass);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
            //JOptionPane.showMessageDialog(null, "Se ha iniciado la base de datos " + db_name + " de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion() {
        return Conexion;
    }

}
