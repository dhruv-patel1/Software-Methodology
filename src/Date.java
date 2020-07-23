import java.util.StringTokenizer;

/**
  
 @author  Dhruv Patel, Shahil Patel
 */
public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
   /**
    * @param d the input date that will get split into the individual elements of 
    * month, day, and year
    */
   public Date(String d)
   {
      //use StringTokenizer to parse the String and create a Date object
	   StringTokenizer s = new StringTokenizer(d,"/");
		   this.month = Integer.parseInt(s.nextToken());
		   this.day = Integer.parseInt(s.nextToken());
		   this.year = Integer.parseInt(s.nextToken()); 
   }
   
   /**
    * @param d the constructor for the Date object
    */
   public Date(Date d)
   {
      //this is a constructor
	   day = d.day;
	   month = d.month;
	   year = d.year;
   }      
   
   /**
    * @return The isValid method tests the date object to see if the inputed date is valid
    */
   public boolean isValid()
   {
	  //General Bounds of Date Validation
      if(month > 12 || month < 0 || day > 31 || day <= 0 || year > 9999 || year < 0) 
      {
    	  return false;
      }
      //Case 1: months with 31 days
      if((month == Month.JAN || month == Month.MAR || month == Month.MAY || month == Month.JUL || month == Month.AUG || month == Month.OCT || month == Month.DEC) && day <= Month.DAYS_ODD) 
      {
    	  return true;
      }
      //Case 2: months with 30 days
      if((month == Month.APR || month == Month.JUN || month == Month.SEP|| month == Month.NOV) && day <= Month.DAYS_EVEN) 
      {
    	  return true;
      }
      //Case 3: February and Leap Year Handling
      if(month == Month.FEB) 
      {
    	  if(day < 29) 
    	  {
    		  return true;
    	  }
    	  if(((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) && day <= 29)
    	  {
    		  return true;
    	  }
      }
      return false;
   }
   
   @Override
   /**
    * This toString Method reformats the date object back into its original form
    */
   public String toString()
   {
       //use the format "month/day/year"
	   return month+"/"+day+"/"+year;
   }
   
   @Override
   /**
    * Checks to see if the Date objects are equivalent
    */
   public boolean equals(Object obj)
   {
	   if(obj == null) 
	   {
		   return false;
	   }
	   if(this == obj) 
	   {
    	   return true;
       }
	   if(obj instanceof Date) 
	   {
		   Date d = (Date) obj;
		   return d.day == day && d.month == month && d.year == year;
	   }
	   
	   return false; 
   }  
   
   /**
    * TestBed to test all constructors and methods implemented within this class
    */
   public static void main(String[] args) 
   {
	   Date test1 = new Date("11/27/2011");
	   Date test2 = new Date("11/36/1999");
	   Date test3 = new Date("02/29/2020");
	   Date test4 = new Date("11/27/2011");
	   
	   System.out.println(test1.isValid()); //true
	   System.out.println(test2.isValid()); //false
	   System.out.println(test3.isValid()); //true
	   
	   System.out.println(test1.toString()); // 11/27/2011
	   System.out.println(test2.toString()); // 11/36/1999
	   System.out.println(test3.toString()); // 2/29/2020
	   
	   System.out.println(test1.equals(test2)); //false
	   System.out.println(test2.equals(test2)); //true
	   System.out.println(test3.equals(test4)); //false
	   System.out.println(test1.equals(test4)); //true
	   
	   System.out.println(test1.month); //11
	   System.out.println(test1.day); //27
	   System.out.println(test1.year); //2011
	   
	    
   }
}


