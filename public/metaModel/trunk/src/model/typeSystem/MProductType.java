package model.typeSystem;

import java.util.Iterator;
import java.util.List;

import model.CycleException;
import model.UserException;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.*;
import persistence.*;
import utils.Lists;

/* Additional import section end */

public class MProductType extends model.typeSystem.MNonEmptyProductType implements PersistentMProductType{
    
    
    public static PersistentMProductType createMProductType() throws PersistenceException{
        return createMProductType(false);
    }
    
    public static PersistentMProductType createMProductType(boolean delayed$Persistence) throws PersistenceException {
        PersistentMProductType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
                .newDelayedMProductType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
                .newMProductType(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMProductType createMProductType(boolean delayed$Persistence,PersistentMProductType This) throws PersistenceException {
        PersistentMProductType result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
                .newDelayedMProductType();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
                .newMProductType(-1);
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
            result.put("factors", this.getFactors().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MProductType provideCopy() throws PersistenceException{
        MProductType result = this;
        result = new MProductType(this.This, 
                                  this.getId());
        result.factors = this.factors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected MProductType_FactorsProxi factors;
    
    public MProductType(PersistentMType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentMType)This,id);
        this.factors = new MProductType_FactorsProxi(this);        
    }
    
    static public long getTypeId() {
        return 115;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 115) ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
            .newMProductType(this.getId());
        super.store();
        this.getFactors().store();
        
    }
    
    public MProductType_FactorsProxi getFactors() throws PersistenceException {
        return this.factors;
    }
    public PersistentMProductType getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMProductType result = new MProductTypeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMProductType)this.This;
    }
    
    public void accept(MNonEmptyProductTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MNonEmptyProductTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MNonEmptyProductTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MNonEmptyProductTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(MAbstractProductTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MAbstractProductTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MAbstractProductTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MAbstractProductTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getContainedTypes().getLength()
            + this.getFactors().getLength());
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
		java.util.Iterator iterator0 = getThis().getFactors().iterator();
		while(iterator0.hasNext())
			if(((MComplexTypeHierarchyHIERARCHY)iterator0.next()).containsMComplexTypeHierarchy(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMProductType)This);
		if(this.equals(This)){
		}
    }
    public PersistentMBoolean isLessOrEqual(final PersistentMType other) 
				throws PersistenceException{
		return getThis().fetchDisjunctiveNormalform().isLessOrEqual(other);
	}
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$factors$$MProductType = strategy.initialize$$MProductType$$factors(getThis(), parameter);
		java.util.Iterator iterator$$ = getThis().getFactors().iterator();
		while (iterator$$.hasNext()){
			PersistentMType current$$Field = (PersistentMType)iterator$$.next();
			T current$$ = current$$Field.strategyMComplexTypeHierarchy(result$$factors$$MProductType, strategy);
			result$$factors$$MProductType = strategy.consolidate$$MProductType$$factors(getThis(), result$$factors$$MProductType, current$$);
		}
		return strategy.finalize$$MProductType(getThis(), parameter,result$$factors$$MProductType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public PersistentMDisjunctiveNF fetchDisjunctiveNormalform() 
				throws PersistenceException{
		// TODO: implement method: fetchDisjunctiveNormalform
		PersistentMDisjunctiveNF resultingDnf = MDisjunctiveNF.createMDisjunctiveNF(true);
		final List<PersistentMDisjunctiveNF> dnfsOfChildren = Lists.newArrayList();

		getThis().getFactors().applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				dnfsOfChildren.add(argument.fetchDisjunctiveNormalform());
			}
		});

		Iterator<PersistentMDisjunctiveNF> dnfI = dnfsOfChildren.iterator();

		if (dnfI.hasNext()) {
			resultingDnf = dnfI.next();
		}
		while (dnfI.hasNext()) {
			resultingDnf = resultingDnf.transientMultiply(dnfI.next());
		}
		return resultingDnf;

	}
    public PersistentMAbstractSumType fetchDisjunctiveNormalform_old() 
				throws PersistenceException{
		final PersistentMSumType sumType = MSumType.createMSumType(true);
		final List<PersistentMAbstractSumType> dnfsOfChildren = Lists.newArrayList();
		this.getThis().getContainedTypes().applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				PersistentMAbstractSumType dnf = argument.fetchDisjunctiveNormalform();
				dnfsOfChildren.add(dnf);
			}
		});

		try {
			List<PersistentMProductType> products = createProducts(dnfsOfChildren);
			for (PersistentMProductType summands : products) {

				sumType.getContainedTypes().add(summands);
			}
		} catch (CycleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sumType;
	}
    public MTypeSearchList getContainedTypes() 
				throws PersistenceException{
		final MTypeSearchList result = new MTypeSearchList();
		getThis().getFactors().applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				result.add(argument);
			}
		});
		return result;
	}
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
		Iterator<PersistentMType> i = getThis().getContainedTypes().iterator();

		while (i.hasNext()) {
			if (!i.next().isSingleton().toBoolean()) {
				return MFalse.getTheMFalse();
			}
		}

		return MTrue.getTheMTrue();
	}
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
		Iterator<PersistentMType> i = getThis().getContainedTypes().iterator();
		while (i.hasNext()) {
			if (i.next().isAbstract().toBoolean()) {
				return MTrue.getTheMTrue();
			}
		}

		return MFalse.getTheMFalse();

	}

    /* Start of protected part that is not overridden by persistence generator */

	private List<PersistentMProductType> createProducts(List<PersistentMAbstractSumType> dnfs)
			throws PersistenceException, CycleException {
		List<PersistentMProductType> products = Lists.newArrayList();

		for (PersistentMAbstractSumType currentSum : dnfs) {
			List<List<PersistentMAtomicType>> atomicTypes = getAtomicTypes(currentSum);
			if (products.isEmpty()) {
				products.addAll(createInitialProducts(atomicTypes));
			} else {
				products = multiplyProducts(products, atomicTypes);
			}
		}

		return products;
	}

	private List<PersistentMProductType> multiplyProducts(List<PersistentMProductType> products,
			List<List<PersistentMAtomicType>> atomicTypes) throws CycleException, PersistenceException {
		List<PersistentMProductType> result = Lists.newArrayList();

		for (List<PersistentMAtomicType> summand : atomicTypes) {
			for (PersistentMProductType product : products) {
				result.add(newProduct(product, summand));
			}
		}

		return result;
	}

	private List<PersistentMProductType> createInitialProducts(List<List<PersistentMAtomicType>> atomicTypes)
			throws CycleException, PersistenceException {
		List<PersistentMProductType> products = Lists.newArrayList();

		for (List<PersistentMAtomicType> list : atomicTypes) {
			products.add(createProduct(list));
		}

		return products;
	}

	private PersistentMProductType createProduct(List<PersistentMAtomicType> list) throws PersistenceException,
			CycleException {
		PersistentMProductType product = MProductType.createMProductType(true);
		for (PersistentMAtomicType persistentMAtomicType : list) {
			product.getContainedTypes().add(persistentMAtomicType);
		}

		return product;
	}

	private PersistentMProductType newProduct(PersistentMProductType prototype, List<PersistentMAtomicType> summand)
			throws PersistenceException, CycleException {
		final PersistentMProductType product = MProductType.createMProductType(true);
		prototype.getContainedTypes().applyToAllException(new ProcdureException<PersistentMType, CycleException>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException, CycleException {
				product.getContainedTypes().add(argument);
			}
		});

		for (PersistentMAtomicType atomicType : summand) {
			product.getContainedTypes().add(atomicType);
		}

		return product;
	}

	private List<List<PersistentMAtomicType>> getAtomicTypes(PersistentMAbstractSumType childDnf)
			throws PersistenceException {
		final List<List<PersistentMAtomicType>> atomicTypes = Lists.newArrayList();
		childDnf.getContainedTypes().applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				// Level 2 - All summands are products
				atomicTypes.add(getAtomicTypes((PersistentMProductType) argument));
			}
		});
		return atomicTypes;
	}

	private List<PersistentMAtomicType> getAtomicTypes(PersistentMProductType dnf) throws PersistenceException {
		final List<PersistentMAtomicType> atomicTypes = Lists.newArrayList();
		dnf.getContainedTypes().applyToAll(new Procdure<PersistentMType>() {

			@Override
			public void doItTo(PersistentMType argument) throws PersistenceException {
				// Level 3 - All factors are atomic types
				atomicTypes.add((PersistentMAtomicType) argument);
			}
		});
		return atomicTypes;
	}
	/*
	 * private List<PersistentMAtomicTypeProduct> createAtomicTypeProducts(List<PersistentMDisjuncitveNF> dnfs) {
	 * List<PersistentMAtomicTypeProduct> products = Lists.newArrayList();
	 * 
	 * for (PersistentMDisjuncitveNF currentDnf : dnfs) { List<PersistentMAtomicTypeProduct> atomicTypepProductsInDnf =
	 * fetchAtomicTypeProducts(currentDnf);
	 * 
	 * if (products.isEmpty()) { products.addAll(atomicTypepProductsInDnf); } else { products =
	 * multiplyAtomicTypeProducts(products, atomicTypepProductsInDnf); } }
	 * 
	 * return products; }
	 */
	/*
	 * private List<PersistentMAtomicTypeProduct> multiplyAtomicTypeProducts(List<PersistentMAtomicTypeProduct>
	 * products, List<PersistentMAtomicTypeProduct> atomicTypepProductsInDnf) {
	 * 
	 * // TODO Auto-generated method stub return null; }
	 * 
	 * private List<PersistentMAtomicTypeProduct> fetchAtomicTypeProducts(PersistentMDisjuncitveNF currentDnf) throws
	 * PersistenceException { final List<PersistentMAtomicTypeProduct> result = Lists.newArrayList();
	 * currentDnf.getAddends().applyToAll(new Procdure<PersistentMAtomicTypeProduct>() {
	 * 
	 * @Override public void doItTo(PersistentMAtomicTypeProduct argument) throws PersistenceException {
	 * result.add(argument); } }); return result; }
	 */

	/* End of protected part that is not overridden by persistence generator */
    
}
