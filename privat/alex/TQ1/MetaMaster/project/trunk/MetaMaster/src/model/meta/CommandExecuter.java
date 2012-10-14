
package model.meta;

import persistence.*;
import model.*;


/* Additional import section end */

public class CommandExecuter extends PersistentObject implements PersistentCommandExecuter{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCommandExecuter getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade.getClass(objectId);
        return (PersistentCommandExecuter)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCommandExecuter createCommandExecuter() throws PersistenceException {
        PersistentCommandExecuter result = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
            .newCommandExecuter();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCommandExecuter createCommandExecuter(PersistentCommandExecuter This) throws PersistenceException {
        PersistentCommandExecuter result = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
            .newCommandExecuter();
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
        return -113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public CommandExecuter_CommandsProxi getCommands() throws PersistenceException {
        return this.commands;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCommandExecuter(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommandExecuter(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommandExecuter(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommandExecuter(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public synchronized void finishCommand(CommitConnectionHandler handler) 
				throws PersistenceException{
        java.util.Iterator<Command> commands = this.getCommands().iterator();
		Command command = commands.next();
		commands.remove();
		((PersistentCommonDate)command).setCommitDate(new java.sql.Date(new java.util.Date().getTime()));
		handler.commit();
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
    public synchronized void commandPut(Command command) 
				throws PersistenceException{
        this.getCommands().add(command);
		this.notify();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        this.start();
    }
    public void initialize(Anything This, java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        
		if(this.equals(This)){
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
    public void initializeOnCreation() 
				throws PersistenceException{
        this.initializeOnInstantiation();
    }
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

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
