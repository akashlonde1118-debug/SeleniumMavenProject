package Java;

public class ReverseThirdWord {

	public static void main(String[] args) 
	{

		String str = "I love Java coding";
		
        String[] words = str.split(" ");
        
        words[2] = new StringBuilder(words[2]).reverse().toString();
        
        System.out.println(String.join(" ", words));
		
	}

}
