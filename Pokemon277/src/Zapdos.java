/**
 * This program creates a class name zapdos which extends pokemon and implements
 * Electric
 * 
 * @author Jesus Vargas
 *
 */
public class Zapdos extends Pokemon implements Electric {
	/**
	 * Zapdos contructor method
	 */
	public Zapdos() {
		super("Zapdos", 1);

	}

	/**
	 * Display method displays type menu for zapdos
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
			hit = thunderShock();
		} else if (move == 2) {
			hit = thunderbolt();
		} else if (move == 3) {
			hit = thunderPunch();
		}

		return hit;
	}

	/**
	 * Display method displays tyoe menu for pikachu
	 */
	@Override
	void displaySpecialMenu() {
		System.out.println(typeMenu);
	}

	/**
	 * Thunder shock method rondomly chooses hit damamge and returns it
	 * 
	 * @return hit integer
	 */
	@Override
	public int thunderShock() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Zapdos charges itself and releases a powerfull shock! BUZZZZ!!!! AHHHHH! smoke!!!!");
		return hit;
	}

	/**
	 * Thunderbolt method rondomly chooses hit damamge and returns it
	 * 
	 * @return hit integer
	 */
	@Override
	public int thunderbolt() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println(
				"Zapdos concentrates and summons a heavy thunderbold that crushes his opponet! THUNDER!!! BAMMM!!!");
		return hit;
	}

	/**
	 * Thunderpunch method rondomly chooses hit damamge and returns it
	 * 
	 * @return hit integer
	 */
	@Override
	public int thunderPunch() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Zapdos smurks and sucke Thunder punches his opponent! HA HA HA");
		return hit;
	}

}
