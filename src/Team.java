/**
  
 @author Shahil Patel, Dhruv Patel
 */

public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   
   public Team()
   {
      //this is the default constructor
	  this.team= new TeamMember[GROW_SIZE];
	  this.numMembers=0; 
   }
   
   private int find(TeamMember m)
   {
	  //checks if the member is part of the team and returns the index 
      for(int i=0; i < numMembers; i++) {
    	  if(team[i].equals(m)) {
    		  return i;
    	  }
      }
      return NOT_FOUND;
   }
   
   private void grow()
   {	
	   //grows the size of the team by 4
	   TeamMember[] newTeam= new TeamMember[team.length + GROW_SIZE] ;
	   for(int i= 0; i< numMembers; i++) {
		   newTeam[i]= team[i];
	   }
	   team= newTeam;
   }
   
   public boolean isEmpty()
   {
	   if(numMembers == 0) {
			return true;
		}
	   return false;
   }
   
   public void add(TeamMember m)
   {
	 //check if there is room in the team and if there is not, grow the team size
	 if((numMembers) % 4 == 0) {
		grow(); 
	 }
	 team[numMembers] = m;
	 numMembers++;
   }
   
   public boolean remove(TeamMember m)
   {
	   //check first to see if m is part of the team
       int index = find(m);       
	   if(index == NOT_FOUND) {
    	   return false;
       }
	   
	   //makes the index of member to removed the last member in the array and sets that index to null
       else {
    	   team[index]= team[numMembers-1];
    	   team[numMembers]= null;
    	   numMembers--;
    	   return true;
       }
   } 
   
   public boolean contains(TeamMember m)
   {
      if(find(m) == NOT_FOUND) {
    	  return false;
      }
      return true;
   } 
   
   public void print()
   {
      //set up a for loop and call the toString() method
	  for(int i=0; i<numMembers; i++) {
		  System.out.println(team[i].toString());
	  }
   } 
}
