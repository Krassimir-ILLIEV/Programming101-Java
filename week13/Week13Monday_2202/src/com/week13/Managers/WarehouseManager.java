package com.week13.Managers;

import java.util.Map;

import com.week13.basicNoFuncClasses.Coordinates;
import com.week13.basicNoFuncClasses.ProductRecord;
import com.week13.basicNoFuncClasses.SupplyRequest;
import com.week13.basicNoFuncClasses.Warehouse;

public class WarehouseManager {

	private Warehouse mWarehouse;

	public WarehouseManager(Warehouse warehouse) {
		this.mWarehouse = warehouse;
	}

	public void addToAvailability(SupplyRequest supplyRequest) {
		mWarehouse.addSuppliedProducts(supplyRequest.getSuppliedProducts());
	}

	public double getProductAvailability(String productName) {
		return mWarehouse.getProductAvailability(productName);
	}

	public Map<String, ProductRecord> getAvailableProducts() {
		return mWarehouse.getAvailableProducts();
	}

	public double getProductWeight(String productName) {
		return mWarehouse.getProductWeight(productName);
	}

	public Coordinates getWarehouseCoordinates() { // the manager could perhaps
													// pick differen warehouses
		return mWarehouse.getWarehouseCoordinates();
	}
	/*
	 * Class WarehouseManager A boolean checkAndLoadOrder(DeliveryRequest
	 * deliveryRequest) method should: - return false if some Product is
	 * missing; -if all necessary Products are present, this method should call
	 * decrementAvailability(String productName, double productQuantity ) which
	 * returns false if the operation is impossible and decrements corresponding
	 * Products otherwise; - call method writeToLog(Sender warehouse, int
	 * senderID,datetime timestamp,String ProductName,String added/taken/failed
	 * to act, double quantity/missing quantity). Sender should be some
	 * enumerable class which contains “warehouse”, “drone”, and maybe
	 * “supplier”. This log should be added to some static file in the common
	 * class; There should also be a method addToAvailability(SupplyRequest
	 * supplyRequest) which should: -increment product types’ quantities; -add
	 * new products.
	 */

}
