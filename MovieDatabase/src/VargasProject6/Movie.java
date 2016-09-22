import java.util.ArrayList;
/**The movie class has movietitle , release year,. Rating (G, PG, PG-13, R, NC-17), Movie Length (min), Movie Length (min), 
 * Audience Rating (1-10 stars) and  ArrayList of Actor Names.
 * 
 * @author Jesus Vargas
 *
 */

public class Movie {
	/** Movie Title
	 * 	
	 */
	private String title;

	/**Release Year
	 * 
	 */
	private String year;

	/**Rating (G, PG, PG-13, R, NC-17)
	 * 
	 */
	private String rating;

	/**Movie Length (min)
	 * 
	 */
	private String length;

	/**Audience Rating (1-10 stars)
	 * 
	 */
	private String audianceRating;

	/**ArrayList of Actor Names
	 * 
	 */
	private ArrayList <String> names;

	/**The movie constructor stores a movie.It consist of title, year,rating length, audiance rating
	 * and an arraylist of names.
	 * 
	 * @param t value of title 
	 * @param y value of year
	 * @param r value of rating 
	 * @param l value of length
	 * @param aR value of arraylist
	 * @param a value of names
	 */
	public  Movie(String t, String y,String r,String l,String aR,ArrayList<String> a){
		title = t;
		year = y;
		rating = r;
		length = l;
		audianceRating = aR;
		names = a;
	}

	//GETTERS
	/**getTitle accesses the title value of movie
	 * 
	 * @return title value
	 */
	public String getTitle(){
		return title;
	}

	/**getYear accesses the year value of movie
	 * 
	 * @return year value
	 */
	public String getYear(){
		return year;
	}

	/**getRating accesses the year value of movie
	 * 
	 * @return rating value
	 */
	public String getRating(){
		return rating;
	}

	/**getLength accesses the year value of movie
	 * 
	 * @return length value
	 */
	public String getLength(){
		return length;
	}

	/**getaudianceRating accesses the year value of movie
	 * 
	 * @return audianceRating
	 */
	public String getaudianceRating(){
		return audianceRating;
	}

	/**getNames accesses the name value of the array
	 * 
	 * @return value of names
	 */
	public ArrayList<String> getNames(){
		return names;
	}


	//SETTERS
	/**setTitle() sets the title of the movie
	 * 
	 * @param t value of title
	 */
	public void setTitle(String t){
		title = t;
	}

	/**setYear() sets the year of the movie
	 * 
	 * @param y value of year
	 */
	public void setYear(String y){
		year = y;
	}

	/**setRating() sets the rating  of the movie
	 * 
	 * @param r value of rating
	 */
	public void setRating(String r){
		rating = r;
	}

	/**setLength() sets the length of the movie
	 * 
	 * @param l value of length
	 */
	public void setLength(String l){
		length = l;
	}

	/**setaudianceRating sets the audience rating of the movie
	 * 
	 * @param aR value of audiance rating
	 */
	public void setaudianceRating(String aR){
		audianceRating = aR;
	}

	/**setNames sets the name of actors of movie
	 * 
	 * @return value of array
	 */
	public ArrayList<String> setNames(){
		return names;
	}

	/**compareTo compares two movies by title
	 * 
	 * @param m movie value
	 * @return integer value 
	 */
	public int compareTo(Movie m){

		int result = title.compareToIgnoreCase(m.getTitle());
		return result;
	}

	@Override
	/**toString() method prints the values of the movie
	 * 
	 * @return value of moview
	 */
	public String toString(){
		String movies = title+"/"+year+"/"+rating +"/"+length+"/"+audianceRating +"/";
		for(String i: names){
			if(names.equals(null) || i.equals(" ")){
				System.out.print(" ");
			}
			else{
				if(i.equals(names.get(names.size()-1))){
					movies += i;  
				}
				else{
					movies += i + ","; 
				}

			}
		}
		return movies;	
	}


}
