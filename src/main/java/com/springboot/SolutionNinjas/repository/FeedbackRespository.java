package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.dto.FeedbackDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Feedback;

import java.util.List;

@Repository
public interface FeedbackRespository extends JpaRepository<Feedback, Integer> {
    @Query("SELECT new com.springboot.SolutionNinjas.dto.FeedbackDto (f.feedbackid,f.user.userid,f.ticket.ticketid,f.feedbackdesc,f.feedbackdate,f.lastmodified) FROM Feedback f where f.ticket.ticketid=:ticketId")
    public List<FeedbackDto> getFeedbacksByTicket(@Param("ticketId") int ticketId);
}
