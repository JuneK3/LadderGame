package ladder;

public class Marker extends NaturalNumber {

	public Marker(int number) {
		super(number);
	}

	public Marker moveRight() {
		return new Marker(getNumber() + 1);
	}

	public Marker moveLeft() {
		return new Marker(getNumber() - 1);
	}
}
