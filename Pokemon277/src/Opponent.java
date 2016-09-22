/**
 * Program creates a opponet and extends trainer
 * 
 * @author Jesus Vargas
 *
 */
public class Opponent extends Trainer {

	/**
	 * Stores attack Speech
	 */
	private String attackSpeech;
	/**
	 * Stores loose speech
	 */
	private String looseSpeech;

	/**
	 * Stores win speech
	 */
	private String winSpeech;

	/**
	 * opponent constructor
	 * 
	 * @param name
	 *            string name
	 * 
	 * @param hp
	 *            String health
	 * 
	 * @param type
	 *            String type of pokemon
	 * 
	 */
	public Opponent(String name, int hp, String a, String l, String w) {
		super(name, hp);
		attackSpeech = a;
		looseSpeech = l;
		winSpeech = w;

	}

	/**
	 * Get attack speech accesses attack speech
	 * 
	 * @return attackSpeech
	 */
	public String getattackSpeech() {
		return attackSpeech;
	}

	/**
	 * Get loose speech accessor
	 * 
	 * @return looseSpeech
	 */
	public String getlooseSpeech() {
		return looseSpeech;
	}

	/**
	 * Get win speech accessor
	 * 
	 * @return winSpeech
	 */
	public String getwinSpeech() {
		return winSpeech;
	}

	/**
	 * Attack speach method that opponet use
	 */
	@Override
	void attackSpeach() {
		System.out.println(getattackSpeech());
	}

	/**
	 * Win speach method for each opponent
	 */
	@Override
	void winSpeach() {
		System.out.println(getwinSpeech());
	}

	/**
	 * Loss speach methdod for each opponenet
	 */
	@Override
	void lossSpeach() {
		System.out.println(getlooseSpeech());

	}

	/**
	 * Choose style method chooses style of fight
	 * 
	 * @return integer style
	 */
	@Override
	int chooseStyle() {
		int style = (int) (Math.random() * 2) + 1;
		return style;
	}

	/**
	 * Choose move chooses fight move
	 * 
	 * @return integer move
	 */
	@Override
	int chooseMove(int style) {
		int move = (int) (Math.random() * 3) + 1;
		return move;
	}

}
