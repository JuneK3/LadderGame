package ladder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RowTest {

	private Row row;

	@BeforeEach
	public void setUp() {
		row = new Row(new NaturalNumber(3));
	}

	@Test
	void testStartPositionWhenOverNoOfPerson() {
		try {
			row.drawLine(new NaturalNumber(4));
			fail("IllegalArgumentException 에러가 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}


	@Test
	void testDrawLineWhenAlreadyDrawnLine() {
		try {
			row.drawLine(new NaturalNumber(1));
			row.drawLine(new NaturalNumber(2));
			fail("IllegalArgumentException 에러가 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	void testMoveWhenArgumentOverNoOfPerson() {
		try {
			row.drawLine(new NaturalNumber(1));
			row.move(new Marker(4));
			fail("IllegalArgumentException 에러가 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	public void testMoveWhenNoLine() {
		NaturalNumber target = row.move(new Marker(1));
		assertEquals(1, target.getNumber());

		target = row.move(new Marker(2));
		assertEquals(2, target.getNumber());
	}

	@Test
	public void testMoveWhenLineLeft() {
		// 0 1 1
		row.drawLine(new NaturalNumber(2));

		NaturalNumber target = row.move(new Marker(3));
		assertEquals(2, target.getNumber());

		// 1 1 0
		row = new Row(new NaturalNumber(3));
		row.drawLine(new NaturalNumber(1));

		target = row.move(new Marker(2));
		assertEquals(1, target.getNumber());
	}

	@Test
	public void testMoveWhenLineRight() {
		// 0 1 1
		row.drawLine(new NaturalNumber(2));

		NaturalNumber target = row.move(new Marker(2));
		assertEquals(3, target.getNumber());

		// 1 1 0
		row = new Row(new NaturalNumber(3));
		row.drawLine(new NaturalNumber(1));

		target = row.move(new Marker(1));
		assertEquals(2, target.getNumber());
	}
}
