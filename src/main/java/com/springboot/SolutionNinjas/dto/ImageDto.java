package com.springboot.SolutionNinjas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImageDto {
    public int imageid;
    public String imagename;
    public String imagepath;
    public int ticketId;
    public int userid;
}
