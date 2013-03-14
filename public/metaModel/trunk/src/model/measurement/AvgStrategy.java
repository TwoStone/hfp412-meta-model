package model.measurement;

import java.math.BigInteger;

import model.UserException;
import model.quantity.QuantityManager;
import model.quantity.UnitTypeManager;
import model.visitor.AggregationStrategyExceptionVisitor;
import model.visitor.AggregationStrategyReturnExceptionVisitor;
import model.visitor.AggregationStrategyReturnVisitor;
import model.visitor.AggregationStrategyVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.AvgStrategyProxi;
import persistence.ConnectionHandler;
import persistence.MeasurementSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAggregationStrategy;
import persistence.PersistentAvgStrategy;
import persistence.PersistentQuantity;
import persistence.TDObserver;

import common.Fraction;

/* Additional import section end */

public class AvgStrategy extends model.measurement.AggregationStrategy implements PersistentAvgStrategy{
    
    private static PersistentAvgStrategy theAvgStrategy = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentAvgStrategy getTheAvgStrategy() throws PersistenceException{
        if (theAvgStrategy == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        AvgStrategyProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theAvgStrategyFacade.getTheAvgStrategy();
                            theAvgStrategy = proxi;
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
                PersistentAvgStrategy getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theAvgStrategy;
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
        return theAvgStrategy;
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
    
    public AvgStrategy(PersistentAggregationStrategy This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAggregationStrategy)This,id);        
    }
    
    static public long getTypeId() {
        return 294;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
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
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAvgStrategy)This);
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    
    
    // Start of section that contains overridden operations only.
    
    public PersistentAbsQuantity aggregateMeasurements(final PersistentAbsUnitType defaultUnitType, final MeasurementSearchList measurements) 
				throws model.ConsistencyException, model.NotComputableException, PersistenceException{
		final PersistentAbsQuantity kumulierteSumme = SumStrategy.getTheSumStrategy().aggregateMeasurements(defaultUnitType, measurements);
		final PersistentQuantity numberOfMeasurement = QuantityManager.getTheQuantityManager().createQuantity(
				UnitTypeManager.getTheUnitTypeManager().fetchScalar(), new Fraction(BigInteger.valueOf(measurements.getLength()), BigInteger.ONE));
		return QuantityManager.getTheQuantityManager().div(kumulierteSumme, numberOfMeasurement);
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
