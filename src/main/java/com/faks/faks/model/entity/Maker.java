package com.faks.faks.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Maker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "country")
	private String country;

	@OneToMany(mappedBy = "maker")
	private List<Car> cars;

}
