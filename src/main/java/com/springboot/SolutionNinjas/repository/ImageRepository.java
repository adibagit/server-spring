package com.springboot.SolutionNinjas.repository;

import com.springboot.SolutionNinjas.dto.ImageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.SolutionNinjas.model.Image;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    Optional<Image> findById(Integer id);

    @Query("SELECT new com.springboot.SolutionNinjas.dto.ImageDto (i.imageid,i.imagename,i.imagepath,ticket.ticketid,ticket.client.userid) FROM Image i where i.ticket.ticketid=:t")
    public List<ImageDto> getImageByTicket(@Param("t") int ticketId);
}
