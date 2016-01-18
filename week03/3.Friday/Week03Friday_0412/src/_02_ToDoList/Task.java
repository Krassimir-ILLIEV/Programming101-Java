package _02_ToDoList;

public class Task {
	private double neededTime;
	private int priority;
	private static final int  DEFAULT_PRIORITY=5;
	private static final double DEFAULT_TIME=1.0;

	public Task(double neededTime, int priority) {
		this.neededTime = neededTime;
		this.priority = priority;
	}
	
	public Task(int priority) {
		this(DEFAULT_TIME,priority);
	}
	
	public Task() {
		this(DEFAULT_TIME, DEFAULT_PRIORITY);

	}
	
	public Task(float neededTime) {
		this(neededTime, DEFAULT_PRIORITY);

	}

	public double getTime() {
		return neededTime;
	}

	public int getPriority() {
		return priority;
	}

	public int compareTo(Task t) {
		if (this.priority > t.priority) {
			return 1;
		} else if (this.priority == t.priority) {
			return 0;
		}
		return -1;
	}

}
