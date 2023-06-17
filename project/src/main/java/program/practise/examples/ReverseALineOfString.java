package program.practise.examples;

public class ReverseALineOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//reverse the order of string
		//input Welcome to India
		//Output India to Welcome
		
		String sentenceString = "Welcome to India";
		String reverseString = "";
		
		String[] splitStrings = sentenceString.split(" ");
				
		for(int i=splitStrings.length - 1 ;i>=0;i--)
		{
			
			reverseString = reverseString + splitStrings[i]+ " ";
		}
		
		System.out.println(reverseString);
		
	}

}
