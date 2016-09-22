
public class YahtzeeDice {
	private final int NUM_DICE_SIDES = 6;
	private final int NUM_DICE = 5;
	
	private Die [] dice;
	
	public YahtzeeDice (){
		dice = new Die[NUM_DICE];
		for (int d = 0; d < dice.length; d++){
			dice[d] = new Die(NUM_DICE_SIDES);
		}
	}
	
	public void rollDice (){
		for(int d = 0; d< dice.length; d++){
			dice[d].roll();
		}
	}
	
	public int [] getValues(){
		int [] values = new int [NUM_DICE];
		for (int d = 0; d < dice.length; d++){
			values[d] = dice[d].getDieValue();
		}
		return values;
	}
	
}
