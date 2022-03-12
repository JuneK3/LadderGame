package creator;

import core.NaturalNumber;
import ladder.LadderGame;

public class LadderCreatorFactory {
	static LadderGame randomLadderGame(NaturalNumber height, NaturalNumber noOfPerson){
		RandomLadderCreator ladderCreator = new RandomLadderCreator(height, noOfPerson);
		return new LadderGame(ladderCreator);
	}

	static LadderGame manualLadderGame(NaturalNumber height, NaturalNumber noOfPerson){
		ManualLadderCreator ladderCreator = new ManualLadderCreator(height, noOfPerson);
		return new LadderGame(ladderCreator);
	}
}
