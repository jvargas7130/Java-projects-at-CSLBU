import java.util.HashMap;

public class Computer {
	
	private HashMap <Pattern, Integer> description ;
	
	public Computer(){
		description = new HashMap<Pattern, Integer>();
	}
	
	public void makePrediction(){
		
		
	}
 
	public void storePattern(Pattern p){
		
		description.put(p, 1);
		
	}
}
