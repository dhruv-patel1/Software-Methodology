import java.util.Scanner;

/*
  
 @author Dhruv Patel, Shahil Patel
 */
 
public class ProjectManager
{
   Scanner stdin = new Scanner(System.in);
   Team cs213 = new Team();
   
   /**
    * The run method takes in one of the four possible commands and completes whatever task 
    * is prompted by the user, rejecting the command if it's not a valid command or in lowerCase
    */
   public void run()
   {
       
      boolean done = false;
      while ( !done )
      {
         String command = stdin.next();
         switch (command.charAt(0))  
         {   
            case 'A': add();
		      break; 
            case 'R': remove();
              break;
            case 'P': print();  
              break;
            case 'Q': print();
            	      System.out.println("The team is ready to go!");
            	      done = true;
              break;
            default: System.out.println("Command '"+ command +"' not supported!");
    
         }  
      }
      //write java code before you terminate the program
   } //run()
   
   /**
    * The add method checks to see if the inputed date is valid and if the team member is in the team. 
    * If the member is in the team, the method will print that the member is already in the team. If the
    * member is not in the team, then it will add the new member in the team and output that they have joined.
    */
   private void add()
   {
     //must check if the date is valid
	//must call the contains() method to check if a given 
	//team member is in the team already
	   String memName = stdin.next();
	   Date joinDate = new Date(stdin.next());
	   if(joinDate.isValid()) 
	   {
		   TeamMember member = new TeamMember(memName, joinDate);
		   if(cs213.contains(member)) 
		   {
			   System.out.println(member.toString()+ " is already in the team");
			   return;
		   }
		   cs213.add(member);
		   System.out.println(member.toString()+ " has joined the team.");
	   }
	   else if (joinDate.isValid() == false) 
	   {
		   System.out.println(joinDate.toString()+ " is not a valid date!");
	   }
   }
   
   /**
    * The remove method checks to see if the inputed date is valid and checks to make sure that
    * the specific team member is a part of the team. If the member is not found, it will output 
    * that the member is not a team member, but if the member is found, then it will remove the member
    * and print that they have left the team.
    */
   
   private void remove()
   {
      //must check if the date is valid
	   String name = stdin.next();
	   Date date = new Date(stdin.next());
	   
	   if(date.isValid()) 
	   {
		   TeamMember exMember = new TeamMember(name, date);
		   if(cs213.remove(exMember) == false) 
		   {
			   System.out.println(exMember.toString()+ " is not a team member.");
		   }
		   else 
		   {
			   cs213.remove(exMember);
			   System.out.println(exMember.toString()+ " has left the team.");
		   }
	   }
	   else if (date.isValid() == false) 
	   {
		   System.out.println(date.toString()+ " is not a valid date!");
	   }
   }
   
   /**
    * The print method checks to see if the team is empty and if so, it outputs that the team
    * has 0 members. If the team is populated with members, then it will print the members and ends 
    * by printing --end of the list--.
    */
   private void print()
   {
      //must check if the team has 0 members. 
	   if(cs213.isEmpty() == true) 
	   {
		   System.out.println("We have 0 team members!");
	   }
	   else 
	   {
		   System.out.println("We have the following team members:");
		   cs213.print();
		   System.out.println("-- end of the list --");
	   }
   }   
} //ProjectManager

