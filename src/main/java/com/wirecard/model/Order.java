package com.wirecard.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date orderDate;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	@Cascade(CascadeType.ALL)
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	@Transient
	private int totalPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public int getTotalPrice() {
		int total = 0;
		int i = 0;
		
		while(i < items.size()) {
			total += items.get(i).getTotalPrice();
			i++;
		}
		
		return total;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
			
}
