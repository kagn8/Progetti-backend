package com.epicode.bookingapp.workstation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WorkstationService {

	@Autowired
	private WorkstationRepository wr;
	
	public void create(Workstation w) {
        wr.save(w);
    }

    public Workstation read(Long id) {
        return wr.findById(id).get();
    }

    public void update(Workstation w) {
        wr.save(w);
    }

    public void delete(Long id) {
        wr.deleteById(id);
    }
    
    public List<Workstation> findByTypeAndCity(String city,TypeWorkstation type){
    	
    	return wr.findByCountryAndType(city,type);
    	
    }
}
