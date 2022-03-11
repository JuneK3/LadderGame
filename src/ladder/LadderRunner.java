package ladder;

public class LadderRunner {

	private Row[] rows;

	public LadderRunner(Row[] rows) {
		this.rows = rows;
	}

	public Marker run(Marker nthPerson) {
		for (int i = 0; i < rows.length; i++) {
			Row row = rows[i];
			System.out.println("Before: ");
			System.out.println(generate(rows, Position.createFromArrayIndex(i, nthPerson.toArrayIndex())));
			nthPerson = row.move(nthPerson);
			System.out.println("After: ");
			System.out.println(generate(rows, Position.createFromArrayIndex(i, nthPerson.toArrayIndex())));
		}
		return nthPerson;
	}

	public static String generate(Row[] rows, Position position) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows.length; i++) {
			Row row = rows[i];
			row.generateRow(sb, i, position);
		}
		return sb.toString();
	}
}
