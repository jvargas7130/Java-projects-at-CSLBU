
public class Job implements Comparable {
	
	private String taskName;
	
	private String dueDate;
	
	public Job(String t, String d){
		taskName = t;
		dueDate = d;
	}
	
	public String getTaskName(){
		return taskName;
	}
	
	public String getDueDate(){
		return dueDate;
	}
	
	public void setTaskName(String t){
		taskName = t;
	}
	
	public void  setDueDate(String d){
		dueDate = d;
	}
	
	/**
	 * Comparable method checks to make sure jopb is in order
	 * The soonest due date is compared first  and breaks ties by alphabetic order of task name
	 * 
	 * @param passes in job object
	 * @return returns negative integer if the two objects are in order, 
	 * a zero if they are equal and  a positive integer if they are out of order
	 */
	@Override
	public int compareTo(Object o) {
		return 0;
	}
	

}
