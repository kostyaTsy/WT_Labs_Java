package main.java.by.tc.task01.main;

import main.java.by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {

	/**
	 * @param appliance that should be printed to console
	 */
	public static void print(Appliance appliance) {
		if (appliance == null)
			System.out.println("Find error");
		else
			System.out.println(appliance.toString());
		
	}

}
