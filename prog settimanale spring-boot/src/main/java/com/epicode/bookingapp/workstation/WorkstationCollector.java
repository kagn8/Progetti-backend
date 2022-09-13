package com.epicode.bookingapp.workstation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/workstation")

public class WorkstationCollector {

	@Autowired
	private WorkstationService ws;

	@PostMapping
	public void create(@RequestBody Workstation w) {
		try {
			ws.create(w);
		} catch (Exception e) {
		log.error("Creation failed");
		
		}
		
		
	}

	@GetMapping("/{id}")
	public Workstation read(@PathVariable Long id) {
		try {
			return ws.read(id);
		} catch (Exception e) {
			log.error("Object  non found");
			return new Workstation();
			
		}
		
	}

	@PutMapping
	public void update(@RequestBody Workstation w) {
		try {
			ws.update(w);
		} catch (Exception e) {
			log.error("Update failed");
		}
		
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		
		try {
			ws.delete(id);
		} catch (Exception e) {
			log.error("Delete failed");		
			}
	}

	@GetMapping
	public List<Workstation> findByCountryAndType(@RequestParam String city, @RequestParam TypeWorkstation type) {
	 
		try {
			return ws.findByTypeAndCity(city, type);
		} catch (Exception e) {
			log.error("Search failed, press ALT+F4");
			return new ArrayList<Workstation>();
			
		}

	}
}
