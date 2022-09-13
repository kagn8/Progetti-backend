package com.epicode.bookingapp.workstation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WorkstationRepository extends CrudRepository<Workstation, Long> {
	
	@Query("SELECT w FROM Workstation w WHERE w.building.city =:city AND w.type =:type")
    public List<Workstation> findByCountryAndType(String c, TypeWorkstation type);
}
