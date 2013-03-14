package model.quantity;

import java.util.Iterator;

import model.ConsistencyException;
import model.UserException;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.AbsUnitExceptionVisitor;
import model.visitor.AbsUnitReturnExceptionVisitor;
import model.visitor.AbsUnitReturnVisitor;
import model.visitor.AbsUnitVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.Anything;
import persistence.CompUnitProxi;
import persistence.CompUnit_RefsProxi;
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentCompUnit;
import persistence.PersistentMBoolean;
import persistence.PersistentMModelItem;
import persistence.PersistentReference;
import persistence.ReferenceSearchList;
import persistence.TDObserver;
import constants.ExceptionConstants;

/* Additional import section end */

public class CompUnit extends model.quantity.AbsUnit implements PersistentCompUnit{
    
    
    public static PersistentCompUnit createCompUnit(PersistentAbsUnitType type,String name) throws PersistenceException{
        return createCompUnit(type,name,false);
    }
    
    public static PersistentCompUnit createCompUnit(PersistentAbsUnitType type,String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentCompUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newDelayedCompUnit(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newCompUnit(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompUnit createCompUnit(PersistentAbsUnitType type,String name,boolean delayed$Persistence,PersistentCompUnit This) throws PersistenceException {
        PersistentCompUnit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newDelayedCompUnit(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
                .newCompUnit(name,-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("type", type);
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
    
    public CompUnit provideCopy() throws PersistenceException{
        CompUnit result = this;
        result = new CompUnit(this.type, 
                              this.name, 
                              this.This, 
                              this.myCONCMModelItem, 
                              this.getId());
        result.refs = this.refs.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected CompUnit_RefsProxi refs;
    
    public CompUnit(PersistentAbsUnitType type,String name,PersistentAbsUnit This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsUnitType)type,(String)name,(PersistentAbsUnit)This,(PersistentMModelItem)myCONCMModelItem,id);
        this.refs = new CompUnit_RefsProxi(this);        
    }
    
    static public long getTypeId() {
        return 145;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 145) ConnectionHandler.getTheConnectionHandler().theCompUnitFacade
            .newCompUnit(name,this.getId());
        super.store();
        this.getRefs().store();
        
    }
    
    public CompUnit_RefsProxi getRefs() throws PersistenceException {
        return this.refs;
    }
    public PersistentCompUnit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompUnit result = new CompUnitProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompUnit)this.This;
    }
    
    public void accept(AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnit(this);
    }
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompUnit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompUnit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompUnit(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getRefs().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCompUnit)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentCompUnit)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setType((PersistentAbsUnitType)final$$Fields.get("type"));
			this.setName((String)final$$Fields.get("name"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		throw new ConsistencyException(ExceptionConstants.DONT_DELETE_UNIT);
	}
    public MModelItemSearchList fetchDependentItems() 
				throws PersistenceException{
		// TODO: implement method: fetchDependentItems
		try {
			throw new java.lang.UnsupportedOperationException("Method \"fetchDependentItems\" not implemented yet.");
		} catch (final java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}
    public PersistentMBoolean hasReferences(final ReferenceSearchList refs) 
				throws PersistenceException{
		final Iterator<PersistentReference> refsIterator = refs.iterator();

		// leere ReferenceList ist immer enthalten
		if (!refsIterator.hasNext()) {
			return MTrue.getTheMTrue();
		}

		PersistentMBoolean result = MFalse.getTheMFalse();
		while (refsIterator.hasNext()) {
			final PersistentReference ref = refsIterator.next();
			final Iterator<PersistentReference> myRefIterator = getThis().getRefs().iterator();
			while (myRefIterator.hasNext()) {
				final PersistentReference myRef = myRefIterator.next();
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
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
		//

	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    

	
    /* End of protected part that is not overridden by persistence generator */
    
}
