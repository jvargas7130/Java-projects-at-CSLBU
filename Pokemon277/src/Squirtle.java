/**
 * This program creates a class name Squirtle which extends pokemon and
 * implements water
 * 
 * @author Jesus Vargas
 *
 */
public class Squirtle extends Pokemon implements Water {

	/**
	 * Squirtle constructor
	 */
	public Squirtle() {
		super("Squirtle", 1);
	}

	/**
	 * Water Gun method rondomly chooses hit damamge and returns it
	 * 
	 * @return Integer hit
	 */
	@Override
	public int waterGun() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out
				.println("Squirtle releases deadly gush of water from his waterGUn and drowns the opponent! gurgle! ");
		return hit;
	}

	/**
	 * Bubble Beam method rondomly chooses hit damamge and returns it
	 * 
	 * @return Integer hit
	 */
	@Override
	public int bubbleBeam() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Squirtle attakcs with bubbleBeam and the opponent takes damage! SQUIRTLE! SQUIRTLE! ");
		return hit;
	}

	/**
	 * Water Fall method rondomly chooses hit damamge and returns it
	 * 
	 * @return Integer hit
	 */
	@Override
	public int waterfall() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Squirtle becomes angry and unleashes a powerfful waterfall attack! WASH! WASH Drowning!");
		return hit;
	}

	/**
	 * GetType method gets type of pokemon
	 * 
	 * @return integer type
	 */
	@Override
	int getType() {
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
			hit = waterGun();
		} else if (move == 2) {
			hit = bubbleBeam();
		} else if (move == 3) {
			hit = waterfall();
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
		System.out.println(typeMenu);
	}

}
