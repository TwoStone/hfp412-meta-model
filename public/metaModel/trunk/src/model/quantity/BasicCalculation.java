package model.quantity;

import model.visitor.AbsQuantityExceptionVisitor;
import model.visitor.AbsQuantityReturnVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentBasicCalculation;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.TDObserver;

/* Additional import section end */

public abstract class BasicCalculation extends PersistentObject implements PersistentBasicCalculation{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentBasicCalculation getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theBasicCalculationFacade.getClass(objectId);
        return (PersistentBasicCalculation)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot arg1 = (AbstractPersistentRoot)this.getArg1();
            if (arg1 != null) {
                result.put("arg1", arg1.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    arg1.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && arg1.hasEssentialFields())arg1.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot arg2 = (AbstractPersistentRoot)this.getArg2();
            if (arg2 != null) {
                result.put("arg2", arg2.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    arg2.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && arg2.hasEssentialFields())arg2.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot resultt = (AbstractPersistentRoot)this.getResultt();
            if (resultt != null) {
                result.put("resultt", resultt.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    resultt.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && resultt.hasEssentialFields())resultt.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract BasicCalculation provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAbsQuantity arg1;
    protected PersistentAbsQuantity arg2;
    protected PersistentAbsQuantity resultt;
    protected PersistentBasicCalculation This;
    
    public BasicCalculation(PersistentAbsQuantity arg1,PersistentAbsQuantity arg2,PersistentAbsQuantity resultt,PersistentBasicCalculation This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.resultt = resultt;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 159;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getArg1() != null){
            this.getArg1().store();
            ConnectionHandler.getTheConnectionHandler().theBasicCalculationFacade.arg1Set(this.getId(), getArg1());
        }
        if(this.getArg2() != null){
            this.getArg2().store();
            ConnectionHandler.getTheConnectionHandler().theBasicCalculationFacade.arg2Set(this.getId(), getArg2());
        }
        if(this.getResultt() != null){
            this.getResultt().store();
            ConnectionHandler.getTheConnectionHandler().theBasicCalculationFacade.resulttSet(this.getId(), getResultt());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theBasicCalculationFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAbsQuantity getArg1() throws PersistenceException {
        return this.arg1;
    }
    public void setArg1(PersistentAbsQuantity newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.arg1)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.arg1 = (PersistentAbsQuantity)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBasicCalculationFacade.arg1Set(this.getId(), newValue);
        }
    }
    public PersistentAbsQuantity getArg2() throws PersistenceException {
        return this.arg2;
    }
    public void setArg2(PersistentAbsQuantity newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.arg2)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.arg2 = (PersistentAbsQuantity)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBasicCalculationFacade.arg2Set(this.getId(), newValue);
        }
    }
    public PersistentAbsQuantity getResultt() throws PersistenceException {
        return this.resultt;
    }
    public void setResultt(PersistentAbsQuantity newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.resultt)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.resultt = (PersistentAbsQuantity)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBasicCalculationFacade.resulttSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentBasicCalculation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentBasicCalculation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBasicCalculationFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentBasicCalculation getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentBasicCalculation)This);
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    
    
    // Start of section that contains overridden operations only.
    
    public void calculate() 
				throws model.NotComputableException, PersistenceException{
		getThis().getArg1().accept(new AbsQuantityExceptionVisitor<model.NotComputableException>() {

			@Override
			public void handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity)
					throws PersistenceException, model.NotComputableException {
				final boolean arg2Comp = BasicCalculation.this.getThis().getArg2()
						.accept(new AbsQuantityReturnVisitor<Boolean>() {

							@Override
							public Boolean handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity)
									throws PersistenceException {
								return true;
							}

							@Override
							public Boolean handleQuantity(final PersistentQuantity quantity)
									throws PersistenceException {
								return false;
							}
						});
				if (arg2Comp) {
					BasicCalculation.this.getThis().calcComp(compoundQuantity,
							(PersistentCompoundQuantity) BasicCalculation.this.getThis().getArg2());
				} else {
					BasicCalculation.this.getThis().calc1Compound1Atomar(
							(PersistentQuantity) BasicCalculation.this.getThis().getArg2(), compoundQuantity);
				}

			}

			@Override
			public void handleQuantity(final PersistentQuantity quantity) throws PersistenceException,
					model.NotComputableException {
				final boolean arg2Comp = BasicCalculation.this.getThis().getArg2()
						.accept(new AbsQuantityReturnVisitor<Boolean>() {

							@Override
							public Boolean handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity)
									throws PersistenceException {
								return true;
							}

							@Override
							public Boolean handleQuantity(final PersistentQuantity quantity)
									throws PersistenceException {
								return false;
							}
						});
				if (arg2Comp) {
					BasicCalculation.this.getThis().calc1Compound1Atomar(quantity,
							(PersistentCompoundQuantity) BasicCalculation.this.getThis().getArg2());
				} else {
					BasicCalculation.this.getThis().calcAtomar(quantity,
							(PersistentQuantity) BasicCalculation.this.getThis().getArg2());
				}

			}
		});
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
