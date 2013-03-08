
package model.meta;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.CommandExceptionVisitor;
import model.visitor.CommandReturnExceptionVisitor;
import model.visitor.CommandReturnVisitor;
import model.visitor.CommandVisitor;
import model.visitor.CommonDateExceptionVisitor;
import model.visitor.CommonDateReturnExceptionVisitor;
import model.visitor.CommonDateReturnVisitor;
import model.visitor.CommonDateVisitor;
import model.visitor.EnumValueManagerCommandExceptionVisitor;
import model.visitor.EnumValueManagerCommandReturnExceptionVisitor;
import model.visitor.EnumValueManagerCommandReturnVisitor;
import model.visitor.EnumValueManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentCommonDate;
import persistence.PersistentDeleteEnumValueCommand;
import persistence.PersistentEnumValueManager;
import persistence.PersistentMEnumValue;
import persistence.PersistentObject;
import persistence.PersistentProxi;


/* Additional import section end */

public class DeleteEnumValueCommand extends PersistentObject implements PersistentDeleteEnumValueCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDeleteEnumValueCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade.getClass(objectId);
        return (PersistentDeleteEnumValueCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentDeleteEnumValueCommand createDeleteEnumValueCommand(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createDeleteEnumValueCommand(createDate,commitDate,false);
    }
    
    public static PersistentDeleteEnumValueCommand createDeleteEnumValueCommand(java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentDeleteEnumValueCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade
                .newDelayedDeleteEnumValueCommand();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade
                .newDeleteEnumValueCommand(-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentMEnumValue enumValue;
    protected Invoker invoker;
    protected PersistentEnumValueManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public DeleteEnumValueCommand(PersistentMEnumValue enumValue,Invoker invoker,PersistentEnumValueManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.enumValue = enumValue;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 355;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 355) ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade
            .newDeleteEnumValueCommand(this.getId());
        super.store();
        if(this.getEnumValue() != null){
            this.getEnumValue().store();
            ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade.enumValueSet(this.getId(), getEnumValue());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentMEnumValue getEnumValue() throws PersistenceException {
        return this.enumValue;
    }
    public void setEnumValue(PersistentMEnumValue newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.enumValue)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.enumValue = (PersistentMEnumValue)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade.enumValueSet(this.getId(), newValue);
        }
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
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentEnumValueManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentEnumValueManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentEnumValueManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
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
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDeleteEnumValueCommandFacade.myCommonDateSet(this.getId(), newValue);
        }
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
        visitor.handleDeleteEnumValueCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeleteEnumValueCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeleteEnumValueCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeleteEnumValueCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDeleteEnumValueCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeleteEnumValueCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeleteEnumValueCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeleteEnumValueCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleDeleteEnumValueCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeleteEnumValueCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeleteEnumValueCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeleteEnumValueCommand(this);
    }
    public void accept(EnumValueManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleDeleteEnumValueCommand(this);
    }
    public <R> R accept(EnumValueManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeleteEnumValueCommand(this);
    }
    public <E extends UserException>  void accept(EnumValueManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeleteEnumValueCommand(this);
    }
    public <R, E extends UserException> R accept(EnumValueManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeleteEnumValueCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getEnumValue() != null) return 1;
        if (this.getCommandReceiver() != null) return 1;
        return 0;
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void execute() 
				throws PersistenceException{
        try{
			this.getCommandReceiver().deleteEnumValue(this.getEnumValue());
		}
		catch(model.ConsistencyException e){
			this.commandException = e;
		}
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
