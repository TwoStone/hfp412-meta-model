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
    RlRlFr number,
    RlRlFrCls number,
    constraint FRlRlFr foreign key (RlRlFrCls) references Cls (id),
    RlThis number,
    RlThisCls number,
    constraint FRlThis foreign key (RlThisCls) references Cls (id)    
);
create index IRlFrRl on Rl (RlRlFr, RlRlFrCls);


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

