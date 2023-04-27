package com.springboot.SolutionNinjas.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.Date;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AdminWorkflowsDTO {
    private int workflowId;
    private String department;
    private String status;
    private String description;
    private int priority;
    private Date date;

    public AdminWorkflowsDTO(int workflowId,String department,String status,String description,int priority,Date date){
        this.workflowId = workflowId;
        this.department = department;
        this.status = status;
        this.description = description;
        this.priority = priority;
        this.date = date;
    }

    @Override
    public String toString() {
        return "AdminWorkflowsDTO [workflowId=" + workflowId + ", department=" + department + ", status=" + status + ", description="
                + description +", priority=" + priority+", date=" + date+ "]";
    }

}
