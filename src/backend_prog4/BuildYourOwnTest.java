package backend_prog4;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * With all the following test cases, the program was tested successfully in that it passed
 * these test cases.
 */

class BuildYourOwnTest {

    @org.junit.jupiter.api.Test
    void pizzaPrice()
    {
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add("Cheese");
        toppings.add("Green Pepper");
        toppings.add("Onion");
        BuildYourOwn test1 = new BuildYourOwn("Small", toppings);
        assertEquals(11, test1.pizzaPrice());

        ArrayList<String> toppings2 = new ArrayList<>();
        BuildYourOwn test2 = new BuildYourOwn("Medium", toppings2);
        assertEquals(-1, test2.pizzaPrice());

        BuildYourOwn test3 = new BuildYourOwn("Medium", toppings);
        assertEquals(13, test3.pizzaPrice());


        ArrayList<String> toppings3 = toppings;
        toppings3.add("Mushroom");
        BuildYourOwn test4 = new BuildYourOwn("Small", toppings3);
        assertEquals(13, test4.pizzaPrice());

        BuildYourOwn test5 = new BuildYourOwn("JJJJ", toppings);
        assertEquals(0, test5.pizzaPrice());

        toppings.remove("Mushroom");
        BuildYourOwn test6 = new BuildYourOwn("Large", toppings);
        assertEquals(15, test6.pizzaPrice());



    }
}