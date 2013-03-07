
package model.meta;

import model.DBConnectionConstants;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.Command;
import persistence.CommandExecuter_CommandsProxi;
import persistence.CommitConnectionHandler;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentCommandExecuter;
import persistence.PersistentCommonDate;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;


/* Additional import section end */

public class CommandExecuter extends PersistentObject implements PersistentCommandExecuter{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCommandExecuter getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade.getClass(objectId);
        return (PersistentCommandExecuter)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCommandExecuter createCommandExecuter() throws PersistenceException{
        return createCommandExecuter(false);
    }
    
    public static PersistentCommandExecuter createCommandExecuter(boolean delayed$Persistence) throws PersistenceException {
        PersistentCommandExecuter result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
                .newDelayedCommandExecuter();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
                .newCommandExecuter(-1);
        }
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCommandExecuter createCommandExecuter(boolean delayed$Persistence,PersistentCommandExecuter This) throws PersistenceException {
        PersistentCommandExecuter result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
                .newDelayedCommandExecuter();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
                .newCommandExecuter(-1);
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
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CommandExecuter_CommandsProxi commands;
    
    public CommandExecuter(long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.commands = new CommandExecuter_CommandsProxi(this);        
    }
    
    static public long getTypeId() {
        return -193;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -193) ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
            .newCommandExecuter(this.getId());
        super.store();
        this.getCommands().store();
        
    }
    
    public CommandExecuter_CommandsProxi getCommands() throws PersistenceException {
        return this.commands;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCommandExecuter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommandExecuter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommandExecuter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommandExecuter(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public synchronized Command commandGet() 
				throws PersistenceException{
        while (!this.getCommands().iterator().hasNext()){
			try {
				this.wait();
			}catch(InterruptedException ie){
				return null;
			}
		}
		java.util.Iterator<Command> commands = this.getCommands().iterator();
		Command command = commands.next();
		return command;
    }
    public synchronized void commandPut(final Command command) 
				throws PersistenceException{
        this.getCommands().add(command);
		this.notify();
    }
    public synchronized void finishCommand(final CommitConnectionHandler handler) 
				throws PersistenceException{
        java.util.Iterator<Command> commands = this.getCommands().iterator();
		Command command = commands.next();
		commands.remove();
		((PersistentCommonDate)command).setCommitDate(new java.sql.Date(new java.util.Date().getTime()));
		handler.commit();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        this.initializeOnInstantiation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        this.start();
    }
    public void run() {
        try {
			CommitConnectionHandler handler = (CommitConnectionHandler)ConnectionHandler.getTheConnectionHandler(); 
			handler.beginWork();
			while(!Thread.currentThread().isInterrupted()){
				Command command = this.commandGet();
				handler.setCommand(command);
				if (command != null){
					try {
						handler.setInTransaction(true);
						command.execute();
						handler.setInTransaction(false);
						command.checkException();
						this.finishCommand(handler);
						command.sendResult();
					} catch (UserException ue){
						handler.rollback();
						this.finishCommand(handler);
						command.sendResult();
					} catch (PersistenceException pee){
						handler.rollback();
						this.finishCommand(handler);
						command.sendException(pee);
					}catch (Throwable t){
						handler.rollback();
						this.finishCommand(handler);
						System.out.println("CommanExecuter terminated due to fatal error!" + t.getMessage());
						t.printStackTrace();
						return;
					}
				}
			}
		}catch(PersistenceException pe){
			return;
		}
    }
    public void start() 
				throws PersistenceException{
        Thread myThread = new Thread(this, "CommandExecuter " + this.getId());
		ConnectionHandler connection = ConnectionHandler.getNewConnection(myThread);
		connection.connect(DBConnectionConstants.DataBaseName,
			DBConnectionConstants.SchemaName,
			DBConnectionConstants.UserName,
			DBConnectionConstants.Password,
			false);
		myThread.start();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
