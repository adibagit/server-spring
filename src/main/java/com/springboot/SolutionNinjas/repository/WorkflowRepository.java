package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.dto.AdminWorkflowsDTO;
import com.springboot.SolutionNinjas.dto.DepartmentWorkflowResponse;
import com.springboot.SolutionNinjas.dto.TicketDto;
import com.springboot.SolutionNinjas.dto.WorkflowDto;
import com.springboot.SolutionNinjas.model.Ticket;
import com.springboot.SolutionNinjas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Workflow;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow, Integer> {
    @Query("SELECT new com.springboot.SolutionNinjas.dto.AdminWorkflowsDTO(workflowid, department.deptname, status.status, workflow.description, workflow.priority,workflow.date) "
            + "FROM Workflow workflow "
            + "INNER JOIN workflow.department department "
            + "INNER JOIN workflow.status status "
            + "WHERE ticket = :ticketid ")
    List<AdminWorkflowsDTO> workflowsReport(@Param("ticketid") Ticket ticketid);

    @Query("SELECT new com.springboot.SolutionNinjas.dto.DepartmentWorkflowResponse (w) FROM Workflow w where w.workflowid=:t")
    public List<DepartmentWorkflowResponse> getWorkflowDetails(@Param("t") int ticketId);

    @Query("SELECT new com.springboot.SolutionNinjas.dto.WorkflowDto (w.workflowid,department.deptid,status.statusid,w.description,w.priority,w.date) FROM Workflow w where w.ticket.ticketid=:t")
    public List<WorkflowDto> getWorkflowsT(@Param("t") int ticketId);

    List<Workflow> findAllByTicket(Ticket ticketid);

    @Query("SELECT CASE WHEN COUNT(w) > 0 THEN true ELSE false END FROM Workflow w WHERE w.ticket = :ticketid")
    public Boolean workflowExist(@Param("ticketid") Ticket ticketId);

    @Query("SELECT w FROM Workflow w where w.status.statusid=:statusId and w.department.deptid=:deptId")
    public List<Workflow> getDeptTickets(@Param("statusId") int statusId,@Param("deptId") int departmentId);


    @Transactional
    @Modifying
    @Query("UPDATE Workflow w set w.status.statusid=:statusId where w.workflowid=:workflowId")
    public void changeWorkflowStatus(@Param("statusId") int statusId,@Param("workflowId")int workflowId);

}
