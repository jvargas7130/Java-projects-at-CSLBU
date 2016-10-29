import java.util.ArrayList;
import java.util.Calendar;

public class Job implements Comparable<Job> {

	private String taskName;

	private String dueDate;

	public Job(String t, String d) {
		taskName = t;
		dueDate = d;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getDueDate() {
		return dueDate;
	}

	public int getMonth() {

		String dateTimeSplit[] = dueDate.split(" ");
		String date = dateTimeSplit[0];
		String monthDayYear[] = date.split("/");

		int month = Integer.parseInt(monthDayYear[0]);

		return month;
	}

	public int getDay() {
		String dateTimeSplit[] = dueDate.split(" ");
		String date = dateTimeSplit[0];
		String monthDayYear[] = date.split("/");

		int month = Integer.parseInt(monthDayYear[1]);

		return month;
	}

	public int getYear() {
		String dateTimeSplit[] = dueDate.split(" ");
		String date = dateTimeSplit[0];
		String monthDayYear[] = date.split("/");

		int month = Integer.parseInt(monthDayYear[2]);

		return month;
	}

	public int getHour() {
		String dateTimeSplit[] = dueDate.split(" ");
		String date = dateTimeSplit[0];
		String hourMinute[] = date.split(":");

		int month = Integer.parseInt(hourMinute[0]);

		return month;
	}

	public int getMinute() {
		String dateTimeSplit[] = dueDate.split(" ");
		String date = dateTimeSplit[0];
		String hourMinute[] = date.split(":");

		int month = Integer.parseInt(hourMinute[1]);

		return month;
	}
	
	@Override
	public String toString(){
		
		return taskName+"," + dueDate;
		
	}

	/**
	 * Comparable method checks to make sure jopb is in order The soonest due
	 * date is compared first and breaks ties by alphabetic order of task name
	 * 
	 * @param passes
	 *            in job object
	 * @return returns negative integer if the two objects are in order, a zero
	 *         if they are equal and a positive integer if they are out of order
	 */

	@Override
	public int compareTo(Job j) {
		int result = 0;

		// check by year
		if (getYear() > j.getYear()) {
			result = -1;
		} else if (getYear() < j.getYear()) {

			result = 1;
		} else if (getYear() == j.getYear()) {

			// check by month
			if (getMonth() > j.getMonth()) {
				result = -1;
			} else if (getMonth() < j.getMonth()) {

				result = 1;
			} else if (getMonth() == j.getMonth()) {

				// check by day
				if (getDay() > j.getDay()) {
					result = -1;
				} else if (getDay() < j.getDay()) {

					result = 1;
				} else if (getDay() == j.getDay()) {

					// check by hour
					if (getHour() > j.getHour()) {
						result = -1;
					} else if (getHour() < j.getMonth()) {

						result = 1;
					} else if (getHour() == j.getHour()) {

						// check by minute
						if (getMinute() > j.getMinute()) {
							result = -1;
						} else if (getMinute() < j.getMinute()) {

							result = 1;
						} else if (getMinute() == j.getMinute()) {
							result = taskName.compareToIgnoreCase(j.getTaskName());
						}
					}

				}
			}

		}

		return result;
	}

}
