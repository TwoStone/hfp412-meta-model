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

	public static final String WRONG_ACCOUNT_TYPE = "Falscher AccountType";

	public static final String UNIT_TYPE_DOES_NOT_MATCH_ADD_OR_SUB = "Addition oder Subtraktion nur mit gleichem Einheitstyp möglich!";

	/* Exceptions für Association, Operation, Link ... */

	public static final String DDE_ASSOC = "Eine Assoziation mit diesem Namen existiert bereits";
	public static final String CYCLE = "Das Hinzufuegen der Assoziation zu dieser Hierarchie ist nicht möglich, da ein Zyklus entstehen würde. Erster Zyklus durch: ";
	public static final String CE_ASSOC_ALREADY_IN_HIERARCHY = "Die Assoziation ist bereits in der Hierarchie enthalten";
	public static final String DDE_HIERARCHY = "Eine Hierarchie mit diesem Namen existiert bereits.";
	public static final String NA_IN_HIERARCHY = "Die gewählte Assoziation ist nicht in der Hierarchie enthalten";
	public static final String CE_LAST_ASSOC_IN_HIERARCHY = "Die gewählte Assoziation ist die letzte Assoziation in der gewählten Hierarchie und kann deshalb nicht entfernt werden.";
	public static final String CE_EXCISTING_LINKS = "Die gewählte Assoziation kann nicht gelöscht werden, solang Exemplare existieren.";
	public static final String CE_ASSOC_IN_HIERARCHY = "Die gewählte Assoziation kann nicht gelöscht werden, da sie Element mindestens einer Hierarchy ist.";
}
