package persistence;

public interface PersistentAuftrag extends Anything, AbstractPersistentProxi {
    
    public PersistentKunde getAuftraggeber() throws PersistenceException ;
    public void setAuftraggeber(PersistentKunde newValue) throws PersistenceException ;
    public PersistentLieferant getAuftragnehmer() throws PersistenceException ;
    public void setAuftragnehmer(PersistentLieferant newValue) throws PersistenceException ;
    public Auftrag_PositionenProxi getPositionen() throws PersistenceException ;
    public PersistentAuftrag getThis() throws PersistenceException ;
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}
