package model.typeSystem;

import model.CycleException;
import model.UserException;
import model.visitor.AbstractObjectExceptionVisitor;
import model.visitor.AbstractObjectReturnExceptionVisitor;
import model.visitor.AbstractObjectReturnVisitor;
import model.visitor.AbstractObjectVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MSingletonObjectProxi;
import persistence.PersistenceException;
import persistence.PersistentAbstractObject;
import persistence.PersistentMAtomicType;
import persistence.PersistentMAtomicTypeProduct;
import persistence.PersistentMSingletonObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class MSingletonObject extends model.typeSystem.AbstractObject implements PersistentMSingletonObject{
    
    
    public static PersistentMSingletonObject createMSingletonObject(PersistentMAtomicType type) throws PersistenceException{
        return createMSingletonObject(type,false);
    }
    
    public static PersistentMSingletonObject createMSingletonObject(PersistentMAtomicType type,boolean delayed$Persistence) throws PersistenceException {
        PersistentMSingletonObject result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMSingletonObjectFacade
                .newDelayedMSingletonObject();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMSingletonObjectFacade
                .newMSingletonObject(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        if(result.getThis().getType() == null)throw new PersistenceException("Field type in type MSingletonObject has not been initialized!",0);
        return result;
    }
    
    public static PersistentMSingletonObject createMSingletonObject(PersistentMAtomicType type,boolean delayed$Persistence,PersistentMSingletonObject This) throws PersistenceException {
        PersistentMSingletonObject result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMSingletonObjectFacade
                .newDelayedMSingletonObject();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMSingletonObjectFacade
                .newMSingletonObject(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot type = (AbstractPersistentRoot)this.getType();
            if (type != null) {
                result.put("type", type.createProxiInformation(false));
                if(depth > 1) {
                    type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && type.hasEssentialFields())type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MSingletonObject provideCopy() throws PersistenceException{
        MSingletonObject result = this;
        result = new MSingletonObject(this.This, 
                                      this.type, 
                                      this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMAtomicType type;
    
    public MSingletonObject(PersistentAbstractObject This,PersistentMAtomicType type,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbstractObject)This,id);
        this.type = type;        
    }
    
    static public long getTypeId() {
        return 287;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 287) ConnectionHandler.getTheConnectionHandler().theMSingletonObjectFacade
            .newMSingletonObject(this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theMSingletonObjectFacade.typeSet(this.getId(), getType());
        }
        
    }
    
    public PersistentMAtomicType getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentMAtomicType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        if(getThis().getType() != null)throw new PersistenceException("Final field type in type MSingletonObject has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentMAtomicType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMSingletonObjectFacade.typeSet(this.getId(), newValue);
        }
    }
    public PersistentMSingletonObject getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMSingletonObject result = new MSingletonObjectProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMSingletonObject)this.This;
    }
    
    public void accept(AbstractObjectVisitor visitor) throws PersistenceException {
        visitor.handleMSingletonObject(this);
    }
    public <R> R accept(AbstractObjectReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSingletonObject(this);
    }
    public <E extends UserException>  void accept(AbstractObjectExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSingletonObject(this);
    }
    public <R, E extends UserException> R accept(AbstractObjectReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSingletonObject(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMSingletonObject(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSingletonObject(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSingletonObject(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSingletonObject(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getPossibleNames().getLength()
            + (this.getProductType() == null ? 0 : 1)
            + (this.getType() == null ? 0 : 1));
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMSingletonObject)This);
		if(this.equals(This)){
			this.setType((PersistentMAtomicType)final$$Fields.get("type"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public PersistentMAtomicTypeProduct getProductType() 
				throws PersistenceException{
		final PersistentMAtomicTypeProduct result = MAtomicTypeProduct.createMAtomicTypeProduct();
		try {
			result.getFactors().add(getThis().getType());
		} catch (CycleException e) {
			// This will never happen!
		}

		return result;
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
