
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class TypeManager extends PersistentObject implements PersistentTypeManager{
    
    private static PersistentTypeManager theTypeManager = null;
    private static boolean reset$For$Test = false;
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
            result.put("atomicTypes", this.getAtomicTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            result.put("productTypes", this.getProductTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            result.put("sumTypes", this.getSumTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public TypeManager provideCopy() throws PersistenceException{
        TypeManager result = this;
        result = new TypeManager(this.This, 
                                 this.getId());
        result.atomicTypes = this.atomicTypes.copy(result);
        result.productTypes = this.productTypes.copy(result);
        result.sumTypes = this.sumTypes.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected TypeManager_AtomicTypesProxi atomicTypes;
    protected TypeManager_ProductTypesProxi productTypes;
    protected TypeManager_SumTypesProxi sumTypes;
    protected PersistentTypeManager This;
    
    public TypeManager(PersistentTypeManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.atomicTypes = new TypeManager_AtomicTypesProxi(this);
        this.productTypes = new TypeManager_ProductTypesProxi(this);
        this.sumTypes = new TypeManager_SumTypesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public TypeManager_AtomicTypesProxi getAtomicTypes() throws PersistenceException {
        return this.atomicTypes;
    }
    public TypeManager_ProductTypesProxi getProductTypes() throws PersistenceException {
        return this.productTypes;
    }
    public TypeManager_SumTypesProxi getSumTypes() throws PersistenceException {
        return this.sumTypes;
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
            + this.getAtomicTypes().getLength()
            + this.getProductTypes().getLength()
            + this.getSumTypes().getLength());
    }
    
    
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType typeunder) 
				throws model.WrongSubTypeAspectException, model.CycleException, PersistenceException{
        superType.addSubType(typeunder);   
    }
    public void createSubType(final PersistentMAtomicType superType, final String name) 
				throws model.WrongSubTypeAspectException, model.DoubleDefinitionException, model.CycleException, PersistenceException{
    	checkForDuplicateMAtomicTypeName(name);
    	PersistentMAtomicType atype = MAtomicType.createMAtomicType(name, superType.getAspect());
        getThis().addSubType(superType, atype);
    }
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType typeunder, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddSubTypeCommand command = model.meta.AddSubTypeCommand.createAddSubTypeCommand(now, now);
		command.setSuperType(superType);
		command.setTypeunder(typeunder);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void createSubType(final PersistentMAtomicType superType, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateSubTypeCommand command = model.meta.CreateSubTypeCommand.createCreateSubTypeCommand(name, now, now);
		command.setSuperType(superType);
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
    public void addAtomicType(final PersistentMAspect aspect, final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
    	checkForDuplicateMAtomicTypeName(name);
        getThis().getAtomicTypes().add(MAtomicType.createMAtomicType(name, aspect));
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void addAtomicType(final PersistentMAspect aspect, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddAtomicTypeCommand command = model.meta.AddAtomicTypeCommand.createAddAtomicTypeCommand(name, now, now);
		command.setAspect(aspect);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    private void checkForDuplicateMAtomicTypeName(String name) throws PersistenceException, DoubleDefinitionException{
    	if(MAtomicType.getMAtomicTypeByName(name).getLength()>0){
    		throw new DoubleDefinitionException("AtomicType-names must be unique. An AtomicType with name " + name +" is already existing.");
    	}
    }
    
    /* End of protected part that is not overridden by persistence generator */
    
}
