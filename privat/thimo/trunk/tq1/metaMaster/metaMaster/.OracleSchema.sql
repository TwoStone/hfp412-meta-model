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

create sequence SCrtAktrCMD nocache;

create table CrtAktrCMD(
    id number primary key,
    Cls number not null,
    CrtAktrCMDNm varchar2(2000),
    CrtAktrCMDInvoker number,
    CrtAktrCMDInvokerCls number,
    constraint FCrtAktrCMDInvoker foreign key (CrtAktrCMDInvokerCls) references Cls (id),
    CrtAktrCMDCReceiver number,
    CrtAktrCMDCReceiverCls number,
    constraint FCrtAktrCMDCReceiver foreign key (CrtAktrCMDCReceiverCls) references Cls (id),
    CrtAktrCMDMyCmmnDt number,
    CrtAktrCMDMyCmmnDtCls number,
    constraint FCrtAktrCMDMyCmmnDt foreign key (CrtAktrCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null    
);

create sequence SAddRlCMD nocache;

create table AddRlCMD(
    id number primary key,
    Cls number not null,
    AddRlCMDAktr number,
    AddRlCMDAktrCls number,
    constraint FAddRlCMDAktr foreign key (AddRlCMDAktrCls) references Cls (id),
    AddRlCMDRllnNm varchar2(2000),
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

create sequence SCmmndCrdntr nocache;

create table CmmndCrdntr(
    id number primary key,
    Cls number not null    
);

create sequence SAktr nocache;

create table Aktr(
    id number primary key,
    Cls number not null,
    AktrNm varchar2(2000),
    AktrThis number,
    AktrThisCls number,
    constraint FAktrThis foreign key (AktrThisCls) references Cls (id)    
);
create index INmAktr on Aktr (AktrNm);


create sequence SCmmnDt nocache;

create table CmmnDt(
    id number primary key,
    Cls number not null,
    CmmnDtCrtdt Date,
    CmmnDtCmmtdt Date    
);

create sequence SRll nocache;

create table Rll(
    id number primary key,
    Cls number not null,
    RllRllFr number,
    RllRllFrCls number,
    constraint FRllRllFr foreign key (RllRllFrCls) references Cls (id),
    RllThis number,
    RllThisCls number,
    constraint FRllThis foreign key (RllThisCls) references Cls (id)    
);
create index IRllFrRll on Rll (RllRllFr, RllRllFrCls);


create sequence SAktrMngr nocache;

create table AktrMngr(
    id number primary key,
    Cls number not null,
    AktrMngrThis number,
    AktrMngrThisCls number,
    constraint FAktrMngrThis foreign key (AktrMngrThisCls) references Cls (id)    
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

create sequence SAktrMngrAktr nocache;

create table AktrMngrAktr(
    id number primary key,
    frm number not null,
    aktr number not null,
    Cls number not null,
    constraint FAktrMngrAktrCls foreign key(Cls) references Cls(id),
    constraint FAktrMngrAktrfrm foreign key(frm) references AktrMngr(id)
);
create index IFrmAktrMngrAktr on AktrMngrAktr(frm);

