package persistence;


/* Additional import section end */

public interface TransactionManagerCommand extends  Command {
    

    public void accept(model.visitor.TransactionManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.TransactionManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.TransactionManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.TransactionManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

