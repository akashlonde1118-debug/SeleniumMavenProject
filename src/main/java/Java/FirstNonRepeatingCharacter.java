package Java;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) 
	
	{

		String str = "stress";
		
        for(char ch: str.toCharArray())
        {
            if(str.indexOf(ch)==str.lastIndexOf(ch))
            {
                System.out.println(ch);
                
                break;
            }
        }
	}

}
