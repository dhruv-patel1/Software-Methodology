package Prog2.src;

/**
 * This class defines the properties and methods of the International student class
 * which is a sub class for the studen class. Methods included: constructor for International
 * students, tuition calculation, and toString.
 *
 * @author Dhruv Patel, Shahil Patel
 */

public class International extends Student {

    private boolean exchange;

    /**
     * Constructor for International
     * @param fname first name of the student
     * @param lname last name of the student
     * @param credit the amount of credits the student is attmepting
     * @param exchange true/false status of exchange student
     */
    public International(String fname, String lname, int credit, boolean exchange) {
        super(fname, lname, credit);
        this.exchange = exchange;
    }

    /**
     * Calculates tuition for International student
     * @return tuition amount that's due
     */
    public int tuitionDue() {
        int tuition=350;
        int tempCredit=credit;
        if(credit > 15) {
            tempCredit = 15;
        }

        if(exchange == true || credit >= 12) {
            tuition += 1441;
        }

        if(exchange == false) {
            tuition += (945 * tempCredit);
        }

        if(exchange == false && credit <12) {
            tuition += 846;
        }

        return tuition;
    }

    /**
     * This method overrides toString of parent class Student
     * @return String representation of International instance
     */
    public String toString()
    {
        return super.toString() + " Is Exchange:" + exchange;
    }

    //testbed
    public static void main(String[] args)
    {
        Student jin = new International("Jin", "Yang", 12, false);
        System.out.println(jin); //Prints Jin Yang Credits:12
        System.out.println("$"+jin.tuitionDue()); //Print $13131

        Student lily = new International("Lily", "Chung", 17, true);
        System.out.println(lily); //Prints Lily Chung Credits:17
        System.out.println("$"+lily.tuitionDue()); //Print $1791
    }
}