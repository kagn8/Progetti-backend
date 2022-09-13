package com.epicode.bookingapp.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.bookingapp.workstation.Workstation;

@Configuration
public class BuildingConfiguration {

	
	
	@Autowired @Qualifier("Workstation1") Workstation w1;
	@Autowired @Qualifier("Workstation2") Workstation w2;
	@Autowired @Qualifier("Workstation3") Workstation w3;
	@Autowired @Qualifier("Workstation4") Workstation w4;
	@Autowired @Qualifier("Workstation5") Workstation w5;
	
	@Bean("b1")
	public Building building1() {
		Building b = new Building();
		b.setAddress("Via Roma");
		b.setCity("Roma");
		b.setName("Epicode");
		b.addWorkstation(w1);
		b.addWorkstation(w2);
		b.addWorkstation(w3);
		return b;
	}
	
	@Bean("b2")
	public Building building2() {
		Building b = new Building();
		b.setAddress("Via Firenze");
		b.setCity("Campobasso");
		b.setName("GigaChadsrl");
		b.addWorkstation(w4);
		b.addWorkstation(w5);
		return b;
		
	}
}
