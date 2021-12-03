package com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bean.Employee;
@Repository
public class EmployeeDao {
@Autowired
EntityManagerFactory emf; //like Session factory
public List<Employee> getAllEmployee(){
	EntityManager manager=emf.createEntityManager();
	Query qry = manager.createQuery("select emp from Employee emp");
	List<Employee> list = qry.getResultList();
	return list;
}

public boolean storeEmpRecord(Employee emp) {
	try {
		EntityManager manager=emf.createEntityManager();//like session
		EntityTransaction tran=manager.getTransaction();//like transaction in hibernate 
		tran.begin();
		manager.persist(emp);
		tran.commit();
		return true;
	}catch (Exception e) {
		// TODO: handle exception
	System.out.println(e);
	return false;
	}
}
public int updateEmpRecord(Employee emp) {
	EntityManager manager=emf.createEntityManager();
	Employee e=manager.find(Employee.class,emp.getId());
	if(e==null) {return 0;}
	else {
		EntityTransaction tran=manager.getTransaction();//like transaction in hibernate 
		tran.begin();
		e.setSalary(emp.getSalary());
		manager.merge(e); //like update in hibernate
		tran.commit();
		return 1;	
		}
}
public int deleteEmpRecord(int id) {
	EntityManager manager=emf.createEntityManager();
	Employee e=manager.find(Employee.class,id);
	if(e==null) {return 0;}
	else {
		EntityTransaction tran=manager.getTransaction(); 
		tran.begin();
		manager.remove(e);
		tran.commit();
		return 1;
		}
}
public Employee findEmpRecord(int id) {
	EntityManager manager=emf.createEntityManager();
	Employee e=manager.find(Employee.class, id);
	return e;
}
}