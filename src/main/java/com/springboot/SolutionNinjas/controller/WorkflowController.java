package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.dto.DepartmentWorkflowResponse;
import com.springboot.SolutionNinjas.dto.TicketDto;
import com.springboot.SolutionNinjas.dto.WorkflowDto;
import com.springboot.SolutionNinjas.model.Ticket;
import com.springboot.SolutionNinjas.model.Workflow;
import com.springboot.SolutionNinjas.service.WorkflowService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @GetMapping("/workflow")
    public ResponseEntity<List<Workflow>> getWorkflows() {
        return new ResponseEntity<List<Workflow>>(workflowService.getWorkflows(), HttpStatus.OK);
    }

    @GetMapping("/workflow/{id}")
    public ResponseEntity<Workflow> getWorkflow(@PathVariable int id) {
        return new ResponseEntity<Workflow>(workflowService.getOneWorkflow(id),HttpStatus.OK);
    }

    @DeleteMapping("/workflow")
    public String deleteWorkflow(@RequestParam int id) {
        workflowService.deleteWorkflow(id);
        return "Workflow having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/workflow")
    public ResponseEntity<Workflow> insertWorkflow(@Valid @RequestBody Workflow workflow) {
        return new ResponseEntity<Workflow>(workflowService.insertWorkflow(workflow),HttpStatus.CREATED);
    }

    @PutMapping("/workflow/{id}")
    public ResponseEntity<Workflow> updateWorkflow(@PathVariable int id,@RequestBody Workflow workflow ) {
        workflow.setWorkflowid(id);
        return new ResponseEntity<Workflow>(workflowService.updateWorkflow(workflow),HttpStatus.OK);
    }

    @GetMapping("/workflowByTicket/{id}")
    public ResponseEntity<List<Workflow>> getWorkflowByTicket(@PathVariable Ticket id) {
        return new ResponseEntity<List<Workflow>>(workflowService.getWorkflowsByTicket(id),HttpStatus.OK);
    }

}
