/**
 * This program creates a class name pikachu which extends pokemon and
 * implements Electric
 * 
 * @author Jesus Vargas
 *
 */
public class Pikachu extends Pokemon implements Electric {

	/**
	 * Pickachu contructor method
	 */
	public Pikachu() {
		super("Pikachu", 2);
	}

	/**
	 * Display method displays tyoe menu for pikachu
	 */
	public void displaySpecialMenu() {
		System.out.println(typeMenu);
	}

	/**
	 * GetType method gets type of pokemon
	 * 
	 * @return integer type
	 */
	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return type;
	}

	/**
	 * Special fight method chooses move and returns it
	 * 
	 * @return hit
	 */
	@Override
	public int specialFight(int move) {
		// TODO Auto-generated method stub
		int hit = 0;

		if (move == 1) {
			hit = thunderShock();
		} else if (move == 2) {
			hit = thunderbolt();
		} else if (move == 3) {
			hit = thunderPunch();
		}

		return hit;
	}

	/**
	 * Thundershock method rondomly chooses hit damamge and returns it
	 */
	@Override
	public int thunderShock() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Pikachu winds up and delivers a massive ThunderShock! PIKAAA! KABOOM!");

		return hit;
	}

	/**
	 * Thunder bolt method rondomly chooses hit damamge and returns it
	 */
	@Override
	public int thunderbolt() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Pikachu charges up and delivers a massive Thunderbolt!  BZRRRTT!");
		return hit;
	}

	/**
	 * Thunderpunch method rondomly chooses hit damamge and returns it
	 */
	@Override
	public int thunderPunch() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Pikachu harnesses a lightning bolt  and throws an electrifing ThunderPunch! BAM!");
		return hit;
	}
}
