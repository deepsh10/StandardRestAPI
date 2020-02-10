package org.practice.restapi;

import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="/user",description = "User CRUD Operations")
@RestController
public class controller {

	@Autowired
	private repository beanRepo;
	
	@GetMapping(value="/user/{id}")
	@ApiOperation(value ="Find User By ID",
			notes = "Single ID should be provided, contact admin if you are not aware")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User fetched"),
		      				@ApiResponse(code = 404, message = "User not Found") } 
				)
	public Optional<bean> getUser(@PathVariable long id)
	{
		System.out.println("Id is" +id);
		
		return beanRepo.findById(id);
	}
	
	@PostMapping(value="/user/update/{eId}")
	@ApiOperation(value ="Update User.", notes="You can update User Name and password.")
	public HttpStatus updateUser(@PathVariable String eId, @RequestBody bean update)
	{
		System.out.println("Employee ID: " + eId);
		
		bean currentBean = beanRepo.findByEmployeeId(eId);
		
		if(currentBean != null)
		{
			System.out.println(currentBean.getUserName());
		}
		
		if(!eId.equals(update.getEmployeeId()) || currentBean == null)
		{
			return HttpStatus.BAD_REQUEST;
		}
		
		update.setId(currentBean.getId());
		
		beanRepo.save(update);
		
		return HttpStatus.ACCEPTED;
	}
	
	@DeleteMapping(value="/user/delete/{id}")
	@ApiOperation(value ="Delete User By ID")
	public HttpStatus deleteById(@PathVariable long id)
	{
		System.out.println("Id is "+ id);
		beanRepo.deleteById(id);
		return HttpStatus.ACCEPTED;
	}

	@ApiOperation(value ="Add User")
	@PutMapping(value="/user/add")
	public bean addUser(@RequestBody bean request)
	{
		System.out.println("User name" + request.getUserName());
		System.out.println("Password" + request.getPassword());
		System.out.println("Employee ID" + request.getEmployeeId());
		
		bean newUser = beanRepo.save(request);
		
		return newUser;
	}
	
}
