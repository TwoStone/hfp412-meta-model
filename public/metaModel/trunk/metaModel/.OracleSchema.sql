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

create sequence STpMngr nocache;

create table TpMngr(
    id number primary key,
    Cls number not null,
    TpMngrThis number,
    TpMngrThisCls number,
    constraint FTpMngrThis foreign key (TpMngrThisCls) references Cls (id)    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null    
);

create sequence SAddAspctCMD nocache;

create table AddAspctCMD(
    id number primary key,
    Cls number not null,
    AddAspctCMDNm varchar2(2000),
    AddAspctCMDInvoker number,
    AddAspctCMDInvokerCls number,
    constraint FAddAspctCMDInvoker foreign key (AddAspctCMDInvokerCls) references Cls (id),
    AddAspctCMDCReceiver number,
    AddAspctCMDCReceiverCls number,
    constraint FAddAspctCMDCReceiver foreign key (AddAspctCMDCReceiverCls) references Cls (id),
    AddAspctCMDMyCmmnDt number,
    AddAspctCMDMyCmmnDtCls number,
    constraint FAddAspctCMDMyCmmnDt foreign key (AddAspctCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAspctMngr nocache;

create table AspctMngr(
    id number primary key,
    Cls number not null,
    AspctMngrThis number,
    AspctMngrThisCls number,
    constraint FAspctMngrThis foreign key (AspctMngrThisCls) references Cls (id)    
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


create sequence SMCmplxTp nocache;

create table MCmplxTp(
    id number primary key,
    Cls number not null,
    MCmplxTpThis number,
    MCmplxTpThisCls number,
    constraint FMCmplxTpThis foreign key (MCmplxTpThisCls) references Cls (id)    
);

create sequence SMAtmcTp nocache;

create table MAtmcTp(
    id number primary key,
    Cls number not null,
    MAtmcTpNm varchar2(2000),
    MAtmcTpAspct number,
    MAtmcTpAspctCls number,
    constraint FMAtmcTpAspct foreign key (MAtmcTpAspctCls) references Cls (id),
    MAtmcTpThis number,
    MAtmcTpThisCls number,
    constraint FMAtmcTpThis foreign key (MAtmcTpThisCls) references Cls (id)    
);
create index INmMAtmcTp on MAtmcTp (MAtmcTpNm);
create index IAspctMAtmcTp on MAtmcTp (MAtmcTpAspct, MAtmcTpAspctCls);


create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null    
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


create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SAddAtmcTpCMD nocache;

create table AddAtmcTpCMD(
    id number primary key,
    Cls number not null,
    AddAtmcTpCMDAspct number,
    AddAtmcTpCMDAspctCls number,
    constraint FAddAtmcTpCMDAspct foreign key (AddAtmcTpCMDAspctCls) references Cls (id),
    AddAtmcTpCMDNm varchar2(2000),
    AddAtmcTpCMDInvoker number,
    AddAtmcTpCMDInvokerCls number,
    constraint FAddAtmcTpCMDInvoker foreign key (AddAtmcTpCMDInvokerCls) references Cls (id),
    AddAtmcTpCMDCReceiver number,
    AddAtmcTpCMDCReceiverCls number,
    constraint FAddAtmcTpCMDCReceiver foreign key (AddAtmcTpCMDCReceiverCls) references Cls (id),
    AddAtmcTpCMDMyCmmnDt number,
    AddAtmcTpCMDMyCmmnDtCls number,
    constraint FAddAtmcTpCMDMyCmmnDt foreign key (AddAtmcTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence STpMngrAtmcTps nocache;

create table TpMngrAtmcTps(
    id number primary key,
    frm number not null,
    atmcTps number not null,
    Cls number not null,
    constraint FTpMngrAtmcTpsCls foreign key(Cls) references Cls(id),
    constraint FTpMngrAtmcTpsfrm foreign key(frm) references TpMngr(id)
);
create index IFrmTpMngrAtmcTps on TpMngrAtmcTps(frm);

create sequence STpMngrPrdctTps nocache;

create table TpMngrPrdctTps(
    id number primary key,
    frm number not null,
    prdctTps number not null,
    Cls number not null,
    constraint FTpMngrPrdctTpsCls foreign key(Cls) references Cls(id),
    constraint FTpMngrPrdctTpsfrm foreign key(frm) references TpMngr(id)
);
create index IFrmTpMngrPrdctTps on TpMngrPrdctTps(frm);

create sequence STpMngrSmTps nocache;

create table TpMngrSmTps(
    id number primary key,
    frm number not null,
    smTps number not null,
    Cls number not null,
    constraint FTpMngrSmTpsCls foreign key(Cls) references Cls(id),
    constraint FTpMngrSmTpsfrm foreign key(frm) references TpMngr(id)
);
create index IFrmTpMngrSmTps on TpMngrSmTps(frm);

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

create sequence SMCmplxTpCntndTps nocache;

create table MCmplxTpCntndTps(
    id number primary key,
    frm number not null,
    cntndTps number not null,
    Cls number not null,
    constraint FMCmplxTpCntndTpsCls foreign key(Cls) references Cls(id),
    constraint FMCmplxTpCntndTpsfrm foreign key(frm) references MCmplxTp(id)
);
create index IFrmMCmplxTpCntndTps on MCmplxTpCntndTps(frm);

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

