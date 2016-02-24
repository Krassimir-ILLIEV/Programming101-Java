package com.week13.basicNoFuncClasses;

public class Product {

	private String mName;
	private double mWeightPerQuantity;

	public Product(String name, double weightPerQuantity) {
		init(name, weightPerQuantity);
	}

	/**
	 * method init checks if the user input is valid and assign it to instance
	 * variables. Otherwise exception is thrown
	 */

	private void init(String name, double weightPerQuantity) {
		if (name.equals(null)) {
			throw new IllegalArgumentException("Nothing written for product name.");
		} else {
			this.mName = name;
		}
		if (weightPerQuantity < 0) {
			throw new IllegalArgumentException("Weight per quantity can't be less than 0.");
		} else {
			this.mWeightPerQuantity = weightPerQuantity;
		}
	}

	public String getName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

	public double getWeightPerQuantity() {
		return mWeightPerQuantity;
	}

	public void setWeightPerQuantity(double mWeightPerQuantity) {
		this.mWeightPerQuantity = mWeightPerQuantity;
	}
}
