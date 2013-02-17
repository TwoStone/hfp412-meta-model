
package model.measurement;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class MinStrategy extends PersistentObject implements PersistentMinStrategy{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMinStrategy getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMinStrategyFacade.getClass(objectId);
        return (PersistentMinStrategy)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentMinStrategy createMinStrategy() throws PersistenceException{
        return createMinStrategy(false);
    }
    
    public static PersistentMinStrategy createMinStrategy(boolean delayed$Persistence) throws PersistenceException {
        PersistentMinStrategy result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMinStrategyFacade
                .newDelayedMinStrategy();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMinStrategyFacade
                .newMinStrategy(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMinStrategy createMinStrategy(boolean delayed$Persistence,PersistentMinStrategy This) throws PersistenceException {
        PersistentMinStrategy result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMinStrategyFacade
                .newDelayedMinStrategy();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMinStrategyFacade
                .newMinStrategy(-1);
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
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MinStrategy provideCopy() throws PersistenceException{
        MinStrategy result = this;
        result = new MinStrategy(this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMinStrategy This;
    
    public MinStrategy(PersistentMinStrategy This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 292;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 292) ConnectionHandler.getTheConnectionHandler().theMinStrategyFacade
            .newMinStrategy(this.getId());
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMinStrategyFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    protected void setThis(PersistentMinStrategy newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMinStrategy)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMinStrategyFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMinStrategy getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMinStrategy result = new MinStrategyProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMinStrategy)this.This;
    }
    
    public void accept(AggregationStrategyVisitor visitor) throws PersistenceException {
        visitor.handleMinStrategy(this);
    }
    public <R> R accept(AggregationStrategyReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMinStrategy(this);
    }
    public <E extends UserException>  void accept(AggregationStrategyExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMinStrategy(this);
    }
    public <R, E extends UserException> R accept(AggregationStrategyReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMinStrategy(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMinStrategy(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMinStrategy(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMinStrategy(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMinStrategy(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public PersistentAbsQuantity aggregateMeasurements(final MeasurementSearchList measurements) 
				throws PersistenceException{
        //TODO: implement method: aggregateMeasurements
        try{
            throw new java.lang.UnsupportedOperationException("Method \"aggregateMeasurements\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMinStrategy)This);
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
