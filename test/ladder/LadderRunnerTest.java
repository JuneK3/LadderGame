package ladder;

import core.NaturalNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderRunnerTest {
	@Test
	void testGenerateWhenNoLine() {
		Row[] rows = new Row[3];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new Row(new NaturalNumber(3));
		}
		String result = LadderRunner.generate(rows, Position.create(1, 1));
		assertEquals("0* 0 0 \n0 0 0 \n0 0 0 \n", result);
	}

	@Test
	void testGenerateWhenLineExists() {
		Row[] rows = new Row[3];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new Row(new NaturalNumber(3));
		}
		rows[0].drawLine(new NaturalNumber(1));
		String result = LadderRunner.generate(rows, Position.create(1, 1));
		assertEquals("1* -1 0 \n0 0 0 \n0 0 0 \n", result);
	}
}
