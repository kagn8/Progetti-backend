package com.epicode.bookingapp.workstation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkstationConfiguration {
	
	
	@Bean("Workstation1")
	public Workstation worstation1() {
		return new Workstation("Description", TypeWorkstation.PRIVATE, 1);
	}
	@Bean("Workstation2")
	public Workstation worstation2() {
		return new Workstation("Description", TypeWorkstation.PRIVATE, 3);
	}
	@Bean("Workstation3")
	public Workstation worstation3() {
		return new Workstation("Description", TypeWorkstation.OPENSPACE, 5);
	}
	@Bean("Workstation4")
	public Workstation worstation4() {
		return new Workstation("Description", TypeWorkstation.MEETENG_ROOM, 10);
	}
	@Bean("Workstation5")
	public Workstation worstation5() {
		return new Workstation("Description", TypeWorkstation.MEETENG_ROOM, 7);
	}
}
