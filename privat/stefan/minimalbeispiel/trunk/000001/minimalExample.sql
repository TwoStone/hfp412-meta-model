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

create sequence SCrtCntnCMD nocache;

create table CrtCntnCMD(
    id number primary key,
    Cls number not null,
    CrtCntnCMDNm varchar2(2000),
    CrtCntnCMDInvoker number,
    CrtCntnCMDInvokerCls number,
    constraint FCrtCntnCMDInvoker foreign key (CrtCntnCMDInvokerCls) references Cls (id),
    CrtCntnCMDCReceiver number,
    CrtCntnCMDCReceiverCls number,
    constraint FCrtCntnCMDCReceiver foreign key (CrtCntnCMDCReceiverCls) references Cls (id),
    CrtCntnCMDMyCmmnDt number,
    CrtCntnCMDMyCmmnDtCls number,
    constraint FCrtCntnCMDMyCmmnDt foreign key (CrtCntnCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SCmmndExctr nocache;

create table CmmndExctr(
    id number primary key,
    Cls number not null    
);

create sequence SAnMngr nocache;

create table AnMngr(
    id number primary key,
    Cls number not null,
    AnMngrThis number,
    AnMngrThisCls number,
    constraint FAnMngrThis foreign key (AnMngrThisCls) references Cls (id)    
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

create sequence SCntn nocache;

create table Cntn(
    id number primary key,
    Cls number not null,
    CntnNm varchar2(2000),
    CntnThis number,
    CntnThisCls number,
    constraint FCntnThis foreign key (CntnThisCls) references Cls (id)    
);
create index INmCntn on Cntn (CntnNm);


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

create sequence SAnMngrCntns nocache;

create table AnMngrCntns(
    id number primary key,
    frm number not null,
    cntns number not null,
    Cls number not null,
    constraint FAnMngrCntnsCls foreign key(Cls) references Cls(id),
    constraint FAnMngrCntnsfrm foreign key(frm) references AnMngr(id)
);
create index IFrmAnMngrCntns on AnMngrCntns(frm);

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

