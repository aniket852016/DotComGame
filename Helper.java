package game; 
import java.util.Random; 
import java.util.Scanner; 
class Helper{
	private static Random rand = new Random(); 
	private static Scanner scan = new Scanner(System.in);
	
	//static int generateToss(){
	//	int toss = Math.abs(rand.nextInt()%2);
	//	return toss; 
	//}
	
	static String rowName(int number){
		String [] charecters = {"a", "b", "c", "d", "e", "f", "g"};
		return charecters[number];
	}
	
	static int generateRandom(){
		int number = Math.abs(rand.nextInt()%7); 
		return number; 
	}
	
	static String scanLine(){
		String s = scan.nextLine(); 
		return s;
	}
	
	static void printInstructions(){
		System.out.println("Welcome to the dot com game. 6 thieves have roobed a bank. now they are in 49 room building."); 
		System.out.println("You have to kill those thieves, for that you need to guess the room in which they are present.");
		System.out.println("To guess a room enter alphabates a-g followed by number 0-6. for example: a0, a1, ...a6");
		//System.out.println("Let's see what you can do");
	}
	
	static boolean checkUserGuess(String s){
		String charString = "abcdefg";
		int guessLength = s.length(); 
		int firstNumber = charString.indexOf(s.charAt(0));
		String secondNumberString = Character.toString(s.charAt(1));
		
		int secondNumber = Integer.parseInt(secondNumberString); 
		//int number = firstNumber*10 + secondNumber; 
		if(firstNumber>=0 && firstNumber<=6 && secondNumber>=0 && secondNumber<=6 && guessLength == 2){
			return true; 
		}
		return false; 
	}

}