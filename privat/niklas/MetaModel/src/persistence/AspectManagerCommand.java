package persistence;


/* Additional import section end */

public interface AspectManagerCommand extends  Command {
    

    public void accept(model.visitor.AspectManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AspectManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AspectManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AspectManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

