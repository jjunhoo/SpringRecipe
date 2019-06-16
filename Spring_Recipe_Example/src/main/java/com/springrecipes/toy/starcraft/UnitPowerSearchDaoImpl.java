package com.springrecipes.toy.starcraft;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UnitPowerSearchDao")
public class UnitPowerSearchDaoImpl implements UnitPowerSearchDao {
	
	// DB 연결 없이 데이터를 조회하기 위해, 컬렉션을 사용하여 임시 데이터 생성
	private final Map<String, Unit> unitInfo = new HashMap<>();
	
	// Autowired를 통해 Bean을 주입 받아 생성자 파라미터로 전달
	@Autowired
	public UnitPowerSearchDaoImpl(SCV scv, Tank tank, Marine marine) {	
		// Bean 등록 시 Scope를 Singleton으로 설정해놓았기 때문에 기존의 scv 인스턴스 사용
		unitInfo.put("SCV", scv);
		// Bean 등록 시 Scope를 Prototype으로 설정해놓았기 때문에 새로운 Tank, Marine 인스턴스를 생성하여 사용
		unitInfo.put("Tank", tank);
		unitInfo.put("Marine", marine);
	}
	
	@Override
	public int getUnitPower(String name) {
		return unitInfo.get(name).getPower();
	}

}
