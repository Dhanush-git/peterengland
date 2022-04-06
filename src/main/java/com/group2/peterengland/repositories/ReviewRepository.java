package com.group2.peterengland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group2.peterengland.models.Reviews;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews,Integer>
{
    Optional<Reviews> getReviewById(int id);
}
