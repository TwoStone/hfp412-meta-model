package view;

public interface ComposedMetaTypeView extends AbstractMetaTypeView {
    
    public java.util.Vector<AbstractMetaTypeView> getComponents() throws ModelException ;
    public void setComponents(java.util.Vector<AbstractMetaTypeView> newValue) throws ModelException ;
    
    public void accept(view.visitor.ComposedMetaTypeVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.ComposedMetaTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.ComposedMetaTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.ComposedMetaTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

