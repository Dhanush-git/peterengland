package com.group2.peterengland.services;

import com.group2.peterengland.models.Inventory;

import java.util.List;
import java.util.Optional;


public interface InventoryService {

	List<Inventory> getProducts();
	
	Optional<Inventory> getProduct(int id);
	
	Inventory addProduct(Inventory inventory);
	
	void deleteProduct(int id);

	Inventory update(Inventory inventory);
}
