package com.pojo;

import com.pojo.abstracts.Pojo;

public class Driver {

	public static void main(String[] args){
		System.out.println("90J0 MACHINE: INACTIVE");

		Pojo bus = new Pojo();
		System.out.println(bus.modelNumber + " produced");
		Pojo transport = new Pojo("L33T",12,true);
		System.out.println(transport.modelNumber + " produced");

}
}
