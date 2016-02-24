package com.week13.Helpers;

import com.week13.Managers.DroneManager;
import com.week13.Managers.RequestManager;
import com.week13.Managers.WarehouseManager;
import com.week13.basicNoFuncClasses.Coordinates;
import com.week13.basicNoFuncClasses.Warehouse;

public class Demo {

	public static void main(String[] args) {
		// let's start the freakshow, shall we

		Coordinates warehouseCoordinates = new Coordinates(42, 42);
		Warehouse warehouse = new Warehouse(warehouseCoordinates);
		WarehouseManager warehouseManager = new WarehouseManager(warehouse);
		// or perhaps a structure containing warehouses
		DroneManager droneManager = new DroneManager(5, warehouseManager);
		// this class should be implemented
		// all of the above method could be started in some set-up method of
		// some global managing class

		RequestManager requestManager = new RequestManager();
		requestManager.manageRequests(droneManager, warehouseManager);
		// managing request delegates to this drone manager

		// bear in mind that request manager makes an instance of the following
		// class, among other things:
		// InputReader inputReader=new
		// InputReader("/home/ubuntu/workspace/Week13Monday_2202/src/testDeliveryRequests");
		// this fila contains two lines:
		// delivery 1 timestamp targetCoordinates productName1 7 productName2 8
		// supply 2 timestamp productName1 10 11 productName2 12 13 productName3
		// 14 15 productName4 15 16

	}
}
