package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.EmployeeDao;
import com.bean.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
public String storeEmpRecord(Employee emp) {
	if(employeeDao.storeEmpRecord(emp)) {return "Stored Successfully";}
	else {return "Not Stored";}
	}

public String updateEmpRecord(Employee emp) {
	if(employeeDao.updateEmpRecord(emp)>0) {return "Updated Successfully";}
	else {return "Not Updated";}
	}
public String deleteEmpRecord(int id) {
	if(employeeDao.deleteEmpRecord(id)>0) {return "Deleted Successfully";}
	else {return "Not Deleted";}
}
public Employee findEmpRecord(int id) {
	return employeeDao.findEmpRecord(id);
	//return 0;
}
}