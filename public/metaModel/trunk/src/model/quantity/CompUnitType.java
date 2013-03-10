package model.quantity;

import java.util.Iterator;

import model.DoubleDefinitionException;
import model.UserException;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.AbsUnitTypeExceptionVisitor;
import model.visitor.AbsUnitTypeReturnExceptionVisitor;
import model.visitor.AbsUnitTypeReturnVisitor;
import model.visitor.AbsUnitTypeVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.CompUnitTypeProxi;
import persistence.CompUnitType_RefsProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCompUnitType;
import persistence.PersistentMBoolean;
import persistence.PersistentReferenceType;
import persistence.PersistentUnit;
import persistence.PersistentUnitTypeManager;
import persistence.ReferenceSearchList;
import persistence.ReferenceTypeSearchList;
import persistence.TDObserver;

/* Additional import section end */

public class CompUnitType extends model.quantity.AbsUnitType implements PersistentCompUnitType{
    
    
    public static PersistentCompUnitType createCompUnitType(String name) throws PersistenceException{
        return createCompUnitType(name,false);
    }
    
    public static PersistentCompUnitType createCompUnitType(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentCompUnitType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
                .newDelayedCompUnitType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
                .newCompUnitType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompUnitType createCompUnitType(String name,boolean delayed$Persistence,PersistentCompUnitType This) throws PersistenceException {
        PersistentCompUnitType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
                .newDelayedCompUnitType(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
                .newCompUnitType(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("refs", this.getRefs().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public CompUnitType provideCopy() throws PersistenceException{
        CompUnitType result = this;
        result = new CompUnitType(this.name, 
                                  this.This, 
                                  this.getId());
        result.refs = this.refs.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CompUnitType_RefsProxi refs;
    
    public CompUnitType(String name,PersistentAbsUnitType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentAbsUnitType)This,id);
        this.refs = new CompUnitType_RefsProxi(this);        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 114) ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade
            .newCompUnitType(name,this.getId());
        super.store();
        this.getRefs().store();
        
    }
    
    public CompUnitType_RefsProxi getRefs() throws PersistenceException {
        return this.refs;
    }
    public PersistentCompUnitType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompUnitType result = new CompUnitTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompUnitType)this.This;
    }
    
    public void accept(AbsUnitTypeVisitor visitor) throws PersistenceException {
        visitor.handleCompUnitType(this);
    }
    public <R> R accept(AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnitType(this);
    }
    public <E extends UserException>  void accept(AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnitType(this);
    }
    public <R, E extends UserException> R accept(AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnitType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompUnitType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnitType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnitType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnitType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getRefs().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCompUnitType)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public PersistentAbsUnit fetchDefaultUnit() 
				throws model.ConsistencyException, PersistenceException{
		final PersistentUnitTypeManager unitTypeManager = UnitTypeManager.getTheUnitTypeManager();
		PersistentAbsUnit result = unitTypeManager.fetchScalar();
		if (getThis().getRefs().getLength() != 0) {
			final ReferenceSearchList refs = new ReferenceSearchList();
			final Iterator<PersistentReferenceType> i = getThis().getRefs().iterator();
			String name = "";
			while (i.hasNext()) {
				final PersistentReferenceType next = i.next();
				refs.add(unitTypeManager.fetchReference((PersistentUnit) next.getRef().fetchDefaultUnit(),
						next.getExponent()));
				if (name != "") {
					name += " * ";
				}
				name += next.getRef().toString() + "^" + next.getExponent();
			}
			try {
				result = unitTypeManager.fetchCU("", refs);
			} catch (final DoubleDefinitionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
    public PersistentMBoolean hasReferences(final ReferenceTypeSearchList refs) 
				throws PersistenceException{
		final Iterator<PersistentReferenceType> refsIterator = refs.iterator();

		// leere ReferenceTypeList ist immer enthalten (sinnvoll?)
		if (!refsIterator.hasNext()) {
			return MTrue.getTheMTrue();
		}

		PersistentMBoolean result = MFalse.getTheMFalse();
		while (refsIterator.hasNext()) {
			final PersistentReferenceType ref = refsIterator.next();
			final Iterator<PersistentReferenceType> myRefIterator = getThis().getRefs().iterator();
			while (myRefIterator.hasNext()) {
				final PersistentReferenceType myRef = myRefIterator.next();
				if (ref.equals(myRef)) {
					result = MTrue.getTheMTrue();
					break;
				} else {
					result = MFalse.getTheMFalse();
				}
			}
			if (!result.toBoolean()) {
				break;
			}
		}

		return result;
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// implement method: initializeOnInstantiation

	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
