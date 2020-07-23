package sample;

/**
 * This class defines the properties and methods of the Controller that brings
 * functionality to the GUI developed.
 * @author Dhruv Patel, Shahil Patel
 */

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import Prog2.src.*;

import static sample.Main.list;

public class Controller
{
    @FXML
    private TextField fName, lName, credits, fundBox;
    @FXML
    private RadioButton inState, outState, international;
    @FXML
    private CheckBox funding, triState, exchange;
    @FXML
    private Button add, remove, print;
    @FXML
    private TextArea output;


    /**
     * This instate method handles the instate checkbox and disables options that aren't
     * relevant to the option.
     * @param mouseEvent is the event
     */
    @FXML
    void inState(MouseEvent mouseEvent)
    {
        exchange.setDisable(true);
        triState.setDisable(true);
        funding.setDisable(false);
    }

    /**
     * This outstate method handles the instate checkbox and disables options that aren't
     * relevant to the option.
     * @param mouseEvent is the event
     */
    @FXML
    void outState(MouseEvent mouseEvent)
    {
      exchange.setDisable(true);
      triState.setDisable(false);
      funding.setDisable(true);
      fundBox.setDisable(true);
    }

    /**
     * This international method handles the instate checkbox and disables options that aren't
     * relevant to the option.
     * @param mouseEvent is the event
     */
    @FXML
    void international(MouseEvent mouseEvent)
    {
        exchange.setDisable(false);
        triState.setDisable(true);
        funding.setDisable(true);
        fundBox.setDisable(true);
    }

    /**
     * Handles the funding checkbox in the GUI
     * @param mouseEvent is the event
     */
    @FXML
    void funding(MouseEvent mouseEvent)
    {
        boolean temp = fundBox.isDisabled();
        fundBox.setDisable(!temp);
    }


    /**
     * This method was created to see if a particular student is already in the list
     * of students or not.
     * @param s is the student being searched
     * @return boolean value corresponding to the result of the search in the list
     */
    private boolean contains(Student s){
        if(list.contains(s))
        {
            output.appendText("Student is already in the list!\n");
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method handles adding a student to the student list if the inputs are valid and
     * displays errors based on wrong inputs and actions
     * @param mouseEvent is the event
     */
    public void addStudent(MouseEvent mouseEvent)
    {
        String first_name, last_name;
        int c;
        if(fName.getText().isBlank()){
            output.appendText("First name is required!\n");
            return;
        }
        else{
            first_name = fName.getText();
        }
        if(lName.getText().isBlank()){
            output.appendText("Last name is required!\n");
            return;
        }
        else{
            last_name = lName.getText();
        }

        if(!credits.getText().isBlank())
        {
            try
            {
                c = Integer.parseInt(credits.getText());
            }
            catch (NumberFormatException e){
                output.appendText("Credits must be a number value!\n");
                return;
            }
            if(c < 1 || (c < 9 && international.isSelected())){
                output.appendText("Invalid number of credits entered!\n");
                return;
            }
        }
        else{
            output.appendText("No credit value entered!\n");
            return;
        }

        if(inState.isSelected())
        {
            int fund = 0;
            if(funding.isSelected())
            {
                try{
                    fund = Integer.parseInt(fundBox.getText());
                }
                catch(NumberFormatException e)
                {
                    output.appendText("Funds need to be a number!\n");
                    return;
                }
                if(fund < 0)
                {
                    output.appendText("Funds can't be negative!\n");
                    return;
                }
            }
            Instate s = new Instate(first_name, last_name, c, fund);
            if(contains(s))
            {
                return;
            }
            else {
                list.add(s);
            }

        }
        else if(outState.isSelected())
        {
            boolean tState = triState.isSelected();
            Outstate s = new Outstate(first_name, last_name, c, tState);
            if(contains(s))
            {
                return;
            }
            else{
                list.add(s);
            }
        }
        else if (international.isSelected())
        {
            boolean exc = exchange.isSelected();
            International s = new International(first_name, last_name, c, exc);
            if(contains(s)){
                return;
            }
            else{
                list.add(s);
            }
        }
        output.appendText("Student has been successfully added!\n");
    }

    /**
     * This method handles removing students from the student list if the student is in the list and the user
     * entered valid data corresponding to the student. It will display an error if the student isn't in the list
     * and if the data inputted doesn't match a student.
     * @param mouseEvent is the event
     */
    public void remove(MouseEvent mouseEvent)
    {
        if(list.isEmpty()){
            output.appendText("The student list is empty!\n");
            return;
        }
        String first_name, last_name;
        int c;
        if(fName.getText().isBlank()){
            output.appendText("First name is required!\n");
            return;
        }
        else{
            first_name = fName.getText();
        }
        if(lName.getText().isBlank()){
            output.appendText("Last name is required!\n");
            return;
        }
        else{
            last_name = lName.getText();
        }

        if(!credits.getText().isBlank())
        {
            try
            {
                c = Integer.parseInt(credits.getText());
            }
            catch (NumberFormatException e){
                output.appendText("Credits must be a number value!\n");
                return;
            }
            if(c < 1 || (c < 9 && international.isSelected())){
                output.appendText("Invalid number of credits entered!\n");
                return;
            }
        }
        else{
            output.appendText("No credit value entered!\n");
            return;
        }

        if(inState.isSelected())
        {
            int fund = 0;
            if(funding.isSelected())
            {
                try{
                    fund = Integer.parseInt(fundBox.getText());
                }
                catch(NumberFormatException e)
                {
                    output.appendText("Funds need to be a number!\n");
                    return;
                }
                if(fund < 0)
                {
                    output.appendText("Funds can't be negative!\n");
                    return;
                }
            }
            Instate s = new Instate(first_name, last_name, c, fund);
            if(list.contains(s))
            {
                list.remove(s);
            }
            else{
                output.appendText("Student to be removed not found in list!\n");
                return;
            }
        }
        else if (outState.isSelected())
        {
            boolean tState = triState.isSelected();
            Outstate s = new Outstate(first_name, last_name, c, tState);
            if(list.contains(s))
            {
                list.remove(s);
            }
            else{
                output.appendText("Student to be removed not found in list!\n");
                return;
            }
        }
        else if(international.isSelected())
        {
            boolean exc = exchange.isSelected();
            International s = new International(first_name, last_name, c, exc);
            if(list.contains(s))
            {
                list.remove(s);
            }
            else{
                output.appendText("Student to be removed not found in list!\n");
                return;
            }
        }
        output.appendText("Student has successfully been removed!\n");
        return;
    }

    /**
     * This method gives a representation of the students that are a part of the list in the text area with
     * the students name, credits, and total tuition that's due
     * @param mouseEvent is the event
     */
    public void print(MouseEvent mouseEvent)
    {
        if(list.isEmpty()){
            output.appendText("Student list is empty!\n");
        }
        else{
           String lst = "";
           int i = 0;
           while(i < list.numStudents)
           {
               lst += list.list[i] + " Tuition Due: $" + list.list[i].tuitionDue()+"\n";
               i++;
           }
           output.appendText(lst+"\n");
        }
        return;
    }
}
