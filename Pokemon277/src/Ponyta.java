/**
 * This program creates a class Ponyta which extends to pokemon and implements
 * fire
 * 
 * @author Jesus Vargas
 *
 */
public class Ponyta extends Pokemon implements Fire {

	/**
	 * Ponyta constructor
	 */
	public Ponyta() {
		super("Ponyta", 1);

	}

	/**
	 * Ember method rondomly chooses hit damamge and returns it
	 * 
	 * @return Integer hit
	 */
	@Override
	public int ember() {
		// TODO Auto-generated method stub
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Ponyta fires up for an ember attack that causes sever burn! HOT!  ");
		return hit;
	}

	/**
	 * Fire Blast method rondomly chooses hit damamge and returns it
	 * 
	 * @return Integer hit
	 */
	@Override
	public int fireBlast() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println(
				"Ponyta tail flares as she gallopts to the right of his opponent To deliver a FireBlast! VeryHot! ");
		return hit;
	}

	/**
	 * Fire Punch method rondomly chooses hit damamge and returns it
	 * 
	 * @return Integer hit
	 */
	@Override
	public int firePunch() {
		int hit = (int) (Math.random() * 10) + 5;

		System.out.println(
				"Ponyta dashes aggressevly towards his oppenent delivering a Powerfull firePunch.  STARS%^&%$#@!d colors!");
		return hit;
	}

	/**
	 * GetType method gets type of pokemon
	 * 
	 * @return integer type
	 */
	@Override
	int getType() {
		// TODO Auto-generated method stub
		return type;
	}

	/**
	 * Special fight method chooses move and returns it
	 * 
	 * @return hit
	 */
	@Override
	int specialFight(int move) {
		int hit = 0;

		if (move == 1) {
			hit = ember();
		} else if (move == 2) {
			hit = fireBlast();
		} else if (move == 3) {
			hit = firePunch();
		}

		return hit;
	}

	/**
	 * Displays special menu
	 * 
	 * @return Integer hit
	 */
	@Override
	void displaySpecialMenu() {
		// TODO Auto-generated method stub
		System.out.println(typeMenu);
	}

}
