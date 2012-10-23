
package model;

import persistence.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class RestrictionException extends model.UserException{
    
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            
        }
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public RestrictionException(String message) throws persistence.PersistenceException {
        super(message);        
    }
    
    static public long getTypeId() {
        return -116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(model.visitor.UserExceptionVisitor visitor) throws PersistenceException {
        visitor.handleRestrictionException(this);
    }
    public <R> R accept(model.visitor.UserExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleRestrictionException(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.UserExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleRestrictionException(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.UserExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleRestrictionException(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
