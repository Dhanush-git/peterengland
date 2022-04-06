package com.group2.peterengland.models;
import javax.persistence.*;

@Entity
public class Reviews
{
	@Id
	@Column(name = "bill_no")
	private Integer id;
	private String review_text;
	private int stars;

	public Reviews()
	{
		
	}
	
	public Reviews(Integer bill_no,String review_text, int stars) {
		this.review_text = review_text;
		this.id = bill_no;
		this.stars = stars;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReview_text() {
		return review_text;
	}

	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Reviews{" +
				"id=" + id +
				", review_text='" + review_text + '\'' +
				", stars=" + stars +
				'}';
	}
}
