import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Jukebox program provides functionality to display the list of songs, display
 * current song , add a new song to the list , Mark complete - removes task form
 * list, remove and readd to list postpone next task and reads in the files.
 * 
 * @author Jesus Vargas
 *
 */
public class TasklistTest {
	public static void main(String[] args) {
		menu();

	}

	public static void readInFile(String fileName, Heap<Job> task) {
		// ArrayList<String> tempDate = new ArrayList<String>();
		// Reads in Files
		try {
			Scanner read = new Scanner(new File(fileName));
			do {

				String line = read.nextLine();
				String[] tokens = line.split(",");

				String tsk = tokens[0];
				String date = tokens[1];

				// String date = tokens[ 1 ];
				// String[] dDate = date.split("/");
				// for(int j = 0; j <dDate.length; j++){
				// tempDate.add(dDate[j]);
				// }

				task.addNode(new Job(tsk, date));

			} while (read.hasNext());
			read.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}
	}

	public static void menu() {
		Heap<Job> task = new Heap<Job>();

		// read in file for songs
		readInFile("taskList.txt", task);

		// write file for songs
		// writeSongsToFile("taskList.txt", task);

		boolean done = false;
		while (!done) {

			System.out.println("1. Display the list of tasks");
			System.out.println("2. Display current task.");
			System.out.println("3. Add a new item to the task list");
			System.out.println("4. Mark Complete");
			System.out.println("5. Postpone next task");
			System.out.println("6. Quit");
			int choose = CheckInput.checkInt(1, 6);

			switch (choose) {
			// 1. Display the list of tasks
			case 1:
				displayList(task);

				break;
			// 2. Display current task.
			case 2:
				displayCtask(task);
				break;
			// 3. Add a new item to the task list
			case 3:
				addTask(task);
				break;
			// 4. Mark Complete
			case 4:
				markComplete(task);
				break;
			// 5. Postpone next task
			case 5:
				postponeNextTask(task);
				break;
			// 6. Quit
			case 6:
				System.out.println("You have quit. Now savig.... ");
				writeSongsToFile("taskList.txt", task);
				done = true;
				break;

			default:
				break;

			}

		}
	}

	public static void displayList(Heap<Job> task) {
		if (!task.isEmpty()) {
			task.PrintHeap();
		} else {
			System.out.println("List is empty");
		}

	}

	public static void displayCtask(Heap<Job> task) {
		if (!task.isEmpty()) {
			System.out.println(task.getNodeAt(0).getTaskName() + task.getNodeAt(0).getDueDate());
		} else {
			System.out.println("List is empty");
		}

	}

	public static void addTask(Heap<Job> task) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Task");
		String newTask = in.nextLine();
		System.out.println("Enter date and time");
		String date = in.nextLine();

		task.addNode(new Job(newTask, date));

	}

	public static void markComplete(Heap<Job> task) {

		if (!task.isEmpty()) {
			task.removeMin();
		} else {
			System.out.println("List is empty");
		}

	}

	public static void postponeNextTask(Heap<Job> task) {
		if (!task.isEmpty()) {
			Scanner in = new Scanner(System.in);

			String tsk = task.getNodeAt(0).getTaskName();

			System.out.println("Enter new date");
			String newDate = in.nextLine();

			task.removeMin();
			task.addNode(new Job(tsk, newDate));

			System.out.println(task.getNodeAt(0).getTaskName() + task.getNodeAt(0).getDueDate());
		} else {
			System.out.println("List is empty");
		}

	}

	public static void writeSongsToFile(String fileName, Heap<Job> task) {
		try {
			PrintWriter writer = new PrintWriter(fileName);
			while (!task.isEmpty()) {

				writer.println(task.removeMin().toString());

			}
			writer.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}
	}

}
