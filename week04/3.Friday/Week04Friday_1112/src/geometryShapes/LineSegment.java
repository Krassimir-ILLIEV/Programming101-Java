package geometryShapes;

public class LineSegment implements Comparable<LineSegment> {
	private Point p1; // moje li final
	private Point p2; // s try catch kak 6te stane?

	public LineSegment(Point p1, Point p2) {
		if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
			throw new java.lang.IllegalArgumentException("Cannot create a line segment with zero length.");
		}

		this.p1 = new Point(p1); // so that it is immutable
		this.p2 = new Point(p2);
	}

	public LineSegment(LineSegment l) {
		this(l.getStartPoint(), l.getEndPoint());
	}

	public int compareTo(LineSegment l) {
		if (this.getLength() > l.getLength()) {
			return 1;
		} else if (this.getLength() == l.getLength()) {
			return 0;
		} else
			return -1;

	}

	public Point getStartPoint() {
		if (p1.compareTo(p2) <= 0) {
			return p1;
		} else
			return p2;
	}

	public Point getEndPoint() {
		if (p1.compareTo(p2) <= 0) {
			return p2;
		} else
			return p1;
	}

	public double getLength() {
		return Math.sqrt(Math.pow((getStartPoint().getX() - getEndPoint().getX()), 2)
				+ Math.pow((getStartPoint().getY() - getEndPoint().getY()), 2));
	}

	@Override
	public String toString() {
		String s = "Line[(" + p1.getX() + "," + p1.getY() + "),(" + p2.getX() + "," + p2.getY() + ")]";
		return s;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		hash = hash * 23 + p1.hashCode();
		hash = hash * 23 + p2.hashCode();
		return hash;
	}

	@Override
	// equals
	public boolean equals(Object l) {
		if (this.getClass().getName() != l.getClass().getName()) {
			return false;
		}
		LineSegment l1 = (LineSegment) l;
		if (!p1.equals(l1.p1)) {
			return false;
		} else if (!p2.equals(l1.p2)) {
			return false;
		}
		return true;
	}

	public Point getPartitionPoint(double d) {
		return new Point(p1.getX() + (p2.getX()-p1.getX())*d, (p1.getY() + (p2.getY()-p1.getY())*d));

	}

	public static void main(String[] args) {

	}
}
