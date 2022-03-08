package ladder;

import core.NaturalNumber;

public class Row {
	private Node[] nodes;

	public Row(NaturalNumber noOfPerson) {
		nodes = new Node[noOfPerson.getNumber()];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = Node.createCenterNode();
		}
	}

	public void drawLine(NaturalNumber startPosition) {
		int startIndex = startPosition.toArrayIndex();
		if (isOverNoOfPerson(startIndex)) {
			throw new IllegalArgumentException(String.format(
					"선을 그릴수 있는 위치는 %d 미만이어야 합니다. 현재값: %d", nodes.length, startPosition.getNumber()
			));
		}

		if (nodes[startIndex].isLeftDirection()) {
			throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");
		}

		nodes[startIndex].changeRight();
		nodes[startIndex + 1].changeLeft();
	}

	private boolean isOverNoOfPerson(int startIndex) {
		return startIndex >= nodes.length - 1;
	}

	public Marker move(Marker marker) {
		if (marker.toArrayIndex() > nodes.length - 1) {
			throw new IllegalArgumentException(String.format(
					"시작점은 %d 이하여야 합니다. 현재값: %d", nodes.length, marker.getNumber()
			));
		}
		return nodes[marker.toArrayIndex()].move(marker);
	}
}
