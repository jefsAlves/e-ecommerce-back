package com.alvesjefs.mscomputers.dto;

import java.io.Serializable;

import com.alvesjefs.mscomputers.domain.Computers;

public class ComputersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private String model;
	private Integer serieNumber;
	private Double price;

	public ComputersDTO() {
	}

	public ComputersDTO(Long id, String name, String description, String model, Integer serieNumber, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.model = model;
		this.serieNumber = serieNumber;
		this.price = price;
	}

	public ComputersDTO(Computers computers) {
		id = computers.getId();
		name = computers.getName();
		description = computers.getDescription();
		model = computers.getModel();
		serieNumber = computers.getSerieNumber();
		price = computers.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getSerieNumber() {
		return serieNumber;
	}

	public void setSerieNumber(Integer serieNumber) {
		this.serieNumber = serieNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
