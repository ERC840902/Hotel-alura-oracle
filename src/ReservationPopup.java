import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationPopup extends JFrame {
    private JTextField guestIdField;
    private JTextField checkInDateField;
    private JTextField checkOutDateField;
    private JTextField totalAmountField;

    public ReservationPopup() {
        setTitle("Reservación de Hotel");
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));

        // Etiquetas y campos de texto
        add(new JLabel("ID del Huésped:"));
        guestIdField = new JTextField();
        add(guestIdField);

        add(new JLabel("Fecha de Entrada:"));
        checkInDateField = new JTextField();
        add(checkInDateField);

        add(new JLabel("Fecha de Salida:"));
        checkOutDateField = new JTextField();
        add(checkOutDateField);

        add(new JLabel("Monto Total:"));
        totalAmountField = new JTextField();
        add(totalAmountField);

        // Botón para realizar la reservación
        JButton reserveButton = new JButton("Reservar");
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener y validar los valores de los campos de texto
                    int guestId = Integer.parseInt(guestIdField.getText());
                    String checkInDate = checkInDateField.getText();
                    String checkOutDate = checkOutDateField.getText();
                    double totalAmount = Double.parseDouble(totalAmountField.getText());

                    // Llamar al método para añadir la reservación
                    boolean isAdded = ReservationManager.addReservation(guestId, checkInDate, checkOutDate, totalAmount);

                    if (isAdded) {
                        JOptionPane.showMessageDialog(null, "Reserva añadida exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Fallo al añadir la reserva. Verifique los datos e intente de nuevo.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese datos válidos en todos los campos.");
                }
            }
        });
        add(reserveButton);
    }

    public static void main(String[] args) {
        new ReservationPopup().setVisible(true);
    }
}
