package persistence;

import java.util.Hashtable;

abstract class ProxiFactory {
	  abstract PersistentProxi create(long objectId);
}
abstract class ListProxiFactory {
	  abstract PersistentListEntryProxi create(long objectId, long entryId);
}

public abstract class PersistentProxi extends PersistentRoot {

  private static ProxiFactory [] proxiFactories;
  private static ListProxiFactory [] listProxiFactories;
	
  private static ListProxiFactory [] getTheListProxiFactories(){
	if (listProxiFactories == null){
		listProxiFactories = new ListProxiFactory[137];
        listProxiFactories[0] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateMObjectCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateUnitTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[4] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAspectCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[5] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[7] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MEmptyProductListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[8] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CompoundQuantityListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[9] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddDefaultUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[10] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new RemoveAssoFrmHierCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[11] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[12] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAtomicTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[13] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CompUnitTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[14] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MProductTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[15] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MeasurementListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[16] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AssociationListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[17] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new RemoveLinkCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[18] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FormalParameterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[19] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateHierarchyCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[20] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new OperationManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[22] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[23] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new UnitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[24] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateMeasurementTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[25] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MMeasurementTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[27] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[28] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountTypeManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[29] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MObjectListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[30] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateQuantityCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[31] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new InstanceObjectListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[32] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new RemoveFpCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[34] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MessageListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[35] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAbstractProductTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[36] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FunctionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[37] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AspectManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[38] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new RemoveOperationCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[39] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateConstantCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[40] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new LinkListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[41] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAspectListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[42] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[43] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MSumTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[44] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CompUnitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[45] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateMessageCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[46] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAccountTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[47] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new OperationListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[48] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ConversionManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[49] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new QuantityManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[51] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateProductTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[52] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateStaticOpCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[53] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AssociationManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[54] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAccountCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[55] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateConversionCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[56] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAtomicSubTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[58] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateVoidOperationCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[59] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateLinkCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[60] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateCompUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[61] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[62] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateCompUnitTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[63] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new RemoveAssociationCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[64] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new HierarchyListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[65] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAccountTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[66] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddFpCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[67] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateStaticMessageCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[68] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new TypeManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[69] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MessageManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[70] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new UnitTypeManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[72] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateVoidMessageCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[74] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddAssociationCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[75] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateConstCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[76] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FractionManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[77] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateOperationCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[78] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ConversionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[79] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ReferenceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[80] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FinishModelingCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[81] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ReferenceTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[82] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[83] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new UnitTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[84] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MFalseListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[85] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MeasurementTypeManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[86] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MEmptySumTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[87] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new LinkManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[88] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAssociationCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[90] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAtomicRootTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[91] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MTrueListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[92] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[93] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new QuantityListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[94] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddReferenceTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[95] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ActualParameterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[96] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateSumTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[97] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new RemoveFpFromOpCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[98] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new RemoveMessageCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[99] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ObjectManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[100] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateFpCommandListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [137];
        proxiFactories[0] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateMObjectCommandProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateUnitTypeCommandProxi(objectId);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAspectCommandProxi(objectId);
            }
        };
        proxiFactories[5] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateUnitCommandProxi(objectId);
            }
        };
        proxiFactories[7] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MEmptyProductProxi(objectId);
            }
        };
        proxiFactories[8] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CompoundQuantityProxi(objectId);
            }
        };
        proxiFactories[9] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddDefaultUnitCommandProxi(objectId);
            }
        };
        proxiFactories[10] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new RemoveAssoFrmHierCommandProxi(objectId);
            }
        };
        proxiFactories[11] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[12] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAtomicTypeProxi(objectId);
            }
        };
        proxiFactories[13] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CompUnitTypeProxi(objectId);
            }
        };
        proxiFactories[14] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MProductTypeProxi(objectId);
            }
        };
        proxiFactories[15] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MeasurementProxi(objectId);
            }
        };
        proxiFactories[16] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AssociationProxi(objectId);
            }
        };
        proxiFactories[17] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new RemoveLinkCommandProxi(objectId);
            }
        };
        proxiFactories[18] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FormalParameterProxi(objectId);
            }
        };
        proxiFactories[19] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateHierarchyCommandProxi(objectId);
            }
        };
        proxiFactories[20] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new OperationManagerProxi(objectId);
            }
        };
        proxiFactories[22] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[23] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new UnitProxi(objectId);
            }
        };
        proxiFactories[24] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateMeasurementTypeCommandProxi(objectId);
            }
        };
        proxiFactories[25] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MMeasurementTypeProxi(objectId);
            }
        };
        proxiFactories[27] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[28] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountTypeManagerProxi(objectId);
            }
        };
        proxiFactories[29] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MObjectProxi(objectId);
            }
        };
        proxiFactories[30] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateQuantityCommandProxi(objectId);
            }
        };
        proxiFactories[31] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new InstanceObjectProxi(objectId);
            }
        };
        proxiFactories[32] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new RemoveFpCommandProxi(objectId);
            }
        };
        proxiFactories[34] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MessageProxi(objectId);
            }
        };
        proxiFactories[35] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAbstractProductTypeProxi(objectId);
            }
        };
        proxiFactories[36] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FunctionProxi(objectId);
            }
        };
        proxiFactories[37] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AspectManagerProxi(objectId);
            }
        };
        proxiFactories[38] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new RemoveOperationCommandProxi(objectId);
            }
        };
        proxiFactories[39] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateConstantCommandProxi(objectId);
            }
        };
        proxiFactories[40] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new LinkProxi(objectId);
            }
        };
        proxiFactories[41] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAspectProxi(objectId);
            }
        };
        proxiFactories[42] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountManagerProxi(objectId);
            }
        };
        proxiFactories[43] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MSumTypeProxi(objectId);
            }
        };
        proxiFactories[44] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CompUnitProxi(objectId);
            }
        };
        proxiFactories[45] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateMessageCommandProxi(objectId);
            }
        };
        proxiFactories[46] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAccountTypeCommandProxi(objectId);
            }
        };
        proxiFactories[47] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new OperationProxi(objectId);
            }
        };
        proxiFactories[48] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ConversionManagerProxi(objectId);
            }
        };
        proxiFactories[49] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new QuantityManagerProxi(objectId);
            }
        };
        proxiFactories[51] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateProductTypeCommandProxi(objectId);
            }
        };
        proxiFactories[52] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateStaticOpCommandProxi(objectId);
            }
        };
        proxiFactories[53] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AssociationManagerProxi(objectId);
            }
        };
        proxiFactories[54] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAccountCommandProxi(objectId);
            }
        };
        proxiFactories[55] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateConversionCommandProxi(objectId);
            }
        };
        proxiFactories[56] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAtomicSubTypeCommandProxi(objectId);
            }
        };
        proxiFactories[58] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateVoidOperationCommandProxi(objectId);
            }
        };
        proxiFactories[59] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateLinkCommandProxi(objectId);
            }
        };
        proxiFactories[60] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateCompUnitCommandProxi(objectId);
            }
        };
        proxiFactories[61] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[62] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateCompUnitTypeCommandProxi(objectId);
            }
        };
        proxiFactories[63] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new RemoveAssociationCommandProxi(objectId);
            }
        };
        proxiFactories[64] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new HierarchyProxi(objectId);
            }
        };
        proxiFactories[65] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAccountTypeProxi(objectId);
            }
        };
        proxiFactories[66] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddFpCommandProxi(objectId);
            }
        };
        proxiFactories[67] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateStaticMessageCommandProxi(objectId);
            }
        };
        proxiFactories[68] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new TypeManagerProxi(objectId);
            }
        };
        proxiFactories[69] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MessageManagerProxi(objectId);
            }
        };
        proxiFactories[70] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new UnitTypeManagerProxi(objectId);
            }
        };
        proxiFactories[72] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateVoidMessageCommandProxi(objectId);
            }
        };
        proxiFactories[74] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddAssociationCommandProxi(objectId);
            }
        };
        proxiFactories[75] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateConstCommandProxi(objectId);
            }
        };
        proxiFactories[76] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FractionManagerProxi(objectId);
            }
        };
        proxiFactories[77] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateOperationCommandProxi(objectId);
            }
        };
        proxiFactories[78] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ConversionProxi(objectId);
            }
        };
        proxiFactories[79] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ReferenceProxi(objectId);
            }
        };
        proxiFactories[80] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FinishModelingCommandProxi(objectId);
            }
        };
        proxiFactories[81] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ReferenceTypeProxi(objectId);
            }
        };
        proxiFactories[82] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountProxi(objectId);
            }
        };
        proxiFactories[83] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new UnitTypeProxi(objectId);
            }
        };
        proxiFactories[84] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MFalseProxi(objectId);
            }
        };
        proxiFactories[85] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MeasurementTypeManagerProxi(objectId);
            }
        };
        proxiFactories[86] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MEmptySumTypeProxi(objectId);
            }
        };
        proxiFactories[87] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new LinkManagerProxi(objectId);
            }
        };
        proxiFactories[88] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAssociationCommandProxi(objectId);
            }
        };
        proxiFactories[90] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAtomicRootTypeCommandProxi(objectId);
            }
        };
        proxiFactories[91] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MTrueProxi(objectId);
            }
        };
        proxiFactories[92] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[93] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new QuantityProxi(objectId);
            }
        };
        proxiFactories[94] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddReferenceTypeCommandProxi(objectId);
            }
        };
        proxiFactories[95] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ActualParameterProxi(objectId);
            }
        };
        proxiFactories[96] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateSumTypeCommandProxi(objectId);
            }
        };
        proxiFactories[97] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new RemoveFpFromOpCommandProxi(objectId);
            }
        };
        proxiFactories[98] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new RemoveMessageCommandProxi(objectId);
            }
        };
        proxiFactories[99] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ObjectManagerProxi(objectId);
            }
        };
        proxiFactories[100] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateFpCommandProxi(objectId);
            }
        };
	}
	return proxiFactories;
  }

  public static PersistentProxi createProxi(common.ProxiInformation proxi) throws PersistenceException{
	  if (proxi.isDecorator()){
		  Decoratees resultDecoratee = (Decoratees) createProxi(proxi.getDecorateeObjectId(), proxi.getDecorateeClassId());
		  PersistentProxi resultDecorator = (PersistentProxi) resultDecoratee.createDecorator();
		  resultDecorator.setId(proxi.getObjectId());
		  return resultDecorator;
	  } else {
		  return createProxi(proxi.getObjectId(), proxi.getClassId());
	  }
  }

  public static PersistentProxi createProxi(long objectId, long classId) throws PersistenceException {
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ProxiFactory factory = getTheProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentProxi result =  factory.create(objectId);
    result.getTheObject();
    return result;
  }
  public static PersistentListEntryProxi createListEntryProxi(long objectId, long classId, long entryId) throws PersistenceException {
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheListProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ListProxiFactory factory = getTheListProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentListEntryProxi result =  factory.create(objectId,entryId);
    result.getTheObject();
    return result;
  }

	private PersistentInCacheProxi object;

	protected PersistentProxi(long id) {
		super(id);
		this.object = null;
	}

	protected PersistentProxi(PersistentInCacheProxi object) {
		//TODO Check if used anywhere!?
		super(object.getId());
		this.object = object;
	}
	public boolean isDelayed$Persistence() throws PersistenceException {
		return this.getTheObject().isDelayed$Persistence();
	}

	public void setDelayed$Persistence(boolean b) throws PersistenceException {
		this.getTheObject().setDelayed$Persistence(b);
	}
	public void store() throws PersistenceException{
		this.getTheObject().store();
	}
	public void setId(long id) {
		super.setId(id);
		try {
			this.getTheObject().setId(id);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}

	protected void setObject(PersistentRoot object) {
		if (this.object == null)
			this.object = (PersistentInCacheProxi)object;
	}

	public Hashtable<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(depth, essentialLevel, forGUI, tdObserver);
	}
	public Hashtable<String, Object> toHashtable(Hashtable<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, tdObserver);
	}

	public PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) {
			this.object = Cache.getTheCache().get(this);
			this.object.incrementUserCount();
		}
		return this.object;
	}
	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public int getIconInfo() throws PersistenceException {
		return this.getTheObject().getIconInfo();
	}
	public int getLeafInfo() throws PersistenceException {
		return this.getTheObject().getLeafInfo();
	}
	
	public String toString() {
		try {
			return this.getTheObject().toString();
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}
	}
	public String toString(boolean inner)throws PersistenceException{
		try {
			return this.getTheObject().toString(inner);
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}		
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	
    	
	
	public void finalize(){
		if (this.object != null)this.object.decrementUserCount();
	}
}
