
import java.awt.Point;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Movie program t keeps a database of movies for a user to search. The class consist of a try catch 
 * that reads in movie file, stores it into a temporary array, shuffles the temporary array , and then 
 * stores it in an tree. 
 * 
 * @author Jesus vargas
 *
 */
public class Movietest {
	//main
	public static void main(String args []){
		Menu();
	}
	public static void displaMenu(){
		System.out.println();
		System.out.println("Movie Database");
		System.out.println("1. Add a New Movie");
		System.out.println("2. Delete Movie");
		System.out.println("3. Add Actor to Movie");
		System.out.println("4. Delete Actor from Movie ");
		System.out.println("5. Display all movies in sorted order by title.");
		System.out.println("6. Find Movie's");
		System.out.println("7. Save and Quit");


	}

	/**
	 * shuffle movie takes in an arraylist and shuffles its values
	 * 
	 * @param shuffleMovie value of movies
	 */
	public static void shuffle(ArrayList<Movie> shuffleMovie){
		boolean swapped = false;
		do {
			swapped = false;
			for(int i = 0; i < shuffleMovie.size() - 1; i++) {
				if(shuffleMovie.get(i).compareTo(shuffleMovie.get(i+1)) > 0) {
					Movie swap = shuffleMovie.get(i);
					shuffleMovie.set(i, shuffleMovie.get(i + 1));
					shuffleMovie.set(i + 1, swap);
					swapped = true;
				} 
			}
		} while( swapped );

	}

	/**Menu method is where the array,queue and stacks are declared. 
	 * There is also options for the user to use when choosing the 
	 * maze.
	 * 
	 */
	public static void Menu(){
		Scanner in = new Scanner(System.in);
		boolean done = false;
		BST tree = new BST();
		Movie mov =null;
		ArrayList<Movie> tempA = new ArrayList<Movie>();

		//Try catch
		try{
			Scanner read = new Scanner(new File("movies.txt"));
			do{
				ArrayList<String> noActor = new ArrayList<String>();
				String line = read.nextLine();
				String [] tokens = line.split("/");
				String name = tokens[ 0 ];
				String year = tokens[ 1 ];
				String rating = tokens[ 2 ];
				String length = tokens[ 3 ];
				String aR = tokens[ 4 ];
				if(tokens.length > 5){
					ArrayList<String> actorTemp = new ArrayList<String>();
					String actor = tokens[ 5 ];
					String[] act  = actor.split(",");
					for(int j = 0; j < act.length; j++){
						actorTemp.add(act[j]);
					}
					mov = new Movie(name, year,rating, length,aR,actorTemp);
					tempA.add(mov);
				}
				else{
					mov = new Movie(name, year,rating, length,aR,noActor);
					tempA.add(mov);
				}
			}while(read.hasNext());
			read.close();
		}catch(FileNotFoundException e){
			System.out.println("File not Found");
		}

		//Shuffle method is called before being stored to binary tree
		shuffle(tempA);
		System.out.println();

		//gets the arraylist of movies and adds them to the tree
		for(int i = 0; i <tempA.size(); i++){
			String name = tempA.get(i).getTitle();
			String year = tempA.get(i).getYear();
			String rating = tempA.get(i).getRating();
			String length = tempA.get(i).getLength();
			String aR = tempA.get(i).getaudianceRating();
			ArrayList<String> actor = tempA.get(i).getNames();
			tree.add(new Movie(name, year, rating, length, aR, actor));
		}

		System.out.println();

		//prints tree out
		tree.printBST();

		//repeating menu
		while(!done){
			displaMenu();
			//user chooses
			int choose = CheckInput.checkInt(1,7);
			switch(choose){
			//Add a New Movie
			case 1: newMovie(tree);
			break;
			//Delete Movie	
			case 2:deleteMovie(tree);
			break;
			//Add Actor to Movie
			case 3:addActor(tree,mov);
			break;
			//Delete Actor from Movie	
			case 4:removeActor(tree,mov);
			break;
			//Display all movies in sorted order by title	
			case 5: displayMovie(tree);
			break;
			//Find Movie's	
			case 6: findMovies(tree);
			break;
			case 7:
				//save and quit
				System.out.println("Save and Quit");

				//printwriter
				quit(tree,mov);
				done = true;
				break;
			default:
				break;

			}
		}
	}

	/**
	 * newMovie adds a new movie. Movie consist of title, year, rating, length, audiance
	 * and actors
	 * 
	 * @param tree values of binary tree
	 */
	public static void newMovie(BST tree){
		ArrayList<String> actors = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		boolean done = false;
		System.out.println("Enter title");
		String title = in.nextLine();
		System.out.println("Enter year");
		String year = in.nextLine();
		System.out.println("Enter rating");
		String rating = in.nextLine();
		System.out.println("Enter length");
		String length = in.nextLine();
		System.out.println("Enter audiance Rating");
		String aR = in.nextLine();

		//adds an array of actors
		do{
			System.out.println("Enter actors");
			System.out.println("Enter d when done");
			String act = in.nextLine();
			if(act.equals("d")){
				done = true;
			}
			else{
				actors.add(act);
			}
		}while(!done);
		tree.add(new Movie(title, year, rating, length, aR, actors));
	}


	/**
	 * deleteMovie method deletes a movie by title
	 * 
	 * @param tree values of binary tree
	 */
	public static void deleteMovie(BST tree){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Title to remove");
		String title = in.nextLine();
		Node find = tree.search(title);
		if(find != null){
			Movie removeTitle = new Movie(title, null, null, null, null, null);

			//removes movie by title
			tree.remove(removeTitle);
		}



	}

	/**
	 * addActor method adds an actor. User is first asked to choose a movie 
	 * to remove an actor, then the movie is removed
	 * 
	 * @param tree  values of binary tree
	 * @param mov values of movies
	 */
	public static void addActor(BST tree, Movie mov){
		Scanner in = new Scanner(System.in);
		System.out.println("Choose the movie to add an actor too");
		String findMovie = in.nextLine();
		Node find = tree.search(findMovie);
		if(find != null){
			System.out.println(tree.search(findMovie).getData());
			System.out.println(tree.search(findMovie).getData().getNames());
			System.out.println("Enter actor to remove");
			ArrayList<String> actor = tree.search(findMovie).getData().getNames();
			String addActor = in.nextLine();
			actor.add(addActor);
		}

	}

	/**
	 * removeActor removes an actor. The user is asked to choose a movie 
	 * to remove the actor from. The user is then asked to choose the actor to remove.
	 * The movie is then removed 
	 * 
	 * 
	 * @param tree  values of binary tree
	 * @param mov   values of movie
	 */
	public static void removeActor(BST tree, Movie mov){
		Scanner in = new Scanner(System.in);
		int counter = 1;
		int deleteActor = 0;
		System.out.println("Choose the Movie to delete Actor");
		String findMovie = in.nextLine();
		Node find = tree.search(findMovie);
		if(find != null){
			System.out.println(tree.search(findMovie).getData());
			System.out.println("Enter actor to remove");
			ArrayList<String> actor = tree.search(findMovie).getData().getNames();
			
			//actors are displayed 
			for(int i =0; i <actor.size(); i++){
				System.out.println(counter+". " + actor.get(i));
				counter++;
			}
			
			//actors are deleted
			deleteActor = CheckInput.checkInt(1, actor.size());
			actor.remove(deleteActor -1);
		}
	}
	
	/**
	 * displayMovie displays the list of movies
	 * 
	 * @param tree  values of binary tree
	 */
	public static void displayMovie(BST tree){
		tree.printBST();
	}
	
	//Find Movie's
	/**
	 * findMovies  searches by title, rating , decade, stars and actors
	 * 
	 * @param tree  values of binary tree
	 */
	public static void findMovies(BST tree){
		Scanner in = new Scanner(System.in);
		boolean done = false;

		//search repeating menu
		while(!done){
			System.out.println("a. By Title ");
			System.out.println("b. By Rating");
			System.out.println("c. By Decade");
			System.out.println("d. By Stars");
			System.out.println("e. By Actor");
			System.out.println("f. done");
			char userChoice = in.next().charAt(0);
			switch(userChoice){
			//a. By Title 
			case 'a':
			case 'A':	
				System.out.println("Enter Title");
				in.nextLine();
				String title = in.nextLine();
				Node find = tree.search(title);
				if(find != null){
					System.out.println(tree.search(title).getData());
				}
				break;
			//b. By Rating	
			case 'b':
			case 'B':
				System.out.println("Enter Rating");
				in.nextLine();
				String  rating = in.nextLine();
				tree.searchRating(rating);
				System.out.println("Item not found");			
				break;
			//c. By Decade	
			case 'c':
			case 'C':
				
				//decade menu
				System.out.println("Enter Decade");
				System.out.println("1.1920 - 1929");
				System.out.println("2.1930 - 1939");
				System.out.println("3.1940 - 1949");
				System.out.println("4.1950 - 1959");
				System.out.println("5.1960 - 1969");
				System.out.println("6.1970 - 1979");
				System.out.println("7.1980 - 1989");
				System.out.println("8.1990 - 1999");
				System.out.println("9.2000 - 2009");
				System.out.println("10.2010 - 2016");
				int decade = CheckInput.checkInt(1, 10);
				
				//decades
				int counter1 = 1920;
				int counter2 = 1930;
				int counter3 = 1940;
				int counter4 = 1950;
				int counter5 = 1960;
				int counter6 = 1970;
				int counter7 = 1980;
				int counter8 = 1990;
				int counter9 = 2000;
				int counter10 = 2010;
				
				//passes in the decades to be found and printed to console
				for(int i = 0; i < 10; i++){
					
					//1.1920 - 1929
					if(decade == 1){
						String dec =Integer.toString(counter1);
						System.out.println(dec);
						tree.searchDecade(dec);
						counter1++;
					}
					
					//2.1930 - 1939
					else if(decade == 2){
						String dec = Integer.toString(counter2);
						System.out.println(dec);
						tree.searchDecade(dec);
						counter2++;
					}
					
					//3.1940 - 1949
					else if(decade == 3){
						String dec = Integer.toString(counter3);
						System.out.println(dec);
						tree.searchDecade(dec);
						counter3++;
					}
					
					//4.1950 - 1959
					else if(decade == 4){
						String dec = Integer.toString(counter4);
						System.out.println(dec);
						tree.searchDecade(dec);
						counter4++;
					}
					
					//5.1960 - 1969
					else if(decade == 5){
						String dec = Integer.toString(counter5);
						System.out.println(dec);
						tree.searchDecade(dec);
						counter5++;
					}
					
					//6.1970 - 1979
					else if(decade == 6){
						String dec = Integer.toString(counter6);
						System.out.println(dec);
						tree.searchDecade(dec);
						counter6++;
					}
					
					//7.1980 - 1989
					else if(decade == 7){
						String dec = Integer.toString(counter7);
						System.out.println(dec);
						tree.searchDecade(dec);
						counter7++;
					}
					
					//8.1990 - 1999
					else if(decade == 8){
						String dec = Integer.toString(counter8);
						System.out.println(dec);
						tree.searchDecade(dec);
						counter8++;
					}
					
					//9.2000 - 2009
					else if(decade == 9){
						String dec = Integer.toString(counter9);
						System.out.println(dec);
						tree.searchDecade(dec);
						counter9++;
					}
					
					//10.2010 - 2016
					else if(decade == 10){
						String dec = Integer.toString(counter10);
						System.out.println(dec);
						tree.searchDecade(dec);
						counter10++;
					}

				}
				break;
			//d. By Stars	
			case 'd':
			case 'D':
				System.out.println("Enter Stars");
				in.nextLine();
				String  stars = in.nextLine();
				tree.searchStars(stars);
				System.out.println("Item not found");
				break;
			//e. By Actor	
			case 'e':
			case 'E':
				System.out.println("Enter Actor");
				in.nextLine();
				String  actors = in.nextLine();
				tree.searchActors(actors);
				break;
			//f. done	
			case 'f':
			case 'F':
				done = true;
				break;
			//invalid 	
			default:
				System.out.println("Invalid Input try again");
				break;
			}	
		}
	}
	
	/**
	 * Quit method writes the movie list to the file when 
	 * user quits
	 * 
	 * @param tree values of binary tree
	 * @param mov values of movie
	 */
	public static void quit(BST tree,Movie mov){
		try{
			PrintWriter writer = new PrintWriter("movies.txt");
			while(!tree.isEmpty()){
				writer.println(tree.findMin());
				tree.remove(tree.findMin());
			}
			writer.close();
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
	}

}
