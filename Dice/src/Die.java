
public class Die {
	private int sides;
	private int dieValue;
	
	public Die (int s){
		sides = s;
		roll();
		
	}
	

	public int roll(){
		dieValue = (int)(Math.random()* sides) +1;
		return dieValue;
	}
	
	
	public int getDieValue(){
		return dieValue;
	}
	
	public boolean setDieValue(int value){
		if (value > 0 && value <= sides){
			dieValue = value;
			return true;
			
		}else {
			return false;
		}
	}
	
	

}
