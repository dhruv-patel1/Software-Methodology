//outstate class is a subclass of the student class
//@author Dhruv Patel, Shahil Patel
public class Outstate extends Student {

	private boolean tristate;
	
	//constructor
	public Outstate(String fname, String lname, int credit, boolean tristate) {
		super(fname, lname, credit);
		this.tristate = tristate;
	} 
	
	//calculates the tuition due for an outstate student 
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