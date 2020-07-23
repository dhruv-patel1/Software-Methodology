//Studentlist class which is an array for students of varying types
//@author Dhruv Patel, Shahil Patel
public class StudentList {
	private final int NOT_FOUND= -1;
	private final int GROW_SIZE = 4; 
	private Student[] list; 
	private int numStudents;
	
	//constructor
	public StudentList() {
		this.list = new Student[GROW_SIZE];
		this.numStudents= 0;
	}
		
	//returns the index of a student
	   private int find(Student s)
	   {
	      for(int i=0; i < numStudents; i++) {
	    	  if(list[i].compareTo(s) == 0) {
	    		  return i;
	    	  }
	      }
	      return NOT_FOUND;
	   }
	   
	   //grows the size of the team by 4
	   private void grow()
	   {	
		   Student[] newList= new Student[list.length + GROW_SIZE] ;
		   for(int i= 0; i< numStudents; i++) {
			   newList[i]= list[i];
		   }
		   list= newList;
	   }
	   
	//adds a student to the array
	public void add(Student s) {
		 if(numStudents == list.length) {
				grow(); 
			 }
			 list[numStudents] = s;
			 numStudents++;
	}
	
	//removes a student from the array 
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
	 
	 //checks if the student s is in the array
	 public boolean contains(Student s) 
	 {
		 if(find(s) == NOT_FOUND) {
	    	  return false;
	      }
	      return true;
	 }
	
	 //prints the information of the students and tuition due of all students in the array 
	public void print() {
		for(int i=0 ; i < numStudents; i++) {
			System.out.println(list[i].toString() + " Tuition due: $" + list[i].tuitionDue());
		}
	}
	
	//checks if the array is empty
	public boolean isEmpty()
	{
        if (numStudents == 0) 
        {
        	return true;
        }
        return false;
    }
}
