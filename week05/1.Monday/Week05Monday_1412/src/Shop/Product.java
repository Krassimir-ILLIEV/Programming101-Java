package Shop;

import VAT.NotSupportedCountryException;
import VAT.VatTaxCalculator;

public class Product {
	
private double priceBeforeTax;
private String countryId, productName;
private int quantity;
private int productId;

public Product(int productId, String productName, double priceBeforeTax, String countryId,  int quantity){
	
	this.priceBeforeTax=priceBeforeTax;
	this.countryId=countryId;
	this.productName=productName;
	this.quantity=quantity;
	this.productId=productId;
}

public double getPriceAfterTax() throws NotSupportedCountryException {
	return VatTaxCalculator.CalculateTax(priceBeforeTax,countryId);
}

public double getPriceBeforeTax(){
	return priceBeforeTax;
}

public int getProductId(){
	return productId;
}

public int getQuantity(){
	return quantity;
}

}
