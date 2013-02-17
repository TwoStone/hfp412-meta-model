package model.quantity;

import java.util.Iterator;

import model.ConsistencyException;
import model.DoubleDefinitionException;
import model.UserException;
import model.visitor.AbsUnitTypeReturnExceptionVisitor;
import model.visitor.AbsUnitTypeVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbsUnitSearchList;
import persistence.AbsUnitTypeSearchList;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAddReferenceCommand;
import persistence.PersistentAddReferenceTypeCommand;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentCreateCompUnitCommand;
import persistence.PersistentCreateCompUnitTypeCommand;
import persistence.PersistentCreateUnitCommand;
import persistence.PersistentCreateUnitTypeCommand;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentReference;
import persistence.PersistentReferenceType;
import persistence.PersistentRemoveUnitCommand;
import persistence.PersistentRemoveUnitTypeCommand;
import persistence.PersistentSetConversionCommand;
import persistence.PersistentSetDefaultUnitCommand;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.Procdure;
import persistence.TDObserver;
import persistence.UnitTypeManagerProxi;
import persistence.UnitTypeManager_UnitTypesProxi;
import persistence.UnitTypeManager_UnitsProxi;
import persistence.UnitTypeSearchList;
import constants.ExceptionConstants;

/* Additional import section end */

public class UnitTypeManager extends PersistentObject implements PersistentUnitTypeManager{
    
    private static PersistentUnitTypeManager theUnitTypeManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentUnitTypeManager getTheUnitTypeManager() throws PersistenceException{
        if (theUnitTypeManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        UnitTypeManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade.getTheUnitTypeManager();
                            theUnitTypeManager = proxi;
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
                PersistentUnitTypeManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theUnitTypeManager;
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
        return theUnitTypeManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("unitTypes", this.getUnitTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            result.put("atomicUnitTypes", this.getAtomicUnitTypes(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false));
            result.put("units", this.getUnits().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public UnitTypeManager provideCopy() throws PersistenceException{
        UnitTypeManager result = this;
        result = new UnitTypeManager(this.This, 
                                     this.getId());
        result.unitTypes = this.unitTypes.copy(result);
        result.units = this.units.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected UnitTypeManager_UnitTypesProxi unitTypes;
    protected UnitTypeManager_UnitsProxi units;
    protected PersistentUnitTypeManager This;
    
    public UnitTypeManager(PersistentUnitTypeManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.unitTypes = new UnitTypeManager_UnitTypesProxi(this);
        this.units = new UnitTypeManager_UnitsProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 171;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public UnitTypeManager_UnitTypesProxi getUnitTypes() throws PersistenceException {
        return this.unitTypes;
    }
    public UnitTypeManager_UnitsProxi getUnits() throws PersistenceException {
        return this.units;
    }
    protected void setThis(PersistentUnitTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentUnitTypeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentUnitTypeManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUnitTypeManager result = new UnitTypeManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentUnitTypeManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitTypeManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getUnitTypes().getLength()
            + this.getUnits().getLength());
    }
    
    
    public void addReference(final String name, final PersistentAbsUnit unit, final PersistentUnit referenceUnit, final long exponent, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddReferenceCommand command = model.meta.AddReferenceCommand.createAddReferenceCommand(name, exponent, now, now);
		command.setUnit(unit);
		command.setReferenceUnit(referenceUnit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createUnit(final String name, final PersistentUnitType type) 
				throws model.DoubleDefinitionException, PersistenceException{
		AbsUnitSearchList old = Unit.getAbsUnitByName(name);
		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_DEFINITION + name);
		}
		getThis().getUnits().add(Unit.createUnit(type, name));

	}
    public UnitTypeSearchList getAtomicUnitTypes() 
				throws PersistenceException{
		final UnitTypeSearchList result = new UnitTypeSearchList();

		this.getThis().getUnitTypes().applyToAll(new Procdure<PersistentAbsUnitType>() {
			@Override
			public void doItTo(PersistentAbsUnitType argument) throws PersistenceException {
				argument.accept(new AbsUnitTypeVisitor() {
					@Override
					public void handleUnitType(PersistentUnitType unitType) throws PersistenceException {
						result.add(unitType);
					}

					@Override
					public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException {
					}
				});
			}
		});

		return result;
	}
    public void addReference(final String name, final PersistentAbsUnit unit, final PersistentUnit referenceUnit, final long exponent) 
				throws model.DoubleDefinitionException, PersistenceException{
		// TODO: implement method: addReference

	}
    public void createCompUnit(final String name, final PersistentCompUnitType type, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateCompUnitCommand command = model.meta.CreateCompUnitCommand.createCreateCompUnitCommand(name, now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public UnitTypeSearchList getAtomicUnitTypes(final TDObserver observer) 
				throws PersistenceException{
        UnitTypeSearchList result = getThis().getAtomicUnitTypes();
		observer.updateTransientDerived(getThis(), "atomicUnitTypes", result);
		return result;
    }
    public void addReferenceType(final String name, final PersistentAbsUnitType unitType, final PersistentUnitType referenceUnitType, final long exponent, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddReferenceTypeCommand command = model.meta.AddReferenceTypeCommand.createAddReferenceTypeCommand(name, exponent, now, now);
		command.setUnitType(unitType);
		command.setReferenceUnitType(referenceUnitType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createCompUnit(final String name, final PersistentCompUnitType type) 
				throws model.DoubleDefinitionException, PersistenceException{

		// DoubleDefinition: Namensgleichheit.
		if (AbsUnitType.getAbsUnitTypeByName(name).iterator().hasNext())
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_DEFINITION);

		// DoubleDefinition: Gleiche Auspr?gung (Typengleichheit).
		// TODO: Double Definition bei gleicher Auspr --> etwas komplexer^^

		Iterator<PersistentReferenceType> it = type.getRefs().iterator();
		PersistentCompUnit newCompUnit = CompUnit.createCompUnit(type, name);

		while (it.hasNext()) {

			PersistentReferenceType curRefType = it.next();

			if (curRefType.getRef().getDefaultUnit() != null) {
				PersistentReference ref = Reference.createReference();
				ref.setType(curRefType);
				ref.setExponent(curRefType.getExponent());
				ref.setRef(curRefType.getRef().getDefaultUnit());
				newCompUnit.getRefs().add(ref);
			}

		}
		this.getThis().getUnits().add(newCompUnit);

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

	}
    public void setDefaultUnit(final PersistentUnitType type, final PersistentUnit unit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentSetDefaultUnitCommand command = model.meta.SetDefaultUnitCommand.createSetDefaultUnitCommand(now, now);
		command.setType(type);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createUnitType(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateUnitTypeCommand command = model.meta.CreateUnitTypeCommand.createCreateUnitTypeCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void removeUnit(final PersistentAbsUnit unit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveUnitCommand command = model.meta.RemoveUnitCommand.createRemoveUnitCommand(now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createCompUnitType(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
		// TODO: nur mit addReferenceType erstellen? Sonst entstehen leere CompUnitTypes
		AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);
		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION + name);
		}
		this.getThis().getUnitTypes().add(CompUnitType.createCompUnitType(name));

	}
    public void removeUnitType(final PersistentAbsUnitType type) 
				throws PersistenceException{
		// TODO: implement method: removeUnitType; schon vorhandene Units zu diesem Typ mit löschen!

	}
    public void createUnit(final String name, final PersistentUnitType type, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateUnitCommand command = model.meta.CreateUnitCommand.createCreateUnitCommand(name, now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void removeUnit(final PersistentAbsUnit unit) 
				throws PersistenceException{
		// TODO: implement method: removeUnit

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{

	}
    public void setConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentSetConversionCommand command = model.meta.SetConversionCommand.createSetConversionCommand(factor, constant, now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{

	}
    public void setConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant) 
				throws model.ConsistencyException, PersistenceException{

		// TODO: Conversion ??ndern, wenn schon vorhanden
		// TODO: Doppelte Functions?
		if (((PersistentUnitType) unit.getType()).getDefaultUnit() == null) {
			throw new ConsistencyException(ExceptionConstants.NO_DEFAULT_UNIT);
		}
		Conversion.createConversion(unit, Function.createFunction(factor, constant));

	}
    public void removeUnitType(final PersistentAbsUnitType type, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveUnitTypeCommand command = model.meta.RemoveUnitTypeCommand.createRemoveUnitTypeCommand(now, now);
		command.setType(type);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentUnitTypeManager)This);
		if(this.equals(This)){
		}
    }
    public void setDefaultUnit(final PersistentUnitType type, final PersistentUnit unit) 
				throws PersistenceException{
		type.setDefaultUnit(unit);
	}
    public void addReferenceType(final String name, final PersistentAbsUnitType unitType, final PersistentUnitType referenceUnitType, final long exponent) 
				throws model.DoubleDefinitionException, PersistenceException{
		// Name schon vorhanden?
		final AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);
		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION);
		}
		// Unterscheidung ob UnitType oder CompUnitType
		unitType.accept(new AbsUnitTypeReturnExceptionVisitor<CompUnitType, DoubleDefinitionException>() {

			@Override
			public model.quantity.CompUnitType handleCompUnitType(PersistentCompUnitType compUnitType)
					throws PersistenceException, DoubleDefinitionException {
				// TODO
				return null;
			}

			@Override
			public model.quantity.CompUnitType handleUnitType(PersistentUnitType unitType) throws PersistenceException,
					DoubleDefinitionException {
				// referenceUnitType und unitType gleich?
				if (referenceUnitType.equals(unitType)) {

				}
				return null;
			}
		});

		// // ---> Dublette pr?fen
		// PersistentReferenceType duplicate = compUnitType.getRefs().findFirst(new Predcate<PersistentReferenceType>()
		// {
		//
		// @Override
		// public boolean test(PersistentReferenceType argument) throws PersistenceException {
		// if (argument.getRef().equals(unitType))
		// return true;
		// return false;
		// }
		// });
		//
		// if (duplicate != null)
		// throw new DoubleDefinitionException(constants.ExceptionConstants.DOUBLE_REFERENCETYPE_DEFINITION
		// + duplicate.toString());
		// // <--- Dublette pr?fen
		//
		// // TODO: CompoundUnitType mit diesen Referenzen schon vorhanden?
		//
		// PersistentReferenceType newRefType = ReferenceType.createReferenceType();
		// newRefType.setRef(unitType);
		// newRefType.setExponent(exponent);
		// compUnitType.getRefs().add(newRefType);

	}
    public void createUnitType(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
		final AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);

		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION);
		}

		this.getThis().getUnitTypes().add(UnitType.createUnitType(name));

	}
    public void createCompUnitType(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateCompUnitTypeCommand command = model.meta.CreateCompUnitTypeCommand.createCreateCompUnitTypeCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }

    /* Start of protected part that is not overridden by persistence generator */

	/**
	 * Testet ob ein CompoundUnitType mit den übergebenen ReferenceTypes schon vorhanden ist.
	 * 
	 * @param referenceTypes
	 * @return
	 */
	private boolean existsCompUnitTypeWithReferenceTypes(PersistentReferenceType... referenceTypes) {
		// TODO!
		return false;
	}

	/* End of protected part that is not overridden by persistence generator */
    
}
