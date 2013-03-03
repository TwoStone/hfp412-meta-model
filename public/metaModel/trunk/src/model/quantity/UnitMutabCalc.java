package model.quantity;

import model.NotComputableException;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentBasicCalculation;
import persistence.PersistentProxi;
import persistence.PersistentUnitMutabCalc;
import persistence.TDObserver;

/* Additional import section end */

public abstract class UnitMutabCalc extends model.quantity.BasicCalculation implements PersistentUnitMutabCalc{
    
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot targetUnit = (AbstractPersistentRoot)this.getTargetUnit();
            if (targetUnit != null) {
                result.put("targetUnit", targetUnit.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    targetUnit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && targetUnit.hasEssentialFields())targetUnit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot targetUnitType = (AbstractPersistentRoot)this.getTargetUnitType();
            if (targetUnitType != null) {
                result.put("targetUnitType", targetUnitType.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    targetUnitType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && targetUnitType.hasEssentialFields())targetUnitType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract UnitMutabCalc provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAbsUnit targetUnit;
    protected PersistentAbsUnitType targetUnitType;
    
    public UnitMutabCalc(PersistentAbsQuantity arg1,PersistentAbsQuantity arg2,PersistentAbsQuantity resultt,PersistentBasicCalculation This,PersistentAbsUnit targetUnit,PersistentAbsUnitType targetUnitType,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsQuantity)arg1,(PersistentAbsQuantity)arg2,(PersistentAbsQuantity)resultt,(PersistentBasicCalculation)This,id);
        this.targetUnit = targetUnit;
        this.targetUnitType = targetUnitType;        
    }
    
    static public long getTypeId() {
        return 334;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getTargetUnit() != null){
            this.getTargetUnit().store();
            ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitSet(this.getId(), getTargetUnit());
        }
        if(this.getTargetUnitType() != null){
            this.getTargetUnitType().store();
            ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitTypeSet(this.getId(), getTargetUnitType());
        }
        
    }
    
    public PersistentAbsUnit getTargetUnit() throws PersistenceException {
        return this.targetUnit;
    }
    public void setTargetUnit(PersistentAbsUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.targetUnit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.targetUnit = (PersistentAbsUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitSet(this.getId(), newValue);
        }
    }
    public PersistentAbsUnitType getTargetUnitType() throws PersistenceException {
        return this.targetUnitType;
    }
    public void setTargetUnitType(PersistentAbsUnitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.targetUnitType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.targetUnitType = (PersistentAbsUnitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitTypeSet(this.getId(), newValue);
        }
    }
    public abstract PersistentUnitMutabCalc getThis() throws PersistenceException ;
    
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentUnitMutabCalc)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public void createTargetUnitType() 
				throws model.NotComputableException, PersistenceException{
		// TODO Auto-generated method stub

	}
    public void findTargetUnit() 
				throws model.NotComputableException, PersistenceException{
		// TODO Auto-generated method stub

	}
    public void findTargetUnitType() 
				throws model.NotComputableException, PersistenceException{
		// TODO Auto-generated method stub

	}
    public void createTargetUnit() 
				throws model.NotComputableException, PersistenceException{
		// TODO Auto-generated method stub

	}

    /* Start of protected part that is not overridden by persistence generator */
    

	
    /* End of protected part that is not overridden by persistence generator */
    
}
