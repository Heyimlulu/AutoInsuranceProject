package com.insurance.assurance.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, columnDefinition = "char(4)")
	private long year;
	
	@Column(nullable = false, columnDefinition = "varchar(50)")
	private String make; // = Vehicle's Brand
	
	@Column(nullable = false, columnDefinition = "varchar(50)")
	private String model;
	
	@Column(columnDefinition = "varchar(50)")
	private String color;
	
	@Column(columnDefinition = "varchar(50)")
	private String trim;
	
	@Column(nullable = false)
	private int mileAge;
	
	@Column(nullable = false, columnDefinition = "varchar(20)")
	private long vinNumber;
	
	@Column(nullable = false, columnDefinition = "varchar(20)")
	private long vehicleNumberPlate;
	
	@Column(nullable = false, columnDefinition = "varchar(50)")
	private String vehicleRegisteredState;
	
	@Column(nullable = false)
	private Date createdDate;
	
	@Column(nullable = false)
	private boolean active;

	// Relations

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "vehicle_coverage",
			joinColumns = {
					@JoinColumn(name = "vehicle_id", referencedColumnName = "id", nullable = false, updatable = false
					)},
			inverseJoinColumns = {
					@JoinColumn(name = "coverage_id", referencedColumnName = "id", nullable = false, updatable = false
					)})
	private List<Coverage> coverage= new ArrayList<>();

	@JsonBackReference(value = "vehicle")
	@ManyToOne
	@JoinColumn(name = "policy_id", nullable = false)
	private Policy policy;
	
	public Policy getPolicy() { return policy; }
	public void setPolicy(Policy policy) { this.policy = policy; }

	// Constructors

	public Vehicle() {}

	public Vehicle(long id, long year, String make, String model, String color, String trim, int mileAge,
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

	// Getters and Setters

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
	
	public int getMileAge() { return mileAge; }
	public void setMileAge(int mileAge) { this.mileAge = mileAge; }
	
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
		return "Vehicle " +
				"[id=" + id +
				", Year=" + year +
				", Make=" + make +
				", Model=" + model +
				", Color=" + model +
				", Trim=" + trim +
				", Mile Age=" + mileAge +
				", VINNumber=" + vinNumber +
				", Vehicle Number Plate=" + vehicleNumberPlate +
				", Vehicle Registered State" + vehicleRegisteredState +
				", Created Date=" + createdDate +
				", Active=" + active +
				"]";
	}
}
