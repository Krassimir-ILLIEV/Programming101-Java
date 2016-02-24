package com.week13.basicNoFuncClasses;

import java.util.ArrayList;
import java.util.Date;

public class SupplyRequest {

	private ArrayList<ProductRecord> mSuppliedProducts;
	private int mSupplyID;
	private String mTimestamp; // should be date

	public SupplyRequest(String supplyRequest) {
		mSuppliedProducts = new ArrayList<ProductRecord>();
		// sample string supply (id) (timestamp) (product name 1) (product
		// weight) (quantity) (product name 2) (product weight) (quantity)
		supplyRequest = supplyRequest.replaceAll("\\p{javaSpaceChar}{2,}", " ").trim();
		String[] supplyRequestArray = supplyRequest.split(" ");
		mSupplyID = Integer.parseInt(supplyRequestArray[1]);
		// double tempTimestamp=Double.parseDouble(supplyRequestArray[2]);
		// mTimestamp=Date.parse(supplyRequestArray[2]);
		String timestamp = supplyRequestArray[2];
		mTimestamp = timestamp;

		for (int i = 3; i < supplyRequestArray.length; i += 3) {
			String productName = supplyRequestArray[i];
			double productWeight = Double.parseDouble(supplyRequestArray[i + 1]);
			double productQuantity = Double.parseDouble(supplyRequestArray[i + 2]);
			ProductRecord productRecord = new ProductRecord(productName, productWeight, productQuantity);
			mSuppliedProducts.add(productRecord);

		}

	}

	public ArrayList<ProductRecord> getSuppliedProducts() {
		return mSuppliedProducts;
	}

	public String toString() {
		String supplyRequest = "ID: " + mSupplyID + " timestamp: " + mTimestamp + " ";
		for (ProductRecord pr : mSuppliedProducts) {
			supplyRequest += pr;
		}
		return supplyRequest;
	}

}
