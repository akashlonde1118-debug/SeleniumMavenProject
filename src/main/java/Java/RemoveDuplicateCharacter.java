package Java;

import java.util.LinkedHashSet;

public class RemoveDuplicateCharacter {

	public static void main(String[] args) 
	
	{

		 String str = "programming";
		 
	        LinkedHashSet<Character> set = new LinkedHashSet<>();
	        
	        for(char ch: str.toCharArray())
	        {
	        	
	        	set.add(ch);
	        }
	       
	        for(char ch: set) 
	        {
	        	
	        	System.out.print(ch);
	        }

		
	}

}
