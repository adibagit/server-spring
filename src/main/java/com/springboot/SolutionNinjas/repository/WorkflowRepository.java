package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.dto.AdminWorkflowsDTO;
import com.springboot.SolutionNinjas.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Workflow;
import java.util.List;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow, Integer> {
    @Query("SELECT new com.springboot.SolutionNinjas.dto.AdminWorkflowsDTO(workflowid, department.deptname, status.status, workflow.description, workflow.priority,workflow.date) "
            + "FROM Workflow workflow "
            + "INNER JOIN workflow.department department "
            + "INNER JOIN workflow.status status "
            + "WHERE ticket = :ticketid ")
    List<AdminWorkflowsDTO> workflowsReport(@Param("ticketid") Ticket ticketid);
}
