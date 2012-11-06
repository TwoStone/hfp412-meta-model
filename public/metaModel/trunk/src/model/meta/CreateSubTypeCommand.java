
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class CreateSubTypeCommand extends PersistentObject implements PersistentCreateSubTypeCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateSubTypeCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateSubTypeCommandFacade.getClass(objectId);
        return (PersistentCreateSubTypeCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateSubTypeCommand createCreateSubTypeCommand(String name,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateSubTypeCommand result = ConnectionHandler.getTheConnectionHandler().theCreateSubTypeCommandFacade
            .newCreateSubTypeCommand(name);
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentMAtomicType superType;
    protected String name;
    protected Invoker invoker;
    protected PersistentTypeManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateSubTypeCommand(PersistentMAtomicType superType,String name,Invoker invoker,PersistentTypeManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.superType = superType;
        this.name = name;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 135;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentMAtomicType getSuperType() throws PersistenceException {
        return this.superType;
    }
    public void setSuperType(PersistentMAtomicType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.superType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.superType = (PersistentMAtomicType)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theCreateSubTypeCommandFacade.superTypeSet(this.getId(), newValue);
    }
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        ConnectionHandler.getTheConnectionHandler().theCreateSubTypeCommandFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public Invoker getInvoker() throws PersistenceException {
        return this.invoker;
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.invoker)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.invoker = (Invoker)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theCreateSubTypeCommandFacade.invokerSet(this.getId(), newValue);
    }
    public PersistentTypeManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentTypeManager)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theCreateSubTypeCommandFacade.commandReceiverSet(this.getId(), newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return this.myCommonDate;
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.myCommonDate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theCreateSubTypeCommandFacade.myCommonDateSet(this.getId(), newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return this.getMyCommonDate().getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        this.getMyCommonDate().setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return this.getMyCommonDate().getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        this.getMyCommonDate().setCommitDate(newValue);
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCommonDate().delete$Me();
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateSubTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateSubTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateSubTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public void accept(TypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateSubTypeCommand(this);
    }
    public <R> R accept(TypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public <E extends UserException>  void accept(TypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateSubTypeCommand(this);
    }
    public <R, E extends UserException> R accept(TypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateSubTypeCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getSuperType() == null ? 0 : 1)
            + (this.getCommandReceiver() == null ? 0 : 1));
    }
    
    
    public void execute() 
				throws PersistenceException{
        try{
			this.getCommandReceiver().createSubType(this.getSuperType(), this.getName());
		}
		catch(model.WrongSubTypeAspectException e){
			this.commandException = e;
		}
		catch(model.DoubleDefinitionException e){
			this.commandException = e;
		}
		catch(model.CycleException e){
			this.commandException = e;
		}
    }
    public void checkException() 
				throws UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
