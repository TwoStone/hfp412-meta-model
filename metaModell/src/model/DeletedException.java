
package model;

import model.visitor.ConsistencyExceptionExceptionVisitor;
import model.visitor.ConsistencyExceptionReturnExceptionVisitor;
import model.visitor.ConsistencyExceptionReturnVisitor;
import model.visitor.ConsistencyExceptionVisitor;
import model.visitor.UserExceptionExceptionVisitor;
import model.visitor.UserExceptionReturnExceptionVisitor;
import model.visitor.UserExceptionReturnVisitor;
import model.visitor.UserExceptionVisitor;
import persistence.PersistenceException;
import persistence.TDObserver;


/* Additional import section end */

@SuppressWarnings("serial")
public class DeletedException extends model.ConsistencyException{
    
    
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
    
    public DeletedException(String message) throws persistence.PersistenceException {
        super(message);        
    }
    
    static public long getTypeId() {
        return -323;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(ConsistencyExceptionVisitor visitor) throws PersistenceException {
        visitor.handleDeletedException(this);
    }
    public <R> R accept(ConsistencyExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeletedException(this);
    }
    public <E extends UserException>  void accept(ConsistencyExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeletedException(this);
    }
    public <R, E extends UserException> R accept(ConsistencyExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeletedException(this);
    }
    public void accept(UserExceptionVisitor visitor) throws PersistenceException {
        visitor.handleDeletedException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeletedException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeletedException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeletedException(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
