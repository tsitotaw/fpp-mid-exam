package edu.miu.cs.cs390fpp.mid.pdmapp;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.miu.cs.cs390fpp.mid.pdmapp.model.Product;

class ProductDataMgmtAppTest {

	@Test
	void testIfSortingWorks() {
		
		Product[] inputList = {
				new Product("P-123-001", 9123456780L, "Apples – Golden Delicious", 2.50f, 248, LocalDate.of(2021,9,10 )),
				new Product("D-124-002", 9123456789L, "Semi-skimmed Milk (1gal)", 4.05f, 64, LocalDate.of(2021,9,8 )),
				new Product("P-123-009", 9123456781L, "Sweet potatoes (Organic)", 5.65f, 131, LocalDate.of(2021,8,31 ))
		};
		
		Product[] expectedResult = {
				new Product("P-123-009", 9123456781L, "Sweet potatoes (Organic)", 5.65f, 131, LocalDate.of(2021,8,31 )),
				new Product("D-124-002", 9123456789L, "Semi-skimmed Milk (1gal)", 4.05f, 64, LocalDate.of(2021,9,8 )),
				new Product("P-123-001", 9123456780L, "Apples – Golden Delicious", 2.50f, 248, LocalDate.of(2021,9,10 ))
		};
		
		Product[] actualResult = ProductDataMgmtApp.sortProducts(inputList);
		assertEquals(expectedResult[0].getUnitPrice(), actualResult[0].getUnitPrice());
	}

}
