package creator;

import core.NaturalNumber;
import ladder.LadderSize;
import ladder.Row;

public interface LadderCreator {
	void drawLine(NaturalNumber row, NaturalNumber col);
	Row[] getRows();

	LadderSize getLadderSize();
}
