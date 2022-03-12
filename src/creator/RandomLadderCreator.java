package creator;

import core.NaturalNumber;
import core.RandomNaturalNumber;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

import java.util.ArrayList;
import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
	public static final double DEFAULT_LINE_RATIO = 0.3;
	private LadderSize ladderSize;
	private LadderCreator ladderCreator;

	public RandomLadderCreator(LadderCreator ladderCreator) {
		this.ladderCreator = ladderCreator;
		this.ladderSize = ladderCreator.getLadderSize();

		ArrayList<Position> startPositions = generateStartPositions();
		for (Position position : startPositions) {
			ladderCreator.drawLine(position.getHeight(), position.getNthOfPerson());
		}
	}

	public Row[] getRows() {
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

	public ArrayList<Position> generateStartPositions() {
		ArrayList<RandomNaturalNumber> numbers = generateRandomPositions();
		return toPositions(numbers);
	}

	private ArrayList<RandomNaturalNumber> generateRandomPositions() {
		NaturalNumber totalPositions = ladderSize.getTotalPosition();
		int countOfLine = ladderSize.getCountOfLine(DEFAULT_LINE_RATIO);
		ArrayList<RandomNaturalNumber> randomPositions = new ArrayList<>();
		do {
			RandomNaturalNumber randomPosition = randInt(1, totalPositions.getNumber());
			if (ladderSize.isMultipleOfPerson(randomPosition)) {
				continue;
			}
			if (randomPositions.contains(randomPosition)) {
				continue;
			}
			if (randomPositions.contains(new RandomNaturalNumber(randomPosition.getNumber() + 1))) {
				continue;
			}
			if (randomPosition.isFirst()) {
				randomPositions.add(randomPosition);
				System.out.printf("random position: %s%n", randomPosition);
			} else {
				if (randomPositions.contains(new RandomNaturalNumber(randomPosition.getNumber() - 1))) {
					continue;
				}
				randomPositions.add(randomPosition);
				System.out.printf("random position: %s%n", randomPosition);
			}
		} while (randomPositions.size() < countOfLine);

		return randomPositions;
	}

	ArrayList<Position> toPositions(ArrayList<RandomNaturalNumber> randomNumbers) {
		ArrayList<Position> positions = new ArrayList<>();
		for (RandomNaturalNumber randomNumber : randomNumbers) {
			positions.add(ladderSize.getPosition(randomNumber));
		}
		return positions;
	}

	static RandomNaturalNumber randInt(int min, int max) {
		Random rand = new Random();
		return new RandomNaturalNumber(rand.nextInt((max - min) + 1) + min);
	}
}


















