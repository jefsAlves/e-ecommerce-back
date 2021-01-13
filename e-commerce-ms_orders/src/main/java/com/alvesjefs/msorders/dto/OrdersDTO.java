package com.alvesjefs.msorders.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.alvesjefs.msorders.domain.Orders;
import com.alvesjefs.msorders.domain.enums.OrderStatus;

public class OrdersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String address;
	private Instant moment;
	private OrderStatus orderStatus;

	private Set<ComputersDTO> computers = new HashSet<>();

	public OrdersDTO() {
	}

	public OrdersDTO(Long id, String address, Instant moment, OrderStatus orderStatus) {
		this.id = id;
		this.address = address;
		this.moment = moment;
		this.orderStatus = orderStatus;
	}

	public OrdersDTO(Orders orders) {
		id = orders.getId();
		address = orders.getAddress();
		moment = orders.getMoment();
		orderStatus = orders.getOrderStatus();
		computers = orders.getComputers().stream().map(x -> new ComputersDTO(x)).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Set<ComputersDTO> getComputers() {
		return computers;
	}

}
