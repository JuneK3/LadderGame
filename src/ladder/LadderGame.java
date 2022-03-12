package ladder;

import core.NaturalNumber;
import creator.LadderCreator;

public class LadderGame {

	private LadderCreator ladderCreator;

	public LadderGame(LadderCreator ladderCreator) {
		this.ladderCreator = ladderCreator;
	}

	public void drawLine(NaturalNumber row, NaturalNumber col) {
		ladderCreator.drawLine(row, col);
	}

	public Marker run(Marker nthPerson) {
		LadderRunner runner = new LadderRunner(ladderCreator.getRows());
		return runner.run(nthPerson);
	}
}
