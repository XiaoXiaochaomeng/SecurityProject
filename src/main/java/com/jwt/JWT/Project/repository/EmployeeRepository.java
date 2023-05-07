package com.jwt.JWT.Project.repository;

import com.jwt.JWT.Project.dto.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Class thuc hien truy van thong tin bang Employee trong database
 * 
 * @author
 * @version 1.00
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("SELECT new EmployeeModel(e.user.Fullname, e.department, e.phone, e.position, e.user.birthday, e.Startday, e.salary) FROM Employee e WHERE e.Deleteday = null")
	List<EmployeeModel> getListEmployee();
	
	@Query("SELECT e FROM Employee e WHERE e.user.id = :uid")
	Employee getEmployeeByUserId(@Param("uid") Integer id);
}
