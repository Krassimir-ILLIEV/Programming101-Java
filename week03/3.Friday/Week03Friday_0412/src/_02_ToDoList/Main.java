package _02_ToDoList;

public class Main {

	public static void main(String[] args) {

			 ToDoList todo = new ToDoList(11); //11 hours remaining!
			 todo.addTask(new StudyForAlgebraTask(10)); //maximum priority!
			 todo.addTask(new LearnGeometryTask()); //default priority, smaller than 10
			 todo.addTask(new GoOutTask(1.5f));  //default priority, smaller than 10
			 todo.addTask(new SleepTask()); //straight 8 hours, of course!

			 if (todo.canFinish()){
			     System.out.println("Woohoo!");
			 } else {
			     System.out.println("I am ...screwed :(");
			 }

			 System.out.println(todo.getTop()); //StudyForAlgebraTask
			 System.out.println(todo.getTimeNeeded()); //sum of the time needed for every task added in todo list

	}

}
