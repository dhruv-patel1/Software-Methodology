/**
 
 @author  Shahil Patel, Dhruv Patel
 */
public class TeamMember 
{
   private String name;
   private Date   startDate;
   
   public TeamMember(String nm, Date date)
   {
	   this.name= nm;
       this.startDate= date;
   }
   
   public Date getStartDate()
   {
	   return startDate;
   }
   
   public boolean equals(Object obj)
   {
	   //name and startDate must be the same
	   if (this == obj) 
	   {
           return true;
       }
	   else if (obj == null)
	   {
           return false;
       } 
       else if (obj instanceof TeamMember)
       {
           TeamMember mem = (TeamMember) obj;
           if (mem.name.equals(name) && mem.getStartDate().equals(getStartDate()))
           {
               return true;
           }
       }
       return false;
   }  
   
   public String toString()
   {
       //name + " " + startDate;
	   return name + " " + startDate.toString();
   }

   public static void main(String [] args)
   {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
	    Date date= new Date("11/27/2011");
		Date date2= new Date("11/28/2011");
	    TeamMember one= new TeamMember("Lily", date);
	    TeamMember two= new TeamMember("Lily", date2);
	    TeamMember three= new TeamMember("Alice", date);
	    TeamMember four= new TeamMember("Lily", date);
		  
		  //Test constructer and toString method
	    System.out.println(one.toString()); //"Lily 11/27/2011"
	    System.out.println(two.toString()); //"Lily 11/28/2011"
	    System.out.println(three.toString()); //Alice 11/27/2011"
		  
		 //test getStartDate method
	    System.out.println(one.getStartDate().toString()); //"11/27/2011"
	    System.out.println(two.getStartDate().toString()); //"11/28/2011"
		  
		//test the equals method
	    System.out.println(one.equals(one)); //true
	    System.out.println(one.equals(two)); //false
	    System.out.println(one.equals(three)); //false
	    System.out.println(one.equals(four));	 //true 
   }
}