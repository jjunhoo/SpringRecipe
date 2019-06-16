package com.springrecipes.toy.starcraft;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Unit {
	
	public String name; // Unit 이름
	public int power;   // Unit 파워
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void attack() {
		System.out.println("attack !");
	}
	
	// 해당 유닛의 Scope, 이름, 파워, 생성 시간(Properties 파일 사용) 출력
	public void print(int unitCount, int generationTime) {
		System.out.println("[" + unitCount + "번째] " + name + " Generator ! (Power : " + this.power + " / GenerationTime : " + generationTime + ")");
	}
}
