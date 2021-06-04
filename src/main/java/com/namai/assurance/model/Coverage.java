package com.namai.assurance.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "coverage")
public class Coverage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String coverageName;

	@Column
	private String coverageGroup;

	@Column
	private long code;

	@Column
	private boolean isPolicyCoverage;

	@Column
	private boolean isVehicleCoverage;

	@Column
	private String description;

	@JsonManagedReference(value = "pcoverage")
	@OneToMany(mappedBy = "coverage", cascade = { CascadeType.ALL })
	private List<PolicyCoverage> policyCoverage;

	/*
	@JsonManagedReference(value = "vehiclecoverage")
	@OneToMany(mappedBy = "coverage", cascade = { CascadeType.ALL })
	private List<VehicleCoverage> vehicleCoverage;
	 */

	public Coverage() {}

	public Coverage(long id, String coverageName, String coverageGroup, long code, boolean isPolicyCoverage, boolean isVehicleCoverage, String description) {
		super();
		this.id = id;
		this.coverageName = coverageName;
		this.coverageGroup = coverageGroup;
		this.code = code;
		this.isPolicyCoverage = isPolicyCoverage;
		this.isVehicleCoverage = isVehicleCoverage;
		this.description = description;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getCoverageName() {
		return coverageName;
	}
	public void setCoverageName(String coverageName) {
		this.coverageName = coverageName;
	}

	public String getCoverageGroup() {
		return coverageGroup;
	}
	public void setCoverageGroup(String coverageGroup) {
		this.coverageGroup = coverageGroup;
	}

	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}

	public boolean getIsPolicyCoverage() {
		return isPolicyCoverage;
	}
	public void setIsPolicyCoverage(boolean isPolicyCoverage) {
		this.isPolicyCoverage = isPolicyCoverage;
	}

	public boolean getIsVehicleCoverage() {
		return isVehicleCoverage;
	}
	public void setIsVehicleCoverage(boolean isVehicleCoverage) {
		this.isVehicleCoverage = isVehicleCoverage;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Coverage [id=" + id + ", coverageName=" + coverageName + ", coverageGroup=" + coverageGroup
				+ ", code=" + code + ", isPolicyCoverage=" + isPolicyCoverage + ", isVehicleCoverage=" + isVehicleCoverage
				+ ", description=" + description + "]";
	}
}
