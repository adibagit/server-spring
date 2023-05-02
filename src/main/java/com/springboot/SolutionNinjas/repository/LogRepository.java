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
    @Query("SELECT new com.springboot.SolutionNinjas.dto.LogsDto (l) FROM Log l where l.ticket.ticketid=:t")
    List<LogsDto> getLogsByTicket(@Param("t") int ticketId);

    @Query("SELECT new com.springboot.SolutionNinjas.dto.LogsDto (l) FROM Log l where l.employee.department.deptid=:departmentId")
    List<LogsDto> getLogsByDepartment(@Param("departmentId") int departmentId);

}
