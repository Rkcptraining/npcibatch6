package com.banking1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking1.entity.Employee;

@Repository
public interface BankingDAOInterface extends JpaRepository<Employee, String>{
	
	@Query("from com.banking1.entity.Employee e where e.email=:em and e.password=:pw")
	public Employee loginDAO(@Param("em") String email, @Param("pw") String password);

}
