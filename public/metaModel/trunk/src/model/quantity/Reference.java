package model.quantity;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.CompUnitSearchList;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentReference;
import persistence.PersistentReferenceType;
import persistence.PersistentUnit;
import persistence.ReferenceProxi;
import persistence.TDObserver;

/* Additional import section end */

public class Reference extends PersistentObject implements PersistentReference{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentReference getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theReferenceFacade.getClass(objectId);
        return (PersistentReference)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentReference createReference() throws PersistenceException{
        return createReference(false);
    }
    
    public static PersistentReference createReference(boolean delayed$Persistence) throws PersistenceException {
        PersistentReference result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade
                .newDelayedReference(0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade
                .newReference(0,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentReference createReference(boolean delayed$Persistence,PersistentReference This) throws PersistenceException {
        PersistentReference result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade
                .newDelayedReference(0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade
                .newReference(0,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
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
                result.put("type", type.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && type.hasEssentialFields())type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("exponent", new Long(this.getExponent()).toString());
            AbstractPersistentRoot ref = (AbstractPersistentRoot)this.getRef();
            if (ref != null) {
                result.put("ref", ref.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    ref.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && ref.hasEssentialFields())ref.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Reference provideCopy() throws PersistenceException{
        Reference result = this;
        result = new Reference(this.type, 
                               this.exponent, 
                               this.ref, 
                               this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentReferenceType type;
    protected long exponent;
    protected PersistentUnit ref;
    protected PersistentReference This;
    
    public Reference(PersistentReferenceType type,long exponent,PersistentUnit ref,PersistentReference This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.type = type;
        this.exponent = exponent;
        this.ref = ref;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 180;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 180) ConnectionHandler.getTheConnectionHandler().theReferenceFacade
            .newReference(0,this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.typeSet(this.getId(), getType());
        }
        if(this.getRef() != null){
            this.getRef().store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.refSet(this.getId(), getRef());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentReferenceType getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentReferenceType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentReferenceType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.typeSet(this.getId(), newValue);
        }
    }
    public long getExponent() throws PersistenceException {
        return this.exponent;
    }
    public void setExponent(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theReferenceFacade.exponentSet(this.getId(), newValue);
        this.exponent = newValue;
    }
    public PersistentUnit getRef() throws PersistenceException {
        return this.ref;
    }
    public void setRef(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.ref)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.ref = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.refSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentReference newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentReference)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theReferenceFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentReference getThis() throws PersistenceException {
        if(this.This == null){
            PersistentReference result = new ReferenceProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentReference)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleReference(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReference(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReference(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReference(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getType() != null) return 1;
        if (this.getRef() != null) return 1;
        return 0;
    }
    
    
    public CompUnitSearchList inverseGetRefs() 
				throws PersistenceException{
        CompUnitSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
							.inverseGetRefs(this.getId(), this.getClassId());
		return result;
    }
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
        this.setThis((PersistentReference)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    

	
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
