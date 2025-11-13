package com.CropProject.CROPCARE.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CropProject.CROPCARE.entity.CropEntity;
import com.CropProject.CROPCARE.repository.CropRepository;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public List<CropEntity> getAllCrops() {
        return cropRepository.findAll();
    }

    public CropEntity addCrop(CropEntity crop) {
        return cropRepository.save(crop);
    }
}
