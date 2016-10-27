
public class Song implements Comparable<Song> {
	private String title;
	private String artist;
	private String album ;
	private String rating;//(1-5)
	
	/**
	 * Song copnstructor
	 * 
	 * @param t  title of song is passed in 
	 * @param a artist of song is passed in 
	 * @param aB album of song is passed in 
	 * @param r rating of song is passed in 
	 */
	public Song(String t, String a, String aB,  String r){
		title = t;
		artist = a;
		album= aB;
		rating = r;
		
		
	}
	
	//getters
	public String getTitle(){
		return title;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public String getAlbum(){
		return album;
	}
	
	public String getRating(){
		return rating;
	}
	
	//setters
	public void setTitle(String t){
		title = t;
	}
	
	public void setArtist(String a){
		artist = a;
	}
	
	public void setAlbum(String aB){
		album = aB;
	}
	
	public void setRating(String r){
		rating = r;
	}
	
	//tostring
	@Override
	public String toString(){
		
		return title+"," + artist +","+ album + "," + rating;
		
	}
	
	/**
	 * Comparable method will compare song by rating , with the highest rated song is 
	 * displayed first. brak ties by alphabettcal order of title. 
	 * 
	 * @param o
	 * @return returns negative integer if the two objects are in order, 
	 * a zero if they are equal and  a positive integer if they are out of order
	 */
	@Override
	public int compareTo(Song s) {
		int result = 0;
		int rate1 = Integer.parseInt(rating);
		int rate2 = Integer.parseInt(s.getRating());
		
	
		
		if(rate1 > rate2){
			result = -1;
		}else if(rate1 < rate2){
			
			result = 1;
		}
		else{
			result = 0;
		}
		
		
		if(result == 0){
			result = title.compareToIgnoreCase(s.getTitle());
		}
		return result;

	
	}
}
