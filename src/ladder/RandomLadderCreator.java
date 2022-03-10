package ladder;

import core.NaturalNumber;

import java.util.Random;

public class RandomLadderCreator {
	public static final double DEFAULT_LINE_RATIO = 0.3;
	private Row[] rows;
	private NaturalNumber totalPositions;

	RandomLadderCreator(NaturalNumber cntOfRow, NaturalNumber noOfPerson) {
		totalPositions = cntOfRow.multiply(noOfPerson);
		rows = new Row[cntOfRow.getNumber()];
		for (int i = 0; i < cntOfRow.getNumber(); i++) {
			rows[i] = new Row(noOfPerson);
		}
	}

	void drawLine(NaturalNumber row, NaturalNumber col) {
		if (rowIsOverLimit(row)) {
			throw new IllegalArgumentException(String.format(
					"사다리 최대 높이를 넘어섰습니다. 현재 값 : %d", row.getNumber()
			));
		}
		rows[row.toArrayIndex()].drawLine(col);
	}

	private boolean rowIsOverLimit(NaturalNumber row) {
		return row.toArrayIndex() > rows.length - 1;
	}

	Row[] getRows() {
		return this.rows;
	}

	static int getCountOfLine(NaturalNumber counts, double ratio) {
		return (int) (counts.getNumber() * ratio);
	}

	static int randInt(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	int[] generatePositions() {
		int countOfLine = getCountOfLine(totalPositions, DEFAULT_LINE_RATIO);
		int[] startPositions = new int[countOfLine];
		for (int i=0; i<startPositions.length; i++){
			startPositions[i] = randInt(1, totalPositions.getNumber());
		}
		return startPositions;
	}
}
