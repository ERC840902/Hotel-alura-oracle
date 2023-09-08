import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserAuthentication {

    public static boolean authenticate(String username, String password) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            try {
                String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Prueba de autenticación
        boolean isAuthenticated = authenticate("esteban", "ramos05");

        if (isAuthenticated) {
            System.out.println("Usuario autenticado exitosamente.");
        } else {
            System.out.println("Fallo en la autenticación del usuario.");
        }
    }
}

