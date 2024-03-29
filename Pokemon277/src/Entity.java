import java.io.Serializable;

/**
 * This program creates an entity which can be either a pokemon or trainer.
 * 
 * @author jesus Vargas
 *
 */
public abstract class Entity implements Serializable {

	/**
	 * Name of entity
	 */
	private String name;

	/**
	 * hp quantity
	 */
	private int hp = 0;

	/**
	 * MaxHp quantity of entity. increases with higher level.
	 */
	private int maxHp = 0;

	/**
	 * Entity constructor
	 * 
	 * @param name entity name passed in
	 *           
	 * @param hp entity hp being passed in
	 *           
	 */
	public Entity(String name, int hp) {
		this.name = name;
		this.hp = hp;
		this.maxHp = hp;
	}

	/**
	 * GetName method returns the name of entity
	 * 
	 * @return string name
	 */
	public String getName() {
		return name;
	}

	/**
	 * GetHp method gets the hp of entity
	 * 
	 * @return integer hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * LooseHp Decreases the hp on entity
	 * 
	 * @param hit integer hit passed in
	 *            
	 * @return hp integer hit
	 */
	public int loseHp(int hit) {

		// keeps hp from becomming negative
		int testHp = hp - hit;

		if (testHp > 0) {
			hp -= hit;
		} else {
			hp = 0;
		}

		return hp;
	}

	/**
	 * Increase the amount of hp
	 * 
	 * @param heal integer heal is passed in passes heal to heal entity
	 *          
	 * 
	 * @return hp the amont of heal points
	 */
	public int gainHp(int heal) {

		int healAll = heal;

		if (healAll != -1) {
			int checkHeal = hp + heal;

			if (heal >= 0) {

				if (checkHeal >= maxHp) { // helps keep hp from going over max
					hp = maxHp;
				} else {
					hp += heal; // heals hp below max
				}

			}
		} else if (healAll == -1) {// if at pokemon center

			hp = maxHp;
			return hp;
		}

		return hp;
	}

	/**
	 * Increase the MaxHp when pokemon levels up.
	 * 
	 */
	public void incMaxHp() {
		maxHp += 5;
	}
}
