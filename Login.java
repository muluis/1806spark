package com.revature.presentation;

import java.util.Scanner;

import com.revature.business.Service;

public class Login implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t"+"\t"+"WELCOME TO ICE BEAR BANK!");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(
			    "\t"+"\t+        .--.              .--.\r\n" + 
				"\t"+"\t+       : (\\ \". _......_ .\" /) :\r\n" + 
				"\t"+"\t+        '.    `        `    .'\r\n" + 
				"\t"+"\t+         /'   _        _   `\\\r\n" + 
				"\t"+"\t+        /     0}      {0     \\\r\n" + 
				"\t"+"\t+       |       /      \\       |\r\n" + 
				"\t"+"\t+       |     /'        `\\     |\r\n" + 
				"\t"+"\t+       \\   | .  .==.  . |   /\r\n" + 
				"\t"+"\t+        '._ \\.' \\__/ './ _.'\r\n" + 
				"\t"+"\t+         /  ``'._-''-_.'``  \\\r\n" + 
				"\t"+"\t+                 `--`"      );
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t"+"\t"+"\t"+"where the currency is seals");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t"+"\t"+"\t"+"\t"+"Username: ");
		String userName = scan.nextLine();
		System.out.println("\t"+"\t"+"\t"+"\t"+"Password: ");
		System.out.println("                                         ");
		String password = scan.nextLine();
		
		if (Service.validUser(userName, password)) {
			return new MainMenu().start();
		}
		
		System.out.println("\t"+"\t"+"\t"+"Invalid username or password. Re-enter user info.");
		return this.start();
	}

}