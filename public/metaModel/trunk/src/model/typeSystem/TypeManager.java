package model.typeSystem;

import model.ConsistencyException;
import model.CycleException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.*;

/* Additional import section end */

public class TypeManager extends PersistentObject implements PersistentTypeManager{
    
    private static PersistentTypeManager theTypeManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentTypeManager getTheTypeManager() throws PersistenceException{
        if (theTypeManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        TypeManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade.getTheTypeManager();
                            theTypeManager = proxi;
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
                PersistentTypeManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theTypeManager;
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
        return theTypeManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("types", this.getTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public TypeManager provideCopy() throws PersistenceException{
        TypeManager result = this;
        result = new TypeManager(this.This, 
                                 this.getId());
        result.types = this.types.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected TypeManager_TypesProxi types;
    protected PersistentTypeManager This;
    
    public TypeManager(PersistentTypeManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.types = new TypeManager_TypesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 169;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public TypeManager_TypesProxi getTypes() throws PersistenceException {
        return this.types;
    }
    protected void setThis(PersistentTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentTypeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentTypeManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTypeManager result = new TypeManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentTypeManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTypeManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getTypes().getLength());
    }
    
    
    public PersistentMAbstractSumType createSumType(final MTypeSearchList addends) 
				throws model.ConsistencyException, PersistenceException{
		final PersistentMSumType transientResult = MSumType.createMSumType(true);

		try {
			addends.applyToAllException(new ProcdureException<PersistentMType, CycleException>() {

				@Override
				public void doItTo(PersistentMType argument) throws PersistenceException, CycleException {
					transientResult.getContainedTypes().add(argument);
				}
			});
		} catch (CycleException e) {
			throw new ConsistencyException("Cycle: " + e.getMessage());
		}

		PersistentMType existingTypeOrNull = getThis().getTypes().findFirst(new Predcate<PersistentMType>() {

			@Override
			public boolean test(PersistentMType argument) throws PersistenceException {
				return argument.isStructuralEquivalant(transientResult).toBoolean();
			}
		});

		if (existingTypeOrNull == null) {
			getThis().getTypes().add(transientResult);
			return transientResult;
		}
		return (PersistentMSumType) existingTypeOrNull;
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void createAtomicRootType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateAtomicRootTypeCommand command = model.meta.CreateAtomicRootTypeCommand.createCreateAtomicRootTypeCommand(name, now, now);
		command.setAspect(aspect);
		command.setSingletonType(singletonType);
		command.setAbstractType(abstractType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void createSumType(final MTypeSearchList addends, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateSumTypeCommand command = model.meta.CreateSumTypeCommand.createCreateSumTypeCommand(now, now);
		java.util.Iterator<PersistentMType> addendsIterator = addends.iterator();
		while(addendsIterator.hasNext()){
			command.getAddends().add(addendsIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createProductType(final MTypeSearchList factors, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateProductTypeCommand command = model.meta.CreateProductTypeCommand.createCreateProductTypeCommand(now, now);
		java.util.Iterator<PersistentMType> factorsIterator = factors.iterator();
		while(factorsIterator.hasNext()){
			command.getFactors().add(factorsIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentTypeManager)This);
		if(this.equals(This)){
		}
    }
    public void createAtomicSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateAtomicSubTypeCommand command = model.meta.CreateAtomicSubTypeCommand.createCreateAtomicSubTypeCommand(name, now, now);
		command.setSuperType(superType);
		command.setSingletonType(singletonType);
		command.setAbstractType(abstractType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public PersistentMAbstractProductType createProductType(final MTypeSearchList factors) 
				throws model.ConsistencyException, PersistenceException{
		// TODO: Faktoren nur aus getrennten Aspekten
		final PersistentMProductType transientResult = MProductType.createMProductType(true);

		try {
			factors.applyToAllException(new ProcdureException<PersistentMType, CycleException>() {

				@Override
				public void doItTo(PersistentMType argument) throws PersistenceException, CycleException {
					transientResult.getContainedTypes().add(argument);
				}
			});
		} catch (CycleException e) {
			throw new ConsistencyException("Cycle: " + e.getMessage());
		}

		PersistentMType existingTypeOrNull = getThis().getTypes().findFirst(new Predcate<PersistentMType>() {

			@Override
			public boolean test(PersistentMType argument) throws PersistenceException {
				return argument.isStructuralEquivalant(transientResult).toBoolean();
			}
		});

		if (existingTypeOrNull == null) {
			getThis().getTypes().add(transientResult);
			return transientResult;
		}
		return (PersistentMProductType) existingTypeOrNull;
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public PersistentMAtomicType createAtomicSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.ConsistencyException, PersistenceException{
		checkMAtomicTypeNameAndConsitency(name, singletonType, abstractType);

		// TODO Hier m??sste man noch ??berpr??fen, ob der SuperType abstrakt ist, wenn nicht -> Exception!
		PersistentMAtomicType result = MAtomicType.createMAtomicType(name, singletonType, abstractType,
				superType.getAspect(), true);
		try {
			result.setSuperType(superType);
		} catch (CycleException e) {
			// TODO: Kann nicht auftreten; exception entwickeln fuer sowas
			throw new ConsistencyException(e.getMessage());
		}
		getThis().getTypes().add(result);
		return result;
	}
    public PersistentMAtomicType createAtomicRootType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.ConsistencyException, PersistenceException{
		checkMAtomicTypeNameAndConsitency(name, singletonType, abstractType);
		PersistentMAtomicType result = MAtomicType.createMAtomicType(name, singletonType, abstractType, aspect);
		getThis().getTypes().add(result);
		return result;
	}

    /* Start of protected part that is not overridden by persistence generator */
	private static void checkMAtomicTypeNameAndConsitency(String name, PersistentMBoolean singletonType,
			PersistentMBoolean abstractType) throws PersistenceException, ConsistencyException {
		if (singletonType.toBoolean() && abstractType.toBoolean()) {
			throw new ConsistencyException("Singletons may not be abstract");
		}
		if (name.isEmpty()) {
			throw new ConsistencyException("Atomic-Type must have a non-empty name");
		}
		if (MAtomicType.getMAtomicTypeByName(name).getLength() > 0) {
			throw new ConsistencyException("AtomicType-names must be unique. An AtomicType with name " + name
					+ " is already existing.");
		}
	}
	/* End of protected part that is not overridden by persistence generator */
    
}
