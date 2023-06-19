package com.mryndina.exhibitions.service;

import com.mryndina.exhibitions.entity.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {
    public Image create(Image image);
    public List<Image> viewAll();
    public Image viewById(long id);
}
