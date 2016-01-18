package _07_GiveMeMedian;

import java.awt.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

public class Test<T extends Number> implements Statistics {
	// private LinkedList<Integer> al = new LinkedList<Integer>();
	private ArrayList<Double> all = new ArrayList<Double>();
	private Hashtable<Double, Integer> ht = new Hashtable<>();
	private double sum = 0;
	private double mean = 0;
	private double median = 0;
	private double mode = 0;
	private double range = 0;

	public Test(Collection<T> s) {
		//System.out.println(s);
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (T n : s) {

			double n_double = n.doubleValue();

			all.add(n_double);
			sum += n_double;
			if (!ht.containsKey(n_double)) {
				ht.put(n_double, 1);
				//System.out.println("key: "+n_double);
				//System.out.println("value: "+ ht.get(n_double));
			} else {
				ht.put(n_double, ht.get(n_double) + 1);
				//System.out.println("--------------");
			}
			
			
			if (n_double < min) {
				min = n_double;
			}
			if (n_double > max) {
				max = n_double;
			}
		}
		
		//System.out.println(ht);
		
		//range=max-min;
		Collections.sort(all);
		range=all.get(all.size()-1)-all.get(0);
		mean = sum / s.size();
		if(all.size()%2!=0){
			median=all.get(all.size()/2);
		} else {
			median=(all.get(all.size()/2)+all.get(all.size()/2-1))/2;
		}
		//median = all.get(all.size() / 2); // correct it
		boolean flag = true;
		for (Double d : ht.keySet()) {
			if (flag) {
				mode = d;
				flag = false;
			} else {
				if (ht.get(d) > ht.get(mode)) {
					mode = d;
				}
			}
		} if(ht.get(mode)==1) {
			mode=Double.MIN_VALUE;   //min double value if no mode
		}

	}

	public Number getMean() {
		return mean;
	}

	public Number getMedian() {
		return median;

	}

	public Number getMode() {
		return mode;

	}

	public Number getRange() {
		return range;

	}
	public static void main(String[] args){
		//Set<Double> all = new HashSet<Double>(Arrays.asList(2.0,2.0,3.0,4.0,5.0));
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,4,74,50));
		System.out.println("a: "+A);
		Test<Integer> t= new Test<Integer>(A);
		System.out.println(t.getMean());
		System.out.println(t.getMedian());
		System.out.println(t.getMode());
		System.out.println(t.getRange());
		
		
	}
}
