package com.week13.basicNoFuncClasses;

public class ProductRecord {

	private String mName;
	private double mUnitWeight;
	private double mUnitsAvailable;

	public ProductRecord(String name, double unitWeight, double unitsAvailable) {
		init(name, unitWeight, unitsAvailable);
	}

	/**
	 * method init checks if the user input is valid and assign it to instance
	 * variables. Otherwise exception is thrown
	 */

	private void init(String name, double unitWeight, double unitsAvailable) {
		setName(name);
		setUnitWeight(unitWeight);
		setUnitsAvailable(unitsAvailable);
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {

		if (name == null) {
			throw new IllegalArgumentException("Nothing written for product name.");
		} else {
			this.mName = name;
		}
	}

	public double getUnitWeight() {
		return mUnitWeight;
	}

	public void setUnitWeight(double unitWeight) {

		if (mUnitWeight < 0) {
			throw new IllegalArgumentException("Unit weight can't be less than 0.");
		} else {
			this.mUnitWeight = unitWeight;
		}
	}

	public double getUnitsAvailable() {
		return mUnitsAvailable;
	}

	public void setUnitsAvailable(double unitsAvailable) {
		if (unitsAvailable < 0) {
			throw new IllegalArgumentException("Units available can't be less than 0.");
		} else {
			this.mUnitsAvailable = unitsAvailable;
		}
	}

	public String toString() {
		return "(ProductName: " + mName + " unit weight: " + mUnitWeight + " units available: " + mUnitsAvailable + ")";

	}
}
