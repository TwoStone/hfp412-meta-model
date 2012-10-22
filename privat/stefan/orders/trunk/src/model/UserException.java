
package model;

import persistence.*;


/* Additional import section end */

@SuppressWarnings("serial")
public abstract class UserException extends Exception{
    
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = new java.util.Hashtable<String,Object>();
            result.put("?Message?", this.getMessage());
            
        }
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public UserException(String message) throws persistence.PersistenceException {
        super(message);        
    }
    
    static public long getTypeId() {
        return -120;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    abstract public void accept(model.visitor.UserExceptionVisitor visitor) throws PersistenceException;
    abstract public <R> R accept(model.visitor.UserExceptionReturnVisitor<R>  visitor) throws PersistenceException;
    abstract public <E extends model.UserException>  void accept(model.visitor.UserExceptionExceptionVisitor<E> visitor) throws PersistenceException, E;
    abstract public <R, E extends model.UserException> R accept(model.visitor.UserExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
