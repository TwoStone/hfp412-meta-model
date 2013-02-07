
package model.measurement;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class MaxStrategy extends PersistentObject implements PersistentMaxStrategy{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMaxStrategy getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMaxStrategyFacade.getClass(objectId);
        return (PersistentMaxStrategy)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentMaxStrategy createMaxStrategy() throws PersistenceException{
        return createMaxStrategy(false);
    }
    
    public static PersistentMaxStrategy createMaxStrategy(boolean delayed$Persistence) throws PersistenceException {
        PersistentMaxStrategy result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMaxStrategyFacade
                .newDelayedMaxStrategy();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMaxStrategyFacade
                .newMaxStrategy(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMaxStrategy createMaxStrategy(boolean delayed$Persistence,PersistentMaxStrategy This) throws PersistenceException {
        PersistentMaxStrategy result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMaxStrategyFacade
                .newDelayedMaxStrategy();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMaxStrategyFacade
                .newMaxStrategy(-1);
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
    
    public MaxStrategy provideCopy() throws PersistenceException{
        MaxStrategy result = this;
        result = new MaxStrategy(this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMaxStrategy This;
    
    public MaxStrategy(PersistentMaxStrategy This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 296;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 296) ConnectionHandler.getTheConnectionHandler().theMaxStrategyFacade
            .newMaxStrategy(this.getId());
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMaxStrategyFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    protected void setThis(PersistentMaxStrategy newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMaxStrategy)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMaxStrategyFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMaxStrategy getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMaxStrategy result = new MaxStrategyProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMaxStrategy)this.This;
    }
    
    public void accept(AggregationStrategyVisitor visitor) throws PersistenceException {
        visitor.handleMaxStrategy(this);
    }
    public <R> R accept(AggregationStrategyReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMaxStrategy(this);
    }
    public <E extends UserException>  void accept(AggregationStrategyExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMaxStrategy(this);
    }
    public <R, E extends UserException> R accept(AggregationStrategyReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMaxStrategy(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMaxStrategy(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMaxStrategy(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMaxStrategy(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMaxStrategy(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public PersistentQuantity compose(final PersistentQuantity first, final PersistentQuantity second) 
				throws model.NotComputableException, PersistenceException{
        //TODO: implement method: compose
        try{
            throw new java.lang.UnsupportedOperationException("Method \"compose\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
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
        this.setThis((PersistentMaxStrategy)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void compose(final PersistentQuantity first, final PersistentQuantity second, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentComposeCommand command = model.meta.ComposeCommand.createComposeCommand(now, now);
		command.setFirst(first);
		command.setSecond(second);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
