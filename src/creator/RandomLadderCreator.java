package creator;

import core.NaturalNumber;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
	public static final double DEFAULT_LINE_RATIO = 0.3;
	private LadderSize ladderSize;
	private LadderCreator ladderCreator;

	public RandomLadderCreator(LadderCreator ladderCreator) {
		this.ladderCreator = ladderCreator;
		this.ladderSize = ladderCreator.getLadderSize();

		Position[] startPositions = generateStartPositions();
		for (Position position : startPositions) {
			ladderCreator.drawLine(position.getHeight(), position.getNthOfPerson());
		}
	}

	public Row[] getRows(){
		return ladderCreator.getRows();
	}

	@Override
	public LadderSize getLadderSize() {
		return this.ladderSize;
	}

	@Override
	public void drawLine(NaturalNumber row, NaturalNumber col) {
		throw new UnsupportedOperationException("RandomLadderCreator에서는 drawLine 메소드를 호출할 수 없습니다.");
	}

	public static boolean isExisted(NaturalNumber[] startPositions, NaturalNumber randomPosition) {
		for (NaturalNumber each : startPositions) {
			if (randomPosition.equals(each)) {
				return true;
			}
		}
		return false;
	}

	public Position[] generateStartPositions() {
		NaturalNumber[] numbers = generateRandomPositions();
		return toPositions(numbers);
	}

	private NaturalNumber[] generateRandomPositions() {
		NaturalNumber totalPositions = ladderSize.getTotalPosition();
		int countOfLine = ladderSize.getCountOfLine(DEFAULT_LINE_RATIO);
		NaturalNumber[] startPositions = new NaturalNumber[countOfLine];
		int i = 0;

		do {
			NaturalNumber randomPosition = randInt(1, totalPositions.getNumber());
			if (ladderSize.isMultipleOfPerson(randomPosition)) {
				continue;
			}
			if (isExisted(startPositions, randomPosition)) {
				continue;
			}
			if (isExisted(startPositions, new NaturalNumber(randomPosition.getNumber() + 1))) {
				continue;
			}
			if (randomPosition.equals(new NaturalNumber(1))) {
				startPositions[i] = randomPosition;
				System.out.println(String.format("random position: %s", startPositions[i]));
				i++;
			} else {
				if (isExisted(startPositions, new NaturalNumber(randomPosition.getNumber() - 1))) {
					continue;
				}
				startPositions[i] = randomPosition;
				System.out.println(String.format("random position: %s", startPositions[i]));
				i++;
			}
		} while (i < countOfLine);

		return startPositions;
	}

	Position[] toPositions(NaturalNumber[] positions) {
		Position[] startPositions = new Position[positions.length];
		for (int i = 0; i < positions.length; i++) {
			startPositions[i] = ladderSize.getPosition(positions[i]);
		}
		return startPositions;
	}

	static NaturalNumber randInt(int min, int max) {
		Random rand = new Random();
		return new NaturalNumber(rand.nextInt((max - min) + 1) + min);
	}
}


















