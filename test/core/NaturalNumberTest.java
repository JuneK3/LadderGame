package core;

import core.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NaturalNumberTest {
	@Test
	void testCreateNaturalNumber() {
		NaturalNumber number = new NaturalNumber(1);
		assertEquals(1, number.getNumber());
	}

	@Test
	void testWhenCreateUnderZero() {
		try {
			new NaturalNumber(0);
			fail("IllegalArgumentException 에러가 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	@Test
	void testToArrayIndex () {
		NaturalNumber number = new NaturalNumber(3);
		assertEquals(2, number.toArrayIndex());
	}

	@Test
	void testFromArrayIndex() {
		NaturalNumber number = NaturalNumber.createFromArrayIndex(1);
		assertEquals(new NaturalNumber(2), number);
	}

	@Test
	void testMultiply() {
		NaturalNumber a = new NaturalNumber(3);
		NaturalNumber b = a.multiply(new NaturalNumber(4));
		assertEquals(new NaturalNumber(12), b);
	}

	@Test
	void testIsFirst() {
		NaturalNumber randomNumber = new NaturalNumber(1);
		assertTrue(randomNumber.isFirst());
		randomNumber = new NaturalNumber(2);
		assertFalse(randomNumber.isFirst());
	}
}
