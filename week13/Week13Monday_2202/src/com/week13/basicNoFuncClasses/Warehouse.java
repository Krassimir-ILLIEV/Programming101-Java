package com.week13.basicNoFuncClasses;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Warehouse {

	private static int mUniqueWarehouseID = 0;

	private int mWarehouseID;
	private final Coordinates warehouseCoordinates;
	private Map<String, ProductRecord> availableProducts;
	private final int warehouseID;

	public Warehouse(Coordinates coordinates) { // start warehouse with
												// coordinates after checking
												// them
		availableProducts = new Hashtable<String, ProductRecord>();
		this.warehouseCoordinates = coordinates;
		this.warehouseID = mUniqueWarehouseID;
		mUniqueWarehouseID++;
	}

	public Coordinates getWarehouseCoordinates() {
		return warehouseCoordinates;
	}

	public double getProductWeight(String productName) {
		if (availableProducts.containsKey(productName)) {
			return availableProducts.get(productName).getUnitWeight();

		} else
			return 0.0; // ???????????it should throw a missing product
						// exception at least
	}

	public Map<String, ProductRecord> getAvailableProducts() {
		return availableProducts;
	}

	public void addSuppliedProducts(ArrayList<ProductRecord> suppliedProducts) {

		for (ProductRecord pr : suppliedProducts) {
			String currentProductName = pr.getName();
			if (availableProducts.containsKey(currentProductName)) {
				pr.setUnitsAvailable(
						pr.getUnitsAvailable() + availableProducts.get(currentProductName).getUnitsAvailable());
				availableProducts.put(pr.getName(), pr);
			} else {
				availableProducts.put(pr.getName(), pr);
			}
		}

	}

	public double getProductAvailability(String productName) {
		if (availableProducts.containsKey(productName)) {
			return availableProducts.get(productName).getUnitsAvailable();

		} else
			return 0.0; // ???????????it should throw a missing product
						// exception at least
	}
}
