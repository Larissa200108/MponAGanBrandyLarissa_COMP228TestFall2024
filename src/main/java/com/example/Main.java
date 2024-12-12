package com.example;

import com.example.controllers.StudentController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.example.models.Student;

import java.util.List;

// Main application class that extends the JavaFX Application class
public class Main extends Application {

    // Method called when the application is launched
    @Override
    public void start(Stage primaryStage) {
        // Set the title of the primary stage
        primaryStage.setTitle("Student Information");

        // Create User Interface components
        Label cityLabel = new Label("Select Student by City:");
        TextField cityTextField = new TextField();
        Button displayButton = new Button("Display");
        TextArea resultsTextArea = new TextArea();
        resultsTextArea.setEditable(false);

        // Create a scroll pane to wrap the text area
        ScrollPane scrollPane = new ScrollPane(resultsTextArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // Set the on action event handler for the display button
        displayButton.setOnAction(event -> {
            // Get the city from the text field and retrieve the list of students
            String city = cityTextField.getText();
            List<Student> students = StudentController.getStudentsByCity(city);

            // Clear the previous results and append the new results to the text area
            resultsTextArea.clear();
            for (Student student : students) {
                resultsTextArea.appendText(student.toString());
            }
        });

        // Create a vertical box layout to arrange the User Interface components
        VBox root = new VBox(10, cityLabel, cityTextField, displayButton, scrollPane);

        // Create a scene with the root layout and set its dimensions
        Scene scene = new Scene(root, 550, 350);

        // Set the scene to the primary stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Main method that launches the JavaFX application
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}