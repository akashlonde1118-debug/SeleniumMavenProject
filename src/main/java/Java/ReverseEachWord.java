package Java;

public class ReverseEachWord {

	public static void main(String[] args) {

		  String str = "Hello World";
		  
	        for (String word : str.split(" ")) {
	        	
	            String rev = new StringBuilder(word).reverse().toString();
	            
	            System.out.print(rev + " ");
	        }
	}

}
