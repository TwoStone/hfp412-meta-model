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

create sequence SMAtmcTp nocache;

create table MAtmcTp(
    id number primary key,
    Cls number not null,
    MAtmcTpNm varchar2(2000),
    MAtmcTpThis number,
    MAtmcTpThisCls number,
    constraint FMAtmcTpThis foreign key (MAtmcTpThisCls) references Cls (id)    
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

