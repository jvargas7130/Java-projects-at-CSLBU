import java.util.HashMap;

public class Computer {
	
	private HashMap <Pattern, Integer> description ;
	private Pattern p;
	
	public Computer(){
		description = new HashMap<Pattern, Integer>();
	}
	
	public int makePrediction(String newP){
		int prediction = 0;
		
		

		

		
		if(!description.isEmpty()){
			//if(description.containsKey(p.getPattern())){
				System.out.println("h");
			if(newP.length() == 4){	
				String p1 = newP.substring(0, 3) + "f";
				String p2 =  newP.substring(0, 3) + "w";
				String p3 = newP.substring (0,3) + "g";
				
				
	
					if(!description.containsKey(p1)){
						System.out.println("p1");
						description.put(p, 0);
					}
					
					if(!description.containsKey(p2)){
						System.out.println("p2");
						description.put(p, 0);
					}
					
					if(!description.containsKey(p3)){
						System.out.println("p3");
						description.put(p, 0);
					}
				
			
				System.out.println(p1);
				System.out.println(p2);
				System.out.println(p3);
				
				if((description.get(p1)  > description.get(p2)) &&(description.get(p1)  > description.get(p3)) ){
					System.out.println("f");
					prediction = 1;
					
				}else if((description.get(p2)  > description.get(p1)) &&(description.get(p2)  > description.get(p3))){
					System.out.println("w");
					prediction = 2;
				}else if((description.get(p3)  > description.get(p1)) &&(description.get(p3)  > description.get(p2))){
					System.out.println("g");
					prediction = 3;
				}
				
				
		     
				
				
			}else if(newP.length() == 8){
				
			}else{
				int randChoice = (int) (Math.random()*3) + 1;
				System.out.println("rand" +randChoice);
				prediction = randChoice;
			}
			
				
				
				
			
			
		}else{
			int randChoice = (int) (Math.random()*3) + 1;
			System.out.println("rand" +randChoice);
			prediction = randChoice;
		}
		
		return prediction;
	}
 
	public void storePattern(Pattern s){
	
		
		int i = 1;
		
		if (description.containsKey(p)){
			description.put(p, i++);
		
		}else{
			description.put(p, i);
		}
	
	}
}
