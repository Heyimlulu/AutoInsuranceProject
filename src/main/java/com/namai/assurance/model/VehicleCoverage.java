/*
package com.namai.assurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vehicle_coverage")
public class VehicleCoverage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private boolean active;

	@Column
	private Date createdDate;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "coverage_id")
	private Coverage coverage;

	public Vehicle getVehicle() { return vehicle; }
	public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

	public Coverage getCoverage() { return coverage; }
	public void setCoverage(Coverage coverage) { this.coverage = coverage; }

	public VehicleCoverage() {}

	public VehicleCoverage(long id, boolean active, Date createdDate, Vehicle vehicle, Coverage coverage) {
		super();
		this.id = id;
		this.active = active;
		this.createdDate = createdDate;
		//this.vehicle = vehicle;
		//this.coverage = coverage;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Vehicle Coverage [id=" + id + ", active=" + active + ", createdDate=" + createdDate + "]";
	}
}

 */
