package ladder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LadderTest {

	@Test
	public void testDrawLineWhenRowIsOverLimit() {
		try {
			Ladder ladder = new Ladder(new NaturalNumber(4), new NaturalNumber(3));
			ladder.drawLine(new NaturalNumber(5), new NaturalNumber(2));
			fail("IllegalArgumentException 에러가 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}


	@Test
	public void testRunWhenNoLine() {
		Ladder ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
		Marker target = ladder.run(new Marker(1));
		assertEquals(new Marker(1), target);

		target = ladder.run(new Marker(2));
		assertEquals(new Marker(2), target);
	}

	@Test
	public void testRunWhenLineLeft() {
		// 1 1 0
		Ladder ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));

		Marker target = ladder.run(new Marker(2));
		assertEquals(new Marker(1), target);

		// 0 1 1
		ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(2));

		target = ladder.run(new Marker(3));
		assertEquals(new Marker(2), target);
	}

	@Test
	public void testRunWhenLineRight() {
		// 0 1 1
		Ladder ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(2));

		Marker target = ladder.run(new Marker(2));
		assertEquals(new Marker(3), target);

		// 1 1 0
		ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));

		target = ladder.run(new Marker(1));
		assertEquals(new Marker(2), target);
	}

	@Test
	public void testRunWhenMultiRows() {
		// 1 1 0 0
		// 0 1 1 0
		// 0 0 1 1
		Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));
		ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
		ladder.drawLine(new NaturalNumber(3), new NaturalNumber(3));

		assertEquals(ladder.run(new Marker(1)), new Marker(4));
		assertEquals(ladder.run(new Marker(2)), new Marker(1));
		assertEquals(ladder.run(new Marker(3)), new Marker(2));
		assertEquals(ladder.run(new Marker(4)), new Marker(3));
	}
}
