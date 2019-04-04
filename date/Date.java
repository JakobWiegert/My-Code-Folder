package programming.set6.date;

/**
 * this class allow you to use dates in java.
 * 
 * @author Jakob Wiegert
 *
 */
public class Date {
	private int year;
	private int month;
	private int day;

	/**
	 * this method gives you the number of days.
	 * 
	 * @param year
	 *            the year in which your month is
	 * @param month
	 *            the month you want the days
	 * @return days
	 */
	static public int getDaysInMonth(int year, int month) {
		int[] daysInMonth = new int[13];

		daysInMonth[1] = daysInMonth[3] = daysInMonth[5] = daysInMonth[7] = daysInMonth[8] = daysInMonth[10] = daysInMonth[12] = 31;
		daysInMonth[4] = daysInMonth[6] = daysInMonth[9] = daysInMonth[11] = 30;

		if (year % 4 == 0 & (year % 100 != 0 | year % 400 == 0)) {
			daysInMonth[2] = 29;
		} else {
			daysInMonth[2] = 28;
		}

		if (1 <= month & month <= 12) {

			return daysInMonth[month];

		} else {

			return 0;
		}

	}

	/**
	 * this validates a day in a month in a year.
	 * 
	 * @param year
	 *            the year of the month
	 * @param month
	 *            the month of the day
	 * @param day
	 *            the tested day
	 * @return a boolean
	 */
	static public boolean validate(int year, int month, int day) {
		int[] dayOfMonth31 = new int[32];
		int[] dayOfMonth30 = new int[31];
		int[] dayOfMonth28 = new int[29];
		int[] dayOfMonth29 = new int[30];
		boolean valid = false;
		for (int i = 1; i <= 31; i++) {
			dayOfMonth31[i] = i;
		}
		for (int i = 1; i <= 30; i++) {
			dayOfMonth30[i] = i;
		}
		for (int i = 1; i <= 28; i++) {
			dayOfMonth28[i] = i;
		}
		for (int i = 1; i <= 29; i++) {
			dayOfMonth29[i] = i;
		}
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			for (int j = 1; j <= 31; j++) {
				if (day == dayOfMonth31[j]) {
					valid = true;
				}

			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			for (int j = 1; j <= 30; j++) {
				if (day == dayOfMonth30[j]) {
					valid = true;
				}
			}
		} else if (month == 2) {
			if (year % 4 == 0 & (year % 100 != 0 | year % 400 == 0)) {
				for (int j = 1; j <= 29; j++) {
					if (day == dayOfMonth29[j]) {
						valid = true;
					}
				}
			} else {
				for (int j = 1; j <= 28; j++) {
					if (day == dayOfMonth28[j]) {
						valid = true;
					}
				}
			}
		}
		return valid;
	}

	/**
	 * this is the constructor for a date.
	 * 
	 * @param ye
	 *            the year of the date
	 * @param mo
	 *            the month of the date
	 * @param d
	 *            the day of the date
	 */
	public Date(int ye, int mo, int d) {
		if (validate(ye, mo, d)) {
			year = ye;
			month = mo;
			day = d;
		} else {
			throw new IllegalArgumentException("This is not a valid date.");
		}
	}

	/**
	 * gives you the day of the date.
	 * 
	 * @return a day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * gives you the month of the date.
	 * 
	 * @return a month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * gives you the year of the Date.
	 * 
	 * @return a year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * gives you the number of days from the 1. januar to the date.
	 * 
	 * @return number of days
	 */
	public int dayOfYear() {
		int daysBefore = 0;
		for (int i = 1; i < month; i++) {
			daysBefore += getDaysInMonth(year, i);
		}
		return day + daysBefore;
	}

	/**
	 * this counts the days between two dates.
	 * 
	 * @param other
	 *            the other Date
	 * @return days
	 */
	public int sameYearDiff(Date other) {
		if (year != other.year) {
			return 0;
		} else {
			int daysBefore = 0;
			for (int i = 1; i < other.month; i++) {
				daysBefore += getDaysInMonth(other.year, i);
			}
			int iOther = other.day + daysBefore;

			return iOther - dayOfYear();
		}
	}

	/**
	 * this is a to string method for dates.
	 * 
	 * @return a string
	 */
	public String toString() {
		String[] months = new String[13];
		months[1] = "Januar";
		months[2] = "Februar";
		months[3] = "March";
		months[4] = "April";
		months[5] = "Mai";
		months[6] = "Juni";
		months[7] = "Juli";
		months[8] = "August";
		months[9] = "September";
		months[10] = "October";
		months[11] = "November";
		months[12] = "December";

		return months[month] + day + "," + year;
	}
}
