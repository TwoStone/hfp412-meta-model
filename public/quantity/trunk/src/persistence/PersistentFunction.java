package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentFunction extends Anything, AbstractPersistentProxi {
    
    public common.Fraction getFactor() throws PersistenceException ;
    public void setFactor(common.Fraction newValue) throws PersistenceException ;
    public common.Fraction getConstant() throws PersistenceException ;
    public void setConstant(common.Fraction newValue) throws PersistenceException ;
    public PersistentFunction getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public common.Fraction executeInverse(final common.Fraction amount) 
				throws PersistenceException;
    public common.Fraction execute(final common.Fraction amount) 
				throws PersistenceException;

}

