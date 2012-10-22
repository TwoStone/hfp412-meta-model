create or replace package body ClassFacade is

  procedure insertType(typeId number, className varchar2, concreteVal number) is
  begin
    insert into  Cls (id, name, concrete) values (typeId, className, concreteVal);
  end;

  function getTypeInfos return TypeInfoCollection is
    result TypeInfoCollection;
  begin
	open result for select * from Cls;
	return result;
  end;
  
  procedure insertSpecialization(ancestorVal number, descendantVal number) is
  test number;
  begin
    select id into test from Specialization where ancestor = descendantVal and descendant = ancestorVal;
	raise_application_error(-20000, 'Cyclic specialization');
  exception
    when no_data_found then
	  begin
	    insert into Specialization select SSpecialization.nextVal, a.ancestor, b.descendant
			   					   from Specialization a, Specialization b
								   where a.descendant = ancestorVal and b.ancestor = descendantVal
								   and (a.ancestor, b.descendant)
								     not in (select ancestor, descendant from Specialization);
	  end;
  end;

  procedure insertAssociation(associationId number, associationName varchar2, ownerId number, targetId number, complexityId number) is
  begin
  	insert into Association (id, name, owner, target, complexity) values(associationId, associationName, ownerId, targetId, complexityId);
  end;

  procedure insertAssociation3(associationId number, associationName varchar2, ownerId number, keyId number, targetId number) is
  begin
  	insert into Association3 (id, name, owner, indxx, target) values (associationId, associationName, ownerId, keyId, targetId);
  end;

  function getAssociationInfos return AssociationInfoCollection is
    result AssociationInfoCollection;
  begin
	open result for select * from Association;
	return result;
  end;

  procedure checkConcrete(typeId number) is
  /* throws exception if not */
  concr number;
  begin
    select concrete into concr from Cls where id = typeId;
	if (concr <> concreteRepresentation) then
	  raise_application_error(-20000, 'Type not concrete');
	end if;
  end;

  procedure checkHasAsDescendant(ancestorVal number, descendantVal number) is
  /* throws exception if not */
  test number;
  begin
    select id into test from Specialization where ancestor = ancestorVal and descendant = descendantVal;
  exception
    when no_data_found then raise_application_error(-20000, descendantVal || ' is not a specialization of ' || ancestorVal);
  end;

  procedure checkIfObjectExists(objectId number, classId number) is
  test number;
  /* throws exception if not */
  begin

        if classId = 119 then
            select id into test from CrtCntnCMD
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 120 then
            select id into test from AnMngr
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = -103 then
            select id into test from CmmndExctr
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = -106 then
            select id into test from CmmndCrdntr
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 108 then
            select id into test from CmmnDt
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = 121 then
            select id into test from Cntn
                where id = objectId and Cls = classId;
            return;
        end if;
        if classId = -112 then
            select id into test from Srvr
                where id = objectId and Cls = classId;
            return;
        end if;

    raise_application_error(-20000, 'Object does not exist! objectId: ' || objectId || ' classId: ' || classId);
  exception
    when no_data_found then raise_application_error(-20000, 'Object does not exist! objectId: ' || objectId || ' classId: ' || classId);
  end;

  procedure initialize is
  numberOfEntries number;
  begin
    select count(*) into numberOfEntries from Cls;
    if numberOfEntries = 0 then

                insertType(Integer_CN, 'Integer', 1);
                insertType(String_CN, 'String', 1);
                insertType(Date_CN, 'Date', 1);
                insertType(Text_CN, 'Text', 1);
                insertType(Timestamp_CN, 'Timestamp', 1);
                insertType(CrtCntnCMD_CN, 'CrtCntnCMD', 1);
                insertType(AnMngr_CN, 'AnMngr', 1);
                insertType(CmmndExctr_CN, 'CmmndExctr', 1);
                insertType(CmmndCrdntr_CN, 'CmmndCrdntr', 1);
                insertType(CmmnDt_CN, 'CmmnDt', 1);
                insertType(Cntn_CN, 'Cntn', 1);
                insertType(Srvr_CN, 'Srvr', 1);
                insertType(CMD_CN, 'CMD', 0);
                insertType(Invoker_CN, 'Invoker', 0);
                insertType(AnMngrCMD_CN, 'AnMngrCMD', 0);
                insertType(Remote_CN, 'Remote', 0);
                insertType(Dcrts_CN, 'Dcrts', 0);
                insertType(Anything_CN, 'Anything', 0);
                insertAssociation(CrtCntnCMDNm_AN, 'CrtCntnCMDNm', 119, 2, 0);
                insertAssociation(CrtCntnCMDInvoker_AN, 'CrtCntnCMDInvoker', 119, 113, 0);
                insertAssociation(CrtCntnCMDCReceiver_AN, 'CrtCntnCMDCReceiver', 119, 120, 0);
                insertAssociation(CrtCntnCMDMyCmmnDt_AN, 'CrtCntnCMDMyCmmnDt', 119, 108, 0);
                insertAssociation(AnMngrCntns_AN, 'AnMngrCntns', 120, 121, 1);
                insertAssociation(AnMngrThis_AN, 'AnMngrThis', 120, 120, 0);
                insertAssociation(CmmndExctrCommands_AN, 'CmmndExctrCommands', -103, 114, 1);
                insertAssociation(CmmndCrdntrExctr_AN, 'CmmndCrdntrExctr', -106, -103, 1);
                insertAssociation(CmmnDtCrtdt_AN, 'CmmnDtCrtdt', 108, 3, 0);
                insertAssociation(CmmnDtCmmtdt_AN, 'CmmnDtCmmtdt', 108, 3, 0);
                insertAssociation(CntnNm_AN, 'CntnNm', 121, 2, 0);
                insertAssociation(CntnThis_AN, 'CntnThis', 121, 121, 0);
                insertAssociation(SrvrThis_AN, 'SrvrThis', -112, -112, 0);
                insertAssociation(SrvrPassword_AN, 'SrvrPassword', -112, 2, 0);
                insertAssociation(SrvrUser_AN, 'SrvrUser', -112, 2, 0);
                insertAssociation(SrvrHackCount_AN, 'SrvrHackCount', -112, 1, 0);
                insertAssociation(SrvrHackDelay_AN, 'SrvrHackDelay', -112, 5, 0);

    end if;
    select count(*) into numberOfEntries from Specialization;
    if numberOfEntries = 0 then

                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 1, 1);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 2, 2);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 3, 3);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 5, 5);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 4, 4);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 119, 119);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 120, 120);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, -103, -103);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, -106, -106);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 108, 108);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 121, 121);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, -112, -112);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 114, 114);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 113, 113);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 123, 123);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 115, 115);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 116, 116);
                insert into Specialization(id, ancestor, descendant) values (SSpecialization.nextVal, 118, 118);
                insertSpecialization(CmmnDt_CN, CrtCntnCMD_CN);
                insertSpecialization(AnMngrCMD_CN, CrtCntnCMD_CN);
                insertSpecialization(Anything_CN, CrtCntnCMD_CN);
                insertSpecialization(Anything_CN, AnMngr_CN);
                insertSpecialization(Anything_CN, CmmndExctr_CN);
                insertSpecialization(Anything_CN, CmmndCrdntr_CN);
                insertSpecialization(Anything_CN, CmmnDt_CN);
                insertSpecialization(Anything_CN, Cntn_CN);
                insertSpecialization(Invoker_CN, Srvr_CN);
                insertSpecialization(Remote_CN, Srvr_CN);
                insertSpecialization(Anything_CN, Srvr_CN);
                insertSpecialization(CMD_CN, AnMngrCMD_CN);

    end if;
  end;

  procedure deleteObject(objectId number, classId number) is
    oldObjectId number;
    oldClassId number;
  begin
    select id,instanceof into oldObjectId,oldClassId from DeletedObjects where id = objectId and instanceOf = classId;
  exception
    when no_data_found then
      begin
        insert into DeletedObjects (id, instanceOf) values (objectId,classId);
      end;
  end;

end;
/
