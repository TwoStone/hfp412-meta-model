package model.typeSystem;

import model.CycleException;
import model.UserException;
import model.visitor.*;
import persistence.*;

/* Additional import section end */

public class MSumType extends model.typeSystem.MNonEmptySumType implements PersistentMSumType{
    
    
    public static PersistentMSumType createMSumType() throws PersistenceException{
        return createMSumType(false);
    }
    
    public static PersistentMSumType createMSumType(boolean delayed$Persistence) throws PersistenceException {
        PersistentMSumType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
                .newDelayedMSumType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
                .newMSumType(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMSumType createMSumType(boolean delayed$Persistence,PersistentMSumType This) throws PersistenceException {
        PersistentMSumType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
                .newDelayedMSumType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
                .newMSumType(-1);
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
            result.put("addends", this.getAddends().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MSumType provideCopy() throws PersistenceException{
        MSumType result = this;
        result = new MSumType(this.This, 
                              this.getId());
        result.addends = this.addends.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected MSumType_AddendsProxi addends;
    
    public MSumType(PersistentMType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,id);
        this.addends = new MSumType_AddendsProxi(this);        
    }
    
    static public long getTypeId() {
        return 144;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 144) ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
            .newMSumType(this.getId());
        super.store();
        this.getAddends().store();
        
    }
    
    public MSumType_AddendsProxi getAddends() throws PersistenceException {
        return this.addends;
    }
    public PersistentMSumType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMSumType result = new MSumTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMSumType)this.This;
    }
    
    public void accept(MNonEmptySumTypeVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MNonEmptySumTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MNonEmptySumTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MNonEmptySumTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(MAbstractSumTypeVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MAbstractSumTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MAbstractSumTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MAbstractSumTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getContainedTypes().getLength()
            + this.getAddends().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator iterator0 = getThis().getAddends().iterator();
		while(iterator0.hasNext())
			if(((MComplexTypeHierarchyHIERARCHY)iterator0.next()).containsMComplexTypeHierarchy(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMSumType)This);
		if(this.equals(This)){
		}
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$addends$$MSumType = strategy.initialize$$MSumType$$addends(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getAddends().iterator();
		while (iterator$$.hasNext()){
			PersistentMType current$$Field = (PersistentMType)iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$addends$$MSumType, strategy);
			result$$addends$$MSumType = strategy.consolidate$$MSumType$$addends(getThis(), result$$addends$$MSumType, current$$);
		}
		return strategy.finalize$$MSumType(getThis(), parameter,result$$addends$$MSumType);
    }
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
		return getThis().fetchDisjunctiveNormalform().isLessOrEqual(other);
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public PersistentMDisjunctiveNF fetchDisjunctiveNormalform() 
				throws PersistenceException{
		final PersistentMDisjunctiveNF result = MDisjunctiveNF.createMDisjunctiveNF(true);
		try {
			getThis().getAddends().applyToAllException(new ProcdureException<PersistentMType, CycleException>() {

				@Override
				public void doItTo(PersistentMType argument) throws PersistenceException, CycleException {
					PersistentMDisjunctiveNF dnf = argument.fetchDisjunctiveNormalform();
					dnf.getAddends().applyToAllException(
							new ProcdureException<PersistentMAtomicTypeProduct, CycleException>() {

								@Override
								public void doItTo(PersistentMAtomicTypeProduct argument) throws PersistenceException,
										CycleException {
									result.getAddends().add(argument);
								}

							});
				}
			});
		} catch (CycleException e) {
			// TODO Exception behandeln. Was m??ssen wir dann hier eigentlich machen?
			e.printStackTrace();
		}
		return result;
	}
    public PersistentMAbstractSumType fetchDisjunctiveNormalform_old() 
				throws PersistenceException{
		final PersistentMSumType sumType = MSumType.createMSumType(true);

		try {
			this.getThis().getContainedTypes()
					.applyToAllException(new ProcdureException<PersistentMType, CycleException>() {

						@Override
						public void doItTo(PersistentMType argument) throws PersistenceException, CycleException {
							PersistentMAbstractSumType dnf = argument.fetchDisjunctiveNormalform();
							dnf.getContainedTypes().applyToAllException(
									new ProcdureException<PersistentMType, CycleException>() {

										@Override
										public void doItTo(PersistentMType product) throws PersistenceException,
												CycleException {
											sumType.getContainedTypes().add(product);
										}
									});
						}
					});
		} catch (CycleException e) {
			// TODO Exception behandeln. Was m??ssen wir dann hier eigentlich machen?
			e.printStackTrace();
		}

		return sumType;
	}
    public MTypeSearchList getContainedTypes() 
				throws PersistenceException{
		final MTypeSearchList result = new MTypeSearchList();
		getThis().getAddends().applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				result.add(argument);
			}
		});
		return result;
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
