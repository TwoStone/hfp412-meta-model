package model.abstractOperation;

import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.NotAvailableException;
import model.UserException;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.AbsOperationReturnVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.*;
import utils.EmptyTypeDisjReturnBooleanVisitor;
import constants.ExceptionConstants;

/* Additional import section end */

public class AssociationManager extends PersistentObject implements PersistentAssociationManager{
    
    private static PersistentAssociationManager theAssociationManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentAssociationManager getTheAssociationManager() throws PersistenceException{
        if (theAssociationManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        AssociationManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade.getTheAssociationManager();
                            theAssociationManager = proxi;
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
                PersistentAssociationManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theAssociationManager;
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
        return theAssociationManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("associations", this.getAssociations().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("hierarchies", this.getHierarchies().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public AssociationManager provideCopy() throws PersistenceException{
        AssociationManager result = this;
        result = new AssociationManager(this.This, 
                                        this.getId());
        result.associations = this.associations.copy(result);
        result.hierarchies = this.hierarchies.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected AssociationManager_AssociationsProxi associations;
    protected AssociationManager_HierarchiesProxi hierarchies;
    protected PersistentAssociationManager This;
    
    public AssociationManager(PersistentAssociationManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.associations = new AssociationManager_AssociationsProxi(this);
        this.hierarchies = new AssociationManager_HierarchiesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 154;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public AssociationManager_AssociationsProxi getAssociations() throws PersistenceException {
        return this.associations;
    }
    public AssociationManager_HierarchiesProxi getHierarchies() throws PersistenceException {
        return this.hierarchies;
    }
    protected void setThis(PersistentAssociationManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAssociationManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAssociationManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAssociationManager result = new AssociationManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAssociationManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAssociationManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAssociationManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAssociationManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAssociationManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getAssociations().getLength() > 0) return 1;
        if (this.getHierarchies().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddAssociationCommand command = model.meta.AddAssociationCommand.createAddAssociationCommand(now, now);
		command.setH(h);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void createAssociation(final PersistentMType source, final PersistentMType target, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateAssociationCommand command = model.meta.CreateAssociationCommand.createCreateAssociationCommand(name, now, now);
		command.setSource(source);
		command.setTarget(target);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createHierarchy(final PersistentAssociation a, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateHierarchyCommand command = model.meta.CreateHierarchyCommand.createCreateHierarchyCommand(name, now, now);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAssociationManager)This);
		if(this.equals(This)){
		}
    }
    public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveAssoFrmHierCommand command = model.meta.RemoveAssoFrmHierCommand.createRemoveAssoFrmHierCommand(now, now);
		command.setH(h);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void removeAssociation(final PersistentAssociation a, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveAssociationCommand command = model.meta.RemoveAssociationCommand.createRemoveAssociationCommand(now, now);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void removeHierarchy(final PersistentHierarchy h, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveHierarchyCommand command = model.meta.RemoveHierarchyCommand.createRemoveHierarchyCommand(now, now);
		command.setH(h);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a) 
				throws model.ConsistencyException, model.CycleException, PersistenceException{
		// Consistency, wenn Assoc schon in Hierarchy
		if (h.getAssociations().findFirst(new Predcate<PersistentAssociation>() {
			@Override
			public boolean test(final PersistentAssociation argument) throws PersistenceException {
				return argument.equals(a);
			}
		}) != null) {
			throw new ConsistencyException(ExceptionConstants.CE_ASSOC_ALREADY_IN_HIERARCHY);
		}

		// Pruefen ob durch bestehende Links ein Zyklus entstehen wuerde
		final LinkSearchList allLinksOfAssociation = a.inverseGetType();

		final PersistentLink firstCycle = allLinksOfAssociation.findFirst(new Predcate<PersistentLink>() {

			@Override
			public boolean test(final PersistentLink argument) throws PersistenceException {
				return argument.getTarget().containsInHierarchy(argument.getSource(), h).toBoolean();
			}
		});
		if (firstCycle != null) {
			throw new CycleException(ExceptionConstants.CYCLE_ADD_ASSOC + firstCycle.toString());
		}

		a.getHierarchies().add(h);
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public PersistentAssociation createAssociation(final PersistentMType source, final PersistentMType target, final String name) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException{
		// DoubleDefinition prüfen
		final AbsOperationSearchList absOperationWithSameName = Association.getAbsOperationByName(name);
		PersistentAbsOperation doubleDefinition = null;
		if (absOperationWithSameName != null) {
			doubleDefinition = absOperationWithSameName.findFirst(new Predcate<PersistentAbsOperation>() {

				@Override
				public boolean test(final PersistentAbsOperation argument) throws PersistenceException {
					return argument.accept(new AbsOperationReturnVisitor<PersistentMBoolean>() {

						@Override
						public PersistentMBoolean handleOperation(final PersistentOperation operation) throws PersistenceException {
							return MFalse.getTheMFalse();
						}

						@Override
						public PersistentMBoolean handleAssociation(final PersistentAssociation association) throws PersistenceException {
							return MTrue.getTheMTrue();
						}
					}).toBoolean();
				}
			});
		}

		if (doubleDefinition != null) {
			throw new DoubleDefinitionException(ExceptionConstants.DDE_ASSOC);
		}

		// Consistency, wenn source oder target = emptySum
		final EmptyTypeDisjReturnBooleanVisitor vis = new EmptyTypeDisjReturnBooleanVisitor();
		if (source.accept(vis)) {
			throw new ConsistencyException("Quelle darf nicht vom Typ " + source + " sein.");
		}
		if (target.accept(vis)) {
			throw new ConsistencyException("Ziel darf nicht vom Typ " + source + " sein.");
		}
		final PersistentAssociation a = Association.createAssociation(name, source, target);
		getThis().getAssociations().add(a);
		return a;
	}
    public PersistentHierarchy createHierarchy(final PersistentAssociation a, final String name) 
				throws model.DoubleDefinitionException, model.ConsistencyException, model.CycleException, PersistenceException{
		if (getThis().getHierarchies().findFirst(new Predcate<PersistentHierarchy>() {
			@Override
			public boolean test(final PersistentHierarchy argument) throws PersistenceException {
				return argument.getName().equals(name);
			}
		}) != null) {
			throw new DoubleDefinitionException(ExceptionConstants.DDE_HIERARCHY);
		}

		final PersistentHierarchy h = Hierarchy.createHierarchy(name);
		getThis().addAssociation(h, a);
		getThis().getHierarchies().add(h);
		return h;
	}
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a) 
				throws model.NotAvailableException, model.ConsistencyException, model.CycleException, PersistenceException{

		// Wenn die Assoziation gar nicht in der Hierarchy ist => Exception
		final PersistentAssociation findFirst = h.getAssociations().findFirst(new Predcate<PersistentAssociation>() {

			@Override
			public boolean test(final PersistentAssociation argument) throws PersistenceException {
				return argument.equals(a);
			}
		});
		if (findFirst == null) {
			throw new NotAvailableException(ExceptionConstants.NA_IN_HIERARCHY);
		}

		// Wenn versucht wird die letzte Assoziation einer Hierarchie zu entfernen
		if (h.getAssociations().getLength() <= 1) {
			throw new ConsistencyException(ExceptionConstants.CE_LAST_ASSOC_IN_HIERARCHY);
		}

		a.getHierarchies().removeFirstSuccess(new Predcate<PersistentHierarchy>() {
			@Override
			public boolean test(final PersistentHierarchy argument) throws PersistenceException {
				return h.equals(argument);
			}
		});
	}
    public void removeAssociation(final PersistentAssociation a) 
				throws model.ConsistencyException, model.CycleException, PersistenceException{
		// Consistency, falls es Links gibt.
		if (a.inverseGetType().getLength() > 0) {
			throw new ConsistencyException(ExceptionConstants.CE_EXISTING_LINKS);
		}
		// Consistency wenn es Element einer Hierarchy ist
		if (getThis().getHierarchies().getLength() > 0) {
			throw new ConsistencyException(ExceptionConstants.CE_ASSOC_IN_HIERARCHY);
		}

		getThis().getAssociations().removeFirstSuccess(new Predcate<PersistentAssociation>() {
			@Override
			public boolean test(final PersistentAssociation argument) throws PersistenceException {
				return a.equals(argument);
			}
		});
	}
    public void removeHierarchy(final PersistentHierarchy h) 
				throws PersistenceException{
		getThis().getHierarchies().removeFirstSuccess(new Predcate<PersistentHierarchy>() {

			@Override
			public boolean test(final PersistentHierarchy argument) throws PersistenceException {
				return argument.equals(h);
			}
		});
	}
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
	/* End of protected part that is not overridden by persistence generator */
    
}
