package com.altimetrik.ee.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.altimetrik.ee.demo.bean.ErrorResponseBean;

@ControllerAdvice
public class RestErrorHandler {

	private static Logger logger = LoggerFactory.getLogger(RestErrorHandler.class.getName());

	@ExceptionHandler(StockException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponseBean processValidationError(StockException pStockException) {
		logger.info("Inside ErrorHandler");
		ErrorResponseBean anErrorResponseBean = new ErrorResponseBean(pStockException.getErrorCode(),
				pStockException.getErrorMessage());
		return anErrorResponseBean;
	}
}
