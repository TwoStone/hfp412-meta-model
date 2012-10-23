package persistence;


/* Additional import section end */

public interface MType extends  MCTypeHierarchyHIERARCHY {
    
    public String fetchName() 
				throws PersistenceException;

    public void accept(model.visitor.MTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.MTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.MTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

