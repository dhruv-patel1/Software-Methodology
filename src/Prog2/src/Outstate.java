package Prog2.src;

/**
 * This class defines the properties for the OutState class which is a sub class for the
 * Student class. The methods includes are for the OutofState student constructor, tuition
 * calculation, and toString,
 *
 * @author Dhruv Patel, Shahil Patel
 */

public class Outstate extends Student {

    private boolean tristate;

    /**
     * Constructor for Outstate
     * @param fname first name of student
     * @param lname last name of student
     * @param credit the amount of credits the student is attempting
     * @param tristate true/false, if the student is from the tristate
     */
    public Outstate(String fname, String lname, int credit, boolean tristate) {
        super(fname, lname, credit);
        this.tristate = tristate;
    }

    /**
     * Calculates tuition for Outstate student
     * @return tuition for Outstate student
     */
    public int tuitionDue() {
        int tuition = 0;
        int tempCredit=credit;
        boolean partTime = false;
        if(credit > 15) {
            tempCredit = 15;
        }
        else if (credit < 12)
        {
            partTime = true;
        }
        if(tristate == true && partTime == false) {
            tuition += ((756-200) * tempCredit);
        }
        else {
            tuition += (756* tempCredit);
        }

        if(credit < 12) {
            tuition += 846;
        }
        else {
            tuition += 1441;
        }

        return tuition;
    }

    /**
     * This method Overrides toString of parent class Student
     * @return String representation of Outstate instance
     */
    public String toString()
    {
        return super.toString() + " Is Tristate:" + tristate;
    }

    //testbed
    public static void main(String[] args)
    {
        Student kyle = new Outstate("Kyle", "Smith", 17, false);
        System.out.println(kyle); //Prints Kyle Smith Credits:17
        System.out.println("$"+kyle.tuitionDue()); //Print $12781

        Student matt = new Outstate("Matt", "Fish", 8, false);
        System.out.println(matt); //Prints Matt Fish Credits:8
        System.out.println("$"+matt.tuitionDue()); //Print $6894
    }
}