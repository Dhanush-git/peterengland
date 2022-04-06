package com.group2.peterengland.services;

import com.group2.peterengland.models.Offers;

import java.util.List;
import java.util.Optional;

public interface offersInterface {
	
	public List<Offers> getoffer();
	public String addoffer(Offers offer);
	public String updateoffer(Offers offer);
	public String deleteoffer(int offer_id);

    String getOfferOnProduct(int product_id);
}
