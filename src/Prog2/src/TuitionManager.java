package Prog2.src;

import java.util.Scanner;

/**
 * This tuition manager class handles the interaction with the user in terms of input and output.
 * This class can handle 6 different command inputs, depending on what the user wants the program to
 * do.
 *@author Dhruv Patel, Shahil Patel
*/

public class TuitionManager
{
    Scanner stdin = new Scanner(System.in);
    StudentList students = new StudentList();

    /**
     * This run method will run the program and handle the input command. Based on what
     * the command is, the program will execute accordingly.
     */
    public void run()
    {
        boolean done = false;
        int temp = 1;
        while(!done)
        {
            String cmd = stdin.next();
            switch(cmd.charAt(0))
            {
                case 'I':
                {
                    Instate addStudent = instateObj(stdin);
                    if(addStudent == null)
                    {
                        System.out.println("Invalid number of credits");
                        break;
                    }
                    addI(addStudent);
                    break;
                }
                case 'O':
                {
                    Outstate addStudent = outofstateObj(stdin);
                    if(addStudent == null)
                    {
                        System.out.println("Invalid number of credits");
                        break;
                    }
                    addO(addStudent);
                    break;
                }
                case 'N':
                {
                    String fName = stdin.next();
                    String lName = stdin.next();
                    int credit = stdin.nextInt();
                    String exchange_char = stdin.next();
                    if(credit < 1 || credit < 9)
                    {
                        System.out.println("Invalid number of credits");
                        break;
                    }
                    International addStudent = internationalObj(fName, lName, credit, exchange_char);
                    addInternational(addStudent);
                    break;
                }
                case 'R':
                {
                    String fName = stdin.next();
                    String lName = stdin.next();
                    remove(fName, lName);
                    break;
                }
                case 'P':
                {
                    if(students.isEmpty()) {
                        System.out.println("There are 0 students in the list");
                    }
                    else
                    {
                        students.print();
                    }
                    break;
                }
                case 'Q':
                {
                    done = true;
                    break;
                }

                default:
                {
                    if(temp == 1)
                    {
                        System.out.println("Command '"+ cmd.charAt(0) +"' not supported!");
                        temp++;
                    }
                    else
                    {
                        break;
                    }

                }

            }
        }
        System.out.println("Program Terminated");
    }

    /**
     * @param stdin
     * @return
     * This method helps to create the Instate student object and reads the user input through
     * the scanner. It creates the object if the number of credits is valid, else it returns null.
     */
    private Instate instateObj(Scanner stdin)
    {
        String fName = stdin.next();
        String lName = stdin.next();
        int credit = stdin.nextInt();
        int funds = stdin.nextInt();

        if(credit <= 0) {
            return null;
        }
        else
        {
            Instate student = new Instate(fName, lName, credit, funds);
            return student;
        }
    }

    /**
     * @param stdin
     * @return
     * This method helps to create the Outstate student object and reads the user input through
     * the scanner. It creates the object if the number of credits is valid, else it returns null.
     */
    private Outstate outofstateObj(Scanner stdin)
    {
        String fName = stdin.next();
        String lName = stdin.next();
        int credit = stdin.nextInt();
        String tristate_char = stdin.next();
        boolean tristate = false;

        if(credit <= 0) {
            return null;
        }
        if(tristate_char.equals("T"))
        {
            tristate = true;
        }
        Outstate student = new Outstate(fName, lName, credit, tristate);
        return student;
    }

    /**
     * @param stdin
     * @return
     * This method helps to create the International student object and reads the user input through
     * passed from the above switch case in the run() method. It creates the object if the number of credits is valid, else it returns null.
     */
    private International internationalObj(String fName, String lName, int credit, String exchange_char)
    {
        boolean exchange = false;
        if(exchange_char.equals("T"))
        {
            exchange = true;
        }
        International student = new International(fName, lName, credit, exchange);
        return student;
    }

    /**
     * @param student
     * Adds Instate student to the student list as long as the student list doesn't already contain
     * the object being added.
     */
    private void addI(Instate student)
    {
        if(students.contains(student))
        {
            System.out.println("Student is already in the list");
        }
        else
        {
            students.add(student);
            String s = student.toString();
            System.out.println(s+" has been added to the list");
        }

    }

    /**
     * @param student
     * Adds Outstate student to the student list as long as the student list doesn't already contain
     * the object being added.
     */
    private void addO(Outstate student)
    {
        if(students.contains(student))
        {
            System.out.println("Student is already in the list");
        }
        else
        {
            students.add(student);
            String s = student.toString();
            System.out.println(s+" has been added to the list");
        }
    }

    /**
     * @param student
     * Adds International student to the student list as long as the student list doesn't already contain
     * the object being added.
     */
    private void addInternational(International student)
    {
        if(!students.contains(student))
        {
            students.add(student);
            String s = student.toString();
            System.out.println(s+" has been added to the list");
        }
        else
        {
            System.out.println("Student is already in the list");
        }
    }

    /**
     * @param fName is the first name of the object to be removed
     * @param lName is the last name of the object to be removed
     * This methods uses the parameters of first and last name to create a dummy Instate
     * object. Then if the object is found in the student list, it will remove the object.
     * Else, it will print that the object to be removed was not found.
     */
    private void remove(String fName, String lName)
    {
        //Create dummy student object to remove student by first and last name
        Student removeStudent = new Instate(fName, lName, 0, 0);
        if(students.contains(removeStudent))
        {
            students.remove(removeStudent);
            String s = removeStudent.toString();
            System.out.println(s+" has been removed from the list");
        }
        else
        {
            System.out.println("Student to remove was not found in list");
        }
    }
}

