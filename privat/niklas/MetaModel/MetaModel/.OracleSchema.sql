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


create sequence SNmdEntt nocache;

create table NmdEntt(
    id number primary key,
    Cls number not null,
    NmdEnttNm varchar2(2000),
    NmdEnttThis number,
    NmdEnttThisCls number,
    constraint FNmdEnttThis foreign key (NmdEnttThisCls) references Cls (id),
    MtAssctnFrmTp number,
    MtAssctnFrmTpCls number,
    constraint FMtAssctnFrmTp foreign key (MtAssctnFrmTpCls) references Cls (id),
    MtAssctnTTp number,
    MtAssctnTTpCls number,
    constraint FMtAssctnTTp foreign key (MtAssctnTTpCls) references Cls (id)    
);
create index INmNmdEntt on NmdEntt (NmdEnttNm);


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
    CrtAspctCMDMyCmmnDt number,
    CrtAspctCMDMyCmmnDtCls number,
    constraint FCrtAspctCMDMyCmmnDt foreign key (CrtAspctCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null    
);

create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SAbstrctMtTp nocache;

create table AbstrctMtTp(
    id number primary key,
    Cls number not null,
    AbstrctMtTpThis number,
    AbstrctMtTpThisCls number,
    constraint FAbstrctMtTpThis foreign key (AbstrctMtTpThisCls) references Cls (id),
    MtTpMAspct number,
    MtTpMAspctCls number,
    constraint FMtTpMAspct foreign key (MtTpMAspctCls) references Cls (id),
    MtTpMyCONCNmdEntt number,
    MtTpMyCONCNmdEnttCls number,
    constraint FMtTpMyCONCNmdEntt foreign key (MtTpMyCONCNmdEnttCls) references Cls (id)    
);
create index IMAspctMtTp on AbstrctMtTp (MtTpMAspct, MtTpMAspctCls);


create sequence SCrtTpCMD nocache;

create table CrtTpCMD(
    id number primary key,
    Cls number not null,
    CrtTpCMDNm varchar2(2000),
    CrtTpCMDAspct number,
    CrtTpCMDAspctCls number,
    constraint FCrtTpCMDAspct foreign key (CrtTpCMDAspctCls) references Cls (id),
    CrtTpCMDInvoker number,
    CrtTpCMDInvokerCls number,
    constraint FCrtTpCMDInvoker foreign key (CrtTpCMDInvokerCls) references Cls (id),
    CrtTpCMDCReceiver number,
    CrtTpCMDCReceiverCls number,
    constraint FCrtTpCMDCReceiver foreign key (CrtTpCMDCReceiverCls) references Cls (id),
    CrtTpCMDMyCmmnDt number,
    CrtTpCMDMyCmmnDtCls number,
    constraint FCrtTpCMDMyCmmnDt foreign key (CrtTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence STpMngrAllTps nocache;

create table TpMngrAllTps(
    id number primary key,
    frm number not null,
    allTps number not null,
    Cls number not null,
    constraint FTpMngrAllTpsCls foreign key(Cls) references Cls(id),
    constraint FTpMngrAllTpsfrm foreign key(frm) references TpMngr(id)
);
create index IFrmTpMngrAllTps on TpMngrAllTps(frm);

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

create sequence SMtAssctnHrrchs nocache;

create table MtAssctnHrrchs(
    id number primary key,
    frm number not null,
    hrrchs number not null,
    Cls number not null,
    constraint FMtAssctnHrrchsCls foreign key(Cls) references Cls(id),
    constraint FMtAssctnHrrchsfrm foreign key(frm) references NmdEntt(id)
);
create index IFrmMtAssctnHrrchs on MtAssctnHrrchs(frm);


create index IHrrchsMtAssctnHrrchs on MtAssctnHrrchs(hrrchs);
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

create sequence SCmpsdMtTpCmpnnts nocache;

create table CmpsdMtTpCmpnnts(
    id number primary key,
    frm number not null,
    cmpnnts number not null,
    Cls number not null,
    constraint FCmpsdMtTpCmpnntsCls foreign key(Cls) references Cls(id),
    constraint FCmpsdMtTpCmpnntsfrm foreign key(frm) references AbstrctMtTp(id)
);
create index IFrmCmpsdMtTpCmpnnts on CmpsdMtTpCmpnnts(frm);

create sequence SMtTpSbtps nocache;

create table MtTpSbtps(
    id number primary key,
    frm number not null,
    sbtps number not null,
    Cls number not null,
    constraint FMtTpSbtpsCls foreign key(Cls) references Cls(id),
    constraint FMtTpSbtpsfrm foreign key(frm) references AbstrctMtTp(id)
);
create index IFrmMtTpSbtps on MtTpSbtps(frm);


create index ISbtpsMtTpSbtps on MtTpSbtps(sbtps);
