package com.alvesjefs.mscomputers.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvesjefs.mscomputers.domain.Computers;
import com.alvesjefs.mscomputers.dto.ComputersDTO;
import com.alvesjefs.mscomputers.services.ComputersService;

@RestController
@RequestMapping(value = "api/computers")
public class ComputersResource {

	@Autowired
	private ComputersService computersService;

	@GetMapping(value = "/searchName")
	public ResponseEntity<Computers> findByName(@RequestParam String name) {
		Computers findName = computersService.findByName(name);
		return ResponseEntity.ok().body(findName);
	}

	@GetMapping(value = "/searchComputers")
	public ResponseEntity<List<ComputersDTO>> findPaginationComputers(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
		List<ComputersDTO> findPagination = computersService.paginationComputers(page, linesPerPage, direction,
				orderBy);
		return ResponseEntity.ok().body(findPagination);
	}

}
