package Assignment2;

import java.util.Scanner;

/**
 * @author Sumitra --Factory class which will decide to whom's instance is to
 *         create and perform all other functions
 *
 */
public class FactoryMain {

	public static void main(String[] args) {

		String name;
		String role;
		char choice;
		// getting instance of company
		
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1 ->To add Frontend Engineer");
			System.out.println("2 ->to print list of Front end Engineer");

			System.out.println("3 ->To add backend Engineer");
			System.out.println("4 ->to print list of back End Engineer"); 

			int doChoice;
			do {// Validation

				System.out.println("enter integer value");
				while (!scanner.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					scanner.next();
				}
				doChoice = scanner.nextInt();
			} while (doChoice < 0);
			switch (doChoice) {
			case 1:
				// adding data in list
				System.out.println("Enter name---");
				name = scanner.next();
				FrontHandEngineer frontengineer = FrontHandEngineer.getInstance();
				frontengineer.addFrontEndEngineer(name);
				break;
			case 2:
				// showing list
				FrontHandEngineer engineerList = FrontHandEngineer.getInstance();
				engineerList.showList();
				break;
			case 3:
				System.out.println("Enter name---");
				name = scanner.next();
				BackHandEngineer backengineer = BackHandEngineer.getInstance();
				backengineer.addBackEndEngineer(name);
				break;
			case 4:
				BackHandEngineer backEngineerList = BackHandEngineer.getInstance();
				backEngineerList.showList();
				break;
				
			default:
				System.out.println("enter correct choice");
				break;
			}

			System.out.println("want to continue(y/n)");
			choice = scanner.next().charAt(0);
		} while (choice == 'y' || choice == 'Y');

		scanner.close();
	}

}
