package backend_prog4;

import java.util.ArrayList;

/**
 * This class defines the methods and properties of the Pizza class which is a abstract class that includes
 * the style, size, and toppings on the pizza.
 * @author Dhruv Patel, Shahil Patel
 */

public abstract class Pizza
{
    protected String style;
    protected String size;
    protected ArrayList<String> toppings;

    /**
     * Constructor for Pizza with style, size, and toppings
     * @param style style of the pizza (Hawaiian, Deluxe, or BuildYourOwn)
     * @param size size of the pizza (Small, Medium, Large)
     * @param toppings the toppings selected for the pizza chosen
     */
    public Pizza(String style, String size, ArrayList<String> toppings)
    {
        this.style = style;
        this.size = size;
        this.toppings = toppings;
    }

    /**
     * This is the constructor for the pizzas without the option of chosing the toppings
     * @param style The style of the pizza (Hawaiian/Deluxe)
     * @param size The size of the pizza
     */
    public Pizza(String style, String size)
    {
        this.style = style;
        this.size = size;
    }

    public abstract int pizzaPrice();

    /**
     * This toString() method returns a string representation for the pizza
     * @return String with style, size, and toppings of the pizza
     */
    public String toString()
    {
        String s = "Style: " + style + ", " + "Size: " + size + ", " + "Toppings: ";
        int i = 0;
        for(String topping : toppings)
        {
            if(i < toppings.size())
            {
                s += topping + ", ";
            }
            else if(i == toppings.size()){
                s += topping + " ";
            }
            i++;
        }
        s += "Price: $" + pizzaPrice() + " \n";
        return s;
    }
}