package persistence;

import java.util.Hashtable;

abstract class ICProxiFactory {
	  abstract PersistentInCacheProxi create(long objectId);
}

public abstract class PersistentInCacheProxi extends PersistentRoot {

	  private static ICProxiFactory [] iCProxiFactories;
		
	  private static ICProxiFactory [] getTheICProxiFactories(){
		if (iCProxiFactories == null){
			iCProxiFactories = new ICProxiFactory[137];
        iCProxiFactories[0] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateMObjectCommandICProxi(objectId);
            }
        };
        iCProxiFactories[1] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateUnitTypeCommandICProxi(objectId);
            }
        };
        iCProxiFactories[4] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateAspectCommandICProxi(objectId);
            }
        };
        iCProxiFactories[5] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateUnitCommandICProxi(objectId);
            }
        };
        iCProxiFactories[7] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MEmptyProductICProxi(objectId);
            }
        };
        iCProxiFactories[8] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompoundQuantityICProxi(objectId);
            }
        };
        iCProxiFactories[9] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AddDefaultUnitCommandICProxi(objectId);
            }
        };
        iCProxiFactories[10] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RemoveAssoFrmHierCommandICProxi(objectId);
            }
        };
        iCProxiFactories[11] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServerICProxi(objectId);
            }
        };
        iCProxiFactories[12] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MAtomicTypeICProxi(objectId);
            }
        };
        iCProxiFactories[13] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompUnitTypeICProxi(objectId);
            }
        };
        iCProxiFactories[14] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MProductTypeICProxi(objectId);
            }
        };
        iCProxiFactories[15] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MeasurementICProxi(objectId);
            }
        };
        iCProxiFactories[16] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AssociationICProxi(objectId);
            }
        };
        iCProxiFactories[17] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RemoveLinkCommandICProxi(objectId);
            }
        };
        iCProxiFactories[18] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new FormalParameterICProxi(objectId);
            }
        };
        iCProxiFactories[19] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateHierarchyCommandICProxi(objectId);
            }
        };
        iCProxiFactories[20] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new OperationManagerICProxi(objectId);
            }
        };
        iCProxiFactories[22] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ErrorDisplayICProxi(objectId);
            }
        };
        iCProxiFactories[23] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new UnitICProxi(objectId);
            }
        };
        iCProxiFactories[24] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateMeasurementTypeCommandICProxi(objectId);
            }
        };
        iCProxiFactories[25] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MMeasurementTypeICProxi(objectId);
            }
        };
        iCProxiFactories[27] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandCoordinatorICProxi(objectId);
            }
        };
        iCProxiFactories[28] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountTypeManagerICProxi(objectId);
            }
        };
        iCProxiFactories[29] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MObjectICProxi(objectId);
            }
        };
        iCProxiFactories[30] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateQuantityCommandICProxi(objectId);
            }
        };
        iCProxiFactories[31] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new InstanceObjectICProxi(objectId);
            }
        };
        iCProxiFactories[32] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RemoveFpCommandICProxi(objectId);
            }
        };
        iCProxiFactories[34] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MessageICProxi(objectId);
            }
        };
        iCProxiFactories[35] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MAbstractProductTypeICProxi(objectId);
            }
        };
        iCProxiFactories[36] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new FunctionICProxi(objectId);
            }
        };
        iCProxiFactories[37] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AspectManagerICProxi(objectId);
            }
        };
        iCProxiFactories[38] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RemoveOperationCommandICProxi(objectId);
            }
        };
        iCProxiFactories[39] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateConstantCommandICProxi(objectId);
            }
        };
        iCProxiFactories[40] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new LinkICProxi(objectId);
            }
        };
        iCProxiFactories[41] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MAspectICProxi(objectId);
            }
        };
        iCProxiFactories[42] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountManagerICProxi(objectId);
            }
        };
        iCProxiFactories[43] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MSumTypeICProxi(objectId);
            }
        };
        iCProxiFactories[44] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CompUnitICProxi(objectId);
            }
        };
        iCProxiFactories[45] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateMessageCommandICProxi(objectId);
            }
        };
        iCProxiFactories[46] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateAccountTypeCommandICProxi(objectId);
            }
        };
        iCProxiFactories[47] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new OperationICProxi(objectId);
            }
        };
        iCProxiFactories[48] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ConversionManagerICProxi(objectId);
            }
        };
        iCProxiFactories[49] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new QuantityManagerICProxi(objectId);
            }
        };
        iCProxiFactories[51] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateProductTypeCommandICProxi(objectId);
            }
        };
        iCProxiFactories[52] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateStaticOpCommandICProxi(objectId);
            }
        };
        iCProxiFactories[53] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AssociationManagerICProxi(objectId);
            }
        };
        iCProxiFactories[54] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateAccountCommandICProxi(objectId);
            }
        };
        iCProxiFactories[55] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateConversionCommandICProxi(objectId);
            }
        };
        iCProxiFactories[56] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateAtomicSubTypeCommandICProxi(objectId);
            }
        };
        iCProxiFactories[58] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateVoidOperationCommandICProxi(objectId);
            }
        };
        iCProxiFactories[59] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateLinkCommandICProxi(objectId);
            }
        };
        iCProxiFactories[60] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateCompUnitCommandICProxi(objectId);
            }
        };
        iCProxiFactories[61] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommonDateICProxi(objectId);
            }
        };
        iCProxiFactories[62] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateCompUnitTypeCommandICProxi(objectId);
            }
        };
        iCProxiFactories[63] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RemoveAssociationCommandICProxi(objectId);
            }
        };
        iCProxiFactories[64] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new HierarchyICProxi(objectId);
            }
        };
        iCProxiFactories[65] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MAccountTypeICProxi(objectId);
            }
        };
        iCProxiFactories[66] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AddFpCommandICProxi(objectId);
            }
        };
        iCProxiFactories[67] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateStaticMessageCommandICProxi(objectId);
            }
        };
        iCProxiFactories[68] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new TypeManagerICProxi(objectId);
            }
        };
        iCProxiFactories[69] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MessageManagerICProxi(objectId);
            }
        };
        iCProxiFactories[70] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new UnitTypeManagerICProxi(objectId);
            }
        };
        iCProxiFactories[72] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateVoidMessageCommandICProxi(objectId);
            }
        };
        iCProxiFactories[74] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AddAssociationCommandICProxi(objectId);
            }
        };
        iCProxiFactories[75] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateConstCommandICProxi(objectId);
            }
        };
        iCProxiFactories[76] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new FractionManagerICProxi(objectId);
            }
        };
        iCProxiFactories[77] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateOperationCommandICProxi(objectId);
            }
        };
        iCProxiFactories[78] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ConversionICProxi(objectId);
            }
        };
        iCProxiFactories[79] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ReferenceICProxi(objectId);
            }
        };
        iCProxiFactories[80] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new FinishModelingCommandICProxi(objectId);
            }
        };
        iCProxiFactories[81] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ReferenceTypeICProxi(objectId);
            }
        };
        iCProxiFactories[82] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountICProxi(objectId);
            }
        };
        iCProxiFactories[83] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new UnitTypeICProxi(objectId);
            }
        };
        iCProxiFactories[84] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MFalseICProxi(objectId);
            }
        };
        iCProxiFactories[85] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MeasurementTypeManagerICProxi(objectId);
            }
        };
        iCProxiFactories[86] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MEmptySumTypeICProxi(objectId);
            }
        };
        iCProxiFactories[87] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new LinkManagerICProxi(objectId);
            }
        };
        iCProxiFactories[88] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateAssociationCommandICProxi(objectId);
            }
        };
        iCProxiFactories[90] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateAtomicRootTypeCommandICProxi(objectId);
            }
        };
        iCProxiFactories[91] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MTrueICProxi(objectId);
            }
        };
        iCProxiFactories[92] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandExecuterICProxi(objectId);
            }
        };
        iCProxiFactories[93] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new QuantityICProxi(objectId);
            }
        };
        iCProxiFactories[94] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AddReferenceTypeCommandICProxi(objectId);
            }
        };
        iCProxiFactories[95] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ActualParameterICProxi(objectId);
            }
        };
        iCProxiFactories[96] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateSumTypeCommandICProxi(objectId);
            }
        };
        iCProxiFactories[97] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RemoveFpFromOpCommandICProxi(objectId);
            }
        };
        iCProxiFactories[98] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new RemoveMessageCommandICProxi(objectId);
            }
        };
        iCProxiFactories[99] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ObjectManagerICProxi(objectId);
            }
        };
        iCProxiFactories[100] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateFpCommandICProxi(objectId);
            }
        };
		}
		return iCProxiFactories;
	  }

	public static PersistentInCacheProxi createInCacheProxi(long objectId, long classId) throws PersistenceException {
	    int index = (int) classId;
		if (index < 0) index = index * -1;
	    index = index - 101;
	    if (index > getTheICProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    ICProxiFactory factory = getTheICProxiFactories()[index];
	    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    PersistentInCacheProxi result =  factory.create(objectId);
	    return result;
	}

	protected PersistentObject object;
  	public int userCount;
	
	protected PersistentInCacheProxi(long id) {
		super(id);
		this.userCount = 0;
	}

	public PersistentInCacheProxi(PersistentObject object) {
		this(object.getId());
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
	public Hashtable<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(depth, essentialLevel, forGUI, tdObserver);
	}
	public Hashtable<String, Object> toHashtable(Hashtable<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, tdObserver);
	}

	protected abstract PersistentObject getRemote() throws PersistenceException;

	public synchronized PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) this.object = getRemote();
		return this.object;
	}		
	protected synchronized void setObject(PersistentObject object) throws PersistenceException {
		this.object = object;
	}
	protected synchronized void clear() throws PersistenceException {
		this.object = null;
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

	public synchronized void incrementUserCount() {
		this.userCount++;
	}

	public synchronized void decrementUserCount() {
		this.userCount--;
		if (this.isRemovable())Cache.getTheCache().remove(this);
	}

	protected boolean isRemovable() {
		return this.userCount == 0 ;
	}
	public synchronized void tryBreak() {
		try {
			if (!this.isDelayed$Persistence())this.object = null;
		} catch (PersistenceException e) {
			return;
		}
	}

	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	
    
}
