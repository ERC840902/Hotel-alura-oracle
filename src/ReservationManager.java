import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationManager {

    // Método para añadir una reserva
    public static boolean addReservation(int guestId, String checkInDate, String checkOutDate, double totalAmount) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            try {
                String query = "INSERT INTO reservations (guest_id, check_in_date, check_out_date, total_amount) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, guestId);
                stmt.setString(2, checkInDate);
                stmt.setString(3, checkOutDate);
                stmt.setDouble(4, totalAmount);

                int rowsInserted = stmt.executeUpdate();

                if (rowsInserted > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // Método para actualizar una reserva
    public static boolean updateReservation(int reservationId, int newGuestId, String newCheckInDate, String newCheckOutDate, double newTotalAmount) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            try {
                String query = "UPDATE reservations SET guest_id = ?, check_in_date = ?, check_out_date = ?, total_amount = ? WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, newGuestId);
                stmt.setString(2, newCheckInDate);
                stmt.setString(3, newCheckOutDate);
                stmt.setDouble(4, newTotalAmount);
                stmt.setInt(5, reservationId);

                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // Método main para pruebas
    public static void main(String[] args) {
        // Prueba de añadir reserva
        boolean isAdded = addReservation(1, "2023-10-01", "2023-10-05", 400.0);

        if (isAdded) {
            System.out.println("Reserva añadida exitosamente.");
        } else {
            System.out.println("Fallo al añadir la reserva.");
        }

        // Prueba de actualizar reserva
        boolean isUpdated = updateReservation(1, 1, "2023-10-02", "2023-10-06", 420.0);

        if (isUpdated) {
            System.out.println("Reserva actualizada exitosamente.");
        } else {
            System.out.println("Fallo al actualizar la reserva.");
        }
    }
}
