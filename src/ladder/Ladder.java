package ladder;

import core.NaturalNumber;

public class Ladder {
	private Row[] rows;

	public Ladder(NaturalNumber cntOfRow, NaturalNumber noOfPerson) {
		rows = new Row[cntOfRow.getNumber()];
		for (int i = 0; i < cntOfRow.getNumber(); i++) {
			rows[i] = new Row(noOfPerson);
		}
	}

	public void drawLine(NaturalNumber row, NaturalNumber col) {
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

	public Marker run(Marker nthPerson) {
		for (int i = 0; i < rows.length; i++) {
			Row row = rows[i];
			nthPerson = row.move(nthPerson);
		}
		return nthPerson;
	}
}
