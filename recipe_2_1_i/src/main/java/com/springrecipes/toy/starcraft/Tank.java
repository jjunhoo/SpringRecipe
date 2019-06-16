package com.springrecipes.toy.starcraft;

public class Tank extends Unit implements Repairable {
	
	// Singleton 빈 확인용
	public static int unitCount = 0; 
		
	public Tank(int generationTime) {
		name  = "Tank";
		power = 10; 
		print(++unitCount, generationTime);
	}
	
	public void attack(){
        System.out.println("퉁퉁");
	}

}
