package ladder;

import java.util.Objects;

public class Node {
	private Direction direction;

	Node(Direction direction) {
		this.direction = direction;
	}

	void changeRight() {
		this.direction = Direction.RIGHT;
	}

	void changeLeft() {
		this.direction = Direction.LEFT;
	}

	enum Direction {
		LEFT, CENTER, RIGHT;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Node node = (Node) o;
		return direction == node.direction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direction);
	}
}
