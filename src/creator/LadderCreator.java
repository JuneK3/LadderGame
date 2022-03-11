package creator;

import core.NaturalNumber;
import ladder.Row;

public interface LadderCreator {
	void drawLine(NaturalNumber row, NaturalNumber col);
	Row[] getRows();
}
