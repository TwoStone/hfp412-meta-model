create or replace package body SrvrFacade is
    
    procedure chkSrvr(SrvrId number) is
    currentClass number;
    begin
        select Cls into currentClass from Srvr where id = SrvrId;
        if currentClass <> -112 then
            raise_application_error(-20000, 'Object not of right class! Required: -112 Actual: ' || currentClass);
        end if; 
    end chkSrvr;
    
    function newSrvr(passwordVal varchar2,userVal varchar2,hackCountVal number,hackDelayVal Timestamp) return number is
    result number;
    begin
        select SSrvr.nextVal into result from dual;
        insert into Srvr (id,Cls,SrvrPassword,SrvrUser,SrvrHackCount,SrvrHackDelay)
            values (result,-112,passwordVal,userVal,hackCountVal,hackDelayVal);
        return result;
    end newSrvr;
    
    function getSrvr(SrvrId number) return SrvrInfoColl is 
    result SrvrInfoColl;
    begin
        chkSrvr(SrvrId);
        open result for select id,SrvrThis,SrvrThisCls,SrvrPassword,SrvrUser,SrvrHackCount,SrvrHackDelay from Srvr
            where id = SrvrId and Cls = -112;
        return result;
    end getSrvr;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from Srvr where id = objectId;
        return result;
    end getClass;
    procedure chkSpecSrvr(SrvrId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Srvr base, Specialization spec
             where base.id = SrvrId and base.Cls = spec.descendant and spec.ancestor = -112;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: -112 Actual: ' || currentClass);
    end chkSpecSrvr;
    
    function getSrvrByUser(user varchar2) return SrvrFacade.SrvrAllColl is 
    result SrvrFacade.SrvrAllColl;
    begin
        open result for select id,Cls,SrvrThis,SrvrThisCls,SrvrPassword,SrvrUser,SrvrHackCount,SrvrHackDelay from Srvr where SrvrUser like user and (id,Cls) not in (select * from DeletedObjects);
        return result;
    end getSrvrByUser;
    
    procedure ThisSet(SrvrId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecSrvr(SrvrId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(-112, ThisCls);
        update Srvr set SrvrThis = ThisVal where id = SrvrId;
        update Srvr set SrvrThisCls = ThisCls where id = SrvrId;
    end ThisSet;
    
    
    procedure passwordSet(SrvrId number, passwordVal varchar2)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrPassword = passwordVal where id = SrvrId;
    end passwordSet;
    
    
    procedure userSet(SrvrId number, userVal varchar2)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrUser = userVal where id = SrvrId;
    end userSet;
    
    
    procedure hackCountSet(SrvrId number, hackCountVal number)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrHackCount = hackCountVal where id = SrvrId;
    end hackCountSet;
    
    
    procedure hackDelaySet(SrvrId number, hackDelayVal Timestamp)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrHackDelay = hackDelayVal where id = SrvrId;
    end hackDelaySet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end SrvrFacade;
/

