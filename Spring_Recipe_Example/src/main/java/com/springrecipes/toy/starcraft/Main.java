package com.springrecipes.toy.starcraft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.springrecipes.toy.starcraft.config.StarcraftConfiguration;

public class Main {

	public static void main(String[] args) {
		// 스프링 IoC 인스턴스 생성 및 configuration 설정
		// 직접 config를 설정해둔 파일뿐만 아니라 패키지 전체의 어노테이션을 스캔할 수도 있음 
		ApplicationContext context = new AnnotationConfigApplicationContext("com.springrecipes.toy.starcraft", "com.springrecipes.toy.starcraft.config");
		
		// IoC에서 등록해놓은 Bean 사용
		SCV scv       = context.getBean(SCV.class);
		Tank tank     = context.getBean(Tank.class);
		Marine marine = context.getBean(Marine.class);
		
		// SCV의 경우, @Bean Scope를 Singleton으로 해두었기 때문에 신규 생성되지 않음
		SCV secondScv       = context.getBean(SCV.class);
		// Tank, Marine의 경우, @Bean Scope를 Prototype으로 해두었기 때문에 신규 생성됨
		Tank secondTank     = context.getBean(Tank.class);
		Marine secondMarine = context.getBean(Marine.class);
		
		// 스타크래프트 각 유닛의 파워를 조회하는 서비스 생성 후 조회 메서드 호출 
		UnitPowerSearchService  unitPowerSearchService = context.getBean(UnitPowerSearchService.class);
		System.out.println("SCV Power : " + unitPowerSearchService.getUnitPower("SCV"));
		System.out.println("Tank Power : " + unitPowerSearchService.getUnitPower("Tank"));
		System.out.println("Marine Power : " + unitPowerSearchService.getUnitPower("Marine"));
		
		// Marine 클래스는 Repairable 인터페이스를 구현하지 않았기 때문에 SCV의 Repair 기능을 사용할 수 없음
		scv.Repair(marine);
		// Tank 클래스는 Repairable 인터페이스를 구현하지 않았기 때문에 SCV의 Repair 기능을 사용할 수 있음
		scv.Repair(tank);
		
	}
}
