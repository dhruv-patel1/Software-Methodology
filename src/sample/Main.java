package sample;

import Prog2.src.StudentList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the Main class that starts and runs the GUI app created.
 * @author Dhruv Patel, Shahil Patel
 */
public class Main extends Application
{
    static StudentList list = new StudentList();
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("Prog3.fxml"));
            primaryStage.setTitle("Program 3 - Tuition Manager");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
