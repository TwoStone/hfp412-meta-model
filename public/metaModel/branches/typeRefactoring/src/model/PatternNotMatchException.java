
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class PatternNotMatchException extends model.UserException{
    
    
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
    
    public PatternNotMatchException(String message) throws persistence.PersistenceException {
        super(message);        
    }
    
    static public long getTypeId() {
        return -266;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws PersistenceException {
        visitor.handlePatternNotMatchException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePatternNotMatchException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePatternNotMatchException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePatternNotMatchException(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
