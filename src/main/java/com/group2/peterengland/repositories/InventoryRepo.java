package com.group2.peterengland.repositories;

import com.group2.peterengland.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

}
