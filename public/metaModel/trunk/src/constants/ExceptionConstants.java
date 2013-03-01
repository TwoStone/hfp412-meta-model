package constants;

public final class ExceptionConstants {

	public static final String DENOMINATOR_MUST_NOT_BE_ZERO = "Nenner darf nicht 0 sein!";

	public static final String DOUBLE_UNIT_TYPE_DEFINITION = "UnitType mit diesem Namen schon vorhanden: ";
	public static final String DOUBLE_UNIT_DEFINITION = "Unit mit diesem Namen schon vorhanden: ";
	public static final String DOUBLE_COMP_UNIT_TYPE = "Es existiert schon ein Unit Type mit Referenzen auf: ";
	public static final String DOUBLE_REFERENCETYPE_DEFINITION = "Es existiert bereits eine Referenz auf: ";

	public static final String UNIT_TYPE_DOES_NOT_MATCH_MEASUREMENT_ACCOUNT = "UnitType des Measurements passt nicht zum UnitType des Accounts.";
	public static final String UNIT_TYPE_DOES_NOT_MATCH_MEASUREMENT_QUANTITY = "UnitType des Measurements passt nicht zum UnitType der Quantity.";

	public static final String ALREADY_FINAL_CUT = "Dieser UnitTyp ist bereits final!";

	public static final String ALREADY_FINAL_CU = "Diese Einheit ist bereits final!";

	public static final String NOT_FINAL = "Noch nicht final.";

	public static final String NO_DEFAULT_UNIT_FOR_CONVERSION = "Im UnitType dieser Unit ist keine Default-Unit gesetzt. Diese wird für die Conversion benötigt.";

	public static final String NO_DEFAULT_UNIT = "Im UnitType dieser Unit ist keine Default-Unit gesetzt.";
}
