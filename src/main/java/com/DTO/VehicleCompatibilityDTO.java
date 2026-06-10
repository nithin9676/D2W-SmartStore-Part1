package com.DTO;

public class VehicleCompatibilityDTO {

    private Integer year;

    private String make;

    private String model;

    private String engine;

    private String fuelType;

    private String engineType;

    public VehicleCompatibilityDTO() {
    }

    public VehicleCompatibilityDTO(
            Integer year,
            String make,
            String model,
            String engine,
            String fuelType,
            String engineType) {

        this.year = year;
        this.make = make;
        this.model = model;
        this.engine = engine;
        this.fuelType = fuelType;
        this.engineType = engineType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}