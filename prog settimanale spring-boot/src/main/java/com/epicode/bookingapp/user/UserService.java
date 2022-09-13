package com.epicode.bookingapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository ur;
	
	public void create(User u) {
        ur.save(u);
    }

    public User read(Long id) {
        return ur.findById(id).get();
    }

    public void update(User u) {
        ur.save(u);
    }

    public void delete(Long id) {
        ur.deleteById(id);
    }
}

