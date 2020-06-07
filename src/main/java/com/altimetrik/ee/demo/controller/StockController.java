package com.altimetrik.ee.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.ee.demo.entity.StockEntity;
import com.altimetrik.ee.demo.exception.StockException;
import com.altimetrik.ee.demo.service.StockService;

@RestController
@RequestMapping("/stock")

public class StockController {

	@Autowired
	StockService stockService;

	@GetMapping("/Getstock/{stock_number}")
	public ResponseEntity<?> getStockDetails(@PathVariable("stock_number") long pStockNumber) throws StockException {
		StockEntity aStockEntity = stockService.getStockDetailsByID(pStockNumber);
		return new ResponseEntity<StockEntity>(aStockEntity, HttpStatus.OK);
	}

	@PostMapping("/CreateOrUpdateStock")
	public ResponseEntity<?> CreateOrUpdateStock(@RequestBody StockEntity pStockEntity) throws StockException {
		StockEntity aStockEntity = stockService.CreateOrUpdateStock(pStockEntity);
		return new ResponseEntity<StockEntity>(aStockEntity, HttpStatus.OK);

	}

}
