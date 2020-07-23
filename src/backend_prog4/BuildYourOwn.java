package backend_prog4;


import java.util.ArrayList;

/**
 * This class defines the properties and the methods of the BuildYourOwn class which is subclass of the Pizza class.
 * This class implements 2 methods defined as pizzaPrice() and toString(). The pizzaPrice method
 * calculates the cost of the pizza ordered by its size and number of toppings, while the toString method
 * gives us a representation of the pizza ordered and its price.
 * @author Dhruv Patel, Shahil Patel
 */

public class BuildYourOwn extends Pizza
{
    public static final int smallBYO = 5;
    public static final int mediumBYO = 7;
    public static final int largeBYO = 9;
    public static final int toppingPrice = 2;

    /**
     * This is the constructor for the BuildYourOwn pizza type.
     * @param size The size of the pizza
     * @param toppings The toppings chosen for the pizza
     */
    public BuildYourOwn(String size, ArrayList<String> toppings)
    {
        super("Build Your Own Pizza", size, toppings);
    }

    /**
     * Returns the total price of the BuildYourOwn pizza based on the options selected
     * @return int that represents the cost of the pizza
     */
    public int pizzaPrice()
    {
        int numtoppings = toppings.size();
        if(numtoppings < 1){
            return -1;
        }
        int cost = 0;
        if(super.size.equals("Small"))
        {
            cost = smallBYO + (numtoppings * toppingPrice);
        }
        else if(super.size.equals("Medium"))
        {
            cost = mediumBYO + (numtoppings * toppingPrice);
        }
        else if(super.size.equals("Large"))
        {
            cost = largeBYO + (numtoppings * toppingPrice);
        }
        return cost;
    }


    /**
     * Overrides the toString method in the Parent pizza class
     * Calls super to get the String representation of the pizza
     * @return string that represents the pizza and cost
     */
    public String toString()
    {
        return super.toString() + " $" + this.pizzaPrice();
    }

}
