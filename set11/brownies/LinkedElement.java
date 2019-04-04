package programming.set11.brownies;

/**
 * This is a array, just more complicated.
 * 
 * @author Jakob Wiegert
 *
 * @param <T>
 *            this is a vaiable for the type
 */
public class LinkedElement<T> {

	private T value;
	private LinkedElement<T> lE;

	/**
	 * This is the constructor.
	 * 
	 * @param value
	 *            the value
	 */
	public LinkedElement(T value) {
		this.value = value;
	}

	/**
	 * Returns the value of the i-th linked element, assuming the current element to
	 * be at index 0.
	 * 
	 * @param i
	 *            0-based index of the element whose value to return.
	 * @return the i-th element's value, or {@code null} if there is no element with
	 *         that index.
	 */
	public T get(int i) {
		if (i > 0) {
			if (lE == null) {
				return null;
			} else {
				return lE.get(i - 1);
			}
		} else if (i == 0) {
			return this.value;
		} else {
			return null;
		}

	}

	/**
	 * Sets the value of the i-th linked element to the given value. If there is no
	 * i-Yth linked element, nothing happens.
	 * 
	 * @param i
	 *            0-based index of the element whose value to set.
	 * @param newVal
	 *            the new value to set.
	 */
	public void set(int i, T newVal) {
		if (i > 0) {
			if (lE == null) {

			} else {
				lE.set(i - 1, newVal);
			}

		} else if (i == 0) {
			this.value = newVal;
		} else {

		}
	}

	/**
	 * Returns the index of the first occurrence of a linked element carrying the
	 * given value in the list.
	 * 
	 * @param val
	 *            the value to search for.
	 * @return index where the value was found, or -1 if it's not in any of the
	 *         linked elements.
	 */
	public int firstIndexOf(T val) {

		int i = 0;

		while (true) {

			if (this.get(i) == val) {
				return i;
			}
			i++;

			if (this.get(i) == null) {
				return -1;
			}
		}

	}

	/**
	 * Adds a new linked element holding the given value at the end of the linked
	 * elements.
	 * 
	 * @param newVal
	 *            the new value.
	 */
	public void add(T newVal) {

		if (this.lE == null) {
			this.lE = new LinkedElement<T>(newVal);
		} else {
			lE.add(newVal);
		}

	}

	/**
	 * Removes the i-th element from the linked elements. If {@code i == 0}, this
	 * will effectively remove the head element. Thus, this method returns the
	 * linked element that is the new head element.
	 * 
	 * @param i
	 *            index of the element to remove.
	 * @return the new head element.
	 */
	public LinkedElement<T> remove(int i) {

		if (i == 0) {
			if (lE == null) {
				return null;
			} else {
				return this.lE;
			}
		} else if (i < 0) {
			return null;
		} else {
			if (i == 1) {
				if (lE != null) {
					if (lE.lE == null) {
						lE = null;
					} else {
						lE = lE.lE;
					}
				}

				return null;
			} else {
				if (lE == null) {
					return null;
				} else {
					lE.remove(i - 1);
					return null;
				}
			}
		}

	}

}