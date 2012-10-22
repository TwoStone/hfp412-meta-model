package persistence;



public class AuftragProxi extends PersistentProxi implements PersistentAuftrag{
    
    public AuftragProxi(long objectId) {
        super(objectId);
    }
    public AuftragProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAuftragFacade
            .getAuftrag(this.getId());
    }
    
    public long getClassId() {
        return 124;
    }
    
    public PersistentKunde getAuftraggeber() throws PersistenceException {
        return ((PersistentAuftrag)this.getTheObject()).getAuftraggeber();
    }
    public void setAuftraggeber(PersistentKunde newValue) throws PersistenceException {
        ((PersistentAuftrag)this.getTheObject()).setAuftraggeber(newValue);
    }
    public PersistentLieferant getAuftragnehmer() throws PersistenceException {
        return ((PersistentAuftrag)this.getTheObject()).getAuftragnehmer();
    }
    public void setAuftragnehmer(PersistentLieferant newValue) throws PersistenceException {
        ((PersistentAuftrag)this.getTheObject()).setAuftragnehmer(newValue);
    }
    public Auftrag_PositionenProxi getPositionen() throws PersistenceException {
        return ((PersistentAuftrag)this.getTheObject()).getPositionen();
    }
    public PersistentAuftrag getThis() throws PersistenceException {
        return ((PersistentAuftrag)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAuftrag(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAuftrag(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAuftrag(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAuftrag(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAuftrag)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAuftrag)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAuftrag)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAuftrag)this.getTheObject()).initializeOnCreation();
    }

    
}
