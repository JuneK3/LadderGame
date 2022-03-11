package ladder;

import core.NaturalNumber;

public class LadderGame {

	enum LadderType {
		MANUAL, RANDOM;
	}

	private LadderCreator ladderCreator;

	public LadderGame(NaturalNumber cntOfRow, NaturalNumber noOfPerson) {
		ladderCreator = new RandomLadderCreator(cntOfRow, noOfPerson);
	}

	public LadderGame(NaturalNumber height, NaturalNumber noOfPerson, LadderType type) {
		if (type == LadderType.MANUAL) {
			ladderCreator = new ManualLadderCreator(height, noOfPerson);
		} else if (type == LadderType.RANDOM) {
			ladderCreator = new RandomLadderCreator(height, noOfPerson);
		}
	}

	public void drawLine(NaturalNumber row, NaturalNumber col) {
		ladderCreator.drawLine(row, col);
	}

	public Marker run(Marker nthPerson) {
		LadderRunner runner = new LadderRunner(ladderCreator.getRows());
		return runner.run(nthPerson);
	}
}
