package com.andre.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Order implements Serializable // Pedido
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date instant;

	@OneToOne(cascade = CascadeType.ALL, mappedBy="order")
	private Payment payment;

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name="delivery_address_id")
	private Adress deliveryAddress;

	public Order() 
	{

	}

	public Order(Integer id, Date instant, Customer customer, Adress deliveryAddress)
	{
		this.id = id;
		this.instant = instant;
		this.customer = customer;
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Date getInstant() 
	{
		return instant;
	}

	public void setInstant(Date instant) 
	{
		this.instant = instant;
	}

	public Payment getPayment() 
	{
		return payment;
	}

	public void setPayment(Payment payment)
	{
		this.payment = payment;
	}

	public Customer getCustomer() 
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public Adress getDeliveryAddress() 
	{
		return deliveryAddress;
	}

	public void setDeliveryAddress(Adress deliveryAddress) 
	{
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} 
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	



}
