create or replace package CntnFacade is
    
    type CntnAll is record (
        id number,
        Cls number,
        CntnNm varchar2(2000),
        CntnThis number,
        CntnThisCls number
    );
    
    type CntnAllColl is ref cursor return CntnAll;
    
    
    type CntnInfo is record (
        id number,
        nm varchar2(2000),
        This number, 
        ThisCls number        
    );
    
    type CntnInfoColl is ref cursor return CntnInfo;
    
    function getCntn(CntnId number) return CntnInfoColl;
    function newCntn(nmVal varchar2) return number;
    function getClass(objectId number) return number;
    function getCntnByNm(nm varchar2) return CntnFacade.CntnAllColl;
    procedure nmSet(CntnId number, nmVal varchar2);
    procedure ThisSet(CntnId number, ThisVal number, ThisCls number);
    
end CntnFacade;
/

