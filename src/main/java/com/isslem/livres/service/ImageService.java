package com.isslem.livres.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.isslem.livres.entities.Image;

@Service
public interface ImageService {
	 Image uplaodImage(MultipartFile file) throws IOException;
	 Image getImageDetails(Long id) throws IOException;
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 void deleteImage(Long id) ;
	 
	 Image uploadImageLiv(MultipartFile file,Long idLiv) throws IOException;
	 List<Image> getImagesParLiv(Long livId);

}
