//Instate class, which is a subclass of Student
//@author Dhruv Patel, Shahil Patel
public class Instate extends Student {

	private int funds;
	
	//constructor for Instate
	public Instate(String fname, String lname, int credit, int funds) {
		super(fname, lname, credit);
		this.funds = funds;
	} 
	
	//calculates the tuition for an instate student
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

