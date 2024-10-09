import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UserFormApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Form");

        // Create labels and text fields for User details
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        
        Label genderLabel = new Label("Gender:");
        TextField genderField = new TextField();
        
        // Role selection
        Label roleLabel = new Label("Role:");
        ComboBox<String> roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll("Student", "Teacher");

        // Fields specific to Student
        Label studentIDLabel = new Label("Student ID:");
        TextField studentIDField = new TextField();
        Label creditHoursLabel = new Label("Credit Hours:");
        TextField creditHoursField = new TextField();
        Label gpaLabel = new Label("GPA:");
        TextField gpaField = new TextField();
        
        // Fields specific to Teacher
        Label teacherIDLabel = new Label("Teacher ID:");
        TextField teacherIDField = new TextField();
        Label subjectLabel = new Label("Subject:");
        TextField subjectField = new TextField();
        Label classesHandledLabel = new Label("Classes Handled:");
        TextField classesHandledField = new TextField();

        // Buttons
        Button submitButton = new Button("Submit");
        Button clearButton = new Button("Clear");

        // Grid layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Adding components to the gridPane
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(ageLabel, 0, 1);
        gridPane.add(ageField, 1, 1);
        gridPane.add(genderLabel, 0, 2);
        gridPane.add(genderField, 1, 2);
        gridPane.add(roleLabel, 0, 3);
        gridPane.add(roleComboBox, 1, 3);

        // Student-specific fields
        gridPane.add(studentIDLabel, 0, 4);
        gridPane.add(studentIDField, 1, 4);
        gridPane.add(creditHoursLabel, 0, 5);
        gridPane.add(creditHoursField, 1, 5);
        gridPane.add(gpaLabel, 0, 6);
        gridPane.add(gpaField, 1, 6);

        // Teacher-specific fields
        gridPane.add(teacherIDLabel, 0, 7);
        gridPane.add(teacherIDField, 1, 7);
        gridPane.add(subjectLabel, 0, 8);
        gridPane.add(subjectField, 1, 8);
        gridPane.add(classesHandledLabel, 0, 9);
        gridPane.add(classesHandledField, 1, 9);

        gridPane.add(submitButton, 1, 10);
        gridPane.add(clearButton, 1, 11);

        // Event Handling
        submitButton.setOnAction(e -> handleSubmit(nameField, ageField, genderField, roleComboBox, studentIDField, teacherIDField));
        clearButton.setOnAction(e -> clearFields(nameField, ageField, genderField, roleComboBox, studentIDField, teacherIDField, creditHoursField, gpaField, subjectField, classesHandledField));

        // Scene
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Handle form submission
    private void handleSubmit(TextField nameField, TextField ageField, TextField genderField, ComboBox<String> roleComboBox, TextField studentIDField, TextField teacherIDField) {
        String name = nameField.getText();
        String age = ageField.getText();
        String gender = genderField.getText();
        String role = roleComboBox.getValue();
        
        if (role.equals("Student")) {
            String studentID = studentIDField.getText();
            System.out.println("Student Info: " + name + ", " + age + ", " + gender + ", " + studentID);
        } else if (role.equals("Teacher")) {
            String teacherID = teacherIDField.getText();
            System.out.println("Teacher Info: " + name + ", " + age + ", " + gender + ", " + teacherID);
        }
    }

    // Clear all fields
    private void clearFields(TextField... fields) {
        for (TextField field : fields) {
            field.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
