package org.practice.restapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface repository extends JpaRepository<bean, Long>{

	@Query("from bean where employeeId = :eID")
	public bean findByEmployeeId(String eID);
	
}
