package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarkerTest {
	@Test
	void testMoveRight() {
		Marker marker = new Marker(3);
		assertEquals(new Marker(4), marker.moveRight());
	}

	@Test
	void testMoveLeft() {
		Marker marker = new Marker(3);
		assertEquals(new Marker(2), marker.moveLeft());
	}
}
