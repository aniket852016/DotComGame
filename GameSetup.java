package game; 
import java.util.ArrayList; 
class GameSetup{
	private ArrayList<DotCom> masterList = new ArrayList<DotCom>();
	
	private void initializeMaster(){
		for(int i=0; i<3; i++){
			masterList.add(new DotCom()); 
		}
	}
	
	public ArrayList<DotCom> getMasterList(){
		return masterList;
	}
	
	private void initInternalElements(){
		//int toss = Helper.generateToss(); 
		boolean isMasterListFull = false; 
		int dotComIndex = 0; 
		int masterListIndex = 0; 
		while(!isMasterListFull){
			masterListIndex++; 
			boolean isDotComFull = false; 
			while(!isDotComFull){
				int number = Helper.generateRandom(); 
				String row = Helper.rowName(Helper.generateRandom()); 
				String s = row + number; 
				int index = masterList.get(dotComIndex).searchDotCom(s); 
				if(index != -1){
					//System.out.println("continue"); 
					continue;
				}
				masterList.get(dotComIndex).getDotCom().add(s); 
				isDotComFull = masterList.get(dotComIndex).isDotComFull(); 
				//System.out.println(isDotComFull);
			}
			dotComIndex++; 
			if(masterListIndex == 3){
				isMasterListFull = true; 
			}
			 
		}

	}
	
	
	public int[] searchDotCom(String s){
		int [] positions = null; 
		for(int i=0; i<masterList.size(); i++){
			int index = masterList.get(i).searchDotCom(s); 
			if(index>=0){
				positions = new int[]{i, index}; 
				break; 
			}
		}
		return positions; 
	}
	
	public void finishSetup(){
		System.out.println("finishing setup..."); 
		initializeMaster();
		//System.out.println("Master element initialized");
		initInternalElements();
		//System.out.println("Internal element initialized");
	}
	
	public void remove(int [] positions){
		masterList.get(positions[0]).remove(positions[1]); 
		int size = masterList.get(positions[0]).getDotCom().size();
		if(size == 0){
			//System.out.println("dotCom-array removed"); 
			masterList.remove(positions[0]); 
		}
	}
	
	public void printPositions(){
		for(DotCom dotCom: masterList){
			ArrayList<String> list = dotCom.getDotCom(); 
			for(String s: list){
				System.out.println(s); 
			}
		}
	}

}