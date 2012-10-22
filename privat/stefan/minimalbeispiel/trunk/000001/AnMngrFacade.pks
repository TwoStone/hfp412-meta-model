create or replace package AnMngrFacade is
    
    type AnMngrAll is record (
        id number,
        Cls number,
        AnMngrThis number,
        AnMngrThisCls number
    );
    
    type AnMngrAllColl is ref cursor return AnMngrAll;
    
    
    type AnMngrInfo is record (
        id number,
        This number, 
        ThisCls number        
    );
    
    type AnMngrInfoColl is ref cursor return AnMngrInfo;
    
    function getTheAnMngr return number;
    function getAnMngr(AnMngrId number) return AnMngrInfoColl;
    function getClass(objectId number) return number;
    procedure ThisSet(AnMngrId number, ThisVal number, ThisCls number);
    function cntnsGet(AnMngrId number) return ManyServices.ManyInfoCollection;
    function cntnsAdd(AnMngrId number, cntnsVal number, cntnsCls number) return number;
    procedure cntnsRem(cntnsId number);
    
end AnMngrFacade;
/

