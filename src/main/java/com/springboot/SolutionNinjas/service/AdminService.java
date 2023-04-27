package com.springboot.SolutionNinjas.service;

import com.springboot.SolutionNinjas.dto.AdminTicketsDTO;
import com.springboot.SolutionNinjas.dto.AdminWorkflowsDTO;
import com.springboot.SolutionNinjas.model.Ticket;
import com.springboot.SolutionNinjas.repository.TicketRepository;
import com.springboot.SolutionNinjas.repository.WorkflowRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Resource
    private TicketRepository ticketRepository;

    public List<AdminTicketsDTO> getTicketsReport() {
        List<AdminTicketsDTO> list = ticketRepository.ticketsReport();
        list.forEach(l -> System.out.println(l));
        return list;
    }

    @Resource
    private WorkflowRepository workflowRepository;
    public List<AdminWorkflowsDTO> getWorkflowsReport(Ticket ticketid) {
        List<AdminWorkflowsDTO> list = workflowRepository.workflowsReport(ticketid);
        list.forEach(l -> System.out.println(l));
        return list;
    }


}
