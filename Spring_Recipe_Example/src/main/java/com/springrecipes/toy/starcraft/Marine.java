package com.springrecipes.toy.starcraft;

public class Marine extends Unit {

	// Singleton 빈 확인용
	public static int unitCount = 0; 
		
	public Marine(int generationTime) {
		name  = "Marine";
		power = 5; 
		print(++unitCount, generationTime);
	}
	
	public void attack(){
        System.out.println("탕탕");
    }

}
