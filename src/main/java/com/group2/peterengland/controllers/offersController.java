package com.group2.peterengland.controllers;

import java.util.List;

import com.group2.peterengland.models.Offers;
import com.group2.peterengland.services.offersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class offersController {
	
	@Autowired
	private offersServices os;
	
	@GetMapping("/offers")
	public List<Offers> getoffers() {
		return this.os.getoffer();
	}
	
	@PostMapping("/offers")
	public String addoffer(@RequestBody Offers offer) {
		return this.os.addoffer(offer);
	}

	@GetMapping("/offers/p/{product_id}")
	public String getOfferOnProduct(@PathVariable int product_id){
		return os.getOfferOnProduct(product_id);
	}
	
	@PutMapping("/offers")
	public String updateoffer(@RequestBody Offers offer) {
		return this.os.updateoffer(offer);
	}
	
	@DeleteMapping("/offers/{offer_id}")
	public String deleteoffer(@PathVariable String offer_id){
		return this.os.deleteoffer(Integer.valueOf(offer_id));
	}
	
	
}

