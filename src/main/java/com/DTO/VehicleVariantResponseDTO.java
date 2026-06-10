package com.DTO;


public class VehicleVariantResponseDTO {

    private Long id;

    private String fullName;

    private String fuelType;

    private String transmission;

    private String engineCode;

	public VehicleVariantResponseDTO(Long id, String fullName, String fuelType, String transmission,
			String engineCode) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.fuelType = fuelType;
		this.transmission = transmission;
		this.engineCode = engineCode;
	}

	public VehicleVariantResponseDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getEngineCode() {
		return engineCode;
	}

	public void setEngineCode(String engineCode) {
		this.engineCode = engineCode;
	}
    

}