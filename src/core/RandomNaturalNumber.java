package core;

import java.util.ArrayList;

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

	public RandomNaturalNumber before() {
		return new RandomNaturalNumber(toArrayIndex());
	}

	public RandomNaturalNumber next() {
		return new RandomNaturalNumber(getNumber() + 1);
	}

	public ArrayList<RandomNaturalNumber> checkedNaturalNumbers(NaturalNumber noOfPerson) {
		ArrayList<RandomNaturalNumber> naturalNumbers = new ArrayList<>();
		int remainder = getNumber() % noOfPerson.getNumber();
		if (!isFirst(remainder)) {
			naturalNumbers.add(before());
		}
		naturalNumbers.add(this);
		naturalNumbers.add(next());
		return naturalNumbers;
	}
}
