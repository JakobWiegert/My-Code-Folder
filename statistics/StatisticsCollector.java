package programming.set7.statistics;

import java.util.*;

/**
 * statistics oh my giddy Aunt ! .
 * 
 * @author Jakob Wiegert
 *
 */
public class StatisticsCollector {

	ArrayList<Double> list = new ArrayList<Double>();

	/**
	 * adds a number to the list.
	 * 
	 * @param item
	 *            the double to add
	 */
	public void addItem(double item) {
		list.add(item);
	}

	/**
	 * gives the number of numbers.
	 * 
	 * @return an integer
	 */
	public int getCount() {
		return list.size();
	}

	/**
	 * adds all numbers in the list.
	 * 
	 * @return an double
	 */
	public double getSum() {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}

	/**
	 * gives the number with the lowest value.
	 * 
	 * @return an double
	 */
	public double getMinimum() {
		double min = Double.POSITIVE_INFINITY;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
			}
		}
		return min;
	}

	/**
	 * gives the number with the highest value.
	 * 
	 * @return an double
	 */
	public double getMaximum() {
		double max = Double.NEGATIVE_INFINITY;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}
		return max;
	}

	/**
	 * gives the average of all numbers.
	 * 
	 * @return an double
	 */
	public double getAverage() {
		if (list.isEmpty()) {
			return 0;
		} else {
			return getSum() / list.size();
		}
	}

	/**
	 * gives the standart deviation of the numbers.
	 * 
	 * @return a double
	 */
	public double getStandardDeviation() {

		if (getCount() != 0) {

			double varz = 0;

			double mean = getAverage();

			for (int i = 0; i < list.size(); i++) {
				varz = varz + Math.pow((list.get(i) - mean), 2);

			}

			double var = varz / getCount();
			double sd = Math.sqrt(var);
			return sd;
		} else {
			return 0;
		}
	}

}
