package com.faks.faks.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Motor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "power")
	private int power;
	
	@Column(name = "torque")
	private int torque;

	@OneToMany(mappedBy = "motor")
	private List<Car> cars;

//	@Enumerated(EnumType.STRING)
//	private Type type;
//
	
}
