package com.springboot.SolutionNinjas.dto;

import com.springboot.SolutionNinjas.model.Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogsDto {
    public Log log;
}
