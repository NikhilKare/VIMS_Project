package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class InsuranceProvider {
	@Id
	private long providerId;
	@OneToOne
	@JoinColumn(name = "user_Id")
	@MapsId
	private User userId;
	private String companyName;
}
