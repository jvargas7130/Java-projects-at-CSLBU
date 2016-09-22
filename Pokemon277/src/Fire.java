
/**
 * This program creates a Fire interface to be used with pokemon type fire
 *
 * @author jesus Vargas
 *
 */
public interface Fire {

	/**
	 * type 0 fire pokemon variable
	 */
	public static final int type = 0;

	/**
	 * type menu variable
	 */
	public static final String typeMenu = "1. Ember\n2. Fire Blast\n3. Fire Punch";

	/**
	 * Ember abstract method
	 * 
	 * @return hit
	 */
	public int ember();

	/**
	 * Fire Blast abstract method
	 * 
	 * @return hit
	 */
	public int fireBlast();

	/**
	 * Fire Punch abstract method
	 * 
	 * @return hit
	 */
	public int firePunch();

}
