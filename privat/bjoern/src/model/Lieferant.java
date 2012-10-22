
package model;

import persistence.*;


/* Additional import section end */

public class Lieferant extends model.Rolle implements PersistentLieferant{
    
    
    public static PersistentLieferant createLieferant(PersistentAkteur rolleFuer) throws PersistenceException {
        PersistentLieferant result = ConnectionHandler.getTheConnectionHandler().theLieferantFacade
            .newLieferant();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("rolleFuer", rolleFuer);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentLieferant createLieferant(PersistentAkteur rolleFuer,PersistentLieferant This) throws PersistenceException {
        PersistentLieferant result = ConnectionHandler.getTheConnectionHandler().theLieferantFacade
            .newLieferant();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("rolleFuer", rolleFuer);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("portfolio", this.getPortfolio().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Lieferant provideCopy() throws PersistenceException{
        Lieferant result = this;
        result = new Lieferant(this.rolleFuer, 
                               this.This, 
                               this.getId());
        result.portfolio = this.portfolio.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Lieferant_PortfolioProxi portfolio;
    
    public Lieferant(PersistentAkteur rolleFuer,PersistentRolle This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAkteur)rolleFuer,(PersistentRolle)This,id);
        this.portfolio = new Lieferant_PortfolioProxi(this);        
    }
    
    static public long getTypeId() {
        return 121;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public Lieferant_PortfolioProxi getPortfolio() throws PersistenceException {
        return this.portfolio;
    }
    public PersistentLieferant getThis() throws PersistenceException {
        if(this.This == null){
            PersistentLieferant result = new LieferantProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentLieferant)this.This;
    }
    
    public void accept(model.visitor.RolleVisitor visitor) throws PersistenceException {
        visitor.handleLieferant(this);
    }
    public <R> R accept(model.visitor.RolleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferant(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.RolleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferant(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.RolleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferant(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLieferant(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLieferant(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLieferant(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLieferant(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getPortfolio().getLength());
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
        this.setThis((PersistentLieferant)This);
		if(this.equals(This)){
			this.setRolleFuer((PersistentAkteur)final$$Fields.get("rolleFuer"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
