package sample;

import backend_prog4.Pizza;
import static sample.Main.plist;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


/**
 * This class defines the properties and methods of the Controller class that is used with viewing the total order which
 * is another GUI. It processes certain user input such as go back to the order screen with the back method and clear all
 * pizzas in the order with the clear method.
 * @author Dhruv Patel, Shahil Patel
 */

public class orderController
{
    private int cost;
    @FXML
    private AnchorPane rP;
    @FXML
    private TextArea order;
    @FXML
    private TextField totalCost;
    @FXML
    private Button clear, back;

    /**
     * This the method that runs when the controller for the GUI has been initialized and displays all the details of the
     * order being made.
     */
    @FXML
    public void initialize()
    {
        for(Pizza temp : plist){
            order.appendText(temp.toString()+ "\n");
            cost += temp.pizzaPrice();
        }
        totalCost.appendText(Integer.toString(cost));
    }

    /**
     * This method handles the user clicking on the clear button to clear the entire order from the pizzalist.
     * @param mouseEvent event of clicking on the clear button
     */
    public void clearPizzas(MouseEvent mouseEvent){
        plist.clear();
        totalCost.clear();
        order.clear();
        String msg = "Order has been cleared!\n";
        order.appendText(msg);
    }

    /**
     * This method handles the user clicking on the back button which brings them back to the order screen of the GUI.
     * @param mouseEvent event of clicking the back button
     * @throws Exception unsucessful load for the GUI
     */
    public void back(MouseEvent mouseEvent) throws Exception
    {
        String source = "Prog4.fxml";
        AnchorPane t_root = FXMLLoader.load(getClass().getResource(source));
        rP.getChildren().setAll(t_root);
    }

}
