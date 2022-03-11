package ladder;

import core.NaturalNumber;
import creator.LadderCreator;
import creator.LadderCreatorFactory;
import creator.LadderCreatorFactory.LadderType;

public class LadderGame {

	private LadderCreator ladderCreator;

	public LadderGame(NaturalNumber height, NaturalNumber noOfPerson, LadderType type) {
		ladderCreator = LadderCreatorFactory.newLadderCreator(height, noOfPerson, type);
	}

	public void drawLine(NaturalNumber row, NaturalNumber col) {
		ladderCreator.drawLine(row, col);
	}

	public Marker run(Marker nthPerson) {
		LadderRunner runner = new LadderRunner(ladderCreator.getRows());
		return runner.run(nthPerson);
	}
}
