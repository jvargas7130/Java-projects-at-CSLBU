/**
 * This program creates oddish class that extends Pokemon and implemets Grass
 * 
 * @author Jesus Vargas
 *
 */
public class Oddish extends Pokemon implements Grass {

	/**
	 * Oddish constructor
	 */
	public Oddish() {
		super("Oddish", 1);

	}

	/**
	 * vinewhip method special
	 * 
	 * @return integer hit
	 */
	@Override
	public int vineWhip() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println(
				"Oddish wines up with a vineWhip which grabs the opponet and slams the opponent to the floor! Swish! Bam!");
		return hit;
	}

	/**
	 * Razor Leaf method special
	 * 
	 * @return integer hit
	 */
	@Override
	public int razorLeaf() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Oddish begins shooting razor leafs! Swing! swing! swing!.  CUT! CUT! CUT! ouch!");
		return hit;
	}

	/**
	 * Solar Beam method special
	 * 
	 * @return integer hit
	 */
	@Override
	public int solarBeam() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Oddish backs up and unleases a solarbeam which stuns his opponent! KABOOM!");
		System.out.println();
		return hit;
	}

	/**
	 * GetType method special
	 * 
	 * @return integer type
	 */
	@Override
	int getType() {

		return type;
	}

	/**
	 * Special fight method special
	 * 
	 * @return integer hit
	 */
	@Override
	int specialFight(int move) {
		int hit = 0;

		if (move == 1) {
			hit = vineWhip();
		} else if (move == 2) {
			hit = razorLeaf();
		} else if (move == 3) {
			hit = solarBeam();
		}
		return hit;
	}

	/**
	 * Display special menu method special
	 * 
	 */
	@Override
	void displaySpecialMenu() {
		System.out.println(typeMenu);
	}

}
