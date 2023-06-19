package com.mryndina.exhibitions.repository;

import com.mryndina.exhibitions.entity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

}
