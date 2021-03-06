package com.jpcm.model;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "PERSON")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="PERSON", include="all")
public class Person implements Comparable<Person>{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_gen")
  @SequenceGenerator(name = "person_seq_gen", sequenceName = "person_id_seq")
  @Column(name = "id")
	private Long id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "middleName")
	private String middleName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "suffixName")
	private String suffixName;
	
	@Column(name = "titleName")
	private String titleName;
	
	@Embedded
	private PersonAddress address;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	private Set<PersonContact> contacts;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "dateHired")
	private Date dateHired;
	
	@Column(name = "currentlyEmployed")
	private boolean currentlyEmployed;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@org.hibernate.annotations.Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinTable(name = "person_role", joinColumns = {
		@JoinColumn(name = "persons_id", nullable = false, updatable = false)},
		inverseJoinColumns = { @JoinColumn(name = "roles_roleid", nullable = false, updatable = false)}
	)
	//@JoinColumn(name="persons")
	private Set<Role> roles;


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
	
	public PersonAddress getAddress() {
		return address;
	}
	
	public Set<PersonContact> getContacts() {
		return contacts;
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
	
	public Set<Role> getRoles() {
		return roles;
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
	
	public void setAddress(PersonAddress address) {
		this.address = address;
	}
	
	public void setContacts(Set<PersonContact> contacts) {
		this.contacts = contacts;
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
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@Override
    public int compareTo(Person person) {
        return this.getGrade().compareTo(person.getGrade());
    }	
}