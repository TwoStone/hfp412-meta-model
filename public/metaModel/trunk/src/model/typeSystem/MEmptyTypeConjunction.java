package model.typeSystem;

import model.ConsistencyException;
import model.UserException;
import model.basic.MBoolean;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MAbstractTypeConjunctionExceptionVisitor;
import model.visitor.MAbstractTypeConjunctionReturnExceptionVisitor;
import model.visitor.MAbstractTypeConjunctionReturnVisitor;
import model.visitor.MAbstractTypeConjunctionVisitor;
import model.visitor.MAtomicTypeConjunctionExceptionVisitor;
import model.visitor.MAtomicTypeConjunctionReturnExceptionVisitor;
import model.visitor.MAtomicTypeConjunctionReturnVisitor;
import model.visitor.MAtomicTypeConjunctionVisitor;
import model.visitor.MComplexTypeExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYVisitor;
import model.visitor.MComplexTypeReturnExceptionVisitor;
import model.visitor.MComplexTypeReturnVisitor;
import model.visitor.MComplexTypeVisitor;
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
import persistence.MEmptyTypeConjunctionProxi;
import persistence.MModelItemSearchList;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAtomicTypeConjunction;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.SearchListRoot;
import persistence.TDObserver;

/* Additional import section end */

public class MEmptyTypeConjunction extends model.typeSystem.MAtomicTypeConjunction implements PersistentMEmptyTypeConjunction{
    
    private static PersistentMEmptyTypeConjunction theMEmptyTypeConjunction = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentMEmptyTypeConjunction getTheMEmptyTypeConjunction() throws PersistenceException{
        if (theMEmptyTypeConjunction == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        MEmptyTypeConjunctionProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theMEmptyTypeConjunctionFacade.getTheMEmptyTypeConjunction();
                            theMEmptyTypeConjunction = proxi;
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
                PersistentMEmptyTypeConjunction getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theMEmptyTypeConjunction;
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
        return theMEmptyTypeConjunction;
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
    
    public MEmptyTypeConjunction provideCopy() throws PersistenceException{
        MEmptyTypeConjunction result = this;
        result = new MEmptyTypeConjunction(this.This, 
                                           this.myCONCMModelItem, 
                                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    
    public MEmptyTypeConjunction(PersistentMType This,PersistentMModelItem myCONCMModelItem,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,(PersistentMModelItem)myCONCMModelItem,id);        
    }
    
    static public long getTypeId() {
        return 310;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentMEmptyTypeConjunction getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMEmptyTypeConjunction result = new MEmptyTypeConjunctionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMEmptyTypeConjunction)this.This;
    }
    
    public void accept(MAtomicTypeConjunctionVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeConjunction(this);
    }
    public <R> R accept(MAtomicTypeConjunctionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MAtomicTypeConjunctionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MAtomicTypeConjunctionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public void accept(MAbstractTypeConjunctionVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeConjunction(this);
    }
    public <R> R accept(MAbstractTypeConjunctionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MAbstractTypeConjunctionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MAbstractTypeConjunctionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeConjunction(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeConjunction(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public void accept(MModelItemVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeConjunction(this);
    }
    public <R> R accept(MModelItemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MModelItemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeConjunction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyTypeConjunction(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyTypeConjunction(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyTypeConjunction(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getDependentItems().getLength()
            + this.getContainedTypes().getLength());
    }
    
    
    public MModelItemSearchList getDependentItems(final TDObserver observer) 
				throws PersistenceException{
        MModelItemSearchList result = getThis().getDependentItems();
		observer.updateTransientDerived(getThis(), "dependentItems", result);
		return result;
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public MModelItemSearchList getDependentItems() 
				throws PersistenceException{
		// TODO: implement method: getDependentItems
		try {
			throw new java.lang.UnsupportedOperationException("Method \"getDependentItems\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

	}
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMEmptyTypeConjunction)This);
		if(this.equals(This)){
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(), (PersistentMEmptyTypeConjunction)This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
    }
    public void prepareForDeletion() 
				throws model.ConsistencyException, PersistenceException{
	}
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return strategy.finalize$$MEmptyTypeConjunction(getThis(), parameter);
    }
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
		return MBoolean.createFromBoolean(getThis().equals(other));
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public PersistentMDisjunctiveNormalForm fetchDisjunctiveNormalform() 
				throws PersistenceException{
		return MNonEmptyDisjunctiveNormalForm.transientCreateDNFFromAtomicTypeConjunction(getThis());
	}
    public void delete() 
				throws model.ConsistencyException, PersistenceException{
		throw new ConsistencyException("The Anything may not be deleted.");
	}
    public String fetchName() 
				throws PersistenceException{
		return "Anything";
	}

    /* Start of protected part that is not overridden by persistence generator */
	@Override
	public SearchListRoot<? extends PersistentMType> fetchContainedTypes() {
		return new MTypeSearchList();
	}

	@Override
	public PersistentMAtomicTypeConjunction transientMultiply(PersistentMAtomicTypeConjunction other)
			throws PersistenceException {
		return other;
	}

	/* End of protected part that is not overridden by persistence generator */
    
}
