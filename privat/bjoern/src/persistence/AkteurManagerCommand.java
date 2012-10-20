package persistence;


/* Additional import section end */

public interface AkteurManagerCommand extends  Command {
    

    public void accept(model.visitor.AkteurManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AkteurManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AkteurManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AkteurManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

