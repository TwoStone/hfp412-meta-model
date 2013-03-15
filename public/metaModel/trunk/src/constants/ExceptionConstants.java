package constants;

public final class ExceptionConstants {

	public static final String DENOMINATOR_MUST_NOT_BE_ZERO = "Nenner darf nicht 0 sein!";

	public static final String DOUBLE_UNIT_TYPE_DEFINITION = "UnitType mit diesem Namen schon vorhanden: ";
	public static final String DOUBLE_UNIT_DEFINITION = "Unit mit diesem Namen schon vorhanden: ";
	public static final String DOUBLE_COMP_UNIT_TYPE = "Es existiert schon ein Unit Type mit Referenzen auf: ";
	public static final String DOUBLE_REFERENCETYPE_DEFINITION = "Es existiert bereits eine Referenz auf: ";

	public static final String DONT_DELETE_UNITTYPE = "Einheitentypen k�nnen nicht gel�scht werden.";
	public static final String DONT_DELETE_UNIT = "Einheiten k�nnen nicht gel�scht werden.";
	public static final String DONT_DELETE_REFERENCE_TYPE = "Referenz-Typen k�nnen nicht gel�scht werden.";
	public static final String DONT_DELETE_REFERENCE = "Referenzen k�nnen nicht gel�scht werden.";

	public static final String MEASUREMENT_TYPE_DOES_NOT_MATCH_TO_NEW_ENTRY_OF_ACCOUNT = "MeasurementType passt nicht zu den �brigen Eintr�gen des Accounts.";
	public static final String UNIT_TYPE_DOES_NOT_MATCH_MEASUREMENT_QUANTITY = "UnitType des Measurements passt nicht zum UnitType der Quantity.";

	public static final String NO_DEFAULT_UNIT_FOR_CONVERSION = "Im UnitType dieser Unit ist keine Default-Unit gesetzt. Diese wird f�r die Conversion ben�tigt.";
	public static final String NO_CONVERSION = "Es ist keine Conversion vorhanden in: ";
	public static final String WRONG_UNIT_TYPE_FOR_CONVERSION = "Die Ziel-Unit hat den falschen UnitType f�r die Konvertierung.";

	public static final String NO_DEFAULT_UNIT = "Im UnitType dieser Unit ist keine Default-Unit gesetzt.";

	public static final String WRONG_ACCOUNT_TYPE = "Falscher AccountType";

	public static final String ALREADY_EX_OF_ACCOUNT_TYPE = "Es existieren bereits Exemplare zu diesem AccountType";

	public static final String UNIT_TYPE_DOES_NOT_MATCH_ADD_OR_SUB = "Addition oder Subtraktion nur mit gleichem Einheitstyp m�glich!";

	/* Exceptions für Association, Operation, Link ... */
	public static final String DDE_ASSOC = "Eine Assoziation mit diesem Namen existiert bereits.";
	public static final String CYCLE_ADD_ASSOC = "Das Hinzufuegen der Assoziation zu dieser Hierarchie ist nicht m�glich, da ein Zyklus entstehen w�rde. Erster Zyklus durch: ";
	public static final String CE_ASSOC_ALREADY_IN_HIERARCHY = "Die Assoziation ist bereits in der Hierarchie enthalten.";
	public static final String DDE_HIERARCHY = "Eine Hierarchie mit diesem Namen existiert bereits.";
	public static final String NA_IN_HIERARCHY = "Die gew�lte Assoziation ist nicht in der Hierarchie enthalten.";
	public static final String CE_LAST_ASSOC_IN_HIERARCHY = "Die gew�lte Assoziation ist die letzte Assoziation in der gew�lten Hierarchie und kann deshalb nicht entfernt werden.";

	public static final String CE_FP_ALREADY_IN_OP = "Die Operation enth�lt bereits den gew�lten Formalparameter.";
	public static final String DDE_FP = "Ein Formalparameter mit diesem Namen existiert bereits.";
	public static final String CE_WRONG_TYPE_EMPTYTYPEDIS = "Der Typ eines Formalparameters darf nicht der leeren Disjunktion entsprechen.";
	public static final String CE_OP_SOURCE_AND_TARGET_EMPTYTYPEDISJ = "Quelle und Ziel k�nnn nicht gleichhzeitig leere Disjunktion sein.";
	public static final String CE_OP_HAS_MESSAGES_FP = "Zu dieser Operation existieren Exemplare, daher darf der Formalparameter nicht entfernt werden.";
	public static final String DDE_OP = "Eine Operation mit diesem Namen existiert bereits.";

	public static final String CYCLE_CREATE_LINK = "Das Erstellen des Links ist nicht m�glich, da ein Zyklus entstehen w�rde.";
	public static final String CE_LINK_SOURCE_WRONG_TYPE = "Die gew�lte Quelle passt nicht zur Assoziation.";
	public static final String CE_LINK_TARGET_WRONG_TYPE = "Das gew�lte Ziel passt nicht zur Assoziation.";

	public static final String CE_AT_SINGLETON_AND_ABSTRACT = "Atomare Typen duerfen nicht sowohl abstract als auch Singleton sein.";
	public static final String CE_AT_ABSTRACT_WITH_OBJECTS = "Atomare Typen mit Objekten duerfen nicht abstract sein.";
	public static final String CE_AT_SINGLETON_WITH_OBJECTS = "Atomare Typen mit Objekten duerfen nicht Singleton sein.";
	public static final String CE_AT_SINGLETON_WITH_DEPENDENT_ITEMS = "Singletons zu denen abhaenginge Items existieren duerfen nicht umdeklariert werden.";
	public static final String CE_AT_NAME_EMPTY = "Atomare Typen muessen einen nicht leeren Namen tragen.";
	public static final String CE_NAME_DOUBLE = "Name bereits vergeben: ";

	public static final String NA_FP = "Formalparameter befindet sich nicht in der Parameterliste.";

	public static final String NOT_COMPARABLE_UT = "Nur mit gleichem Einheitstyp vergleichbar!";
}
