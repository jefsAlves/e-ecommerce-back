package com.alvesjefs.msorders.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.alvesjefs.msorders.domain.enums.OrderStatus;

@Entity
@Table(name = "TB_ORDERS")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String address;
	private Instant moment;
	private OrderStatus orderStatus;

	@ManyToMany
	@JoinTable(
	name = "TB_ORDERS_COMPUTERS", 
	joinColumns = @JoinColumn(name = "ORDER_ID"), 
	inverseJoinColumns = @JoinColumn(name = "COMPUTER_ID"))
	private Set<Computers> computers = new HashSet<>();

	public Orders() {
	}

	public Orders(Long id, String address, Instant moment, OrderStatus orderStatus) {
		this.id = id;
		this.address = address;
		this.moment = moment;
		this.orderStatus = orderStatus;
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

	public Set<Computers> getComputers() {
		return computers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [id=");
		builder.append(id);
		builder.append(", moment=");
		builder.append(moment);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append(", computers=");
		builder.append(computers);
		builder.append("]");
		return builder.toString();
	}

}
