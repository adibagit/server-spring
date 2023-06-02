package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT user FROM User user WHERE user.usertype = 'employee' AND user.userid NOT IN (SELECT employee.user.userid FROM Employee employee)")
    List<User> getEmployeeRequest();

    @Query("SELECT CASE WHEN COUNT(employee) > 0 THEN true ELSE false END FROM Employee employee WHERE employee.user.userid = :userId")
    boolean isEmployeeActive(@Param("userId") int userId);

}
