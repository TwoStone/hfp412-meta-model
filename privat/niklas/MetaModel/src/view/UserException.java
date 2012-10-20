
package view;




/* Additional import section end */

@SuppressWarnings("serial")
public abstract class UserException extends Exception{
    
    
    public UserException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    abstract public void accept(view.visitor.UserExceptionVisitor visitor) throws ModelException;
    abstract public <R> R accept(view.visitor.UserExceptionReturnVisitor<R>  visitor) throws ModelException;
    abstract public <E extends model.UserException>  void accept(view.visitor.UserExceptionExceptionVisitor<E> visitor) throws ModelException, E;
    abstract public <R, E extends model.UserException> R accept(view.visitor.UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    
}
