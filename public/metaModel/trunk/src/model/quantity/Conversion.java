package model.quantity;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ConversionProxi;
import persistence.PersistenceException;
import persistence.PersistentConversion;
import persistence.PersistentFunction;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.TDObserver;

import common.Fraction;

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
                result.put("source", source.createProxiInformation(false));
                if(depth > 1) {
                    source.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && source.hasEssentialFields())source.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot myFunction = (AbstractPersistentRoot)this.getMyFunction();
            if (myFunction != null) {
                result.put("myFunction", myFunction.createProxiInformation(false));
                if(depth > 1) {
                    myFunction.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && myFunction.hasEssentialFields())myFunction.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentUnit source;
    protected PersistentFunction myFunction;
    protected PersistentConversion This;
    
    public Conversion(PersistentUnit source,PersistentFunction myFunction,PersistentConversion This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.source = source;
        this.myFunction = myFunction;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 164;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 164) ConnectionHandler.getTheConnectionHandler().theConversionFacade
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
    public PersistentConversion getThis() throws PersistenceException {
        if(this.This == null){
            PersistentConversion result = new ConversionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentConversion)this.This;
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
        return (int) (0 
            + (this.getSource() == null ? 0 : 1)
            + (this.getMyFunction() == null ? 0 : 1));
    }
    
    
    public PersistentQuantity convert(final common.Fraction amount) 
				throws PersistenceException{
		Fraction convertedAmount = this.getThis().getMyFunction().execute(amount);
		// TODO: Quantity mit QuantityManager erstellen?
		return Quantity.createQuantity(convertedAmount,
				((PersistentUnitType) this.getThis().getSource().getType()).getDefaultUnit());
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// implement method: initializeOnInstantiation

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// implement method: copyingPrivateUserAttributes

	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentConversion)This);
		if(this.equals(This)){
			this.setSource((PersistentUnit)final$$Fields.get("source"));
			this.setMyFunction((PersistentFunction)final$$Fields.get("myFunction"));
		}
    }
    public PersistentQuantity convertInverse(final common.Fraction amount) 
				throws PersistenceException{
		Fraction convertedAmount = this.getThis().getMyFunction().executeInverse(amount);
		// TODO: Quantity mit QuantityManager erstellen?
		return Quantity.createQuantity(convertedAmount, this.getThis().getSource());
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// implement method: initializeOnCreation

	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
