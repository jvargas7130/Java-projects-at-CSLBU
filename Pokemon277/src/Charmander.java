/**
 * Charmander class has all the attributes of charmander character. The
 * Charmander character uses fire as there attack.
 * 
 * @author Jesus Vargas
 *
 */
public class Charmander extends Pokemon implements Fire {

	/**
	 * Charmander constructor
	 */
	public Charmander() {
		super("Charmander", 1);
	}

	/**
	 * GetType method gets type of pokemon
	 * 
	 * @return type
	 */
	@Override
	public int getType() {
		return type;
	}

	/**
	 * Special Fight method
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
	 * Display Special Menu method
	 * 
	 */
	@Override
	void displaySpecialMenu() {

		System.out.println(typeMenu);
	}

	/**
	 * Ember method
	 * 
	 * @return hit
	 */
	@Override
	public int ember() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Charmander flares up and engulfs his opponent with ember!!  HOOOT! BURN!!!");
		return hit;
	}

	/**
	 * Fire Blast method
	 * 
	 * @return hit
	 */
	@Override
	public int fireBlast() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Charmander fireBlast with all his might and oppponet receives 3rd degree burns! SIZZLE!");
		return hit;
	}

	/**
	 * Fire Punch method
	 * 
	 * @return hit
	 */
	@Override
	public int firePunch() {
		int hit = (int) (Math.random() * 10) + 5;
		System.out.println("Charmander runs toward opponent and makes contact with thir face with a mega FIRE PUNCH!");
		return hit;
	}

}
