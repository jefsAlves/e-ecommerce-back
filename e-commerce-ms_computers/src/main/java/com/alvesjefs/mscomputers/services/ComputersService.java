package com.alvesjefs.mscomputers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alvesjefs.mscomputers.domain.Computers;
import com.alvesjefs.mscomputers.dto.ComputersDTO;
import com.alvesjefs.mscomputers.repositories.ComputersRepository;
import com.alvesjefs.mscomputers.services.exceptions.NameNotFoundException;

@Service
public class ComputersService {

	@Autowired
	private ComputersRepository computersRepository;

	public Computers findByName(String name) {
		Computers findName = computersRepository.findByName(name);
		if (findName == null) {
			throw new NameNotFoundException("Name not found!");
		}
		return findName;
	}

	public List<ComputersDTO> paginationComputers(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Computers> findPagination = computersRepository.findAll(pageRequest);
		return findPagination.stream().map(x -> new ComputersDTO(x)).collect(Collectors.toList());
	}

}
