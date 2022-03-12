package core;

public class RandomNaturalNumber extends NaturalNumber {
	public RandomNaturalNumber(int number) {
		super(number);
	}

	public int getPositionOfHeight(int noOfPerson) {
		double quotient = Math.ceil(getNumber() / (double) noOfPerson);
		return (int) quotient;
	}

	public int getPositionOfPerson(int noOfPerson) {
		int remainder = getNumber() % noOfPerson;
		if (remainder == 0) {
			return noOfPerson;
		}
		return remainder;
	}

	public boolean isMultipleOfPerson(int noOfPerson) {
		int remainder = getNumber() % noOfPerson;
		if (remainder == 0) {
			return true;
		}
		return false;
	}
}
