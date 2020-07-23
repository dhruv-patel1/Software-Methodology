//international class is a subclass of the student class
//@author Dhruv Patel, Shahil Patel
public class International extends Student {

	private boolean exchange;
	
	//constructor
	public International(String fname, String lname, int credit, boolean exchange) {
		super(fname, lname, credit);
		this.exchange = exchange;
	} 
	
	//calculates the tuition due for an international student
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