package Prog2.src;

/**
 * This class defines the properties and methods for the Instate student class
 * which is a subclass of the Student class. The methods included are: constructor,
 * tuition calculation, and toString.
 *
 * @author Dhruv Patel, Shahil Patel
 */

public class Instate extends Student {

    private int funds;

    /**
     * constructor for Instate
     *@param fname First name of student
     *@param lname Last name of student
     *@param credit Number of credits student is attempting
     *@param funds Total value of funding
     */
    public Instate(String fname, String lname, int credit, int funds) {
        super(fname, lname, credit);
        this.funds = funds;
    }

    /**
     * Calculates tuition for Instate student, consisting of a university fee, and a
     * per-credit fee.
     * The total tuition is decreased by the value of funds of the Instate student.
     * @return Total tuition for Instate student
     */
    public int tuitionDue() {
        int tempCredit=credit;
        boolean partTime = false;
        if(credit > 15) {
            tempCredit = 15;
        }
        int tuition= 433 * tempCredit;

        if(credit < 12) {
            tuition += 846;
            partTime = true;
        }
        else {
            tuition += 1441;
        }

        if(!partTime)
        {
            tuition -= funds;
        }

        return tuition;
    }

    /**
     * This method overrides toString of parent class Student
     * @return String representation of Instate instance
     */
    public String toString()
    {
        return super.toString() + " Funds:" + funds;
    }

    //testbed
    public static void main(String[] args)
    {
        Student john = new Instate("John", "Smith", 8, 0);
        System.out.println(john); //Prints John Smith Credits:8
        System.out.println("$"+john.tuitionDue()); //Print $4310

        Student frank = new Instate("Frank", "Hot", 8, 1000);
        System.out.println(frank); //Prints Frank Hot Credits:8
        System.out.println("$"+frank.tuitionDue()); //Print $4310
    }
}

