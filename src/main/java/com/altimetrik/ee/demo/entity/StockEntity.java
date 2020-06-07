package com.altimetrik.ee.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TBL_STOCK")
@DynamicUpdate(true)
public class StockEntity {

	@Override
	public String toString() {
		return "StockEntity [" + (stockNumber != null ? "stockNumber=" + stockNumber + ", " : "")
				+ (stockName != null ? "stockName=" + stockName + ", " : "")
				+ (purchasingPrice != null ? "purchasingPrice=" + purchasingPrice + ", " : "")
				+ (purchasingDate != null ? "purchasingDate=" + purchasingDate + ", " : "")
				+ (quantity != null ? "quantity=" + quantity : "") + "]";
	}

	public StockEntity() {
		
	}

	public StockEntity(Long pStockNumber, String pStockName, Integer pPurchasingPrice, String pPurchasingDate,
			Integer pQuantity) {
		super();
		this.stockNumber = pStockNumber;
		this.stockName = pStockName;
		this.purchasingPrice = pPurchasingPrice;
		this.purchasingDate = pPurchasingDate;
		this.quantity = pQuantity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_number")
	private Long stockNumber;

	@Column(name = "stock_name")
	private String stockName;

	@Column(name = "purchasing_price")
	private Integer purchasingPrice;

	@Column(name = "purchasing_date")
	private String purchasingDate;

	@Column(name = "quantity")
	private Integer quantity;

	public Long getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(Long pStockNumber) {
		this.stockNumber = pStockNumber;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String pStockName) {
		this.stockName = pStockName;
	}

	public Integer getPurchasingPrice() {
		return purchasingPrice;
	}

	public void setPurchasingPrice(Integer pPurchasingPrice) {
		this.purchasingPrice = pPurchasingPrice;
	}

	public String getPurchasingDate() {
		return purchasingDate;
	}

	public void setPurchasingDate(String pPurchasingDate) {
		this.purchasingDate = pPurchasingDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer pQuantity) {
		this.quantity = pQuantity;
	}
}
