package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import com.springboot.SolutionNinjas.dto.ImageDto;
import com.springboot.SolutionNinjas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.Image;
import com.springboot.SolutionNinjas.repository.ImageRepository;

@Service
public class ImageService{

	@Autowired
	private ImageRepository imagerepo;
	
	public List<Image> getImages() {
		return imagerepo.findAll();
	}

	public Image insertImage(Image image) {
		return imagerepo.save(image);
	}

	public Image getOneImage(int imageId) {
		Optional<Image> optionalImage = Optional.ofNullable(imagerepo.findById(imageId).orElseThrow(() -> new ResourceNotFoundException("Image", "Id", imageId)));
		if(optionalImage.isPresent())
			return optionalImage.get();
		System.out.println("Image not found for id : "+imageId);
		return null;
	}

	public void deleteImage(int imageId) {
		imagerepo.deleteById(imageId);
	}

	public Image updateImage(Image image) {
		return imagerepo.save(image);
	}

	public List<ImageDto> allImagesByTicket(int ticketId) {
		return imagerepo.getImageByTicket(ticketId);
	}

}
