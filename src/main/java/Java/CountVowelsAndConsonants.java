package Java;

public class CountVowelsAndConsonants {

	public static void main(String[] args) 
	{

	    String str = "Automation".toLowerCase();
	    
        int v=0,c=0;
        
        for(char ch: str.toCharArray())
        {
            if("aeiou".indexOf(ch)!=-1) v++;
            
            else if(Character.isLetter(ch)) c++;
        }
        
        System.out.println("Vowels: "+v+", Consonants: "+c);
	}

}
