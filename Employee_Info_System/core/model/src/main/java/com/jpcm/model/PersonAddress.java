package com.jpcm.model;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Embeddable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="ADDRESS", include="all")
public class PersonAddress {
	
	@Column(name = "addStreet")
	private String addStreet;
	
	@Column(name = "addBarangay")
	private String addBarangay;
	
	@Column(name = "addCityMunicipality")
	private String addCityMunicipality;	
	
	@Column(name = "addZipCode")
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
