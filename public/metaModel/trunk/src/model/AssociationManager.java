
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AssociationManager extends PersistentObject implements PersistentAssociationManager{
    
    private static PersistentAssociationManager theAssociationManager = null;
    private static boolean reset$For$Test = false;
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
        return 141;
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
    
    
    public void addToHierarchy(final PersistentMAssociation association, final PersistentMAHierarchy theHierarchy) 
				throws PersistenceException{
        PersistentMAHierarchy sameHInAssoc = association.getHierarchies().findFirst(new Predcate<PersistentMAHierarchy>() {
			
			@Override
			public boolean test(PersistentMAHierarchy argument)
					throws PersistenceException {
				return argument.equals(theHierarchy);
			}
		}); 
        
        if (sameHInAssoc == null) {
        	association.getHierarchies().add(theHierarchy);
        }
        
    	//TODO think about objects (exemplar ebene);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void createHierarchy(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateHierarchyCommand command = model.meta.CreateHierarchyCommand.createCreateHierarchyCommand(name, now, now);
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
    public void addToHierarchy(final PersistentMAssociation association, final PersistentMAHierarchy theHierarchy, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddToHierarchyCommand command = model.meta.AddToHierarchyCommand.createAddToHierarchyCommand(now, now);
		command.setAssociation(association);
		command.setTheHierarchy(theHierarchy);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void createAssociation(final String name, final MType source, final MType target, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateAssociationCommand command = model.meta.CreateAssociationCommand.createCreateAssociationCommand(name, now, now);
		command.setSource(source);
		command.setTarget(target);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createAssociation(final String name, final MType source, final MType target) 
				throws model.DoubleDefinitionException, PersistenceException{
    	PersistentMAssociation sameNamedInSource = source.fetchAssociations().findFirst(new Predcate<PersistentMAssociation>() {
		
		@Override
		public boolean test(PersistentMAssociation argument)
				throws PersistenceException {
			return name.equals(argument.getName());
		}
	});
       if(sameNamedInSource != null) {
    	   throw new DoubleDefinitionException("There already existsts an Association with name " + name + " in SourceType " + source.fetchName());
       }
       
       //TODO obriges ist Quatsch: Nameclashes klären und produkttypen analysieren als quelle von assocs
       PersistentMAssociation newAssoc = MAssociation.createMAssociation(name, source, target);
       getThis().getAssociations().add(newAssoc);
    }
    public void createHierarchy(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        
    	if(MAHierarchy.getMAHierarchyByName(name).getLength() != 0) {
    		throw new DoubleDefinitionException("There already exists a Hierarchy with name " + name);
    	}
    	getThis().getHierarchies().add(MAHierarchy.createMAHierarchy(name));
    	//TODO  Check object-level for violations 
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
