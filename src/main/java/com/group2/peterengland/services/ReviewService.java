package com.group2.peterengland.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.group2.peterengland.models.Reviews;
import com.group2.peterengland.repositories.ReviewRepository;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewService(ReviewRepository reviewRepository) {
		
		this.reviewRepository = reviewRepository;
	}


	public List<Reviews> getReviews()
	{
		return reviewRepository.findAll();
	}

	public String getReview(int id)
	{
		Optional<Reviews> optionalReviews = reviewRepository.getReviewById(id);
		if(optionalReviews.isPresent()){
			return optionalReviews.get().toString();
		}else{
			return "No such review by that id found";
		}
	}

	public String updateReview(int id,Reviews reviews) {
		Optional<Reviews> optionalReviews = reviewRepository.getReviewById(id);
		if(optionalReviews.isPresent()){
			reviews.setId(id);
			reviewRepository.save(reviews);
			return reviews.toString();
		}else{
			return "No such review by that id found";
		}
	}

	public void deleteReview(int id) {
		reviewRepository.deleteById(id);
	}

	public Reviews addReview(Reviews reviews) {
		return reviewRepository.save(reviews);
	}
}
