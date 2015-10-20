package common;

public abstract class RPCConstantsAndServices {

	public static final int CurrentVersion = 0;
	public static final String VersionErrorText = "Bitte neue Version der Software von der ?blichen Stelle laden!";

	public static boolean test = false;

	public static int EssentialDepth = 3;	

	private static final int RefreshInterval = 64000;

	public static final int ServerPort = 8089;
	public static final int ClientRefreshInterval = RefreshInterval;
	public static final int ServerRefreshInterval = RefreshInterval;
	public static final String ConnectionHandlerName = "connection";
	
	public static final String ConnectSeparator = "|";

	public static final String AdministratorName = "hugo";

	private static final String KeySeparator = "#";
	private static final String IconInfoSeparator = "I";
	private static final String LeafInfoSeparator = "L";
	private static final String ToStringSeparator = "$$";
	private static final String DecorateeSeparator = "%%";
	
	public static final String RPCClassIdFieldName = "classId";
	public static final String RPCObjectIdFieldName = "id";
	public static final String RPCToStringFieldName = "toString";
	
	public static final String OKOrNotOKResultFieldName = "?OK?";
	public static final String ErrorNumberFieldName = "?ErrorNumber?";
	public static final Integer PersistenceExceptionNumber = new Integer(0);
	public static final String ResultFieldName = "?Result?";
	public static final String RootFieldName = "?Root?";
	public static final String ResultListFieldName = "?ResultList?";
	public static final String ExceptionMessageFieldName = "?Message?";
	public static final String ExceptionNumberFieldName = "?ExceptionNumber?";

	public static final long NullObjectID = 0;
	public static final long NullClassID = 0;
	public static final int NullIconInfo = 0;
	public static final int NullLeafInfo = 0;
	public static final String NullObjectToString = "null";

	public static final int ObjectNotAvailableErrorNo = 111;
	public static final String ObjectNotAvailableErrorMessage = "Object is not available!";

	public static String createHashtableKey(long classId, long objectId){
		return classId + KeySeparator + objectId + IconInfoSeparator ;
	}
	private static String createHashtableRepresentation(long classId, long objectId, int iconInfo, int leafInfo, boolean withDecoratee) {
		return classId + KeySeparator + objectId + IconInfoSeparator + iconInfo + LeafInfoSeparator + leafInfo + (withDecoratee ? DecorateeSeparator : ToStringSeparator);
	}

	public static String createProxiRepresentation(long classId, long objectId, int iconInfo, int leafInfo, String toString){
		return createHashtableKey(classId, objectId) + iconInfo + LeafInfoSeparator + leafInfo + ToStringSeparator + toString;
	}

	public static String createProxiRepresentation(long classId, long objectId, int iconInfo, int leafInfo, String toString, long decorateeClassId, long decorateeObjectId){
		return createHashtableRepresentation(classId, objectId, iconInfo, leafInfo, true) + createHashtableRepresentation(decorateeClassId, decorateeObjectId) + toString;
	}
	private static String createHashtableRepresentation(long decorateeClassId, long decorateeObjectId) {
		return decorateeClassId + KeySeparator + decorateeObjectId + ToStringSeparator;
	}
	public static ProxiInformation createProxiInformation(String proxiString) {
		int keySeparatorPosition = proxiString.indexOf(KeySeparator);
		int iconInfoSeparatorPosition = proxiString.indexOf(IconInfoSeparator);
		int leafInfoSeparatorPosition = proxiString.indexOf(LeafInfoSeparator);
		int toStringSeparatorPosition = proxiString.indexOf(ToStringSeparator);
		int decorateeSeparatorPosition = proxiString.indexOf(DecorateeSeparator);
		if (decorateeSeparatorPosition >= 0 && decorateeSeparatorPosition < toStringSeparatorPosition){
			return createDecoratedProxiInformation(proxiString, keySeparatorPosition, iconInfoSeparatorPosition, leafInfoSeparatorPosition, decorateeSeparatorPosition, toStringSeparatorPosition);			
		} else {
			return createUndecoratedProxiInformation(proxiString, keySeparatorPosition, iconInfoSeparatorPosition, leafInfoSeparatorPosition, toStringSeparatorPosition);
		}
	}

	private static ProxiInformation createDecoratedProxiInformation(String proxiString, int keySeparatorPosition, int iconInfoSeparatorPosition, int leafInfoSeparatorPosition, int decorateeSeparatorPosition, int toStringSeparatorPosition) {
		long classId = new Long(proxiString.substring(0,keySeparatorPosition));
		long objectId = new Long(proxiString.substring(keySeparatorPosition + KeySeparator.length(), iconInfoSeparatorPosition));
		int iconInfo = new Integer(proxiString.substring(iconInfoSeparatorPosition + IconInfoSeparator.length(), leafInfoSeparatorPosition));
		int leafInfo = new Integer(proxiString.substring(leafInfoSeparatorPosition + LeafInfoSeparator.length(),decorateeSeparatorPosition));
		String proxiStringWithoutFirstHash = proxiString.substring(decorateeSeparatorPosition + DecorateeSeparator.length(), proxiString.length());
		keySeparatorPosition = proxiStringWithoutFirstHash.indexOf(KeySeparator);
		long decorateeClassId = new Long(proxiStringWithoutFirstHash.substring(keySeparatorPosition));
		long decorateeObjectid = new Long(proxiStringWithoutFirstHash.substring(keySeparatorPosition + KeySeparator.length(), toStringSeparatorPosition));
		String toString = proxiStringWithoutFirstHash.substring(toStringSeparatorPosition + ToStringSeparator.length(), proxiString.length());
		return new ProxiInformation(classId,objectId,iconInfo,leafInfo,toString,decorateeClassId,decorateeObjectid);
	}

	private static ProxiInformation createUndecoratedProxiInformation(String proxiString, int keySeparatorPosition, int iconInfoSeparatorPosition, int leafInfoSeparatorPosition, int toStringSeparatorPosition) {
		long classId = new Long(proxiString.substring(0,keySeparatorPosition));
		long objectId = new Long(proxiString.substring(keySeparatorPosition + KeySeparator.length(), iconInfoSeparatorPosition));
		int iconInfo = 0; 
		int leafInfo = 0;
		String toString = "";
		if (leafInfoSeparatorPosition >=  0){
			iconInfo = new Integer(proxiString.substring(iconInfoSeparatorPosition + IconInfoSeparator.length(), leafInfoSeparatorPosition));
			leafInfo = new Integer(proxiString.substring(leafInfoSeparatorPosition + LeafInfoSeparator.length(),toStringSeparatorPosition));
			toString = proxiString.substring(toStringSeparatorPosition + ToStringSeparator.length(), proxiString.length());
		}
		return new ProxiInformation(classId,objectId,iconInfo,leafInfo,toString);
	}

	public static String createFromClientProxiRepresentation(long classId, long id, int remoteDepth) {
		return createProxiRepresentation(classId, id, 0, 0, new Integer(remoteDepth).toString());
	}
	
	public static String createFromClientProxiRepresentation(long classId, long id, int remoteDepth, long decorateeClassId, long decorateeObjectId) {
		return createProxiRepresentation(classId, id, 0, 0, new Integer(remoteDepth).toString(), decorateeClassId, decorateeObjectId);
	}
	
	private RPCConstantsAndServices(){}
}
