package com.group2.peterengland.repositories;

import com.group2.peterengland.models.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface offersRepository extends JpaRepository<Offers,Integer> {
    @Query("SELECT o FROM Offers o WHERE o.product_id=?1")
    public Optional<Offers> getOfferByProductId(int product_id);
}
