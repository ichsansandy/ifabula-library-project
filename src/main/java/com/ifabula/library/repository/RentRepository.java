package com.ifabula.library.repository;

import com.ifabula.library.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Integer> {
}
