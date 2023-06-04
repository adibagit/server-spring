package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.dto.DepartmentWorkflowResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Department;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {


    @Query("SELECT new com.springboot.SolutionNinjas.dto.DepartmentWorkflowResponse (w) FROM Workflow w where w.workflowid=:t")
    public List<DepartmentWorkflowResponse> getWorkflowDetails(@Param("t") int ticketId);
    @Query("SELECT e.department.deptid FROM Employee e where user.userid=:userId")
    public int getDepart(@Param("userId") int userId);

    @Query("SELECT d FROM Department d where d.deptid NOT IN (SELECT m.department.deptid FROM Manager m)")
    public List<Department> getDepartmentWithoutManager();

}
