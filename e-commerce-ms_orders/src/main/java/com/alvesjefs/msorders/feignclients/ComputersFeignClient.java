package com.alvesjefs.msorders.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alvesjefs.msorders.domain.Computers;

@FeignClient(name = "ms-computers", path = "api/computers")
@Component
public interface ComputersFeignClient {

	@GetMapping(value = "/searchName")
	ResponseEntity<Computers> findByName(@RequestParam String name);

	@GetMapping(value = "/searchComputers")
	public ResponseEntity<List<Computers>> findPaginationComputers(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy);
}
