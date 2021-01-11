package com.alvesjefs.mscomputers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.mscomputers.domain.Computers;

public interface ComputersRepository extends JpaRepository<Computers, Long> {

	Computers findByName(String name);

}
