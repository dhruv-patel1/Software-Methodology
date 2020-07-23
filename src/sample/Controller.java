package sample;

import backend_prog4.BuildYourOwn;
import backend_prog4.Deluxe;
import backend_prog4.Hawaiian;
import backend_prog4.Pizza;
import java.util.ArrayList;
import static sample.Main.plist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * This class defines the properties and methods of the Controller that will interact with the JFX GUI to give it functionality.
 * Furthermore, this class contains the methods that will give life to the GUI and process the user's input.
 * @author Dhruv Patel, Shahil Patel
 */

public class Controller
{
    ObservableList<String> toppingOptions = FXCollections.observableArrayList("Beef", "Cheese", "Chicken", "Green Pepper",
            "Ham", "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    ObservableList<String> toppingsLeft = FXCollections.observableArrayList("Beef", "Cheese", "Chicken", "Green Pepper",
            "Ham", "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
    ObservableList<String> listOfToppings = FXCollections.observableArrayList();
    ObservableList<String> pizzaType = FXCollections.observableArrayList("Build Your Own", "Hawaiian", "Deluxe");
    ObservableList<String> pizzaSize = FXCollections.observableArrayList("Small", "Medium", "Large");

    @FXML
    public AnchorPane root;
    @FXML
    private ComboBox<String> type, size;
    @FXML
    private ListView<String> toppings, selectedToppings;
    @FXML
    private Button add, remove, clear;
    @FXML
    private ImageView img;
    @FXML
    private TextArea output;

    /**
     * This is the method that will run when the Controller has been initialized. Furthermoe, it pre-populates the options
     * with a default setting.
     */
    @FXML
    public void initialize()
    {
        String defaultType = "Build Your Own";
        String defaultSize = "Medium";
        toppings.setItems(toppingOptions);
        type.setItems(pizzaType);
        size.setItems(pizzaSize);
        type.setValue(defaultType);
        size.setValue(defaultSize);
        img.setImage(new Image("sample/byo.jpg"));
    }

    /**
     * This method handles adding toppings for the BuildYourOwn pizza from the list of topping options. Also, this method limits
     * the amount of toppings chosen for the pizza to 6.
     * @param mouseEvent event of adding topping to pizza
     */
    public void addTopping(MouseEvent mouseEvent)
    {
        int numToppings = listOfToppings.size();
        if(numToppings >= 6)
        {
            output.appendText("The maximum number of toppings is 6!\n");
            return;
        }
        String chosenToppings = (String) toppings.getSelectionModel().getSelectedItem();
        if(chosenToppings == null){
            return;
        }

        toppingsLeft.remove(chosenToppings);
        toppings.setItems(toppingsLeft);
        listOfToppings.add(chosenToppings);
        selectedToppings.setItems(listOfToppings);

    }

    /**
     * This method handles removing toppings from the toppings the user may have selected, but don't want anymore.
     * @param mouseEvent event of clicking the remove button
     */
    public void removeTopping(MouseEvent mouseEvent)
    {
        String chosenToppings = (String) selectedToppings.getSelectionModel().getSelectedItem();
        if(chosenToppings == null){
            return;
        }
        listOfToppings.remove(chosenToppings);
        selectedToppings.setItems(listOfToppings);
        toppingsLeft.add(chosenToppings);
        toppings.setItems(toppingsLeft);

    }

    /**
     * This method gives the clear button functionality as it clears all the toppings that were selected
     * @param mouseEvent event of clicking the clear button
     */
    public void clearSelected(MouseEvent mouseEvent)
    {
        toppingsLeft.addAll(listOfToppings);
        listOfToppings.clear();
        selectedToppings.setItems(listOfToppings);
    }

    /**
     * This method handles adding the pizza selected with all the options to the pizzalist which stores all pizzas that
     * are ordered.
     * @param mouseEvent event of adding pizza to order
     */
    public void addToOrder(MouseEvent mouseEvent)
    {
        String t_type = (String) type.getSelectionModel().getSelectedItem();
        String t_size = (String) size.getSelectionModel().getSelectedItem();

        int numToppings = listOfToppings.size();
        if(numToppings < 1)
        {
            output.appendText("The minimum number of toppings is 1!\n");
            return;
        }

        Pizza toAdd;
        if(t_type == "Hawaiian"){
            toAdd = new Hawaiian(t_size);
        }
        else if(t_type == "Deluxe")
        {
            toAdd = new Deluxe(t_size);
        }
        else{
            ArrayList<String> temp = new ArrayList<String>(listOfToppings);
            toAdd = new BuildYourOwn(t_size, temp);
        }
        plist.add(toAdd);
        String msg = t_size + " " + t_type + " pizza has been added to the order!\n";
        output.appendText(msg);
        reset();
    }

    /**
     * This method handles switching the FXML file and controller to the specific FXML file and controller for the order
     * details.
     * @param mouseEvent event of clicking the show order button
     * @throws Exception if it doesn't load
     */
    public void showOrder(MouseEvent mouseEvent) throws Exception
    {
        AnchorPane t_root = FXMLLoader.load(getClass().getResource("PizzaOrder.fxml"));
        root.getChildren().setAll(t_root);
    }

    /**
     * This method handles making changes to the GUI in terms of disabling certain options/features based on the pizza selected
     * as you can't add toppings to the Hawaiian and Deluxe pizzas.
     * @param mouseEvent event of choosing one of the 3 pizza types
     */
    public void pizzaChosen(ActionEvent mouseEvent)
    {
         toppingsLeft.addAll(listOfToppings);
         listOfToppings.clear();
         selectedToppings.setItems(listOfToppings);

         String pizza_type = (String) type.getSelectionModel().getSelectedItem();
         if(pizza_type == "Hawaiian"){
             img.setImage(new Image("sample/hawaiian.jpg"));
             toppingsLeft.remove("Ham");
             toppingsLeft.remove("Pineapple");
             toppings.setItems(toppingsLeft);

             listOfToppings.add("Ham");
             listOfToppings.add("Pineapple");
             selectedToppings.setItems(listOfToppings);

             toppings.setDisable(true);
             add.setDisable(true);
             remove.setDisable(true);
             clear.setDisable(true);
         }
         else if (pizza_type == "Deluxe")
         {
             img.setImage(new Image("sample/deluxe.jpg"));
             toppingsLeft.remove("Sausage");
             toppingsLeft.remove("Green Pepper");
             toppingsLeft.remove("Pepperoni");
             toppingsLeft.remove("Onion");
             toppingsLeft.remove("Mushroom");
             toppings.setItems(toppingsLeft);

             listOfToppings.add("Sausage");
             listOfToppings.add("Green Pepper");
             listOfToppings.add("Pepperoni");
             listOfToppings.add("Onion");
             listOfToppings.add("Mushroom");
             selectedToppings.setItems(listOfToppings);

             toppings.setDisable(true);
             add.setDisable(true);
             remove.setDisable(true);
             clear.setDisable(true);
         }
         else if(pizza_type == "Build Your Own"){
             img.setImage(new Image("sample/byo.jpg"));
             toppings.setDisable(false);
             add.setDisable(true);
             remove.setDisable(true);
             clear.setDisable(true);
         }
    }

    /**
     * This method handles resetting all the options for the GUI once a pizza has been ordered.
     */
    private void reset()
    {
        String defaultType = "Build Your Own";
        String defaultSize = "Medium";
        toppings.setItems(toppingOptions);
        type.setItems(pizzaType);
        size.setItems(pizzaSize);
        type.setValue(defaultType);
        size.setValue(defaultSize);
        img.setImage(new Image("sample/byo.jpg"));
        listOfToppings.removeAll();
    }


}
