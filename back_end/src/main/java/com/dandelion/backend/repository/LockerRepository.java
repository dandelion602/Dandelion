package com.dandelion.backend.repository;

import com.dandelion.backend.entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Integer> {
}
