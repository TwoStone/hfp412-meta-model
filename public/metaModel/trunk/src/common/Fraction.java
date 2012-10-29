package common;

import java.math.BigInteger;

public class Fraction {

	private static final BigInteger BIZero = new BigInteger("0");
	private static final BigInteger BIOne = new BigInteger("1");
	private static final BigInteger BIMinusOne = new BigInteger("-1");
	
	public static final Fraction Null = new Fraction(BIZero, BIOne);
	
	private static final String FractionStroke = "/";

	public static Fraction parse(String fraction) {
		
		BigInteger denominator = BIOne;
		BigInteger enumarator = BIOne;
		try {
			int fractionStrokePosition = fraction.indexOf(FractionStroke);
			String enumaratorText = fraction.substring(0,fractionStrokePosition);
			if (enumaratorText.length() > 0) enumarator = new BigInteger(enumaratorText);
			String denominatorText = fraction.substring(fractionStrokePosition + FractionStroke.length(), fraction.length());
			if (denominatorText.length() > 0) denominator = new BigInteger(denominatorText);
		} catch (IndexOutOfBoundsException iobe){
			enumarator = new BigInteger(fraction);
		}
		if (denominator.equals(BIZero)) throw new NumberFormatException("Denominator must not be zero!");
		return new Fraction(enumarator,denominator);
	}

	private BigInteger enumerator;
	private BigInteger getEnumerator() {
		return enumerator;
	}
	private BigInteger getDenominator() {
		return denominator;
	}

	private BigInteger denominator;

	public Fraction(BigInteger enumarator, BigInteger denominator) {
		BigInteger gcd = enumarator.gcd(denominator);
		boolean negativeDenominator = denominator.compareTo(BIZero) < 0;
		this.enumerator = enumarator.divide(gcd).multiply(negativeDenominator ? BIMinusOne : BIOne);
		this.denominator = denominator.divide(gcd).multiply(negativeDenominator ? BIMinusOne : BIOne);
	}
	public String toString(){
		return this.getEnumerator().toString() + (this.getDenominator().equals(BIOne) ? "" : (FractionStroke + this.getDenominator().toString())); 
	}

	public boolean equals(Object argument){
		if (argument instanceof common.Fraction){
			Fraction argumentAsFraction = (Fraction) argument;
			return this.getEnumerator().equals(argumentAsFraction.getEnumerator()) && this.getDenominator().equals(argumentAsFraction.getDenominator());
		} else {
			return false;
		}
	}
	public int hashCode(){
		return this.getEnumerator().multiply(this.getDenominator()).hashCode();
	}
}
