package com.group2.peterengland.services;

import java.util.List;
import java.util.Optional;

import com.group2.peterengland.models.Inventory;
import com.group2.peterengland.repositories.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImplementation implements InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;
	
	@Override
	public List<Inventory> getProducts() {
		
		return inventoryRepo.findAll();
	}

	@Override
	public Optional<Inventory> getProduct(int id) {
		Optional<Inventory> optionaldata = inventoryRepo.findById(id);
		
		return optionaldata;
	}

	@Override
	public Inventory addProduct(Inventory inventory) {
		return inventoryRepo.save(inventory);
	}
	

	@Override
	public void deleteProduct(int id) {
		inventoryRepo.deleteById(id);
	}

	@Override
	public Inventory update(Inventory inventory) {
		return inventoryRepo.save(inventory);
	}

	
}
