package com.jpcm.dto;

public class PersonContactDTO {
	private Long contactId;
	private Long mobileNumber;
	private Long landLineNumber;
	private String emailAddress;
  private PersonDTO personDTO;
    
    
	public Long getContactId() {
		return contactId;
	}
	
	public Long getMobileNumber() {
		return mobileNumber;
	}
	
	public Long getLandLineNumber() {
		return landLineNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setContactId (Long contactId) {
		this.contactId = contactId;
	}
	
	public void setMobileNumber (Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public void setLandLineNumber (Long landLineNumber) {
		this.landLineNumber = landLineNumber;
	}
	
	public void setEmailAddress (String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public PersonDTO getPersonDTO () {
		return this.personDTO;
	}

	public void setPersonDTO(PersonDTO personDTO){
		this.personDTO = personDTO;
	}
}
