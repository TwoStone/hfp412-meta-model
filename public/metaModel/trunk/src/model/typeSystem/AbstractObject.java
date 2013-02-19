package model.typeSystem;

import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.NameSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbstractObject;
import persistence.PersistentMAtomicType;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Procdure;
import persistence.TDObserver;

/* Additional import section end */

public abstract class AbstractObject extends PersistentObject implements PersistentAbstractObject{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAbstractObject getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAbstractObjectFacade.getClass(objectId);
        return (PersistentAbstractObject)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("possibleNames", this.getPossibleNames(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false));
            AbstractPersistentRoot productType = (AbstractPersistentRoot)this.getProductType(tdObserver);
            if (productType != null) {
                result.put("productType", productType.createProxiInformation(false));
                if(depth > 1) {
                    productType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && productType.hasEssentialFields())productType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract AbstractObject provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAbstractObject This;
    
    public AbstractObject(PersistentAbstractObject This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 286;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAbstractObjectFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    protected void setThis(PersistentAbstractObject newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAbstractObject)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAbstractObjectFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentAbstractObject getThis() throws PersistenceException ;
    
    
    
    public NameSearchList getPossibleNames(final TDObserver observer) 
				throws PersistenceException{
        NameSearchList result = getThis().getPossibleNames();
		observer.updateTransientDerived(getThis(), "possibleNames", result);
		return result;
    }
    public PersistentMNonEmptyAtomicTypeConjunction getProductType(final TDObserver observer) 
				throws PersistenceException{
        PersistentMNonEmptyAtomicTypeConjunction result = getThis().getProductType();
		observer.updateTransientDerived(getThis(), "productType", result);
		return result;
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAbstractObject)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public NameSearchList getPossibleNames() 
				throws PersistenceException{
		final NameSearchList list = new NameSearchList();

		this.getThis().getProductType().getFactors().applyToAll(new Procdure<PersistentMAtomicType>() {

			@Override
			public void doItTo(PersistentMAtomicType argument) throws PersistenceException {
				list.add(argument.getPossibleNames());
			}
		});

		return list;
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
