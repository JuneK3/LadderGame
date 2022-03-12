package creator;

import core.NaturalNumber;
import ladder.LadderSize;
import ladder.Row;

public class ManualLadderCreator implements LadderCreator {
	private Row[] rows;
	private LadderSize ladderSize;

	public ManualLadderCreator(NaturalNumber height, NaturalNumber noOfPerson) {
		ladderSize = LadderSize.create(height, noOfPerson);
		rows = new Row[height.getNumber()];
		for (int i = 0; i < height.getNumber(); i++) {
			rows[i] = new Row(noOfPerson);
		}
	}

	private boolean rowIsOverLimit(NaturalNumber row) {
		return row.toArrayIndex() > rows.length - 1;
	}

	@Override
	public void drawLine(NaturalNumber row, NaturalNumber col) {
		if (rowIsOverLimit(row)) {
			throw new IllegalArgumentException(String.format(
					"사다리 최대 높이를 넘어섰습니다. 현재 값 : %d", row.getNumber()
			));
		}
		rows[row.toArrayIndex()].drawLine(col);
	}

	@Override
	public Row[] getRows() {
		return this.rows;
	}

	public LadderSize getLadderSize() {
		return ladderSize;
	}
}
