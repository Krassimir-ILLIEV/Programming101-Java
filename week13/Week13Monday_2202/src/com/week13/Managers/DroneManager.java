package com.week13.Managers;

import java.util.ArrayList;

import com.week13.basicNoFuncClasses.Coordinates;
import com.week13.basicNoFuncClasses.DeliveryRequest;
import com.week13.basicNoFuncClasses.Drone;
import com.week13.basicNoFuncClasses.ProductRecord;

public class DroneManager {

	private ArrayList<Drone> availableDrones;
	// assume all drones are in warehouse and ready

	WarehouseManager mWarehouseManager;

	public DroneManager(int droneCount, WarehouseManager warehouseManager) {
		availableDrones = new ArrayList<Drone>();
		mWarehouseManager = warehouseManager;
		for (int i = 0; i < droneCount; i++) {
			Drone drone = new Drone(2000, 500, 5.0, 1.0, 1.0);

			drone.setCurrentCoordinates(warehouseManager.getWarehouseCoordinates());
			// all drones are set to start from only one specific warehouse

			// System.out.println(drone.getCapacity());
			availableDrones.add(drone);
			// set drone coordinates to warehouse coordinates from
			// warehouseManager by ID
		}
	}

	private double checkDrones(int neededFlights) {

		return 0; // ?????????????????will be used in the future;
	}

	public double getTotalDeliveryWeight(DeliveryRequest deliveryRequest) {
		ArrayList<ProductRecord> productsToDeliver = deliveryRequest.getProductsToDeliver();
		double deliveryWeight = 0;
		for (ProductRecord pr : productsToDeliver) {
			deliveryWeight += mWarehouseManager.getProductWeight(pr.getName()) * pr.getUnitsAvailable(); // here
			// here units available means units to deliver
		}
		return deliveryWeight;
	}

	private int calculateNeededFlights(DeliveryRequest deliveryRequest) {
		// check if cargo is divisible
		double deliveryTotalWeight = getTotalDeliveryWeight(deliveryRequest);
		Drone drone = availableDrones.get(0);
		// check if empty, assume all drones are same type
		int droneCapacity = drone.getCapacity();
		return ((Double) (Math.ceil(deliveryTotalWeight / droneCapacity))).intValue();
		// this method will always round up

	}

	private double calculateTime(int neededFlights, DeliveryRequest deliveryRequest) {
		// Warehouse ID could be added as a parameter

		if (neededFlights < availableDrones.size()) {

			// check if empty; otherwise delivery is made in one go

			Drone drone = availableDrones.get(0);
			// assuming all drones are the same; we need one to obtain its
			// characteristics

			final double chargingRate = drone.getChargingRate();
			final double timeToLoad = drone.getLoadingTime();
			final double timeToUnload = drone.getUnloadingTime();
			Coordinates destinationCoordinates = deliveryRequest.getCoordinates();
			double timeToTravel = drone.getCurrentCoordinates().getDistanceTo(destinationCoordinates);
			// ???????????? drone coordinates should be considered in the
			// future, also event driven simulation
			double timeTotal = timeToTravel + timeToLoad + timeToUnload;
			// time for all drones is the same as that for first drone+time
			// to load,time to unload, and maybe time to recharge
			return timeTotal;

		} else {

			int timesAllDronesAreSent = ((Double) (Math.ceil(neededFlights / availableDrones.size()))).intValue();
			// this should always round up, as even if not all drones are
			// set out the last time, it will still take time for at least
			// one from the last wave to arrive
			// it should return how many drone "waves" (all available
			// drones) were sent to the destination

			// the time to delivery in this case will take into account the
			// following steps:
			// each wave of drones will load, (charge if not first wave)
			// travel the distance from warehouse to destination,
			// unload,
			// and with the exception of the last wave, travel the distance
			// back
			// check if empty; delivery is made in one go

			Drone drone = availableDrones.get(0);
			final double chargingRate = drone.getChargingRate();
			final double timeToLoad = drone.getLoadingTime();
			final double timeToUnload = drone.getUnloadingTime();
			Coordinates destinationCoordinates = deliveryRequest.getCoordinates();

			double timeToTravelLastWave = drone.getCurrentCoordinates().getDistanceTo(destinationCoordinates);
			double timeToTravelReturningWaves = 2 * timeToTravelLastWave;
			double timeToloadUnloadAllWaves = timesAllDronesAreSent * (timeToLoad + timeToUnload);
			// double chargingTime=; //this was not added

			double timeTotal = timeToTravelReturningWaves + timeToTravelLastWave + timeToloadUnloadAllWaves;
			return timeTotal;
		}
	}

	public boolean isDeliveryPossible(DeliveryRequest deliveryRequest) {
		ArrayList<ProductRecord> productsToDeliver = deliveryRequest.getProductsToDeliver();

		boolean isDeliveryPossible = true; // this should involve other checks
											// as well
		for (ProductRecord pr : productsToDeliver) {

			if (mWarehouseManager.getProductAvailability(pr.getName()) == 0) {
				isDeliveryPossible = false;
			}
		}
		return isDeliveryPossible;
	}

	public double filfillOrder(DeliveryRequest deliveryRequest) {

		// warehouseManager.checkAndLoadOrder(deliveryRequest);
		// these should be called
		// WarehouseManager.checkAvailability(deliveryRequest);
		// WarehouseManager.getdeliveryweight
		if (isDeliveryPossible(deliveryRequest)) {
			int neededFlights = calculateNeededFlights(deliveryRequest);

			return calculateTime(neededFlights, deliveryRequest);
		} else
			return -1; // this case will have to be handled with a queue

		// -WarehouseManager object method checkAndLoadOrder(DeliveryRequest
		// deliveryRequest);
		// -calculateNeededFlights();
		// -checkDrones() which should calculate drone positions and battery
		// statuses and pick a drone or more, decide on charging and combined
		// deliveries;
		// -calculateTime() which returns ETA taking into consideration
		// distances/loading/unloading times, etc.
	}
}
