package com.epicode.bookingapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	@Autowired
	private UserService us;

	@PostMapping
	public void create(@RequestBody User u) {

		try {
			us.create(u);
		} catch (Exception e) {
			log.error("Create failed");
		}
	}

	@GetMapping("/{id}")
	public User read(@PathVariable Long id) {

		try {
			return us.read(id);
		} catch (Exception e) {
			log.error("Search failed");
			return new User();
		}
	}

	@PutMapping
	public void update(@RequestBody User u) {
		try {
			us.update(u);
		} catch (Exception e) {
			log.error("Creation failed");
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		try {
			us.delete(id);
		} catch (Exception e) {
			log.error("Delete failed");
		}
	}
}
