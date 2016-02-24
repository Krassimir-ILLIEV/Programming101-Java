package com.week13.basicNoFuncClasses;

public class Coordinates {

	private int x;
	private int y;

	public Coordinates(int x, int y) {
		init(x, y);
	}

	private void init(int x, int y) {
		if (x < 0 || x > 1000 || y < 0 || y > 1000) {
			throw new IllegalArgumentException("Incorrect coordinate input");
		} else {
			this.x = x;
			this.y = y;
		}
	}

	public double getDistanceTo(Coordinates coordinates) {
		// check input for correctness
		double xDistanceSq = (this.x - coordinates.x) * (this.x - coordinates.x);
		double yDistanceSq = (this.y - coordinates.y) * (this.y - coordinates.y);

		return Math.sqrt(xDistanceSq + yDistanceSq); // this method is a stub
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
