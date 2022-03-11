package ladder;

import core.NaturalNumber;

public class LadderGame {
//	private LadderCreator ladderCreator;
	private RandomLadderCreator ladderCreator;

	public LadderGame(NaturalNumber cntOfRow, NaturalNumber noOfPerson) {
		ladderCreator = new RandomLadderCreator(cntOfRow, noOfPerson);
	}

	public void drawLine(NaturalNumber row, NaturalNumber col) {
		ladderCreator.drawLine(row, col);
	}

	public Marker run(Marker nthPerson) {
		LadderRunner runner = new LadderRunner(ladderCreator.getRows());
		return runner.run(nthPerson);
	}
}
