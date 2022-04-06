package com.group2.peterengland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.group2.peterengland.models.Reviews;
import com.group2.peterengland.services.ReviewService;


@RestController
@RequestMapping(path="/review")
public class ReviewsController
{
	private final ReviewService reviewservice;
	
	@Autowired
	public ReviewsController(ReviewService reviewservice)
	{
		this.reviewservice=reviewservice;
	}

	@GetMapping
	public List<Reviews> getReviews()
	{
		return reviewservice.getReviews();
	}

	@PostMapping
	public Reviews addReview(@RequestBody Reviews reviews){
		return reviewservice.addReview(reviews);
	}

	@GetMapping("/{id}")
	public String getReview(@PathVariable int id){
		return reviewservice.getReview(id);
	}

	@PutMapping("/{id}")
	public String updateReview(@PathVariable int id,@RequestBody Reviews reviews){
		return reviewservice.updateReview(id,reviews);
	}

	@DeleteMapping()
	public void deleteReview(@RequestParam int id){
		reviewservice.deleteReview(id);
	}
}
