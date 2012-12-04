package model.quantity;

import java.util.Iterator;

import model.AlreadyFinalizedException;
import model.DoubleDefinitionException;
import model.NotFinalizedException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MBooleanExceptionVisitor;
import persistence.AbsUnitSearchList;
import persistence.AbsUnitTypeSearchList;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAddDefaultUnitCommand;
import persistence.PersistentAddReferenceTypeCommand;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentCreateCompUnitCommand;
import persistence.PersistentCreateCompUnitTypeCommand;
import persistence.PersistentCreateUnitCommand;
import persistence.PersistentCreateUnitTypeCommand;
import persistence.PersistentFinishModelingCommand;
import persistence.PersistentMBoolean;
import persistence.PersistentMFalse;
import persistence.PersistentMTrue;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentReference;
import persistence.PersistentReferenceType;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.Predcate;
import persistence.TDObserver;
import persistence.UnitTypeManagerProxi;
import persistence.UnitTypeManager_UnitTypesProxi;
import persistence.UnitTypeManager_UnitsProxi;
import constants.ExceptionConstants;

/* Additional import section end */

public class UnitTypeManager extends PersistentObject implements PersistentUnitTypeManager{
    
    private static PersistentUnitTypeManager theUnitTypeManager = null;
    private static boolean reset$For$Test = false;
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
        return 176;
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
    
    
    public void addReferenceType(final PersistentCompUnitType compUnitType, final PersistentUnitType unitType, final long exponent, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddReferenceTypeCommand command = model.meta.AddReferenceTypeCommand.createAddReferenceTypeCommand(exponent, now, now);
		command.setCompUnitType(compUnitType);
		command.setUnitType(unitType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    public void createUnit(final String name, final PersistentUnitType type) 
				throws model.DoubleDefinitionException, PersistenceException{
    	AbsUnitSearchList old = Unit.getAbsUnitByName(name);
		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(
					ExceptionConstants.DOUBLE_UNIT_DEFINITION + name);
		}
		getThis().getUnits().add(Unit.createUnit(type, name));
        
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
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public void addReferenceType(final PersistentCompUnitType compUnitType, final PersistentUnitType unitType, final long exponent) 
				throws model.DoubleDefinitionException, model.AlreadyFinalizedException, PersistenceException{
    	// ---> isFinal-Attribut pr?fen
    			compUnitType.isFinal().accept(
    					new MBooleanExceptionVisitor<AlreadyFinalizedException>() {

    						@Override
    						public void handleMFalse(
    								PersistentMFalse booleanFalse)
    								throws PersistenceException,
    								AlreadyFinalizedException {
    						}

    						@Override
    						public void handleMTrue(
    								PersistentMTrue booleanTrue)
    								throws PersistenceException,
    								AlreadyFinalizedException {
    							throw new AlreadyFinalizedException(
    									constants.ExceptionConstants.ALREADY_FINAL_CUT);

    						}

								@Override
								public void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException, AlreadyFinalizedException {
									// TODO Auto-generated method stub
									
								}
    					});
    			// <--- isFinal-Attribut pr?fen

    			// ---> Dublette pr?fen
    			PersistentReferenceType duplicate = compUnitType.getRefs().findFirst(
    					new Predcate<PersistentReferenceType>() {

    						@Override
    						public boolean test(PersistentReferenceType argument)
    								throws PersistenceException {
    							if (argument.getRef().equals(unitType))
    								return true;
    							return false;
    						}
    					});

    			if (duplicate != null)
    				throw new DoubleDefinitionException(
    						constants.ExceptionConstants.DOUBLE_REFERENCETYPE_DEFINITION
    								+ duplicate.toString());
    			// <--- Dublette pr?fen

    			PersistentReferenceType newRefType = ReferenceType
    					.createReferenceType();
    			newRefType.setRef(unitType);
    			newRefType.setExponent(exponent);
    			compUnitType.getRefs().add(newRefType);        
    }
    public void createCompUnit(final String name, final PersistentCompUnitType type) 
				throws model.DoubleDefinitionException, model.NotFinalizedException, PersistenceException{
    	
    	// DoubleDefinition: Namensgleichheit.
    	if (AbsUnitType.getAbsUnitTypeByName(name).iterator().hasNext())
    		throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_DEFINITION);
    	
    	// DoubleDefinition: Gleiche Auspr?gung (Typengleichheit).
    	// TODO: Double Definition bei gleicher Auspr --> etwas komplexer^^
    	
    	// Falls CompUnitType noch im draft-Status: blocken.
    	type.isFinal().accept(new MBooleanExceptionVisitor<NotFinalizedException>() {

			@Override
			public void handleMFalse(PersistentMFalse booleanFalse)
					throws PersistenceException, NotFinalizedException {
				throw new NotFinalizedException("Not final...");				
			}

			@Override
			public void handleMTrue(PersistentMTrue booleanTrue)
					throws PersistenceException, NotFinalizedException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException, NotFinalizedException {
				// TODO Auto-generated method stub
				
			}
    		
    		
    	});
    	
    	Iterator<PersistentReferenceType> it = type.getRefs().iterator();
    	PersistentCompUnit newCompUnit = CompUnit.createCompUnit(type, name);
    	
    	while(it.hasNext()) {
    		
    		PersistentReferenceType curRefType = it.next();
   			
    		if(curRefType.getRef().getDefaultUnit()!=null){
    			PersistentReference ref = Reference.createReference();
    			ref.setType(curRefType);
    			ref.setExponent(curRefType.getExponent());
    			ref.setRef((PersistentUnit) curRefType.getRef().getDefaultUnit());
    			newCompUnit.getRefs().add(ref);
    		}
    		
    		
    	}
    	this.getThis().getUnits().add(newCompUnit);
        
    }
    public void finishModeling(final PersistentCompUnitType compUnitType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentFinishModelingCommand command = model.meta.FinishModelingCommand.createFinishModelingCommand(now, now);
		command.setCompUnitType(compUnitType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void finishModeling(final PersistentCompUnitType compUnitType) 
				throws model.AlreadyFinalizedException, PersistenceException{
    	
    	compUnitType.isFinal().accept(new MBooleanExceptionVisitor<AlreadyFinalizedException>() {
    			  
    		@Override 
    		public void handleMFalse(PersistentMFalse booleanFalse) 
    				throws PersistenceException, AlreadyFinalizedException {}
    			  
    		@Override 
    		public void handleMTrue(PersistentMTrue booleanTrue) 
    				throws PersistenceException, AlreadyFinalizedException {
    			throw new AlreadyFinalizedException(
    					constants.ExceptionConstants.ALREADY_FINAL_CUT); 
    		}

				@Override
				public void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException, AlreadyFinalizedException {
					// TODO Auto-generated method stub
					
				}	  
    	});
    			  
    	compUnitType.finishModeling(); 
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void createUnitType(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateUnitTypeCommand command = model.meta.CreateUnitTypeCommand.createCreateUnitTypeCommand(name, now, now);
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
    public void createCompUnitType(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
		AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);
		if (old.iterator().hasNext()) {
			throw new DoubleDefinitionException(
					ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION + name);
		}
		this.getThis().getUnitTypes()
				.add(CompUnitType.createCompUnitType(name));

	}
    public void addDefaultUnit(final PersistentAbsUnitType type, final PersistentAbsUnit unit, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddDefaultUnitCommand command = model.meta.AddDefaultUnitCommand.createAddDefaultUnitCommand(now, now);
		command.setType(type);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void addDefaultUnit(final PersistentAbsUnitType type, final PersistentAbsUnit unit) 
				throws PersistenceException{
		// TODO Was passiert, wenn es schon eine Default-Unit gibt?
		type.setDefaultUnit(unit);

	}
    public void createUnitType(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
		AbsUnitTypeSearchList old = AbsUnitType.getAbsUnitTypeByName(name);
		
		if(old.iterator().hasNext()){
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_UNIT_TYPE_DEFINITION);
		}

		this.getThis().getUnitTypes().add(UnitType.createUnitType(name));

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
    public void createCompUnitType(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateCompUnitTypeCommand command = model.meta.CreateCompUnitTypeCommand.createCreateCompUnitTypeCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }

    /* Start of protected part that is not overridden by persistence generator */
	/*
	 * public void finalize(final PersistentCompUnitType compUnitType) throws
	 * model.AlreadyFinalizedException, PersistenceException{
	 * 
	 * 

	/* End of protected part that is not overridden by persistence generator */
    
}
