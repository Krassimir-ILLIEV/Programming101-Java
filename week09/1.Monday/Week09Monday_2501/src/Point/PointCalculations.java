package Point;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class PointCalculations {

	public static List<MyPoint> generatePoints() {

		List<MyPoint> generatedPoints = new ArrayList<MyPoint>();

		for (int i = 0; i < 30000; i++) { // was 100_000
			double x = ThreadLocalRandom.current().nextDouble(0, 10_000);
			double y = ThreadLocalRandom.current().nextDouble(0, 10_000);
			generatedPoints.add(new MyPoint(x, y));
		}

		return generatedPoints;
	}

	public Map<MyPoint, MyPoint> getNearestPoints(List<MyPoint> generatedPoints) {
		Map<MyPoint, MyPoint> pointMap = new ConcurrentHashMap<MyPoint, MyPoint>();

		while (!generatedPoints.isEmpty()) {
			MyPoint first = generatedPoints.remove(0);
			double minDist = Double.MAX_VALUE;
			MyPoint closestPoint = first;
			for (MyPoint p : generatedPoints) {
				double currentDist = first.getDistanceSq(p);
				if (currentDist < minDist) {
					minDist = currentDist;
					closestPoint = p;
				}
			}
			pointMap.put(closestPoint, first);
			pointMap.put(first, closestPoint);
			generatedPoints.remove(closestPoint);

		}

		return pointMap;

	}

	public class calculatingThreadRange implements Runnable {

		List<MyPoint> inPoints;
		int indexFrom;
		int indexTo;
		Map<MyPoint, MyPoint> outMap;

		public calculatingThreadRange(List<MyPoint> inPoints, int indexFrom, int indexTo,
				Map<MyPoint, MyPoint> outMap) {
			this.inPoints = inPoints;
			this.indexFrom = indexFrom;
			this.indexTo = indexTo;
			this.outMap = outMap;
		}

		public void run() {

			for (int i = indexFrom; i <= indexTo; i++) {
				double minDist = Double.MAX_VALUE;
				MyPoint closestPoint = null;
				MyPoint first = inPoints.get(i);
				for (MyPoint p : inPoints) {
					if (first != p) {
						double currentDist = first.getDistanceSq(p);
						if (currentDist < minDist) {
							minDist = currentDist;
							closestPoint = p;
						}
						outMap.put(first, p);
					}
				}

			}
		}
	}

	public Thread doCalculations(List<MyPoint> inPoints, int indexFrom, int indexTo, Map<MyPoint, MyPoint> outMap) {
		// calculatingThreadRange ctr =new calculatingThreadRange(inPoints,
		// indexFrom, indexTo, outMap);
		Thread ttr = new Thread(new calculatingThreadRange(inPoints, indexFrom, indexTo, outMap));
		ttr.start();
		return ttr;
	}

	public Map<MyPoint, MyPoint> calculationsRangedThreads(List<MyPoint> inPoints, int numberOfThreads) {
		Map<MyPoint, MyPoint> outMap = new ConcurrentHashMap<MyPoint, MyPoint>();
		ArrayList<Thread> ThreadArray = new ArrayList<Thread>();
		Thread newThread = null;
		int ThreadRange = inPoints.size() / numberOfThreads;

		for (int i = 0; i < numberOfThreads - 1; i++) {
			newThread = doCalculations(inPoints, i * ThreadRange, (i + 1) * ThreadRange - 1, outMap);
			ThreadArray.add(newThread);

		}
		newThread = doCalculations(inPoints, (numberOfThreads - 1) * ThreadRange, inPoints.size() - 1, outMap);
		ThreadArray.add(newThread);
		for (int i = 0; i < ThreadArray.size(); i++) {
			while (ThreadArray.get(i).isAlive())
				;
		}
		// System.out.println(outMap.size());
		return outMap;
	}

	synchronized public boolean ifPointIsAvailable(MyPoint p, Map<MyPoint, MyPoint> outMap, MyPoint closestPoint) {
		if (closestPoint == null) {
			if (!outMap.containsKey(p)) {
				outMap.put(p, null);
				notify();
				return true;
			}
			notify();
			return false;
		} else {
			outMap.put(p, closestPoint);
			notify();
			return false;
		}
	}

	public class CalculatingThread implements Runnable {

		List<MyPoint> inPoints;
		Map<MyPoint, MyPoint> outMap;

		public CalculatingThread(List<MyPoint> inPoints, Map<MyPoint, MyPoint> outMap) {
			this.inPoints = inPoints;
			this.outMap = outMap;
		}

		public void run() {

			for (int i = 0; i < inPoints.size(); i++) {
				if (!inPoints.get(i).setAvailabilityToTrue()) {
					continue;
				}
				double minDist = Double.MAX_VALUE;
				MyPoint closestPoint = null;
				MyPoint first = inPoints.get(i);
				for (MyPoint p : inPoints) {
					if (first != p) {
						double currentDist = first.getDistanceSq(p);
						if (currentDist < minDist) {
							minDist = currentDist;
							closestPoint = p;
						}

					}
				}
				synchronized(outMap){outMap.put(first, closestPoint);}
			}
		}
	}

	public Map<MyPoint, MyPoint> doCalculationsWhole(List<MyPoint> inPoints, int numberOfThreads) {
		Map<MyPoint, MyPoint> outMap = new HashMap<MyPoint, MyPoint>();

		Thread[] ThreadArray = new Thread[numberOfThreads];
		for (int i = 0; i < numberOfThreads; i++) {
			ThreadArray[i] = new Thread(new CalculatingThread(inPoints, outMap));
			ThreadArray[i].start();
		}

		for (int i = 0; i < numberOfThreads; i++) {
			while (ThreadArray[i].isAlive())
				;
		}

		return outMap;
	}

	private static class MyPoint {
		double x;
		double y;

		public AtomicBoolean isTaken;

		public MyPoint(double x, double y) {
			this.x = x;
			this.y = y;
			isTaken=new AtomicBoolean(false);//.getAndSet(false);
		}

		synchronized public Boolean setAvailabilityToTrue() {
			if (isTaken.get() == false) {
				isTaken.set(true);

				return true;
			}
			return false;
		}

		public double getDistanceSq(MyPoint p) {
			return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}

	}

	public static void main(String[] args) {
		PointCalculations pc = new PointCalculations();
		long startTime = System.currentTimeMillis();

		 pc.getNearestPoints(generatePoints());

		// System.out.println("Time elapsed:
		// "+(System.currentTimeMillis()-startTime)/1000.0);

		// pc.calculationsRangedThreads(generatePoints(), 10);
		Map<MyPoint, MyPoint> outMap = pc.doCalculationsWhole(generatePoints(), 7);
		System.out.println(outMap.size());

		System.out.println("Time elapsed: " + (System.currentTimeMillis() - startTime) / 1000.0);
	}
}
