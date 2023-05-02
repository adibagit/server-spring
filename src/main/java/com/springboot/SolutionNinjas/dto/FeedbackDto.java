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
public class FeedbackDto {
    public int feedbackid;
    public int userid;
    public int ticketid;
    public String feedbackdesc;
    public Date feedbackdate;
    public Date lastmodified;
}
