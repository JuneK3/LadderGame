package ladder;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RandomLadderCreatorTest {
	@Test
	void testGenerateStartPosition() {
		for (int i=0; i<10; i++){
			System.out.println(randInt(1, 20));
		}
	}

	public static int randInt(int min, int max){
		Random rand = new Random();
		int randNum = rand.nextInt((max - min) + 1) + min;
		return randNum;
	}
}
