package com.searchcar.selenium;

public class vehicleDetails {

	private String vehicleReg = null;
	private String vehicleMake = null;
	private String vehicleModel = null;
	public String getVehicleReg() {
		//System.out.println("vehicleReg:" +vehicleReg);
		return vehicleReg;
		
	}
	public void setVehicleReg(String vehicleReg) {
		this.vehicleReg = vehicleReg;
	}
	public String getVehicleMake() {
		//System.out.println("VehicleMake:" +vehicleMake);
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleModel() {
		//System.out.println("VehicleModel:" +vehicleModel);
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

}
