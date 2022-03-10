package core;

import java.util.Objects;

public class NaturalNumber {
	private int number;

	public NaturalNumber(int number) {
		if (number < 1) {
			throw new IllegalArgumentException(String.format(
					"자연수는 1이상이어야 함. 현재 값은: %d", number
			));
		}
		this.number = number;
	}

	public static NaturalNumber createFromArrayIndex(int index) {
		return new NaturalNumber(index + 1);
	}

	public int getNumber() {
		return number;
	}

	public int toArrayIndex() {
		return number - 1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NaturalNumber number1 = (NaturalNumber) o;
		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	public NaturalNumber multiply(NaturalNumber operand) {
		return new NaturalNumber(this.number * operand.getNumber());
	}
}
