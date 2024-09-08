package com.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QuizGenerator {
	private static Scanner sc = new Scanner(System.in);
	private static Map<String, Character> questions = new HashMap<String, Character>();
	private static Map<String, List<String>> mcqs = new HashMap<String, List<String>>();
	
	public static int score = 0;
	public static int totalQuestions=5;

	public static void addDefaultQuestions() {
		String ques1 = "In what galaxy is our solar system located?";
		String opt1 = "A. The Milky Way";
		String opt2 = "B. Andromeda";
		String opt3 = "C. Orion";
		String opt4 = "D. Triangulum";

		List<String> options = new ArrayList<String>();

		options.add(opt1);
		options.add(opt2);
		options.add(opt3);
		options.add(opt4);

		mcqs.put(ques1, options);
		questions.put(ques1, 'A');

		options= new ArrayList<String>();

		ques1 = "Red, yellow, and blue are examples of what?";
		opt1 = "A. Secondary colors";
		opt2 = "B. Tertiary colors";
		opt3 = "C. Primary colors";
		opt4 = "D. Complementary colors";

		options.add(opt1);
		options.add(opt2);
		options.add(opt3);
		options.add(opt4);

		mcqs.put(ques1, options);
		questions.put(ques1, 'C');

		options= new ArrayList<String>();

		ques1 = "What type of gas is absorbed by plants during photosynthesis?";
		opt1 = "A. Oxygen";
		opt2 = "B. Nitrogen";
		opt3 = "C. Carbon dioxide";
		opt4 = "D. Hydrogen";

		options.add(opt1);
		options.add(opt2);
		options.add(opt3);
		options.add(opt4);

		mcqs.put(ques1, options);
		questions.put(ques1, 'C');

		options= new ArrayList<String>();

		ques1 = "Which planet is known as the “Red Planet”?";
		opt1 = "A. Venus";
		opt2 = "B. Jupiter";
		opt3 = "C. Mars";
		opt4 = "D. Saturn";

		options.add(opt1);
		options.add(opt2);
		options.add(opt3);
		options.add(opt4);

		mcqs.put(ques1, options);
		questions.put(ques1, 'C');

		options= new ArrayList<String>();

		ques1 = "Out of all the 2-digit integers between 1 and 100, a 2-digit number has to be selected at random.\n What is the probability that the selected number is not divisible by 7?";
		opt1 = "A. 13/90";
		opt2 = "B. 12/90";
		opt3 = "C. 78/90";
		opt4 = "D. 77/90";

		options.add(opt1);
		options.add(opt2);
		options.add(opt3);
		options.add(opt4);

		mcqs.put(ques1, options);
		questions.put(ques1, 'A');

	}

	public static int showMenu() {
		System.out.println("Welcome To Quiz Generator :: ");
		System.out.println("1. Create Quiz");
		System.out.println("2. Add Questions");
		System.out.println("3. Exit");
		System.out.print("Choose Above Option:: ");
		int ch = sc.nextInt();
		return ch;
	}

	public static int questionNumber = 1;
	public static void generateQuiz() {
		System.out.println("Quiz Started Answer Carefully...");
		System.out.println("__________________________________");
		mcqs.forEach((question, list) -> {
			System.out.println("Q."+questionNumber+": "+question);
			list.forEach(System.out::println);
			System.out.println("_____________________________");
			System.out.print("Choose Correct Option :: ");
			Character correct = sc.next().toUpperCase().charAt(0);

			if (correct.equals(questions.get(question))) {
				System.out.println("Correct");
				score++;
			} else {
				System.err.println("Wrong Answer");
			}
			questionNumber++;
			System.out.println("_____________________________________");
		});
		System.out.println("------------------------------");
		System.out.println("You Scored:: " + score+"/"+totalQuestions);
		System.out.println("Our feedback");
		switch (score) {
		case 0: {
			System.out.println("You Need More Hard Working");
			break;
		}
		case 1: {
			System.out.println("You Need More Hard Working");
			break;
		}
		case 3: {
			System.out.println("Very Good");
			break;
		}
		case 5: {
			System.out.println("Excellent");
			break;
		}
		default:
		{
			System.out.println("Good");
		}
		}
		
		System.out.println("------------------------------");
		score = 0;
		questionNumber = 1;
	}

	public static void main(String[] args) {

		while (true) {
			try
			{
				switch (showMenu()) {
				case 1: {
					addDefaultQuestions();
					generateQuiz();
					break;
				}
				case 2: {
					System.out.println("Enter Your Question");
					String ques = sc.nextLine();
					ques = sc.nextLine();
					System.out.print("Enter Option A: ");
					String opt1 = sc.nextLine();
					System.out.print("Enter Option B: ");
					String opt2 = sc.nextLine();
					System.out.print("Enter Option C: ");
					String opt3 = sc.nextLine();
					System.out.print("Enter Option D: ");
					String opt4 = sc.nextLine();

					System.out.print("Enter Correct Option :: ");
					Character correct = sc.next().charAt(0);

					List<String> options = new ArrayList<String>();
					options.add("A. " + opt1);
					options.add("B. " + opt2);
					options.add("C. " + opt3);
					options.add("D. " + opt4);

					mcqs.put(ques, options);
					questions.put(ques, correct);
					totalQuestions++;
					break;
				}
				case 3: {
					System.out.println("Thank You");
					sc.close();
					System.exit(0);
				}
				default: System.out.println("Invalid Input");
				}
			}
			catch (Exception e) {
				System.err.println("Error Occured");
				break;
			}
		}

	}

}
