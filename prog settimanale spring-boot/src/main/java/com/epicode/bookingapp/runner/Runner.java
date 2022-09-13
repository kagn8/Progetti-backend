package com.epicode.bookingapp.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicode.bookingapp.booking.BookingConfiguration;
import com.epicode.bookingapp.booking.BookingService;
import com.epicode.bookingapp.building.BuildingConfiguration;
import com.epicode.bookingapp.building.BuildingService;
import com.epicode.bookingapp.user.UserConfiguration;
import com.epicode.bookingapp.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
@AllArgsConstructor
public class Runner implements ApplicationRunner {

	
	
	//@Autowired
	BuildingConfiguration bconf;
	
	//@Autowired
	BuildingService bs;
	
	//@Autowired
	BookingConfiguration bc;
	
	//@Autowired
	BookingService bser;
	
	//@Autowired 
	UserConfiguration uc;
	
	//@Autowired
	UserService us;
	
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Runner start-----------------------------------------------------");
		
		bs.create(bconf.building1());
		
		us.create(uc.newUser1());
		
		bser.create(bc.booking1());
		
		bser.create(bc.booking2());
		
		
		
		
		
		
		
	}

}
