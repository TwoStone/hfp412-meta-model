
package view;


import viewClient.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class DoubleDefinitionException extends view.UserException{
    
    public static DoubleDefinitionException fromHashtableToDoubleDefinitionException(java.util.Hashtable<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new DoubleDefinitionException(message);
    }
    
    public DoubleDefinitionException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(view.visitor.UserExceptionVisitor visitor) throws ModelException {
        visitor.handleDoubleDefinitionException(this);
    }
    public <R> R accept(view.visitor.UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDoubleDefinitionException(this);
    }
    public <E extends model.UserException>  void accept(view.visitor.UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDoubleDefinitionException(this);
    }
    public <R, E extends model.UserException> R accept(view.visitor.UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDoubleDefinitionException(this);
    }
    
    
}
