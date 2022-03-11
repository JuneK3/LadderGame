package ladder;

import core.NaturalNumber;

public interface LadderCreator {
	void drawLine(NaturalNumber row, NaturalNumber col);
	Row[] getRows();
}
