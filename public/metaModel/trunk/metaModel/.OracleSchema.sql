create table Cls(
    id number primary key,
    name varchar2(2000) not null,
    concrete number not null
);

create table DeletedObjects(
    id number,
    instanceOf number not null,
    constraint FDeletedObjectsInstanceOf foreign key (instanceOf) references Cls(id)
);
create unique index DltdObjInx on DeletedObjects (id, instanceOf);

create sequence SSpecialization nocache;

create table Specialization (
    id number primary key,
    ancestor number,
    constraint FSpecializationAncestor foreign key (ancestor) references Cls(id),
    descendant number,
    constraint FSpecializationDescendant foreign key (descendant) references Cls(id)
);

create table Association (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociationOwner foreign key (owner) references Cls(id),
    target number,
    constraint FAssociationTarget foreign key (target) references Cls(id),
    complexity number
);

create table Association3 (
    id number,
    owner number,
    name varchar2(2000),
    constraint FAssociation3Owner foreign key (owner) references Cls(id),
    indxx number,
    constraint FAssociation3Indxx foreign key (indxx) references Cls(id),
    target number,
    constraint FAssociation3Target foreign key (target) references Cls(id)
);

create sequence SCrtMObjctCMD nocache;

create table CrtMObjctCMD(
    id number primary key,
    Cls number not null,
    CrtMObjctCMDInvoker number,
    CrtMObjctCMDInvokerCls number,
    constraint FCrtMObjctCMDInvoker foreign key (CrtMObjctCMDInvokerCls) references Cls (id),
    CrtMObjctCMDCReceiver number,
    CrtMObjctCMDCReceiverCls number,
    constraint FCrtMObjctCMDCReceiver foreign key (CrtMObjctCMDCReceiverCls) references Cls (id),
    CrtMObjctCMDCResult number,
    CrtMObjctCMDCResultCls number,
    constraint FCrtMObjctCMDCResult foreign key (CrtMObjctCMDCResultCls) references Cls (id),
    CrtMObjctCMDMyCmmnDt number,
    CrtMObjctCMDMyCmmnDtCls number,
    constraint FCrtMObjctCMDMyCmmnDt foreign key (CrtMObjctCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtUntTpCMD nocache;

create table CrtUntTpCMD(
    id number primary key,
    Cls number not null,
    CrtUntTpCMDNm varchar2(2000),
    CrtUntTpCMDInvoker number,
    CrtUntTpCMDInvokerCls number,
    constraint FCrtUntTpCMDInvoker foreign key (CrtUntTpCMDInvokerCls) references Cls (id),
    CrtUntTpCMDCReceiver number,
    CrtUntTpCMDCReceiverCls number,
    constraint FCrtUntTpCMDCReceiver foreign key (CrtUntTpCMDCReceiverCls) references Cls (id),
    CrtUntTpCMDMyCmmnDt number,
    CrtUntTpCMDMyCmmnDtCls number,
    constraint FCrtUntTpCMDMyCmmnDt foreign key (CrtUntTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtAspctCMD nocache;

create table CrtAspctCMD(
    id number primary key,
    Cls number not null,
    CrtAspctCMDNm varchar2(2000),
    CrtAspctCMDInvoker number,
    CrtAspctCMDInvokerCls number,
    constraint FCrtAspctCMDInvoker foreign key (CrtAspctCMDInvokerCls) references Cls (id),
    CrtAspctCMDCReceiver number,
    CrtAspctCMDCReceiverCls number,
    constraint FCrtAspctCMDCReceiver foreign key (CrtAspctCMDCReceiverCls) references Cls (id),
    CrtAspctCMDCResult number,
    CrtAspctCMDCResultCls number,
    constraint FCrtAspctCMDCResult foreign key (CrtAspctCMDCResultCls) references Cls (id),
    CrtAspctCMDMyCmmnDt number,
    CrtAspctCMDMyCmmnDtCls number,
    constraint FCrtAspctCMDMyCmmnDt foreign key (CrtAspctCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtUntCMD nocache;

create table CrtUntCMD(
    id number primary key,
    Cls number not null,
    CrtUntCMDNm varchar2(2000),
    CrtUntCMDTp number,
    CrtUntCMDTpCls number,
    constraint FCrtUntCMDTp foreign key (CrtUntCMDTpCls) references Cls (id),
    CrtUntCMDInvoker number,
    CrtUntCMDInvokerCls number,
    constraint FCrtUntCMDInvoker foreign key (CrtUntCMDInvokerCls) references Cls (id),
    CrtUntCMDCReceiver number,
    CrtUntCMDCReceiverCls number,
    constraint FCrtUntCMDCReceiver foreign key (CrtUntCMDCReceiverCls) references Cls (id),
    CrtUntCMDMyCmmnDt number,
    CrtUntCMDMyCmmnDtCls number,
    constraint FCrtUntCMDMyCmmnDt foreign key (CrtUntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAbsOprtn nocache;

create table AbsOprtn(
    id number primary key,
    Cls number not null,
    AbsOprtnNm varchar2(2000),
    AbsOprtnSrc number,
    AbsOprtnSrcCls number,
    constraint FAbsOprtnSrc foreign key (AbsOprtnSrcCls) references Cls (id),
    AbsOprtnTrgt number,
    AbsOprtnTrgtCls number,
    constraint FAbsOprtnTrgt foreign key (AbsOprtnTrgtCls) references Cls (id),
    AbsOprtnThis number,
    AbsOprtnThisCls number,
    constraint FAbsOprtnThis foreign key (AbsOprtnThisCls) references Cls (id)    
);
create index INmAbsOprtn on AbsOprtn (AbsOprtnNm);


create sequence SAddDfltUntCMD nocache;

create table AddDfltUntCMD(
    id number primary key,
    Cls number not null,
    AddDfltUntCMDTp number,
    AddDfltUntCMDTpCls number,
    constraint FAddDfltUntCMDTp foreign key (AddDfltUntCMDTpCls) references Cls (id),
    AddDfltUntCMDUnt number,
    AddDfltUntCMDUntCls number,
    constraint FAddDfltUntCMDUnt foreign key (AddDfltUntCMDUntCls) references Cls (id),
    AddDfltUntCMDInvoker number,
    AddDfltUntCMDInvokerCls number,
    constraint FAddDfltUntCMDInvoker foreign key (AddDfltUntCMDInvokerCls) references Cls (id),
    AddDfltUntCMDCReceiver number,
    AddDfltUntCMDCReceiverCls number,
    constraint FAddDfltUntCMDCReceiver foreign key (AddDfltUntCMDCReceiverCls) references Cls (id),
    AddDfltUntCMDMyCmmnDt number,
    AddDfltUntCMDMyCmmnDtCls number,
    constraint FAddDfltUntCMDMyCmmnDt foreign key (AddDfltUntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SRmvAssFrmHrCMD nocache;

create table RmvAssFrmHrCMD(
    id number primary key,
    Cls number not null,
    RmvAssFrmHrCMDH number,
    RmvAssFrmHrCMDHCls number,
    constraint FRmvAssFrmHrCMDH foreign key (RmvAssFrmHrCMDHCls) references Cls (id),
    RmvAssFrmHrCMDA number,
    RmvAssFrmHrCMDACls number,
    constraint FRmvAssFrmHrCMDA foreign key (RmvAssFrmHrCMDACls) references Cls (id),
    RmvAssFrmHrCMDInvoker number,
    RmvAssFrmHrCMDInvokerCls number,
    constraint FRmvAssFrmHrCMDInvoker foreign key (RmvAssFrmHrCMDInvokerCls) references Cls (id),
    RmvAssFrmHrCMDCReceiver number,
    RmvAssFrmHrCMDCReceiverCls number,
    constraint FRmvAssFrmHrCMDCReceiver foreign key (RmvAssFrmHrCMDCReceiverCls) references Cls (id),
    RmvAssFrmHrCMDMyCmmnDt number,
    RmvAssFrmHrCMDMyCmmnDtCls number,
    constraint FRmvAssFrmHrCMDMyCmmnDt foreign key (RmvAssFrmHrCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SSrvr nocache;

create table Srvr(
    id number primary key,
    Cls number not null,
    SrvrThis number,
    SrvrThisCls number,
    constraint FSrvrThis foreign key (SrvrThisCls) references Cls (id),
    SrvrPassword varchar2(2000),
    SrvrUser varchar2(2000),
    SrvrHackCount number,
    SrvrHackDelay Timestamp    
);
create index IUserSrvr on Srvr (SrvrUser);


create sequence SRmvLnkCMD nocache;

create table RmvLnkCMD(
    id number primary key,
    Cls number not null,
    RmvLnkCMDLnk number,
    RmvLnkCMDLnkCls number,
    constraint FRmvLnkCMDLnk foreign key (RmvLnkCMDLnkCls) references Cls (id),
    RmvLnkCMDInvoker number,
    RmvLnkCMDInvokerCls number,
    constraint FRmvLnkCMDInvoker foreign key (RmvLnkCMDInvokerCls) references Cls (id),
    RmvLnkCMDCReceiver number,
    RmvLnkCMDCReceiverCls number,
    constraint FRmvLnkCMDCReceiver foreign key (RmvLnkCMDCReceiverCls) references Cls (id),
    RmvLnkCMDMyCmmnDt number,
    RmvLnkCMDMyCmmnDtCls number,
    constraint FRmvLnkCMDMyCmmnDt foreign key (RmvLnkCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SFrmlPrmtr nocache;

create table FrmlPrmtr(
    id number primary key,
    Cls number not null,
    FrmlPrmtrOfTp number,
    FrmlPrmtrOfTpCls number,
    constraint FFrmlPrmtrOfTp foreign key (FrmlPrmtrOfTpCls) references Cls (id),
    FrmlPrmtrNm varchar2(2000),
    FrmlPrmtrThis number,
    FrmlPrmtrThisCls number,
    constraint FFrmlPrmtrThis foreign key (FrmlPrmtrThisCls) references Cls (id)    
);
create index INmFrmlPrmtr on FrmlPrmtr (FrmlPrmtrNm);


create sequence SCrtHrrchCMD nocache;

create table CrtHrrchCMD(
    id number primary key,
    Cls number not null,
    CrtHrrchCMDA number,
    CrtHrrchCMDACls number,
    constraint FCrtHrrchCMDA foreign key (CrtHrrchCMDACls) references Cls (id),
    CrtHrrchCMDNm varchar2(2000),
    CrtHrrchCMDInvoker number,
    CrtHrrchCMDInvokerCls number,
    constraint FCrtHrrchCMDInvoker foreign key (CrtHrrchCMDInvokerCls) references Cls (id),
    CrtHrrchCMDCReceiver number,
    CrtHrrchCMDCReceiverCls number,
    constraint FCrtHrrchCMDCReceiver foreign key (CrtHrrchCMDCReceiverCls) references Cls (id),
    CrtHrrchCMDMyCmmnDt number,
    CrtHrrchCMDMyCmmnDtCls number,
    constraint FCrtHrrchCMDMyCmmnDt foreign key (CrtHrrchCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SOprtnMngr nocache;

create table OprtnMngr(
    id number primary key,
    Cls number not null,
    OprtnMngrThis number,
    OprtnMngrThisCls number,
    constraint FOprtnMngrThis foreign key (OprtnMngrThisCls) references Cls (id)    
);

create sequence SQntfObjct nocache;

create table QntfObjct(
    id number primary key,
    Cls number not null,
    QntfObjctObjct number,
    QntfObjctObjctCls number,
    constraint FQntfObjctObjct foreign key (QntfObjctObjctCls) references Cls (id),
    QntfObjctThis number,
    QntfObjctThisCls number,
    constraint FQntfObjctThis foreign key (QntfObjctThisCls) references Cls (id),
    MsrmntTp number,
    MsrmntTpCls number,
    constraint FMsrmntTp foreign key (MsrmntTpCls) references Cls (id),
    MsrmntQntt number,
    MsrmntQnttCls number,
    constraint FMsrmntQntt foreign key (MsrmntQnttCls) references Cls (id),
    AccntTp number,
    AccntTpCls number,
    constraint FAccntTp foreign key (AccntTpCls) references Cls (id)    
);
create index IObjctQntfObjct on QntfObjct (QntfObjctObjct, QntfObjctObjctCls);


create sequence SCrtMsrmntTpCMD nocache;

create table CrtMsrmntTpCMD(
    id number primary key,
    Cls number not null,
    CrtMsrmntTpCMDNm varchar2(2000),
    CrtMsrmntTpCMDTp number,
    CrtMsrmntTpCMDTpCls number,
    constraint FCrtMsrmntTpCMDTp foreign key (CrtMsrmntTpCMDTpCls) references Cls (id),
    CrtMsrmntTpCMDUntTp number,
    CrtMsrmntTpCMDUntTpCls number,
    constraint FCrtMsrmntTpCMDUntTp foreign key (CrtMsrmntTpCMDUntTpCls) references Cls (id),
    CrtMsrmntTpCMDInvoker number,
    CrtMsrmntTpCMDInvokerCls number,
    constraint FCrtMsrmntTpCMDInvoker foreign key (CrtMsrmntTpCMDInvokerCls) references Cls (id),
    CrtMsrmntTpCMDCReceiver number,
    CrtMsrmntTpCMDCReceiverCls number,
    constraint FCrtMsrmntTpCMDCReceiver foreign key (CrtMsrmntTpCMDCReceiverCls) references Cls (id),
    CrtMsrmntTpCMDMyCmmnDt number,
    CrtMsrmntTpCMDMyCmmnDtCls number,
    constraint FCrtMsrmntTpCMDMyCmmnDt foreign key (CrtMsrmntTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMQntObjctTp nocache;

create table MQntObjctTp(
    id number primary key,
    Cls number not null,
    MQntObjctTpTp number,
    MQntObjctTpTpCls number,
    constraint FMQntObjctTpTp foreign key (MQntObjctTpTpCls) references Cls (id),
    MQntObjctTpUntTp number,
    MQntObjctTpUntTpCls number,
    constraint FMQntObjctTpUntTp foreign key (MQntObjctTpUntTpCls) references Cls (id),
    MQntObjctTpThis number,
    MQntObjctTpThisCls number,
    constraint FMQntObjctTpThis foreign key (MQntObjctTpThisCls) references Cls (id)    
);

create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null    
);

create sequence SAccntTpMngr nocache;

create table AccntTpMngr(
    id number primary key,
    Cls number not null,
    AccntTpMngrThis number,
    AccntTpMngrThisCls number,
    constraint FAccntTpMngrThis foreign key (AccntTpMngrThisCls) references Cls (id)    
);

create sequence SMObjct nocache;

create table MObjct(
    id number primary key,
    Cls number not null,
    MObjctThis number,
    MObjctThisCls number,
    constraint FMObjctThis foreign key (MObjctThisCls) references Cls (id)    
);

create sequence SCrtQnttCMD nocache;

create table CrtQnttCMD(
    id number primary key,
    Cls number not null,
    CrtQnttCMDUnt number,
    CrtQnttCMDUntCls number,
    constraint FCrtQnttCMDUnt foreign key (CrtQnttCMDUntCls) references Cls (id),
    CrtQnttCMDAmnt varchar2(2000),
    CrtQnttCMDInvoker number,
    CrtQnttCMDInvokerCls number,
    constraint FCrtQnttCMDInvoker foreign key (CrtQnttCMDInvokerCls) references Cls (id),
    CrtQnttCMDCReceiver number,
    CrtQnttCMDCReceiverCls number,
    constraint FCrtQnttCMDCReceiver foreign key (CrtQnttCMDCReceiverCls) references Cls (id),
    CrtQnttCMDMyCmmnDt number,
    CrtQnttCMDMyCmmnDtCls number,
    constraint FCrtQnttCMDMyCmmnDt foreign key (CrtQnttCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SInstncObjct nocache;

create table InstncObjct(
    id number primary key,
    Cls number not null,
    InstncObjctTp number,
    InstncObjctTpCls number,
    constraint FInstncObjctTp foreign key (InstncObjctTpCls) references Cls (id),
    InstncObjctThis number,
    InstncObjctThisCls number,
    constraint FInstncObjctThis foreign key (InstncObjctThisCls) references Cls (id)    
);

create sequence SRmvFpCMD nocache;

create table RmvFpCMD(
    id number primary key,
    Cls number not null,
    RmvFpCMDFp number,
    RmvFpCMDFpCls number,
    constraint FRmvFpCMDFp foreign key (RmvFpCMDFpCls) references Cls (id),
    RmvFpCMDInvoker number,
    RmvFpCMDInvokerCls number,
    constraint FRmvFpCMDInvoker foreign key (RmvFpCMDInvokerCls) references Cls (id),
    RmvFpCMDCReceiver number,
    RmvFpCMDCReceiverCls number,
    constraint FRmvFpCMDCReceiver foreign key (RmvFpCMDCReceiverCls) references Cls (id),
    RmvFpCMDMyCmmnDt number,
    RmvFpCMDMyCmmnDtCls number,
    constraint FRmvFpCMDMyCmmnDt foreign key (RmvFpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMBln nocache;

create table MBln(
    id number primary key,
    Cls number not null,
    MBlnThis number,
    MBlnThisCls number,
    constraint FMBlnThis foreign key (MBlnThisCls) references Cls (id)    
);

create sequence SFnctn nocache;

create table Fnctn(
    id number primary key,
    Cls number not null,
    FnctnFctr varchar2(2000),
    FnctnCnstnt varchar2(2000),
    FnctnThis number,
    FnctnThisCls number,
    constraint FFnctnThis foreign key (FnctnThisCls) references Cls (id)    
);

create sequence SAspctMngr nocache;

create table AspctMngr(
    id number primary key,
    Cls number not null,
    AspctMngrThis number,
    AspctMngrThisCls number,
    constraint FAspctMngrThis foreign key (AspctMngrThisCls) references Cls (id)    
);

create sequence SRmvOprtnCMD nocache;

create table RmvOprtnCMD(
    id number primary key,
    Cls number not null,
    RmvOprtnCMDOp number,
    RmvOprtnCMDOpCls number,
    constraint FRmvOprtnCMDOp foreign key (RmvOprtnCMDOpCls) references Cls (id),
    RmvOprtnCMDInvoker number,
    RmvOprtnCMDInvokerCls number,
    constraint FRmvOprtnCMDInvoker foreign key (RmvOprtnCMDInvokerCls) references Cls (id),
    RmvOprtnCMDCReceiver number,
    RmvOprtnCMDCReceiverCls number,
    constraint FRmvOprtnCMDCReceiver foreign key (RmvOprtnCMDCReceiverCls) references Cls (id),
    RmvOprtnCMDMyCmmnDt number,
    RmvOprtnCMDMyCmmnDtCls number,
    constraint FRmvOprtnCMDMyCmmnDt foreign key (RmvOprtnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtCnstntCMD nocache;

create table CrtCnstntCMD(
    id number primary key,
    Cls number not null,
    CrtCnstntCMDNm varchar2(2000),
    CrtCnstntCMDTrgt number,
    CrtCnstntCMDTrgtCls number,
    constraint FCrtCnstntCMDTrgt foreign key (CrtCnstntCMDTrgtCls) references Cls (id),
    CrtCnstntCMDInvoker number,
    CrtCnstntCMDInvokerCls number,
    constraint FCrtCnstntCMDInvoker foreign key (CrtCnstntCMDInvokerCls) references Cls (id),
    CrtCnstntCMDCReceiver number,
    CrtCnstntCMDCReceiverCls number,
    constraint FCrtCnstntCMDCReceiver foreign key (CrtCnstntCMDCReceiverCls) references Cls (id),
    CrtCnstntCMDMyCmmnDt number,
    CrtCnstntCMDMyCmmnDtCls number,
    constraint FCrtCnstntCMDMyCmmnDt foreign key (CrtCnstntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMAspct nocache;

create table MAspct(
    id number primary key,
    Cls number not null,
    MAspctNm varchar2(2000),
    MAspctThis number,
    MAspctThisCls number,
    constraint FMAspctThis foreign key (MAspctThisCls) references Cls (id)    
);
create index INmMAspct on MAspct (MAspctNm);


create sequence SAccntMngr nocache;

create table AccntMngr(
    id number primary key,
    Cls number not null,
    AccntMngrThis number,
    AccntMngrThisCls number,
    constraint FAccntMngrThis foreign key (AccntMngrThisCls) references Cls (id)    
);

create sequence SCrtMssgCMD nocache;

create table CrtMssgCMD(
    id number primary key,
    Cls number not null,
    CrtMssgCMDTp number,
    CrtMssgCMDTpCls number,
    constraint FCrtMssgCMDTp foreign key (CrtMssgCMDTpCls) references Cls (id),
    CrtMssgCMDSrc number,
    CrtMssgCMDSrcCls number,
    constraint FCrtMssgCMDSrc foreign key (CrtMssgCMDSrcCls) references Cls (id),
    CrtMssgCMDTrgt number,
    CrtMssgCMDTrgtCls number,
    constraint FCrtMssgCMDTrgt foreign key (CrtMssgCMDTrgtCls) references Cls (id),
    CrtMssgCMDInvoker number,
    CrtMssgCMDInvokerCls number,
    constraint FCrtMssgCMDInvoker foreign key (CrtMssgCMDInvokerCls) references Cls (id),
    CrtMssgCMDCReceiver number,
    CrtMssgCMDCReceiverCls number,
    constraint FCrtMssgCMDCReceiver foreign key (CrtMssgCMDCReceiverCls) references Cls (id),
    CrtMssgCMDMyCmmnDt number,
    CrtMssgCMDMyCmmnDtCls number,
    constraint FCrtMssgCMDMyCmmnDt foreign key (CrtMssgCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtAccntTpCMD nocache;

create table CrtAccntTpCMD(
    id number primary key,
    Cls number not null,
    CrtAccntTpCMDNm varchar2(2000),
    CrtAccntTpCMDTp number,
    CrtAccntTpCMDTpCls number,
    constraint FCrtAccntTpCMDTp foreign key (CrtAccntTpCMDTpCls) references Cls (id),
    CrtAccntTpCMDUntTp number,
    CrtAccntTpCMDUntTpCls number,
    constraint FCrtAccntTpCMDUntTp foreign key (CrtAccntTpCMDUntTpCls) references Cls (id),
    CrtAccntTpCMDInvoker number,
    CrtAccntTpCMDInvokerCls number,
    constraint FCrtAccntTpCMDInvoker foreign key (CrtAccntTpCMDInvokerCls) references Cls (id),
    CrtAccntTpCMDCReceiver number,
    CrtAccntTpCMDCReceiverCls number,
    constraint FCrtAccntTpCMDCReceiver foreign key (CrtAccntTpCMDCReceiverCls) references Cls (id),
    CrtAccntTpCMDMyCmmnDt number,
    CrtAccntTpCMDMyCmmnDtCls number,
    constraint FCrtAccntTpCMDMyCmmnDt foreign key (CrtAccntTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCnvrsnMngr nocache;

create table CnvrsnMngr(
    id number primary key,
    Cls number not null,
    CnvrsnMngrThis number,
    CnvrsnMngrThisCls number,
    constraint FCnvrsnMngrThis foreign key (CnvrsnMngrThisCls) references Cls (id)    
);

create sequence SQnttMngr nocache;

create table QnttMngr(
    id number primary key,
    Cls number not null,
    QnttMngrThis number,
    QnttMngrThisCls number,
    constraint FQnttMngrThis foreign key (QnttMngrThisCls) references Cls (id)    
);

create sequence SAbsUntTp nocache;

create table AbsUntTp(
    id number primary key,
    Cls number not null,
    AbsUntTpNm varchar2(2000),
    AbsUntTpThis number,
    AbsUntTpThisCls number,
    constraint FAbsUntTpThis foreign key (AbsUntTpThisCls) references Cls (id),
    CmpUntTpIsFnl number,
    CmpUntTpIsFnlCls number,
    constraint FCmpUntTpIsFnl foreign key (CmpUntTpIsFnlCls) references Cls (id),
    UntTpDfltUnt number,
    UntTpDfltUntCls number,
    constraint FUntTpDfltUnt foreign key (UntTpDfltUntCls) references Cls (id)    
);
create index INmAbsUntTp on AbsUntTp (AbsUntTpNm);


create sequence SCrtPrdctTpCMD nocache;

create table CrtPrdctTpCMD(
    id number primary key,
    Cls number not null,
    CrtPrdctTpCMDInvoker number,
    CrtPrdctTpCMDInvokerCls number,
    constraint FCrtPrdctTpCMDInvoker foreign key (CrtPrdctTpCMDInvokerCls) references Cls (id),
    CrtPrdctTpCMDCReceiver number,
    CrtPrdctTpCMDCReceiverCls number,
    constraint FCrtPrdctTpCMDCReceiver foreign key (CrtPrdctTpCMDCReceiverCls) references Cls (id),
    CrtPrdctTpCMDCResult number,
    CrtPrdctTpCMDCResultCls number,
    constraint FCrtPrdctTpCMDCResult foreign key (CrtPrdctTpCMDCResultCls) references Cls (id),
    CrtPrdctTpCMDMyCmmnDt number,
    CrtPrdctTpCMDMyCmmnDtCls number,
    constraint FCrtPrdctTpCMDMyCmmnDt foreign key (CrtPrdctTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtSttcOpCMD nocache;

create table CrtSttcOpCMD(
    id number primary key,
    Cls number not null,
    CrtSttcOpCMDNm varchar2(2000),
    CrtSttcOpCMDTrgt number,
    CrtSttcOpCMDTrgtCls number,
    constraint FCrtSttcOpCMDTrgt foreign key (CrtSttcOpCMDTrgtCls) references Cls (id),
    CrtSttcOpCMDInvoker number,
    CrtSttcOpCMDInvokerCls number,
    constraint FCrtSttcOpCMDInvoker foreign key (CrtSttcOpCMDInvokerCls) references Cls (id),
    CrtSttcOpCMDCReceiver number,
    CrtSttcOpCMDCReceiverCls number,
    constraint FCrtSttcOpCMDCReceiver foreign key (CrtSttcOpCMDCReceiverCls) references Cls (id),
    CrtSttcOpCMDMyCmmnDt number,
    CrtSttcOpCMDMyCmmnDtCls number,
    constraint FCrtSttcOpCMDMyCmmnDt foreign key (CrtSttcOpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAssctnMngr nocache;

create table AssctnMngr(
    id number primary key,
    Cls number not null,
    AssctnMngrThis number,
    AssctnMngrThisCls number,
    constraint FAssctnMngrThis foreign key (AssctnMngrThisCls) references Cls (id)    
);

create sequence SCrtAccntCMD nocache;

create table CrtAccntCMD(
    id number primary key,
    Cls number not null,
    CrtAccntCMDNm varchar2(2000),
    CrtAccntCMDTp number,
    CrtAccntCMDTpCls number,
    constraint FCrtAccntCMDTp foreign key (CrtAccntCMDTpCls) references Cls (id),
    CrtAccntCMDObjct number,
    CrtAccntCMDObjctCls number,
    constraint FCrtAccntCMDObjct foreign key (CrtAccntCMDObjctCls) references Cls (id),
    CrtAccntCMDInvoker number,
    CrtAccntCMDInvokerCls number,
    constraint FCrtAccntCMDInvoker foreign key (CrtAccntCMDInvokerCls) references Cls (id),
    CrtAccntCMDCReceiver number,
    CrtAccntCMDCReceiverCls number,
    constraint FCrtAccntCMDCReceiver foreign key (CrtAccntCMDCReceiverCls) references Cls (id),
    CrtAccntCMDMyCmmnDt number,
    CrtAccntCMDMyCmmnDtCls number,
    constraint FCrtAccntCMDMyCmmnDt foreign key (CrtAccntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtCnvrsnCMD nocache;

create table CrtCnvrsnCMD(
    id number primary key,
    Cls number not null,
    CrtCnvrsnCMDUnt number,
    CrtCnvrsnCMDUntCls number,
    constraint FCrtCnvrsnCMDUnt foreign key (CrtCnvrsnCMDUntCls) references Cls (id),
    CrtCnvrsnCMDFctr varchar2(2000),
    CrtCnvrsnCMDCnstnt varchar2(2000),
    CrtCnvrsnCMDInvoker number,
    CrtCnvrsnCMDInvokerCls number,
    constraint FCrtCnvrsnCMDInvoker foreign key (CrtCnvrsnCMDInvokerCls) references Cls (id),
    CrtCnvrsnCMDCReceiver number,
    CrtCnvrsnCMDCReceiverCls number,
    constraint FCrtCnvrsnCMDCReceiver foreign key (CrtCnvrsnCMDCReceiverCls) references Cls (id),
    CrtCnvrsnCMDMyCmmnDt number,
    CrtCnvrsnCMDMyCmmnDtCls number,
    constraint FCrtCnvrsnCMDMyCmmnDt foreign key (CrtCnvrsnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtAtmcSbTpCMD nocache;

create table CrtAtmcSbTpCMD(
    id number primary key,
    Cls number not null,
    CrtAtmcSbTpCMDSprTp number,
    CrtAtmcSbTpCMDSprTpCls number,
    constraint FCrtAtmcSbTpCMDSprTp foreign key (CrtAtmcSbTpCMDSprTpCls) references Cls (id),
    CrtAtmcSbTpCMDNm varchar2(2000),
    CrtAtmcSbTpCMDSngltnTp number,
    CrtAtmcSbTpCMDSngltnTpCls number,
    constraint FCrtAtmcSbTpCMDSngltnTp foreign key (CrtAtmcSbTpCMDSngltnTpCls) references Cls (id),
    CrtAtmcSbTpCMDAbstrctTp number,
    CrtAtmcSbTpCMDAbstrctTpCls number,
    constraint FCrtAtmcSbTpCMDAbstrctTp foreign key (CrtAtmcSbTpCMDAbstrctTpCls) references Cls (id),
    CrtAtmcSbTpCMDInvoker number,
    CrtAtmcSbTpCMDInvokerCls number,
    constraint FCrtAtmcSbTpCMDInvoker foreign key (CrtAtmcSbTpCMDInvokerCls) references Cls (id),
    CrtAtmcSbTpCMDCReceiver number,
    CrtAtmcSbTpCMDCReceiverCls number,
    constraint FCrtAtmcSbTpCMDCReceiver foreign key (CrtAtmcSbTpCMDCReceiverCls) references Cls (id),
    CrtAtmcSbTpCMDCResult number,
    CrtAtmcSbTpCMDCResultCls number,
    constraint FCrtAtmcSbTpCMDCResult foreign key (CrtAtmcSbTpCMDCResultCls) references Cls (id),
    CrtAtmcSbTpCMDMyCmmnDt number,
    CrtAtmcSbTpCMDMyCmmnDtCls number,
    constraint FCrtAtmcSbTpCMDMyCmmnDt foreign key (CrtAtmcSbTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAbsQntt nocache;

create table AbsQntt(
    id number primary key,
    Cls number not null,
    AbsQnttThis number,
    AbsQnttThisCls number,
    constraint FAbsQnttThis foreign key (AbsQnttThisCls) references Cls (id),
    QnttAmnt varchar2(2000),
    QnttUnt number,
    QnttUntCls number,
    constraint FQnttUnt foreign key (QnttUntCls) references Cls (id)    
);

create sequence SCrtVdOprtnCMD nocache;

create table CrtVdOprtnCMD(
    id number primary key,
    Cls number not null,
    CrtVdOprtnCMDSrc number,
    CrtVdOprtnCMDSrcCls number,
    constraint FCrtVdOprtnCMDSrc foreign key (CrtVdOprtnCMDSrcCls) references Cls (id),
    CrtVdOprtnCMDNm varchar2(2000),
    CrtVdOprtnCMDInvoker number,
    CrtVdOprtnCMDInvokerCls number,
    constraint FCrtVdOprtnCMDInvoker foreign key (CrtVdOprtnCMDInvokerCls) references Cls (id),
    CrtVdOprtnCMDCReceiver number,
    CrtVdOprtnCMDCReceiverCls number,
    constraint FCrtVdOprtnCMDCReceiver foreign key (CrtVdOprtnCMDCReceiverCls) references Cls (id),
    CrtVdOprtnCMDMyCmmnDt number,
    CrtVdOprtnCMDMyCmmnDtCls number,
    constraint FCrtVdOprtnCMDMyCmmnDt foreign key (CrtVdOprtnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtLnkCMD nocache;

create table CrtLnkCMD(
    id number primary key,
    Cls number not null,
    CrtLnkCMDTp number,
    CrtLnkCMDTpCls number,
    constraint FCrtLnkCMDTp foreign key (CrtLnkCMDTpCls) references Cls (id),
    CrtLnkCMDSrc number,
    CrtLnkCMDSrcCls number,
    constraint FCrtLnkCMDSrc foreign key (CrtLnkCMDSrcCls) references Cls (id),
    CrtLnkCMDTrgt number,
    CrtLnkCMDTrgtCls number,
    constraint FCrtLnkCMDTrgt foreign key (CrtLnkCMDTrgtCls) references Cls (id),
    CrtLnkCMDInvoker number,
    CrtLnkCMDInvokerCls number,
    constraint FCrtLnkCMDInvoker foreign key (CrtLnkCMDInvokerCls) references Cls (id),
    CrtLnkCMDCReceiver number,
    CrtLnkCMDCReceiverCls number,
    constraint FCrtLnkCMDCReceiver foreign key (CrtLnkCMDCReceiverCls) references Cls (id),
    CrtLnkCMDMyCmmnDt number,
    CrtLnkCMDMyCmmnDtCls number,
    constraint FCrtLnkCMDMyCmmnDt foreign key (CrtLnkCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtCmpUntCMD nocache;

create table CrtCmpUntCMD(
    id number primary key,
    Cls number not null,
    CrtCmpUntCMDNm varchar2(2000),
    CrtCmpUntCMDTp number,
    CrtCmpUntCMDTpCls number,
    constraint FCrtCmpUntCMDTp foreign key (CrtCmpUntCMDTpCls) references Cls (id),
    CrtCmpUntCMDInvoker number,
    CrtCmpUntCMDInvokerCls number,
    constraint FCrtCmpUntCMDInvoker foreign key (CrtCmpUntCMDInvokerCls) references Cls (id),
    CrtCmpUntCMDCReceiver number,
    CrtCmpUntCMDCReceiverCls number,
    constraint FCrtCmpUntCMDCReceiver foreign key (CrtCmpUntCMDCReceiverCls) references Cls (id),
    CrtCmpUntCMDMyCmmnDt number,
    CrtCmpUntCMDMyCmmnDtCls number,
    constraint FCrtCmpUntCMDMyCmmnDt foreign key (CrtCmpUntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SCrtCmpUntTpCMD nocache;

create table CrtCmpUntTpCMD(
    id number primary key,
    Cls number not null,
    CrtCmpUntTpCMDNm varchar2(2000),
    CrtCmpUntTpCMDInvoker number,
    CrtCmpUntTpCMDInvokerCls number,
    constraint FCrtCmpUntTpCMDInvoker foreign key (CrtCmpUntTpCMDInvokerCls) references Cls (id),
    CrtCmpUntTpCMDCReceiver number,
    CrtCmpUntTpCMDCReceiverCls number,
    constraint FCrtCmpUntTpCMDCReceiver foreign key (CrtCmpUntTpCMDCReceiverCls) references Cls (id),
    CrtCmpUntTpCMDMyCmmnDt number,
    CrtCmpUntTpCMDMyCmmnDtCls number,
    constraint FCrtCmpUntTpCMDMyCmmnDt foreign key (CrtCmpUntTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SRmvAssctnCMD nocache;

create table RmvAssctnCMD(
    id number primary key,
    Cls number not null,
    RmvAssctnCMDA number,
    RmvAssctnCMDACls number,
    constraint FRmvAssctnCMDA foreign key (RmvAssctnCMDACls) references Cls (id),
    RmvAssctnCMDInvoker number,
    RmvAssctnCMDInvokerCls number,
    constraint FRmvAssctnCMDInvoker foreign key (RmvAssctnCMDInvokerCls) references Cls (id),
    RmvAssctnCMDCReceiver number,
    RmvAssctnCMDCReceiverCls number,
    constraint FRmvAssctnCMDCReceiver foreign key (RmvAssctnCMDCReceiverCls) references Cls (id),
    RmvAssctnCMDMyCmmnDt number,
    RmvAssctnCMDMyCmmnDtCls number,
    constraint FRmvAssctnCMDMyCmmnDt foreign key (RmvAssctnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SHrrch nocache;

create table Hrrch(
    id number primary key,
    Cls number not null,
    HrrchNm varchar2(2000),
    HrrchThis number,
    HrrchThisCls number,
    constraint FHrrchThis foreign key (HrrchThisCls) references Cls (id)    
);
create index INmHrrch on Hrrch (HrrchNm);


create sequence SAddFpCMD nocache;

create table AddFpCMD(
    id number primary key,
    Cls number not null,
    AddFpCMDOp number,
    AddFpCMDOpCls number,
    constraint FAddFpCMDOp foreign key (AddFpCMDOpCls) references Cls (id),
    AddFpCMDFp number,
    AddFpCMDFpCls number,
    constraint FAddFpCMDFp foreign key (AddFpCMDFpCls) references Cls (id),
    AddFpCMDInvoker number,
    AddFpCMDInvokerCls number,
    constraint FAddFpCMDInvoker foreign key (AddFpCMDInvokerCls) references Cls (id),
    AddFpCMDCReceiver number,
    AddFpCMDCReceiverCls number,
    constraint FAddFpCMDCReceiver foreign key (AddFpCMDCReceiverCls) references Cls (id),
    AddFpCMDMyCmmnDt number,
    AddFpCMDMyCmmnDtCls number,
    constraint FAddFpCMDMyCmmnDt foreign key (AddFpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtSttcMssgCMD nocache;

create table CrtSttcMssgCMD(
    id number primary key,
    Cls number not null,
    CrtSttcMssgCMDTp number,
    CrtSttcMssgCMDTpCls number,
    constraint FCrtSttcMssgCMDTp foreign key (CrtSttcMssgCMDTpCls) references Cls (id),
    CrtSttcMssgCMDNm varchar2(2000),
    CrtSttcMssgCMDTrgt number,
    CrtSttcMssgCMDTrgtCls number,
    constraint FCrtSttcMssgCMDTrgt foreign key (CrtSttcMssgCMDTrgtCls) references Cls (id),
    CrtSttcMssgCMDInvoker number,
    CrtSttcMssgCMDInvokerCls number,
    constraint FCrtSttcMssgCMDInvoker foreign key (CrtSttcMssgCMDInvokerCls) references Cls (id),
    CrtSttcMssgCMDCReceiver number,
    CrtSttcMssgCMDCReceiverCls number,
    constraint FCrtSttcMssgCMDCReceiver foreign key (CrtSttcMssgCMDCReceiverCls) references Cls (id),
    CrtSttcMssgCMDMyCmmnDt number,
    CrtSttcMssgCMDMyCmmnDtCls number,
    constraint FCrtSttcMssgCMDMyCmmnDt foreign key (CrtSttcMssgCMDMyCmmnDtCls) references Cls (id)    
);

create sequence STpMngr nocache;

create table TpMngr(
    id number primary key,
    Cls number not null,
    TpMngrThis number,
    TpMngrThisCls number,
    constraint FTpMngrThis foreign key (TpMngrThisCls) references Cls (id)    
);

create sequence SMssgMngr nocache;

create table MssgMngr(
    id number primary key,
    Cls number not null,
    MssgMngrThis number,
    MssgMngrThisCls number,
    constraint FMssgMngrThis foreign key (MssgMngrThisCls) references Cls (id)    
);

create sequence SUntTpMngr nocache;

create table UntTpMngr(
    id number primary key,
    Cls number not null,
    UntTpMngrThis number,
    UntTpMngrThisCls number,
    constraint FUntTpMngrThis foreign key (UntTpMngrThisCls) references Cls (id)    
);

create sequence SMTp nocache;

create table MTp(
    id number primary key,
    Cls number not null,
    MTpThis number,
    MTpThisCls number,
    constraint FMTpThis foreign key (MTpThisCls) references Cls (id),
    MAtmcTpNm varchar2(2000),
    MAtmcTpSngltnTp number,
    MAtmcTpSngltnTpCls number,
    constraint FMAtmcTpSngltnTp foreign key (MAtmcTpSngltnTpCls) references Cls (id),
    MAtmcTpAbstrctTp number,
    MAtmcTpAbstrctTpCls number,
    constraint FMAtmcTpAbstrctTp foreign key (MAtmcTpAbstrctTpCls) references Cls (id),
    MAtmcTpAspct number,
    MAtmcTpAspctCls number,
    constraint FMAtmcTpAspct foreign key (MAtmcTpAspctCls) references Cls (id),
    MAtmcTpSprTp number,
    MAtmcTpSprTpCls number,
    constraint FMAtmcTpSprTp foreign key (MAtmcTpSprTpCls) references Cls (id)    
);
create index INmMAtmcTp on MTp (MAtmcTpNm);
create index IAspctMAtmcTp on MTp (MAtmcTpAspct, MAtmcTpAspctCls);
create index ISprTpMAtmcTp on MTp (MAtmcTpSprTp, MAtmcTpSprTpCls);


create sequence SCrtVdMssgCMD nocache;

create table CrtVdMssgCMD(
    id number primary key,
    Cls number not null,
    CrtVdMssgCMDTp number,
    CrtVdMssgCMDTpCls number,
    constraint FCrtVdMssgCMDTp foreign key (CrtVdMssgCMDTpCls) references Cls (id),
    CrtVdMssgCMDSrc number,
    CrtVdMssgCMDSrcCls number,
    constraint FCrtVdMssgCMDSrc foreign key (CrtVdMssgCMDSrcCls) references Cls (id),
    CrtVdMssgCMDInvoker number,
    CrtVdMssgCMDInvokerCls number,
    constraint FCrtVdMssgCMDInvoker foreign key (CrtVdMssgCMDInvokerCls) references Cls (id),
    CrtVdMssgCMDCReceiver number,
    CrtVdMssgCMDCReceiverCls number,
    constraint FCrtVdMssgCMDCReceiver foreign key (CrtVdMssgCMDCReceiverCls) references Cls (id),
    CrtVdMssgCMDMyCmmnDt number,
    CrtVdMssgCMDMyCmmnDtCls number,
    constraint FCrtVdMssgCMDMyCmmnDt foreign key (CrtVdMssgCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAbsUnt nocache;

create table AbsUnt(
    id number primary key,
    Cls number not null,
    AbsUntTp number,
    AbsUntTpCls number,
    constraint FAbsUntTp foreign key (AbsUntTpCls) references Cls (id),
    AbsUntNm varchar2(2000),
    AbsUntThis number,
    AbsUntThisCls number,
    constraint FAbsUntThis foreign key (AbsUntThisCls) references Cls (id),
    CmpUntIsFnl number,
    CmpUntIsFnlCls number,
    constraint FCmpUntIsFnl foreign key (CmpUntIsFnlCls) references Cls (id)    
);
create index INmAbsUnt on AbsUnt (AbsUntNm);


create sequence SAddAssctnCMD nocache;

create table AddAssctnCMD(
    id number primary key,
    Cls number not null,
    AddAssctnCMDH number,
    AddAssctnCMDHCls number,
    constraint FAddAssctnCMDH foreign key (AddAssctnCMDHCls) references Cls (id),
    AddAssctnCMDA number,
    AddAssctnCMDACls number,
    constraint FAddAssctnCMDA foreign key (AddAssctnCMDACls) references Cls (id),
    AddAssctnCMDInvoker number,
    AddAssctnCMDInvokerCls number,
    constraint FAddAssctnCMDInvoker foreign key (AddAssctnCMDInvokerCls) references Cls (id),
    AddAssctnCMDCReceiver number,
    AddAssctnCMDCReceiverCls number,
    constraint FAddAssctnCMDCReceiver foreign key (AddAssctnCMDCReceiverCls) references Cls (id),
    AddAssctnCMDMyCmmnDt number,
    AddAssctnCMDMyCmmnDtCls number,
    constraint FAddAssctnCMDMyCmmnDt foreign key (AddAssctnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtCnstCMD nocache;

create table CrtCnstCMD(
    id number primary key,
    Cls number not null,
    CrtCnstCMDTp number,
    CrtCnstCMDTpCls number,
    constraint FCrtCnstCMDTp foreign key (CrtCnstCMDTpCls) references Cls (id),
    CrtCnstCMDNm varchar2(2000),
    CrtCnstCMDTrgt number,
    CrtCnstCMDTrgtCls number,
    constraint FCrtCnstCMDTrgt foreign key (CrtCnstCMDTrgtCls) references Cls (id),
    CrtCnstCMDInvoker number,
    CrtCnstCMDInvokerCls number,
    constraint FCrtCnstCMDInvoker foreign key (CrtCnstCMDInvokerCls) references Cls (id),
    CrtCnstCMDCReceiver number,
    CrtCnstCMDCReceiverCls number,
    constraint FCrtCnstCMDCReceiver foreign key (CrtCnstCMDCReceiverCls) references Cls (id),
    CrtCnstCMDMyCmmnDt number,
    CrtCnstCMDMyCmmnDtCls number,
    constraint FCrtCnstCMDMyCmmnDt foreign key (CrtCnstCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SFrctnMngr nocache;

create table FrctnMngr(
    id number primary key,
    Cls number not null,
    FrctnMngrThis number,
    FrctnMngrThisCls number,
    constraint FFrctnMngrThis foreign key (FrctnMngrThisCls) references Cls (id)    
);

create sequence SCrtOprtnCMD nocache;

create table CrtOprtnCMD(
    id number primary key,
    Cls number not null,
    CrtOprtnCMDSrc number,
    CrtOprtnCMDSrcCls number,
    constraint FCrtOprtnCMDSrc foreign key (CrtOprtnCMDSrcCls) references Cls (id),
    CrtOprtnCMDTrgt number,
    CrtOprtnCMDTrgtCls number,
    constraint FCrtOprtnCMDTrgt foreign key (CrtOprtnCMDTrgtCls) references Cls (id),
    CrtOprtnCMDNm varchar2(2000),
    CrtOprtnCMDInvoker number,
    CrtOprtnCMDInvokerCls number,
    constraint FCrtOprtnCMDInvoker foreign key (CrtOprtnCMDInvokerCls) references Cls (id),
    CrtOprtnCMDCReceiver number,
    CrtOprtnCMDCReceiverCls number,
    constraint FCrtOprtnCMDCReceiver foreign key (CrtOprtnCMDCReceiverCls) references Cls (id),
    CrtOprtnCMDMyCmmnDt number,
    CrtOprtnCMDMyCmmnDtCls number,
    constraint FCrtOprtnCMDMyCmmnDt foreign key (CrtOprtnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCnvrsn nocache;

create table Cnvrsn(
    id number primary key,
    Cls number not null,
    CnvrsnSrc number,
    CnvrsnSrcCls number,
    constraint FCnvrsnSrc foreign key (CnvrsnSrcCls) references Cls (id),
    CnvrsnMFnctn number,
    CnvrsnMFnctnCls number,
    constraint FCnvrsnMFnctn foreign key (CnvrsnMFnctnCls) references Cls (id),
    CnvrsnThis number,
    CnvrsnThisCls number,
    constraint FCnvrsnThis foreign key (CnvrsnThisCls) references Cls (id)    
);
create index ISrcCnvrsn on Cnvrsn (CnvrsnSrc, CnvrsnSrcCls);


create sequence SRfrnc nocache;

create table Rfrnc(
    id number primary key,
    Cls number not null,
    RfrncTp number,
    RfrncTpCls number,
    constraint FRfrncTp foreign key (RfrncTpCls) references Cls (id),
    RfrncExpnnt number,
    RfrncRf number,
    RfrncRfCls number,
    constraint FRfrncRf foreign key (RfrncRfCls) references Cls (id),
    RfrncThis number,
    RfrncThisCls number,
    constraint FRfrncThis foreign key (RfrncThisCls) references Cls (id)    
);

create sequence SFnshMdlngCMD nocache;

create table FnshMdlngCMD(
    id number primary key,
    Cls number not null,
    FnshMdlngCMDCmpUntTp number,
    FnshMdlngCMDCmpUntTpCls number,
    constraint FFnshMdlngCMDCmpUntTp foreign key (FnshMdlngCMDCmpUntTpCls) references Cls (id),
    FnshMdlngCMDInvoker number,
    FnshMdlngCMDInvokerCls number,
    constraint FFnshMdlngCMDInvoker foreign key (FnshMdlngCMDInvokerCls) references Cls (id),
    FnshMdlngCMDCReceiver number,
    FnshMdlngCMDCReceiverCls number,
    constraint FFnshMdlngCMDCReceiver foreign key (FnshMdlngCMDCReceiverCls) references Cls (id),
    FnshMdlngCMDMyCmmnDt number,
    FnshMdlngCMDMyCmmnDtCls number,
    constraint FFnshMdlngCMDMyCmmnDt foreign key (FnshMdlngCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SRfrncTp nocache;

create table RfrncTp(
    id number primary key,
    Cls number not null,
    RfrncTpExpnnt number,
    RfrncTpRf number,
    RfrncTpRfCls number,
    constraint FRfrncTpRf foreign key (RfrncTpRfCls) references Cls (id),
    RfrncTpThis number,
    RfrncTpThisCls number,
    constraint FRfrncTpThis foreign key (RfrncTpThisCls) references Cls (id)    
);

create sequence SMsrmntTpMng nocache;

create table MsrmntTpMng(
    id number primary key,
    Cls number not null,
    MsrmntTpMngThis number,
    MsrmntTpMngThisCls number,
    constraint FMsrmntTpMngThis foreign key (MsrmntTpMngThisCls) references Cls (id)    
);

create sequence SLnkMngr nocache;

create table LnkMngr(
    id number primary key,
    Cls number not null,
    LnkMngrThis number,
    LnkMngrThisCls number,
    constraint FLnkMngrThis foreign key (LnkMngrThisCls) references Cls (id)    
);

create sequence SCrtAssctnCMD nocache;

create table CrtAssctnCMD(
    id number primary key,
    Cls number not null,
    CrtAssctnCMDSrc number,
    CrtAssctnCMDSrcCls number,
    constraint FCrtAssctnCMDSrc foreign key (CrtAssctnCMDSrcCls) references Cls (id),
    CrtAssctnCMDTrgt number,
    CrtAssctnCMDTrgtCls number,
    constraint FCrtAssctnCMDTrgt foreign key (CrtAssctnCMDTrgtCls) references Cls (id),
    CrtAssctnCMDNm varchar2(2000),
    CrtAssctnCMDInvoker number,
    CrtAssctnCMDInvokerCls number,
    constraint FCrtAssctnCMDInvoker foreign key (CrtAssctnCMDInvokerCls) references Cls (id),
    CrtAssctnCMDCReceiver number,
    CrtAssctnCMDCReceiverCls number,
    constraint FCrtAssctnCMDCReceiver foreign key (CrtAssctnCMDCReceiverCls) references Cls (id),
    CrtAssctnCMDMyCmmnDt number,
    CrtAssctnCMDMyCmmnDtCls number,
    constraint FCrtAssctnCMDMyCmmnDt foreign key (CrtAssctnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMssgOrLnk nocache;

create table MssgOrLnk(
    id number primary key,
    Cls number not null,
    MssgOrLnkSrc number,
    MssgOrLnkSrcCls number,
    constraint FMssgOrLnkSrc foreign key (MssgOrLnkSrcCls) references Cls (id),
    MssgOrLnkTrgt number,
    MssgOrLnkTrgtCls number,
    constraint FMssgOrLnkTrgt foreign key (MssgOrLnkTrgtCls) references Cls (id),
    MssgOrLnkThis number,
    MssgOrLnkThisCls number,
    constraint FMssgOrLnkThis foreign key (MssgOrLnkThisCls) references Cls (id),
    MssgTp number,
    MssgTpCls number,
    constraint FMssgTp foreign key (MssgTpCls) references Cls (id),
    LnkTp number,
    LnkTpCls number,
    constraint FLnkTp foreign key (LnkTpCls) references Cls (id)    
);

create sequence SCrtAtmcRtTpCMD nocache;

create table CrtAtmcRtTpCMD(
    id number primary key,
    Cls number not null,
    CrtAtmcRtTpCMDAspct number,
    CrtAtmcRtTpCMDAspctCls number,
    constraint FCrtAtmcRtTpCMDAspct foreign key (CrtAtmcRtTpCMDAspctCls) references Cls (id),
    CrtAtmcRtTpCMDNm varchar2(2000),
    CrtAtmcRtTpCMDSngltnTp number,
    CrtAtmcRtTpCMDSngltnTpCls number,
    constraint FCrtAtmcRtTpCMDSngltnTp foreign key (CrtAtmcRtTpCMDSngltnTpCls) references Cls (id),
    CrtAtmcRtTpCMDAbstrctTp number,
    CrtAtmcRtTpCMDAbstrctTpCls number,
    constraint FCrtAtmcRtTpCMDAbstrctTp foreign key (CrtAtmcRtTpCMDAbstrctTpCls) references Cls (id),
    CrtAtmcRtTpCMDInvoker number,
    CrtAtmcRtTpCMDInvokerCls number,
    constraint FCrtAtmcRtTpCMDInvoker foreign key (CrtAtmcRtTpCMDInvokerCls) references Cls (id),
    CrtAtmcRtTpCMDCReceiver number,
    CrtAtmcRtTpCMDCReceiverCls number,
    constraint FCrtAtmcRtTpCMDCReceiver foreign key (CrtAtmcRtTpCMDCReceiverCls) references Cls (id),
    CrtAtmcRtTpCMDCResult number,
    CrtAtmcRtTpCMDCResultCls number,
    constraint FCrtAtmcRtTpCMDCResult foreign key (CrtAtmcRtTpCMDCResultCls) references Cls (id),
    CrtAtmcRtTpCMDMyCmmnDt number,
    CrtAtmcRtTpCMDMyCmmnDtCls number,
    constraint FCrtAtmcRtTpCMDMyCmmnDt foreign key (CrtAtmcRtTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null    
);

create sequence SAddRfrncTpCMD nocache;

create table AddRfrncTpCMD(
    id number primary key,
    Cls number not null,
    AddRfrncTpCMDCmpUntTp number,
    AddRfrncTpCMDCmpUntTpCls number,
    constraint FAddRfrncTpCMDCmpUntTp foreign key (AddRfrncTpCMDCmpUntTpCls) references Cls (id),
    AddRfrncTpCMDUntTp number,
    AddRfrncTpCMDUntTpCls number,
    constraint FAddRfrncTpCMDUntTp foreign key (AddRfrncTpCMDUntTpCls) references Cls (id),
    AddRfrncTpCMDExpnnt number,
    AddRfrncTpCMDInvoker number,
    AddRfrncTpCMDInvokerCls number,
    constraint FAddRfrncTpCMDInvoker foreign key (AddRfrncTpCMDInvokerCls) references Cls (id),
    AddRfrncTpCMDCReceiver number,
    AddRfrncTpCMDCReceiverCls number,
    constraint FAddRfrncTpCMDCReceiver foreign key (AddRfrncTpCMDCReceiverCls) references Cls (id),
    AddRfrncTpCMDMyCmmnDt number,
    AddRfrncTpCMDMyCmmnDtCls number,
    constraint FAddRfrncTpCMDMyCmmnDt foreign key (AddRfrncTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SActlPrmtr nocache;

create table ActlPrmtr(
    id number primary key,
    Cls number not null,
    ActlPrmtrTp number,
    ActlPrmtrTpCls number,
    constraint FActlPrmtrTp foreign key (ActlPrmtrTpCls) references Cls (id),
    ActlPrmtrVl number,
    ActlPrmtrVlCls number,
    constraint FActlPrmtrVl foreign key (ActlPrmtrVlCls) references Cls (id),
    ActlPrmtrThis number,
    ActlPrmtrThisCls number,
    constraint FActlPrmtrThis foreign key (ActlPrmtrThisCls) references Cls (id)    
);

create sequence SCrtSmTpCMD nocache;

create table CrtSmTpCMD(
    id number primary key,
    Cls number not null,
    CrtSmTpCMDInvoker number,
    CrtSmTpCMDInvokerCls number,
    constraint FCrtSmTpCMDInvoker foreign key (CrtSmTpCMDInvokerCls) references Cls (id),
    CrtSmTpCMDCReceiver number,
    CrtSmTpCMDCReceiverCls number,
    constraint FCrtSmTpCMDCReceiver foreign key (CrtSmTpCMDCReceiverCls) references Cls (id),
    CrtSmTpCMDCResult number,
    CrtSmTpCMDCResultCls number,
    constraint FCrtSmTpCMDCResult foreign key (CrtSmTpCMDCResultCls) references Cls (id),
    CrtSmTpCMDMyCmmnDt number,
    CrtSmTpCMDMyCmmnDtCls number,
    constraint FCrtSmTpCMDMyCmmnDt foreign key (CrtSmTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SRmvFpFrmOpCMD nocache;

create table RmvFpFrmOpCMD(
    id number primary key,
    Cls number not null,
    RmvFpFrmOpCMDOp number,
    RmvFpFrmOpCMDOpCls number,
    constraint FRmvFpFrmOpCMDOp foreign key (RmvFpFrmOpCMDOpCls) references Cls (id),
    RmvFpFrmOpCMDFp number,
    RmvFpFrmOpCMDFpCls number,
    constraint FRmvFpFrmOpCMDFp foreign key (RmvFpFrmOpCMDFpCls) references Cls (id),
    RmvFpFrmOpCMDInvoker number,
    RmvFpFrmOpCMDInvokerCls number,
    constraint FRmvFpFrmOpCMDInvoker foreign key (RmvFpFrmOpCMDInvokerCls) references Cls (id),
    RmvFpFrmOpCMDCReceiver number,
    RmvFpFrmOpCMDCReceiverCls number,
    constraint FRmvFpFrmOpCMDCReceiver foreign key (RmvFpFrmOpCMDCReceiverCls) references Cls (id),
    RmvFpFrmOpCMDMyCmmnDt number,
    RmvFpFrmOpCMDMyCmmnDtCls number,
    constraint FRmvFpFrmOpCMDMyCmmnDt foreign key (RmvFpFrmOpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SRmvMssgCMD nocache;

create table RmvMssgCMD(
    id number primary key,
    Cls number not null,
    RmvMssgCMDM number,
    RmvMssgCMDMCls number,
    constraint FRmvMssgCMDM foreign key (RmvMssgCMDMCls) references Cls (id),
    RmvMssgCMDInvoker number,
    RmvMssgCMDInvokerCls number,
    constraint FRmvMssgCMDInvoker foreign key (RmvMssgCMDInvokerCls) references Cls (id),
    RmvMssgCMDCReceiver number,
    RmvMssgCMDCReceiverCls number,
    constraint FRmvMssgCMDCReceiver foreign key (RmvMssgCMDCReceiverCls) references Cls (id),
    RmvMssgCMDMyCmmnDt number,
    RmvMssgCMDMyCmmnDtCls number,
    constraint FRmvMssgCMDMyCmmnDt foreign key (RmvMssgCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SObjctMngr nocache;

create table ObjctMngr(
    id number primary key,
    Cls number not null,
    ObjctMngrThis number,
    ObjctMngrThisCls number,
    constraint FObjctMngrThis foreign key (ObjctMngrThisCls) references Cls (id)    
);

create sequence SCrtFpCMD nocache;

create table CrtFpCMD(
    id number primary key,
    Cls number not null,
    CrtFpCMDNm varchar2(2000),
    CrtFpCMDOfTp number,
    CrtFpCMDOfTpCls number,
    constraint FCrtFpCMDOfTp foreign key (CrtFpCMDOfTpCls) references Cls (id),
    CrtFpCMDInvoker number,
    CrtFpCMDInvokerCls number,
    constraint FCrtFpCMDInvoker foreign key (CrtFpCMDInvokerCls) references Cls (id),
    CrtFpCMDCReceiver number,
    CrtFpCMDCReceiverCls number,
    constraint FCrtFpCMDCReceiver foreign key (CrtFpCMDCReceiverCls) references Cls (id),
    CrtFpCMDMyCmmnDt number,
    CrtFpCMDMyCmmnDtCls number,
    constraint FCrtFpCMDMyCmmnDt foreign key (CrtFpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtMObjctCMDTps nocache;

create table CrtMObjctCMDTps(
    id number primary key,
    frm number not null,
    tps number not null,
    Cls number not null,
    constraint FCrtMObjctCMDTpsCls foreign key(Cls) references Cls(id),
    constraint FCrtMObjctCMDTpsfrm foreign key(frm) references CrtMObjctCMD(id)
);
create index IFrmCrtMObjctCMDTps on CrtMObjctCMDTps(frm);

create sequence SMCmplxTpCntndTps nocache;

create table MCmplxTpCntndTps(
    id number primary key,
    frm number not null,
    cntndTps number not null,
    Cls number not null,
    constraint FMCmplxTpCntndTpsCls foreign key(Cls) references Cls(id),
    constraint FMCmplxTpCntndTpsfrm foreign key(frm) references MTp(id)
);
create index IFrmMCmplxTpCntndTps on MCmplxTpCntndTps(frm);

create sequence SAbsOprtnPrmtrs nocache;

create table AbsOprtnPrmtrs(
    id number primary key,
    frm number not null,
    prmtrs number not null,
    Cls number not null,
    constraint FAbsOprtnPrmtrsCls foreign key(Cls) references Cls(id),
    constraint FAbsOprtnPrmtrsfrm foreign key(frm) references AbsOprtn(id)
);
create index IFrmAbsOprtnPrmtrs on AbsOprtnPrmtrs(frm);

create sequence SCmpndQnttPrts nocache;

create table CmpndQnttPrts(
    id number primary key,
    frm number not null,
    prts number not null,
    Cls number not null,
    constraint FCmpndQnttPrtsCls foreign key(Cls) references Cls(id),
    constraint FCmpndQnttPrtsfrm foreign key(frm) references AbsQntt(id)
);
create index IFrmCmpndQnttPrts on CmpndQnttPrts(frm);

create sequence SCmpUntTpRfs nocache;

create table CmpUntTpRfs(
    id number primary key,
    frm number not null,
    rfs number not null,
    Cls number not null,
    constraint FCmpUntTpRfsCls foreign key(Cls) references Cls(id),
    constraint FCmpUntTpRfsfrm foreign key(frm) references AbsUntTp(id)
);
create index IFrmCmpUntTpRfs on CmpUntTpRfs(frm);

create sequence SAssctnHrrchs nocache;

create table AssctnHrrchs(
    id number primary key,
    frm number not null,
    hrrchs number not null,
    Cls number not null,
    constraint FAssctnHrrchsCls foreign key(Cls) references Cls(id),
    constraint FAssctnHrrchsfrm foreign key(frm) references AbsOprtn(id)
);
create index IFrmAssctnHrrchs on AssctnHrrchs(frm);


create index IHrrchsAssctnHrrchs on AssctnHrrchs(hrrchs);
create sequence SOprtnMngrOprtns nocache;

create table OprtnMngrOprtns(
    id number primary key,
    frm number not null,
    oprtns number not null,
    Cls number not null,
    constraint FOprtnMngrOprtnsCls foreign key(Cls) references Cls(id),
    constraint FOprtnMngrOprtnsfrm foreign key(frm) references OprtnMngr(id)
);
create index IFrmOprtnMngrOprtns on OprtnMngrOprtns(frm);

create sequence SOprtnMngrFrmlPrmtrs nocache;

create table OprtnMngrFrmlPrmtrs(
    id number primary key,
    frm number not null,
    frmlPrmtrs number not null,
    Cls number not null,
    constraint FOprtnMngrFrmlPrmtrsCls foreign key(Cls) references Cls(id),
    constraint FOprtnMngrFrmlPrmtrsfrm foreign key(frm) references OprtnMngr(id)
);
create index IFrmOprtnMngrFrmlPrmtrs on OprtnMngrFrmlPrmtrs(frm);

create sequence SCmmndCrdntrExctr nocache;

create table CmmndCrdntrExctr(
    id number primary key,
    frm number not null,
    exctr number not null,
    Cls number not null,
    constraint FCmmndCrdntrExctrCls foreign key(Cls) references Cls(id),
    constraint FCmmndCrdntrExctrfrm foreign key(frm) references CmmndCrdntr(id)
);
create index IFrmCmmndCrdntrExctr on CmmndCrdntrExctr(frm);

create sequence SAccntTpMngrAccntTps nocache;

create table AccntTpMngrAccntTps(
    id number primary key,
    frm number not null,
    accntTps number not null,
    Cls number not null,
    constraint FAccntTpMngrAccntTpsCls foreign key(Cls) references Cls(id),
    constraint FAccntTpMngrAccntTpsfrm foreign key(frm) references AccntTpMngr(id)
);
create index IFrmAccntTpMngrAccntTps on AccntTpMngrAccntTps(frm);

create sequence SMssgActlPrmtrs nocache;

create table MssgActlPrmtrs(
    id number primary key,
    frm number not null,
    actlPrmtrs number not null,
    Cls number not null,
    constraint FMssgActlPrmtrsCls foreign key(Cls) references Cls(id),
    constraint FMssgActlPrmtrsfrm foreign key(frm) references MssgOrLnk(id)
);
create index IFrmMssgActlPrmtrs on MssgActlPrmtrs(frm);

create sequence SAspctMngrAspcts nocache;

create table AspctMngrAspcts(
    id number primary key,
    frm number not null,
    aspcts number not null,
    Cls number not null,
    constraint FAspctMngrAspctsCls foreign key(Cls) references Cls(id),
    constraint FAspctMngrAspctsfrm foreign key(frm) references AspctMngr(id)
);
create index IFrmAspctMngrAspcts on AspctMngrAspcts(frm);

create sequence SAccntMngrAccnts nocache;

create table AccntMngrAccnts(
    id number primary key,
    frm number not null,
    accnts number not null,
    Cls number not null,
    constraint FAccntMngrAccntsCls foreign key(Cls) references Cls(id),
    constraint FAccntMngrAccntsfrm foreign key(frm) references AccntMngr(id)
);
create index IFrmAccntMngrAccnts on AccntMngrAccnts(frm);

create sequence SCmpUntRfs nocache;

create table CmpUntRfs(
    id number primary key,
    frm number not null,
    rfs number not null,
    Cls number not null,
    constraint FCmpUntRfsCls foreign key(Cls) references Cls(id),
    constraint FCmpUntRfsfrm foreign key(frm) references AbsUnt(id)
);
create index IFrmCmpUntRfs on CmpUntRfs(frm);

create sequence SCrtMssgCMDAp nocache;

create table CrtMssgCMDAp(
    id number primary key,
    frm number not null,
    ap number not null,
    Cls number not null,
    constraint FCrtMssgCMDApCls foreign key(Cls) references Cls(id),
    constraint FCrtMssgCMDApfrm foreign key(frm) references CrtMssgCMD(id)
);
create index IFrmCrtMssgCMDAp on CrtMssgCMDAp(frm);

create sequence SCnvrsnMngrCnvrsns nocache;

create table CnvrsnMngrCnvrsns(
    id number primary key,
    frm number not null,
    cnvrsns number not null,
    Cls number not null,
    constraint FCnvrsnMngrCnvrsnsCls foreign key(Cls) references Cls(id),
    constraint FCnvrsnMngrCnvrsnsfrm foreign key(frm) references CnvrsnMngr(id)
);
create index IFrmCnvrsnMngrCnvrsns on CnvrsnMngrCnvrsns(frm);

create sequence SQnttMngrQntts nocache;

create table QnttMngrQntts(
    id number primary key,
    frm number not null,
    qntts number not null,
    Cls number not null,
    constraint FQnttMngrQnttsCls foreign key(Cls) references Cls(id),
    constraint FQnttMngrQnttsfrm foreign key(frm) references QnttMngr(id)
);
create index IFrmQnttMngrQntts on QnttMngrQntts(frm);

create sequence SCrtPrdctTpCMDFctrs nocache;

create table CrtPrdctTpCMDFctrs(
    id number primary key,
    frm number not null,
    fctrs number not null,
    Cls number not null,
    constraint FCrtPrdctTpCMDFctrsCls foreign key(Cls) references Cls(id),
    constraint FCrtPrdctTpCMDFctrsfrm foreign key(frm) references CrtPrdctTpCMD(id)
);
create index IFrmCrtPrdctTpCMDFctrs on CrtPrdctTpCMDFctrs(frm);

create sequence SCrtSttcOpCMDFp nocache;

create table CrtSttcOpCMDFp(
    id number primary key,
    frm number not null,
    fp number not null,
    Cls number not null,
    constraint FCrtSttcOpCMDFpCls foreign key(Cls) references Cls(id),
    constraint FCrtSttcOpCMDFpfrm foreign key(frm) references CrtSttcOpCMD(id)
);
create index IFrmCrtSttcOpCMDFp on CrtSttcOpCMDFp(frm);

create sequence SAssctnMngrAssctns nocache;

create table AssctnMngrAssctns(
    id number primary key,
    frm number not null,
    assctns number not null,
    Cls number not null,
    constraint FAssctnMngrAssctnsCls foreign key(Cls) references Cls(id),
    constraint FAssctnMngrAssctnsfrm foreign key(frm) references AssctnMngr(id)
);
create index IFrmAssctnMngrAssctns on AssctnMngrAssctns(frm);

create sequence SAssctnMngrHrrchs nocache;

create table AssctnMngrHrrchs(
    id number primary key,
    frm number not null,
    hrrchs number not null,
    Cls number not null,
    constraint FAssctnMngrHrrchsCls foreign key(Cls) references Cls(id),
    constraint FAssctnMngrHrrchsfrm foreign key(frm) references AssctnMngr(id)
);
create index IFrmAssctnMngrHrrchs on AssctnMngrHrrchs(frm);

create sequence SCrtVdOprtnCMDFp nocache;

create table CrtVdOprtnCMDFp(
    id number primary key,
    frm number not null,
    fp number not null,
    Cls number not null,
    constraint FCrtVdOprtnCMDFpCls foreign key(Cls) references Cls(id),
    constraint FCrtVdOprtnCMDFpfrm foreign key(frm) references CrtVdOprtnCMD(id)
);
create index IFrmCrtVdOprtnCMDFp on CrtVdOprtnCMDFp(frm);

create sequence SMAccntTpSbAccntTps nocache;

create table MAccntTpSbAccntTps(
    id number primary key,
    frm number not null,
    sbAccntTps number not null,
    Cls number not null,
    constraint FMAccntTpSbAccntTpsCls foreign key(Cls) references Cls(id),
    constraint FMAccntTpSbAccntTpsfrm foreign key(frm) references MQntObjctTp(id)
);
create index IFrmMAccntTpSbAccntTps on MAccntTpSbAccntTps(frm);

create sequence SCrtSttcMssgCMDAp nocache;

create table CrtSttcMssgCMDAp(
    id number primary key,
    frm number not null,
    ap number not null,
    Cls number not null,
    constraint FCrtSttcMssgCMDApCls foreign key(Cls) references Cls(id),
    constraint FCrtSttcMssgCMDApfrm foreign key(frm) references CrtSttcMssgCMD(id)
);
create index IFrmCrtSttcMssgCMDAp on CrtSttcMssgCMDAp(frm);

create sequence STpMngrTps nocache;

create table TpMngrTps(
    id number primary key,
    frm number not null,
    tps number not null,
    Cls number not null,
    constraint FTpMngrTpsCls foreign key(Cls) references Cls(id),
    constraint FTpMngrTpsfrm foreign key(frm) references TpMngr(id)
);
create index IFrmTpMngrTps on TpMngrTps(frm);

create sequence SMssgMngrMssgs nocache;

create table MssgMngrMssgs(
    id number primary key,
    frm number not null,
    mssgs number not null,
    Cls number not null,
    constraint FMssgMngrMssgsCls foreign key(Cls) references Cls(id),
    constraint FMssgMngrMssgsfrm foreign key(frm) references MssgMngr(id)
);
create index IFrmMssgMngrMssgs on MssgMngrMssgs(frm);

create sequence SUntTpMngrUntTps nocache;

create table UntTpMngrUntTps(
    id number primary key,
    frm number not null,
    untTps number not null,
    Cls number not null,
    constraint FUntTpMngrUntTpsCls foreign key(Cls) references Cls(id),
    constraint FUntTpMngrUntTpsfrm foreign key(frm) references UntTpMngr(id)
);
create index IFrmUntTpMngrUntTps on UntTpMngrUntTps(frm);

create sequence SUntTpMngrUnts nocache;

create table UntTpMngrUnts(
    id number primary key,
    frm number not null,
    unts number not null,
    Cls number not null,
    constraint FUntTpMngrUntsCls foreign key(Cls) references Cls(id),
    constraint FUntTpMngrUntsfrm foreign key(frm) references UntTpMngr(id)
);
create index IFrmUntTpMngrUnts on UntTpMngrUnts(frm);

create sequence SCrtVdMssgCMDAp nocache;

create table CrtVdMssgCMDAp(
    id number primary key,
    frm number not null,
    ap number not null,
    Cls number not null,
    constraint FCrtVdMssgCMDApCls foreign key(Cls) references Cls(id),
    constraint FCrtVdMssgCMDApfrm foreign key(frm) references CrtVdMssgCMD(id)
);
create index IFrmCrtVdMssgCMDAp on CrtVdMssgCMDAp(frm);

create sequence SCrtOprtnCMDFp nocache;

create table CrtOprtnCMDFp(
    id number primary key,
    frm number not null,
    fp number not null,
    Cls number not null,
    constraint FCrtOprtnCMDFpCls foreign key(Cls) references Cls(id),
    constraint FCrtOprtnCMDFpfrm foreign key(frm) references CrtOprtnCMD(id)
);
create index IFrmCrtOprtnCMDFp on CrtOprtnCMDFp(frm);

create sequence SAccntSbAccnts nocache;

create table AccntSbAccnts(
    id number primary key,
    frm number not null,
    sbAccnts number not null,
    Cls number not null,
    constraint FAccntSbAccntsCls foreign key(Cls) references Cls(id),
    constraint FAccntSbAccntsfrm foreign key(frm) references QntfObjct(id)
);
create index IFrmAccntSbAccnts on AccntSbAccnts(frm);

create sequence SAccntEntrs nocache;

create table AccntEntrs(
    id number primary key,
    frm number not null,
    entrs number not null,
    Cls number not null,
    constraint FAccntEntrsCls foreign key(Cls) references Cls(id),
    constraint FAccntEntrsfrm foreign key(frm) references QntfObjct(id)
);
create index IFrmAccntEntrs on AccntEntrs(frm);

create sequence SMsrmntTpMngMsrmntTps nocache;

create table MsrmntTpMngMsrmntTps(
    id number primary key,
    frm number not null,
    msrmntTps number not null,
    Cls number not null,
    constraint FMsrmntTpMngMsrmntTpsCls foreign key(Cls) references Cls(id),
    constraint FMsrmntTpMngMsrmntTpsfrm foreign key(frm) references MsrmntTpMng(id)
);
create index IFrmMsrmntTpMngMsrmntTps on MsrmntTpMngMsrmntTps(frm);

create sequence SLnkMngrLnks nocache;

create table LnkMngrLnks(
    id number primary key,
    frm number not null,
    lnks number not null,
    Cls number not null,
    constraint FLnkMngrLnksCls foreign key(Cls) references Cls(id),
    constraint FLnkMngrLnksfrm foreign key(frm) references LnkMngr(id)
);
create index IFrmLnkMngrLnks on LnkMngrLnks(frm);

create sequence SCmmndExctrCommands nocache;

create table CmmndExctrCommands(
    id number primary key,
    frm number not null,
    commands number not null,
    Cls number not null,
    constraint FCmmndExctrCommandsCls foreign key(Cls) references Cls(id),
    constraint FCmmndExctrCommandsfrm foreign key(frm) references CmmndExctr(id)
);
create index IFrmCmmndExctrCommands on CmmndExctrCommands(frm);

create sequence SCrtSmTpCMDAddnds nocache;

create table CrtSmTpCMDAddnds(
    id number primary key,
    frm number not null,
    addnds number not null,
    Cls number not null,
    constraint FCrtSmTpCMDAddndsCls foreign key(Cls) references Cls(id),
    constraint FCrtSmTpCMDAddndsfrm foreign key(frm) references CrtSmTpCMD(id)
);
create index IFrmCrtSmTpCMDAddnds on CrtSmTpCMDAddnds(frm);

create sequence SObjctMngrObjcts nocache;

create table ObjctMngrObjcts(
    id number primary key,
    frm number not null,
    objcts number not null,
    Cls number not null,
    constraint FObjctMngrObjctsCls foreign key(Cls) references Cls(id),
    constraint FObjctMngrObjctsfrm foreign key(frm) references ObjctMngr(id)
);
create index IFrmObjctMngrObjcts on ObjctMngrObjcts(frm);

