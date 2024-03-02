package com.jsp.Agro.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Agro.entity.Image;
import com.jsp.Agro.repo.ImageRepo;

@Repository
public class ImageDao {

	@Autowired
	ImageRepo repo;

	// ****************************** save*****************
	public Image saveImage(Image image) {
		return repo.save(image);
	}

	// ***********************Update*****************************
	public Image updateImage(Image image) {
		return repo.save(image);
	}

	// **********************DeleteBy id*************************
	public Image deleteById(int id) {
		Optional<Image> db = repo.findById(id);
		if (db.isEmpty()) {
			return null;
		} else
			return db.get();
	}

	// *********************Fetching by id****************************
	public Image fetchImageByid(int id) {
		Optional<Image> db = repo.findById(id);
		if (db.isPresent()) {
			return db.get();
		} else {
			return null;
		}
	}

	// ********************FetchingAll***************************
	public List<Image> fetchAll() {
		return repo.findAll();
	}

}
