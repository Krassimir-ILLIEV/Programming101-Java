package com.week13.basicNoFuncClasses;

/**
 * class Drone has only one constructor with parameters, method init which
 * checks if the user input is correct and assign passed parameters to instance
 * variables, also has getters and setters. If the user input is not correct,
 * exception is thrown. Otherwise object drone is created.
 *
 */
public class Drone {

	private static int mUniqueDroneID = 0;

	private int mDroneID;
	private int mBatteryUnits;
	private int mCapacity;
	private double mChargingRate;
	private double mLoadingTime;
	private double mUnloadingTime;
	private Coordinates mCurrentCoordinates;

	public Drone(int batteryUnits, int capacity, double chargingRate, double loadingTime, double unloadingTime) {
		init(batteryUnits, capacity, chargingRate, loadingTime, unloadingTime);
		// mUniqueID += 1;
	}

	private void init(int batteryUnits, int capacity, double chargingRate, double loadingTime, double unloadingTime) {

		mDroneID = mUniqueDroneID;
		mUniqueDroneID++;
		if (batteryUnits < 0 || batteryUnits > 2000) {
			throw new IllegalArgumentException("Battery units must be more than 0 and less than 2000.");
		} else {
			this.mBatteryUnits = batteryUnits;
		}
		if (capacity < 0 || capacity > 500) {
			throw new IllegalArgumentException("Weight capacity must be more than 0 and less than 500.");
		} else {
			this.mCapacity = capacity;
		}

		this.mChargingRate = chargingRate; // think about corner cases
		this.mLoadingTime = loadingTime;
		this.mUnloadingTime = unloadingTime;
	}

	public void charge() {
		// it takes some time to charge the battery
	}

	// all setters should check their input
	public void setCurrentCoordinates(Coordinates CurrentCoordinates) {
		this.mCurrentCoordinates = CurrentCoordinates;
	}

	public Coordinates getCurrentCoordinates() {
		return mCurrentCoordinates;
	}

	public final int getDroneID() { // it should not be static, but assigned to
									// a drone and it should not change
		return mDroneID;
	}

	// public void setDroneID() { //drone ID should be unique and set only once
	// this.mDroneID = mUniqueID;
	// mUniqueID++;
	// }

	public int getBatteryUnits() {
		return mBatteryUnits;
	}

	public void setBatteryUnits(int BatteryUnits) {
		this.mBatteryUnits = BatteryUnits;
	}

	public int getCapacity() {
		return mCapacity;
	}

	public void setCapacity(int Capacity) {
		this.mCapacity = Capacity;
	}

	public double getChargingRate() {
		return mChargingRate;
	}

	public void setChargingRate(double ChargingRate) {
		this.mChargingRate = ChargingRate;
	}

	public double getLoadingTime() {
		return mLoadingTime;
	}

	public void setLoadingTime(double loadingTime) {
		this.mLoadingTime = loadingTime;
	}

	public double getUnloadingTime() {
		return mUnloadingTime;
	}

	public void setUnloadingTime(double unloadingTime) {
		this.mUnloadingTime = unloadingTime;
	}
}
