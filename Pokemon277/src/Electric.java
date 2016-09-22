/**
 * Electric class creates a bulbasauer and gives it attributes
 *
 * @author Jesus Vargas
 *
 */
public interface Electric {

	/**
	 * type 3 electric type
	 */
	public static final int type = 3;

	/**
	 * Menu for electric type
	 */
	public static final String typeMenu = "1.Thunder Shock \n2.Thunderbolt \n3.Thunder Punch";

	/**
	 * Thundershock abstract methdod
	 * 
	 * @return hit
	 */
	public int thunderShock();

	/**
	 * Thunderbolt abstrac method
	 * 
	 * @return hit
	 */
	public int thunderbolt();

	/**
	 * Thunderpunch abstract method
	 * 
	 * @return hit
	 * 
	 */
	public int thunderPunch();

}
