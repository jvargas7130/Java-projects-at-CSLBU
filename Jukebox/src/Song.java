
/**
 * Song class implements the comparable interface. It holds toghether a song which consist
 * of title, artist , album, rating.
 * 
 * 
 * @author Jesus Vargas
 *
 */
public class Song implements Comparable<Song> {
	
	/**
	 * Title instant variable of song
	 */
	private String title;
	
	/**
	 * artist instant variable of song
	 */
	private String artist;
	
	/**
	 * Album instant variable of song
	 */
	private String album;
	
	/**
	 * Rating instant variable of song
	 */
	private String rating;// (1-5)

	/**
	 * Song copnstructor
	 * 
	 * @param t title of song is passed in
	 *            
	 * @param a artist of song is passed in
	 *            
	 * @param aB album of song is passed in
	 *            
	 * @param r rating of song is passed in
	 *            
	 */
	public Song(String t, String a, String aB, String r) {
		title = t;
		artist = a;
		album = aB;
		rating = r;

	}

	// getters
	
	/**
	 * Title accessor
	 * 
	 * @return title string value
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Artist accessor
	 * 
	 * @return artist string value
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * Album accessor
	 * 
	 * @return album string value
	 */
	public String getAlbum() {
		return album;
	}
	
	/**
	 * Rating accessor
	 * 
	 * @return rating string value
	 */
	public String getRating() {
		return rating;
	}

	// tostring
	
	/**
	 * To string value prints out song
	 * 
	 * @return  title + "," + artist + "," + album + "," + rating
	 * 
	 */
	@Override
	public String toString() {

		return title + "," + artist + "," + album + "," + rating;

	}

	/**
	 * Comparable method will compare song by rating , with the highest rated
	 * song is displayed first. brak ties by alphabettcal order of title.
	 * 
	 * @param o
	 * @return returns negative integer if the two objects are in order, a zero
	 *         if they are equal and a positive integer if they are out of order
	 */
	@Override
	public int compareTo(Song s) {
		int result = 0;
		int rate1 = Integer.parseInt(rating);
		int rate2 = Integer.parseInt(s.getRating());

		if (rate1 > rate2) {
			result = -1;
		} else if (rate1 < rate2) {

			result = 1;
		} else {
			result = 0;
		}

		if (result == 0) {
			result = title.compareToIgnoreCase(s.getTitle());
		}
		return result;

	}
}
