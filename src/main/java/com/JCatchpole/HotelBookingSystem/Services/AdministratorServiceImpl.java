package com.JCatchpole.HotelBookingSystem.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JCatchpole.HotelBookingSystem.DAO.AdministratorDao;
import com.JCatchpole.HotelBookingSystem.model.Administrator;

@Service
public class AdministratorServiceImpl implements AdministratorService {
	
	//Inject a AdministratorDao object
	@Autowired
	private AdministratorDao adminDao;

	//Add new Administrator object to database
	@Override
	public boolean addNewAdministrator(Administrator administrator) {
		
		return adminDao.addAdministrator(administrator);
	}

	//Lists all Administrator objects in database
	@Override
	public List<Administrator> getAllAdministrators() {
		
		return adminDao.getAllAdminUsers();
	}

	//Delete a Administrator object from the database by Primary key
	@Override
	public boolean deleteAdministratorByKey(String email) {
		
		return adminDao.deleteAdminUser(email);
	}

	//Get Administrator object by primary key from the database
	@Override
	public Administrator getAdministratorByKey(String email) {
		
		return adminDao.getAdminUsersDetails(email);
	}

	@Override
	public boolean updateAdminsDetaila(Administrator admin) {
		return adminDao.updateAdminDetails(admin);
	}

}
