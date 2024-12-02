package com.isslem.livres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isslem.livres.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long>{

}
