create or replace package body CntnFacade is
    
    procedure chkCntn(CntnId number) is
    currentClass number;
    begin
        select Cls into currentClass from Cntn where id = CntnId;
        if currentClass <> 121 then
            raise_application_error(-20000, 'Object not of right class! Required: 121 Actual: ' || currentClass);
        end if; 
    end chkCntn;
    
    function newCntn(nmVal varchar2) return number is
    result number;
    begin
        select SCntn.nextVal into result from dual;
        insert into Cntn (id,Cls,CntnNm)
            values (result,121,nmVal);
        return result;
    end newCntn;
    
    function getCntn(CntnId number) return CntnInfoColl is 
    result CntnInfoColl;
    begin
        chkCntn(CntnId);
        open result for select id,CntnNm,CntnThis,CntnThisCls from Cntn
            where id = CntnId and Cls = 121;
        return result;
    end getCntn;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from Cntn where id = objectId;
        return result;
    end getClass;
    procedure chkSpecCntn(CntnId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Cntn base, Specialization spec
             where base.id = CntnId and base.Cls = spec.descendant and spec.ancestor = 121;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 121 Actual: ' || currentClass);
    end chkSpecCntn;
    
    function getCntnByNm(nm varchar2) return CntnFacade.CntnAllColl is 
    result CntnFacade.CntnAllColl;
    begin
        open result for select id,Cls,CntnNm,CntnThis,CntnThisCls from Cntn where CntnNm like nm and (id,Cls) not in (select * from DeletedObjects);
        return result;
    end getCntnByNm;
    
    procedure nmSet(CntnId number, nmVal varchar2)is
    begin 
        chkSpecCntn(CntnId);
        update Cntn set CntnNm = nmVal where id = CntnId;
    end nmSet;
    
    
    procedure ThisSet(CntnId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecCntn(CntnId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(121, ThisCls);
        update Cntn set CntnThis = ThisVal where id = CntnId;
        update Cntn set CntnThisCls = ThisCls where id = CntnId;
    end ThisSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end CntnFacade;
/

