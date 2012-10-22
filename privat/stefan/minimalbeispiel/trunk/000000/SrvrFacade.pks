create or replace package SrvrFacade is
    
    type SrvrAll is record (
        id number,
        Cls number,
        SrvrThis number,
        SrvrThisCls number,
        SrvrPassword varchar2(2000),
        SrvrUser varchar2(2000),
        SrvrHackCount number,
        SrvrHackDelay Timestamp
    );
    
    type SrvrAllColl is ref cursor return SrvrAll;
    
    
    type SrvrInfo is record (
        id number,
        This number, 
        ThisCls number,
        password varchar2(2000),
        user varchar2(2000),
        hackCount number,
        hackDelay Timestamp        
    );
    
    type SrvrInfoColl is ref cursor return SrvrInfo;
    
    function getSrvr(SrvrId number) return SrvrInfoColl;
    function newSrvr(passwordVal varchar2,userVal varchar2,hackCountVal number,hackDelayVal Timestamp) return number;
    function getClass(objectId number) return number;
    function getSrvrByUser(user varchar2) return SrvrFacade.SrvrAllColl;
    procedure ThisSet(SrvrId number, ThisVal number, ThisCls number);
    procedure passwordSet(SrvrId number, passwordVal varchar2);
    procedure userSet(SrvrId number, userVal varchar2);
    procedure hackCountSet(SrvrId number, hackCountVal number);
    procedure hackDelaySet(SrvrId number, hackDelayVal Timestamp);
    
end SrvrFacade;
/

