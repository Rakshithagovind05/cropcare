package com.CropProject.CROPCARE.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crops")
public class CropEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;
    private String diseaseName;
    private String solution;
    private String marketTrend;

    public CropEntity() {}

    public CropEntity(String cropName, String diseaseName, String solution, String marketTrend) {
        this.cropName = cropName;
        this.diseaseName = diseaseName;
        this.solution = solution;
        this.marketTrend = marketTrend;
    }

    public Long getId() {
        return id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getMarketTrend() {
        return marketTrend;
    }

    public void setMarketTrend(String marketTrend) {
        this.marketTrend = marketTrend;
    }
}
