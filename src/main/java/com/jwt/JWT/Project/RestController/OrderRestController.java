
package com.jwt.JWT.Project.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.jwt.JWT.Project.entity.Order;
import com.jwt.JWT.Project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/orders")
public class OrderRestController {

	@Autowired
	OrderService orderService;

	@GetMapping()
	public List<Order> getAll() {
		return orderService.findAll();
	}

	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {
		return orderService.create(orderData);
	}
}