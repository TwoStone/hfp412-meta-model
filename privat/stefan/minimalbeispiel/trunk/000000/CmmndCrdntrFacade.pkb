create or replace package body CmmndCrdntrFacade is
    
    procedure chkCmmndCrdntr(CmmndCrdntrId number) is
    currentClass number;
    begin
        select Cls into currentClass from CmmndCrdntr where id = CmmndCrdntrId;
        if currentClass <> -106 then
            raise_application_error(-20000, 'Object not of right class! Required: -106 Actual: ' || currentClass);
        end if; 
    end chkCmmndCrdntr;
    
    function getTheCmmndCrdntr return number is
    result number;
    begin
        select id into result from CmmndCrdntr where Cls = -106;
        return result;
    exception
        when no_data_found then
        begin
            select SCmmndCrdntr.nextVal into result from dual;
            insert into CmmndCrdntr (id,Cls)
                values (result,-106);
            return result * -1;
        end;
    end getTheCmmndCrdntr;
    
    function getCmmndCrdntr(CmmndCrdntrId number) return CmmndCrdntrInfoColl is 
    result CmmndCrdntrInfoColl;
    begin
        chkCmmndCrdntr(CmmndCrdntrId);
        open result for select id from CmmndCrdntr
            where id = CmmndCrdntrId and Cls = -106;
        return result;
    end getCmmndCrdntr;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from CmmndCrdntr where id = objectId;
        return result;
    end getClass;
    procedure chkSpecCmmndCrdntr(CmmndCrdntrId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from CmmndCrdntr base, Specialization spec
             where base.id = CmmndCrdntrId and base.Cls = spec.descendant and spec.ancestor = -106;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: -106 Actual: ' || currentClass);
    end chkSpecCmmndCrdntr;
    
    function exctrGet(CmmndCrdntrId number) return ManyServices.ManyInfoCollection is 
    result ManyServices.ManyInfoCollection;
    begin
        chkSpecCmmndCrdntr(CmmndCrdntrId);
        open result for select exctr, Cls, id from CmmndCrdntrExctr
            where frm = CmmndCrdntrId
            order by id asc;
        return result;
    end exctrGet;
    
    function exctrAdd(CmmndCrdntrId number, exctrVal number, exctrCls number) return number is
    result number;
    begin
        chkSpecCmmndCrdntr(CmmndCrdntrId);
        ClassFacade.checkIfObjectExists(exctrVal, exctrCls);
        ClassFacade.checkHasAsDescendant(-103, exctrCls);
        select SCmmndCrdntrExctr.nextVal into result from dual;
        insert into CmmndCrdntrExctr (id, frm, exctr, Cls)
        values (result, CmmndCrdntrId, exctrVal, exctrCls);
        return result;
    end exctrAdd;
    
    procedure exctrRem(exctrId number) is
    begin
        delete from CmmndCrdntrExctr where id = exctrId;
    end exctrRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end CmmndCrdntrFacade;
/

