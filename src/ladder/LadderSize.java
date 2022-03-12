package ladder;

import core.NaturalNumber;
import core.RandomNaturalNumber;

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

	public Position getPosition(RandomNaturalNumber currentTotalPosition){
		int positionOfHeight = currentTotalPosition.getPositionOfHeight(noOfPerson.getNumber());
		int positionOfPerson = currentTotalPosition.getPositionOfPerson(noOfPerson.getNumber());
		return Position.create(positionOfHeight, positionOfPerson);
	}

	public int getCountOfLine(double ratio) {
		NaturalNumber totalPositions = getTotalPosition();
		return (int) (totalPositions.getNumber() * ratio);
	}

	public NaturalNumber getTotalPosition() {
		return height.multiply(noOfPerson);
	}

	public boolean isMultipleOfPerson(RandomNaturalNumber randomPosition) {
		return randomPosition.isMultipleOfPerson(noOfPerson.getNumber());
	}
}
