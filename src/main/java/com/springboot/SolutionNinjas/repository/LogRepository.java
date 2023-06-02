package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.dto.LogsDto;
import com.springboot.SolutionNinjas.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Log;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
    @Query("SELECT new com.springboot.SolutionNinjas.dto.LogsDto (l) FROM Log l where l.workflow.workflowid=:t")
    List<LogsDto> getLogsByWorkflow(@Param("t") int workflowId);

    @Query("SELECT new com.springboot.SolutionNinjas.dto.LogsDto (l) FROM Log l where l.employee.department.deptid=:departmentId")
    List<LogsDto> getLogsByDepartment(@Param("departmentId") int departmentId);

    @Query("SELECT l FROM Log l where l.employee.empid=:empId and l.status.statusid=:statusId")
    List<Log> getLogsByEmp(@Param("empId") int empId,@Param("statusId") int statusId);
}
