import javafx.application.Application; // The main entry point for JavaFX applications
import javafx.scene.Scene;             // The container for all content in a scene graph
import javafx.scene.control.Label;     // A simple text label UI component
import javafx.scene.layout.StackPane;  // A layout manager that stacks nodes on top of each other
import javafx.stage.Stage;             // The top-level window

public class HelloFc extends Application {

    // The start method is the main entry point for all JavaFX applications.
    // It's called after the init() method returns, and after the system is ready for the application to begin running.
    @Override
    public void start(Stage primaryStage) {
        // 1. Create a Label
        Label helloLabel = new Label("Hello, JavaFX!");

        // 2. Create a layout pane (StackPane will center its children)
        StackPane root = new StackPane();
        root.getChildren().add(helloLabel); // Add the label to the pane

        // 3. Create a Scene (which holds the layout pane) with specified dimensions
        Scene scene = new Scene(root, 300, 200);

        // 4. Set the title of the primary stage (the main window)
        primaryStage.setTitle("My First JavaFX App");

        // 5. Set the scene on the primary stage
        primaryStage.setScene(scene);

        // 6. Show the stage (make the window visible)
        primaryStage.show();
    }

    // The main method is used to launch the JavaFX application.
    // It simply calls Application.launch() which then calls the start() method.
    public static void main(String[] args) {
        launch(args);
    }
}