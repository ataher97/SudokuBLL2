package pkgEnum;

public enum ePuzzleViolation {
	DupRow, DupCol, DupRegion, InvalidValue, ContainsZero, MissingZero;

	private ePuzzleViolation() {

	}

	public static ePuzzleViolation valueOf​(String name) {
		ePuzzleViolation valueOf = null;
		for (ePuzzleViolation violation : ePuzzleViolation.values()) {
			if (violation.toString() == name) {
				valueOf = violation;
				break;
			}
		}
		return valueOf;
	}
}