package ladder;

public class Row {
	private enum Direction {
		LEFT(-1),
		CENTER(0),
		RIGHT(1);

		private int val;

		Direction(int val) {
			this.val = val;
		}

		private int getVal() {
			return val;
		}
	}

	private int[] cols;

	public Row(NaturalNumber noOfPerson) {
		cols = new int[noOfPerson.getNumber()];
	}

	public void drawLine(NaturalNumber startPosition) {
		int startIndex = startPosition.toArrayIndex();
		if (startIndex >= cols.length - 1) {
			throw new IllegalArgumentException(String.format(
					"선을 그릴수 있는 위치는 %d 미만이어야 합니다. 현재값: %d", cols.length, startPosition.getNumber()
			));
		}

		if (cols[startIndex] == -1) {
			throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");
		}

		cols[startIndex] = Direction.RIGHT.getVal();
		cols[startIndex + 1] = Direction.LEFT.getVal();
	}

	public Marker move(Marker nthPerson) {
		if (nthPerson.toArrayIndex() > cols.length - 1) {
			throw new IllegalArgumentException(String.format(
					"시작점은 %d 이하여야 합니다. 현재값: %d", cols.length, nthPerson.getNumber()
			));
		}

		if (hasNoLine(nthPerson.toArrayIndex())) {
			return nthPerson;
		}

		if (hasRightLine(nthPerson.toArrayIndex())) {
			return nthPerson.moveRight();
		}

		return nthPerson.moveLeft();
	}

	private boolean hasRightLine(int nthPerson) {
		return cols[nthPerson] == 1;
	}

	private boolean hasNoLine(int nthPerson) {
		return cols[nthPerson] == Direction.CENTER.getVal();
	}

}
