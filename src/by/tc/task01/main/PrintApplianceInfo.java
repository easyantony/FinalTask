package by.tc.task01.main;

import java.util.List;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> appliances) {
		
		for(Appliance element : appliances) {
			
			System.out.println(element.toString());
		}
		
	}
	
}
