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

create sequence SMEnm nocache;

create table MEnm(
    id number primary key,
    Cls number not null,
    MEnmNm varchar2(2000),
    MEnmThis number,
    MEnmThisCls number,
    constraint FMEnmThis foreign key (MEnmThisCls) references Cls (id),
    MEnmMyCONCMMdlItm number,
    MEnmMyCONCMMdlItmCls number,
    constraint FMEnmMyCONCMMdlItm foreign key (MEnmMyCONCMMdlItmCls) references Cls (id)    
);
create index INmMEnm on MEnm (MEnmNm);


create sequence SAbsObj nocache;

create table AbsObj(
    id number primary key,
    Cls number not null,
    AbsObjThis number,
    AbsObjThisCls number,
    constraint FAbsObjThis foreign key (AbsObjThisCls) references Cls (id),
    AbsObjMyCONCMMdlItm number,
    AbsObjMyCONCMMdlItmCls number,
    constraint FAbsObjMyCONCMMdlItm foreign key (AbsObjMyCONCMMdlItmCls) references Cls (id),
    SngltnObjTp number,
    SngltnObjTpCls number,
    constraint FSngltnObjTp foreign key (SngltnObjTpCls) references Cls (id)    
);

create sequence SCnvrtTDfltCMD nocache;

create table CnvrtTDfltCMD(
    id number primary key,
    Cls number not null,
    CnvrtTDfltCMDQntt number,
    CnvrtTDfltCMDQnttCls number,
    constraint FCnvrtTDfltCMDQntt foreign key (CnvrtTDfltCMDQnttCls) references Cls (id),
    CnvrtTDfltCMDInvoker number,
    CnvrtTDfltCMDInvokerCls number,
    constraint FCnvrtTDfltCMDInvoker foreign key (CnvrtTDfltCMDInvokerCls) references Cls (id),
    CnvrtTDfltCMDCReceiver number,
    CnvrtTDfltCMDCReceiverCls number,
    constraint FCnvrtTDfltCMDCReceiver foreign key (CnvrtTDfltCMDCReceiverCls) references Cls (id),
    CnvrtTDfltCMDMyCmmnDt number,
    CnvrtTDfltCMDMyCmmnDtCls number,
    constraint FCnvrtTDfltCMDMyCmmnDt foreign key (CnvrtTDfltCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtEnmCMD nocache;

create table CrtEnmCMD(
    id number primary key,
    Cls number not null,
    CrtEnmCMDNm varchar2(2000),
    CrtEnmCMDInvoker number,
    CrtEnmCMDInvokerCls number,
    constraint FCrtEnmCMDInvoker foreign key (CrtEnmCMDInvokerCls) references Cls (id),
    CrtEnmCMDCReceiver number,
    CrtEnmCMDCReceiverCls number,
    constraint FCrtEnmCMDCReceiver foreign key (CrtEnmCMDCReceiverCls) references Cls (id),
    CrtEnmCMDMyCmmnDt number,
    CrtEnmCMDMyCmmnDtCls number,
    constraint FCrtEnmCMDMyCmmnDt foreign key (CrtEnmCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtMObjctCMD nocache;

create table CrtMObjctCMD(
    id number primary key,
    Cls number not null,
    CrtMObjctCMDTp number,
    CrtMObjctCMDTpCls number,
    constraint FCrtMObjctCMDTp foreign key (CrtMObjctCMDTpCls) references Cls (id),
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

create sequence SAddTpCMD nocache;

create table AddTpCMD(
    id number primary key,
    Cls number not null,
    AddTpCMDObjct number,
    AddTpCMDObjctCls number,
    constraint FAddTpCMDObjct foreign key (AddTpCMDObjctCls) references Cls (id),
    AddTpCMDNwTp number,
    AddTpCMDNwTpCls number,
    constraint FAddTpCMDNwTp foreign key (AddTpCMDNwTpCls) references Cls (id),
    AddTpCMDInvoker number,
    AddTpCMDInvokerCls number,
    constraint FAddTpCMDInvoker foreign key (AddTpCMDInvokerCls) references Cls (id),
    AddTpCMDCReceiver number,
    AddTpCMDCReceiverCls number,
    constraint FAddTpCMDCReceiver foreign key (AddTpCMDCReceiverCls) references Cls (id),
    AddTpCMDMyCmmnDt number,
    AddTpCMDMyCmmnDtCls number,
    constraint FAddTpCMDMyCmmnDt foreign key (AddTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAssgnTpCMD nocache;

create table AssgnTpCMD(
    id number primary key,
    Cls number not null,
    AssgnTpCMDSchm number,
    AssgnTpCMDSchmCls number,
    constraint FAssgnTpCMDSchm foreign key (AssgnTpCMDSchmCls) references Cls (id),
    AssgnTpCMDTp number,
    AssgnTpCMDTpCls number,
    constraint FAssgnTpCMDTp foreign key (AssgnTpCMDTpCls) references Cls (id),
    AssgnTpCMDInvoker number,
    AssgnTpCMDInvokerCls number,
    constraint FAssgnTpCMDInvoker foreign key (AssgnTpCMDInvokerCls) references Cls (id),
    AssgnTpCMDCReceiver number,
    AssgnTpCMDCReceiverCls number,
    constraint FAssgnTpCMDCReceiver foreign key (AssgnTpCMDCReceiverCls) references Cls (id),
    AssgnTpCMDCResult number,
    AssgnTpCMDCResultCls number,
    constraint FAssgnTpCMDCResult foreign key (AssgnTpCMDCResultCls) references Cls (id),
    AssgnTpCMDMyCmmnDt number,
    AssgnTpCMDMyCmmnDtCls number,
    constraint FAssgnTpCMDMyCmmnDt foreign key (AssgnTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SFtchCUCMD nocache;

create table FtchCUCMD(
    id number primary key,
    Cls number not null,
    FtchCUCMDNm varchar2(2000),
    FtchCUCMDInvoker number,
    FtchCUCMDInvokerCls number,
    constraint FFtchCUCMDInvoker foreign key (FtchCUCMDInvokerCls) references Cls (id),
    FtchCUCMDCReceiver number,
    FtchCUCMDCReceiverCls number,
    constraint FFtchCUCMDCReceiver foreign key (FtchCUCMDCReceiverCls) references Cls (id),
    FtchCUCMDCResult number,
    FtchCUCMDCResultCls number,
    constraint FFtchCUCMDCResult foreign key (FtchCUCMDCResultCls) references Cls (id),
    FtchCUCMDMyCmmnDt number,
    FtchCUCMDMyCmmnDtCls number,
    constraint FFtchCUCMDMyCmmnDt foreign key (FtchCUCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMnStrtg nocache;

create table MnStrtg(
    id number primary key,
    Cls number not null,
    MnStrtgThis number,
    MnStrtgThisCls number,
    constraint FMnStrtgThis foreign key (MnStrtgThisCls) references Cls (id)    
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
    CrtUntTpCMDCResult number,
    CrtUntTpCMDCResultCls number,
    constraint FCrtUntTpCMDCResult foreign key (CrtUntTpCMDCResultCls) references Cls (id),
    CrtUntTpCMDMyCmmnDt number,
    CrtUntTpCMDMyCmmnDtCls number,
    constraint FCrtUntTpCMDMyCmmnDt foreign key (CrtUntTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SRmvHrrchCMD nocache;

create table RmvHrrchCMD(
    id number primary key,
    Cls number not null,
    RmvHrrchCMDH number,
    RmvHrrchCMDHCls number,
    constraint FRmvHrrchCMDH foreign key (RmvHrrchCMDHCls) references Cls (id),
    RmvHrrchCMDInvoker number,
    RmvHrrchCMDInvokerCls number,
    constraint FRmvHrrchCMDInvoker foreign key (RmvHrrchCMDInvokerCls) references Cls (id),
    RmvHrrchCMDCReceiver number,
    RmvHrrchCMDCReceiverCls number,
    constraint FRmvHrrchCMDCReceiver foreign key (RmvHrrchCMDCReceiverCls) references Cls (id),
    RmvHrrchCMDMyCmmnDt number,
    RmvHrrchCMDMyCmmnDtCls number,
    constraint FRmvHrrchCMDMyCmmnDt foreign key (RmvHrrchCMDMyCmmnDtCls) references Cls (id)    
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
    CrtUntCMDCResult number,
    CrtUntCMDCResultCls number,
    constraint FCrtUntCMDCResult foreign key (CrtUntCMDCResultCls) references Cls (id),
    CrtUntCMDMyCmmnDt number,
    CrtUntCMDMyCmmnDtCls number,
    constraint FCrtUntCMDMyCmmnDt foreign key (CrtUntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SNSInst nocache;

create table NSInst(
    id number primary key,
    Cls number not null,
    NSInstNm varchar2(2000),
    NSInstTp number,
    NSInstTpCls number,
    constraint FNSInstTp foreign key (NSInstTpCls) references Cls (id),
    NSInstThis number,
    NSInstThisCls number,
    constraint FNSInstThis foreign key (NSInstThisCls) references Cls (id)    
);
create index ITpNSInst on NSInst (NSInstTp, NSInstTpCls);


create sequence SCrTpDisjCMD nocache;

create table CrTpDisjCMD(
    id number primary key,
    Cls number not null,
    CrTpDisjCMDInvoker number,
    CrTpDisjCMDInvokerCls number,
    constraint FCrTpDisjCMDInvoker foreign key (CrTpDisjCMDInvokerCls) references Cls (id),
    CrTpDisjCMDCReceiver number,
    CrTpDisjCMDCReceiverCls number,
    constraint FCrTpDisjCMDCReceiver foreign key (CrTpDisjCMDCReceiverCls) references Cls (id),
    CrTpDisjCMDCResult number,
    CrTpDisjCMDCResultCls number,
    constraint FCrTpDisjCMDCResult foreign key (CrTpDisjCMDCResultCls) references Cls (id),
    CrTpDisjCMDMyCmmnDt number,
    CrTpDisjCMDMyCmmnDtCls number,
    constraint FCrTpDisjCMDMyCmmnDt foreign key (CrTpDisjCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SRmvTpCMD nocache;

create table RmvTpCMD(
    id number primary key,
    Cls number not null,
    RmvTpCMDObjct number,
    RmvTpCMDObjctCls number,
    constraint FRmvTpCMDObjct foreign key (RmvTpCMDObjctCls) references Cls (id),
    RmvTpCMDOldTp number,
    RmvTpCMDOldTpCls number,
    constraint FRmvTpCMDOldTp foreign key (RmvTpCMDOldTpCls) references Cls (id),
    RmvTpCMDInvoker number,
    RmvTpCMDInvokerCls number,
    constraint FRmvTpCMDInvoker foreign key (RmvTpCMDInvokerCls) references Cls (id),
    RmvTpCMDCReceiver number,
    RmvTpCMDCReceiverCls number,
    constraint FRmvTpCMDCReceiver foreign key (RmvTpCMDCReceiverCls) references Cls (id),
    RmvTpCMDMyCmmnDt number,
    RmvTpCMDMyCmmnDtCls number,
    constraint FRmvTpCMDMyCmmnDt foreign key (RmvTpCMDMyCmmnDtCls) references Cls (id)    
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
create index ISrcAbsOprtn on AbsOprtn (AbsOprtnSrc, AbsOprtnSrcCls);


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

create sequence SStCnvrsnCMD nocache;

create table StCnvrsnCMD(
    id number primary key,
    Cls number not null,
    StCnvrsnCMDUnt number,
    StCnvrsnCMDUntCls number,
    constraint FStCnvrsnCMDUnt foreign key (StCnvrsnCMDUntCls) references Cls (id),
    StCnvrsnCMDFctr varchar2(2000),
    StCnvrsnCMDCnstnt varchar2(2000),
    StCnvrsnCMDInvoker number,
    StCnvrsnCMDInvokerCls number,
    constraint FStCnvrsnCMDInvoker foreign key (StCnvrsnCMDInvokerCls) references Cls (id),
    StCnvrsnCMDCReceiver number,
    StCnvrsnCMDCReceiverCls number,
    constraint FStCnvrsnCMDCReceiver foreign key (StCnvrsnCMDCReceiverCls) references Cls (id),
    StCnvrsnCMDMyCmmnDt number,
    StCnvrsnCMDMyCmmnDtCls number,
    constraint FStCnvrsnCMDMyCmmnDt foreign key (StCnvrsnCMDMyCmmnDtCls) references Cls (id)    
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


create sequence SNmSchm nocache;

create table NmSchm(
    id number primary key,
    Cls number not null,
    NmSchmRgExpPttrn varchar2(2000),
    NmSchmNm varchar2(2000),
    NmSchmIsItrbl number,
    NmSchmIsItrblCls number,
    constraint FNmSchmIsItrbl foreign key (NmSchmIsItrblCls) references Cls (id),
    NmSchmThis number,
    NmSchmThisCls number,
    constraint FNmSchmThis foreign key (NmSchmThisCls) references Cls (id)    
);
create index INmNmSchm on NmSchm (NmSchmNm);


create sequence SRnmAspctCMD nocache;

create table RnmAspctCMD(
    id number primary key,
    Cls number not null,
    RnmAspctCMDAspct number,
    RnmAspctCMDAspctCls number,
    constraint FRnmAspctCMDAspct foreign key (RnmAspctCMDAspctCls) references Cls (id),
    RnmAspctCMDNwNm varchar2(2000),
    RnmAspctCMDInvoker number,
    RnmAspctCMDInvokerCls number,
    constraint FRnmAspctCMDInvoker foreign key (RnmAspctCMDInvokerCls) references Cls (id),
    RnmAspctCMDCReceiver number,
    RnmAspctCMDCReceiverCls number,
    constraint FRnmAspctCMDCReceiver foreign key (RnmAspctCMDCReceiverCls) references Cls (id),
    RnmAspctCMDMyCmmnDt number,
    RnmAspctCMDMyCmmnDtCls number,
    constraint FRnmAspctCMDMyCmmnDt foreign key (RnmAspctCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrTpConjCMD nocache;

create table CrTpConjCMD(
    id number primary key,
    Cls number not null,
    CrTpConjCMDInvoker number,
    CrTpConjCMDInvokerCls number,
    constraint FCrTpConjCMDInvoker foreign key (CrTpConjCMDInvokerCls) references Cls (id),
    CrTpConjCMDCReceiver number,
    CrTpConjCMDCReceiverCls number,
    constraint FCrTpConjCMDCReceiver foreign key (CrTpConjCMDCReceiverCls) references Cls (id),
    CrTpConjCMDCResult number,
    CrTpConjCMDCResultCls number,
    constraint FCrTpConjCMDCResult foreign key (CrTpConjCMDCResultCls) references Cls (id),
    CrTpConjCMDMyCmmnDt number,
    CrTpConjCMDMyCmmnDtCls number,
    constraint FCrTpConjCMDMyCmmnDt foreign key (CrTpConjCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAssgnNmCMD nocache;

create table AssgnNmCMD(
    id number primary key,
    Cls number not null,
    AssgnNmCMDObjct number,
    AssgnNmCMDObjctCls number,
    constraint FAssgnNmCMDObjct foreign key (AssgnNmCMDObjctCls) references Cls (id),
    AssgnNmCMDNm number,
    AssgnNmCMDNmCls number,
    constraint FAssgnNmCMDNm foreign key (AssgnNmCMDNmCls) references Cls (id),
    AssgnNmCMDVl varchar2(2000),
    AssgnNmCMDInvoker number,
    AssgnNmCMDInvokerCls number,
    constraint FAssgnNmCMDInvoker foreign key (AssgnNmCMDInvokerCls) references Cls (id),
    AssgnNmCMDCReceiver number,
    AssgnNmCMDCReceiverCls number,
    constraint FAssgnNmCMDCReceiver foreign key (AssgnNmCMDCReceiverCls) references Cls (id),
    AssgnNmCMDMyCmmnDt number,
    AssgnNmCMDMyCmmnDtCls number,
    constraint FAssgnNmCMDMyCmmnDt foreign key (AssgnNmCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SChngUNmCMD nocache;

create table ChngUNmCMD(
    id number primary key,
    Cls number not null,
    ChngUNmCMDUnt number,
    ChngUNmCMDUntCls number,
    constraint FChngUNmCMDUnt foreign key (ChngUNmCMDUntCls) references Cls (id),
    ChngUNmCMDNm varchar2(2000),
    ChngUNmCMDInvoker number,
    ChngUNmCMDInvokerCls number,
    constraint FChngUNmCMDInvoker foreign key (ChngUNmCMDInvokerCls) references Cls (id),
    ChngUNmCMDCReceiver number,
    ChngUNmCMDCReceiverCls number,
    constraint FChngUNmCMDCReceiver foreign key (ChngUNmCMDCReceiverCls) references Cls (id),
    ChngUNmCMDMyCmmnDt number,
    ChngUNmCMDMyCmmnDtCls number,
    constraint FChngUNmCMDMyCmmnDt foreign key (ChngUNmCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAggrgtCMD nocache;

create table AggrgtCMD(
    id number primary key,
    Cls number not null,
    AggrgtCMDStrtg number,
    AggrgtCMDStrtgCls number,
    constraint FAggrgtCMDStrtg foreign key (AggrgtCMDStrtgCls) references Cls (id),
    AggrgtCMDInvoker number,
    AggrgtCMDInvokerCls number,
    constraint FAggrgtCMDInvoker foreign key (AggrgtCMDInvokerCls) references Cls (id),
    AggrgtCMDCReceiver number,
    AggrgtCMDCReceiverCls number,
    constraint FAggrgtCMDCReceiver foreign key (AggrgtCMDCReceiverCls) references Cls (id),
    AggrgtCMDCResult number,
    AggrgtCMDCResultCls number,
    constraint FAggrgtCMDCResult foreign key (AggrgtCMDCResultCls) references Cls (id),
    AggrgtCMDMyCmmnDt number,
    AggrgtCMDMyCmmnDtCls number,
    constraint FAggrgtCMDMyCmmnDt foreign key (AggrgtCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAddSbAccTypCMD nocache;

create table AddSbAccTypCMD(
    id number primary key,
    Cls number not null,
    AddSbAccTypCMDAccntTp number,
    AddSbAccTypCMDAccntTpCls number,
    constraint FAddSbAccTypCMDAccntTp foreign key (AddSbAccTypCMDAccntTpCls) references Cls (id),
    AddSbAccTypCMDInvoker number,
    AddSbAccTypCMDInvokerCls number,
    constraint FAddSbAccTypCMDInvoker foreign key (AddSbAccTypCMDInvokerCls) references Cls (id),
    AddSbAccTypCMDCReceiver number,
    AddSbAccTypCMDCReceiverCls number,
    constraint FAddSbAccTypCMDCReceiver foreign key (AddSbAccTypCMDCReceiverCls) references Cls (id),
    AddSbAccTypCMDMyCmmnDt number,
    AddSbAccTypCMDMyCmmnDtCls number,
    constraint FAddSbAccTypCMDMyCmmnDt foreign key (AddSbAccTypCMDMyCmmnDtCls) references Cls (id)    
);

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

create sequence SMObsrvtnTp nocache;

create table MObsrvtnTp(
    id number primary key,
    Cls number not null,
    MObsrvtnTpNm varchar2(2000),
    MObsrvtnTpEnmTp number,
    MObsrvtnTpEnmTpCls number,
    constraint FMObsrvtnTpEnmTp foreign key (MObsrvtnTpEnmTpCls) references Cls (id),
    MObsrvtnTpThTp number,
    MObsrvtnTpThTpCls number,
    constraint FMObsrvtnTpThTp foreign key (MObsrvtnTpThTpCls) references Cls (id),
    MObsrvtnTpThis number,
    MObsrvtnTpThisCls number,
    constraint FMObsrvtnTpThis foreign key (MObsrvtnTpThisCls) references Cls (id),
    MObsrvtnTpMyCONCMMdlItm number,
    MObsrvtnTpMyCONCMMdlItmCls number,
    constraint FMObsrvtnTpMyCONCMMdlItm foreign key (MObsrvtnTpMyCONCMMdlItmCls) references Cls (id)    
);
create index INmMObsrvtnTp on MObsrvtnTp (MObsrvtnTpNm);
create index IEnmTpMObsrvtnTp on MObsrvtnTp (MObsrvtnTpEnmTp, MObsrvtnTpEnmTpCls);
create index IThTpMObsrvtnTp on MObsrvtnTp (MObsrvtnTpThTp, MObsrvtnTpThTpCls);


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
    CrtHrrchCMDCResult number,
    CrtHrrchCMDCResultCls number,
    constraint FCrtHrrchCMDCResult foreign key (CrtHrrchCMDCResultCls) references Cls (id),
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


create sequence SMlCMD nocache;

create table MlCMD(
    id number primary key,
    Cls number not null,
    MlCMDFctr1 number,
    MlCMDFctr1Cls number,
    constraint FMlCMDFctr1 foreign key (MlCMDFctr1Cls) references Cls (id),
    MlCMDFctr2 number,
    MlCMDFctr2Cls number,
    constraint FMlCMDFctr2 foreign key (MlCMDFctr2Cls) references Cls (id),
    MlCMDInvoker number,
    MlCMDInvokerCls number,
    constraint FMlCMDInvoker foreign key (MlCMDInvokerCls) references Cls (id),
    MlCMDCReceiver number,
    MlCMDCReceiverCls number,
    constraint FMlCMDCReceiver foreign key (MlCMDCReceiverCls) references Cls (id),
    MlCMDCResult number,
    MlCMDCResultCls number,
    constraint FMlCMDCResult foreign key (MlCMDCResultCls) references Cls (id),
    MlCMDMyCmmnDt number,
    MlCMDMyCmmnDtCls number,
    constraint FMlCMDMyCmmnDt foreign key (MlCMDMyCmmnDtCls) references Cls (id)    
);

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

create sequence SMObsrvtn nocache;

create table MObsrvtn(
    id number primary key,
    Cls number not null,
    MObsrvtnNm varchar2(2000),
    MObsrvtnThTp number,
    MObsrvtnThTpCls number,
    constraint FMObsrvtnThTp foreign key (MObsrvtnThTpCls) references Cls (id),
    MObsrvtnEnmVl number,
    MObsrvtnEnmVlCls number,
    constraint FMObsrvtnEnmVl foreign key (MObsrvtnEnmVlCls) references Cls (id),
    MObsrvtnThObsObjct number,
    MObsrvtnThObsObjctCls number,
    constraint FMObsrvtnThObsObjct foreign key (MObsrvtnThObsObjctCls) references Cls (id),
    MObsrvtnThis number,
    MObsrvtnThisCls number,
    constraint FMObsrvtnThis foreign key (MObsrvtnThisCls) references Cls (id),
    MObsrvtnMyCONCMMdlItm number,
    MObsrvtnMyCONCMMdlItmCls number,
    constraint FMObsrvtnMyCONCMMdlItm foreign key (MObsrvtnMyCONCMMdlItmCls) references Cls (id)    
);
create index INmMObsrvtn on MObsrvtn (MObsrvtnNm);
create index IThTpMObsrvtn on MObsrvtn (MObsrvtnThTp, MObsrvtnThTpCls);
create index IEnmVlMObsrvtn on MObsrvtn (MObsrvtnEnmVl, MObsrvtnEnmVlCls);
create index IThObsObjctMObsrvtn on MObsrvtn (MObsrvtnThObsObjct, MObsrvtnThObsObjctCls);


create sequence SMMdlItm nocache;

create table MMdlItm(
    id number primary key,
    Cls number not null,
    MMdlItmThis number,
    MMdlItmThisCls number,
    constraint FMMdlItmThis foreign key (MMdlItmThisCls) references Cls (id)    
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
    CrtQnttCMDCResult number,
    CrtQnttCMDCResultCls number,
    constraint FCrtQnttCMDCResult foreign key (CrtQnttCMDCResultCls) references Cls (id),
    CrtQnttCMDMyCmmnDt number,
    CrtQnttCMDMyCmmnDtCls number,
    constraint FCrtQnttCMDMyCmmnDt foreign key (CrtQnttCMDMyCmmnDtCls) references Cls (id)    
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

create sequence SGtExstngCUTCMD nocache;

create table GtExstngCUTCMD(
    id number primary key,
    Cls number not null,
    GtExstngCUTCMDInvoker number,
    GtExstngCUTCMDInvokerCls number,
    constraint FGtExstngCUTCMDInvoker foreign key (GtExstngCUTCMDInvokerCls) references Cls (id),
    GtExstngCUTCMDCReceiver number,
    GtExstngCUTCMDCReceiverCls number,
    constraint FGtExstngCUTCMDCReceiver foreign key (GtExstngCUTCMDCReceiverCls) references Cls (id),
    GtExstngCUTCMDCResult number,
    GtExstngCUTCMDCResultCls number,
    constraint FGtExstngCUTCMDCResult foreign key (GtExstngCUTCMDCResultCls) references Cls (id),
    GtExstngCUTCMDMyCmmnDt number,
    GtExstngCUTCMDMyCmmnDtCls number,
    constraint FGtExstngCUTCMDMyCmmnDt foreign key (GtExstngCUTCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SEnmVlMngr nocache;

create table EnmVlMngr(
    id number primary key,
    Cls number not null,
    EnmVlMngrThis number,
    EnmVlMngrThisCls number,
    constraint FEnmVlMngrThis foreign key (EnmVlMngrThisCls) references Cls (id)    
);

create sequence SMBln nocache;

create table MBln(
    id number primary key,
    Cls number not null,
    MBlnThis number,
    MBlnThisCls number,
    constraint FMBlnThis foreign key (MBlnThisCls) references Cls (id)    
);

create sequence SFtchSclrCMD nocache;

create table FtchSclrCMD(
    id number primary key,
    Cls number not null,
    FtchSclrCMDInvoker number,
    FtchSclrCMDInvokerCls number,
    constraint FFtchSclrCMDInvoker foreign key (FtchSclrCMDInvokerCls) references Cls (id),
    FtchSclrCMDCReceiver number,
    FtchSclrCMDCReceiverCls number,
    constraint FFtchSclrCMDCReceiver foreign key (FtchSclrCMDCReceiverCls) references Cls (id),
    FtchSclrCMDCResult number,
    FtchSclrCMDCResultCls number,
    constraint FFtchSclrCMDCResult foreign key (FtchSclrCMDCResultCls) references Cls (id),
    FtchSclrCMDMyCmmnDt number,
    FtchSclrCMDMyCmmnDtCls number,
    constraint FFtchSclrCMDMyCmmnDt foreign key (FtchSclrCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SBscClcltn nocache;

create table BscClcltn(
    id number primary key,
    Cls number not null,
    BscClcltnArg1 number,
    BscClcltnArg1Cls number,
    constraint FBscClcltnArg1 foreign key (BscClcltnArg1Cls) references Cls (id),
    BscClcltnArg2 number,
    BscClcltnArg2Cls number,
    constraint FBscClcltnArg2 foreign key (BscClcltnArg2Cls) references Cls (id),
    BscClcltnRsltt number,
    BscClcltnRslttCls number,
    constraint FBscClcltnRsltt foreign key (BscClcltnRslttCls) references Cls (id),
    BscClcltnThis number,
    BscClcltnThisCls number,
    constraint FBscClcltnThis foreign key (BscClcltnThisCls) references Cls (id),
    UntMtbClcTrgtUnt number,
    UntMtbClcTrgtUntCls number,
    constraint FUntMtbClcTrgtUnt foreign key (UntMtbClcTrgtUntCls) references Cls (id),
    UntMtbClcTrgtUntTp number,
    UntMtbClcTrgtUntTpCls number,
    constraint FUntMtbClcTrgtUntTp foreign key (UntMtbClcTrgtUntTpCls) references Cls (id)    
);

create sequence SNmInstnc nocache;

create table NmInstnc(
    id number primary key,
    Cls number not null,
    NmInstncTp number,
    NmInstncTpCls number,
    constraint FNmInstncTp foreign key (NmInstncTpCls) references Cls (id),
    NmInstncFrmObjct number,
    NmInstncFrmObjctCls number,
    constraint FNmInstncFrmObjct foreign key (NmInstncFrmObjctCls) references Cls (id),
    NmInstncNmSchm number,
    NmInstncNmSchmCls number,
    constraint FNmInstncNmSchm foreign key (NmInstncNmSchmCls) references Cls (id),
    NmInstncThis number,
    NmInstncThisCls number,
    constraint FNmInstncThis foreign key (NmInstncThisCls) references Cls (id)    
);
create index IFrmObjctNmInstnc on NmInstnc (NmInstncFrmObjct, NmInstncFrmObjctCls);


create sequence SDltEnmCMD nocache;

create table DltEnmCMD(
    id number primary key,
    Cls number not null,
    DltEnmCMDTp number,
    DltEnmCMDTpCls number,
    constraint FDltEnmCMDTp foreign key (DltEnmCMDTpCls) references Cls (id),
    DltEnmCMDInvoker number,
    DltEnmCMDInvokerCls number,
    constraint FDltEnmCMDInvoker foreign key (DltEnmCMDInvokerCls) references Cls (id),
    DltEnmCMDCReceiver number,
    DltEnmCMDCReceiverCls number,
    constraint FDltEnmCMDCReceiver foreign key (DltEnmCMDCReceiverCls) references Cls (id),
    DltEnmCMDMyCmmnDt number,
    DltEnmCMDMyCmmnDtCls number,
    constraint FDltEnmCMDMyCmmnDt foreign key (DltEnmCMDMyCmmnDtCls) references Cls (id)    
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

create sequence SFtchRfrncCMD nocache;

create table FtchRfrncCMD(
    id number primary key,
    Cls number not null,
    FtchRfrncCMDUnt number,
    FtchRfrncCMDUntCls number,
    constraint FFtchRfrncCMDUnt foreign key (FtchRfrncCMDUntCls) references Cls (id),
    FtchRfrncCMDExpnnt number,
    FtchRfrncCMDInvoker number,
    FtchRfrncCMDInvokerCls number,
    constraint FFtchRfrncCMDInvoker foreign key (FtchRfrncCMDInvokerCls) references Cls (id),
    FtchRfrncCMDCReceiver number,
    FtchRfrncCMDCReceiverCls number,
    constraint FFtchRfrncCMDCReceiver foreign key (FtchRfrncCMDCReceiverCls) references Cls (id),
    FtchRfrncCMDCResult number,
    FtchRfrncCMDCResultCls number,
    constraint FFtchRfrncCMDCResult foreign key (FtchRfrncCMDCResultCls) references Cls (id),
    FtchRfrncCMDMyCmmnDt number,
    FtchRfrncCMDMyCmmnDtCls number,
    constraint FFtchRfrncCMDMyCmmnDt foreign key (FtchRfrncCMDMyCmmnDtCls) references Cls (id)    
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
    CrtCnstntCMDCResult number,
    CrtCnstntCMDCResultCls number,
    constraint FCrtCnstntCMDCResult foreign key (CrtCnstntCMDCResultCls) references Cls (id),
    CrtCnstntCMDMyCmmnDt number,
    CrtCnstntCMDMyCmmnDtCls number,
    constraint FCrtCnstntCMDMyCmmnDt foreign key (CrtCnstntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAddRfrncCMD nocache;

create table AddRfrncCMD(
    id number primary key,
    Cls number not null,
    AddRfrncCMDNm varchar2(2000),
    AddRfrncCMDUnt number,
    AddRfrncCMDUntCls number,
    constraint FAddRfrncCMDUnt foreign key (AddRfrncCMDUntCls) references Cls (id),
    AddRfrncCMDRfrncUnt number,
    AddRfrncCMDRfrncUntCls number,
    constraint FAddRfrncCMDRfrncUnt foreign key (AddRfrncCMDRfrncUntCls) references Cls (id),
    AddRfrncCMDExpnnt number,
    AddRfrncCMDInvoker number,
    AddRfrncCMDInvokerCls number,
    constraint FAddRfrncCMDInvoker foreign key (AddRfrncCMDInvokerCls) references Cls (id),
    AddRfrncCMDCReceiver number,
    AddRfrncCMDCReceiverCls number,
    constraint FAddRfrncCMDCReceiver foreign key (AddRfrncCMDCReceiverCls) references Cls (id),
    AddRfrncCMDCResult number,
    AddRfrncCMDCResultCls number,
    constraint FAddRfrncCMDCResult foreign key (AddRfrncCMDCResultCls) references Cls (id),
    AddRfrncCMDMyCmmnDt number,
    AddRfrncCMDMyCmmnDtCls number,
    constraint FAddRfrncCMDMyCmmnDt foreign key (AddRfrncCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMAspct nocache;

create table MAspct(
    id number primary key,
    Cls number not null,
    MAspctNm varchar2(2000),
    MAspctThis number,
    MAspctThisCls number,
    constraint FMAspctThis foreign key (MAspctThisCls) references Cls (id),
    MAspctMyCONCMMdlItm number,
    MAspctMyCONCMMdlItmCls number,
    constraint FMAspctMyCONCMMdlItm foreign key (MAspctMyCONCMMdlItmCls) references Cls (id)    
);
create index INmMAspct on MAspct (MAspctNm);


create sequence SCrtNmSchmCMD nocache;

create table CrtNmSchmCMD(
    id number primary key,
    Cls number not null,
    CrtNmSchmCMDNm varchar2(2000),
    CrtNmSchmCMDRgExpPttrn varchar2(2000),
    CrtNmSchmCMDIsItrbl number,
    CrtNmSchmCMDIsItrblCls number,
    constraint FCrtNmSchmCMDIsItrbl foreign key (CrtNmSchmCMDIsItrblCls) references Cls (id),
    CrtNmSchmCMDInvoker number,
    CrtNmSchmCMDInvokerCls number,
    constraint FCrtNmSchmCMDInvoker foreign key (CrtNmSchmCMDInvokerCls) references Cls (id),
    CrtNmSchmCMDCReceiver number,
    CrtNmSchmCMDCReceiverCls number,
    constraint FCrtNmSchmCMDCReceiver foreign key (CrtNmSchmCMDCReceiverCls) references Cls (id),
    CrtNmSchmCMDCResult number,
    CrtNmSchmCMDCResultCls number,
    constraint FCrtNmSchmCMDCResult foreign key (CrtNmSchmCMDCResultCls) references Cls (id),
    CrtNmSchmCMDMyCmmnDt number,
    CrtNmSchmCMDMyCmmnDtCls number,
    constraint FCrtNmSchmCMDMyCmmnDt foreign key (CrtNmSchmCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAccntMngr nocache;

create table AccntMngr(
    id number primary key,
    Cls number not null,
    AccntMngrThis number,
    AccntMngrThisCls number,
    constraint FAccntMngrThis foreign key (AccntMngrThisCls) references Cls (id)    
);

create sequence SAddEntrCMD nocache;

create table AddEntrCMD(
    id number primary key,
    Cls number not null,
    AddEntrCMDMsrmnt number,
    AddEntrCMDMsrmntCls number,
    constraint FAddEntrCMDMsrmnt foreign key (AddEntrCMDMsrmntCls) references Cls (id),
    AddEntrCMDInvoker number,
    AddEntrCMDInvokerCls number,
    constraint FAddEntrCMDInvoker foreign key (AddEntrCMDInvokerCls) references Cls (id),
    AddEntrCMDCReceiver number,
    AddEntrCMDCReceiverCls number,
    constraint FAddEntrCMDCReceiver foreign key (AddEntrCMDCReceiverCls) references Cls (id),
    AddEntrCMDMyCmmnDt number,
    AddEntrCMDMyCmmnDtCls number,
    constraint FAddEntrCMDMyCmmnDt foreign key (AddEntrCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SGtExstngCUCMD nocache;

create table GtExstngCUCMD(
    id number primary key,
    Cls number not null,
    GtExstngCUCMDInvoker number,
    GtExstngCUCMDInvokerCls number,
    constraint FGtExstngCUCMDInvoker foreign key (GtExstngCUCMDInvokerCls) references Cls (id),
    GtExstngCUCMDCReceiver number,
    GtExstngCUCMDCReceiverCls number,
    constraint FGtExstngCUCMDCReceiver foreign key (GtExstngCUCMDCReceiverCls) references Cls (id),
    GtExstngCUCMDCResult number,
    GtExstngCUCMDCResultCls number,
    constraint FGtExstngCUCMDCResult foreign key (GtExstngCUCMDCResultCls) references Cls (id),
    GtExstngCUCMDMyCmmnDt number,
    GtExstngCUCMDMyCmmnDtCls number,
    constraint FGtExstngCUCMDMyCmmnDt foreign key (GtExstngCUCMDMyCmmnDtCls) references Cls (id)    
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

create sequence SObsrvtnMngr nocache;

create table ObsrvtnMngr(
    id number primary key,
    Cls number not null,
    ObsrvtnMngrThis number,
    ObsrvtnMngrThisCls number,
    constraint FObsrvtnMngrThis foreign key (ObsrvtnMngrThisCls) references Cls (id)    
);

create sequence SMEnmVl nocache;

create table MEnmVl(
    id number primary key,
    Cls number not null,
    MEnmVlNm varchar2(2000),
    MEnmVlThTp number,
    MEnmVlThTpCls number,
    constraint FMEnmVlThTp foreign key (MEnmVlThTpCls) references Cls (id),
    MEnmVlThis number,
    MEnmVlThisCls number,
    constraint FMEnmVlThis foreign key (MEnmVlThisCls) references Cls (id),
    MEnmVlMyCONCMMdlItm number,
    MEnmVlMyCONCMMdlItmCls number,
    constraint FMEnmVlMyCONCMMdlItm foreign key (MEnmVlMyCONCMMdlItmCls) references Cls (id)    
);
create index INmMEnmVl on MEnmVl (MEnmVlNm);
create index IThTpMEnmVl on MEnmVl (MEnmVlThTp, MEnmVlThTpCls);


create sequence SDvCMD nocache;

create table DvCMD(
    id number primary key,
    Cls number not null,
    DvCMDDvdnd number,
    DvCMDDvdndCls number,
    constraint FDvCMDDvdnd foreign key (DvCMDDvdndCls) references Cls (id),
    DvCMDDvsr number,
    DvCMDDvsrCls number,
    constraint FDvCMDDvsr foreign key (DvCMDDvsrCls) references Cls (id),
    DvCMDInvoker number,
    DvCMDInvokerCls number,
    constraint FDvCMDInvoker foreign key (DvCMDInvokerCls) references Cls (id),
    DvCMDCReceiver number,
    DvCMDCReceiverCls number,
    constraint FDvCMDCReceiver foreign key (DvCMDCReceiverCls) references Cls (id),
    DvCMDCResult number,
    DvCMDCResultCls number,
    constraint FDvCMDCResult foreign key (DvCMDCResultCls) references Cls (id),
    DvCMDMyCmmnDt number,
    DvCMDMyCmmnDtCls number,
    constraint FDvCMDMyCmmnDt foreign key (DvCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAbsUntTp nocache;

create table AbsUntTp(
    id number primary key,
    Cls number not null,
    AbsUntTpNm varchar2(2000),
    AbsUntTpThis number,
    AbsUntTpThisCls number,
    constraint FAbsUntTpThis foreign key (AbsUntTpThisCls) references Cls (id),
    UntTpDfltUnt number,
    UntTpDfltUntCls number,
    constraint FUntTpDfltUnt foreign key (UntTpDfltUntCls) references Cls (id)    
);
create index INmAbsUntTp on AbsUntTp (AbsUntTpNm);


create sequence SQnttMngr nocache;

create table QnttMngr(
    id number primary key,
    Cls number not null,
    QnttMngrThis number,
    QnttMngrThisCls number,
    constraint FQnttMngrThis foreign key (QnttMngrThisCls) references Cls (id)    
);

create sequence SNmSchmMngr nocache;

create table NmSchmMngr(
    id number primary key,
    Cls number not null,
    NmSchmMngrThis number,
    NmSchmMngrThisCls number,
    constraint FNmSchmMngrThis foreign key (NmSchmMngrThisCls) references Cls (id)    
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
    CrtSttcOpCMDCResult number,
    CrtSttcOpCMDCResultCls number,
    constraint FCrtSttcOpCMDCResult foreign key (CrtSttcOpCMDCResultCls) references Cls (id),
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
    CrtLnkCMDCResult number,
    CrtLnkCMDCResultCls number,
    constraint FCrtLnkCMDCResult foreign key (CrtLnkCMDCResultCls) references Cls (id),
    CrtLnkCMDMyCmmnDt number,
    CrtLnkCMDMyCmmnDtCls number,
    constraint FCrtLnkCMDMyCmmnDt foreign key (CrtLnkCMDMyCmmnDtCls) references Cls (id)    
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
    CrtVdOprtnCMDCResult number,
    CrtVdOprtnCMDCResultCls number,
    constraint FCrtVdOprtnCMDCResult foreign key (CrtVdOprtnCMDCResultCls) references Cls (id),
    CrtVdOprtnCMDMyCmmnDt number,
    CrtVdOprtnCMDMyCmmnDtCls number,
    constraint FCrtVdOprtnCMDMyCmmnDt foreign key (CrtVdOprtnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtObsTpCMD nocache;

create table CrtObsTpCMD(
    id number primary key,
    Cls number not null,
    CrtObsTpCMDNm varchar2(2000),
    CrtObsTpCMDEnmTp number,
    CrtObsTpCMDEnmTpCls number,
    constraint FCrtObsTpCMDEnmTp foreign key (CrtObsTpCMDEnmTpCls) references Cls (id),
    CrtObsTpCMDThTp number,
    CrtObsTpCMDThTpCls number,
    constraint FCrtObsTpCMDThTp foreign key (CrtObsTpCMDThTpCls) references Cls (id),
    CrtObsTpCMDInvoker number,
    CrtObsTpCMDInvokerCls number,
    constraint FCrtObsTpCMDInvoker foreign key (CrtObsTpCMDInvokerCls) references Cls (id),
    CrtObsTpCMDCReceiver number,
    CrtObsTpCMDCReceiverCls number,
    constraint FCrtObsTpCMDCReceiver foreign key (CrtObsTpCMDCReceiverCls) references Cls (id),
    CrtObsTpCMDMyCmmnDt number,
    CrtObsTpCMDMyCmmnDtCls number,
    constraint FCrtObsTpCMDMyCmmnDt foreign key (CrtObsTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SStDfltUntCMD nocache;

create table StDfltUntCMD(
    id number primary key,
    Cls number not null,
    StDfltUntCMDTp number,
    StDfltUntCMDTpCls number,
    constraint FStDfltUntCMDTp foreign key (StDfltUntCMDTpCls) references Cls (id),
    StDfltUntCMDUnt number,
    StDfltUntCMDUntCls number,
    constraint FStDfltUntCMDUnt foreign key (StDfltUntCMDUntCls) references Cls (id),
    StDfltUntCMDInvoker number,
    StDfltUntCMDInvokerCls number,
    constraint FStDfltUntCMDInvoker foreign key (StDfltUntCMDInvokerCls) references Cls (id),
    StDfltUntCMDCReceiver number,
    StDfltUntCMDCReceiverCls number,
    constraint FStDfltUntCMDCReceiver foreign key (StDfltUntCMDCReceiverCls) references Cls (id),
    StDfltUntCMDMyCmmnDt number,
    StDfltUntCMDMyCmmnDtCls number,
    constraint FStDfltUntCMDMyCmmnDt foreign key (StDfltUntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SChngAbstrctCMD nocache;

create table ChngAbstrctCMD(
    id number primary key,
    Cls number not null,
    ChngAbstrctCMDTp number,
    ChngAbstrctCMDTpCls number,
    constraint FChngAbstrctCMDTp foreign key (ChngAbstrctCMDTpCls) references Cls (id),
    ChngAbstrctCMDNwAbstrctTp number,
    ChngAbstrctCMDNwAbstrctTpCls number,
    constraint FChngAbstrctCMDNwAbstrctTp foreign key (ChngAbstrctCMDNwAbstrctTpCls) references Cls (id),
    ChngAbstrctCMDInvoker number,
    ChngAbstrctCMDInvokerCls number,
    constraint FChngAbstrctCMDInvoker foreign key (ChngAbstrctCMDInvokerCls) references Cls (id),
    ChngAbstrctCMDCReceiver number,
    ChngAbstrctCMDCReceiverCls number,
    constraint FChngAbstrctCMDCReceiver foreign key (ChngAbstrctCMDCReceiverCls) references Cls (id),
    ChngAbstrctCMDMyCmmnDt number,
    ChngAbstrctCMDMyCmmnDtCls number,
    constraint FChngAbstrctCMDMyCmmnDt foreign key (ChngAbstrctCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SAvgStrtg nocache;

create table AvgStrtg(
    id number primary key,
    Cls number not null,
    AvgStrtgThis number,
    AvgStrtgThisCls number,
    constraint FAvgStrtgThis foreign key (AvgStrtgThisCls) references Cls (id)    
);

create sequence SDltObsTpCMD nocache;

create table DltObsTpCMD(
    id number primary key,
    Cls number not null,
    DltObsTpCMDThTp number,
    DltObsTpCMDThTpCls number,
    constraint FDltObsTpCMDThTp foreign key (DltObsTpCMDThTpCls) references Cls (id),
    DltObsTpCMDInvoker number,
    DltObsTpCMDInvokerCls number,
    constraint FDltObsTpCMDInvoker foreign key (DltObsTpCMDInvokerCls) references Cls (id),
    DltObsTpCMDCReceiver number,
    DltObsTpCMDCReceiverCls number,
    constraint FDltObsTpCMDCReceiver foreign key (DltObsTpCMDCReceiverCls) references Cls (id),
    DltObsTpCMDMyCmmnDt number,
    DltObsTpCMDMyCmmnDtCls number,
    constraint FDltObsTpCMDMyCmmnDt foreign key (DltObsTpCMDMyCmmnDtCls) references Cls (id)    
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

create sequence SCrtEnmVlCMD nocache;

create table CrtEnmVlCMD(
    id number primary key,
    Cls number not null,
    CrtEnmVlCMDNm varchar2(2000),
    CrtEnmVlCMDTp number,
    CrtEnmVlCMDTpCls number,
    constraint FCrtEnmVlCMDTp foreign key (CrtEnmVlCMDTpCls) references Cls (id),
    CrtEnmVlCMDInvoker number,
    CrtEnmVlCMDInvokerCls number,
    constraint FCrtEnmVlCMDInvoker foreign key (CrtEnmVlCMDInvokerCls) references Cls (id),
    CrtEnmVlCMDCReceiver number,
    CrtEnmVlCMDCReceiverCls number,
    constraint FCrtEnmVlCMDCReceiver foreign key (CrtEnmVlCMDCReceiverCls) references Cls (id),
    CrtEnmVlCMDMyCmmnDt number,
    CrtEnmVlCMDMyCmmnDtCls number,
    constraint FCrtEnmVlCMDMyCmmnDt foreign key (CrtEnmVlCMDMyCmmnDtCls) references Cls (id)    
);

create sequence STpMngr nocache;

create table TpMngr(
    id number primary key,
    Cls number not null,
    TpMngrThis number,
    TpMngrThisCls number,
    constraint FTpMngrThis foreign key (TpMngrThisCls) references Cls (id)    
);

create sequence SSbCMD nocache;

create table SbCMD(
    id number primary key,
    Cls number not null,
    SbCMDMnnd number,
    SbCMDMnndCls number,
    constraint FSbCMDMnnd foreign key (SbCMDMnndCls) references Cls (id),
    SbCMDSbtrhnd number,
    SbCMDSbtrhndCls number,
    constraint FSbCMDSbtrhnd foreign key (SbCMDSbtrhndCls) references Cls (id),
    SbCMDInvoker number,
    SbCMDInvokerCls number,
    constraint FSbCMDInvoker foreign key (SbCMDInvokerCls) references Cls (id),
    SbCMDCReceiver number,
    SbCMDCReceiverCls number,
    constraint FSbCMDCReceiver foreign key (SbCMDCReceiverCls) references Cls (id),
    SbCMDCResult number,
    SbCMDCResultCls number,
    constraint FSbCMDCResult foreign key (SbCMDCResultCls) references Cls (id),
    SbCMDMyCmmnDt number,
    SbCMDMyCmmnDtCls number,
    constraint FSbCMDMyCmmnDt foreign key (SbCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMssgMngr nocache;

create table MssgMngr(
    id number primary key,
    Cls number not null,
    MssgMngrThis number,
    MssgMngrThisCls number,
    constraint FMssgMngrThis foreign key (MssgMngrThisCls) references Cls (id)    
);

create sequence SSmStrtg nocache;

create table SmStrtg(
    id number primary key,
    Cls number not null,
    SmStrtgThis number,
    SmStrtgThisCls number,
    constraint FSmStrtgThis foreign key (SmStrtgThisCls) references Cls (id)    
);

create sequence SMTp nocache;

create table MTp(
    id number primary key,
    Cls number not null,
    MTpThis number,
    MTpThisCls number,
    constraint FMTpThis foreign key (MTpThisCls) references Cls (id),
    MTpMyCONCMMdlItm number,
    MTpMyCONCMMdlItmCls number,
    constraint FMTpMyCONCMMdlItm foreign key (MTpMyCONCMMdlItmCls) references Cls (id),
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


create sequence SUntTpMngr nocache;

create table UntTpMngr(
    id number primary key,
    Cls number not null,
    UntTpMngrThis number,
    UntTpMngrThisCls number,
    constraint FUntTpMngrThis foreign key (UntTpMngrThisCls) references Cls (id)    
);

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
    constraint FAbsUntThis foreign key (AbsUntThisCls) references Cls (id)    
);
create index ITpAbsUnt on AbsUnt (AbsUntTp, AbsUntTpCls);
create index INmAbsUnt on AbsUnt (AbsUntNm);


create sequence SEnmrtnMngr nocache;

create table EnmrtnMngr(
    id number primary key,
    Cls number not null,
    EnmrtnMngrThis number,
    EnmrtnMngrThisCls number,
    constraint FEnmrtnMngrThis foreign key (EnmrtnMngrThisCls) references Cls (id)    
);

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

create sequence SRplcTpCMD nocache;

create table RplcTpCMD(
    id number primary key,
    Cls number not null,
    RplcTpCMDObjct number,
    RplcTpCMDObjctCls number,
    constraint FRplcTpCMDObjct foreign key (RplcTpCMDObjctCls) references Cls (id),
    RplcTpCMDOldTp number,
    RplcTpCMDOldTpCls number,
    constraint FRplcTpCMDOldTp foreign key (RplcTpCMDOldTpCls) references Cls (id),
    RplcTpCMDNwTp number,
    RplcTpCMDNwTpCls number,
    constraint FRplcTpCMDNwTp foreign key (RplcTpCMDNwTpCls) references Cls (id),
    RplcTpCMDInvoker number,
    RplcTpCMDInvokerCls number,
    constraint FRplcTpCMDInvoker foreign key (RplcTpCMDInvokerCls) references Cls (id),
    RplcTpCMDCReceiver number,
    RplcTpCMDCReceiverCls number,
    constraint FRplcTpCMDCReceiver foreign key (RplcTpCMDCReceiverCls) references Cls (id),
    RplcTpCMDMyCmmnDt number,
    RplcTpCMDMyCmmnDtCls number,
    constraint FRplcTpCMDMyCmmnDt foreign key (RplcTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SFtchSclrTpCMD nocache;

create table FtchSclrTpCMD(
    id number primary key,
    Cls number not null,
    FtchSclrTpCMDInvoker number,
    FtchSclrTpCMDInvokerCls number,
    constraint FFtchSclrTpCMDInvoker foreign key (FtchSclrTpCMDInvokerCls) references Cls (id),
    FtchSclrTpCMDCReceiver number,
    FtchSclrTpCMDCReceiverCls number,
    constraint FFtchSclrTpCMDCReceiver foreign key (FtchSclrTpCMDCReceiverCls) references Cls (id),
    FtchSclrTpCMDCResult number,
    FtchSclrTpCMDCResultCls number,
    constraint FFtchSclrTpCMDCResult foreign key (FtchSclrTpCMDCResultCls) references Cls (id),
    FtchSclrTpCMDMyCmmnDt number,
    FtchSclrTpCMDMyCmmnDtCls number,
    constraint FFtchSclrTpCMDMyCmmnDt foreign key (FtchSclrTpCMDMyCmmnDtCls) references Cls (id)    
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
    CrtOprtnCMDCResult number,
    CrtOprtnCMDCResultCls number,
    constraint FCrtOprtnCMDCResult foreign key (CrtOprtnCMDCResultCls) references Cls (id),
    CrtOprtnCMDMyCmmnDt number,
    CrtOprtnCMDMyCmmnDtCls number,
    constraint FCrtOprtnCMDMyCmmnDt foreign key (CrtOprtnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SChngUTNmCMD nocache;

create table ChngUTNmCMD(
    id number primary key,
    Cls number not null,
    ChngUTNmCMDUntTp number,
    ChngUTNmCMDUntTpCls number,
    constraint FChngUTNmCMDUntTp foreign key (ChngUTNmCMDUntTpCls) references Cls (id),
    ChngUTNmCMDNm varchar2(2000),
    ChngUTNmCMDInvoker number,
    ChngUTNmCMDInvokerCls number,
    constraint FChngUTNmCMDInvoker foreign key (ChngUTNmCMDInvokerCls) references Cls (id),
    ChngUTNmCMDCReceiver number,
    ChngUTNmCMDCReceiverCls number,
    constraint FChngUTNmCMDCReceiver foreign key (ChngUTNmCMDCReceiverCls) references Cls (id),
    ChngUTNmCMDMyCmmnDt number,
    ChngUTNmCMDMyCmmnDtCls number,
    constraint FChngUTNmCMDMyCmmnDt foreign key (ChngUTNmCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SFrctnMngr nocache;

create table FrctnMngr(
    id number primary key,
    Cls number not null,
    FrctnMngrThis number,
    FrctnMngrThisCls number,
    constraint FFrctnMngrThis foreign key (FrctnMngrThisCls) references Cls (id)    
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
    RfrncExpnnt number,
    RfrncRf number,
    RfrncRfCls number,
    constraint FRfrncRf foreign key (RfrncRfCls) references Cls (id),
    RfrncThis number,
    RfrncThisCls number,
    constraint FRfrncThis foreign key (RfrncThisCls) references Cls (id)    
);

create sequence SCrtObsrvtnCMD nocache;

create table CrtObsrvtnCMD(
    id number primary key,
    Cls number not null,
    CrtObsrvtnCMDNm varchar2(2000),
    CrtObsrvtnCMDThTp number,
    CrtObsrvtnCMDThTpCls number,
    constraint FCrtObsrvtnCMDThTp foreign key (CrtObsrvtnCMDThTpCls) references Cls (id),
    CrtObsrvtnCMDThObsObjct number,
    CrtObsrvtnCMDThObsObjctCls number,
    constraint FCrtObsrvtnCMDThObsObjct foreign key (CrtObsrvtnCMDThObsObjctCls) references Cls (id),
    CrtObsrvtnCMDEnmVl number,
    CrtObsrvtnCMDEnmVlCls number,
    constraint FCrtObsrvtnCMDEnmVl foreign key (CrtObsrvtnCMDEnmVlCls) references Cls (id),
    CrtObsrvtnCMDInvoker number,
    CrtObsrvtnCMDInvokerCls number,
    constraint FCrtObsrvtnCMDInvoker foreign key (CrtObsrvtnCMDInvokerCls) references Cls (id),
    CrtObsrvtnCMDCReceiver number,
    CrtObsrvtnCMDCReceiverCls number,
    constraint FCrtObsrvtnCMDCReceiver foreign key (CrtObsrvtnCMDCReceiverCls) references Cls (id),
    CrtObsrvtnCMDMyCmmnDt number,
    CrtObsrvtnCMDMyCmmnDtCls number,
    constraint FCrtObsrvtnCMDMyCmmnDt foreign key (CrtObsrvtnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SDltAspctCMD nocache;

create table DltAspctCMD(
    id number primary key,
    Cls number not null,
    DltAspctCMDAspct number,
    DltAspctCMDAspctCls number,
    constraint FDltAspctCMDAspct foreign key (DltAspctCMDAspctCls) references Cls (id),
    DltAspctCMDInvoker number,
    DltAspctCMDInvokerCls number,
    constraint FDltAspctCMDInvoker foreign key (DltAspctCMDInvokerCls) references Cls (id),
    DltAspctCMDCReceiver number,
    DltAspctCMDCReceiverCls number,
    constraint FDltAspctCMDCReceiver foreign key (DltAspctCMDCReceiverCls) references Cls (id),
    DltAspctCMDMyCmmnDt number,
    DltAspctCMDMyCmmnDtCls number,
    constraint FDltAspctCMDMyCmmnDt foreign key (DltAspctCMDMyCmmnDtCls) references Cls (id)    
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

create sequence SObsTpMngr nocache;

create table ObsTpMngr(
    id number primary key,
    Cls number not null,
    ObsTpMngrThis number,
    ObsTpMngrThisCls number,
    constraint FObsTpMngrThis foreign key (ObsTpMngrThisCls) references Cls (id)    
);

create sequence SMxStrtg nocache;

create table MxStrtg(
    id number primary key,
    Cls number not null,
    MxStrtgThis number,
    MxStrtgThisCls number,
    constraint FMxStrtgThis foreign key (MxStrtgThisCls) references Cls (id)    
);

create sequence SDltObsrvtnCMD nocache;

create table DltObsrvtnCMD(
    id number primary key,
    Cls number not null,
    DltObsrvtnCMDObsrvtn number,
    DltObsrvtnCMDObsrvtnCls number,
    constraint FDltObsrvtnCMDObsrvtn foreign key (DltObsrvtnCMDObsrvtnCls) references Cls (id),
    DltObsrvtnCMDInvoker number,
    DltObsrvtnCMDInvokerCls number,
    constraint FDltObsrvtnCMDInvoker foreign key (DltObsrvtnCMDInvokerCls) references Cls (id),
    DltObsrvtnCMDCReceiver number,
    DltObsrvtnCMDCReceiverCls number,
    constraint FDltObsrvtnCMDCReceiver foreign key (DltObsrvtnCMDCReceiverCls) references Cls (id),
    DltObsrvtnCMDMyCmmnDt number,
    DltObsrvtnCMDMyCmmnDtCls number,
    constraint FDltObsrvtnCMDMyCmmnDt foreign key (DltObsrvtnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMsrmntTpMng nocache;

create table MsrmntTpMng(
    id number primary key,
    Cls number not null,
    MsrmntTpMngThis number,
    MsrmntTpMngThisCls number,
    constraint FMsrmntTpMngThis foreign key (MsrmntTpMngThisCls) references Cls (id)    
);

create sequence SAddMltplFpCMD nocache;

create table AddMltplFpCMD(
    id number primary key,
    Cls number not null,
    AddMltplFpCMDOp number,
    AddMltplFpCMDOpCls number,
    constraint FAddMltplFpCMDOp foreign key (AddMltplFpCMDOpCls) references Cls (id),
    AddMltplFpCMDInvoker number,
    AddMltplFpCMDInvokerCls number,
    constraint FAddMltplFpCMDInvoker foreign key (AddMltplFpCMDInvokerCls) references Cls (id),
    AddMltplFpCMDCReceiver number,
    AddMltplFpCMDCReceiverCls number,
    constraint FAddMltplFpCMDCReceiver foreign key (AddMltplFpCMDCReceiverCls) references Cls (id),
    AddMltplFpCMDMyCmmnDt number,
    AddMltplFpCMDMyCmmnDtCls number,
    constraint FAddMltplFpCMDMyCmmnDt foreign key (AddMltplFpCMDMyCmmnDtCls) references Cls (id)    
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
    CrtAssctnCMDCResult number,
    CrtAssctnCMDCResultCls number,
    constraint FCrtAssctnCMDCResult foreign key (CrtAssctnCMDCResultCls) references Cls (id),
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
    MssgOrLnkMyCONCMMdlItm number,
    MssgOrLnkMyCONCMMdlItmCls number,
    constraint FMssgOrLnkMyCONCMMdlItm foreign key (MssgOrLnkMyCONCMMdlItmCls) references Cls (id),
    MssgTp number,
    MssgTpCls number,
    constraint FMssgTp foreign key (MssgTpCls) references Cls (id),
    LnkTp number,
    LnkTpCls number,
    constraint FLnkTp foreign key (LnkTpCls) references Cls (id)    
);
create index ISrcMssgOrLnk on MssgOrLnk (MssgOrLnkSrc, MssgOrLnkSrcCls);
create index ITrgtMssgOrLnk on MssgOrLnk (MssgOrLnkTrgt, MssgOrLnkTrgtCls);
create index ITpMssg on MssgOrLnk (MssgTp, MssgTpCls);
create index ITpLnk on MssgOrLnk (LnkTp, LnkTpCls);


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

create sequence SAddCMD nocache;

create table AddCMD(
    id number primary key,
    Cls number not null,
    AddCMDSmmnd1 number,
    AddCMDSmmnd1Cls number,
    constraint FAddCMDSmmnd1 foreign key (AddCMDSmmnd1Cls) references Cls (id),
    AddCMDSmmnd2 number,
    AddCMDSmmnd2Cls number,
    constraint FAddCMDSmmnd2 foreign key (AddCMDSmmnd2Cls) references Cls (id),
    AddCMDInvoker number,
    AddCMDInvokerCls number,
    constraint FAddCMDInvoker foreign key (AddCMDInvokerCls) references Cls (id),
    AddCMDCReceiver number,
    AddCMDCReceiverCls number,
    constraint FAddCMDCReceiver foreign key (AddCMDCReceiverCls) references Cls (id),
    AddCMDCResult number,
    AddCMDCResultCls number,
    constraint FAddCMDCResult foreign key (AddCMDCResultCls) references Cls (id),
    AddCMDMyCmmnDt number,
    AddCMDMyCmmnDtCls number,
    constraint FAddCMDMyCmmnDt foreign key (AddCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCnvrtCMD nocache;

create table CnvrtCMD(
    id number primary key,
    Cls number not null,
    CnvrtCMDQntt number,
    CnvrtCMDQnttCls number,
    constraint FCnvrtCMDQntt foreign key (CnvrtCMDQnttCls) references Cls (id),
    CnvrtCMDUnt number,
    CnvrtCMDUntCls number,
    constraint FCnvrtCMDUnt foreign key (CnvrtCMDUntCls) references Cls (id),
    CnvrtCMDInvoker number,
    CnvrtCMDInvokerCls number,
    constraint FCnvrtCMDInvoker foreign key (CnvrtCMDInvokerCls) references Cls (id),
    CnvrtCMDCReceiver number,
    CnvrtCMDCReceiverCls number,
    constraint FCnvrtCMDCReceiver foreign key (CnvrtCMDCReceiverCls) references Cls (id),
    CnvrtCMDMyCmmnDt number,
    CnvrtCMDMyCmmnDtCls number,
    constraint FCnvrtCMDMyCmmnDt foreign key (CnvrtCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null    
);

create sequence SDltEnmVlCMD nocache;

create table DltEnmVlCMD(
    id number primary key,
    Cls number not null,
    DltEnmVlCMDEnmVl number,
    DltEnmVlCMDEnmVlCls number,
    constraint FDltEnmVlCMDEnmVl foreign key (DltEnmVlCMDEnmVlCls) references Cls (id),
    DltEnmVlCMDInvoker number,
    DltEnmVlCMDInvokerCls number,
    constraint FDltEnmVlCMDInvoker foreign key (DltEnmVlCMDInvokerCls) references Cls (id),
    DltEnmVlCMDCReceiver number,
    DltEnmVlCMDCReceiverCls number,
    constraint FDltEnmVlCMDCReceiver foreign key (DltEnmVlCMDCReceiverCls) references Cls (id),
    DltEnmVlCMDMyCmmnDt number,
    DltEnmVlCMDMyCmmnDtCls number,
    constraint FDltEnmVlCMDMyCmmnDt foreign key (DltEnmVlCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAddRfrncTpCMD nocache;

create table AddRfrncTpCMD(
    id number primary key,
    Cls number not null,
    AddRfrncTpCMDNm varchar2(2000),
    AddRfrncTpCMDUntTp number,
    AddRfrncTpCMDUntTpCls number,
    constraint FAddRfrncTpCMDUntTp foreign key (AddRfrncTpCMDUntTpCls) references Cls (id),
    AddRfrncTpCMDRfrncUntTp number,
    AddRfrncTpCMDRfrncUntTpCls number,
    constraint FAddRfrncTpCMDRfrncUntTp foreign key (AddRfrncTpCMDRfrncUntTpCls) references Cls (id),
    AddRfrncTpCMDExpnnt number,
    AddRfrncTpCMDInvoker number,
    AddRfrncTpCMDInvokerCls number,
    constraint FAddRfrncTpCMDInvoker foreign key (AddRfrncTpCMDInvokerCls) references Cls (id),
    AddRfrncTpCMDCReceiver number,
    AddRfrncTpCMDCReceiverCls number,
    constraint FAddRfrncTpCMDCReceiver foreign key (AddRfrncTpCMDCReceiverCls) references Cls (id),
    AddRfrncTpCMDCResult number,
    AddRfrncTpCMDCResultCls number,
    constraint FAddRfrncTpCMDCResult foreign key (AddRfrncTpCMDCResultCls) references Cls (id),
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
create index ITpActlPrmtr on ActlPrmtr (ActlPrmtrTp, ActlPrmtrTpCls);


create sequence SAddSbAccntCMD nocache;

create table AddSbAccntCMD(
    id number primary key,
    Cls number not null,
    AddSbAccntCMDAccnt number,
    AddSbAccntCMDAccntCls number,
    constraint FAddSbAccntCMDAccnt foreign key (AddSbAccntCMDAccntCls) references Cls (id),
    AddSbAccntCMDInvoker number,
    AddSbAccntCMDInvokerCls number,
    constraint FAddSbAccntCMDInvoker foreign key (AddSbAccntCMDInvokerCls) references Cls (id),
    AddSbAccntCMDCReceiver number,
    AddSbAccntCMDCReceiverCls number,
    constraint FAddSbAccntCMDCReceiver foreign key (AddSbAccntCMDCReceiverCls) references Cls (id),
    AddSbAccntCMDMyCmmnDt number,
    AddSbAccntCMDMyCmmnDtCls number,
    constraint FAddSbAccntCMDMyCmmnDt foreign key (AddSbAccntCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SNm nocache;

create table Nm(
    id number primary key,
    Cls number not null,
    NmFrmTp number,
    NmFrmTpCls number,
    constraint FNmFrmTp foreign key (NmFrmTpCls) references Cls (id),
    NmNmSchm number,
    NmNmSchmCls number,
    constraint FNmNmSchm foreign key (NmNmSchmCls) references Cls (id),
    NmThis number,
    NmThisCls number,
    constraint FNmThis foreign key (NmThisCls) references Cls (id)    
);
create index IFrmTpNm on Nm (NmFrmTp, NmFrmTpCls);


create sequence SAddFrctnCMD nocache;

create table AddFrctnCMD(
    id number primary key,
    Cls number not null,
    AddFrctnCMDKey varchar2(2000),
    AddFrctnCMDNwFrctn varchar2(2000),
    AddFrctnCMDInvoker number,
    AddFrctnCMDInvokerCls number,
    constraint FAddFrctnCMDInvoker foreign key (AddFrctnCMDInvokerCls) references Cls (id),
    AddFrctnCMDCReceiver number,
    AddFrctnCMDCReceiverCls number,
    constraint FAddFrctnCMDCReceiver foreign key (AddFrctnCMDCReceiverCls) references Cls (id),
    AddFrctnCMDMyCmmnDt number,
    AddFrctnCMDMyCmmnDtCls number,
    constraint FAddFrctnCMDMyCmmnDt foreign key (AddFrctnCMDMyCmmnDtCls) references Cls (id)    
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

create sequence SFrctnWrppr nocache;

create table FrctnWrppr(
    id number primary key,
    Cls number not null,
    FrctnWrpprFrctn varchar2(2000),
    FrctnWrpprThis number,
    FrctnWrpprThisCls number,
    constraint FFrctnWrpprThis foreign key (FrctnWrpprThisCls) references Cls (id)    
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

create sequence SFnctnMngr nocache;

create table FnctnMngr(
    id number primary key,
    Cls number not null,
    FnctnMngrThis number,
    FnctnMngrThisCls number,
    constraint FFnctnMngrThis foreign key (FnctnMngrThisCls) references Cls (id)    
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
    CrtFpCMDCResult number,
    CrtFpCMDCResultCls number,
    constraint FCrtFpCMDCResult foreign key (CrtFpCMDCResultCls) references Cls (id),
    CrtFpCMDMyCmmnDt number,
    CrtFpCMDMyCmmnDtCls number,
    constraint FCrtFpCMDMyCmmnDt foreign key (CrtFpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCrtMObjctCMDOthrTps nocache;

create table CrtMObjctCMDOthrTps(
    id number primary key,
    frm number not null,
    othrTps number not null,
    Cls number not null,
    constraint FCrtMObjctCMDOthrTpsCls foreign key(Cls) references Cls(id),
    constraint FCrtMObjctCMDOthrTpsfrm foreign key(frm) references CrtMObjctCMD(id)
);
create index IFrmCrtMObjctCMDOthrTps on CrtMObjctCMDOthrTps(frm);

create sequence SFtchCUCMDRfs nocache;

create table FtchCUCMDRfs(
    id number primary key,
    frm number not null,
    rfs number not null,
    Cls number not null,
    constraint FFtchCUCMDRfsCls foreign key(Cls) references Cls(id),
    constraint FFtchCUCMDRfsfrm foreign key(frm) references FtchCUCMD(id)
);
create index IFrmFtchCUCMDRfs on FtchCUCMDRfs(frm);

create sequence SCrTpDisjCMDAddnds nocache;

create table CrTpDisjCMDAddnds(
    id number primary key,
    frm number not null,
    addnds number not null,
    Cls number not null,
    constraint FCrTpDisjCMDAddndsCls foreign key(Cls) references Cls(id),
    constraint FCrTpDisjCMDAddndsfrm foreign key(frm) references CrTpDisjCMD(id)
);
create index IFrmCrTpDisjCMDAddnds on CrTpDisjCMDAddnds(frm);

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

create sequence SCrTpConjCMDFctrs nocache;

create table CrTpConjCMDFctrs(
    id number primary key,
    frm number not null,
    fctrs number not null,
    Cls number not null,
    constraint FCrTpConjCMDFctrsCls foreign key(Cls) references Cls(id),
    constraint FCrTpConjCMDFctrsfrm foreign key(frm) references CrTpConjCMD(id)
);
create index IFrmCrTpConjCMDFctrs on CrTpConjCMDFctrs(frm);

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


create index IRfsCmpUntTpRfs on CmpUntTpRfs(rfs);
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

create sequence SMMxdCnjnctnFctrs nocache;

create table MMxdCnjnctnFctrs(
    id number primary key,
    frm number not null,
    fctrs number not null,
    Cls number not null,
    constraint FMMxdCnjnctnFctrsCls foreign key(Cls) references Cls(id),
    constraint FMMxdCnjnctnFctrsfrm foreign key(frm) references MTp(id)
);
create index IFrmMMxdCnjnctnFctrs on MMxdCnjnctnFctrs(frm);


create index IFctrsMMxdCnjnctnFctrs on MMxdCnjnctnFctrs(fctrs);
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

create sequence SMObjctTps nocache;

create table MObjctTps(
    id number primary key,
    frm number not null,
    tps number not null,
    Cls number not null,
    constraint FMObjctTpsCls foreign key(Cls) references Cls(id),
    constraint FMObjctTpsfrm foreign key(frm) references AbsObj(id)
);
create index IFrmMObjctTps on MObjctTps(frm);


create index ITpsMObjctTps on MObjctTps(tps);
create sequence SGtExstngCUTCMDRfTps nocache;

create table GtExstngCUTCMDRfTps(
    id number primary key,
    frm number not null,
    rfTps number not null,
    Cls number not null,
    constraint FGtExstngCUTCMDRfTpsCls foreign key(Cls) references Cls(id),
    constraint FGtExstngCUTCMDRfTpsfrm foreign key(frm) references GtExstngCUTCMD(id)
);
create index IFrmGtExstngCUTCMDRfTps on GtExstngCUTCMDRfTps(frm);

create sequence SEnmVlMngrEnmVls nocache;

create table EnmVlMngrEnmVls(
    id number primary key,
    frm number not null,
    enmVls number not null,
    Cls number not null,
    constraint FEnmVlMngrEnmVlsCls foreign key(Cls) references Cls(id),
    constraint FEnmVlMngrEnmVlsfrm foreign key(frm) references EnmVlMngr(id)
);
create index IFrmEnmVlMngrEnmVls on EnmVlMngrEnmVls(frm);

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

create sequence SGtExstngCUCMDRfs nocache;

create table GtExstngCUCMDRfs(
    id number primary key,
    frm number not null,
    rfs number not null,
    Cls number not null,
    constraint FGtExstngCUCMDRfsCls foreign key(Cls) references Cls(id),
    constraint FGtExstngCUCMDRfsfrm foreign key(frm) references GtExstngCUCMD(id)
);
create index IFrmGtExstngCUCMDRfs on GtExstngCUCMDRfs(frm);

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


create index IRfsCmpUntRfs on CmpUntRfs(rfs);
create sequence SObsrvtnMngrObsrvtns nocache;

create table ObsrvtnMngrObsrvtns(
    id number primary key,
    frm number not null,
    obsrvtns number not null,
    Cls number not null,
    constraint FObsrvtnMngrObsrvtnsCls foreign key(Cls) references Cls(id),
    constraint FObsrvtnMngrObsrvtnsfrm foreign key(frm) references ObsrvtnMngr(id)
);
create index IFrmObsrvtnMngrObsrvtns on ObsrvtnMngrObsrvtns(frm);

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

create sequence SNmSchmMngrSchms nocache;

create table NmSchmMngrSchms(
    id number primary key,
    frm number not null,
    schms number not null,
    Cls number not null,
    constraint FNmSchmMngrSchmsCls foreign key(Cls) references Cls(id),
    constraint FNmSchmMngrSchmsfrm foreign key(frm) references NmSchmMngr(id)
);
create index IFrmNmSchmMngrSchms on NmSchmMngrSchms(frm);

create sequence SNmSchmMngrNms nocache;

create table NmSchmMngrNms(
    id number primary key,
    frm number not null,
    nms number not null,
    Cls number not null,
    constraint FNmSchmMngrNmsCls foreign key(Cls) references Cls(id),
    constraint FNmSchmMngrNmsfrm foreign key(frm) references NmSchmMngr(id)
);
create index IFrmNmSchmMngrNms on NmSchmMngrNms(frm);

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


create index ISbAccntTpsMAccntTpSbAccntTps on MAccntTpSbAccntTps(sbAccntTps);
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

create sequence SMxdTpDisjAddnds nocache;

create table MxdTpDisjAddnds(
    id number primary key,
    frm number not null,
    addnds number not null,
    Cls number not null,
    constraint FMxdTpDisjAddndsCls foreign key(Cls) references Cls(id),
    constraint FMxdTpDisjAddndsfrm foreign key(frm) references MTp(id)
);
create index IFrmMxdTpDisjAddnds on MxdTpDisjAddnds(frm);


create index IAddndsMxdTpDisjAddnds on MxdTpDisjAddnds(addnds);
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

create sequence SNEATConjFctrs nocache;

create table NEATConjFctrs(
    id number primary key,
    frm number not null,
    fctrs number not null,
    Cls number not null,
    constraint FNEATConjFctrsCls foreign key(Cls) references Cls(id),
    constraint FNEATConjFctrsfrm foreign key(frm) references MTp(id)
);
create index IFrmNEATConjFctrs on NEATConjFctrs(frm);


create index IFctrsNEATConjFctrs on NEATConjFctrs(fctrs);
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

create sequence SUntTpMngrRfTps nocache;

create table UntTpMngrRfTps(
    id number primary key,
    frm number not null,
    rfTps number not null,
    Cls number not null,
    constraint FUntTpMngrRfTpsCls foreign key(Cls) references Cls(id),
    constraint FUntTpMngrRfTpsfrm foreign key(frm) references UntTpMngr(id)
);
create index IFrmUntTpMngrRfTps on UntTpMngrRfTps(frm);

create sequence SUntTpMngrRfs nocache;

create table UntTpMngrRfs(
    id number primary key,
    frm number not null,
    rfs number not null,
    Cls number not null,
    constraint FUntTpMngrRfsCls foreign key(Cls) references Cls(id),
    constraint FUntTpMngrRfsfrm foreign key(frm) references UntTpMngr(id)
);
create index IFrmUntTpMngrRfs on UntTpMngrRfs(frm);

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

create sequence SEnmrtnMngrEnmTps nocache;

create table EnmrtnMngrEnmTps(
    id number primary key,
    frm number not null,
    enmTps number not null,
    Cls number not null,
    constraint FEnmrtnMngrEnmTpsCls foreign key(Cls) references Cls(id),
    constraint FEnmrtnMngrEnmTpsfrm foreign key(frm) references EnmrtnMngr(id)
);
create index IFrmEnmrtnMngrEnmTps on EnmrtnMngrEnmTps(frm);

create sequence SNEDisjNFAddnds nocache;

create table NEDisjNFAddnds(
    id number primary key,
    frm number not null,
    addnds number not null,
    Cls number not null,
    constraint FNEDisjNFAddndsCls foreign key(Cls) references Cls(id),
    constraint FNEDisjNFAddndsfrm foreign key(frm) references MTp(id)
);
create index IFrmNEDisjNFAddnds on NEDisjNFAddnds(frm);


create index IAddndsNEDisjNFAddnds on NEDisjNFAddnds(addnds);
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

create sequence SFrctnMngrMngdFrctns nocache;

create table FrctnMngrMngdFrctns(
    id number primary key,
    frm number not null,
    FrctnMngrMngdFrctnsindxx varchar2(2000) not null,
    mngdFrctns number not null,
    Cls number not null,
    constraint FFrctnMngrMngdFrctnsCls foreign key(Cls) references Cls(id),
    constraint FFrctnMngrMngdFrctnsfrm foreign key(frm) references FrctnMngr(id)
);
create index IFrmFrctnMngrMngdFrctns on FrctnMngrMngdFrctns(frm);
create index IIndxxFrctnMngrMngdFrctns on FrctnMngrMngdFrctns(FrctnMngrMngdFrctnsindxx);

create sequence SObsTpMngrObsrvtnTps nocache;

create table ObsTpMngrObsrvtnTps(
    id number primary key,
    frm number not null,
    obsrvtnTps number not null,
    Cls number not null,
    constraint FObsTpMngrObsrvtnTpsCls foreign key(Cls) references Cls(id),
    constraint FObsTpMngrObsrvtnTpsfrm foreign key(frm) references ObsTpMngr(id)
);
create index IFrmObsTpMngrObsrvtnTps on ObsTpMngrObsrvtnTps(frm);

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


create index ISbAccntsAccntSbAccnts on AccntSbAccnts(sbAccnts);
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

create sequence SAddMltplFpCMDFp nocache;

create table AddMltplFpCMDFp(
    id number primary key,
    frm number not null,
    fp number not null,
    Cls number not null,
    constraint FAddMltplFpCMDFpCls foreign key(Cls) references Cls(id),
    constraint FAddMltplFpCMDFpfrm foreign key(frm) references AddMltplFpCMD(id)
);
create index IFrmAddMltplFpCMDFp on AddMltplFpCMDFp(frm);

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

create sequence SFnctnMngrFnctns nocache;

create table FnctnMngrFnctns(
    id number primary key,
    frm number not null,
    fnctns number not null,
    Cls number not null,
    constraint FFnctnMngrFnctnsCls foreign key(Cls) references Cls(id),
    constraint FFnctnMngrFnctnsfrm foreign key(frm) references FnctnMngr(id)
);
create index IFrmFnctnMngrFnctns on FnctnMngrFnctns(frm);

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

