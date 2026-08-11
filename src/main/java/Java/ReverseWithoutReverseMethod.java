package Java;

public class ReverseWithoutReverseMethod 
{

	    public static void main(String[] args) {
	    	
	        String str = "Selenium";
	        String rev = "";
	        
	        for (int i = str.length()-1; i >= 0; i--) {
	            rev += str.charAt(i);
	        }
	        System.out.println(rev);
	    }
	}
	
	

