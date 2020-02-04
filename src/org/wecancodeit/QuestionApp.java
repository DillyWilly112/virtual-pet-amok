package org.wecancodeit;
import java.util.Scanner;
import java.util.regex.Pattern;

public class QuestionApp {

	Scanner input;

	public QuestionApp(Scanner input) {

		this.input = input;

	}

	boolean yesOrNo(String question) {

		System.out.println(question);

		while (true) {

			String response = input.nextLine();
			switch (response.toLowerCase()) {

				case "y":	

				case "yes":

					return true;

				case "n":

				case "no": 
					
					return false;

				default:
					
					System.out.println("Sorry, I didn't catch that?");

			}
		}
	}

	String verifyString(String question) {

		System.out.println(question);



		while (true) {

			String response = input.nextLine();

			boolean noNumbers = Pattern.matches("[a-zA-Z]+", response);

			if (response.toLowerCase().equals("quit"))  {

				System.exit(0);

			}

			if (noNumbers) {

				return response;

			}

			System.out.println("Please enter valid text, not a number. Thank you.");

		}
	}

	int returnInt(String question, Boolean negativesOK) {

		System.out.println(question);

		boolean isInteger;

		if (!negativesOK) {

			while (true) {

				String response = input.nextLine();

				if (response.toLowerCase().equals("quit"))  {

					System.exit(0);

				}

				isInteger = isInteger(response);

				if (isInteger) {

					int responseInt = Integer.parseInt(response);

					if (responseInt > 0) {

						return responseInt;

					}

					System.out.println("Please enter a realistic (positive) number!");	

				} else {

					System.out.println("Please enter a valid integer or type 'Quit' to end the progam.");

				}
			}
		}

		while (true) {

			String response = input.nextLine();

			if (response.toLowerCase().equals("quit")) {

				System.exit(0);

			}

			isInteger = isInteger(response);

			if (isInteger) {

				int responseInt = Integer.parseInt(response);

				return responseInt;

			}

			System.out.println("Please enter a valid integer or type 'Quit' to end the progam.");

		}
	}

	public static boolean isInteger(String s) {

		boolean isValidInteger = false;

	      try

	      {

	         Integer.parseInt(s);

	         isValidInteger = true;

	      }

	      catch (NumberFormatException ex)

	      {
	      }

	      return isValidInteger;

	}
}