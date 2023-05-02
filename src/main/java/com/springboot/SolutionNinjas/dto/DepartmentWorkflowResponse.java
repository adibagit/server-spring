package com.springboot.SolutionNinjas.dto;

import com.springboot.SolutionNinjas.model.Workflow;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentWorkflowResponse {
  public Workflow workflows;
}
