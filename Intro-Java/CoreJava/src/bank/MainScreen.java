package bank;

import java.util.Scanner;

public class MainScreen implements Screen {

	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		System.out.println("WELCOME TO GREED CO. BANKING, PLEASE SELECT FROM THE FOLLOWING:");
		System.out.println("1 TO LOGIN");
		System.out.println("2 to contact Customer Service");
		String input = scan.nextLine();

		switch (input) {

		case "1":
			return new pinMenu();
			
		case "2":
			System.out.println("Please call 1-637-700-1337");
		}

		// TODO Auto-generated method stub
		return this;
	}

}
