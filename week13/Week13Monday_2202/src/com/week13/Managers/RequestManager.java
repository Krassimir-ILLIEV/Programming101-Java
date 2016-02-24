package com.week13.Managers;

import com.week13.Helpers.InputReader;
import com.week13.basicNoFuncClasses.DeliveryRequest;
import com.week13.basicNoFuncClasses.SupplyRequest;
import com.week13.basicNoFuncClasses.Warehouse;

public class RequestManager {

	public void manageRequests(DroneManager dm, WarehouseManager warehouseManager) {

		InputReader ir = new InputReader("/home/ubuntu/workspace/Week13Monday_2202/src/testDeliveryRequests");
		String requestType = ir.getNextRequestType();

		// System.out.println(warehouseManager.getAvailableProducts());
		while (requestType != null) {
			if (requestType.equals("supply")) {
				SupplyRequest currentSupplyRequest = ir.convertToSupplyRequest();
				warehouseManager.addToAvailability(currentSupplyRequest);
				// System.out.println(warehouseManager.getAvailableProducts());
			} else if (requestType.equals("delivery")) {
				DeliveryRequest currentDeliveryRequest = ir.convertToDeliveryRequest();
				double DeliveryTimeTotal = dm.filfillOrder(currentDeliveryRequest);
				if (DeliveryTimeTotal == -1) {
					System.out.println("The drones could not make the delivery");
				} else {
					System.out.println("The time it took the drones to make the delivery was "
							+ dm.filfillOrder(currentDeliveryRequest));
					// this is just for testing
				}
			}
			requestType = ir.getNextRequestType();
		}
	}
}
