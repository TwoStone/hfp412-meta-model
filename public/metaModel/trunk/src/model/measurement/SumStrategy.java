package model.measurement;

import model.NotComputableException;
import model.UserException;
import model.visitor.AggregationStrategyExceptionVisitor;
import model.visitor.AggregationStrategyReturnExceptionVisitor;
import model.visitor.AggregationStrategyReturnVisitor;
import model.visitor.AggregationStrategyVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AggregtionException;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MeasurementSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentMeasurement;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentSumStrategy;
import persistence.SumStrategyProxi;
import persistence.TDObserver;

/* Additional import section end */

public class SumStrategy extends PersistentObject implements PersistentSumStrategy{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentSumStrategy getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theSumStrategyFacade.getClass(objectId);
        return (PersistentSumStrategy)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentSumStrategy createSumStrategy() throws PersistenceException{
        return createSumStrategy(false);
    }
    
    public static PersistentSumStrategy createSumStrategy(boolean delayed$Persistence) throws PersistenceException {
        PersistentSumStrategy result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theSumStrategyFacade
                .newDelayedSumStrategy();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theSumStrategyFacade
                .newSumStrategy(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentSumStrategy createSumStrategy(boolean delayed$Persistence,PersistentSumStrategy This) throws PersistenceException {
        PersistentSumStrategy result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theSumStrategyFacade
                .newDelayedSumStrategy();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theSumStrategyFacade
                .newSumStrategy(-1);
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
    
    public SumStrategy provideCopy() throws PersistenceException{
        SumStrategy result = this;
        result = new SumStrategy(this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentSumStrategy This;
    
    public SumStrategy(PersistentSumStrategy This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 295;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 295) ConnectionHandler.getTheConnectionHandler().theSumStrategyFacade
            .newSumStrategy(this.getId());
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theSumStrategyFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    protected void setThis(PersistentSumStrategy newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentSumStrategy)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theSumStrategyFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentSumStrategy getThis() throws PersistenceException {
        if(this.This == null){
            PersistentSumStrategy result = new SumStrategyProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentSumStrategy)this.This;
    }
    
    public void accept(AggregationStrategyVisitor visitor) throws PersistenceException {
        visitor.handleSumStrategy(this);
    }
    public <R> R accept(AggregationStrategyReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSumStrategy(this);
    }
    public <E extends UserException>  void accept(AggregationStrategyExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSumStrategy(this);
    }
    public <R, E extends UserException> R accept(AggregationStrategyReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSumStrategy(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSumStrategy(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSumStrategy(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSumStrategy(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSumStrategy(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentSumStrategy)This);
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public PersistentAbsQuantity aggregateMeasurements(final PersistentAbsQuantity neutralElement, final MeasurementSearchList measurements) 
				throws model.NotComputableException, PersistenceException{

		return measurements
				.aggregateException(new AggregtionException<PersistentMeasurement, PersistentAbsQuantity, NotComputableException>() {

					@Override
					public PersistentAbsQuantity neutral() throws PersistenceException, NotComputableException {
						return neutralElement;
					}

					@Override
					public PersistentAbsQuantity compose(final PersistentAbsQuantity result,
							final PersistentMeasurement argument) throws PersistenceException, NotComputableException {
						return result.add(argument.getQuantity());
					}

				});
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

	}
    public void initializeOnCreation() 
				throws PersistenceException{

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{

	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
