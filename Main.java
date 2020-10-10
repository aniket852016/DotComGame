package game; 
class Main{
	public static void main(String [] args){
		GameSetup game1 = new GameSetup(); 
		game1.finishSetup();
		
		boolean isGameStarted = false;
		Helper.printInstructions(); 
		while(true){
			//game1.printPositions(); 
			System.out.println("Guess the position: ");
			String userGuess = Helper.scanLine(); 
			if(!Helper.checkUserGuess(userGuess)){
				System.out.println("please enter valid guess");
				//Helper.printInstructions();
				continue; 
			}
			int[] guessResult = game1.searchDotCom(userGuess); 
			if(guessResult == null){
				System.out.println("Miss"); 
				continue; 
			}
			System.out.println("Hit"); 
			game1.remove(guessResult);
			int size = game1.getMasterList().size(); 
			if(size != 0){
				continue; 
			}
			System.out.println("Hoorayy! you won..."); 
			break;
		}
	}
}