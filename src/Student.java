//Student class
//@author Dhruv Patel, Shahil Patel
public abstract class Student implements Comparable {
	private String fname;
	private String lname;
	protected int credit;
	
	//constructor
	public Student(String fname, String lname, int credit) {
		this.fname = fname;
		this.lname = lname;
		this.credit = credit;
	} 
			
	//must implement compareTo method because Student class implements the Comparable Interface
	//return 0 if fname and lname of the two students are equal,
	//return -1 if this fname and lname is < obj’s, return 1 if this fname and lname is > obj’s
	//Hint: use the .equals and compareToIgnoreCase methods of the String class to compare fname
	//and lname; names are not case-sensitive
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
	//return a string with fname, lname and credit hours; subclasses will be using this method.
	public String toString() {
		return fname + " " + lname + " Credits:" + credit; 
 	}
	
	//compute the tuition due; concrete implementation is required in the subclasses.
	public abstract int tuitionDue();
	
}
