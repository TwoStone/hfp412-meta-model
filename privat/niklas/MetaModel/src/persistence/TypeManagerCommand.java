package persistence;


/* Additional import section end */

public interface TypeManagerCommand extends  Command {
    

    public void accept(model.visitor.TypeManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.TypeManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.TypeManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.TypeManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

