package core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RandomNaturalNumberTest {
	@Test
	void testGetPositionOfPerson() {
		RandomNaturalNumber number = new RandomNaturalNumber(4);
		int actual = number.getPositionOfPerson(3);
		assertEquals(1, actual);
	}

	@Test
	void testGetPositionOfHeight() {
		RandomNaturalNumber number = new RandomNaturalNumber(4);
		int actual = number.getPositionOfHeight(3);
		assertEquals(2, actual);
	}

	@Test
	void testIsMultipleOfPerson() {
		RandomNaturalNumber randomNumber = new RandomNaturalNumber(8);
		assertTrue(randomNumber.isMultipleOfPerson(4));
		randomNumber = new RandomNaturalNumber(5);
		assertFalse(randomNumber.isMultipleOfPerson(3));
	}

	@Test
	void testCheckedNaturalNumbers() {
		RandomNaturalNumber randomNumber = new RandomNaturalNumber(2);
		ArrayList<RandomNaturalNumber> naturalNumbers = randomNumber.checkedNaturalNumbers(new NaturalNumber(3));
		assertTrue(naturalNumbers.size() == 3);
	}

	@Test
	void testCheckedNaturalNumbersWhenFirst() {
		RandomNaturalNumber randomNumber = new RandomNaturalNumber(4);
		ArrayList<RandomNaturalNumber> naturalNumbers = randomNumber.checkedNaturalNumbers(new NaturalNumber(3));
		assertTrue(naturalNumbers.size() == 2);
	}
}
