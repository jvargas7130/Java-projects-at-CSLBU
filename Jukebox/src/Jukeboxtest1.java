import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Jukebox program provides functionality to display the list of tasks, display
 * current task, adds a new item to the task list, Mark complete - removes task
 * from list, displays new current task Postpone next task, quits and reads in
 * fie
 * 
 * @author Jesus Vargas
 *
 */
public class Jukeboxtest1 {

	public static void main(String[] args) {
		Heap<Song> song = new Heap<Song>();
		menu(song);
	}

	/**
	 * ReadInFile reads in song list and stores them in an array *
	 * 
	 * @param fileName  passes in songlist
	 *          
	 * @param songs arraulist to be stored
	 *           
	 */
	public static void readInFile(String fileName, Heap<Song> song) {

		// Reads in Files
		try {
			Scanner read = new Scanner(new File(fileName));
			do {

				String line = read.nextLine();
				String[] tokens = line.split(",");
				song.addNode(new Song(tokens[0], tokens[1], tokens[2], tokens[3]));

			} while (read.hasNext());
			read.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}

	}

	/**
	 * Menu didplays menu and repeats menu untill user quits
	 * 
	 * @param song heap is passedin
	 */
	public static void menu(Heap<Song> song) {

		// read in file for songs

		readInFile("songs.txt", song);

		// write file for songs
		//

		boolean done = false;
		while (!done) {

			System.out.println("1. Display the list of songs");
			System.out.println("2. Display current song.");
			System.out.println("3. Add a new song to the list");
			System.out.println("4. Play next song");
			System.out.println("5. Re-rate next song");
			System.out.println("6. Quit");
			int choose = CheckInput.checkInt(1, 6);

			switch (choose) {
			// Display the list of songs
			case 1:
				listSongs(song);
				break;
			// Display current song.
			case 2:
				displayCSong(song);
				break;
			// Add a new song to the list
			case 3:
				addSong(song);
				break;
			// Play next song-removes song from list, displays new current song.
			case 4:
				playNextSong(song);
				break;
			// Re-rate next song- prompts user for new rating , remove and
			// re-add to list
			case 5:
				reRatesong(song);
				break;
			// quit
			case 6:
				System.out.println("You have quit. Now savig.... ");
				writeSongsToFile("songs.txt", song);

				done = true;
				break;

			default:
				break;

			}

		}
	}

	/**
	 * Listsongs displays the list of songs
	 */
	public static void listSongs(Heap<Song> song) {

		if (!song.isEmpty()) {
			song.PrintHeap();
		} else {
			System.out.println("List is empty");
		}

	}

	/**
	 * DisplayCSong displays the current song
	 * 
	 */
	public static void displayCSong(Heap<Song> song) {
		if (!song.isEmpty()) {
			System.out.println(song.getNodeAt(0).getTitle() + " " + song.getNodeAt(0).getArtist() + " "
					+ song.getNodeAt(0).getAlbum() + " " + song.getNodeAt(0).getRating());

		} else {
			System.out.println("List is empty");
		}

	}

	/**
	 * Addsong method adds a song to the list
	 * 
	 */
	public static void addSong(Heap<Song> song) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Title");
		String title = in.nextLine();
		System.out.println("Enter Artist");
		String artist = in.nextLine();
		System.out.println("Enter Album");
		String album = in.nextLine();
		System.out.println("Enter Rating");
		String rating = in.nextLine();

		song.addNode(new Song(title, artist, album, rating));

	}

	/**
	 * Playnextsong plays -removes song from list, displays new current song.
	 * 
	 */
	public static void playNextSong(Heap<Song> song) {
		if (!song.isEmpty()) {
			song.removeMin();
		} else {
			System.out.println("List is empty");
		}

	}

	/**
	 * Re-rate next song- prompts user for new rating , remove and re-add to
	 * list
	 */
	public static void reRatesong(Heap<Song> song) {

		if (!song.isEmpty()) {
			Scanner in = new Scanner(System.in);
			String title = song.getNodeAt(0).getTitle();
			String artist = song.getNodeAt(0).getArtist();
			String album = song.getNodeAt(0).getAlbum();

			System.out.println("Enter rate");
			int rate = CheckInput.checkInt(1, 5);
			String strRate = "" + rate;
			song.removeMin();

			song.addNode(new Song(title, artist, album, strRate));
		} else {
			System.out.println("List is empty");
		}

	}

	/**
	 * WriteSongsToFile writes  songs to file
	 * 
	 * @param fileName name of file 
	 * @param songs that are stored in the Heap
	 */
	public static void writeSongsToFile(String fileName, Heap<Song> song) {
		try {
			PrintWriter writer = new PrintWriter(fileName);
			while (!song.isEmpty()) {

				writer.println(song.removeMin().toString());

			}
			writer.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}
	}
}
