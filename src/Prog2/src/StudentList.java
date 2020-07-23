package Prog2.src;

/**
 * This class defines the properties for the StudentList class, a container class for
 * the Students. The students entered, are stored in a growable array. The methods included
 * are finding, adding, removing, and printing students.
 *
 * @author Dhruv Patel, Shahil Patel
 */

public class StudentList {
    private final int NOT_FOUND= -1;
    private final int GROW_SIZE = 4;
    public Student[] list;
    public int numStudents;

    /**
     * Constructor for StudentList
     */
    public StudentList() {
        this.list = new Student[GROW_SIZE];
        this.numStudents= 0;
    }

    /**
     * Finds a specific Student in the studentList array
     * @param s Student searched for in the array
     * @return first index of matching student and NOT_FOUND otherwise
     */
    private int find(Student s)
    {
        for(int i=0; i < numStudents; i++) {
            if(list[i].compareTo(s) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Grows the array with four additional slots for data
     */
    private void grow()
    {
        Student[] newList= new Student[list.length + GROW_SIZE] ;
        for(int i= 0; i< numStudents; i++) {
            newList[i]= list[i];
        }
        list= newList;
    }

    /**
     * adds a student to the array
     * @param s is the student to be added
     */
    public void add(Student s) {
        if(numStudents == list.length) {
            grow();
        }
        list[numStudents] = s;
        numStudents++;
    }

    /**
     * This method removes a student from the array
     * @param s is the student to be removed
     * @return true if removed, else false
     */
    public boolean remove(Student s)
    {
        //check first to see if s is part of the team
        int index = find(s);
        if(index == NOT_FOUND) {
            return false;
        }

        //makes the index of team member to removed the last member in the array and sets that index to null
        else {
            list[index]= list[numStudents-1];
            list[numStudents-1]= null;
            numStudents--;
            return true;
        }
    }

    /**
     * checks if the student s is in the array
     * @param s is the student being searched for
     * @return true if found, false otherwise
     */
    public boolean contains(Student s)
    {
        if(find(s) == NOT_FOUND) {
            return false;
        }
        return true;
    }

    /**
     * prints the information of the students and tuition due of all students in the array
     */
    public void print() {
        for(int i=0 ; i < numStudents; i++) {
            System.out.println(list[i].toString() + " Tuition due: $" + list[i].tuitionDue());
        }
    }

    /**
     * checks if the array is empty
     * @return true if empty, else false
     */
    public boolean isEmpty()
    {
        if (numStudents == 0)
        {
            return true;
        }
        return false;
    }
}
