package com.group2.peterengland.controllers;
import java.util.List;
import java.util.Optional;

import com.group2.peterengland.models.Inventory;
import com.group2.peterengland.services.InventoryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
	
	@Autowired
	private InventoryServiceImplementation inventoryService;
	
	@GetMapping("/inventory")
	public List<Inventory> getProducts1() {
		return inventoryService.getProducts();
	}
	
	@GetMapping("/inventory/{id}")
	public Optional<Inventory> getProduct(@PathVariable int id) {
		return inventoryService.getProduct(id);
	}
	
	@PostMapping("/inventory")
	public Inventory addProduct(@RequestBody Inventory inventory) {
		return inventoryService.addProduct(inventory);
	}
	
	@PutMapping("/inventory/{id}")
	public Inventory updateProduct(@PathVariable int id,@RequestBody Inventory inventory) {
		inventory.setId(id);
		return inventoryService.update(inventory);
	}
	
	@DeleteMapping("/inventory")
	public void deleteProduct(@RequestParam int id) {
		inventoryService.deleteProduct(id);
	}
}
