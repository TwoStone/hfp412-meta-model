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
		listProxiFactories = new ListProxiFactory[111];
        listProxiFactories[68] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ConversionManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[69] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new QuantityManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[86] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateProductTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[70] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateUnitTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[40] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AssociationManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[71] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateConversionCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[87] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAtomicSubTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[38] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAspectCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[72] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[41] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAHierarchyListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[73] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateCompUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[74] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateCompUnitTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[20] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[93] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAccountTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[17] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new TypeManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[57] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CompoundQuantityListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[85] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MEmptyProductListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[75] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new UnitTypeManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[76] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddDefaultUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[4] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAtomicTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[77] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FractionManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[62] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ReferenceListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[63] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ConversionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[64] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CompUnitTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[0] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MProductTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[94] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MeasurementListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[78] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FinishModelingCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[49] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ReferenceTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[95] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AccountListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[96] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MOperationListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[43] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateHierarchyCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[35] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MFalseListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[51] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new UnitTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[52] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new UnitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[98] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MMeasurementTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[89] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MEmptySumTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[19] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[100] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MFormalParameterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[42] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAssociationListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[45] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAssociationCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[79] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateQuantityCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[102] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new InstanceObjectListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[90] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateAtomicRootTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[37] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MTrueListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[18] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[80] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddReferenceTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[56] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new QuantityListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[91] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAbstractProductTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[104] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MessageListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[58] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new FunctionListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[25] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AspectManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[105] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ActualParameterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[44] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddToHierarchyCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[32] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddSubTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[92] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateSumTypeCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[106] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new LinkListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[26] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MAspectListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[2] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MSumTypeListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[61] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CompUnitListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [111];
        proxiFactories[68] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ConversionManagerProxi(objectId);
            }
        };
        proxiFactories[69] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new QuantityManagerProxi(objectId);
            }
        };
        proxiFactories[86] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateProductTypeCommandProxi(objectId);
            }
        };
        proxiFactories[70] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateUnitTypeCommandProxi(objectId);
            }
        };
        proxiFactories[40] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AssociationManagerProxi(objectId);
            }
        };
        proxiFactories[71] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateConversionCommandProxi(objectId);
            }
        };
        proxiFactories[87] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAtomicSubTypeCommandProxi(objectId);
            }
        };
        proxiFactories[38] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAspectCommandProxi(objectId);
            }
        };
        proxiFactories[72] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateUnitCommandProxi(objectId);
            }
        };
        proxiFactories[41] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAHierarchyProxi(objectId);
            }
        };
        proxiFactories[73] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateCompUnitCommandProxi(objectId);
            }
        };
        proxiFactories[74] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateCompUnitTypeCommandProxi(objectId);
            }
        };
        proxiFactories[20] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[93] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAccountTypeProxi(objectId);
            }
        };
        proxiFactories[17] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new TypeManagerProxi(objectId);
            }
        };
        proxiFactories[57] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CompoundQuantityProxi(objectId);
            }
        };
        proxiFactories[85] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MEmptyProductProxi(objectId);
            }
        };
        proxiFactories[75] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new UnitTypeManagerProxi(objectId);
            }
        };
        proxiFactories[76] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddDefaultUnitCommandProxi(objectId);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAtomicTypeProxi(objectId);
            }
        };
        proxiFactories[77] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FractionManagerProxi(objectId);
            }
        };
        proxiFactories[62] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ReferenceProxi(objectId);
            }
        };
        proxiFactories[63] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ConversionProxi(objectId);
            }
        };
        proxiFactories[64] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CompUnitTypeProxi(objectId);
            }
        };
        proxiFactories[0] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MProductTypeProxi(objectId);
            }
        };
        proxiFactories[94] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MeasurementProxi(objectId);
            }
        };
        proxiFactories[78] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FinishModelingCommandProxi(objectId);
            }
        };
        proxiFactories[49] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ReferenceTypeProxi(objectId);
            }
        };
        proxiFactories[95] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AccountProxi(objectId);
            }
        };
        proxiFactories[96] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MOperationProxi(objectId);
            }
        };
        proxiFactories[43] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateHierarchyCommandProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[35] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MFalseProxi(objectId);
            }
        };
        proxiFactories[51] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new UnitTypeProxi(objectId);
            }
        };
        proxiFactories[52] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new UnitProxi(objectId);
            }
        };
        proxiFactories[98] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MMeasurementTypeProxi(objectId);
            }
        };
        proxiFactories[89] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MEmptySumTypeProxi(objectId);
            }
        };
        proxiFactories[19] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[100] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MFormalParameterProxi(objectId);
            }
        };
        proxiFactories[42] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAssociationProxi(objectId);
            }
        };
        proxiFactories[45] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAssociationCommandProxi(objectId);
            }
        };
        proxiFactories[79] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateQuantityCommandProxi(objectId);
            }
        };
        proxiFactories[102] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new InstanceObjectProxi(objectId);
            }
        };
        proxiFactories[90] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateAtomicRootTypeCommandProxi(objectId);
            }
        };
        proxiFactories[37] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MTrueProxi(objectId);
            }
        };
        proxiFactories[18] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[80] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddReferenceTypeCommandProxi(objectId);
            }
        };
        proxiFactories[56] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new QuantityProxi(objectId);
            }
        };
        proxiFactories[91] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAbstractProductTypeProxi(objectId);
            }
        };
        proxiFactories[104] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MessageProxi(objectId);
            }
        };
        proxiFactories[58] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new FunctionProxi(objectId);
            }
        };
        proxiFactories[25] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AspectManagerProxi(objectId);
            }
        };
        proxiFactories[105] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ActualParameterProxi(objectId);
            }
        };
        proxiFactories[44] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddToHierarchyCommandProxi(objectId);
            }
        };
        proxiFactories[32] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddSubTypeCommandProxi(objectId);
            }
        };
        proxiFactories[92] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateSumTypeCommandProxi(objectId);
            }
        };
        proxiFactories[106] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new LinkProxi(objectId);
            }
        };
        proxiFactories[26] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MAspectProxi(objectId);
            }
        };
        proxiFactories[2] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MSumTypeProxi(objectId);
            }
        };
        proxiFactories[61] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CompUnitProxi(objectId);
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
	
    protected void setDltd() throws PersistenceException{
        this.getTheObject().setDltd();
    }
    public boolean isDltd() throws PersistenceException {
        return this.getTheObject().isDltd();
    }
	
	
//	public void finalize(){
//		if (this.object != null)this.object.decrementUserCount();
//	}
}
