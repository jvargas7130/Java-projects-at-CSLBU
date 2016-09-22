
/**
 * Pokemon maker creates a class that creates a random wild pokemon and chooses
 * there type of element special attack. It also has a choose first pokemon
 * function.
 * 
 * @author Jesus Vargas
 *
 */
public class PokemonMaker {
	
	/**
	 * Makewild pokenmon makes pokemon and returns it
	 * @return poke  Pokemon object
	 */
	public static Pokemon makeWildPokemon() {

		int randWild = (int) (Math.random() * 4) + 0;

		Pokemon poke = makeTypePokemon(randWild);

		return poke;
	}

	/**
	 * this method is used to create special powers for pokemon
	 * 
	 * @param type interger type is passed in
	 *           
	 * @return Integer type of power
	 */
	public static Pokemon makeTypePokemon(int type) {

		if (type == 0) {
			int choose = (int) (Math.random() * 1) + 0;
			if (choose == 0) {

				return new Charmander();
			} else if (choose == 1) {

				return new Ponyta();
			}

		} else if (type == 1) {
			int choose = (int) (Math.random() * 1) + 0;
			if (choose == 0) {
				return new Squirtle();
			} else if (choose == 1) {
				return new Staryu();
			}

		} else if (type == 2) {
			int choose = (int) (Math.random() * 1) + 0;
			if (choose == 0) {
				return new Bulbasaur();
			} else if (choose == 1) {
				return new Oddish();
			}

		} else if (type == 3) {
			int choose = (int) (Math.random() * 1) + 0;

			if (choose == 0) {

				return new Pikachu();
			} else if (choose == 1) {

				return new Zapdos();
			}

		}

		return null;
	}

	/**
	 * Player picks first pokemon
	 * 
	 * @param trainerChoiceinterger is passes in
	 *            
	 * @return pokemon object trainerChoice
	 */
	public static Pokemon makeStartPokemon(int trainerChoice) {
		if (trainerChoice == 1) {
			return new Charmander();
		} else if (trainerChoice == 2) {
			return new Squirtle();
		} else if (trainerChoice == 3) {
			return new Bulbasaur();
		} else if (trainerChoice == 4) {
			return new Pikachu();
		}

		return null;
	}

}
