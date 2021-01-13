package com.alvesjefs.msorders.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alvesjefs.msorders.domain.Orders;
import com.alvesjefs.msorders.dto.OrdersDTO;
import com.alvesjefs.msorders.repositories.OrdersRepository;
import com.alvesjefs.msorders.services.exceptions.IdNotFoundException;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	public Orders findById(Long id) {
		Optional<Orders> findId = ordersRepository.findById(id);
		return findId.orElseThrow(() -> new IdNotFoundException("Id not found!"));
	}

	public List<OrdersDTO> findAll() {
		List<Orders> findAll = ordersRepository.findAll();
		return findAll.stream().map(x -> new OrdersDTO(x)).collect(Collectors.toList());
	}

	public Page<OrdersDTO> findPagination(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Orders> findPage = ordersRepository.findAll(pageRequest);
		return findPage.map(x -> new OrdersDTO(x));
	}

}
