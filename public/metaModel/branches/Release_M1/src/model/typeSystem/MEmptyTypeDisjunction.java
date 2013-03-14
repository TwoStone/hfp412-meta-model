package model.typeSystem;

import model.ConsistencyException;
import model.UserException;
import model.basic.MTrue;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MAbstractTypeDisjunctionExceptionVisitor;
import model.visitor.MAbstractTypeDisjunctionReturnExceptionVisitor;
import model.visitor.MAbstractTypeDisjunctionReturnVisitor;
import model.visitor.MAbstractTypeDisjunctionVisitor;
import model.visitor.MComplexTypeExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYVisitor;
import model.visitor.MComplexTypeReturnExceptionVisitor;
import model.visitor.MComplexTypeReturnVisitor;
import model.visitor.MComplexTypeVisitor;
import model.visitor.MDisjunctiveNormalFormExceptionVisitor;
import model.visitor.MDisjunctiveNormalFormReturnExceptionVisitor;
import model.visitor.MDisjunctiveNormalFormReturnVisitor;
import model.visitor.MDisjunctiveNormalFormVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import model.visitor.MTypeExceptionVisitor;
import model.visitor.MTypeReturnExceptionVisitor;
import model.visitor.MTypeReturnVisitor;
import model.visitor.MTypeVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MEmptyTypeDisjunctionProxi;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.SearchListRoot;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public class MEmptyTypeDisjunction extends model.typeSystem.MDisjunctiveNormalForm implements PersistentMEmptyTypeDisjunction{
    
    private static PersistentMEmptyTypeDisjunction theMEmptyTypeDisjunction = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentMEmptyTypeDisjunction getTheMEmptyTypeDisjunction() throws PersistenceException{
        if (theMEmptyTypeDisjunction == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        MEmptyTypeDisjunctionProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theMEmptyTypeDisjunctionFacade.getTheMEmptyTypeDisjunction();
                            theMEmptyTypeDisjunction = proxi;
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
                PersistentMEmptyTypeDisjunction getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theMEmptyTypeDisjunction;
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
        return theMEmptyTypeDisjunction;
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
    
    public MEmptyTypeDisjunction provideCopy() throws PersistenceException{
        MEmptyTypeDisjunction result = this;
        result = new MEmptyTypeDisjunction(this.This, 
                                           this.myCONCMModelItem, 
                                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    
    public MEmptyTypeDisjunction(PersistentMType This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,(PersistentMModelItem)myCONCMModelItem,id);        
    }
    
    static public long getTypeId() {
        return 307;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentMEmptyTypeDisjunction getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMEmptyTypeDisjunction result = new MEmptyTypeDisjunctionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMEmptyTypeDisjunction)this.This;
    }
    
    public void accept(MDisjunctiveNormalFormVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R> R accept(MDisjunctiveNormalFormReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MDisjunctiveNormalFormExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MDisjunctiveNormalFormReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public void accept(MAbstractTypeDisjunctionVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R> R accept(MAbstractTypeDisjunctionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MAbstractTypeDisjunctionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MAbstractTypeDisjunctionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeDisjunction(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeDisjunction(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMEmptyTypeDisjunction)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMEmptyTypeDisjunction)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return strategy.finalize$$MEmptyTypeDisjunction(getThis(), parameter);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public PersistentMDisjunctiveNormalForm fetchDisjunctiveNormalform() 
				throws PersistenceException{
		return getThis();
	}
    public MTypeSearchList fetchTypesContainingThisDirectly() 
				throws PersistenceException{
		final MTypeSearchList result = new MTypeSearchList();
		SearchLists.addSecondToFirst(result, getThis().getMTCContainingMe());
		SearchLists.addSecondToFirst(result, getThis().getMTDJContainingMe());
		return result;
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
		return MTrue.getTheMTrue();
	}
    public PersistentMDisjunctiveNormalForm transientMultiply(final PersistentMDisjunctiveNormalForm other) 
				throws PersistenceException{
		return getThis();
	}
    
    
    // Start of section that contains overridden operations only.
    
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		throw new ConsistencyException("The Nothing may not be deleted.");
	}
    public String fetchName() 
				throws PersistenceException{
		return "Nothing";
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    

	@Override
	public SearchListRoot<? extends PersistentMType> obtainContainedTypes() {
		return new MTypeSearchList();
	}

	
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}