
package model;

import persistence.*;


/* Additional import section end */

public class Auftrag extends PersistentObject implements PersistentAuftrag{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAuftrag getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAuftragFacade.getClass(objectId);
        return (PersistentAuftrag)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAuftrag createAuftrag() throws PersistenceException {
        PersistentAuftrag result = ConnectionHandler.getTheConnectionHandler().theAuftragFacade
            .newAuftrag();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentAuftrag createAuftrag(PersistentAuftrag This) throws PersistenceException {
        PersistentAuftrag result = ConnectionHandler.getTheConnectionHandler().theAuftragFacade
            .newAuftrag();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot auftraggeber = (AbstractPersistentRoot)this.getAuftraggeber();
            if (auftraggeber != null) {
                result.put("auftraggeber", auftraggeber.createProxiInformation());
                if(depth > 1) {
                    auftraggeber.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && auftraggeber.hasEssentialFields())auftraggeber.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot auftragnehmer = (AbstractPersistentRoot)this.getAuftragnehmer();
            if (auftragnehmer != null) {
                result.put("auftragnehmer", auftragnehmer.createProxiInformation());
                if(depth > 1) {
                    auftragnehmer.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && auftragnehmer.hasEssentialFields())auftragnehmer.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("positionen", this.getPositionen().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Auftrag provideCopy() throws PersistenceException{
        Auftrag result = this;
        result = new Auftrag(this.auftraggeber, 
                             this.auftragnehmer, 
                             this.This, 
                             this.getId());
        result.positionen = this.positionen.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentKunde auftraggeber;
    protected PersistentLieferant auftragnehmer;
    protected Auftrag_PositionenProxi positionen;
    protected PersistentAuftrag This;
    
    public Auftrag(PersistentKunde auftraggeber,PersistentLieferant auftragnehmer,PersistentAuftrag This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.auftraggeber = auftraggeber;
        this.auftragnehmer = auftragnehmer;
        this.positionen = new Auftrag_PositionenProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 124;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentKunde getAuftraggeber() throws PersistenceException {
        return this.auftraggeber;
    }
    public void setAuftraggeber(PersistentKunde newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.auftraggeber)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.auftraggeber = (PersistentKunde)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theAuftragFacade.auftraggeberSet(this.getId(), newValue);
    }
    public PersistentLieferant getAuftragnehmer() throws PersistenceException {
        return this.auftragnehmer;
    }
    public void setAuftragnehmer(PersistentLieferant newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.auftragnehmer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.auftragnehmer = (PersistentLieferant)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theAuftragFacade.auftragnehmerSet(this.getId(), newValue);
    }
    public Auftrag_PositionenProxi getPositionen() throws PersistenceException {
        return this.positionen;
    }
    protected void setThis(PersistentAuftrag newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAuftrag)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theAuftragFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentAuftrag getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAuftrag result = new AuftragProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAuftrag)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getAuftraggeber() == null ? 0 : 1)
            + (this.getAuftragnehmer() == null ? 0 : 1)
            + this.getPositionen().getLength());
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAuftrag)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
