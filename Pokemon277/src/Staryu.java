/**
 * This program creates a class name Staryu which extends pokemon and implements
 * water
 * 
 * @author Jesus Vargas
 *
 */
public class Staryu extends Pokemon implements Water {

	/**
	 * Staryu constructor
	 */
	public Staryu() {
		super("Staryu", 1);
	}

	/**
	 * Water Gun method rondomly chooses hit damamge and returns it
	 * 
	 * @return Integer hit
	 */
	@Override
	public int waterGun() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println(
				"Staryu uses waterGun to lift himself to the air and spraing his opponent! STAARYU!  WASHHHHH!");
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
		System.out.println("Staryu backs up and uses bubbleBeam on opponet to cause major damage");
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
		System.out.println("Styryu slams opponet to floor with a big Waterfall attack.! WHISH!! SLAAAAM!");
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
