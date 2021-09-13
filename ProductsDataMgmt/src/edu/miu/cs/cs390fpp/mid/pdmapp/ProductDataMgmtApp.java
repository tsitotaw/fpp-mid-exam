package edu.miu.cs.cs390fpp.mid.pdmapp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringJoiner;

import edu.miu.cs.cs390fpp.mid.pdmapp.model.Product;

public class ProductDataMgmtApp {

	public static void main(String[] args) {		
		
		Product[] productList = {
				new Product("P-123-001", 9123456780L, "Apples – Golden Delicious", 2.50f, 248, LocalDate.of(2021,9,10 )),
				new Product("D-124-002", 9123456789L, "Semi-skimmed Milk (1gal)", 4.05f, 64, LocalDate.of(2021,9,8 )),
				new Product("P-123-009", 9123456781L, "Sweet potatoes (Organic)", 5.65f, 131, LocalDate.of(2021,8,31 ))
		};
		
		System.out.println("Before Sorting");
		printProducts(productList);
		
		System.out.println("After Sorting");
		sortProducts(productList);
		printProducts(productList);
		
		findLowInStockProduct(productList);

	}
	
	/**
	 * a helper method that allows us to print products according to expected format
	 * we will be using a StringJoiner and String.format to properly display those
	 * @param list
	 */
	private static void printProducts(Product[] list) {
		String format = "";
		StringJoiner joiner = new StringJoiner("","[","\n]");
		for(Product product: list) {
			format = String.format("\n\t{ProductId: %s, Bin No: %d, Desc: %s, Price: $%.2f, QuantityInStock: %d, DateSupplied: %s},",
					product.getProductId(), product.getBinNumber(), product.getDescription(), product.getUnitPrice(), product.getStockQuantity(),
					product.getSuppliedDate());
			joiner.add(format);
		}
		
		System.out.println(joiner.toString());
	}
	
	/**
	 * Here we just only need to call the Arrays.sort here as we have already implement our own compareTo method
	 * @param list
	 */
	public static Product[] sortProducts(Product[] list) {
		Arrays.sort(list);
		return list;
	}
	
	/**
	 * Here we will find the lowest Product from a Stock
	 * We will be using an index flag to determine the lowest stock 
	 * @param list
	 */
	private static void findLowInStockProduct(Product[] list) {
		int lowQuantityProductIndex = 0;
		for(int i=0; i< list.length; i++) {
			lowQuantityProductIndex = (list[i].getStockQuantity() < list[lowQuantityProductIndex].getStockQuantity()) ? i : lowQuantityProductIndex;
		}
		
		System.out.println("The low in Stock Quantity is : " + list[lowQuantityProductIndex]);
	}

}
