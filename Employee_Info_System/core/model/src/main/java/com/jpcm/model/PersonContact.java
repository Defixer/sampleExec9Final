package com.jpcm.model;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "CONTACT")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="CONTACT", include="all")
public class PersonContact {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq_gen")
  @SequenceGenerator(name = "contact_seq_gen", sequenceName = "contact_id_seq")
  @Column(name = "contactId")
	private Long contactId;
	
	@Column(name = "mobileNumber")
	private Long mobileNumber;
	
	@Column(name = "landLineNumber")
	private Long landLineNumber;
	
	@Column(name = "emailAddress")
	private String emailAddress;
    
  @ManyToOne(cascade = {CascadeType.PERSIST})
  @org.hibernate.annotations.Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
  @JoinColumn(name="personId")
  private Person person;
    
    
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
}
