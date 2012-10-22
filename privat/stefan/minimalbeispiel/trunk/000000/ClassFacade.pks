create or replace package ClassFacade is
  
	abstractRepresentation constant number := 0;
  	concreteRepresentation constant number := 1;

	oneRepresentation constant number := 0;
  	manyRepresentation constant number := 1;

	type ObjectInfo is record(
		objectId number,
		classId number
	);
		
	type ObjectInfoCollection is ref cursor return ObjectInfo;

	type ObjectThisInfo is record(
		objectId number,
		classId number,
		thisId number,
		thisClassId number
	);
		
	type ObjectThisInfoCollection is ref cursor return ObjectThisInfo;

	type TypeInfo is record(
		typeId number,
		typeName varchar2(2000),
		abstractInfo number
	);
	
	type TypeInfoCollection is ref cursor return TypeInfo;
	
	type AssociationInfo is record(
		associationId number,
		ownerId number,
		associationName varchar2(2000),
		targetId number,
		complexityInfo number
	);
	
	type AssociationInfoCollection is ref cursor return AssociationInfo;

    Integer_CN constant number := 1;
    String_CN constant number := 2;
    Date_CN constant number := 3;
    Text_CN constant number := 4;
    Timestamp_CN constant number := 5;
    CrtCntnCMD_CN constant number := 119;
        CrtCntnCMDNm_AN constant number := 10030;
        CrtCntnCMDInvoker_AN constant number := 10031;
        CrtCntnCMDCReceiver_AN constant number := 10032;
        CrtCntnCMDMyCmmnDt_AN constant number := 10033;
    AnMngr_CN constant number := 120;
        AnMngrCntns_AN constant number := 10034;
        AnMngrThis_AN constant number := 10035;
    CmmndExctr_CN constant number := -103;
        CmmndExctrCommands_AN constant number := 10003;
    CmmndCrdntr_CN constant number := -106;
        CmmndCrdntrExctr_AN constant number := 10009;
    CmmnDt_CN constant number := 108;
        CmmnDtCrtdt_AN constant number := 10013;
        CmmnDtCmmtdt_AN constant number := 10014;
    Cntn_CN constant number := 121;
        CntnNm_AN constant number := 10036;
        CntnThis_AN constant number := 10037;
    Srvr_CN constant number := -112;
        SrvrThis_AN constant number := 10041;
        SrvrPassword_AN constant number := 10026;
        SrvrUser_AN constant number := 10027;
        SrvrHackCount_AN constant number := 10043;
        SrvrHackDelay_AN constant number := 10044;
    CMD_CN constant number := 114;
    Invoker_CN constant number := 113;
    AnMngrCMD_CN constant number := 123;
    Remote_CN constant number := 115;
    Dcrts_CN constant number := 116;
    Anything_CN constant number := 118;

  	procedure insertType(typeId number, className varchar2, concreteVal number);
  	function getTypeInfos return TypeInfoCollection;
  	procedure insertSpecialization(ancestorVal number, descendantVal number);
  	procedure insertAssociation(associationId number, associationName varchar2, ownerId number, targetId number, complexityId number);
  	procedure insertAssociation3(associationId number, associationName varchar2, ownerId number, keyId number, targetId number);
  	function getAssociationInfos return AssociationInfoCollection;
  	procedure checkConcrete(typeId number);
  	/* throws exception if not */
  	procedure checkHasAsDescendant(ancestorVal number, descendantVal number);
  	/* throws exception if not */
  	procedure checkIfObjectExists(objectId number, classId number);
  	/* throws exception if not */
	procedure initialize;
	procedure deleteObject(objectId number, classId number);
end;
/
