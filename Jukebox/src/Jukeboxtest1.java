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
		Heap<Song> h = new Heap<Song>();
		menu(h);
	}

	/**
	 * ReadInFile reads in song list and stores them in an array *
	 * 
	 * @param fileName
	 *            passes in songlist
	 * @param songs
	 *            arraulist to be stored
	 */
	public static void readInFile(String fileName, Heap<Song> h) {

		// Reads in Files
		try {
			Scanner read = new Scanner(new File(fileName));
			do {

				String line = read.nextLine();
				String[] tokens = line.split(",");
				h.addNode(new Song(tokens[0], tokens[1], tokens[2], tokens[3]));

			} while (read.hasNext());
			read.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}

	}

	public static void menu(Heap<Song> h) {

		// read in file for songs

		readInFile("songs.txt", h);

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
				listSongs(h);
				break;
			// Display current song.
			case 2:
				displayCSong(h);
				break;
			// Add a new song to the list
			case 3:
				addSong(h);
				break;
			// Play next song-removes song from list, displays new current song.
			case 4:
				playNextSong(h);
				break;
			// Re-rate next song- prompts user for new rating , remove and
			// re-add to list
			case 5:
				reRatesong(h);
				break;
			// quit
			case 6:
				System.out.println("You have quit. Now savig.... ");
				writeSongsToFile("songs.txt", h);

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
	public static void listSongs(Heap<Song> h) {

		if (!h.isEmpty()) {
			h.PrintHeap();
		} else {
			System.out.println("List is empty");
		}

	}

	/**
	 * DisplayCSong displays the current song
	 * 
	 */
	public static void displayCSong(Heap<Song> h) {
		if (!h.isEmpty()) {
			System.out.println(h.getNodeAt(0).getTitle() + " " + h.getNodeAt(0).getArtist() + " "
					+ h.getNodeAt(0).getAlbum() + " " + h.getNodeAt(0).getRating());

		} else {
			System.out.println("List is empty");
		}

	}

	/**
	 * Addsong method adds a song to the list
	 * 
	 */
	public static void addSong(Heap<Song> h) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Title");
		String title = in.nextLine();
		System.out.println("Enter Artist");
		String artist = in.nextLine();
		System.out.println("Enter Album");
		String album = in.nextLine();
		System.out.println("Enter Rating");
		String rating = in.nextLine();

		h.addNode(new Song(title, artist, album, rating));

	}

	/**
	 * Playnextsong plays -removes song from list, displays new current song.
	 * 
	 */
	public static void playNextSong(Heap<Song> h) {
		if (!h.isEmpty()) {
			h.removeMin();
		} else {
			System.out.println("List is empty");
		}

	}

	/**
	 * Re-rate next song- prompts user for new rating , remove and re-add to
	 * list
	 */
	public static void reRatesong(Heap<Song> h) {

		if (!h.isEmpty()) {
			Scanner in = new Scanner(System.in);
			String title = h.getNodeAt(0).getTitle();
			String artist = h.getNodeAt(0).getArtist();
			String album = h.getNodeAt(0).getAlbum();

			System.out.println("Enter rate");
			int rate = CheckInput.checkInt(1, 5);
			String strRate = "" + rate;
			h.removeMin();

			h.addNode(new Song(title, artist, album, strRate));
		} else {
			System.out.println("List is empty");
		}

	}

	/**
	 * WriteSongsToFile writes a songs to file
	 * 
	 * @param fileName
	 * @param songs
	 */
	public static void writeSongsToFile(String fileName, Heap<Song> h) {
		try {
			PrintWriter writer = new PrintWriter(fileName);
			while (!h.isEmpty()) {

				writer.println(h.removeMin().toString());

			}
			writer.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}
	}
}
