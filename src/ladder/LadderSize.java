package ladder;

import core.NaturalNumber;

public class LadderSize {
	private NaturalNumber height;
	private NaturalNumber noOfPerson;

	private LadderSize(NaturalNumber height, NaturalNumber noOfPerson) {
		this.height = height;
		this.noOfPerson = noOfPerson;
	}

	public static LadderSize create(int height, int noOfPerson) {
		return create(new NaturalNumber(height), new NaturalNumber(noOfPerson));
	}

	public static LadderSize create(NaturalNumber height, NaturalNumber noOfPerson) {
		return new LadderSize(height, noOfPerson);
	}

	NaturalNumber getPositionOfHeight(NaturalNumber currentTotalPositions) {
		double quotient = Math.ceil(currentTotalPositions.getNumber() / (double) noOfPerson.getNumber());
		return new NaturalNumber((int) quotient);
	}

	NaturalNumber getPositionOfPerson(NaturalNumber currentTotalPositions) {
		int remainder = currentTotalPositions.getNumber() % noOfPerson.getNumber();
		if (remainder == 0) {
			return noOfPerson;
		}
		return new NaturalNumber(remainder);
	}

	public Position getPosition(NaturalNumber currentTotalPosition){
		return Position.create(getPositionOfHeight(currentTotalPosition), getPositionOfPerson(currentTotalPosition));
	}

	public NaturalNumber getHeight() {
		return this.height;
	}

	public NaturalNumber getNoOfPerson() {
		return this.noOfPerson;
	}

	public int getCountOfLine(double ratio) {
		NaturalNumber totalPositions = getTotalPosition();
		return (int) (totalPositions.getNumber() * ratio);
	}

	public NaturalNumber getTotalPosition() {
		return height.multiply(noOfPerson);
	}

	public boolean isMultipleOfPerson(NaturalNumber randomPosition) {
		int remainder = randomPosition.getNumber() % noOfPerson.getNumber();
		if (remainder == 0){
			return true;
		}
		return false;
	}
}
