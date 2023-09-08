import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL de la base de datos
            String url = "jdbc:mysql://localhost:3306/hotel_reservation";

            // Credenciales de la base de datos
            String user = "root";
            String password = "Race840902@";

            // Establecer la conexión
            Connection conn = DriverManager.getConnection(url, user, password);

            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Conexión exitosa a la base de datos.");
        } else {
            System.out.println("Fallo en la conexión a la base de datos.");
        }
    }
}
