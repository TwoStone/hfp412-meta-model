package common;

import java.math.BigInteger;

public class Fraction {

	private static final BigInteger BIMinusOne = new BigInteger("-1");

	public static final Fraction Null = new Fraction(BigInteger.ZERO, BigInteger.ONE);

	private static final String FractionStroke = "/";

	public static Fraction parse(final String fraction) {

		BigInteger denominator = BigInteger.ONE;
		BigInteger enumarator = BigInteger.ONE;
		try {
			final int fractionStrokePosition = fraction.indexOf(FractionStroke);
			final String enumaratorText = fraction.substring(0, fractionStrokePosition);
			if (enumaratorText.length() > 0)
				enumarator = new BigInteger(enumaratorText);
			final String denominatorText = fraction.substring(fractionStrokePosition + FractionStroke.length(), fraction.length());
			if (denominatorText.length() > 0)
				denominator = new BigInteger(denominatorText);
		} catch (final IndexOutOfBoundsException iobe) {
			enumarator = new BigInteger(fraction);
		}
		if (denominator.equals(BigInteger.ZERO))
			throw new NumberFormatException(constants.ExceptionConstants.DENOMINATOR_MUST_NOT_BE_ZERO);
		return new Fraction(enumarator, denominator);

	}

	private final BigInteger enumerator;

	public BigInteger getEnumerator() {
		return enumerator;
	}

	public BigInteger getDenominator() {
		return denominator;
	}

	private final BigInteger denominator;

	public Fraction(final BigInteger enumarator, final BigInteger denominator) {
		if (denominator.equals(BigInteger.ZERO))
			throw new NumberFormatException(constants.ExceptionConstants.DENOMINATOR_MUST_NOT_BE_ZERO);
		final BigInteger gcd = enumarator.gcd(denominator);
		final boolean negativeDenominator = denominator.compareTo(BigInteger.ZERO) < 0;
		this.enumerator = enumarator.divide(gcd).multiply(negativeDenominator ? BIMinusOne : BigInteger.ONE);
		this.denominator = denominator.divide(gcd).multiply(negativeDenominator ? BIMinusOne : BigInteger.ONE);
	}

	@Override
	public String toString() {
		return this.getEnumerator().toString()
				+ (this.getDenominator().equals(BigInteger.ONE) ? "" : (FractionStroke + this.getDenominator().toString()));
	}

	public String toDecimal() {
		return "~" + this.getEnumerator().floatValue() / this.getDenominator().floatValue();
	}

	public Fraction invert() {
		return new Fraction(this.denominator, this.enumerator);
	}

	@Override
	public boolean equals(final Object argument) {
		if (argument instanceof common.Fraction) {
			final Fraction argumentAsFraction = (Fraction) argument;
			return this.getEnumerator().equals(argumentAsFraction.getEnumerator())
					&& this.getDenominator().equals(argumentAsFraction.getDenominator());
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.getEnumerator().multiply(this.getDenominator()).hashCode();
	}

	public Fraction mul(final Fraction fraction) throws Throwable {
		// TODO: implement logic...
		// e1/d1 * e2/d2 = finalize(finalize(e1/d2) * finalize(e2/d1))

		// Kreuzprodukt Bruch 1 und Kuerzen.
		final Fraction frac1 = new Fraction(this.enumerator, fraction.denominator);

		// Kreuzprodukt Bruch 2 und Kuerzen.
		final Fraction frac2 = new Fraction(fraction.enumerator, this.denominator);
		final Fraction result = new Fraction(frac1.enumerator.multiply(frac2.enumerator), frac1.denominator.multiply(frac2.denominator));

		return result;
	}

	public Fraction add(final Fraction fraction) throws Throwable {
		// TODO: implement logic...
		// // e1/d1 + e2/d2 = (e1*d2+e2*d1) / d1*d2 und finalize.

		final Fraction result = new Fraction(fraction.enumerator.multiply(denominator).add(this.enumerator.multiply(fraction.denominator)),
				this.denominator.multiply(fraction.denominator));
		return result;
	}

	public Fraction div(final Fraction divisor) throws Throwable {
		return this.mul(divisor.invert());
	}

	public Fraction sub(final Fraction minuend) throws Throwable {
		// TODO: implement logic...
		// e1/d1 - e2/d2 = (e1*d2 - e2*d1) / d1*d2 und finalize
		final Fraction result = new Fraction(this.getEnumerator().multiply(minuend.getDenominator())
				.subtract(minuend.getEnumerator().multiply(this.getDenominator())), this.getDenominator().multiply(minuend.getDenominator()));
		return result;
	}
}
