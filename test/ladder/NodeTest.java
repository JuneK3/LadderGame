package ladder;

import org.junit.jupiter.api.Test;

import static ladder.Node.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
	@Test
	void testWhenCreateCenter() {
		Node node = Node.createCenterNode();
		assertEquals(Node.createCenterNode(), node);
	}

	@Test
	void testChangeToRightNode() {
		Node node = Node.createCenterNode();
		node.changeRight();
		assertEquals(Node.createRightNode(), node);
	}

	@Test
	void testChangeToLeftNode() {
		Node node = Node.createCenterNode();
		node.changeLeft();
		assertEquals(Node.createLeftNode(), node);
	}

	@Test
	void testMoveRight() {
		Node node = Node.createRightNode();
		Marker marker = node.move(new Marker(3));
		assertEquals(new Marker(4), marker);
	}

	@Test
	void testMoveLeft() {
		Node node = Node.createLeftNode();
		Marker marker = node.move(new Marker(3));
		assertEquals(new Marker(2), marker);
	}

	@Test
	void testMoveCenter() {
		Node node = Node.createCenterNode();
		Marker marker = node.move(new Marker(3));
		assertEquals(new Marker(3), marker);
	}
}
