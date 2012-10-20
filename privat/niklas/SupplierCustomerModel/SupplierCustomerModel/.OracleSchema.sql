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

create sequence SActrMngr nocache;

create table ActrMngr(
    id number primary key,
    Cls number not null,
    ActrMngrThis number,
    ActrMngrThisCls number,
    constraint FActrMngrThis foreign key (ActrMngrThisCls) references Cls (id)    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null    
);

create sequence SCrtPrdctCMD nocache;

create table CrtPrdctCMD(
    id number primary key,
    Cls number not null,
    CrtPrdctCMDMnfctrr number,
    CrtPrdctCMDMnfctrrCls number,
    constraint FCrtPrdctCMDMnfctrr foreign key (CrtPrdctCMDMnfctrrCls) references Cls (id),
    CrtPrdctCMDNm varchar2(2000),
    CrtPrdctCMDInvoker number,
    CrtPrdctCMDInvokerCls number,
    constraint FCrtPrdctCMDInvoker foreign key (CrtPrdctCMDInvokerCls) references Cls (id),
    CrtPrdctCMDCReceiver number,
    CrtPrdctCMDCReceiverCls number,
    constraint FCrtPrdctCMDCReceiver foreign key (CrtPrdctCMDCReceiverCls) references Cls (id),
    CrtPrdctCMDMyCmmnDt number,
    CrtPrdctCMDMyCmmnDtCls number,
    constraint FCrtPrdctCMDMyCmmnDt foreign key (CrtPrdctCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAddRlCMD nocache;

create table AddRlCMD(
    id number primary key,
    Cls number not null,
    AddRlCMDActr number,
    AddRlCMDActrCls number,
    constraint FAddRlCMDActr foreign key (AddRlCMDActrCls) references Cls (id),
    AddRlCMDRlNm varchar2(2000),
    AddRlCMDInvoker number,
    AddRlCMDInvokerCls number,
    constraint FAddRlCMDInvoker foreign key (AddRlCMDInvokerCls) references Cls (id),
    AddRlCMDCReceiver number,
    AddRlCMDCReceiverCls number,
    constraint FAddRlCMDCReceiver foreign key (AddRlCMDCReceiverCls) references Cls (id),
    AddRlCMDMyCmmnDt number,
    AddRlCMDMyCmmnDtCls number,
    constraint FAddRlCMDMyCmmnDt foreign key (AddRlCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SPrdct nocache;

create table Prdct(
    id number primary key,
    Cls number not null,
    PrdctNm varchar2(2000),
    PrdctPrdcr number,
    PrdctPrdcrCls number,
    constraint FPrdctPrdcr foreign key (PrdctPrdcrCls) references Cls (id),
    PrdctThis number,
    PrdctThisCls number,
    constraint FPrdctThis foreign key (PrdctThisCls) references Cls (id)    
);
create index IPrdcrPrdct on Prdct (PrdctPrdcr, PrdctPrdcrCls);


create sequence SOrdr nocache;

create table Ordr(
    id number primary key,
    Cls number not null,
    OrdrCstmr number,
    OrdrCstmrCls number,
    constraint FOrdrCstmr foreign key (OrdrCstmrCls) references Cls (id),
    OrdrSpplr number,
    OrdrSpplrCls number,
    constraint FOrdrSpplr foreign key (OrdrSpplrCls) references Cls (id),
    OrdrThis number,
    OrdrThisCls number,
    constraint FOrdrThis foreign key (OrdrThisCls) references Cls (id)    
);
create index ICstmrOrdr on Ordr (OrdrCstmr, OrdrCstmrCls);


create sequence SCrtActrCMD nocache;

create table CrtActrCMD(
    id number primary key,
    Cls number not null,
    CrtActrCMDNm varchar2(2000),
    CrtActrCMDInvoker number,
    CrtActrCMDInvokerCls number,
    constraint FCrtActrCMDInvoker foreign key (CrtActrCMDInvokerCls) references Cls (id),
    CrtActrCMDCReceiver number,
    CrtActrCMDCReceiverCls number,
    constraint FCrtActrCMDCReceiver foreign key (CrtActrCMDCReceiverCls) references Cls (id),
    CrtActrCMDMyCmmnDt number,
    CrtActrCMDMyCmmnDtCls number,
    constraint FCrtActrCMDMyCmmnDt foreign key (CrtActrCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SChngNmCMD nocache;

create table ChngNmCMD(
    id number primary key,
    Cls number not null,
    ChngNmCMDActr number,
    ChngNmCMDActrCls number,
    constraint FChngNmCMDActr foreign key (ChngNmCMDActrCls) references Cls (id),
    ChngNmCMDNm varchar2(2000),
    ChngNmCMDInvoker number,
    ChngNmCMDInvokerCls number,
    constraint FChngNmCMDInvoker foreign key (ChngNmCMDInvokerCls) references Cls (id),
    ChngNmCMDCReceiver number,
    ChngNmCMDCReceiverCls number,
    constraint FChngNmCMDCReceiver foreign key (ChngNmCMDCReceiverCls) references Cls (id),
    ChngNmCMDMyCmmnDt number,
    ChngNmCMDMyCmmnDtCls number,
    constraint FChngNmCMDMyCmmnDt foreign key (ChngNmCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAddPstnCMD nocache;

create table AddPstnCMD(
    id number primary key,
    Cls number not null,
    AddPstnCMDOrdr number,
    AddPstnCMDOrdrCls number,
    constraint FAddPstnCMDOrdr foreign key (AddPstnCMDOrdrCls) references Cls (id),
    AddPstnCMDPrdct number,
    AddPstnCMDPrdctCls number,
    constraint FAddPstnCMDPrdct foreign key (AddPstnCMDPrdctCls) references Cls (id),
    AddPstnCMDQntt number,
    AddPstnCMDInvoker number,
    AddPstnCMDInvokerCls number,
    constraint FAddPstnCMDInvoker foreign key (AddPstnCMDInvokerCls) references Cls (id),
    AddPstnCMDCReceiver number,
    AddPstnCMDCReceiverCls number,
    constraint FAddPstnCMDCReceiver foreign key (AddPstnCMDCReceiverCls) references Cls (id),
    AddPstnCMDMyCmmnDt number,
    AddPstnCMDMyCmmnDtCls number,
    constraint FAddPstnCMDMyCmmnDt foreign key (AddPstnCMDMyCmmnDtCls) references Cls (id)    
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


create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null    
);

create sequence SActr nocache;

create table Actr(
    id number primary key,
    Cls number not null,
    ActrNm varchar2(2000),
    ActrThis number,
    ActrThisCls number,
    constraint FActrThis foreign key (ActrThisCls) references Cls (id)    
);
create index INmActr on Actr (ActrNm);


create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SRl nocache;

create table Rl(
    id number primary key,
    Cls number not null,
    RlThis number,
    RlThisCls number,
    constraint FRlThis foreign key (RlThisCls) references Cls (id)    
);

create sequence SPstn nocache;

create table Pstn(
    id number primary key,
    Cls number not null,
    PstnPrdct number,
    PstnPrdctCls number,
    constraint FPstnPrdct foreign key (PstnPrdctCls) references Cls (id),
    PstnQntt number,
    PstnThis number,
    PstnThisCls number,
    constraint FPstnThis foreign key (PstnThisCls) references Cls (id)    
);

create sequence SCrtOrdrCMD nocache;

create table CrtOrdrCMD(
    id number primary key,
    Cls number not null,
    CrtOrdrCMDCstmr number,
    CrtOrdrCMDCstmrCls number,
    constraint FCrtOrdrCMDCstmr foreign key (CrtOrdrCMDCstmrCls) references Cls (id),
    CrtOrdrCMDSpplr number,
    CrtOrdrCMDSpplrCls number,
    constraint FCrtOrdrCMDSpplr foreign key (CrtOrdrCMDSpplrCls) references Cls (id),
    CrtOrdrCMDInvoker number,
    CrtOrdrCMDInvokerCls number,
    constraint FCrtOrdrCMDInvoker foreign key (CrtOrdrCMDInvokerCls) references Cls (id),
    CrtOrdrCMDCReceiver number,
    CrtOrdrCMDCReceiverCls number,
    constraint FCrtOrdrCMDCReceiver foreign key (CrtOrdrCMDCReceiverCls) references Cls (id),
    CrtOrdrCMDMyCmmnDt number,
    CrtOrdrCMDMyCmmnDtCls number,
    constraint FCrtOrdrCMDMyCmmnDt foreign key (CrtOrdrCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SActrMngrActrs nocache;

create table ActrMngrActrs(
    id number primary key,
    frm number not null,
    actrs number not null,
    Cls number not null,
    constraint FActrMngrActrsCls foreign key(Cls) references Cls(id),
    constraint FActrMngrActrsfrm foreign key(frm) references ActrMngr(id)
);
create index IFrmActrMngrActrs on ActrMngrActrs(frm);

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

create sequence SOrdrPstns nocache;

create table OrdrPstns(
    id number primary key,
    frm number not null,
    pstns number not null,
    Cls number not null,
    constraint FOrdrPstnsCls foreign key(Cls) references Cls(id),
    constraint FOrdrPstnsfrm foreign key(frm) references Ordr(id)
);
create index IFrmOrdrPstns on OrdrPstns(frm);

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

create sequence SActrRls nocache;

create table ActrRls(
    id number primary key,
    frm number not null,
    rls number not null,
    Cls number not null,
    constraint FActrRlsCls foreign key(Cls) references Cls(id),
    constraint FActrRlsfrm foreign key(frm) references Actr(id)
);
create index IFrmActrRls on ActrRls(frm);


create index IRlsActrRls on ActrRls(rls);
