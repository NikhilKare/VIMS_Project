package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VehicleDetails {
	@Id
	private String chasisNo;
	private String vehicleType;//type=SUV,Haycback,Sedan...
	private LocalDate registrationDate;
	private String vehicleNumber;//MH-15-....
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;
}
