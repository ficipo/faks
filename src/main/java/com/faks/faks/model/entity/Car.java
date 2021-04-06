package com.faks.faks.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "model_name")
	private String name;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "manufacture_date")
	@Temporal(TemporalType.DATE)
	private Date manufactureDate;

	@ManyToOne
	@JoinColumn(name = "maker_id")
	private Maker maker;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@ManyToOne
	@JoinColumn(name = "motor_id")
	private Motor motor;

}
