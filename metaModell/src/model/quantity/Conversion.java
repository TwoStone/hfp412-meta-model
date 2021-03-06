package model.quantity;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ConversionProxi;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentConversion;
import persistence.PersistentFunction;
import persistence.PersistentMModelItem;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentUnit;
import persistence.TDObserver;

/* Additional import section end */

public class Conversion extends PersistentObject implements PersistentConversion{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentConversion getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theConversionFacade.getClass(objectId);
        return (PersistentConversion)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentConversion createConversion(PersistentUnit source,PersistentFunction myFunction) throws PersistenceException{
        return createConversion(source,myFunction,false);
    }
    
    public static PersistentConversion createConversion(PersistentUnit source,PersistentFunction myFunction,boolean delayed$Persistence) throws PersistenceException {
        PersistentConversion result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theConversionFacade
                .newDelayedConversion();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theConversionFacade
                .newConversion(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("source", source);
        final$$Fields.put("myFunction", myFunction);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentConversion createConversion(PersistentUnit source,PersistentFunction myFunction,boolean delayed$Persistence,PersistentConversion This) throws PersistenceException {
        PersistentConversion result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theConversionFacade
                .newDelayedConversion();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theConversionFacade
                .newConversion(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("source", source);
        final$$Fields.put("myFunction", myFunction);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot source = (AbstractPersistentRoot)this.getSource();
            if (source != null) {
                result.put("source", source.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    source.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && source.hasEssentialFields())source.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot myFunction = (AbstractPersistentRoot)this.getMyFunction();
            if (myFunction != null) {
                result.put("myFunction", myFunction.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    myFunction.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && myFunction.hasEssentialFields())myFunction.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot myCONCMModelItem = (AbstractPersistentRoot)this.getMyCONCMModelItem();
            if (myCONCMModelItem != null) {
                result.put("myCONCMModelItem", myCONCMModelItem.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    myCONCMModelItem.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    myCONCMModelItem.toHashtable(allResults, depth, essentialLevel + 1, forGUI, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Conversion provideCopy() throws PersistenceException{
        Conversion result = this;
        result = new Conversion(this.source, 
                                this.myFunction, 
                                this.This, 
                                this.myCONCMModelItem, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentUnit source;
    protected PersistentFunction myFunction;
    protected PersistentConversion This;
    protected PersistentMModelItem myCONCMModelItem;
    
    public Conversion(PersistentUnit source,PersistentFunction myFunction,PersistentConversion This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.source = source;
        this.myFunction = myFunction;
        if (This != null && !(this.equals(This))) this.This = This;
        this.myCONCMModelItem = myCONCMModelItem;        
    }
    
    static public long getTypeId() {
        return 179;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 179) ConnectionHandler.getTheConnectionHandler().theConversionFacade
            .newConversion(this.getId());
        super.store();
        if(this.getSource() != null){
            this.getSource().store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.sourceSet(this.getId(), getSource());
        }
        if(this.getMyFunction() != null){
            this.getMyFunction().store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.myFunctionSet(this.getId(), getMyFunction());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.ThisSet(this.getId(), getThis());
        }
        if(this.getMyCONCMModelItem() != null){
            this.getMyCONCMModelItem().store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
        }
        
    }
    
    public PersistentUnit getSource() throws PersistenceException {
        return this.source;
    }
    public void setSource(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.source)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.source = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.sourceSet(this.getId(), newValue);
        }
    }
    public PersistentFunction getMyFunction() throws PersistenceException {
        return this.myFunction;
    }
    public void setMyFunction(PersistentFunction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.myFunction)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myFunction = (PersistentFunction)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.myFunctionSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentConversion newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentConversion)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMModelItem getMyCONCMModelItem() throws PersistenceException {
        return this.myCONCMModelItem;
    }
    public void setMyCONCMModelItem(PersistentMModelItem newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.myCONCMModelItem)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCONCMModelItem = (PersistentMModelItem)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.myCONCMModelItemSet(this.getId(), newValue);
        }
    }
    public PersistentConversion getThis() throws PersistenceException {
        if(this.This == null){
            PersistentConversion result = new ConversionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentConversion)this.This;
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCONCMModelItem().delete$Me();
    }
    
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleConversion(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleConversion(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleConversion(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleConversion(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleConversion(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleConversion(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleConversion(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleConversion(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMyFunction() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentConversion)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentConversion)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setSource((PersistentUnit)final$$Fields.get("source"));
			this.setMyFunction((PersistentFunction)final$$Fields.get("myFunction"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public common.Fraction convertFromDefault(final common.Fraction amount) 
				throws PersistenceException{
		return this.getThis().getMyFunction().execute(amount);

	}
    public common.Fraction convertToDefault(final common.Fraction amount) 
				throws PersistenceException{
		return this.getThis().getMyFunction().executeInverse(amount);
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		// TODO Check delegation to abstract class and overwrite if necessary!
		this.getMyCONCMModelItem().delete();
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
    public void initializeOnCreation() 
				throws PersistenceException{
		// implement method: initializeOnCreation

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
