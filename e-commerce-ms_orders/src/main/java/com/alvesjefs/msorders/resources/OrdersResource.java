package com.alvesjefs.msorders.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alvesjefs.msorders.domain.Orders;
import com.alvesjefs.msorders.dto.OrdersDTO;
import com.alvesjefs.msorders.services.OrdersService;

@RestController
@RequestMapping(value = "api/orders")
public class OrdersResource {

	@Autowired
	private OrdersService ordersService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Orders> findById(@PathVariable Long id) {
		Orders findId = ordersService.findById(id);
		return ResponseEntity.ok().body(findId);
	}

	@GetMapping
	public ResponseEntity<List<OrdersDTO>> findAll() {
		List<OrdersDTO> findAll = ordersService.findAll();
		return ResponseEntity.ok().body(findAll);
	}

	@GetMapping(value = "/searchPage")
	public ResponseEntity<Page<OrdersDTO>> findPagination(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "3") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		Page<OrdersDTO> findPage = ordersService.findPagination(page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(findPage);
	}

	@PostMapping
	public ResponseEntity<OrdersDTO> insertOrder(@RequestBody OrdersDTO ordersDTO) {
		OrdersDTO insertOrder = ordersService.insertOrder(ordersDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertOrder.getId())
				.toUri();
		return ResponseEntity.created(uri).body(insertOrder);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<OrdersDTO> updateOrder(@PathVariable Long id) {
		OrdersDTO orders = ordersService.updateOrder(id);
		return ResponseEntity.noContent().build();
	}
}
