package com.springrecipes.toy.starcraft;

public class SCV extends Unit implements Repairable {

	// Singleton 빈 확인용
	public static int unitCount = 0; 
	
	public SCV(int generationTime) {
		name  = "SCV";
		power = 1;
		print(++unitCount, generationTime);
	}
	
	public void Repair(Unit u) {
		if (u instanceof Repairable) {
			System.out.println(u.name + " is available Repair");
		} else {
			System.out.println(u.name + " is unavailable Repair");
		}
	}
}
