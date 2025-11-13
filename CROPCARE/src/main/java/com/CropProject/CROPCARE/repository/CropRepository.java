package com.CropProject.CROPCARE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CropProject.CROPCARE.entity.CropEntity;

@Repository
public interface CropRepository extends JpaRepository<CropEntity, Long> { }
