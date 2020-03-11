package com.mitrais.todo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "mg_teacher", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private int teacherId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name", nullable = true)
	private String lastName;
	
	@Column(name="username", nullable = true)
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password", nullable = true)
	private String password;
	
	@Column(name="address", nullable = true)
	private String address;
	
	@Column(name="place_of_birth", nullable = true)
	private String placeOfBirth;
	
	@Column(name="date_of_birth", nullable = true)
	private Date dateOfBirth;
	
	@Column(name="gender", nullable = true)
	private String gender;
	
	@Column(name="religion", nullable = true)
	private String religion;
	
	@Column(name="phone_number_1")
	private int phoneNumber1;
	
	@Column(name="phone_number_2")
	private int phoneNumber2;
	
	@Column(name="occupation", nullable = true)
	private String occupation;
	
	@Column(name="experience", nullable = true)
	private String experience;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="last_upd_date", nullable = true)
	private Date lastUpdDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="university_id", nullable = true)
	private String universityId;
	
	@Column(name="major_id", nullable = true)
	private String majorId;
	
	@Column(name="profile_picture_url")
	private String profilePictureUrl;
	
	@Column(name ="rekening_no")
	private int rekeningNo;
	
	@Column(name="bank_name")
	private String bankName;
	
	public Teacher(String firstName, String lastName,String email,String profilePictureUrl) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.profilePictureUrl = profilePictureUrl;
		this.createDate = new Date();
	}
	
	
// Create From SignUp Form
	public Teacher(String firstName, String username, String email, String password, String gender) {
		this.firstName = firstName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.createDate = new Date();
		this.status = "ACTIVE";
	}



	public Teacher() {
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public int getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(int phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public int getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(int phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdDate() {
		return lastUpdDate;
	}

	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUniversityId() {
		return universityId;
	}

	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}
	public int getRekeningNo() {
		return rekeningNo;
	}
	public void setRekeningNo(int rekeningNo) {
		this.rekeningNo = rekeningNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
