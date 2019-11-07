package com.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {
	@Id
	private int id;
	private String number;
	private String distance;
	private String district;	
	private Auto auto;

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
	@Column(name = "number", nullable = false, length = 100)
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Basic
	@Column(name = "distance", nullable = false, length = 100)
	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	@Basic
	@Column(name = "district", nullable = false, length = 100)
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auto", referencedColumnName = "id", nullable = false, unique = true)
	public Auto getAuto() {
		return auto;
	}
	
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	@Override
    public String toString() {
        return "route[" +
                "id=" + id +
                ", number=" + number +
                ", distance=" + distance +
                ", district='" + district+ ']';
    }
	
}
