package com.namai.assurance.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private long year;
	
	@Column
	private String make; // = Vehicle's Brand
	
	@Column
	private String model;
	
	@Column
	private String color;
	
	@Column
	private String trim;
	
	@Column
	private double mileAge;
	
	@Column
	private long vinNumber;
	
	@Column
	private long vehicleNumberPlate;
	
	@Column
	private String vehicleRegisteredState;
	
	@Column
	private Date createdDate;
	
	@Column
	private boolean active;

	@JsonBackReference(value = "vehicle")
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;

	/*
	@JsonManagedReference
	@OneToMany(mappedBy = "vehicle", cascade = { CascadeType.ALL })
	private List<VehicleCoverage> vehicleCoverage;

	 */
	
	public Policy getPolicy() { return policy; }
	public void setPolicy(Policy policy) { this.policy = policy; }

	/*
	// VehicleCoverage Model - GET/SET
	public List<VehicleCoverage> getVehicleCoverage() { return vehicleCoverage; }
	public void setVehicleCoverage(List<VehicleCoverage> vehicleCoverage) { this.vehicleCoverage = vehicleCoverage; }

	 */
	
	public Vehicle() {}

	public Vehicle(long id, long year, String make, String model, String color, String trim, double mileAge, 
			long vinNumber, long vehicleNumberPlate, String vehicleRegisteredState, Date createdDate, boolean active, Policy policy) {
		super();
		this.id = id;
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
		this.trim = trim;
		this.mileAge = mileAge;
		this.vinNumber = vinNumber;
		this.vehicleNumberPlate = vehicleNumberPlate;
		this.vehicleRegisteredState = vehicleRegisteredState;
		this.createdDate = createdDate;
		this.active = active;
		
		this.policy = policy;
	}

	public long getId() { return this.id; }
	public void setId(long id) { this.id = id; }

	public long getYear() { return year; }
	public void setYear(long year) { this.year = year; }
	
	public String getMake() { return make; }
	public void setMake(String make) { this.make = make; }
	
	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; }
	
	public String getColor() { return color; }
	public void setColor(String color) { this.color = color; }
	
	public String getTrim() { return trim; }
	public void setTrim(String trim) { this.trim = trim; }
	
	public double getMileAge() { return mileAge; }
	public void setMileAge(double mileAge) { this.mileAge = mileAge; }
	
	public long getVinNumber() { return vinNumber; }
	public void setVinNumber(long vinNumber) { this.vinNumber = vinNumber; }
	
	public long getVehicleNumberPlate() { return vehicleNumberPlate; }
	public void setVehicleNumberPlate(long vehicleNumberPlate) { this.vehicleNumberPlate = vehicleNumberPlate; }
	
	public String getVehicleRegisteredState() { return vehicleRegisteredState; }
	public void setVehicleRegisteredState(String vehicleRegisteredState) { this.vehicleRegisteredState = vehicleRegisteredState; }
	
	public Date getCreatedDate() { return createdDate; }
	public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }
	
	public boolean getActive() { return active; }
	public void setActive(boolean active) { this.active = active; }


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", Year=" + year	+ ", Make=" + make + ", Model=" + model + ", Color=" + model + ", Trim=" + trim +
				", Mile Age=" + mileAge + ", VINNumber=" + vinNumber + ", Vehicle Number Plate=" + vehicleNumberPlate + 
				", Vehicle Registered State" + vehicleRegisteredState + ", Created Date=" + createdDate + ", Active=" + active + "]";
	}
}
