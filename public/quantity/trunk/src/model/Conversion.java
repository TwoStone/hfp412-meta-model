
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Conversion extends PersistentObject implements PersistentConversion{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentConversion getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theConversionFacade.getClass(objectId);
        return (PersistentConversion)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentConversion createConversion() throws PersistenceException{
        return createConversion(false);
    }
    
    public static PersistentConversion createConversion(boolean delayed$Persistence) throws PersistenceException {
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
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentConversion createConversion(boolean delayed$Persistence,PersistentConversion This) throws PersistenceException {
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
            AbstractPersistentRoot target = (AbstractPersistentRoot)this.getTarget();
            if (target != null) {
                result.put("target", target.createProxiInformation(false));
                if(depth > 1) {
                    target.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && target.hasEssentialFields())target.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot convFunction = (AbstractPersistentRoot)this.getConvFunction();
            if (convFunction != null) {
                result.put("convFunction", convFunction.createProxiInformation(false));
                if(depth > 1) {
                    convFunction.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && convFunction.hasEssentialFields())convFunction.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
                                this.target, 
                                this.convFunction, 
                                this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentUnit source;
    protected PersistentUnit target;
    protected PersistentFunction convFunction;
    protected PersistentConversion This;
    
    public Conversion(PersistentUnit source,PersistentUnit target,PersistentFunction convFunction,PersistentConversion This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.source = source;
        this.target = target;
        this.convFunction = convFunction;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 116) ConnectionHandler.getTheConnectionHandler().theConversionFacade
            .newConversion(this.getId());
        super.store();
        if(this.getSource() != null){
            this.getSource().store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.sourceSet(this.getId(), getSource());
        }
        if(this.getTarget() != null){
            this.getTarget().store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.targetSet(this.getId(), getTarget());
        }
        if(this.getConvFunction() != null){
            this.getConvFunction().store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.convFunctionSet(this.getId(), getConvFunction());
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
    public PersistentUnit getTarget() throws PersistenceException {
        return this.target;
    }
    public void setTarget(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.target)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.target = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.targetSet(this.getId(), newValue);
        }
    }
    public PersistentFunction getConvFunction() throws PersistenceException {
        return this.convFunction;
    }
    public void setConvFunction(PersistentFunction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.convFunction)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.convFunction = (PersistentFunction)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theConversionFacade.convFunctionSet(this.getId(), newValue);
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
            + (this.getTarget() == null ? 0 : 1)
            + (this.getConvFunction() == null ? 0 : 1));
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentConversion)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
