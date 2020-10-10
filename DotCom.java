package game; 
import java.util.ArrayList; 

class DotCom{
	private int SizeOfDotCom = 2; 
	private ArrayList<String> dotCom = new ArrayList<String>(); 
	
	public ArrayList<String> getDotCom(){
		return dotCom; 
	}
	
	public void add(String s){
		dotCom.add(s); 
	}
	
	//public void remove(String s){
	//	int index = searchDotCom(s);
	//	dotCom.remove(index);
	//}
	
	public void remove(int i){
		System.out.println(dotCom.get(i) + " got killed"); 
		dotCom.remove(i); 
	}
	
	public boolean isDotComFull(){
		if (dotCom.size() == SizeOfDotCom){
			return true; 
		}
		return false; 
	}
	
	public int searchDotCom(String s){
		int index = -1; 
		for(int i=0; i<dotCom.size(); i++){
			if (dotCom.get(i).equals(s)){
				index = i;
				break; 
			}
		}
		return index;
	}
	
	public String get(int i){
		return dotCom.get(i);
	}
	
}