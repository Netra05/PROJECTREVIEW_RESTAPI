package com.portal.exercise.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.model.Registeration_table;
import com.portal.exercise.service.Register_serve;

@RestController
public class Register_controller {
	@Autowired
	public Register_serve rs;
	
	//Post mapping
	@PostMapping("/postTable")
	public String postTable(@RequestBody Registeration_table rtr )
	{
		rs.saveRegisterTable(rtr);
		return "Data is been saved";
	}
	
	//Get Mapping
	@GetMapping("/getTable")
	public List<Registeration_table>getRegisterInfo()
	{
		return rs.getRegisterTable();
	}
	
	//getCustomerById
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable int customerId)
	{
		Optional<Registeration_table>registertable=rs.getCustomerId(customerId);
		
			if(registertable!=null)
			{
				return ResponseEntity.ok(registertable); //Return the customer's data if available
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with mentioned ID is not available");
	}
	
	//Put mapping
	@PutMapping("/updateTable")
	public Registeration_table updateRegisterInfo(@RequestBody Registeration_table ra)
	{
		return rs.updateRegisterTable(ra);
	}
	
	@PutMapping("/updateTableif/{id}")
	public ResponseEntity<String> updateRegisterInfo(@PathVariable int id,@RequestBody Registeration_table ra)
	{
		boolean updated=rs.updateRegisterTableif(id,ra);
		if(updated)
		{
			return ResponseEntity.ok("RegisterTable with ID "+id+" updated successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RegisterTable with ID "+id+" not found and not updated");
		}
	}
	
	//Delete Mapping
	
	@DeleteMapping("/deleteTable/{id}")
			 public String removeTable(@PathVariable("id") int tid)
			 {
		rs.deleteRegisterTable(tid);
		return "RegisterTable with ID "+tid+" is deleted";
			 }
	
	//Delete mapping using request param
	@DeleteMapping("/byReqParam")
	public String removeByRequestParam(@RequestParam("id") int id)
	{
		rs.deleteRegisterTable(id);
		return "RegisterTable with ID "+id+" is deleted";
	}
	
	//Delete Mapping using if
	@DeleteMapping("/deleteTableif/{id}")
	public ResponseEntity<String>deleteRegisterInfo(@PathVariable int id)
	{
		boolean deleted=rs.deleteRegisterTableif(id);
	    if(deleted) {
	    	return ResponseEntity.ok("RegisterTable with ID "+id+"deleted successfully");
	    }
	    else 
	    {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RegisterTable with ID "+id+" not found");
	    }
	    
	}
	
}
