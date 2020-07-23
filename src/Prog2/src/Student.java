package Prog2.src;

/**
 * This class defines the properties and methods for the Student class, a parent class
 * of the three subclasses: International, Instate, Outstate. Methods included are: a
 * constructor, comparing two students, and toString.
 *
 * @author Dhruv Patel, Shahil Patel
 */

public abstract class Student implements Comparable {
    private String fname;
    private String lname;
    protected int credit;

    /**
     * Constructor for student
     * @param fname first name
     * @param lname last name
     * @param credit amount of credits taking
     */
    public Student(String fname, String lname, int credit) {
        this.fname = fname;
        this.lname = lname;
        this.credit = credit;
    }

    /**
     *Compares Student to object by typecasting to Student and using compareToIgnoreCase on the sum of first
     * name and last name values for both objects
     * @param obj Object for student to be compared to
     * @return -1 if this fname and lname is less than object's, 1 if it is greater, and 0 if equal
     */
    public int compareTo(Object obj){
        if (this == obj) {
            return 0;
        }
        else if (obj == null){
            return -1;
        }
        else if (obj instanceof Student){
            Student stud = (Student) obj;
            if (stud.fname.equals(fname) && stud.lname.equals(lname)){
                return 0;
            }
            else if(stud.fname.compareToIgnoreCase(fname) < 0 && stud.lname.compareToIgnoreCase(lname) < 0) {
                return -1;
            }
            else if(stud.fname.compareToIgnoreCase(fname) > 0 && stud.lname.compareToIgnoreCase(lname) > 0) {
                return 1;
            }
        }
        return -1;

    }

    /**
     * return a string with fname, lname and credit hours; subclasses will be using this method.
     * @return String containing firstname, lastname, and credit hours of Student
     */
    public String toString() {
        return fname + " " + lname + " Credits:" + credit;
    }

    /**
     * Calculates tuition due for Student
     * @return the total tuition amount
     */
    public abstract int tuitionDue();

}
