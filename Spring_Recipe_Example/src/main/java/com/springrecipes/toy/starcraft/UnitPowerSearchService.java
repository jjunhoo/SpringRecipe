package com.springrecipes.toy.starcraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitPowerSearchService {
	 
	private UnitPowerSearchDao unitPowerSearchDao;
	
	// Autowired를 사용하여 Dao를 주입 
	@Autowired
	public UnitPowerSearchService(UnitPowerSearchDao unitPowerSearchDao) {
		this.unitPowerSearchDao = unitPowerSearchDao;
	}
	
	// Autowired를 사용하여 주입 받은 Dao의 메서드 호출
	public int getUnitPower(String name) {
		return unitPowerSearchDao.getUnitPower(name);
	}
}
