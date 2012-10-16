
package view;


import viewClient.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class CycleException extends view.UserException{
    
    public static CycleException fromHashtableToCycleException(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new CycleException(message);
    }
    
    public CycleException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(view.visitor.UserExceptionVisitor visitor) throws ModelException {
        visitor.handleCycleException(this);
    }
    public <R> R accept(view.visitor.UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCycleException(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCycleException(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCycleException(this);
    }
    
    
}
