package com.ex.classes;

public class Launcher {
	
	public static void main(String[] args) {
		Dog sparky = new Dog("sparky", 48, false, "zombie");
		System.out.println(sparky.getName());
		Fish nemo = new Fish("Nemo", 50, true, 1);
		System.out.println(nemo.getFins());
		
	
	
	Dog bolt = new Dog("Bolt", 3, true, "husky");
	
	Fish bubbles = new Fish("bubbles", 2, true, 4);
	
	Dog drew = new Dog("Drew", 8, true, "mut");
	
	Pet[] pets = new Pet[5];
	pets[0] = sparky;
	pets[1] = nemo;
	pets[2] = bolt;
	pets[3] = bubbles;
	pets[4] = drew;
	
	for(Pet p: pets) {
		p.speak();
	}
	
}
	
}
