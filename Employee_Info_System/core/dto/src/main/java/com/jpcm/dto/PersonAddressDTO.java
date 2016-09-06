package com.jpcm.dto;

public class PersonAddressDTO {
	private String addStreet;
	private String addBarangay;
	private String addCityMunicipality;
	private int addZipCode;
	
	public String getAddStreet() {
		return addStreet;
	}
	
	public String getAddBarangay() {
		return addBarangay;
	}
	
	public String getAddCityMunicipality() {
		return addCityMunicipality;
	}
	
	public int getAddZipCode() {
		return addZipCode;
	}
	

	public void setAddStreet(String addStreet) {
		this.addStreet = addStreet;
	}
	
	public void setAddBarangay(String addBarangay) {
		this.addBarangay = addBarangay;
	}
	
	public void setAddCityMunicipality(String addCityMunicipality) {
		this.addCityMunicipality = addCityMunicipality;
	}
	
	public void setAddZipCode(int addZipCode) {
		this.addZipCode = addZipCode;
	}
}
