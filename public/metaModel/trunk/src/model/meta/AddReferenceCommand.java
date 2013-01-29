
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class AddReferenceCommand extends PersistentObject implements PersistentAddReferenceCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAddReferenceCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.getClass(objectId);
        return (PersistentAddReferenceCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAddReferenceCommand createAddReferenceCommand(long exponent,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createAddReferenceCommand(exponent,createDate,commitDate,false);
    }
    
    public static PersistentAddReferenceCommand createAddReferenceCommand(long exponent,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentAddReferenceCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade
                .newDelayedAddReferenceCommand(exponent);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade
                .newAddReferenceCommand(exponent,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentCompUnit compUnit;
    protected PersistentUnit unit;
    protected long exponent;
    protected Invoker invoker;
    protected PersistentUnitTypeManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public AddReferenceCommand(PersistentCompUnit compUnit,PersistentUnit unit,long exponent,Invoker invoker,PersistentUnitTypeManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.compUnit = compUnit;
        this.unit = unit;
        this.exponent = exponent;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 259;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 259) ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade
            .newAddReferenceCommand(exponent,this.getId());
        super.store();
        if(this.getCompUnit() != null){
            this.getCompUnit().store();
            ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.compUnitSet(this.getId(), getCompUnit());
        }
        if(this.getUnit() != null){
            this.getUnit().store();
            ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.unitSet(this.getId(), getUnit());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentCompUnit getCompUnit() throws PersistenceException {
        return this.compUnit;
    }
    public void setCompUnit(PersistentCompUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.compUnit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.compUnit = (PersistentCompUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.compUnitSet(this.getId(), newValue);
        }
    }
    public PersistentUnit getUnit() throws PersistenceException {
        return this.unit;
    }
    public void setUnit(PersistentUnit newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.unit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.unit = (PersistentUnit)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.unitSet(this.getId(), newValue);
        }
    }
    public long getExponent() throws PersistenceException {
        return this.exponent;
    }
    public void setExponent(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.exponentSet(this.getId(), newValue);
        this.exponent = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.invokerSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleAddReferenceCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddReferenceCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddReferenceCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddReferenceCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddReferenceCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddReferenceCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddReferenceCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddReferenceCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddReferenceCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddReferenceCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddReferenceCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddReferenceCommand(this);
    }
    public void accept(UnitTypeManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddReferenceCommand(this);
    }
    public <R> R accept(UnitTypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddReferenceCommand(this);
    }
    public <E extends UserException>  void accept(UnitTypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddReferenceCommand(this);
    }
    public <R, E extends UserException> R accept(UnitTypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddReferenceCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getCompUnit() == null ? 0 : 1)
            + (this.getUnit() == null ? 0 : 1)
            + (this.getCommandReceiver() == null ? 0 : 1));
    }
    
    
    public void execute() 
				throws PersistenceException{
        try{
			this.getCommandReceiver().addReference(this.getCompUnit(), this.getUnit(), this.getExponent());
		}
		catch(model.DoubleDefinitionException e){
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
