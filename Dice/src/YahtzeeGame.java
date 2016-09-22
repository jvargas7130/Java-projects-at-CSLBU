
public class YahtzeeGame {
	public static void main(String [] args){
		
		YahtzeeDice dice = new YahtzeeDice();
		
		System.out.print("First Roll ");
		for (int i: dice.getValues()){
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		
		dice.rollDice();
		System.out.print("second Roll ");
		for (int i : dice.getValues()){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	

}
