package edu.miu.cs.cs390fpp.mid.pdmapp.model;

import java.time.LocalDate;

/**
 * A Product class that manages stocks and other details
 * @author Tamirat Fisseha - 613437
 *
 */
public class Product implements Comparable<Product>{
	private static final int DEFAULT_STOCK = 0;
	private String productId;
	private long binNumber;
	private String description;
	private double unitPrice;
	private int stockQuantity;
	private LocalDate suppliedDate;
		
	
	public Product() {
		
	}

	/**
	 * the default constructor which expects all the instance varibles to be passed
	 * this is the one we will use on our main method
	 * @param productId
	 * @param binNumber
	 * @param description
	 * @param unitPrice
	 * @param stockQuantity
	 * @param suppliedDate
	 */
	public Product(String productId, long binNumber, String description, double unitPrice, int stockQuantity,
			LocalDate suppliedDate) {
		this.productId = productId;
		this.binNumber = binNumber;
		this.description = description;
		this.unitPrice = unitPrice;
		this.stockQuantity = stockQuantity;
		this.suppliedDate = suppliedDate;
	}
	
	/**
	 * a constructor without a stock quantity, we will use 0 as default  - hope this is OK
	 * we will consume the constant here
	 * @param binNumber
	 * @param description
	 * @param unitPrice
	 * @param stockQuantity
	 * @param suppliedDate
	 */
	public Product(String productId, long binNumber, String description, double unitPrice, LocalDate suppliedDate) {
		this(productId, binNumber, description, unitPrice,Product.DEFAULT_STOCK, suppliedDate);
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public long getBinNumber() {
		return binNumber;
	}
	public void setBinNumber(long binNumber) {
		this.binNumber = binNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public LocalDate getSuppliedDate() {
		return suppliedDate;
	}
	public void setSuppliedDate(LocalDate suppliedDate) {
		this.suppliedDate = suppliedDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", binNumber=" + binNumber + ", description=" + description
				+ ", unitPrice=" + unitPrice + ", stockQuantity=" + stockQuantity + ", suppliedDate=" + suppliedDate
				+ "]";
	}

	/**
	 * we would like to override this compareTo method as we want to give a sorting behavior to our product class
	 * we have to do some checks before going with the comparison though
	 */
	@Override
	public int compareTo(Product obj) {
		if(obj != null) {
			if(this.getUnitPrice() > obj.getUnitPrice()) return -1;
			else if(this.getUnitPrice() < obj.getUnitPrice()) return 1;
			else return 0;
		}
		return 0;
	}
	
	
}
