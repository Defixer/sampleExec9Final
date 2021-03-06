package com.jpcm.dto;
import java.util.Set;
import java.util.Date;

public class PersonDTO implements Comparable<PersonDTO>{
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffixName;
	private String titleName;
	private PersonAddressDTO addressDTO;
	private Set<PersonContactDTO> contactDTOs;
	private Date birthday;
	private String grade;
	private Date dateHired;
	private boolean currentlyEmployed;
	private Set<RoleDTO> roleDTOs;

	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getSuffixName() {
		return suffixName;
	}
	
	public String getTitleName() {
		return titleName;
	}
	
	public PersonAddressDTO getAddressDTO() {
		return addressDTO;
	}
	
	public Set<PersonContactDTO> getContactDTOs() {
		return contactDTOs;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public Date getDateHired() {
		return dateHired;
	}
	
	public boolean getCurrentlyEmployed() {
		return currentlyEmployed;
	}
	
	public Set<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}
	
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public void setAddressDTO(PersonAddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}
	
	public void setContactDTOs(Set<PersonContactDTO> contactDTOs) {
		this.contactDTOs = contactDTOs;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}
	
	public void setCurrentlyEmployed(boolean currentlyEmployed) {
		this.currentlyEmployed = currentlyEmployed;
	}
	
	public void setRoleDTOs(Set<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}
	
	@Override
    public int compareTo(PersonDTO person) {
        return this.getGrade().compareTo(person.getGrade());
    }
}
