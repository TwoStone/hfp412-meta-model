package persistence;


/* Additional import section end */

public interface ActorManagerCommand extends  Command {
    

    public void accept(model.visitor.ActorManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.ActorManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.ActorManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.ActorManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

