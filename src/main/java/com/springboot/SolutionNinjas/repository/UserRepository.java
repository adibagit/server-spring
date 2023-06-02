package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.dto.AdminTicketsDTO;
import com.springboot.SolutionNinjas.dto.TicketDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT new com.springboot.SolutionNinjas.dto.AdminTicketsDTO(ticket.ticketid, user.emailid, ticket.description, property.propertyname, status.status, ticket.priority, ticket.ticketdate) "
            + "FROM Ticket ticket "
            + "INNER JOIN ticket.property property "
            + "INNER JOIN ticket.status status "
            + "INNER JOIN ticket.client user ")
    List<AdminTicketsDTO> ticketsReport();

    @Query("SELECT u.usertype FROM User u WHERE u.emailid = :email")
    public String getUserRole(@Param("email") String emailId);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.emailid = :email")
    public Boolean userExist(@Param("email") String emailId);

    @Query("SELECT new com.springboot.SolutionNinjas.dto.TicketDto (ticket.ticketid) FROM Workflow w where w.department.deptid=:d")
    public List<TicketDto> getTicketsByDepartment(@Param("d") int deptId);

    List<User> findAllByEmailid(String emailid);

    List<User> findAllByUsertype(String userRole);

}
