
package model.abstractOperation;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.AssociationManagerProxi;
import persistence.AssociationManager_AssociationsProxi;
import persistence.AssociationManager_HierarchiesProxi;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAddAssociationCommand;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentCreateAssociationCommand;
import persistence.PersistentCreateHierarchyCommand;
import persistence.PersistentHierarchy;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentRemoveAssoFrmHierCommand;
import persistence.PersistentRemoveAssociationCommand;
import persistence.TDObserver;


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
            result.put("associations", this.getAssociations().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
            result.put("hierarchies", this.getHierarchies().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
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
        return (int) (0 
            + this.getAssociations().getLength()
            + this.getHierarchies().getLength());
    }
    
    
    public void createAssociation(final PersistentMType source, final PersistentMType target, final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        //TODO: implement method: createAssociation
        
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
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a) 
				throws model.DoubleDefinitionException, model.CycleException, PersistenceException{
        //TODO: implement method: addAssociation
        
    }
    public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a) 
				throws model.NotAvailableException, model.CycleException, PersistenceException{
        //TODO: implement method: removeAssoFrmHier
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
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
    public void removeAssociation(final PersistentAssociation a) 
				throws model.ConsistencyException, model.CycleException, PersistenceException{
        //TODO: implement method: removeAssociation
        
    }
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
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
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
    public void removeAssociation(final PersistentAssociation a, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveAssociationCommand command = model.meta.RemoveAssociationCommand.createRemoveAssociationCommand(now, now);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createHierarchy(final PersistentAssociation a, final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        //TODO: implement method: createHierarchy
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
