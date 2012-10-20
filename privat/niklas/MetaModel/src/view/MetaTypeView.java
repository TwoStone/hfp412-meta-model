package view;

public interface MetaTypeView extends CONCNamedEntityView, AbstractMetaTypeView {
    
    public java.util.Vector<MetaTypeView> getSubtypes() throws ModelException ;
    public void setSubtypes(java.util.Vector<MetaTypeView> newValue) throws ModelException ;
    public MetaAspectView getMyAspect() throws ModelException ;
    public void setMyAspect(MetaAspectView newValue) throws ModelException ;
    public NamedEntityView getMyCONCNamedEntity() throws ModelException ;
    public void setMyCONCNamedEntity(NamedEntityView newValue) throws ModelException ;
    
    public void accept(view.visitor.AbstractMetaTypeVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.AnythingVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(view.visitor.NamedEntityVisitor visitor) throws ModelException;
    public <R> R accept(view.visitor.NamedEntityReturnVisitor<R>  visitor) throws ModelException;
    public <E extends model.UserException>  void accept(view.visitor.NamedEntityExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends model.UserException> R accept(view.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

