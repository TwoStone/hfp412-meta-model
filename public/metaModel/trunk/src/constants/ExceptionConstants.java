package constants;

public final class ExceptionConstants {

	public static final String DENOMINATOR_MUST_NOT_BE_ZERO = "Nenner darf nicht 0 sein!";

	public static final String DOUBLE_UNIT_TYPE_DEFINITION = "UnitType mit diesem Namen schon vorhanden: ";
	public static final String DOUBLE_UNIT_DEFINITION = "Unit mit diesem Namen schon vorhanden: ";
	public static final String DOUBLE_COMP_UNIT_TYPE = "Es existiert schon ein Unit Type mit Referenzen auf: ";
	public static final String DOUBLE_REFERENCETYPE_DEFINITION = "Es existiert bereits eine Referenz auf: ";

	public static final String DONT_DELETE_UNITTYPE = "Einheitentypen können nicht gelöscht werden.";
	public static final String DONT_DELETE_UNIT = "Einheiten können nicht gelöscht werden.";
	public static final String DONT_DELETE_REFERENCE_TYPE = "Referenz-Typen können nicht gelöscht werden.";
	public static final String DONT_DELETE_REFERENCE = "Referenzen können nicht gelöscht werden.";

	public static final String MEASUREMENT_TYPE_DOES_NOT_MATCH_TO_NEW_ENTRY_OF_ACCOUNT = "MeasurementType passt nicht zu den übrigen Einträgen des Accounts.";
	public static final String UNIT_TYPE_DOES_NOT_MATCH_MEASUREMENT_QUANTITY = "UnitType des Measurements passt nicht zum UnitType der Quantity.";

	public static final String NO_DEFAULT_UNIT_FOR_CONVERSION = "Im UnitType dieser Unit ist keine Default-Unit gesetzt. Diese wird für die Conversion benötigt.";
	public static final String NO_CONVERSION = "Es ist keine Conversion vorhanden in: ";
	public static final String WRONG_UNIT_TYPE_FOR_CONVERSION = "Die Ziel-Unit hat den falschen UnitType für die Konvertierung.";

	public static final String NO_DEFAULT_UNIT = "Im UnitType dieser Unit ist keine Default-Unit gesetzt.";

	public static final String WRONG_ACCOUNT_TYPE = "Falscher AccountType";

	public static final String ALREADY_EX_OF_ACCOUNT_TYPE = "Es existieren bereits Exemplare zu diesem AccountType";

	public static final String UNIT_TYPE_DOES_NOT_MATCH_ADD_OR_SUB = "Addition oder Subtraktion nur mit gleichem Einheitstyp möglich!";

	/* Beginn Exceptions für Association, Operation, Link ... */
	public static final String DDE_ASSOC = "Eine Assoziation mit diesem Namen existiert bereits.";
	public static final String CYCLE_ADD_ASSOC = "Das Hinzufügen der Assoziation zu dieser Hierarchie ist nicht möglich, da ein Zyklus entstehen würde. Erster Zyklus durch: ";
	public static final String CE_ASSOC_ALREADY_IN_HIERARCHY = "Die Assoziation ist bereits in der Hierarchie enthalten.";
	public static final String DDE_HIERARCHY = "Eine Hierarchie mit diesem Namen existiert bereits.";
	public static final String NA_IN_HIERARCHY = "Die gewälte Assoziation ist nicht in der Hierarchie enthalten.";
	public static final String CE_LAST_ASSOC_IN_HIERARCHY = "Die gewälte Assoziation ist die letzte Assoziation in der gewälten Hierarchie und kann deshalb nicht entfernt werden.";
	public static final String CE_ASSOC_WRONG_SOURCE_EMPTY_DIS = "Die Quelle einer Assoziation darf nicht der leeren Disjunktion entsprechen.";
	public static final String CE_ASSOC_WRONG_TARGET_EMPTY_DIS = "Das Ziel einer Assoziation darf nicht der leeren Disjunktion entsprechen.";

	public static final String CE_FP_ALREADY_IN_OP = "Die Operation enthält bereits den gewälten Formalparameter.";
	public static final String DDE_FP = "Ein Formalparameter mit diesem Namen existiert bereits.";
	public static final String CE_FP_WRONG_TYPE_EMPTY_DIS = "Der Typ eines Formalparameters darf nicht der leeren Disjunktion entsprechen.";
	public static final String CE_OP_SOURCE_AND_TARGET_EMPTYTYPEDISJ = "Quelle und Ziel könnn nicht gleichhzeitig leere Disjunktion sein.";
	public static final String CE_OP_HAS_MESSAGES_FP = "Zu dieser Operation existieren Exemplare, daher darf der Formalparameter nicht entfernt werden.";
	public static final String DDE_OP = "Eine Operation mit diesem Namen existiert bereits.";
	public static final String NA_FP = "Formalparameter befindet sich nicht in der Parameterliste.";

	public static final String CYCLE_CREATE_LINK = "Das Erstellen des Links ist nicht möglich, da ein Zyklus entstehen würde.";
	public static final String CE_LINK_SOURCE_WRONG_TYPE = "Die gewälte Quelle passt nicht zur Assoziation.";
	public static final String CE_LINK_TARGET_WRONG_TYPE = "Das gewälte Ziel passt nicht zur Assoziation.";
	/* Ende Exceptions für Association, Operation, Link ... */

	public static final String CE_AT_SINGLETON_AND_ABSTRACT = "Atomare Typen duerfen nicht sowohl abstract als auch Singleton sein.";
	public static final String CE_AT_ABSTRACT_WITH_OBJECTS = "Atomare Typen mit Objekten duerfen nicht abstract sein.";
	public static final String CE_AT_SINGLETON_WITH_OBJECTS = "Atomare Typen mit Objekten duerfen nicht Singleton sein.";
	public static final String CE_AT_SINGLETON_WITH_DEPENDENT_ITEMS = "Singletons zu denen abhaenginge Items existieren duerfen nicht umdeklariert werden.";
	public static final String CE_AT_NAME_EMPTY = "Atomare Typen muessen einen nicht leeren Namen tragen.";
	public static final String CE_NAME_DOUBLE = "Name bereits vergeben: ";

	public static final String NOT_COMPARABLE_UT = "Nur mit gleichem Einheitstyp vergleichbar!";

	public static final String CE_OBJ_CONC_TYPE = "Objekte dürfen nur in konkreten Typen klassifiziert werden!";
	public static final String CE_OBJ_NOT_SINGLETON_TYPE = "Objekte dürfen nur in nicht-singleton Typen klassifiziert werden!";
	public static final String CE_OBJ_ONLY_ONE_TYPE_PER_ASPECT = "Das Objekt kann nur in nur einem Typen pro Aspekt klassifiziert werden! Aspekt: %s";
	public static final String CE_OBJ_MIN_ONE_TYPE = "Das Objekt muss in mindestens einem Typen klassifiziert! Fügen sie einen weiteren Typen hinzu bevor Sie diesen entfernen!";
	public static final String CE_OBJ_MAX_ONE_TYPE = "Das Objekt kann nur in nur einem Typen pro Aspekt klassifiziert werden! Aspekt: %s";
	public static final String CE_OBJ_NAME_WITH_SCHEME = "Das Objekt hat bereits einen Namen in dem Schema!";
	public static final String CE_OBJ_NOT_THIS_SCHEME = "Das Objekt kann nicht in diesem Schema benannt werden!";
	public static final String CE_SCHEME_NAME_NOT_VALID = "Der angegebene Name entspricht nicht dem Schema!";
	public static final String CE_CONJ_NO_SINGLETON = "Typen in Typ-Konjunktionen dürfen keine Singletons sein";
	public static final String CE_ASP_IN_CONJ_UNIQUE = "Aspekte in Typ-Konjunktionen müssen eindeutig sein.";
	public static final String CE_ASP_NAME_UNIQUE = "Aspekt-Namen müssen eindeutig sein. Es existiert bereits ein Aspekt mit dem Namen: ";
	public static final String CE_CYCLE_NOT_VALID = "Es ist eine unerwartete CycleException aufgetreten: ";
	public static final String CE_ENUM_TYPE_NOT_VALID = "Enumwert ist nicht vom korrekten Typ.";

	public static final String CE_MI_DELETE = "Das folgende Element kann nicht gelöscht werden, da es noch Abhängigkeiten zu anderen Elementen gibt: ";
	public static final String CE_DELETE_ANYTHING = "'ANYTHING' darf nicht gelöscht werden.";
	public static final String CE_DELETE_NOTHING = "'NOTHING' darf nicht gelöscht werden.";

	public static final String CE_ENUM_DELETE_ENUMVALUE = "Enumeration kann nicht gelöscht werden, da es noch Abhängigkeiten zu Enumwerten gibt.";
	public static final String CE_ENUM_DELETE_OBSERVATION = "Enumeration kann nicht gelöscht werden, da es noch Abhängigkeiten zu Observationen gibt.";
	public static final String CE_OBSERVATION_DELETE = "Observation kann nicht gelöscht werden, da es noch Abhängigkeiten zu anderen Elementen gibt.";
	public static final String CE_OBSERVATIONTYPE_DELETE = "Observation-Typ kann nicht gelöscht werden, da es noch Abhängigkeiten zu anderen Elementen gibt.";
	public static final String CYCLE_ACCOUNT_HIERARCHY = "Es wurde Zyklus in der Account-Hierarchie festgestellt.";
	public static final String CYCLE_ACCOUNTTYPE_HIERARCHY = "Es wurde Zyklus in der Accounttyp-Hierarchie festgestellt.";
	public static final String CYCLE_COMPLEXTYPE_HIERARCHY = "Es wurde Zyklus in der komplexen Typ-Hierarchie festgestellt.";
	public static final String CYCLE_ATOMICTYPE_HIERARCHY = "Es wurde Zyklus in der atomaren Typ-Hierarchie festgestellt.";

	public static final String DDE_FRACTION = "Ein solcher Bruch existiert bereits: ";
	public static final String DDE_ENUM = "Eine Enumeration mit diesem Namen existiert bereits.";
	public static final String DDE_ENUMVALUE = "Eine Enumerationswert mit diesem Namen existiert zur Enumeration bereits.";
	public static final String DDE_OBSERVATION = "Eine Observation mit diesem Namen existiert bereits.";

	public static final String NC_QUANTITY_UNITTYPES = "Es können keine Quantitäten zu unterschiedlichen Einheitentypen addiert werden.";
	public static final String NC_DIFFRENT_TYPES = "Die Typen stimmen nicht überein.";
	public static final String NC_DEFAULTUNIT = "Es fehlt eine DefaultUnit für ";
	public static final String NOT_FOUND = " wurde nicht gefunden.";

}
