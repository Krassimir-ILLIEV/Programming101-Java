package _02_ToDoList;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ToDoList {
	private int remTime;
	private PriorityQueue<Task> pq;
	private Queue<Task> finishedTasks;
	private Queue<Task> cancelledTasks;

	public ToDoList(int remTime) {
		this.remTime = remTime;
		pq = new PriorityQueue<Task>();
		finishedTasks = new LinkedList<Task>();
		cancelledTasks = new LinkedList<Task>();
	}

	public void addTask(Task t) {
		pq.add(t);
	}

	public void markFinished(Task t) {
		if (pq.isEmpty() || !pq.contains(t))
			return;
		pq.remove(t);
		finishedTasks.add(t);
		remTime -= t.getTime();

	}

	public void markCancelled(Task t) {
		if (pq.isEmpty() || !pq.contains(t))
			return;
		pq.remove(t);
		cancelledTasks.add(t);
	}

	public Task getTop() {
		return pq.peek();
	}

	public boolean canFinish() {
		return getRemainingTime() >= 0;
	}

	public int getTimeNeeded() {
		double totalNeededTime = 0;
		for (Task t : pq) {
			totalNeededTime += t.getTime();
		}
		return new Double(totalNeededTime).intValue();
	}

	public int getRemainingTime() { // calculates the time remaining after
									// you've
									// done all of your tasks.

		return new Double(remTime - getTimeNeeded()).intValue();

	}

}
