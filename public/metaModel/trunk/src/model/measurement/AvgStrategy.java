
package model.measurement;

import persistence.*;
import model.UserException;
import model.visitor.*;


/* Additional import section end */

public class AvgStrategy extends PersistentObject implements PersistentAvgStrategy{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAvgStrategy getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAvgStrategyFacade.getClass(objectId);
        return (PersistentAvgStrategy)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAvgStrategy createAvgStrategy() throws PersistenceException{
        return createAvgStrategy(false);
    }
    
    public static PersistentAvgStrategy createAvgStrategy(boolean delayed$Persistence) throws PersistenceException {
        PersistentAvgStrategy result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAvgStrategyFacade
                .newDelayedAvgStrategy();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAvgStrategyFacade
                .newAvgStrategy(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentAvgStrategy createAvgStrategy(boolean delayed$Persistence,PersistentAvgStrategy This) throws PersistenceException {
        PersistentAvgStrategy result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAvgStrategyFacade
                .newDelayedAvgStrategy();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAvgStrategyFacade
                .newAvgStrategy(-1);
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
    
    public AvgStrategy provideCopy() throws PersistenceException{
        AvgStrategy result = this;
        result = new AvgStrategy(this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAvgStrategy This;
    
    public AvgStrategy(PersistentAvgStrategy This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 294;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 294) ConnectionHandler.getTheConnectionHandler().theAvgStrategyFacade
            .newAvgStrategy(this.getId());
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAvgStrategyFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    protected void setThis(PersistentAvgStrategy newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAvgStrategy)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAvgStrategyFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAvgStrategy getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAvgStrategy result = new AvgStrategyProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAvgStrategy)this.This;
    }
    
    public void accept(AggregationStrategyVisitor visitor) throws PersistenceException {
        visitor.handleAvgStrategy(this);
    }
    public <R> R accept(AggregationStrategyReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAvgStrategy(this);
    }
    public <E extends UserException>  void accept(AggregationStrategyExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAvgStrategy(this);
    }
    public <R, E extends UserException> R accept(AggregationStrategyReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAvgStrategy(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAvgStrategy(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAvgStrategy(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAvgStrategy(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAvgStrategy(this);
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
        this.setThis((PersistentAvgStrategy)This);
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
