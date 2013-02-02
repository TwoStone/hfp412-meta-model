
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
import model.visitor.UnitTypeManagerCommandExceptionVisitor;
import model.visitor.UnitTypeManagerCommandReturnExceptionVisitor;
import model.visitor.UnitTypeManagerCommandReturnVisitor;
import model.visitor.UnitTypeManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCommonDate;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentRemoveUnitTypeCommand;
import persistence.PersistentUnitTypeManager;


/* Additional import section end */

public class RemoveUnitTypeCommand extends PersistentObject implements PersistentRemoveUnitTypeCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentRemoveUnitTypeCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade.getClass(objectId);
        return (PersistentRemoveUnitTypeCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentRemoveUnitTypeCommand createRemoveUnitTypeCommand(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createRemoveUnitTypeCommand(createDate,commitDate,false);
    }
    
    public static PersistentRemoveUnitTypeCommand createRemoveUnitTypeCommand(java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentRemoveUnitTypeCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade
                .newDelayedRemoveUnitTypeCommand();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade
                .newRemoveUnitTypeCommand(-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentAbsUnitType type;
    protected Invoker invoker;
    protected PersistentUnitTypeManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public RemoveUnitTypeCommand(PersistentAbsUnitType type,Invoker invoker,PersistentUnitTypeManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.type = type;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 272;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 272) ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade
            .newRemoveUnitTypeCommand(this.getId());
        super.store();
        if(this.getType() != null){
            this.getType().store();
            ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade.typeSet(this.getId(), getType());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentAbsUnitType getType() throws PersistenceException {
        return this.type;
    }
    public void setType(PersistentAbsUnitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.type)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.type = (PersistentAbsUnitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade.typeSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentUnitTypeManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentUnitTypeManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentUnitTypeManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theRemoveUnitTypeCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleRemoveUnitTypeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveUnitTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveUnitTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveUnitTypeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleRemoveUnitTypeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveUnitTypeCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveUnitTypeCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveUnitTypeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleRemoveUnitTypeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveUnitTypeCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveUnitTypeCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveUnitTypeCommand(this);
    }
    public void accept(UnitTypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleRemoveUnitTypeCommand(this);
    }
    public <R> R accept(UnitTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRemoveUnitTypeCommand(this);
    }
    public <E extends UserException>  void accept(UnitTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRemoveUnitTypeCommand(this);
    }
    public <R, E extends UserException> R accept(UnitTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRemoveUnitTypeCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getType() == null ? 0 : 1)
            + (this.getCommandReceiver() == null ? 0 : 1));
    }
    
    
    public void execute() 
				throws PersistenceException{
        this.getCommandReceiver().removeUnitType(this.getType());
		
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
