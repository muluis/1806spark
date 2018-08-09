package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.business.Service;

public class DepositSeals implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\r\n" + 
				"\t                                             oo\r\n" + 
				"\t                                            o\"  $\r\n" + 
				"\t                                          \" o   $\r\n" + 
				"\t                                         \"      $\r\n" + 
				"\t                                        $      $$ \r\n" + 
				"\t                                        o\"     \"$o \r\n" + 
				"\t   $oo                                  $     \"$$$\r\n" + 
				"\t   $\"$oo                               \"      \"o$$ \r\n" + 
				"\t  \"$$o$\"o\"o                          o\"      $\"$$$\r\n" + 
				"\t     \"\"\"o\"$o\"\"\"\"\"\"\"\" \"\"\" oo ooooooo\"\"\"     o\"\"o$$$\r\n" + 
				"\t          \"$$ o                            o\"\"$$$\r\n" + 
				"\t    oooo$$$$$$$$oo\"o o                 o \"o \"o \"\"oo\r\n" + 
				"\t  \"$$$$$$$$$$\"\"\"\"$$$$o\"o$ o o o  \"o \" $\"$o$$oo\"o  $\"o\r\n" + 
				"\t   \"$$$$$$\"         \"\"$$o$o$ $ \"ooo$o$o$$$$$$\"$o$o $\"$o\r\n" + 
				"\t   \"$\"\"                 \"\"\"\"$$$$$o$$$$$$$$$     \"$o$$$$o\r\n" + 
				"\t   \"                           \" \"\" \"  \"$$$$       \" $$$o\r\n" + 
				"\t                                         \"$$$         \"\"\"\r\n" + 
				"\t                                           \"\"$");
		System.out.println("\t"+"\t"+"\t"+"How many seals would you like to deposit?"+"\n");
		System.out.println("Amount: ");
		try {
			Double amount = scan.nextDouble();
			Service.depositSeals(amount);
		} catch (InputMismatchException e) {
			System.out.println("\t"+"\t"+"\t"+"Please enter number of seals desired");
			return this.start();
		}
		
		return new MainMenu().start();
	}
	
	

}