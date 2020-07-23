package backend_prog4;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines the properties and methods of the Hawaiian class which is a sub class of the Pizza class. Furthermore,
 * it implements two methods of pizzaPrice and toString.
 * @author Dhruv Patel, Shahil Patel
 */

public class Hawaiian extends Pizza
{
    public static final int smallHawaiian = 14;
    public static final int mediumHawaiian = 16;
    public static final int largeHawaiian = 18;
    ArrayList<String> HToppings = new ArrayList<String>(List.of("Ham", "Pineapple"));

    /**
     * This is the constructor for the Hawaiian pizza type
     * @param size the size of the pizza selected
     */
    public Hawaiian(String size)
    {
        super("Hawaiian", size);
        toppings = HToppings;
    }

    /**
     * Returns the cost of the Hawaiian pizza based on what size it was chosen in
     * @return int representing cost of the pizza
     */
    public int pizzaPrice()
    {
        int cost = 0;
        if(super.size.equals("Small"))
        {
            cost = smallHawaiian;
        }
        if(super.size.equals("Medium"))
        {
            cost = mediumHawaiian;
        }
        if(super.size.equals("Large"))
        {
            cost = largeHawaiian;
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