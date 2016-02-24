package TestTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class MyTest {

	private ArrayList<String> QuestionSet;
	private ArrayList<Answer> AnswerSet;

	public class Answer {
		String answerID;
		String answerBody;
		boolean isCorrect;

		public Answer(String answerID, String answerBody, boolean isCorrect) {
			this.answerID = answerID;
			this.answerBody = answerBody;
			this.isCorrect = isCorrect;
		}

		private String getAnswerBody() {
			return answerBody;
		}

		public String toString() {
			return "answerID: " + answerID + " answerBody: " + answerBody + " iscorrect: " + isCorrect;
		}
	}

	private ArrayList<String> getQuestionSet() {
		ArrayList<String> QuestionSet = new ArrayList<String>();
		// System.out.println("before cycle");
		for (Integer i = 0; i < 15; i++) {
			QuestionSet.add(i.toString());
			// System.out.println("in cycle");
		}

		// System.out.println("out of cycle");
		return QuestionSet;
	}

	private ArrayList<String> getChosenQuestions(ArrayList<String> QuestionSet, int numberOfQuesionsNeeded) {
		ArrayList<String> chosenQuestionSet = new ArrayList<String>();
		Random generator = new Random();
		// System.out.println("chosen q 1");
		for (int i = 0; i < numberOfQuesionsNeeded; i++) {
			int indexToRemove = generator.nextInt(QuestionSet.size());
			// System.out.println("indextoremove "+indexToRemove+"size:
			// "+QuestionSet.size());
			chosenQuestionSet.add(QuestionSet.remove(indexToRemove));

		}
		// System.out.println("chosen q 3");
		return chosenQuestionSet;

	}

	private String getQuestionText(String questionID) {
		return questionID + "text";
	}

	private ArrayList<Answer> getChosenAnswers(String questionID) {
		ArrayList<Answer> chosenAnswerSet = new ArrayList<Answer>();

		// pick 4 among all wrong answers
		ArrayList<Answer> allWrongAnswers = new ArrayList<Answer>();

		for (Integer i = 0; i < 6; i++) {
			Answer ans = new Answer(i.toString(), questionID + " AnswerBody false" + i.toString(), false);
			allWrongAnswers.add(ans);
		}

		Random generator = new Random();
		for (Integer i = 0; i < 4; i++) {
			chosenAnswerSet.add(allWrongAnswers.remove(generator.nextInt(allWrongAnswers.size())));
		}

		// all 2 among all correct answers
		ArrayList<Answer> allCorrectAnswers = new ArrayList<Answer>();

		for (Integer i = 0; i < 3; i++) {
			Answer ans = new Answer(i.toString(), questionID + " answerBody true" + i.toString(), true);
			allCorrectAnswers.add(ans);
		}

		for (Integer i = 0; i < 1; i++) {
			chosenAnswerSet.add(allCorrectAnswers.remove(generator.nextInt(allCorrectAnswers.size())));
		}

		ArrayList<Answer> randomizedAnswerSet = new ArrayList<Answer>();

		int numberOfAnswers = chosenAnswerSet.size();
		for (Integer i = 0; i < numberOfAnswers; i++) {
			randomizedAnswerSet.add(chosenAnswerSet.remove(generator.nextInt(chosenAnswerSet.size())));
		}
		return randomizedAnswerSet;
	}

	public static void main(String[] args) throws IOException {
		MyTest m = new MyTest();

		m.QuestionSet = m.getChosenQuestions(m.getQuestionSet(), 10);
		ArrayList<Answer> answers;
		System.out.println("Welcome to our testing program!");
		System.out.println(
				"Please provide the correct answers to the following 10 questions or type \"Exit\" to leave the program.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.out.print("Enter String");
		String answer = br.readLine();
		// System.out.print("Enter Integer:");

		// Scanner userInput = new Scanner(System.in);
		// String answer = userInput.nextLine();
		// System.out.println(answer);

		int numberOfQuestions = m.QuestionSet.size();
		boolean flag = false;

		while (true) {
			for (int i = 0; i < numberOfQuestions; i++) {

				System.out.println("Question #" + (i + 1) + " is: " + m.QuestionSet.get(i));
				System.out.println("Please choose one or two among the following answers:\n");

				answers = m.getChosenAnswers(m.QuestionSet.get(i));
				for (int j = 0; j < answers.size(); j++) {
					System.out.println(answers.get(j).getAnswerBody());

				}
				System.out.println();

				while (!answer.equals("Exit") && !flag) {
					try {
						answer = br.readLine();
						int userPickedNumber = Integer.parseInt(answer);
						flag = true;
					} catch (NumberFormatException nfe) {

						System.err.println("Please provide a valid number or type \"Exit\" to leave.\n");
					}
				}
				System.out.println("Goodbye!"); //score
			}

			System.out.println("Goodbye!");

		}
	}
}
