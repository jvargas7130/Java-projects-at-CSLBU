/**
 * Bulbasuar class creates a bulbasauer and gives it attributes
 * 
 * @author Jesus Vargas
 *
 */
public class Bulbasaur extends Pokemon implements Grass {

	/**
	 * Constructor for Bulbasaur
	 */
	public Bulbasaur() {
		super("Bulbasaur", 1);
	}

	/**
	 * VineWhip attack method
	 * 
	 * @return hit
	 */
	@Override
	public int vineWhip() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Bulbasaur raise his vine and lets it rip! Bulba! Saur!  WHIIIIP!");
		return hit;
	}

	/**
	 * razorLeaf attack method
	 * 
	 * @return hit
	 */
	@Override
	public int razorLeaf() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Bulbasuar dashes left and unleasheas a fury of razorLeafs! Saur!  Swing! swing! swing! swing!");
		return hit;
	}

	/**
	 * solarBeam attack method
	 * 
	 * @return hit
	 */
	@Override
	public int solarBeam() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Bulbasaur steps back and attacks with a fierce solar Beam!  WHIIIIP!");

		return hit;
	}

	/**
	 * GetType attack method
	 * 
	 * @return type
	 */
	@Override
	public int getType() {
		return type;
	}

	/**
	 * Specialfight attack method
	 * 
	 * @return hit
	 */
	@Override
	public int specialFight(int move) {
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
	 * Display Special Menu attack method
	 * 
	 */
	@Override
	public void displaySpecialMenu() {
		System.out.println(typeMenu);
	}

}
