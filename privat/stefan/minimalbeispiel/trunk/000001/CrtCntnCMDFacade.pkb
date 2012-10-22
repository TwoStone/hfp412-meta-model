create or replace package body CrtCntnCMDFacade is
    
    procedure chkCrtCntnCMD(CrtCntnCMDId number) is
    currentClass number;
    begin
        select Cls into currentClass from CrtCntnCMD where id = CrtCntnCMDId;
        if currentClass <> 119 then
            raise_application_error(-20000, 'Object not of right class! Required: 119 Actual: ' || currentClass);
        end if; 
    end chkCrtCntnCMD;
    
    function newCrtCntnCMD(nmVal varchar2) return number is
    result number;
    begin
        select SCrtCntnCMD.nextVal into result from dual;
        insert into CrtCntnCMD (id,Cls,CrtCntnCMDNm)
            values (result,119,nmVal);
        return result;
    end newCrtCntnCMD;
    
    function getCrtCntnCMD(CrtCntnCMDId number) return CrtCntnCMDInfoColl is 
    result CrtCntnCMDInfoColl;
    begin
        chkCrtCntnCMD(CrtCntnCMDId);
        open result for select id,CrtCntnCMDNm,CrtCntnCMDInvoker,CrtCntnCMDInvokerCls,CrtCntnCMDCReceiver,CrtCntnCMDCReceiverCls,CrtCntnCMDMyCmmnDt,CrtCntnCMDMyCmmnDtCls from CrtCntnCMD
            where id = CrtCntnCMDId and Cls = 119;
        return result;
    end getCrtCntnCMD;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from CrtCntnCMD where id = objectId;
        return result;
    end getClass;
    procedure chkSpecCrtCntnCMD(CrtCntnCMDId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from CrtCntnCMD base, Specialization spec
             where base.id = CrtCntnCMDId and base.Cls = spec.descendant and spec.ancestor = 119;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 119 Actual: ' || currentClass);
    end chkSpecCrtCntnCMD;
    
    procedure nmSet(CrtCntnCMDId number, nmVal varchar2)is
    begin 
        chkSpecCrtCntnCMD(CrtCntnCMDId);
        update CrtCntnCMD set CrtCntnCMDNm = nmVal where id = CrtCntnCMDId;
    end nmSet;
    
    
    procedure invokerSet(CrtCntnCMDId number, invokerVal number, invokerCls number)is
    begin 
        chkSpecCrtCntnCMD(CrtCntnCMDId);
        ClassFacade.checkIfObjectExists(invokerVal, invokerCls);
        ClassFacade.checkHasAsDescendant(113, invokerCls);
        update CrtCntnCMD set CrtCntnCMDInvoker = invokerVal where id = CrtCntnCMDId;
        update CrtCntnCMD set CrtCntnCMDInvokerCls = invokerCls where id = CrtCntnCMDId;
    end invokerSet;
    
    
    procedure cReceiverSet(CrtCntnCMDId number, cReceiverVal number, cReceiverCls number)is
    begin 
        chkSpecCrtCntnCMD(CrtCntnCMDId);
        ClassFacade.checkIfObjectExists(cReceiverVal, cReceiverCls);
        ClassFacade.checkHasAsDescendant(120, cReceiverCls);
        update CrtCntnCMD set CrtCntnCMDCReceiver = cReceiverVal where id = CrtCntnCMDId;
        update CrtCntnCMD set CrtCntnCMDCReceiverCls = cReceiverCls where id = CrtCntnCMDId;
    end cReceiverSet;
    
    
    procedure myCmmnDtSet(CrtCntnCMDId number, myCmmnDtVal number, myCmmnDtCls number)is
    begin 
        chkSpecCrtCntnCMD(CrtCntnCMDId);
        ClassFacade.checkIfObjectExists(myCmmnDtVal, myCmmnDtCls);
        ClassFacade.checkHasAsDescendant(108, myCmmnDtCls);
        update CrtCntnCMD set CrtCntnCMDMyCmmnDt = myCmmnDtVal where id = CrtCntnCMDId;
        update CrtCntnCMD set CrtCntnCMDMyCmmnDtCls = myCmmnDtCls where id = CrtCntnCMDId;
    end myCmmnDtSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end CrtCntnCMDFacade;
/

