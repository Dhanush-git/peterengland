package com.group2.peterengland.services;

import java.util.List;
import java.util.Optional;


import com.group2.peterengland.models.Offers;
import com.group2.peterengland.repositories.offersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class offersServices implements offersInterface {

	@Autowired
	offersRepository offersrepository;
	
	@Override
	public List<Offers> getoffer() {
		return offersrepository.findAll();
	}
	
	@Override
	public String addoffer(Offers offer) {
		offersrepository.save(offer);
		return "Offer added successfully";
	}

	@Override
	public String updateoffer(Offers offer) {
		offersrepository.save(offer);
		return "Offer updated successfully";
	}

	@Override
	public String deleteoffer(int offer_id) {
		offersrepository.deleteById(offer_id);
		return "Offer deleted successfully";
	}

	@Override
	public String getOfferOnProduct(int product_id) {
		Optional<Offers> offer = offersrepository.getOfferByProductId(product_id);
		if(offer.isPresent()){
			return offer.get().toString();
		}else{
			return "no offer for that product id found";
		}
	}

	public Optional<Offers> getOfferOnProductId(int product_id){
		return offersrepository.getOfferByProductId(product_id);
	}
}
