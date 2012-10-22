create or replace package CmmndCrdntrFacade is
    
    type CmmndCrdntrAll is record (
        id number,
        Cls number
    );
    
    type CmmndCrdntrAllColl is ref cursor return CmmndCrdntrAll;
    
    
    type CmmndCrdntrInfo is record (
        id number        
    );
    
    type CmmndCrdntrInfoColl is ref cursor return CmmndCrdntrInfo;
    
    function getTheCmmndCrdntr return number;
    function getCmmndCrdntr(CmmndCrdntrId number) return CmmndCrdntrInfoColl;
    function getClass(objectId number) return number;
    function exctrGet(CmmndCrdntrId number) return ManyServices.ManyInfoCollection;
    function exctrAdd(CmmndCrdntrId number, exctrVal number, exctrCls number) return number;
    procedure exctrRem(exctrId number);
    
end CmmndCrdntrFacade;
/

