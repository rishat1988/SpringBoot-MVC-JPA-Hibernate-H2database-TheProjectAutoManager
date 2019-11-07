package com.models;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {
	private int id;
	private String fullName;
	private String numberOfTelefon;
	private String numberOfDrivingLicense;
	private String age;
	private List<Auto> autos;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "full_name", nullable = false, length = 100)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Basic
	@Column(name = "number_of_telefon", nullable = false, length = 100)
	public String getNumberOfTelefon() {
		return numberOfTelefon;
	}

	public void setNumberOfTelefon(String numberOfTelefon) {
		this.numberOfTelefon = numberOfTelefon;
	}

	@Basic
	@Column(name = "number_of_driving_license", nullable = false, length = 100)
	public String getNumberOfDrivingLicense() {
		return numberOfDrivingLicense;
	}

	public void setNumberOfDrivingLicense(String numberOfDrivingLicense) {
		this.numberOfDrivingLicense = numberOfDrivingLicense;
	}

	@Basic
	@Column(name = "age", nullable = false, length = 100)
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	

	@ManyToMany(        
	        //cascade = CascadeType.MERGE,
			fetch = FetchType.EAGER
	    )
	@JoinTable(name = "driver_autos",
			joinColumns = { @JoinColumn(name = "autos_id") },
			inverseJoinColumns = { @JoinColumn(name = "driver_id") })
	public List<Auto> getAutos() {
		return this.autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}

	@Override
	public String toString() {
		return "Auto{" + "id=" + id + ", fullName=" + fullName + ", numberOfTelefon=" + numberOfTelefon
				+ ", numberOfDrivingLicense='" + numberOfDrivingLicense + ", age='" + age + '}';
	}
}
