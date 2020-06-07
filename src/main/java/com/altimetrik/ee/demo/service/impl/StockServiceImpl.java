package com.altimetrik.ee.demo.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.ee.demo.constants.MessageContants;
import com.altimetrik.ee.demo.entity.StockEntity;
import com.altimetrik.ee.demo.exception.StockException;
import com.altimetrik.ee.demo.repository.StockRepository;
import com.altimetrik.ee.demo.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	private static Logger logger = LoggerFactory.getLogger(StockServiceImpl.class.getName());

	@Autowired
	private StockRepository stockRepository;

	@Override
	public StockEntity getStockDetailsByID(long pStockNumber) throws StockException {
		StockException aStockException = null;
		try {
			Optional<StockEntity> aStockEntity = stockRepository.findById(pStockNumber);
			if (aStockEntity.isPresent()) {
				logger.debug(MessageContants.SUCCESS_RETRIEVE + aStockEntity.get().toString());
				return aStockEntity.get();
			} else {
				aStockException = new StockException(1001, MessageContants.NOT_AVAILABLE);
			}
		} catch (Exception pException) {
			logger.error(pException.getMessage(), pException);
			aStockException = new StockException(1002, MessageContants.UNABLE_TO_RETREVE);
		} finally {
			if (aStockException != null) {
				throw aStockException;
			}
		}
		return new StockEntity();
		
	}

	@Override
	public StockEntity CreateOrUpdateStock(StockEntity pStockEntity) throws StockException {
		StockEntity aNewStockEntity = new StockEntity();
		Optional<StockEntity> aStockEntity = null;
		try {
			if (pStockEntity.getStockNumber() != null) {
				aStockEntity = stockRepository.findById(pStockEntity.getStockNumber());
				if (aStockEntity.isPresent()) {
					logger.debug(MessageContants.FOUND_REQUESTING_UPDATE);
					aNewStockEntity.setStockNumber(pStockEntity.getStockNumber());
				} else {
					logger.debug(MessageContants.NOT_FOUND_REQUESTING_CREATE);
				}
			} else {
				logger.debug(MessageContants.REQUESTING_CREATE);
			}
			aNewStockEntity.setStockName(pStockEntity.getStockName());
			aNewStockEntity.setPurchasingDate(pStockEntity.getPurchasingDate());
			aNewStockEntity.setPurchasingPrice(pStockEntity.getPurchasingPrice());
			aNewStockEntity.setQuantity(pStockEntity.getQuantity());
			aNewStockEntity = stockRepository.save(pStockEntity);

			logger.debug(MessageContants.CREATE_SUCCESS + aNewStockEntity.toString());
		} catch (Exception pException) {
			logger.error(pException.getMessage(), pException);
			throw new StockException(1003, MessageContants.UNABLE_TO_CREATE_UPDATE);
		}

		return aNewStockEntity;
	}

}
