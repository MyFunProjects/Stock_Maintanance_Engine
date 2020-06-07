package com.altimetrik.ee.demo.service;

import org.springframework.stereotype.Service;

import com.altimetrik.ee.demo.entity.StockEntity;
import com.altimetrik.ee.demo.exception.StockException;

@Service
public interface StockService {

	public StockEntity getStockDetailsByID(long pStockNumber) throws StockException;

	public StockEntity CreateOrUpdateStock(StockEntity pStockEntity) throws StockException;

}
