package com.epicode.bookingapp.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

	@Bean("user1")
	public User newUser1() {
		return new User("Vitalij","Vitalij Mazzucchi","vitalimazzucchi@gmail.com");
	}
	@Bean("user2")
	public User newUser2() {
		return new User("Mauro","Mauro Larese","maurolarese@gmail.com");
	}
	@Bean("user3")
	public User newUser3() {
		return new User("Carlo","Carlo Magno","carlomagno@gmail.com");
	}
}
