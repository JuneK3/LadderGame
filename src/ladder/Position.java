package ladder;

import core.NaturalNumber;

import java.util.Objects;

public class Position {


	private NaturalNumber height;
	private NaturalNumber noOfPerson;

	private Position(NaturalNumber height, NaturalNumber noOfPerson) {
		this.height = height;
		this.noOfPerson = noOfPerson;
	}

	private Position(int height, int noOfPerson) {
		this(new NaturalNumber(height), new NaturalNumber(noOfPerson));
	}

	static Position create(NaturalNumber height, NaturalNumber noOfPerson) {
		return new Position(height, noOfPerson);
	}

	static Position create(int height, int noOfPerson) {
		return new Position(height, noOfPerson);
	}

	public static Position createFromArrayIndex(int height, int noOfPerson) {
		return new Position(NaturalNumber.createFromArrayIndex(height),
				NaturalNumber.createFromArrayIndex(noOfPerson));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return Objects.equals(height, position.height) && Objects.equals(noOfPerson, position.noOfPerson);
	}

	@Override
	public int hashCode() {
		return Objects.hash(height, noOfPerson);
	}

	@Override
	public String toString() {
		return String.format("Position [height=%s, noOfPerson=%s]", height, noOfPerson);
	}

	public NaturalNumber getHeight() {
		return this.height;
	}

	public NaturalNumber getNthOfPerson() {
		return this.noOfPerson;
	}
}
