package com.springboot.SolutionNinjas.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkflowDto {
    public int workflowid;
    public int deptid;
    public int statusid;
    public String description;
    public int priority;
    public Date date;
}
