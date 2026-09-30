package org.example.registerformulary;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEdad;

    @FXML
    private CheckBox chkCondiciones;

    @FXML
    private Label lblMensaje;

    @FXML
    protected void handleRegistrarse() {
        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String email = txtEmail.getText().trim();
        String edadStr = txtEdad.getText().trim();
        boolean aceptaCondiciones = chkCondiciones.isSelected();

        if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || edadStr.isEmpty()) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Rechazo: Todos los campos son obligatorios.");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadStr);
            if (edad <= 0) {
                lblMensaje.setStyle("-fx-text-fill: red;");
                lblMensaje.setText("Rechazo: La edad debe ser mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Rechazo: La edad debe ser un número entero.");
            return;
        }

        if (!aceptaCondiciones) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Rechazo: Debes aceptar las condiciones.");
            return;
        }

        lblMensaje.setStyle("-fx-text-fill: green;");
        lblMensaje.setText("Registro\n" +
                "Nombre: " + nombre + " " + apellidos + "\n" +
                "Email: " + email + "\n" +
                "Edad: " + edad);
    }
}