/**
 * This program creates a water interface to be used with pokemon type fire
 *
 * @author jesus Vargas
 *
 */
public interface Water {

	/**
	 * type 1 fire pokemon variable
	 */
	public static final int type = 1;

	/**
	 * type menu variable
	 */
	public static final String typeMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall";

	/**
	 * Water gun abstract method
	 */
	public int waterGun();

	/**
	 * BubbleBeam abstract method
	 */
	public int bubbleBeam();

	/**
	 * Water fall abstract method
	 */
	public int waterfall();

}
