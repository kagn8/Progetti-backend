package com.epicode.bookingapp.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BuildingService {

	@Autowired
	private BuildingRepository br;
	
	public void create(Building b) {
        br.save(b);
    }

    public Building read(Long id) {
        return br.findById(id).get();
    }

    public void update(Building b) {
        br.save(b);
    }

    public void delete(Long id) {
        br.deleteById(id);
    }
}
