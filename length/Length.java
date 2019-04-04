package programming.set9.length;

/**
 * this is cool stuff about useless non-metric systems!.
 * 
 * @author Jakob Wiegert
 *
 */
public enum Length {
	ARSHIN(0.71), FINGER(0.022225), METRE(1), HORSE_LENGTH(2.4), PARSEC(30856776000000000.0), PLUTO_RADIUS(1186000);

	private final double lengthInMeters;

	/**
	 * the constructor.
	 * 
	 * @param lengthInMeters
	 *            the amount of meters
	 */
	Length(double lengthInMeters) {
		this.lengthInMeters = lengthInMeters;
	}

	/**
	 * Returns how much one of this unit is in metres.
	 * 
	 * @return one unit in metres.
	 */
	public double getUnitLengthInMetres() {
		return lengthInMeters;
	}

	/**
	 * Converts the given amount measured in the current length unit to how much it
	 * would be in the target unit.
	 * 
	 * @param targetLength
	 *            the target unit of length.
	 * @param amount
	 *            the length to convert to the target length.
	 * @return the corresponding length in the target unit.
	 */
	public double convertTo(Length targetLength, double amount) {
		double meter = amount * this.lengthInMeters; // umrechnung in Meter
		return meter / targetLength.lengthInMeters;
	}

}
