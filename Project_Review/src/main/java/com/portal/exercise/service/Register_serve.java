package com.portal.exercise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.exercise.model.Registeration_table;
import com.portal.exercise.repository.RegisterRepo;

@Service
public class Register_serve {
	@Autowired
	public RegisterRepo rtrepo;
	
	//to post the data
	public String saveRegisterTable(Registeration_table rt)
	{
		rtrepo.save(rt);
		return "Data is successfully saved in the database";
	}
	
	//to get the data
	
	public List<Registeration_table>getRegisterTable()
	{
		return rtrepo.findAll();
	}
	
	//getCustomerById
	public Optional<Registeration_table>getCustomerId(int customerId)
	{
		Optional<Registeration_table>registertable=rtrepo.findById(customerId);
		if(registertable.isPresent())
		{
			return registertable;
		}
		return null;
	}
	//put-->to update the data
	public Registeration_table updateRegisterTable(Registeration_table r)
	{
		return rtrepo.saveAndFlush(r);
	}
	
	
	//to update the existing data when if id is present
	public boolean updateRegisterTableif(int userId,Registeration_table r)
	{
		if(rtrepo.existsById(userId))
		{
			rtrepo.save(r);
			return true;
		}
		return false;
	}
	
	//to delete the data
	public void deleteRegisterTable(int user_Id)
	{
		System.out.println("Sucessfully Deleted");
		rtrepo.deleteById(user_Id);
	}
	
	//to delete the existing data if id is present
	public boolean deleteRegisterTableif(int userId) {
		if(rtrepo.existsById(userId))
		{
			rtrepo.deleteById(userId);
			return true;
		}
		return false;
	}
	

}
