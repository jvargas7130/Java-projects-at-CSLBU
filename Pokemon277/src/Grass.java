/**
 * This program creates a grass type class that will be used by grass type
 * pokemon
 * 
 * @author Jesus Vargas
 *
 */
public interface Grass {

	/**
	 * Type 2 grass varible
	 */
	public final int type = 2;

	/**
	 * Type menu variable
	 */
	public final String typeMenu = "1. Vine Whip\n2. Razer Leaf\n3. Solar Beam";

	/**
	 * vine whip special
	 * 
	 * @return integer hit
	 */
	public int vineWhip();

	/**
	 * razor Leaf special
	 * 
	 * @return integer hit
	 */
	public int razorLeaf();

	/**
	 * Solar beam special
	 * 
	 * @return integer hit
	 */
	public int solarBeam();
}
