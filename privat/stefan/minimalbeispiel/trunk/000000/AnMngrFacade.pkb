create or replace package body AnMngrFacade is
    
    procedure chkAnMngr(AnMngrId number) is
    currentClass number;
    begin
        select Cls into currentClass from AnMngr where id = AnMngrId;
        if currentClass <> 120 then
            raise_application_error(-20000, 'Object not of right class! Required: 120 Actual: ' || currentClass);
        end if; 
    end chkAnMngr;
    
    function getTheAnMngr return number is
    result number;
    begin
        select id into result from AnMngr where Cls = 120;
        return result;
    exception
        when no_data_found then
        begin
            select SAnMngr.nextVal into result from dual;
            insert into AnMngr (id,Cls)
                values (result,120);
            return result * -1;
        end;
    end getTheAnMngr;
    
    function getAnMngr(AnMngrId number) return AnMngrInfoColl is 
    result AnMngrInfoColl;
    begin
        chkAnMngr(AnMngrId);
        open result for select id,AnMngrThis,AnMngrThisCls from AnMngr
            where id = AnMngrId and Cls = 120;
        return result;
    end getAnMngr;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from AnMngr where id = objectId;
        return result;
    end getClass;
    procedure chkSpecAnMngr(AnMngrId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from AnMngr base, Specialization spec
             where base.id = AnMngrId and base.Cls = spec.descendant and spec.ancestor = 120;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 120 Actual: ' || currentClass);
    end chkSpecAnMngr;
    
    procedure ThisSet(AnMngrId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecAnMngr(AnMngrId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(120, ThisCls);
        update AnMngr set AnMngrThis = ThisVal where id = AnMngrId;
        update AnMngr set AnMngrThisCls = ThisCls where id = AnMngrId;
    end ThisSet;
    
    
    function cntnsGet(AnMngrId number) return ManyServices.ManyInfoCollection is 
    result ManyServices.ManyInfoCollection;
    begin
        chkSpecAnMngr(AnMngrId);
        open result for select cntns, Cls, id from AnMngrCntns
            where frm = AnMngrId
            order by id asc;
        return result;
    end cntnsGet;
    
    function cntnsAdd(AnMngrId number, cntnsVal number, cntnsCls number) return number is
    result number;
    begin
        chkSpecAnMngr(AnMngrId);
        ClassFacade.checkIfObjectExists(cntnsVal, cntnsCls);
        ClassFacade.checkHasAsDescendant(121, cntnsCls);
        select SAnMngrCntns.nextVal into result from dual;
        insert into AnMngrCntns (id, frm, cntns, Cls)
        values (result, AnMngrId, cntnsVal, cntnsCls);
        return result;
    end cntnsAdd;
    
    procedure cntnsRem(cntnsId number) is
    begin
        delete from AnMngrCntns where id = cntnsId;
    end cntnsRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end AnMngrFacade;
/

