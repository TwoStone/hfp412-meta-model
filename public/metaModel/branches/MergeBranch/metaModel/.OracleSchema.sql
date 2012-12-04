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

create sequence SCrtHrrchCMD nocache;

create table CrtHrrchCMD(
    id number primary key,
    Cls number not null,
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

create sequence SAspctMngr nocache;

create table AspctMngr(
    id number primary key,
    Cls number not null,
    AspctMngrThis number,
    AspctMngrThisCls number,
    constraint FAspctMngrThis foreign key (AspctMngrThisCls) references Cls (id)    
);

create sequence SAddTHrrchCMD nocache;

create table AddTHrrchCMD(
    id number primary key,
    Cls number not null,
    AddTHrrchCMDAssctn number,
    AddTHrrchCMDAssctnCls number,
    constraint FAddTHrrchCMDAssctn foreign key (AddTHrrchCMDAssctnCls) references Cls (id),
    AddTHrrchCMDThHrrch number,
    AddTHrrchCMDThHrrchCls number,
    constraint FAddTHrrchCMDThHrrch foreign key (AddTHrrchCMDThHrrchCls) references Cls (id),
    AddTHrrchCMDInvoker number,
    AddTHrrchCMDInvokerCls number,
    constraint FAddTHrrchCMDInvoker foreign key (AddTHrrchCMDInvokerCls) references Cls (id),
    AddTHrrchCMDCReceiver number,
    AddTHrrchCMDCReceiverCls number,
    constraint FAddTHrrchCMDCReceiver foreign key (AddTHrrchCMDCReceiverCls) references Cls (id),
    AddTHrrchCMDMyCmmnDt number,
    AddTHrrchCMDMyCmmnDtCls number,
    constraint FAddTHrrchCMDMyCmmnDt foreign key (AddTHrrchCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SAddSbTpCMD nocache;

create table AddSbTpCMD(
    id number primary key,
    Cls number not null,
    AddSbTpCMDSprTp number,
    AddSbTpCMDSprTpCls number,
    constraint FAddSbTpCMDSprTp foreign key (AddSbTpCMDSprTpCls) references Cls (id),
    AddSbTpCMDTpndr number,
    AddSbTpCMDTpndrCls number,
    constraint FAddSbTpCMDTpndr foreign key (AddSbTpCMDTpndrCls) references Cls (id),
    AddSbTpCMDInvoker number,
    AddSbTpCMDInvokerCls number,
    constraint FAddSbTpCMDInvoker foreign key (AddSbTpCMDInvokerCls) references Cls (id),
    AddSbTpCMDCReceiver number,
    AddSbTpCMDCReceiverCls number,
    constraint FAddSbTpCMDCReceiver foreign key (AddSbTpCMDCReceiverCls) references Cls (id),
    AddSbTpCMDMyCmmnDt number,
    AddSbTpCMDMyCmmnDtCls number,
    constraint FAddSbTpCMDMyCmmnDt foreign key (AddSbTpCMDMyCmmnDtCls) references Cls (id)    
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


create sequence SAssctnMngr nocache;

create table AssctnMngr(
    id number primary key,
    Cls number not null,
    AssctnMngrThis number,
    AssctnMngrThisCls number,
    constraint FAssctnMngrThis foreign key (AssctnMngrThisCls) references Cls (id)    
);

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
    constraint FMAtmcTpSprTp foreign key (MAtmcTpSprTpCls) references Cls (id),
    MAtmcTpThis number,
    MAtmcTpThisCls number,
    constraint FMAtmcTpThis foreign key (MAtmcTpThisCls) references Cls (id)    
);
create index INmMAtmcTp on MAtmcTp (MAtmcTpNm);
create index IAspctMAtmcTp on MAtmcTp (MAtmcTpAspct, MAtmcTpAspctCls);
create index ISprTpMAtmcTp on MAtmcTp (MAtmcTpSprTp, MAtmcTpSprTpCls);


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

create sequence SCrtAtmcTpCMD nocache;

create table CrtAtmcTpCMD(
    id number primary key,
    Cls number not null,
    CrtAtmcTpCMDAspct number,
    CrtAtmcTpCMDAspctCls number,
    constraint FCrtAtmcTpCMDAspct foreign key (CrtAtmcTpCMDAspctCls) references Cls (id),
    CrtAtmcTpCMDNm varchar2(2000),
    CrtAtmcTpCMDSngltnTp number,
    CrtAtmcTpCMDSngltnTpCls number,
    constraint FCrtAtmcTpCMDSngltnTp foreign key (CrtAtmcTpCMDSngltnTpCls) references Cls (id),
    CrtAtmcTpCMDAbstrctTp number,
    CrtAtmcTpCMDAbstrctTpCls number,
    constraint FCrtAtmcTpCMDAbstrctTp foreign key (CrtAtmcTpCMDAbstrctTpCls) references Cls (id),
    CrtAtmcTpCMDInvoker number,
    CrtAtmcTpCMDInvokerCls number,
    constraint FCrtAtmcTpCMDInvoker foreign key (CrtAtmcTpCMDInvokerCls) references Cls (id),
    CrtAtmcTpCMDCReceiver number,
    CrtAtmcTpCMDCReceiverCls number,
    constraint FCrtAtmcTpCMDCReceiver foreign key (CrtAtmcTpCMDCReceiverCls) references Cls (id),
    CrtAtmcTpCMDMyCmmnDt number,
    CrtAtmcTpCMDMyCmmnDtCls number,
    constraint FCrtAtmcTpCMDMyCmmnDt foreign key (CrtAtmcTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMAHrrch nocache;

create table MAHrrch(
    id number primary key,
    Cls number not null,
    MAHrrchNm varchar2(2000),
    MAHrrchThis number,
    MAHrrchThisCls number,
    constraint FMAHrrchThis foreign key (MAHrrchThisCls) references Cls (id)    
);
create index INmMAHrrch on MAHrrch (MAHrrchNm);


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

create sequence SMAssctn nocache;

create table MAssctn(
    id number primary key,
    Cls number not null,
    MAssctnNm varchar2(2000),
    MAssctnSrc number,
    MAssctnSrcCls number,
    constraint FMAssctnSrc foreign key (MAssctnSrcCls) references Cls (id),
    MAssctnTrgt number,
    MAssctnTrgtCls number,
    constraint FMAssctnTrgt foreign key (MAssctnTrgtCls) references Cls (id),
    MAssctnThis number,
    MAssctnThisCls number,
    constraint FMAssctnThis foreign key (MAssctnThisCls) references Cls (id)    
);

create sequence SCrtAssctnCMD nocache;

create table CrtAssctnCMD(
    id number primary key,
    Cls number not null,
    CrtAssctnCMDNm varchar2(2000),
    CrtAssctnCMDSrc number,
    CrtAssctnCMDSrcCls number,
    constraint FCrtAssctnCMDSrc foreign key (CrtAssctnCMDSrcCls) references Cls (id),
    CrtAssctnCMDTrgt number,
    CrtAssctnCMDTrgtCls number,
    constraint FCrtAssctnCMDTrgt foreign key (CrtAssctnCMDTrgtCls) references Cls (id),
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

create sequence SCrtSbTpCMD nocache;

create table CrtSbTpCMD(
    id number primary key,
    Cls number not null,
    CrtSbTpCMDSprTp number,
    CrtSbTpCMDSprTpCls number,
    constraint FCrtSbTpCMDSprTp foreign key (CrtSbTpCMDSprTpCls) references Cls (id),
    CrtSbTpCMDNm varchar2(2000),
    CrtSbTpCMDSngltnTp number,
    CrtSbTpCMDSngltnTpCls number,
    constraint FCrtSbTpCMDSngltnTp foreign key (CrtSbTpCMDSngltnTpCls) references Cls (id),
    CrtSbTpCMDAbstrctTp number,
    CrtSbTpCMDAbstrctTpCls number,
    constraint FCrtSbTpCMDAbstrctTp foreign key (CrtSbTpCMDAbstrctTpCls) references Cls (id),
    CrtSbTpCMDInvoker number,
    CrtSbTpCMDInvokerCls number,
    constraint FCrtSbTpCMDInvoker foreign key (CrtSbTpCMDInvokerCls) references Cls (id),
    CrtSbTpCMDCReceiver number,
    CrtSbTpCMDCReceiverCls number,
    constraint FCrtSbTpCMDCReceiver foreign key (CrtSbTpCMDCReceiverCls) references Cls (id),
    CrtSbTpCMDMyCmmnDt number,
    CrtSbTpCMDMyCmmnDtCls number,
    constraint FCrtSbTpCMDMyCmmnDt foreign key (CrtSbTpCMDMyCmmnDtCls) references Cls (id)    
);

create sequence SMBln nocache;

create table MBln(
    id number primary key,
    Cls number not null,
    MBlnThis number,
    MBlnThisCls number,
    constraint FMBlnThis foreign key (MBlnThisCls) references Cls (id)    
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

create sequence SMAssctnHrrchs nocache;

create table MAssctnHrrchs(
    id number primary key,
    frm number not null,
    hrrchs number not null,
    Cls number not null,
    constraint FMAssctnHrrchsCls foreign key(Cls) references Cls(id),
    constraint FMAssctnHrrchsfrm foreign key(frm) references MAssctn(id)
);
create index IFrmMAssctnHrrchs on MAssctnHrrchs(frm);


create index IHrrchsMAssctnHrrchs on MAssctnHrrchs(hrrchs);
