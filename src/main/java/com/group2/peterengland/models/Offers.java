package com.group2.peterengland.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int offer_id;
	private int product_id;
	private float discount;
	private Date start_date;
	private Date end_date;
	
	public Offers() {}
	
	public Offers(int product_id, float discount, Date start_date, Date end_date) {
		super();
		this.product_id = product_id;
		this.discount = discount;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public int getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "offers [offer_id=" + offer_id + ", product_id=" + product_id + ", discount=" + discount
				+ ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}
}
