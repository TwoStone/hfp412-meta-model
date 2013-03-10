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

	public static final String ALREADY_EX_OF_ACCOUNT_TYPE = "Es existieren bereits Exemplare zu diesem AccountType";

	public static final String UNIT_TYPE_DOES_NOT_MATCH_ADD_OR_SUB = "Addition oder Subtraktion nur mit gleichem Einheitstyp möglich!";

	/* Exceptions für Association, Operation, Link ... */
	public static final String DDE_ASSOC = "Eine Assoziation mit diesem Namen existiert bereits.";
	public static final String CYCLE_ADD_ASSOC = "Das Hinzufuegen der Assoziation zu dieser Hierarchie ist nicht möglich, da ein Zyklus entstehen würde. Erster Zyklus durch: ";
	public static final String CE_ASSOC_ALREADY_IN_HIERARCHY = "Die Assoziation ist bereits in der Hierarchie enthalten.";
	public static final String DDE_HIERARCHY = "Eine Hierarchie mit diesem Namen existiert bereits.";
	public static final String NA_IN_HIERARCHY = "Die gewählte Assoziation ist nicht in der Hierarchie enthalten.";
	public static final String CE_LAST_ASSOC_IN_HIERARCHY = "Die gewählte Assoziation ist die letzte Assoziation in der gewählten Hierarchie und kann deshalb nicht entfernt werden.";
	public static final String CE_EXISTING_LINKS = "Die gewählte Assoziation kann nicht gelöscht werden, solang Exemplare existieren.";
	public static final String CE_ASSOC_IN_HIERARCHY = "Die gewählte Assoziation kann nicht gelöscht werden, da sie Element mindestens einer Hierarchy ist.";

	public static final String CE_FP_ALREADY_IN_OP = "Die Operation enthält bereits den gewählten Formalparameter.";
	public static final String DDE_FP = "Ein Formalparameter mit diesem Namen existiert bereits.";
	public static final String CE_WRONG_TYPE_EMPTYTYPEDIS = "Der Typ eines Formalparameters darf nicht der leeren Disjunktion entsprechen.";
	public static final String CE_OP_SOURCE_AND_TARGET_EMPTYTYPEDISJ = "Quelle und Ziel könnn nicht gleichhzeitig leere Disjunktion sein.";
	public static final String CE_OP_HAS_MESSAGES_FP = "Zu dieser Operation existieren Exemplare, daher darf der Formalparameter nicht entfernt werden.";
	public static final String CE_EXISTING_AP = "Der gewählte Formalparameter kann nicht gelöscht werden, solang Exemplare existieren.";
	public static final String CE_FP_IN_OP = "Der gewählte Formalparameter kann nicht gelöcht werden, solang er Teil einer Operation ist.";
	public static final String CE_OP_HAS_MESSAGES = "Die gewählte Operationen kann nicht gelöscht werden, solang Exemplare existieren.";
	public static final String DDE_OP = "Eine Operation mit diesem Namen existiert bereits.";

	public static final String CYCLE_CREATE_LINK = "Das Erstellen des Links ist nicht möglich, da ein Zyklus entstehen würde.";
	public static final String CE_LINK_SOURCE_WRONG_TYPE = "Die gewählte Quelle passt nicht zur Assoziation.";
	public static final String CE_LINK_TARGET_WRONG_TYPE = "Das gewählte Ziel passt nicht zur Assoziation.";

	public static final String CE_AT_SINGLETON_AND_ABSTRACT = "Atomare Typen duerfen nicht sowohl abstract als auch Singleton sein.";
	public static final String CE_AT_ABSTRACT_WITH_OBJECTS = "Atomare Typen mit Objekten duerfen nicht abstract sein.";
	public static final String CE_AT_SINGLETON_WITH_OBJECTS = "Atomare Typen mit Objekten duerfen nicht Singleton sein.";
	public static final String CE_AT_SINGLETON_WITH_DEPENDENT_ITEMS = "Singletons zu denen abhaenginge Items existieren duerfen nicht umdeklariert werden.";
	public static final String CE_AT_NAME_EMPTY = "Atomare Typen muessen einen nicht leeren Namen tragen.";
	public static final String CE_NAME_DOUBLE = "Name bereits vergeben: ";
}
