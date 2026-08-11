package Java;

public class FirstRepeatingCharacter {

	public static void main(String[] args)
	
	{

		  String str = "apple";
		  
	        for(int i=0;i<str.length();i++)
	        {
	            if(str.indexOf(str.charAt(i))!=i)
	            {
	                System.out.println(str.charAt(i));
	                
	                break;
	            }
	        }

	}

}
