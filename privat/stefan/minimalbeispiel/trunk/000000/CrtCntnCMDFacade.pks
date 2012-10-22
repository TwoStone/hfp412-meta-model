create or replace package CrtCntnCMDFacade is
    
    type CrtCntnCMDAll is record (
        id number,
        Cls number,
        CrtCntnCMDNm varchar2(2000),
        CrtCntnCMDInvoker number,
        CrtCntnCMDInvokerCls number,
        CrtCntnCMDCReceiver number,
        CrtCntnCMDCReceiverCls number,
        CrtCntnCMDMyCmmnDt number,
        CrtCntnCMDMyCmmnDtCls number
    );
    
    type CrtCntnCMDAllColl is ref cursor return CrtCntnCMDAll;
    
    
    type CrtCntnCMDInfo is record (
        id number,
        nm varchar2(2000),
        invoker number, 
        invokerCls number,
        cReceiver number, 
        cReceiverCls number,
        myCmmnDt number, 
        myCmmnDtCls number        
    );
    
    type CrtCntnCMDInfoColl is ref cursor return CrtCntnCMDInfo;
    
    function getCrtCntnCMD(CrtCntnCMDId number) return CrtCntnCMDInfoColl;
    function newCrtCntnCMD(nmVal varchar2) return number;
    function getClass(objectId number) return number;
    procedure nmSet(CrtCntnCMDId number, nmVal varchar2);
    procedure invokerSet(CrtCntnCMDId number, invokerVal number, invokerCls number);
    procedure cReceiverSet(CrtCntnCMDId number, cReceiverVal number, cReceiverCls number);
    procedure myCmmnDtSet(CrtCntnCMDId number, myCmmnDtVal number, myCmmnDtCls number);
    
end CrtCntnCMDFacade;
/

