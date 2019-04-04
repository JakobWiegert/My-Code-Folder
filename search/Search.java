package ads.set1.search;

public class Search {

	/**
	 * Looks for the given element (the "needle") in the given array (the "hay")
	 * using a linear search algorithm.
	 * 
	 * @param hay
	 *            array to search for the needle, sorted in ascending order.
	 * @param needle
	 *            the value to search for in the array.
	 * @return index of the needle in the array, if it could be found, or {@code -1}
	 *         otherwise.
	 */
	public static int linearSearch(int[] hay, int needle) { // O(hayLength) , da es einmal durch hay.length geht

		int hayLength = hay.length;

		for (int i = 0; i < hayLength; i++) {

			if (hay[i] == needle) {

				return i;

			}

		}

		return -1;
	}

	/**
	 * Looks for the given element (the "needle") in the given array (the "hay")
	 * using a binary search algorithm.
	 * 
	 * @param hay
	 *            array to search for the needle, sorted in ascending order.
	 * @param needle
	 *            the value to search for in the array.
	 * @return index of the needle in the array, if it could be found, or {@code -1}
	 *         otherwise.
	 */
	public static int binarySearch(int[] hay, int needle) { // O(log2(n)), da er immer den gesuchten bereich halbiert,
															// bei jeden Durchlauf

		int n = hay.length;
		int i = 0;
		int j = n - 1;
		int mid = -1;
		boolean found = false;
		while ((i <= j) & !(found)) {
			mid = (i + j) / 2;
			if (needle < hay[mid]) {
				j = mid - 1;
			} else if (needle > hay[mid]) {
				i = mid + 1;
			} else {
				found = true;
			}
		}

		if (found) {
			return mid;
		} else {
			return -1;
		}

	}

	public static void main(String args[]) {

		int array[] = new int[10];

		for (int i = 0; i < 10; i++) {
			array[i] = i;
		}
		
		array[8]= 100;

		System.out.print(linearSearch(array, 100));
		System.out.print(binarySearch(array, 100));

	}

}
