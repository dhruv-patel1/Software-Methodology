package sample;

import backend_prog4.Pizza;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * This is the main class which contains the main method which is used to run the GUI for ordering pizzas.
 * @author Dhruv Patel, Shahil Patel
 */

public class Main extends Application
{
    public static ArrayList<Pizza> plist = new ArrayList<Pizza>();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("Prog4.fxml"));
            primaryStage.setTitle("Program 4 - Pizza Store");
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
