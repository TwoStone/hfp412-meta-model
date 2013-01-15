package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMAbsOperation extends Anything, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public PersistentMType getSource() throws PersistenceException ;
    public void setSource(PersistentMType newValue) throws PersistenceException ;
    public PersistentMType getTarget() throws PersistenceException ;
    public void setTarget(PersistentMType newValue) throws PersistenceException ;
    public MAbsOperation_ParametersProxi getParameters() throws PersistenceException ;
    public abstract PersistentMAbsOperation getThis() throws PersistenceException ;
    
    public void accept(MAbsOperationVisitor visitor) throws PersistenceException;
    public <R> R accept(MAbsOperationReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MAbsOperationExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MAbsOperationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

