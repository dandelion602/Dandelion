package com.dandelion.backend.repository;

import com.dandelion.backend.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DealRepository extends JpaRepository<Deal, Integer> {

//
//    @Query("select * from Deal  where sellerNumber = sellerNumber")
//    List<Deal> findBy

    List<Deal> findBySeller(int sellerNumber);

}
