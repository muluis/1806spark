package com.advanced.drake;

public interface OrderPizza {
	
	String crust = "Starting your pizza";
	
	default void buildPizza() {
		
		System.out.println(crust);
		
	}

}