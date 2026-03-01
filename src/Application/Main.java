package Application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter Email");

        Button addButton = new Button("Add Student");

        Label status = new Label();

        addButton.setOnAction(e -> {
            try {
                Connection con = DBConnection.getConnection();

                String sql = "INSERT INTO student(name,email) VALUES(?,?)";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, nameField.getText());
                ps.setString(2, emailField.getText());

                ps.executeUpdate();

                status.setText("Student Added Successfully ✅");

                nameField.clear();
                emailField.clear();

                con.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                status.setText("Error ❌");
            }
        });

        VBox root = new VBox(10, nameField, emailField, addButton, status);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Student Management - JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
