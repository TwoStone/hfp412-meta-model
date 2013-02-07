package model.typeSystem;

import model.ConsistencyException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.*;

/* Additional import section end */

public class ObjectManager extends PersistentObject implements PersistentObjectManager{
    
    private static PersistentObjectManager theObjectManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentObjectManager getTheObjectManager() throws PersistenceException{
        if (theObjectManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        ObjectManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theObjectManagerFacade.getTheObjectManager();
                            theObjectManager = proxi;
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
                PersistentObjectManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theObjectManager;
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
        return theObjectManager;
    }
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("objects", this.getObjects().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ObjectManager provideCopy() throws PersistenceException{
        ObjectManager result = this;
        result = new ObjectManager(this.This, 
                                   this.getId());
        result.objects = this.objects.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ObjectManager_ObjectsProxi objects;
    protected PersistentObjectManager This;
    
    public ObjectManager(PersistentObjectManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.objects = new ObjectManager_ObjectsProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 200;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public ObjectManager_ObjectsProxi getObjects() throws PersistenceException {
        return this.objects;
    }
    protected void setThis(PersistentObjectManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentObjectManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theObjectManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentObjectManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentObjectManager result = new ObjectManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentObjectManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleObjectManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleObjectManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleObjectManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleObjectManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getObjects().getLength());
    }
    
    
    public void removeType(final PersistentMObject object, final PersistentMAtomicType oldType) 
				throws model.ConsistencyException, PersistenceException{
        //TODO: implement method: removeType
        
    }
    public void replaceType(final PersistentMObject object, final PersistentMAtomicType oldType, final PersistentMAtomicType newType) 
				throws model.ConsistencyException, PersistenceException{
        //TODO: implement method: replaceType
        
    }
    public void removeType(final PersistentMObject object, final PersistentMAtomicType oldType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveTypeCommand command = model.meta.RemoveTypeCommand.createRemoveTypeCommand(now, now);
		command.setObject(object);
		command.setOldType(oldType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public PersistentMObject createMObject(final PersistentMAtomicType type, final MAtomicTypeSearchList otherTypes) 
				throws model.ConsistencyException, PersistenceException{
        //TODO: implement method: createMObject
        try{
            throw new java.lang.UnsupportedOperationException("Method \"createMObject\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void replaceType(final PersistentMObject object, final PersistentMAtomicType oldType, final PersistentMAtomicType newType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentReplaceTypeCommand command = model.meta.ReplaceTypeCommand.createReplaceTypeCommand(now, now);
		command.setObject(object);
		command.setOldType(oldType);
		command.setNewType(newType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentObjectManager)This);
		if(this.equals(This)){
		}
    }
    public void createMObject(final PersistentMAtomicType type, final MAtomicTypeSearchList otherTypes, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateMObjectCommand command = model.meta.CreateMObjectCommand.createCreateMObjectCommand(now, now);
		command.setType(type);
		java.util.Iterator<PersistentMAtomicType> otherTypesIterator = otherTypes.iterator();
		while(otherTypesIterator.hasNext()){
			command.getOtherTypes().add(otherTypesIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void addType(final PersistentMObject object, final PersistentMAtomicType newType) 
				throws model.ConsistencyException, PersistenceException{
        //TODO: implement method: addType
        
    }
    public void addType(final PersistentMObject object, final PersistentMAtomicType newType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddTypeCommand command = model.meta.AddTypeCommand.createAddTypeCommand(now, now);
		command.setObject(object);
		command.setNewType(newType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}