package com.springboot.SolutionNinjas.dto;

import lombok.Data;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AdminTicketsDTO{
    private int ticketId;
    private String emailId;
    private String ticketDescription;
    private String propertyName;
    private String status;
    private int priority;
    private Date raisedDate;

    public AdminTicketsDTO(int ticketId,String emailId,String ticketDescription,String propertyName, String status,int priority,Date raisedDate ) {
        this.ticketId = ticketId;
        this.emailId = emailId;
        this.ticketDescription = ticketDescription;
        this.propertyName = propertyName;
        this.status = status;
        this.priority = priority;
        this.raisedDate = raisedDate;
    }

    @Override
    public String toString() {
        return "AdminTicketsDTO [ticketId=" + ticketId + ", emailId=" + emailId + ", ticketDescription=" + ticketDescription + ", propertyName="
                + propertyName +", status=" + status+", priority=" + priority+", raisedDate=" + raisedDate+ "]";
    }
}
