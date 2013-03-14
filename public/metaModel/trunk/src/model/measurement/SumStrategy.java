package model.measurement;

import model.NotComputableException;
import model.UserException;
import model.quantity.QuantityManager;
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
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAggregationStrategy;
import persistence.PersistentMeasurement;
import persistence.PersistentSumStrategy;
import persistence.SumStrategyProxi;
import persistence.TDObserver;

import common.Fraction;

/* Additional import section end */

public class SumStrategy extends model.measurement.AggregationStrategy implements PersistentSumStrategy{
    
    private static PersistentSumStrategy theSumStrategy = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentSumStrategy getTheSumStrategy() throws PersistenceException{
        if (theSumStrategy == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        SumStrategyProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theSumStrategyFacade.getTheSumStrategy();
                            theSumStrategy = proxi;
                        }
                        if(proxi.getId() < 0) {
                            proxi.setId(proxi.getId() * -1);
                            proxi.initialize(proxi, new java.util.Hashtable<String,Object>());
                            proxi.initializeOnCreation();
                        }
                    } catch (PersistenceException e){
                        exception = e;
                    }
                    synchronized ($$lock){$$lock.notify();}
                }
                PersistentSumStrategy getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theSumStrategy;
                }
            }
            synchronized ($$lock) {
                reset$For$Test = false;
                Initializer initializer = new Initializer();
                new Thread(initializer).start();
                try {$$lock.wait();}catch (InterruptedException e) {} //Need not to be interrupted
                return initializer.getResult();
            }
        }
        return theSumStrategy;
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
    
    public SumStrategy(PersistentAggregationStrategy This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAggregationStrategy)This,id);        
    }
    
    static public long getTypeId() {
        return 295;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
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
    
    public PersistentAbsQuantity aggregateMeasurements(final PersistentAbsUnitType defaultUnitType, final MeasurementSearchList measurements) 
				throws model.ConsistencyException, model.NotComputableException, PersistenceException{
		final PersistentAbsUnit defaultUnit = defaultUnitType.fetchDefaultUnit();
		return measurements.aggregateException(new AggregtionException<PersistentMeasurement, PersistentAbsQuantity, NotComputableException>() {
			@Override
			public PersistentAbsQuantity neutral() throws PersistenceException, NotComputableException {
				return QuantityManager.getTheQuantityManager().createQuantity(defaultUnit, Fraction.Null);
			}

			@Override
			public PersistentAbsQuantity compose(final PersistentAbsQuantity result, final PersistentMeasurement argument)
					throws PersistenceException, NotComputableException {
				return QuantityManager.getTheQuantityManager().add(result, argument.getQuantity());
			}
		});
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
