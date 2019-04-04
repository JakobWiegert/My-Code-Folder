/**
 * This program let you use ComplexNumbers in Java it can: create
 * ComplexNumber,. add them, subtract them, multiply them, divide them, get the
 * real and the imaginary part, get the absolut value, return a ComplexNumber as
 * a String
 * 
 * @author Jakob Wiegert
 *
 */
public class ComplexNumber {

	private double re;
	private double im;

	/**
	 * set re and im to 0.
	 */
	public ComplexNumber() {
		re = 0;
		im = 0;

	}

	/**
	 * set re and im to the given values c=r+b*i.
	 * 
	 * @param real
	 *            value of the real part: r
	 * @param imaginary
	 *            value of the imaginary part: b
	 */
	public ComplexNumber(double real, double imaginary) {

		re = real;
		im = imaginary;
	}

	/**
	 * set re and im to the value of a given ComplexNumber.
	 * 
	 * @param cn
	 *            a ComplexNumber
	 */
	public ComplexNumber(ComplexNumber cn) {
		re = cn.re;
		im = cn.im;
	}

	/**
	 * return the the real part of the ComplexNumber.
	 * 
	 * @return real part
	 */
	public double getReal() {
		return re;
	}

	/**
	 * return the imaginary part of the ComplexNumber.
	 * 
	 * @return return imaginary part
	 */
	public double getImaginary() {
		return im;
	}

	/**
	 * return the conjugate of the last ComplexNumber c` = r - b*i.
	 * 
	 * @return a ComplexNumber
	 */
	public ComplexNumber conjugate() {

		return new ComplexNumber(re, -im);
	}

	/**
	 * This add the last ComplexNumber with the parameter.
	 * 
	 * @param other
	 *            ComplexNumber that will be added
	 * @return a ComplexNumber
	 */
	public ComplexNumber add(ComplexNumber other) {
		return new ComplexNumber(re + other.re, im + other.im);
	}

	/**
	 * This subtracts the last ComplexNumber with the parameter.
	 * 
	 * @param other
	 *            ComplexNumber that will be subtracted
	 * @return a ComplexNumber
	 */
	public ComplexNumber subtract(ComplexNumber other) {
		return new ComplexNumber(re - other.re, im - other.im);
	}

	/**
	 * This multiply the last ComplexNumber with the parameter.
	 * 
	 * @param other
	 *            ComplexNumber that will be multiplied
	 * @return a ComplexNumber
	 */
	public ComplexNumber multiply(ComplexNumber other) {
		return new ComplexNumber(re * other.re - im * other.im, im * other.re + re * other.im);
	}

	/**
	 * This divide the last ComplexNumber with the parameter.
	 * 
	 * @param other
	 *            ComplexNumber that will be used to divide
	 * @return a ComplexNumber
	 */
	public ComplexNumber divide(ComplexNumber other) {

		if (other.re != 0 || other.im != 0) {
			return new ComplexNumber((re * other.re + im * other.im) / (other.im * other.im + other.re * other.re),
					(im * other.re - re * other.im) / (other.im * other.im + other.re * other.re));
		} else {
			return null;
		}
	}

	/**
	 * return the absolute value of the last ComplexNumber.
	 * 
	 * @return the absolute value as an double
	 */
	public double abs() {
		return Math.sqrt(re * re + im * im);
	}

	/**
	 * transform a ComplexNumber in a String.
	 * 
	 * @return ComplexNumber as a String
	 */
	public String toString() {
		return "" + re + "+" + im + "i";
	}
}
