package ladder;

import org.junit.jupiter.api.Test;

import static ladder.Node.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {
	@Test
	void testWhenCreateCenter() {
		Node node = new Node(CENTER);
		assertEquals(new Node(CENTER), node);
	}

	@Test
	void testChangeToRightNode() {
		Node node = new Node(CENTER);
		node.changeRight();
		assertEquals(new Node(RIGHT), node);
	}

	@Test
	void testChangeToLeftNode() {
		Node node = new Node(CENTER);
		node.changeLeft();
		assertEquals(new Node(LEFT), node);
	}
}
