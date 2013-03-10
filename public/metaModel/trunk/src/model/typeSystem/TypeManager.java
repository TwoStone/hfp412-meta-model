package model.typeSystem;

import model.ConsistencyException;
import model.CycleException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentChangeAbstractCommand;
import persistence.PersistentChangeSingletonCommand;
import persistence.PersistentCreateAtomicRootTypeCommand;
import persistence.PersistentCreateAtomicSubTypeCommand;
import persistence.PersistentCreateTypeConjunctionCommand;
import persistence.PersistentCreateTypeDisjunctionCommand;
import persistence.PersistentDeleteAtomicTypeCommand;
import persistence.PersistentDeleteComplexeTypeCommand;
import persistence.PersistentMAbstractTypeConjunction;
import persistence.PersistentMAbstractTypeDisjunction;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMComplexType;
import persistence.PersistentMSingletonObject;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentRenameAtomicTypeCommand;
import persistence.PersistentTypeManager;
import persistence.Predcate;
import persistence.Procdure;
import persistence.TDObserver;
import persistence.TypeManagerProxi;
import persistence.TypeManager_TypesProxi;
import utils.Iterables;
import constants.ExceptionConstants;

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
            result.put("types", this.getTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
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
        if (this.getTypes().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void changeAbstract(final PersistentMAtomicType type, final PersistentMBoolean newAbstractType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentChangeAbstractCommand command = model.meta.ChangeAbstractCommand.createChangeAbstractCommand(now, now);
		command.setType(type);
		command.setNewAbstractType(newAbstractType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void changeSingleton(final PersistentMAtomicType type, final PersistentMBoolean newSingletonType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentChangeSingletonCommand command = model.meta.ChangeSingletonCommand.createChangeSingletonCommand(now, now);
		command.setType(type);
		command.setNewSingletonType(newSingletonType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
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
    public void createTypeConjunction(final MTypeSearchList factors, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateTypeConjunctionCommand command = model.meta.CreateTypeConjunctionCommand.createCreateTypeConjunctionCommand(now, now);
		java.util.Iterator<PersistentMType> factorsIterator = factors.iterator();
		while(factorsIterator.hasNext()){
			command.getFactors().add(factorsIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createTypeDisjunction(final MTypeSearchList addends, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateTypeDisjunctionCommand command = model.meta.CreateTypeDisjunctionCommand.createCreateTypeDisjunctionCommand(now, now);
		java.util.Iterator<PersistentMType> addendsIterator = addends.iterator();
		while(addendsIterator.hasNext()){
			command.getAddends().add(addendsIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void deleteAtomicType(final PersistentMAtomicType type, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentDeleteAtomicTypeCommand command = model.meta.DeleteAtomicTypeCommand.createDeleteAtomicTypeCommand(now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void deleteComplexeType(final PersistentMComplexType type, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentDeleteComplexeTypeCommand command = model.meta.DeleteComplexeTypeCommand.createDeleteComplexeTypeCommand(now, now);
		command.setType(type);
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
    public void renameAtomicType(final PersistentMAtomicType type, final String newName, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRenameAtomicTypeCommand command = model.meta.RenameAtomicTypeCommand.createRenameAtomicTypeCommand(newName, now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void changeAbstract(final PersistentMAtomicType type, final PersistentMBoolean newAbstractType) 
				throws model.ConsistencyException, PersistenceException{
		type.changeAbstract(newAbstractType);
	}
    public void changeSingleton(final PersistentMAtomicType type, final PersistentMBoolean newSingletonType) 
				throws model.ConsistencyException, PersistenceException{
		if (type.getSingletonType().equals(newSingletonType)) {
			return;
		}
		if (newSingletonType.toBoolean()) {
			type.changeSingleton(newSingletonType);
			addSingletonInstanceToManager(type);
		} else {
			removeSingletonInstanceFromManager(type);
			type.changeSingleton(newSingletonType);
		}
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public PersistentMAtomicType createAtomicRootType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.ConsistencyException, PersistenceException{
		TypeManager.checkMAtomicTypeNameAndConsitency(name, singletonType, abstractType);
		PersistentMAtomicType result;
		try {
			result = MAtomicType.createMAtomicType(name, singletonType, abstractType, aspect, MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
			getThis().getTypes().add(result);
			addSingletonInstanceToManager(result);
			return result;
		} catch (final CycleException e) {
			e.printStackTrace();
			throw new ConsistencyException("Cycle Exception that can't occur: " + e.getMessage());
		}

	}
    public PersistentMAtomicType createAtomicSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.ConsistencyException, PersistenceException{
		TypeManager.checkMAtomicTypeNameAndConsitency(name, singletonType, abstractType);
		try {
			final PersistentMAtomicType result = MAtomicType.createMAtomicType(name, singletonType, abstractType, superType.getAspect(), superType);
			getThis().getTypes().add(result);
			addSingletonInstanceToManager(result);
			return result;
		} catch (final CycleException e) {
			// TODO can't occur
			throw new ConsistencyException("Cycle Exception that can't occur: " + e.getMessage());
		}

	}
    public PersistentMAbstractTypeConjunction createTypeConjunction(final MTypeSearchList factors) 
				throws model.ConsistencyException, PersistenceException{
		final PersistentMAbstractTypeConjunction result = MAbstractTypeConjunction.transientCreateAbstractTypeConj(factors);

		if (result.equals(MEmptyTypeConjunction.getTheMEmptyTypeConjunction())) {
			return MEmptyTypeConjunction.getTheMEmptyTypeConjunction();
		}

		final PersistentMType containedEqualType = getStructuralEquivalentType(result);

		if (containedEqualType == null) {
			getThis().getTypes().add(result);
			return result;
		}

		return (PersistentMAbstractTypeConjunction) containedEqualType;
	}
    public PersistentMAbstractTypeDisjunction createTypeDisjunction(final MTypeSearchList addends) 
				throws model.ConsistencyException, PersistenceException{

		final PersistentMAbstractTypeDisjunction result = MAbstractTypeDisjunction.transientCreateAbstrTypeDisj(addends);

		if (result.equals(MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction())) {
			return MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction();
		}

		final PersistentMType containedEqualType = getStructuralEquivalentType(result);

		if (containedEqualType == null) {
			getThis().getTypes().add(result);
			return result;
		}

		return (PersistentMAbstractTypeDisjunction) containedEqualType;

	}
    public void deleteAtomicType(final PersistentMAtomicType type) 
				throws model.ConsistencyException, PersistenceException{
		removeSingletonInstanceFromManager(type);
		getThis().getTypes().filter(new Predcate<PersistentMType>() {

			@Override
			public boolean test(final PersistentMType argument) throws PersistenceException {
				return !argument.equals(type);
			}
		});
		type.delete();
	}
    public void deleteComplexeType(final PersistentMComplexType type) 
				throws model.ConsistencyException, PersistenceException{
		getThis().getTypes().filter(new Predcate<PersistentMType>() {

			@Override
			public boolean test(final PersistentMType argument) throws PersistenceException {
				return !argument.equals(type);
			}
		});
		type.delete();

	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void renameAtomicType(final PersistentMAtomicType type, final String newName) 
				throws model.ConsistencyException, PersistenceException{
		if (type.getName().equals(newName)) {
			return;
		}
		if (MAtomicType.getMAtomicTypeByName(newName).getLength() > 0) {
			throw new ConsistencyException(ExceptionConstants.CE_NAME_DOUBLE + newName);
		}
		type.setName(newName);
	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */

	private static void checkMAtomicTypeNameAndConsitency(final String name, final PersistentMBoolean singletonType,
			final PersistentMBoolean abstractType) throws PersistenceException, ConsistencyException {
		if (singletonType.toBoolean() && abstractType.toBoolean()) {
			throw new ConsistencyException(ExceptionConstants.CE_AT_SINGLETON_AND_ABSTRACT);
		}
		if (name.isEmpty()) {
			throw new ConsistencyException(ExceptionConstants.CE_AT_NAME_EMPTY);
		}
		if (MAtomicType.getMAtomicTypeByName(name).getLength() > 0) {
			throw new ConsistencyException(ExceptionConstants.CE_NAME_DOUBLE + name);
		}
	}

	/*
	 * static ArrayList<PersistentMAtomicTypeProduct> filterAtomicProducts(MTypeSearchList list) throws
	 * PersistenceException { final ArrayList<PersistentMAtomicTypeProduct> result = new
	 * ArrayList<PersistentMAtomicTypeProduct>(); list.applyToAll(new Procdure<PersistentMType>() {
	 * 
	 * @Override public void doItTo(PersistentMType argument) throws PersistenceException { argument.accept(new
	 * MTypeStandardVisitor() {
	 * 
	 * @Override protected void standardHandling(PersistentMType mType) throws PersistenceException { }
	 * 
	 * @Override public void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws
	 * PersistenceException { result.add(mAtomicTypeProduct); }
	 * 
	 * }); } }); return result; }
	 * 
	 * private static ArrayList<PersistentMAtomicType> filterAtomicTypes(MTypeSearchList list) throws
	 * PersistenceException { final ArrayList<PersistentMAtomicType> result = new ArrayList<PersistentMAtomicType>();
	 * list.applyToAll(new Procdure<PersistentMType>() {
	 * 
	 * @Override public void doItTo(PersistentMType argument) throws PersistenceException { argument.accept(new
	 * MTypeStandardVisitor() {
	 * 
	 * @Override protected void standardHandling(PersistentMType mType) throws PersistenceException { }
	 * 
	 * @Override public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException {
	 * result.add(mAtomicType); } }); } }); return result; }
	 */

	private PersistentMType getStructuralEquivalentType(final PersistentMType search) throws PersistenceException {
		return getThis().getTypes().findFirst(new Predcate<PersistentMType>() {

			@Override
			public boolean test(final PersistentMType argument) throws PersistenceException {
				return search.isStructuralEquivalant(argument).toBoolean();
			}
		});
	}

	private void checkOnlyNonSingletonFactors(final MTypeSearchList factors) throws ConsistencyException, PersistenceException {
		for (final PersistentMType type : Iterables.wrap(factors)) {
			if (type.isSingleton().toBoolean()) {
				throw new ConsistencyException("Die Produktbildung von Singletons ist nicht erlaubt!");
			}
		}
	}

	private void removeSingletonInstanceFromManager(final PersistentMAtomicType type) throws PersistenceException {
		ObjectManager.getTheObjectManager().getSingletons().filter(new Predcate<PersistentMSingletonObject>() {

			@Override
			public boolean test(final PersistentMSingletonObject argument) throws PersistenceException {
				return !argument.getType().equals(type);
			}
		});
	}

	private void addSingletonInstanceToManager(final PersistentMAtomicType type) throws PersistenceException {
		type.getSingletonObject().applyToAll(new Procdure<PersistentMSingletonObject>() {

			@Override
			public void doItTo(final PersistentMSingletonObject argument) throws PersistenceException {
				ObjectManager.getTheObjectManager().getSingletons().add(argument);
			}
		});
	}
	/* End of protected part that is not overridden by persistence generator */
    
}
