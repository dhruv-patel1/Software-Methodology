package backend_prog4;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines the properties and methods of the Deluxe class which is a sub class of the Pizza class. Furthermore,
 * it implements two methods of pizzaPrice and toString.
 * @author Dhruv Patel, Shahil Patel
 */

public class Deluxe extends Pizza
{
    public static final int smallDeluxe = 14;
    public static final int mediumDeluxe = 16;
    public static final int largeDeluxe = 18;

    ArrayList<String> dToppings = new ArrayList<String>(List.of("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom"));

    /**
     * This is the constructor for the Deluxe pizza
     * @param size This corresponds to the size of the pizza
     */
    public Deluxe(String size)
    {
        super("Deluxe", size);
        toppings = dToppings;
    }

    /**
     * Returns the cost of the Deluxe pizza based on what size it was chosen in
     * @return int representing cost of the pizza
     */
    public int pizzaPrice()
    {
        int cost = 0;
        if(super.size.equals("Small"))
        {
            cost = smallDeluxe;
        }
        if(super.size.equals("Medium"))
        {
            cost = mediumDeluxe;
        }
        else if (super.size.equals("Large"))
        {
            cost = largeDeluxe;
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