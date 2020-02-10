package org.practice.restapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class bean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="USER_NAME", nullable = false)
	private String userName;
	
	@Column(name="EMP_ID")
	private String employeeId;
	
	@Column(name="PASSWORD")
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public bean(String userName, String employeeId, String password) {
		super();
		this.userName = userName;
		this.employeeId = employeeId;
		this.password = password;
	}
	
	public bean(long id, String userName, String employeeId, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.employeeId = employeeId;
		this.password = password;
	}

	public bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
